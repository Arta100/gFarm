package org.example;
// Base class representing a generic entity with a unique ID and name.
public class Entity {
    public int id;
    protected String name;
    // Constructor to create an entity with the given ID and name.
    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // Provides a basic description of the entity containing its ID and name.
    public String getDescription() {
        return "ID: " + id + ", Name: " + name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

