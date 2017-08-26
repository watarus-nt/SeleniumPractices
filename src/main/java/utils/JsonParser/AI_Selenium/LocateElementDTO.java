package utils.JsonParser.AI_Selenium;

public class LocateElementDTO {
    private String by;
    private String value;

    @Override
    public String toString() {
        return "By: " + by + "\n"
                + "Value: " + value;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
