package org.example;

public class Crop extends Entity {
    private String cropType;
    private int quantity;

    public Crop(int id, String name, String cropType, int quantity) {
        super(id, name);
        this.cropType = cropType;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Crop{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getCropType() + '\'' +
                ", quantity=" + getQuantity() +
                '}';
    }

    public String getDescription() {
        return super.getDescription() + ", Type: " + this.cropType + ", Quantity: " + this.quantity;
    }

    public String getCSV() {
        return this.id + "," + this.name + "," + this.cropType + "," + this.quantity;
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

