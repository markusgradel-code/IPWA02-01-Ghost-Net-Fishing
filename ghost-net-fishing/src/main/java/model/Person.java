package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity 
public class Person implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;

    private String name;
    private String phoneNumber; 

    // JPA braucht einen leeren Konstruktor
    public Person() {
    }

    // weiterer Konstruktor für einfaches Erstellen von Personen
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter und Setter 
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}