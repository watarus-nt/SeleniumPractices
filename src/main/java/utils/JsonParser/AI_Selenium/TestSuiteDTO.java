package utils.JsonParser.AI_Selenium;

public class TestSuiteDTO {
    private String name;

    private TestCaseDTO[] testcase;

    @Override
    public String toString() {
        return "TestSuite name: " + name + "\n"
                + testcase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestCaseDTO[] getTestcase() {
        return testcase;
    }

    public void setTestcase(TestCaseDTO[] testcase) {
        this.testcase = testcase;
    }
}
