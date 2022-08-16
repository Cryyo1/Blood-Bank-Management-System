package System_Classes;

public class Post {

    private int id_post;
    private String message;
    private String titre;

    public Post(int id_post, String message, String titre) {
        this.id_post = id_post;
        this.message = message;
        this.titre = titre;
    }
    //setters and getters

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
