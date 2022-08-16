package System_Classes;

import java.time.LocalDate;

public class Donneur{
    private String nom_complet;
    private String adresse;
    private String contact;
    private GroupeSanguin groupe_sanguin;
    private Rhesus rhesus;
    private int age;
    private String genre;
    private String remarques;

    public Donneur(String nom_complet, String adresse, String contact,
                   GroupeSanguin groupe_sanguin, Rhesus rhesus, int age, String genre, String remarques) {
        this.nom_complet = nom_complet;
        this.adresse = adresse;
        this.contact = contact;
        this.groupe_sanguin = groupe_sanguin;
        this.rhesus = rhesus;
        this.age = age;
        this.genre = genre;
        this.remarques = remarques;
    }

    //getters and setters

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }


    //Methodes De donneur

}
