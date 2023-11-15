package org.example;

public class Animal extends Entity {
    private String species;

    public Animal(int id, String name, String species) {
        super(id, name);
        this.species = species;
    }

    // Returnerar en beskrivning av djuret
    @Override


    public String toString() {
        return "Animal{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public String getDescription() {
        return super.getDescription() + ", Species: " + species;
    }

    // Returnerar en CSV-formaterad sträng med djurets information
    public String getCSV() {
        return this.id + "," + this.name + "," + this.species;
    }

    // Mata djuret (denna metod kan behöva anpassas beroende på hur du vill hantera matning)
    public void feed(Crop crop) {
        if (crop.getQuantity() > 0) {
            crop.setQuantity(crop.getQuantity() - 1);
            // Lägg till någon form av tillstånd i Animal om det behövs
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
