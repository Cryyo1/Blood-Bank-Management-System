package System_Classes;

import java.time.LocalDate;

public class DemandeDuSang {
    private String controle_non;
    private String demande_par;
    private String nom_du_destinataire;
    private LocalDate date_de_demande;
    private GroupeSanguin groupe_sanguin;
    private Rhesus rhesus;
    private Boolean pas_de_sacs;
    private String objectif;
    private String remarques;

    public DemandeDuSang(String controle_non, String demande_par, String nom_du_destinataire,
                         LocalDate date_de_demande, GroupeSanguin groupe_sanguin,
                         Rhesus rhesus, Boolean pas_de_sacs, String objectif, String remarques) {
        this.controle_non = controle_non;
        this.demande_par = demande_par;
        this.nom_du_destinataire = nom_du_destinataire;
        this.date_de_demande = date_de_demande;
        this.groupe_sanguin = groupe_sanguin;
        this.rhesus = rhesus;
        this.pas_de_sacs = pas_de_sacs;
        this.objectif = objectif;
        this.remarques = remarques;
    }
    //getters and setters

    public String getControle_non() {
        return controle_non;
    }

    public void setControle_non(String controle_non) {
        this.controle_non = controle_non;
    }

    public String getDemande_par() {
        return demande_par;
    }

    public void setDemande_par(String demande_par) {
        this.demande_par = demande_par;
    }

    public String getNom_du_destinataire() {
        return nom_du_destinataire;
    }

    public void setNom_du_destinataire(String nom_du_destinataire) {
        this.nom_du_destinataire = nom_du_destinataire;
    }

    public LocalDate getDate_de_demande() {
        return date_de_demande;
    }

    public void setDate_de_demande(LocalDate date_de_demande) {
        this.date_de_demande = date_de_demande;
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

    public Boolean getPas_de_sacs() {
        return pas_de_sacs;
    }

    public void setPas_de_sacs(Boolean pas_de_sacs) {
        this.pas_de_sacs = pas_de_sacs;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
