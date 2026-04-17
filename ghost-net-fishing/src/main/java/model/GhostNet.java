package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class GhostNet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //
    private int id;

    private double latitude;
    private double longitude;
    private String size; // Größe als Text

    @Enumerated(EnumType.STRING) // Enum als String speichern
    private GhostNetStatus status;

    // Die meldende Person
    @ManyToOne(cascade = CascadeType.ALL)
    private Person reporter;

    // Der Berger des Netzes
    @ManyToOne(cascade = CascadeType.ALL)
    private Person recoverer;

    // Setzt das Netz direkt auf GEMELDET, wenn es neu erstellt wird
    public GhostNet() {
        this.status = GhostNetStatus.GEMELDET; 
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public GhostNetStatus getStatus() {
        return status;
    }

    public void setStatus(GhostNetStatus status) {
        this.status = status;
    }

    public Person getReporter() {
        return reporter;
    }

    public void setReporter(Person reporter) {
        this.reporter = reporter;
    }

    public Person getRecoverer() {
        return recoverer;
    }

    public void setRecoverer(Person recoverer) {
        this.recoverer = recoverer;
    }
}