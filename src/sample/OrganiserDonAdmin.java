package sample;


import Db_Handlers.Db_handler;
import System_Classes.DemandeRendezVous;
import System_Classes.DonOrganise;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import static sample.LoginController.profile;


public class OrganiserDonAdmin implements Initializable {

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
    private JFXButton organisation;

    @FXML
    private JFXButton liste_hopitaux;

    @FXML
    private JFXButton liste_baqnue;

    @FXML
    private JFXButton logout;

    @FXML
    private TableView<DonOrganise> listes_dons_organise;

    @FXML
    private TableColumn<DonOrganise, Integer> num_don;

    @FXML
    private TableColumn<DonOrganise, LocalDate> Date_don;

    @FXML
    private TableColumn<DonOrganise, String> Endroit_don;

    @FXML
    private TableColumn<DonOrganise, String> organiser_par;

    @FXML
    private TableColumn<DonOrganise, LocalTime> heure_deb;

    @FXML
    private TableColumn<DonOrganise, LocalTime> heure_fin;

    @FXML
    private JFXButton refus;

    @FXML
    private JFXButton accept;

    public void remplirTable(){
        ObservableList<DonOrganise> data = FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet resultSet = db_handler.execute_select("select * from demandeOragnisation where etat='en attente'");
            while (resultSet.next()) {
                data.add(new DonOrganise(resultSet.getInt("num_demande"),
                        resultSet.getString("oragniser_par"),
                        LocalDate.parse(resultSet.getString("date")),
                        LocalTime.parse(resultSet.getString("h_debut")),
                        LocalTime.parse(resultSet.getString("h_fin")),
                        resultSet.getString("location")));
            }
            num_don.setCellValueFactory(new PropertyValueFactory<DonOrganise,Integer>("num"));
            Date_don.setCellValueFactory(new PropertyValueFactory<DonOrganise, LocalDate>("date"));
            Endroit_don.setCellValueFactory(new PropertyValueFactory<DonOrganise,String>("location"));
            organiser_par.setCellValueFactory(new PropertyValueFactory<DonOrganise,String>("oragniser_par"));
            heure_deb.setCellValueFactory(new PropertyValueFactory<DonOrganise,LocalTime>("h_debut"));
            heure_fin.setCellValueFactory(new PropertyValueFactory<DonOrganise,LocalTime>("h_fin"));

            listes_dons_organise.setItems(data);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

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

    public void openRDV(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)demanderv.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel_rdv.fxml"));
        stage.setTitle("preference");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openBanque(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)liste_baqnue.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("GestionBanque.fxml"));
        stage.setTitle("preference");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openHopital(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)liste_hopitaux.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("GestionHopitaux.fxml"));
        stage.setTitle("preference");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openPreference(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("preference.fxml"));
        stage.setTitle("banque");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openStock(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
        stage.setTitle("Stock");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openHistorique(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        stage.setTitle("Historique");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openorganiserDonAdmin(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("OrganiserDonAdmin.fxml"));
        stage.setTitle("Historique");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openorganiserDon(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("OrganiserDon.fxml"));
        stage.setTitle("Historique");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_complet.setText(profile.getUser().getUsername());
        try{
            Image img = new Image("file:///" + profile.getPreference().getImage(), false);
            if (!img.isError()) {
                avatar.setStroke(Color.SEAGREEN);
                avatar.setFill(new ImagePattern(img));
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        remplirTable();

    }

    public void accepter(){
        try {
            DonOrganise donOrganise = listes_dons_organise.getSelectionModel().getSelectedItem();
            if (donOrganise != null){
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("update demandeOragnisation set etat='accepter'" +
                            " where num_demande="+donOrganise.getNum()+"");
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez selectionnez une ligne", ButtonType.OK);
                alert.showAndWait();
            }
            remplirTable();
        }catch (Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR, "une erreur s'est produite veuillez réessayer ",ButtonType.OK);
            alert.showAndWait();

        }

    }

    public void refuser(){
        try {
            DonOrganise donOrganise = listes_dons_organise.getSelectionModel().getSelectedItem();
            if (donOrganise != null){
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("update demandeOragnisation set etat='refuser'" +
                        " where num_demande="+donOrganise.getNum()+"");
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez selectionnez une ligne", ButtonType.OK);
                alert.showAndWait();
            }
            remplirTable();
        }catch (Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR, "une erreur s'est produite veuillez réessayer ",ButtonType.OK);
            alert.showAndWait();

        }

    }
}
