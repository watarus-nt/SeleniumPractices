package utils.DataGenerator;

import com.github.javafaker.Faker;

public class FakerExamples {


    public static void main(String[] args) {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            System.out.println(faker.name().firstName() + " " + faker.lorem().sentence());
            System.out.println(faker.ancient().god());
            System.out.println(faker.ancient().hero());
            System.out.println(faker.commerce().price());


            String fullName = faker.name().fullName(); // Miss Samanta Schmidt
            String[] names = fullName.split(" ");
            String lastName = names[names.length - 1];
            String firstName = names[names.length - 2];

            String streetAddress = faker.address().streetAddress();


            System.out.println("Full Name: " + fullName);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Stress Address: " + streetAddress);
            System.out.println("-----------------------------------");
        }
    }
}
