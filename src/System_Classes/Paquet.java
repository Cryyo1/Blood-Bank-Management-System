package System_Classes;

import Db_Handlers.Db_handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paquet {
    private int num_paquet;
    private String donne_par;
    private LocalDate date_de_Don;
    private String sang;
    private String type_donnation;

    public Paquet(int num_paquet, String donne_par, LocalDate date_de_Don, String sang, String type_donnation) {
        this.num_paquet = num_paquet;
        this.donne_par = donne_par;
        this.date_de_Don = date_de_Don;
        this.sang = sang;
        this.type_donnation = type_donnation;
    }

//getters and setters

    public int getNum_paquet() {
        return num_paquet;
    }

    public void setNum_paquet(int num_paquet) {
        this.num_paquet = num_paquet;
    }

    public String getDonne_par() {
        return donne_par;
    }

    public void setDonne_par(String donne_par) {
        this.donne_par = donne_par;
    }

    public LocalDate getDate_de_Don() {
        return date_de_Don;
    }

    public void setDate_de_Don(LocalDate date_de_Don) {
        this.date_de_Don = date_de_Don;
    }

    public String getSang() {
        return sang;
    }

    public void setSang(String sang) {
        this.sang = sang;
    }

    public String getType_donnation() {
        return type_donnation;
    }

    public void setType_donnation(String type_donnation) {
        this.type_donnation = type_donnation;
    }
    //methodes
    public void ajouterPaquet(){
        Db_handler db_handler=new Db_handler();
        db_handler.execute_update("INSERT INTO stock VALUES (1,'"+this.donne_par+"'," +
                                "date('"+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"'),'"+this.type_donnation+"')");

    }
}
