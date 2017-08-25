package utils.JsonParser;

public class TestStepJson {
    private String name;
    private String action;
    private LocateElementJson locateElement;
    private String texttoWrite;

    @Override
    public String toString() {
        return "TestStep name: " + name + "\n"
                + "Action name: " + action + "\n"
                + locateElement + "\n"
                + texttoWrite;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocateElementJson getLocateElement() {
        return locateElement;
    }

    public void setLocateElement(LocateElementJson locateElement) {
        this.locateElement = locateElement;
    }

    public String getTexttoWrite() {
        return texttoWrite;
    }

    public void setTexttoWrite(String texttoWrite) {
        this.texttoWrite = texttoWrite;
    }
}
