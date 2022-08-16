package System_Classes;

public class Preference {

    private String nom_complet;
    private Langue langue;
    private String etat_de_santé;
    private GroupeSanguin groupe_sanguin;
    private Rhesus rhesus;
    private String image;
    //constructeur
    public Preference(){}
    public Preference(String nom_complet, Langue langue, String etat_de_santé, GroupeSanguin groupe_sanguin, Rhesus rhesus, String image) {
        this.nom_complet = nom_complet;
        this.langue = langue;
        this.etat_de_santé = etat_de_santé;
        this.groupe_sanguin = groupe_sanguin;
        this.rhesus = rhesus;
        this.image = image;
    }
    //getters && setters
    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public String getEtat_de_santé() {
        return etat_de_santé;
    }

    public void setEtat_de_santé(String etat_de_santé) {
        this.etat_de_santé = etat_de_santé;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
