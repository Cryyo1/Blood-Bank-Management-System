package System_Classes;

import java.time.LocalDate;

public class DemandeRendezVous {
    private LocalDate date_rdv;
    private String hospital;
    private LocalDate date_dernier_rv;
    private String demander_par;
    private String etat;

    public DemandeRendezVous(LocalDate date_rdv, String hospital, LocalDate date_dernier_rv, String demander_par) {
        this.date_rdv = date_rdv;
        this.hospital = hospital;
        this.date_dernier_rv = date_dernier_rv;
        this.demander_par = demander_par;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public DemandeRendezVous(LocalDate date_rdv, String hospital, String demander_par, String etat) {
        this.date_rdv = date_rdv;
        this.hospital = hospital;
        this.etat = etat;
        this.demander_par = demander_par;
    }

    public LocalDate getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(LocalDate date_rdv) {
        this.date_rdv = date_rdv;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public LocalDate getDate_dernier_rv() {
        return date_dernier_rv;
    }

    public void setDate_dernier_rv(LocalDate date_dernier_rv) {
        this.date_dernier_rv = date_dernier_rv;
    }

    public String getDemander_par() {
        return demander_par;
    }

    public void setDemander_par(String demander_par) {
        this.demander_par = demander_par;
    }
}
