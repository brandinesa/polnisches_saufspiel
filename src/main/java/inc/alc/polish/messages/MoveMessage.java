package inc.alc.polish.messages;

public class MoveMessage extends Message {
    private int currentField;
    private boolean move;

    public MoveMessage(String type, String message, int currentField, boolean move) {
        super(type, message);
        this.currentField = currentField;
        this.move = move;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public int getCurrentField() {
        return currentField;
    }

    public void setCurrentField(int currentField) {
        this.currentField = currentField;
    }
}
