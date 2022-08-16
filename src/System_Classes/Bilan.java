package System_Classes;

public class Bilan {
    private int num_bilan;
    private String VIH ;
    private String VHB ;
    private String VHC ;
    private String syphilis;
    private String nom_donneur;

    public Bilan(int num_bilan, String VIH, String VHB, String VHC, String syphilis, String nom_donneur) {
        this.num_bilan = num_bilan;
        this.VIH = VIH;
        this.VHB = VHB;
        this.VHC = VHC;
        this.syphilis = syphilis;
        this.nom_donneur = nom_donneur;
    }

    public int getNum_bilan() {
        return num_bilan;
    }

    public void setNum_bilan(int num_bilan) {
        this.num_bilan = num_bilan;
    }

    public String getVIH() {
        return VIH;
    }

    public void setVIH(String VIH) {
        this.VIH = VIH;
    }

    public String getVHB() {
        return VHB;
    }

    public void setVHB(String VHB) {
        this.VHB = VHB;
    }

    public String getVHC() {
        return VHC;
    }

    public void setVHC(String VHC) {
        this.VHC = VHC;
    }

    public String getSyphilis() {
        return syphilis;
    }

    public void setSyphilis(String syphilis) {
        this.syphilis = syphilis;
    }

    public String getNom_donneur() {
        return nom_donneur;
    }

    public void setNom_donneur(String nom_donneur) {
        this.nom_donneur = nom_donneur;
    }
}
