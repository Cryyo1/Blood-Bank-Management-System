package sample;


import System_Classes.Preference;
import System_Classes.Profile;
import System_Classes.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton signup;


    static Profile profile;


    public void authentifier(ActionEvent event){
        try {
            String user=username.getText(),pass=password.getText();
            profile =new Profile(new Preference(),new User(user,pass,"",false));

            if(profile.getUser().authentifier()){
                Stage stage =(Stage)login.getScene().getWindow();
                Parent root;
                if(profile.getUser().isAdminstrateur())
                    root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("DonneurPanel.fxml"));

                stage.setTitle("principale");
                Scene scene=new Scene(root, 720, 464);
                scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR, "nom d'utilisateur \n ou mot de passe n'est pas correct", ButtonType.OK);
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void openSignUp(ActionEvent event) throws IOException {
        Stage stage =(Stage)signup.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        stage.setTitle("SignUp");
        Scene scene=new Scene(root, 682, 449);
        scene.getStylesheets().add(getClass().getResource("..//CSS//Login.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



}
