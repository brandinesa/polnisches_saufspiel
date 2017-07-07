package inc.alc.polish;

import inc.alc.polish.data.Fields;
import inc.alc.polish.dtos.User;
import inc.alc.polish.dtos.Field;
import inc.alc.polish.messages.Message;
import inc.alc.polish.messages.Move;
import inc.alc.polish.messages.MoveMessage;
import inc.alc.polish.messages.NewField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class GameController {
    public static final String TOPIC = "/topic/game";
    @Autowired
    private Fields fields;
    @Autowired
    private SimpMessagingTemplate messageQueue;

    public void broadcast(Object message) {
        messageQueue.convertAndSend(GameController.TOPIC, message);
    }

    @MessageMapping("/newUser")
    @SendTo(TOPIC)
    public void addUser(User user) throws Exception {
        if (user != null) {
            String name = user.getName();
            if (name != null && name.length() > 0) {
                broadcast(new Message("newUser", name + " hat das Spiel begonnen!"));
            }
        }
    }

    @MessageMapping("/dice")
    @SendTo(TOPIC)
    public void dice(User user) throws Exception {
        if (user != null) {
            String name = user.getName();
            if (name != null && name.length() > 0) {
                int nr = new Random().nextInt(6) + 1;
                broadcast(new Message("dice", name + " hat eine " + nr + " gewürfelt!"));
            }
        }
    }

    @MessageMapping("/newField")
    @SendTo(TOPIC)
    public void newField(NewField newField) throws Exception {
        if (newField != null) {
            String msg = newField.getUser() + " hat von " + newField.getOldField()
                    + " auf das Feld " + newField.getNewField() + " gewechselt: \n";
            msg += fields.getFields().get(newField.getNewField()).getText();
            broadcast(new Message("newField", msg));
        }
    }

    @MessageMapping("/move")
    @SendTo(TOPIC)
    public void move(Move move) throws Exception {
        if (move != null) {
            Field f = fields.getFields().get(move.getCurrentField());
            Field next;
            int dice = -1;
            String msg = move.getUser();

            if (f.getNextField() >= 0) {
                next = fields.getFields().get(f.getNextField());
            } else {
                dice = new Random().nextInt(6) + 1;
                int currentField = move.getCurrentField();

                if (dice + currentField > 70) {
                    dice = 70 - currentField;
                }

                next = fields.getFields().get(move.getCurrentField() + dice);
                msg += " hat eine " + dice + " gewürfelt und ";
            }
            msg += " befindet sich nun auf dem Feld " + next.getNumber() + ": " + next.getText();

            broadcast(new MoveMessage("move", msg, next.getNumber(), next.getNextField() >= 0));
        }
    }
}
