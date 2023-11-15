package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a farm with animals and crops.
public class Farm {

    private List<Animal> animals = new ArrayList<>();
    private List<Crop> crops = new ArrayList<>();
    // Scanner to handle user input.
    private Scanner scanner = new Scanner(System.in);
    // Static variable to generate unique IDs for new animals and crops.
    private static int nextId = 1;


    // Constructor that loads animals and crops from file if they exist, otherwise creates predefined ones.
    public Farm() {
        // File objects to check if animal and crop files exist.
        File animalsFile = new File("animals.txt");
        File cropsFile = new File("crops.txt");

        // Loads animals from file if it exists, otherwise adds predefined animals.
        if (animalsFile.exists()) {
            loadAnimalsFromFile("animals.txt.");
        } else {
            // Predefined animals
            animals.add(new Animal(nextId++, "Bessie", "Cow"));
            animals.add(new Animal(nextId++, "Cluck", "Chicken"));
            animals.add(new Animal(nextId++, "Mady", "Horse"));
            animals.add(new Animal(nextId++, "Patches", "Goat"));
            animals.add(new Animal(nextId++, "Whiskers", "Cat"));
        }
        // Loads crops from file if it exists, otherwise adds predefined crops.
        if (cropsFile.exists()) {
            loadCropsFromFile("crops.txt.");
        } else {
            // Predefined crops
            crops.add(new Crop(nextId++, "Wheat", "Grain", 100));
            crops.add(new Crop(nextId++, "Corn", "Grain", 150));
            crops.add(new Crop(nextId++, "Carrots", "Vegetable", 200));
            crops.add(new Crop(nextId++, "Tomatoes", "Fruit", 100));
            crops.add(new Crop(nextId++, "Lettuce", "Leafy Green", 80));
        }
    }

    // Method to load animals from a file.
    private void loadAnimalsFromFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // System.out.println("Loaded line: " + line);
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        // Creates a new Animal object and adds it to the list.
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String species = parts[2];
                        animals.add(new Animal(id, name, species));
                        // Updates the next available ID.
                        nextId = Math.max(nextId, id + 1);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Could not find the file: " + filename);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing ID from file: " + filename);
            }
        } else {
            System.out.println("The file does not exist: " + filename);
        }
    }

    // Method to load crops from a file.
    private void loadCropsFromFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // System.out.println("Loaded line: " + line);
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String type = parts[2];
                        int quantity = Integer.parseInt(parts[3]);
                        crops.add(new Crop(id, name, type, quantity));
                        nextId = Math.max(nextId, id + 1);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Could not find the file: " + filename);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing ID from file: " + filename);
            }
        } else {
            System.out.println("The file does not exist: " + filename);
        }
    }
    // Main menu of the program.
    public void MainMenu() {
        // While loop to display the menu until the user chooses to exit the program.
        boolean running = true;
        while (running) {
            // Presents options to the user.
            System.out.println("\nWelcome to the Farm Management System");
            System.out.println("1. View all animals");
            System.out.println("2. View all crops");
            System.out.println("3. Add an animal");
            System.out.println("4. Add a crop");
            System.out.println("5. Feed an animal");
            System.out.println("6. Remove an animal");
            System.out.println("7. Remove a crop");
            System.out.println("8. Save all data");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            // Handles the user's choice and calls the corresponding method.
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        ViewAnimals();
                        break;
                    case 2:
                        ViewCrops();
                        break;
                    case 3:
                        AddAnimal();
                        break;
                    case 4:
                        AddCrop();
                        break;
                    case 5:
                        FeedAnimal();
                        break;
                    case 6:
                        RemoveAnimal();
                        break;
                    case 7:
                        RemoveCrop();
                        break;
                    case 8:
                        save();
                        break;
                    case 9:
                        running = false;
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Methods which implements logic to show, add, feed and remove animals and crops.

    private void ViewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("There are no animals on the farm.");
        } else for (Animal animal : animals) {
            System.out.println(animal); // Detta anropar toString()-metoden för varje Animal
        }
    }

    private void ViewCrops() {
        if (crops.isEmpty()) {
            System.out.println("There are no crops on the farm.");
        } else {
            for (Crop crop : crops) {
                System.out.println(crop);
            }
        }
    }

    private void AddAnimal() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal species: ");
        String species = scanner.nextLine();

        Animal newAnimal = new Animal(nextId++, name, species);
        animals.add(newAnimal);
        System.out.println("Animal added with ID: " + newAnimal.getId());
    }

    private void AddCrop() {
        System.out.print("Enter crop name: ");
        String name = scanner.nextLine();
        System.out.print("Enter crop type: ");
        String type = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        crops.add(new Crop(nextId++, name, type, quantity));
        System.out.println("Crop added.");
    }

    private void FeedAnimal() {
        System.out.print("Enter the ID of the animal to feed: ");
        int animalId = Integer.parseInt(scanner.nextLine());
        Animal animalToFeed = null;
        for (Animal animal : animals) {
            if (animal.getId() == animalId) {
                animalToFeed = animal;
                break;
            }
        }

        if (animalToFeed == null) {
            System.out.println("Animal with ID " + animalId + " not found.");
            return;
        }

        System.out.print("Enter the ID of the crop to feed the animal: ");
        int cropId = Integer.parseInt(scanner.nextLine());
        Crop cropToFeed = null;
        for (Crop crop : crops) {
            if (crop.getId() == cropId && crop.getQuantity() > 0) {
                cropToFeed = crop;
                break;
            }
        }

        if (cropToFeed == null) {
            System.out.println("Crop with ID " + cropId + " not found or is out of stock.");
            return;
        }

        //  Logic to "feed" the animal. For example:
        cropToFeed.setQuantity(cropToFeed.getQuantity() - 1);
        System.out.println("Fed " + animalToFeed.getName() + " with " + cropToFeed.getName() + ".");
    }

    private void RemoveAnimal() {
        System.out.print("Enter the ID of the animal to remove: ");
        int animalId = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == animalId) {
                found = true;
                animals.remove(i);
                System.out.println("Animal with ID " + animalId + " removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Animal with ID " + animalId + " not found.");
        }
    }

    private void RemoveCrop() {
        System.out.print("Enter the ID of the crop to remove: ");
        int cropId = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < crops.size(); i++) {
            if (crops.get(i).getId() == cropId) {
                found = true;
                crops.remove(i);
                System.out.println("Crop with ID " + cropId + " removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Crop with ID " + cropId + " not found.");
        }
    }

    private void save() {
        saveAnimals();
        saveCrops();
    }
    // Method to save the list of animals to file.
    private void saveAnimals() {
        saveListToFile("animals.txt", animals);
    }
    // Method to save the list of crops to file.
    private void saveCrops() {
        saveListToFile("crops.txt", crops);
    }

    // Helper method to save a list of entities (animals or crops) to a file.
    private void saveListToFile(String filename, List<? extends Entity> entities) {
        try (FileWriter fw = new FileWriter(new File(filename));
             BufferedWriter bw = new BufferedWriter(fw)) {
            // Iterates over the entities and writes them to the file in CSV format.
            for (Entity entity : entities) {
                if (entity instanceof Animal) {
                    bw.write(((Animal) entity).getCSV());
                } else if (entity instanceof Crop) {
                    bw.write(((Crop) entity).getCSV());
                }
                bw.newLine();
            }
            System.out.println("Successfully saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving to " + filename + ": " + e.getMessage());
        }
    }
}