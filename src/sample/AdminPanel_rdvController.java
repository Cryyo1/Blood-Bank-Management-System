package sample;


import Db_Handlers.Db_handler;
import System_Classes.DemandeRendezVous;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import java.util.ResourceBundle;

import static sample.LoginController.profile;

public class AdminPanel_rdvController implements Initializable {

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
    private JFXButton liste_banques;

    @FXML
    private JFXButton logout;

    @FXML
    private JFXButton refuser;

    @FXML
    private JFXButton retour;

    @FXML
    private JFXButton accepter;
    @FXML
    private TableView<DemandeRendezVous> table_rendez_vous;
    @FXML
    private TableColumn<DemandeRendezVous,LocalDate> date_de_rendez_vous;
    @FXML
    private TableColumn<DemandeRendezVous,String> hopital;
    @FXML
    private TableColumn<DemandeRendezVous, String> demander_par;
    @FXML
    private TableColumn<DemandeRendezVous, LocalDate> date_dernier_rv;
    @FXML
    private JFXDatePicker date_rv;


    @FXML
    public void changerImage(){
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Choisissez votre image de profile");
        Stage stage=(Stage)main_pane.getScene().getWindow();
        File file=fileChooser.showOpenDialog(stage);
        if (file !=null){
            Db_handler db_handler=new Db_handler();
            db_handler.execute_update("update preferenceProfile set image='"+file.getAbsolutePath()+"'where username='"+profile.getUser().getUsername()+"'");
            System.out.println("update preferenceProfile set image='"+file.getAbsolutePath()+"'where username='"+profile.getUser().getUsername()+"'");
            Image img = new Image("file:///"+file.getPath(), false);
            avatar.setStroke(Color.SEAGREEN);
            avatar.setFill(new ImagePattern(img));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_complet.setText(profile.getUser().getUsername());
        remplireTable();
        try{
            Image img = new Image("file:///" + profile.getPreference().getImage(), false);
            if (!img.isError()) {
                avatar.setStroke(Color.SEAGREEN);
                avatar.setFill(new ImagePattern(img));
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void Retourner() throws IOException {
        Stage stage =(Stage)retour.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        stage.setTitle("principale");
        Scene scene=new Scene(root, 720, 464);
        scene.getStylesheets().add(getClass().getResource("..//CSS//main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private void remplireTable() {
        ObservableList<DemandeRendezVous> data =FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet resultSet = db_handler.execute_select("select date_rdv,hopital_name,demander_par " +
                                                            "from demandeRDV d,hopital h " +
                                                            " where h.hopital_id=d.hopital_id " +
                                                            " and etat_demande='en attente'");
            while (resultSet.next()) {
                LocalDate date = LocalDate.parse(resultSet.getString(1));

                data.add(new DemandeRendezVous(/*date rdv*/date,/*nom hopital*/resultSet.getString(2),
                                                /*date last rdv*/LocalDate.now(),/*demander par*/resultSet.getString(3)));
            }
            date_de_rendez_vous.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,LocalDate>("date_rdv"));
            hopital.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,String>("hospital"));
            demander_par.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,String>("demander_par"));
            date_dernier_rv.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,LocalDate>("date_dernier_rv"));
            table_rendez_vous.setItems(data);

        }catch(Exception e){
            e.printStackTrace();
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
        Stage stage =(Stage)modifier_profile.getScene().getWindow();
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



    public void AccepterHandler(){
        try {
            DemandeRendezVous drv = table_rendez_vous.getSelectionModel().getSelectedItem();
            if (drv != null) {
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("update demandeRDV set etat_demande='accepter' "
                                            +"where date_rdv='"+drv.getDate_rdv()+"' and hopital_id in " +
                                            "(SELECT hopital_id from hopital where hopital_name='"+drv.getHospital()+"')");

                Alert alert=new Alert(Alert.AlertType.INFORMATION, "La demande de rdv a été accepter :) !! ", ButtonType.OK);
                alert.showAndWait();
            }else{
                Alert alert=new Alert(Alert.AlertType.WARNING, "veuillez choisir une ligne !! ", ButtonType.OK);
                alert.showAndWait();
            }
            remplireTable();
        }catch(NullPointerException ne){
            Alert alert=new Alert(Alert.AlertType.WARNING, "une erreur s'est produite veuillez réessayer !! ", ButtonType.OK);
            alert.showAndWait();
        }

    }
    public void RefuserHandler(){
        try {
            DemandeRendezVous drv = table_rendez_vous.getSelectionModel().getSelectedItem();
            if (drv != null) {
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("update demandeRDV set etat_demande='refuser' "
                        +"where date_rdv='"+drv.getDate_rdv()+"' and hopital_id in " +
                        "(SELECT hopital_id from hopital where hopital_name='"+drv.getHospital()+"')");

                Alert alert=new Alert(Alert.AlertType.INFORMATION, "La demande de rdv a été refuser :( !! ", ButtonType.OK);
                alert.showAndWait();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.WARNING, "veuillez choisir une ligne !! ", ButtonType.OK);
                alert.showAndWait();
            }
        }catch(NullPointerException ne){
            Alert alert=new Alert(Alert.AlertType.WARNING, "une erreur s'est produite veuillez réessayer !! ", ButtonType.OK);
            alert.showAndWait();
        }

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
}

