package sample;

import Db_Handlers.Db_handler;
import System_Classes.Profile;
import System_Classes.Rhesus;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.LoginController.profile;

public class PreferenceDonneur implements Initializable {

    @FXML
    private AnchorPane main_pane;

    @FXML
    private Label nom_complet;

    @FXML
    private JFXButton modifier_profile;

    @FXML
    private Circle avatar;

    @FXML
    private JFXButton changer_image;

    @FXML
    private JFXButton demanderv;

    @FXML
    private JFXButton historique;

    @FXML
    private JFXButton carnet;

    @FXML
    private JFXButton liste_hopitaux;

    @FXML
    private JFXButton liste_banque;

    @FXML
    private JFXButton logout;

    @FXML
    private JFXTextField fullname;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField groupe_sanguin;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton valider;

    @FXML
    private ImageView imageview;

    @FXML
    private JFXButton retour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_complet.setText(profile.getUser().getUsername());
        email.setText(profile.getUser().getEmail_adresse());
        fullname.setText(profile.getPreference().getNom_complet());
        String str=(profile.getPreference().getRhesus() == Rhesus.postive) ? "+":"-";
        groupe_sanguin.setText(profile.getPreference().getGroupe_sanguin()+str);
        username.setText(profile.getUser().getUsername());
        password.setText(profile.getUser().getUsername());

        try {
            Image img = new Image("file:///" + profile.getPreference().getImage(), false);
            if (!img.isError()) {
                imageview.setImage(img);
                avatar.setStroke(Color.SEAGREEN);
                avatar.setFill(new ImagePattern(img));
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void changerImage() throws SQLException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Choisissez votre image de profile");
        Stage stage=(Stage)main_pane.getScene().getWindow();
        File file=fileChooser.showOpenDialog(stage);
        if (file !=null){
            Image img = new Image("file:///"+file.getPath(), false);
            Db_handler db_handler=new Db_handler();
            db_handler.execute_update("update preferenceProfile set image='"+file.getAbsolutePath()+"'where username='"+profile.getUser().getUsername()+"'");
            avatar.setStroke(Color.SEAGREEN);
            avatar.setFill(new ImagePattern(img));
            db_handler.closeConn();
        }
    }
    @FXML
    public void logoutfunction() throws IOException {
        Alert alert=new Alert(Alert.AlertType.INFORMATION, "Au revoir :) !! ", ButtonType.OK);
        alert.showAndWait();
        Stage stage = (Stage) logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("principale");
        Scene scene = new Scene(root, 720, 464);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void openCarnetDeSante(ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CarnetSante.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void openHistorique(ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HistoriqueDonneur.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void openListesDemande(ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ListesDemandes.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openPreference(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PreferenceDonneur.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void openRDV(ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DemandeRDV.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void openorganiserDon(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("OrganiserDonDonneur.fxml"));
        stage.setTitle("Historique");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void enregisterModif(){
        try {
            Db_handler db_handler = new Db_handler();
            db_handler.execute_update("update preferenceProfile set"
                    + " nom_complet ='" + fullname.getText() + "',"
                    + " email ='" + email.getText() + "',"
                    + " username ='" + username.getText() + "'"
                    + "where username='" + profile.getUser().getUsername() + "'");
            Alert alert=new Alert(Alert.AlertType.INFORMATION, "Vos informations on été modifié :) !! ", ButtonType.OK);
            alert.showAndWait();
        }catch(Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR, "une erreur s'est produite veuillez réessayer", ButtonType.OK);
            alert.showAndWait();
        }

    }


}
