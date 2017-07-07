package inc.alc.polish.dtos.out;

import inc.alc.polish.dtos.User;

public class StartGame extends AbstractMessage {
    private String type = "startGame";
    private String user;

    public StartGame(User user) {
        this.user = user.getName();
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
}
