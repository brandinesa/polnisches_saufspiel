package inc.alc.polish.dtos.out;

public class DrinkMessage extends AbstractMessage {
    private String type = "drink";
    private String target;

    public DrinkMessage(String target) {
        this.target = target;
    }

    @Override
    public String getType() { return type; }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
