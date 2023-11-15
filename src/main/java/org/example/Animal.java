package org.example;

// Class representing an animal with a unique ID, name, and species.
public class Animal extends Entity {
    private String species;

    // Constructor to create an animal with the given ID, name, and species.
    public Animal(int id, String name, String species) {
        super(id, name);
        this.species = species;
    }

    // Overrides the toString method to return a string representation of the animal.
    @Override

    public String toString() {
        return "Animal{" +
                "id=" + getId() +  // Retrieves the ID from the parent Entity class.
                ", name='" + getName() + '\'' + // Retrieves the name from the parent Entity class.
                ", species='" + species + '\'' + // Adds the species information.
                '}';
    }
    // Provides a description of the animal by calling the getDescription method from the Entity class.
    public String getDescription() {
        return super.getDescription() + ", Species: " + species;
    }

    // Returns a CSV-formatted string containing the animal's information, useful for saving to a file.
    public String getCSV() {
        return this.id + "," + this.name + "," + this.species;
    }

    // Method to feed the animal with the specified crop.
    // Decreases the crop quantity by 1 and prints out a message indicating the animal was fed.
    public void feed(Crop crop) {
        if (crop.getQuantity() > 0) {
            crop.setQuantity(crop.getQuantity() - 1);
            // Prints out which animal was fed with which crop.
            System.out.println(this.getName() + " was fed with " + crop.getName() + ".");
        } else {
            System.out.println("No more " + crop.getName() + " left to feed " + this.getName() + ".");
        }
    }

    // Getters och setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
