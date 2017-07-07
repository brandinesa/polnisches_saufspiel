package inc.alc.polish.dtos.out;

import inc.alc.polish.dtos.User;

public class NewUser extends AbstractMessage {
    private String type = "newUser";
    private String user;
    private String field;

    public NewUser(User user, String field) {
        this.user = user.getName();
        this.field = field;
    }

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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
