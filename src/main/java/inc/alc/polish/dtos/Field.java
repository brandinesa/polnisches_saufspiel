package inc.alc.polish.dtos;

public class Field {
    private static int id = 0;

    private int number;
    private String text;
    private int nextField;

    public Field(String text) {
        this.number = id++;
        this.text = text;
        this.nextField = -1;
    }

    public Field(String text, int nextField) {
        this(text);
        this.nextField = nextField;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Field.id = id;
    }

    public int getNextField() {
        return nextField;
    }

    public void setNextField(int nextField) {
        this.nextField = nextField;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
