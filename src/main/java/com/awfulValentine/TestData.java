package com.awfulValentine;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

    final private static Map<String, String> enviromentList;
    private static Faker faker = new Faker(new Locale("en"));

    static {
        enviromentList = new HashMap<String, String>();
        enviromentList.put("test", "http://awful-valentine.com");
        enviromentList.put("staging", "http://awful-valentine.com");
        enviromentList.put("production", "http://awful-valentine.com");
    }

    public static String getFullName() {
        return faker.name().fullName();
    }


    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getWebsite() {
        return faker.internet().url();
    }

    public static String getRating() {
        return String.valueOf(faker.number().numberBetween(1, 5));
    }

    public static String getBuzzword() {
        //Using this combo since java implementation does not have a buzz word generator
        return faker.name().firstName() + " " + faker.lorem().sentence(20);
    }

    public static String getEnviroment() {
        Map<String, String> env = System.getenv();

        if (env.keySet().contains("enviroment")) {
            return env.get("enviroment");
        } else {
            return "test";
        }
    }


    public static String getBaseUrl() {
        return enviromentList.get(getEnviroment());
    }

    public static Map<String, Object> getProductFixtures() {
        return YAMLFixtures.parseYaml();
    }

    public static Map<String, Object> getFixture(String fixture) {
        return (Map<String, Object>) getProductFixtures().get(fixture);

    }

    public static String getFixtureVariable(String fixture, String variable) {
        String result = "";
        try {
            result = (String) getFixture(fixture).get(variable);
        } catch (Exception ex) {
            result = getFixture(fixture).get(variable).toString();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getFixtureVariable("fixture_1", "name"));
    }

}
