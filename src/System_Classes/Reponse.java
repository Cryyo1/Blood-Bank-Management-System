package System_Classes;

public class Reponse {

    private int id_reponse;
    private String message;

    public Reponse(int id_reponse, String message) {
        this.id_reponse = id_reponse;
        this.message = message;
    }
    //getters and setters

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
