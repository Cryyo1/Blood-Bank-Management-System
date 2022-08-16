package System_Classes;

import java.time.LocalDate;

public class Transaction {
    private int num_controle;
    private Donneur delivre_par;
    private LocalDate date_de_publication;
    private String delivre_a;

    public Transaction(int num_controle, Donneur delivre_par, LocalDate date_de_publication, String delivre_a) {
        this.num_controle = num_controle;
        this.delivre_par = delivre_par;
        this.date_de_publication = date_de_publication;
        this.delivre_a = delivre_a;
    }
    //getters and setters

    public int getNum_controle() {
        return num_controle;
    }

    public void setNum_controle(int num_controle) {
        this.num_controle = num_controle;
    }

    public Donneur getDelivre_par() {
        return delivre_par;
    }

    public void setDelivre_par(Donneur delivre_par) {
        this.delivre_par = delivre_par;
    }

    public LocalDate getDate_de_publication() {
        return date_de_publication;
    }

    public void setDate_de_publication(LocalDate date_de_publication) {
        this.date_de_publication = date_de_publication;
    }

    public String getDelivre_a() {
        return delivre_a;
    }

    public void setDelivre_a(String delivre_a) {
        this.delivre_a = delivre_a;
    }
}
