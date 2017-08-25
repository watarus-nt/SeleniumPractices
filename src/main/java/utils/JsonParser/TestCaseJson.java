package utils.JsonParser;

public class TestCaseJson {
    private String name;
    private TestStepJson[] step;

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

    public TestStepJson[] getStep() {
        return step;
    }

    public void setStep(TestStepJson[] step) {
        this.step = step;
    }
}
