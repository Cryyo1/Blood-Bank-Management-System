package System_Classes;

import Db_Handlers.Db_handler;

import java.sql.ResultSet;

public class User {
    private String username;
    private String password;
    private String email_adresse;
    private boolean adminstrateur;

    public User(String username, String password, String email_adresse, boolean adminstrateur) {
        this.username = username;
        this.password = password;
        this.email_adresse = email_adresse;
        this.adminstrateur = adminstrateur;
    }

    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_adresse() {
        return email_adresse;
    }

    public void setEmail_adresse(String email_adresse) {
        this.email_adresse = email_adresse;
    }

    public boolean isAdminstrateur() {
        return adminstrateur;
    }

    public void setAdminstrateur(boolean adminstrateur) {
        this.adminstrateur = adminstrateur;
    }

    //Methodes de user
    public boolean authentifier(){
        Db_handler db_handler=new Db_handler();
        try {
            String query="SELECT * FROM users WHERE username='"+this.username+"' and password_us='"+this.password+"'";
            ResultSet rs=db_handler.execute_select(query);
            if (rs.isBeforeFirst()) {
                this.adminstrateur = rs.getString(3).equals("admin");
                return true;
            }
            else
                return false;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
