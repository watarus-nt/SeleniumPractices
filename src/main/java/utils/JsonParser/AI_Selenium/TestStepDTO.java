package utils.JsonParser.AI_Selenium;

public class TestStepDTO {
    private String name;
    private String action;
    private LocateElementDTO locateElement;
    private String thirdPara;

    @Override
    public String toString() {
        return "TestStep name: " + name + "\n"
                + "Action name: " + action + "\n"
                + locateElement + "\n"
                + thirdPara;

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

    public LocateElementDTO getLocateElement() {
        return locateElement;
    }

    public void setLocateElement(LocateElementDTO locateElement) {
        this.locateElement = locateElement;
    }

    public String getThirdPara() {
        return thirdPara;
    }

    public void setThirdPara(String thirdPara) {
        this.thirdPara = thirdPara;
    }
}
