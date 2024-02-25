package co.huru.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class DataGenerator {

    public static String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder();

        String[] prefixes = {"50", "52", "54", "55", "56", "58"};
        String prefix = prefixes[random.nextInt(prefixes.length)];
        mobileNumber.append(prefix);

        for (int i = 0; i < 7; i++) {
            mobileNumber.append(random.nextInt(10));
        }

        return mobileNumber.toString();
    }

    public static String generateRandomEmail() {

        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};

        Random random = new Random();
        String randomFirstName = "aut" + generateRandomString(3, true, false);
        String randomLastName = generateRandomString(3, true, false);
        int randomNumber = random.nextInt(1000);
        String randomDomain = domains[random.nextInt(domains.length)];

        return randomFirstName + randomLastName + randomNumber + "@" + randomDomain;
    }

    public static String generateRandomPin() {
        return generateRandomString(6, false, true);
    }

    public static String generateRandomName() {
        return generateRandomString(4, true, false) + " " +
                generateRandomString(4, true, false);
    }

    public static String generateRandomString(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String reverseString(String data) {
        return new StringBuilder(data).reverse().toString();
    }

}
