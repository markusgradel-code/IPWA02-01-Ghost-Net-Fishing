package controller;

import dao.GhostNetDAO;
import model.GhostNet;
import model.GhostNetStatus;
import model.Person;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class GhostNetController implements Serializable {

    // Serial ID für die Session-Speicherung
    private static final long serialVersionUID = 42L; 

    private GhostNetDAO dao = new GhostNetDAO(); 
    private GhostNet newNet = new GhostNet();
    private Person reporter = new Person(); 
    private Person recoverer = new Person(); 
    private GhostNet selectedNet; 

    public List<GhostNet> getGhostNets() {
        return dao.findAll();
    }

    // gemeldetes Netz speichern (Anforderung 1)
    public String save() {
        System.out.println("Controller: Speichere neues Netz...");
        
        // Prüfung ob Name eingegeben wurde oder anonym 
        if (reporter.getName() != null && !reporter.getName().isEmpty()) {
            newNet.setReporter(reporter);
        } else {
            newNet.setReporter(null);
        }
        
        newNet.setStatus(GhostNetStatus.GEMELDET);
        dao.save(newNet);
        
        // Felder leeren für neue Eingabe
        newNet = new GhostNet();
        reporter = new Person();
        
        // Seite neu laden um Doppeleingabe zu verhindern
        return "index.xhtml?faces-redirect=true";
    }
    
    // Zuweisung Berger 
    public String assignRecoverer() {
        // Prüfung ob wir ein ausgewähltes Netz haben
        if (this.selectedNet != null && recoverer.getName() != null && !recoverer.getName().isEmpty()) {
            System.out.println("Netz gefunden ID: " + selectedNet.getId());
            // Berger-Objekt vorbereiten
            Person berger = new Person(recoverer.getName(), recoverer.getPhoneNumber());
            // Die Daten im ausgewählten Netz setzen
            this.selectedNet.setRecoverer(berger);
            this.selectedNet.setStatus(GhostNetStatus.BERGUNG_BEVORSTEHEND);
            // Speichern
            dao.save(this.selectedNet);
            System.out.println("Status geändert auf " + selectedNet.getStatus());
            // Aufräumen
            this.recoverer = new Person();
            this.selectedNet = null;
            //  Reload der Seite
            return "index.xhtml?faces-redirect=true";
        } else {
            System.out.println("Abbruch - selectedNet ist null oder Name leer!");
        }
        return null; 
    }
    
    // Status  Geborgen setzen
    public void markAsRecovered(GhostNet net) {
        if (net != null) {
            System.out.println("Controller: Netz als geborgen markiert.");
            net.setStatus(GhostNetStatus.GEBORGEN);
            dao.save(net);
        }
    }
    
    // Status "Verschollen" setzen
    public void markAsMissing(GhostNet net) {
        if (net != null) {
            System.out.println("Controller: Netz ist verschollen.");
            net.setStatus(GhostNetStatus.VERSCHOLLEN);
            dao.save(net);
        }
    }

    // Getter und Setter 
    public GhostNet getSelectedNet() { 
    	return selectedNet; 
    }
    public void setSelectedNet(GhostNet selectedNet) { 
    	this.selectedNet = selectedNet; 
    }
    
    public GhostNet getNewNet() { 
    	return newNet; 
    }
    public void setNewNet(GhostNet newNet) { 
    	this.newNet = newNet; 
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