package inc.alc.polish.data;

import inc.alc.polish.dtos.Field;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fields {
    private List<Field> fields;

    public Fields() {
        initFields();
    }

    private void initFields() {
        fields = new ArrayList<>();
        fields.add(new Field("START")); //0
        fields.add(new Field("Alle trinken")); //1
        fields.add(new Field("Du trinkst und deine beiden Nebensitzer"));
        fields.add(new Field("Gehe 2 Felder zurück", 1));
        fields.add(new Field("Alle singen ein Lied, wer nicht mitsingt trinkt 2"));
        fields.add(new Field("Trinke und gehe auf Feld 32", 32)); //5
        fields.add(new Field("Endlich kannst du wieder trinken"));
        fields.add(new Field("Alle außer dir trinken"));
        fields.add(new Field("8"));
        fields.add(new Field("Bestimme einen der trinken soll"));
        fields.add(new Field("Alle Typen trinken")); //10
        fields.add(new Field("Dein rechter Nebensitzer trinkt"));
        fields.add(new Field("Einer deiner Wahl trinkt 2 mal"));
        fields.add(new Field("Trink soviel du würfelst und gehe auf START", 0));
        fields.add(new Field("Es trinken die Personen, die am nächsten START/ZIEL sind"));
        fields.add(new Field("Das Mädchen deiner Wahl trinkt")); //15
        fields.add(new Field("Du trinkst und der erste der lacht trinkt 2"));
        fields.add(new Field("Trinke und setze eine Runde aus"));
        fields.add(new Field("18"));
        fields.add(new Field("Alle Mädels trinken"));
        fields.add(new Field("Trink und würfle noch einmal")); //20
        fields.add(new Field("Gehe zurück auf START", 0));
        fields.add(new Field("Trink soviel wie du gewürfelt hast"));
        fields.add(new Field("Alle trinken, die einen Bruder haben"));
        fields.add(new Field("Trink 3 oder gehe 4 Felder zurück"));
        fields.add(new Field("Endlich kannst du trinken")); //25
        fields.add(new Field("Es trinken die, die ein gerades Alter haben"));
        fields.add(new Field("Es trinken die, die ein ungerades Alter haben"));
        fields.add(new Field("28"));
        fields.add(new Field("Gehe auf Feld 9 und trinke 5", 9));
        fields.add(new Field("Jeder, der keine 10 Euro hat, trinkt")); //30
        fields.add(new Field("Würfel, bei einer geraden Zahl trinkst du, sonst der Rest"));
        fields.add(new Field("Trinke 3 und küsse eine Person des anderen Geschlechts oder trinke 6"));
        fields.add(new Field("Trinke und ziehe ein Kleidungsstück aus"));
        fields.add(new Field("Trinke und bestimme eine Person, die aufs Feld 6 zurück geht"));
        fields.add(new Field("Gehe auf das Feld 6", 6)); //35
        fields.add(new Field("Es trinkt der, der am nächsten dem Start ist. Gehe dann dahin", 0));
        fields.add(new Field("Alle, die vor dir sind trinken"));
        fields.add(new Field("38"));
        fields.add(new Field("Trinke und ziehe ein Kleidungsstück aus"));
        fields.add(new Field("Trink, soviel du würfelst")); //40
        fields.add(new Field("Es trinkt der, der am wenigsten Münzen dabei hat"));
        fields.add(new Field("Alle würfeln. Alle mit einer 1 trinken"));
        fields.add(new Field("Alle, die eine Schwester haben trinken"));
        fields.add(new Field("Trinke und dein linker Nebensitzer entscheidet, wer noch trinkt"));
        fields.add(new Field("Gehe 2 Felder vor und trinke", 47)); //45
        fields.add(new Field("Wirf eine Münze, bei Kopf trinken alle, bei Zahl nur du"));
        fields.add(new Field("Küsse jemanden deiner Wahl und trinke 2 oder trinke 4"));
        fields.add(new Field("48")); //TODO
        fields.add(new Field("Gehe auf das Feld 28 und würfel noch einmal", 28));
        fields.add(new Field("Trinke und ziehe ein Kleidungsstück aus")); //50
        fields.add(new Field("Bestimme 2 Personen die sich küssen und 3 trinken oder jeweils 6 trinken"));
        fields.add(new Field("Alle unter 21 trinken 2"));
        fields.add(new Field("Deine beiden Nebensitzer trinken"));
        fields.add(new Field("Alle trinken"));
        fields.add(new Field("Alle die eine 6 würfeln trinken")); //55
        fields.add(new Field("Trink und gehe aufs Feld 18 zurück", 18));
        fields.add(new Field("Alle, die eine 8 im Geburtsjahr haben, trinken"));
        fields.add(new Field("58"));
        fields.add(new Field("Alle würfeln. Alle die eine 1 würfeln trinken und gehen auf den Start"));
        fields.add(new Field("Alle Singen ein Lied. Wer nicht mitsingt trinkt 5")); //60
        fields.add(new Field("Alle trinken, die keine Brille/Kontaktlinsen tragen"));
        fields.add(new Field("Würfel 3 mal und gehe dann die Anzahl der Augen zurück"));
        fields.add(new Field("Jeder, der eine Jeans Hose trägt, trinkt"));
        fields.add(new Field("Alle trinken"));
        fields.add(new Field("Alle gehen 1 Feld zurück. 2 Minuten Spielpause")); //65
        fields.add(new Field("Gehe auf das Feld 32", 32));
        fields.add(new Field("Alle trinken 3 und ziehen 1 Kleidungsstück aus"));
        fields.add(new Field("68"));
        fields.add(new Field("Würfel 5 mal und gehe die Anzahl der Augen zurück"));
        fields.add(new Field("Trinke und gehe auf START (0) zurück", 0)); //70
        fields.add(new Field("ZIEL - du hast geschummelt! Trinke 10 und gehe auf START", 0));
    }

    public List<Field> getFields() {
        return fields;
    }
}
