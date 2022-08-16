package System_Classes;

public class Forum {
    private int id_forum;
    private String titre;

    public Forum(int id_forum, String titre) {
        this.id_forum = id_forum;
        this.titre = titre;
    }

    //getters and setters

    public int getId_forum() {
        return id_forum;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
