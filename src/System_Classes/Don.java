package System_Classes;

import java.time.LocalDate;

public class Don {
    private Integer num_don;
    private LocalDate date_don;
    private String Location;
    private String nom_donneur;

    public Don(int num_don, LocalDate date_don, String location,String nom_donneur) {
        this.num_don = num_don;
        this.date_don = date_don;
        Location = location;
        this.nom_donneur=nom_donneur;
    }

    public Integer getNum_don() {
        return num_don;
    }

    public void setNum_don(Integer num_don) {
        this.num_don = num_don;
    }

    public LocalDate getDate_don() {
        return date_don;
    }

    public void setDate_don(LocalDate date_don) {
        this.date_don = date_don;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getNom_donneur() {
        return nom_donneur;
    }

    public void setNom_donneur(String nom_donneur) {
        this.nom_donneur = nom_donneur;
    }
}
