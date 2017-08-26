package utils.JsonParser.AI_Selenium;

public class TestCaseDTO {
    private String name;
    private TestStepDTO[] step;

    @Override
    public String toString() {
        return "TestCase name: " + name + "\n"
                + step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestStepDTO[] getStep() {
        return step;
    }

    public void setStep(TestStepDTO[] step) {
        this.step = step;
    }
}
