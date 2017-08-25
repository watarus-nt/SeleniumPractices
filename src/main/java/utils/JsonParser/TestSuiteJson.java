package utils.JsonParser;

public class TestSuiteJson {
    private String name;

    private TestCaseJson[] testcase;

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

    public TestCaseJson[] getTestcase() {
        return testcase;
    }

    public void setTestcase(TestCaseJson[] testcase) {
        this.testcase = testcase;
    }
}
