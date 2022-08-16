package System_Classes;
import java.time.LocalDate;
import java.time.LocalTime;
public class DonOrganise {
    private int num;
    private String oragniser_par;
    private LocalDate date;
    private LocalTime h_debut, h_fin;
    private String location;
    private String etat;

    public DonOrganise(String oragniser_par, LocalDate date, LocalTime h_debut, LocalTime h_fin, String location) {
        this.oragniser_par = oragniser_par;
        this.date = date;
        this.h_debut = h_debut;
        this.h_fin = h_fin;
        this.location = location;
    }

    public DonOrganise(int num, LocalDate date, LocalTime h_debut, LocalTime h_fin, String location, String etat) {
        this.num = num;
        this.date = date;
        this.h_debut = h_debut;
        this.h_fin = h_fin;
        this.location = location;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public DonOrganise(int num, String oragniser_par, LocalDate date, LocalTime h_debut, LocalTime h_fin, String location) {
        this.num = num;
        this.oragniser_par = oragniser_par;
        this.date = date;
        this.h_debut = h_debut;
        this.h_fin = h_fin;
        this.location = location;
    }

    @Override
    public String toString() {
        return "DonOrganise{" +
                "oragniser_par='" + oragniser_par + '\'' +
                ", date=" + date +
                ", h_debut=" + h_debut +
                ", h_fin=" + h_fin +
                ", location='" + location + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOragniser_par() {
        return oragniser_par;
    }

    public void setOragniser_par(String oragniser_par) {
        this.oragniser_par = oragniser_par;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getH_debut() {
        return h_debut;
    }

    public void setH_debut(LocalTime h_debut) {
        this.h_debut = h_debut;
    }

    public LocalTime getH_fin() {
        return h_fin;
    }

    public void setH_fin(LocalTime h_fin) {
        this.h_fin = h_fin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
