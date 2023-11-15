package org.example;
/**
 * The Main class contains the main method which serves as the entry point for the Farm Management System application.
 * It creates an instance of the Farm class and starts the application by calling the MainMenu method.
 */
public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.MainMenu();
    }
}