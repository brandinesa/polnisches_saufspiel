package inc.alc.polish.dtos.out;

import inc.alc.polish.dtos.User;
import inc.alc.polish.dtos.Field;

public class DiceMessage extends AbstractMessage {
    private String type = "dice";
    private String user;
    private int oldField;
    private Field newField;
    private int dice;

    public DiceMessage(User user, int oldField, Field newField) {
        this.user = user.getName();
        this.oldField = oldField;
        this.newField = newField;
        dice = newField.getNumber() - oldField;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getOldField() {
        return oldField;
    }

    public void setOldField(int oldField) {
        this.oldField = oldField;
    }

    public Field getNewField() {
        return newField;
    }

    public void setNewField(Field newField) {
        this.newField = newField;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
}
