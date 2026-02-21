package br.com.erudio.automated_tests_with_java_erudio.advancedMockito.staticwithparams;

public class MyUtils {

    public static String getWelcomeMessage(String username, boolean isCustomer) {
        if (isCustomer) {
            return "Dear " + username;
        }
        else {
            return "Hello " + username;
        }
    }
}
