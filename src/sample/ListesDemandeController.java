package sample;

import Db_Handlers.Db_handler;
import System_Classes.DemandeRendezVous;
import System_Classes.DonOrganise;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.ResourceBundle;

import static sample.LoginController.profile;

public class ListesDemandeController implements Initializable {
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
    private JFXButton carnetSante;

    @FXML
    private JFXButton liste_baqnue;

    @FXML
    private JFXButton listes_deamndes;

    @FXML
    private JFXButton logout;

    @FXML
    private TableView<DemandeRendezVous> listes_dons;

    @FXML
    private TableColumn<DemandeRendezVous, LocalDate> date_rdv;

    @FXML
    private TableColumn<DemandeRendezVous, String> nom_hopital;

    @FXML
    private TableColumn<DemandeRendezVous, String> demander_par;

    @FXML
    private TableColumn<DemandeRendezVous, String> etat;

    @FXML
    private JFXButton valider_org;

    @FXML
    private TableView<DonOrganise> listeorganisation;

    @FXML
    private TableColumn<DonOrganise, Integer> num_demande;

    @FXML
    private TableColumn<DonOrganise, LocalDate> date;

    @FXML
    private TableColumn<DonOrganise, LocalTime> heure_deb;

    @FXML
    private TableColumn<DonOrganise, LocalTime> heure_fin;

    @FXML
    private TableColumn<DonOrganise, String> location;

    @FXML
    private TableColumn<DonOrganise, String> Etat_org;

    @FXML
    private JFXButton valider_don;

    @FXML
    void annuler(ActionEvent event) {
        try {
            DemandeRendezVous drv = listes_dons.getSelectionModel().getSelectedItem();
            if (drv != null) {
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("delete from demandeRDV "
                        +"where date_rdv='"+drv.getDate_rdv()+"' and hopital_id in (select hopital_id from hopital where hopital_name='"+drv.getHospital()+"')");

                Alert alert=new Alert(Alert.AlertType.INFORMATION, "La demande de rdv a été annuler :( !! ", ButtonType.OK);
                alert.showAndWait();
                remplireTable();
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
    @FXML
    public void annuler_org(ActionEvent actionEvent) {
        try {
            DonOrganise donOrganise = listeorganisation.getSelectionModel().getSelectedItem();
            if (donOrganise != null) {
                Db_handler db_handler=new Db_handler();
                db_handler.execute_update("delete from demandeOragnisation "
                        +"where num_demande="+donOrganise.getNum()+"");

                Alert alert=new Alert(Alert.AlertType.INFORMATION, "La demande d'organisation a été annuler :( !! ", ButtonType.OK);
                alert.showAndWait();
                remplireTable();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.WARNING, "veuillez choisir une ligne !! ", ButtonType.OK);
                alert.showAndWait();
            }
            remplirTableOrg();
        }catch(NullPointerException ne){
            Alert alert=new Alert(Alert.AlertType.WARNING, "une erreur s'est produite veuillez réessayer !! ", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            nom_complet.setText(profile.getUser().getUsername());
            Image img = new Image("file:///" + profile.getPreference().getImage(), false);
            remplireTable();
            remplirTableOrg();
            if (!img.isError()) {
                avatar.setStroke(Color.SEAGREEN);
                avatar.setFill(new ImagePattern(img));
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    private void remplireTable() {
        ObservableList<DemandeRendezVous> data = FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet resultSet = db_handler.execute_select("select date_rdv,hopital_name,demander_par,etat_demande " +
                    "from demandeRDV d,hopital h " +
                    " where h.hopital_id=d.hopital_id and demander_par='"+profile.getUser().getUsername()+"'");
            while (resultSet.next()) {
                LocalDate date = LocalDate.parse(resultSet.getString(1));
                data.add(new DemandeRendezVous(/*date rdv*/date,/*nom hopital*/resultSet.getString(2)
                                ,/*demander par*/resultSet.getString(3),resultSet.getString(4)));
            }
            date_rdv.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,LocalDate>("date_rdv"));
            nom_hopital.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,String>("hospital"));
            demander_par.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,String>("demander_par"));
            etat.setCellValueFactory(new PropertyValueFactory<DemandeRendezVous,String>("etat"));

            listes_dons.setItems(data);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void remplirTableOrg(){
        ObservableList<DonOrganise> data = FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet resultSet = db_handler.execute_select("select * from demandeOragnisation where oragniser_par='"+profile.getPreference().getNom_complet()+"'");
            while (resultSet.next()) {
                data.add(new DonOrganise(resultSet.getInt("num_demande"),
                        LocalDate.parse(resultSet.getString("date")),
                        LocalTime.parse(resultSet.getString("h_debut")),
                        LocalTime.parse(resultSet.getString("h_fin")),
                        resultSet.getString("location"),
                        resultSet.getString("etat")));
            }
            num_demande.setCellValueFactory(new PropertyValueFactory<DonOrganise,Integer>("num"));
            date.setCellValueFactory(new PropertyValueFactory<DonOrganise, LocalDate>("date"));
            location.setCellValueFactory(new PropertyValueFactory<DonOrganise,String>("location"));
            Etat_org.setCellValueFactory(new PropertyValueFactory<DonOrganise,String>("etat"));
            heure_deb.setCellValueFactory(new PropertyValueFactory<DonOrganise,LocalTime>("h_debut"));
            heure_fin.setCellValueFactory(new PropertyValueFactory<DonOrganise,LocalTime>("h_fin"));

            listeorganisation.setItems(data);

        }catch(Exception e){
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

}
