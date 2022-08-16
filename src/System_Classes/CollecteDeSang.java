package System_Classes;

import java.time.LocalDate;

public class CollecteDeSang {
    private Donneur donnateur;
    private Hospital hospital;
    private GroupeSanguin groupe_sanguin;
    private Rhesus rhesus;
    private LocalDate date_de_collecte;
    private boolean medecin_responsable;

    public CollecteDeSang(Donneur donnateur, Hospital hospital,
                          GroupeSanguin groupe_sanguin, Rhesus rhesus,
                          LocalDate date_de_collecte, boolean medecin_responsable) {
        this.donnateur = donnateur;
        this.hospital = hospital;
        this.groupe_sanguin = groupe_sanguin;
        this.rhesus = rhesus;
        this.date_de_collecte = date_de_collecte;
        this.medecin_responsable = medecin_responsable;
    }

    //getters and setters


    public Donneur getDonnateur() {
        return donnateur;
    }

    public void setDonnateur(Donneur donnateur) {
        this.donnateur = donnateur;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public GroupeSanguin getGroupe_sanguin() {
        return groupe_sanguin;
    }

    public void setGroupe_sanguin(GroupeSanguin groupe_sanguin) {
        this.groupe_sanguin = groupe_sanguin;
    }

    public Rhesus getRhesus() {
        return rhesus;
    }

    public void setRhesus(Rhesus rhesus) {
        this.rhesus = rhesus;
    }

    public LocalDate getDate_de_collecte() {
        return date_de_collecte;
    }

    public void setDate_de_collecte(LocalDate date_de_collecte) {
        this.date_de_collecte = date_de_collecte;
    }

    public boolean isMedecin_responsable() {
        return medecin_responsable;
    }

    public void setMedecin_responsable(boolean medecin_responsable) {
        this.medecin_responsable = medecin_responsable;
    }
}
