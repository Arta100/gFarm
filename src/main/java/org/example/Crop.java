package org.example;

// Class representing a crop with a unique ID, name, type, and quantity.
public class Crop extends Entity {
    private String cropType;
    private int quantity;

    // Constructor to create a crop with the given ID, name, type, and quantity
    public Crop(int id, String name, String cropType, int quantity) {
        super(id, name);
        this.cropType = cropType;
        this.quantity = quantity;
    }
    // Overrides the toString method to return a string representation of the crop.
    @Override
    public String toString() {
        return "Crop{" +
                "id=" + getId() + // Retrieves the ID from the parent Entity class.
                ", name='" + getName() + '\'' + // Retrieves the name from the parent Entity class.
                ", type='" + getCropType() + '\'' + // Adds the crop type information.
                ", quantity=" + getQuantity() + // Adds the quantity information.
                '}';
    }
    // Provides a description of the crop by calling the getDescription method from the Entity class and adding type and quantity information.
    public String getDescription() {
        return super.getDescription() + ", Type: " + this.cropType + ", Quantity: " + this.quantity;
    }
    // Returns a CSV-formatted string containing the crop's information, useful for saving to a file.
    public String getCSV() {
        return this.id + "," + this.name + "," + this.cropType + "," + this.quantity; // Combines ID, name, type, and quantity separated by commas.
    }
    // Getters and setters
    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

