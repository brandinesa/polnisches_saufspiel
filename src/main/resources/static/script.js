var stompClient = null;
var user = {};
var currentField = 0;

function initConnect() {
    disconnect();

    $("#errorMsg").addClass("hidden");
    $("#content").load("connect.html");
}

function connect() {
    $("#errorMsg").addClass("hidden");

    var name = $("#name").val();

    if (name.length === 0) {
        $("#errorMsg").html("Kein Spielername!");
        $("#errorMsg").removeClass("hidden");
    } else {
        //connect
        user = { "name": name };

        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/game', function(message){
                handleMessage(JSON.parse(message.body));
            });
            stompClient.send("/app/newUser", {}, JSON.stringify(user));
        });

        initGameView(user);
    }
}

function initGameView(user) {
    $("#content").load("game.html", function(responseTxt, statusTxt, xhr) {
        var msg = "Du befindest dich am Start. Viel Glück!";
        if (user.name.toLowerCase() === "andi") {
            msg = "Willkommen. Bevor das Spiel startet, trinke 10. Viel Glück!"
        }
        gameLog(msg);
    });
}

function gameLog(message) {
    message = "<b>" + new Date().toISOString() + "</b>: " + message;
    $("#logOutput").prepend("<p>" + message + "</p>");
}

function disconnect() {
    user = {};
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function startGame() {
    if (stompClient === null) {
        alert("Du bist noch nicht eingeloggt!");
    } else {
        //TODO really start?
        stompClient.send("/app/start", {}, JSON.stringify(user));
    }
}

function resetGame() {
    if (stompClient === null) {
        alert("Du bist noch nicht eingeloggt!");
    } else {
        //TODO really reset?
        stompClient.send("/app/reset", {}, {});
    }
}

function vibrate() {
    navigator.vibrate = navigator.vibrate || navigator.webkitVibrate || navigator.mozVibrate || navigator.msVibrate;

    if (navigator.vibrate) {
        navigator.vibrate(500);
    }
}

function handleMessage(message) {
    if (message.type === "newUser") {
        if (message.message.lastIndexOf(user.name, 0) != 0) {
            gameLog(message.message);
        }
    } else if (message.type === "move" && message.message.lastIndexOf(user.name, 0) === 0) {
        currentField = message.currentField;
        gameLog(message.message);

        if (message.move) {
            move();
        }
    } else {
        gameLog(message.message);
    }
}

function dice() {
    stompClient.send("/app/dice", {}, JSON.stringify(user));
}

function move() {
    stompClient.send("/app/move", {}, JSON.stringify({
        "user": user.name,
        "currentField": currentField
    }));
}

function showFieldDialog() {
    BootstrapDialog.show({
        title: "Aktuelle Position",
        message: $('<input type="text" class="form-control" placeholder="Aktuelles Feld" value="'
            + currentField +'" id="currentFieldTextbox" />'),
        buttons: [
            {
                label: 'Speichern',
                cssClass: 'btn-primary',
                action: function(dialogItself) {
                    var val = $("#currentFieldTextbox").val();
                    if(val.length > 0) {
                        if (!isNaN(val)) {
                            var intVal = parseInt(val);
                            if (intVal >= 0 && intVal <= 70) {
                                stompClient.send("/app/newField", {}, JSON.stringify({
                                    "user": user.name,
                                    "oldField": currentField,
                                    "newField": intVal
                                }));
                                currentField = intVal;
                                dialogItself.close();
                            } else {
                                $("#currentFieldTextbox").val(currentField);
                            }
                        }
                    }
                }
            }, {
                label: 'Schließen',
                cssClass: 'btn-default',
                action: function(dialogItself) {
                    dialogItself.close();
                }
            }
        ]
    });
}

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function showGreeting(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}
