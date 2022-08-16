package System_Classes;

public class Banque {
    private int banque_id;
    private String banque_name;

    public Banque(int banque_id, String banque_name) {
        this.banque_id = banque_id;
        this.banque_name = banque_name;
    }
    //getters and setters

    public int getBanque_id() {
        return banque_id;
    }

    public void setBanque_id(int banque_id) {
        this.banque_id = banque_id;
    }

    public String getBanque_name() {
        return banque_name;
    }

    public void setBanque_name(String banque_name) {
        this.banque_name = banque_name;
    }
}
