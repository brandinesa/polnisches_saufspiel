package inc.alc.polish.messages;

public class NewField {
    private String user;
    private int oldField;
    private int newField;

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

    public int getNewField() {
        return newField;
    }

    public void setNewField(int newField) {
        this.newField = newField;
    }
}
