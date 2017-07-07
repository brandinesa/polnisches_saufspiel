package inc.alc.polish.dtos.out;

import inc.alc.polish.dtos.User;
import inc.alc.polish.dtos.Field;

public class MoveMesssage extends AbstractMessage {
    private String type = "move";
    private String user;
    private Field newField;

    @Override
    public String getType() { return type; }

    public MoveMesssage(User user, Field newField) {
        this.user = user.getName();
        this.newField = newField;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Field getNewField() {
        return newField;
    }

    public void setNewField(Field newField) {
        this.newField = newField;
    }
}
