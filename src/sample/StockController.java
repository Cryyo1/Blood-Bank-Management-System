package sample;

import Db_Handlers.Db_handler;
import System_Classes.Paquet;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.Arrays;
import java.util.ResourceBundle;
import static sample.LoginController.profile;

public class StockController implements Initializable {

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
    private TableView<Paquet> listes_paquets;

    @FXML
    private TableColumn<Paquet, Integer> num_packet;

    @FXML
    private TableColumn<Paquet, String> donnateur;

    @FXML
    private TableColumn<Paquet, LocalDate> date_don;

    @FXML
    private TableColumn<Paquet,String> groupe_sanguin;

    @FXML
    private TableColumn<Paquet,String> type;

    @FXML
    private JFXComboBox<String> filtre;

    @FXML
    private Label nom_complet1;

    @FXML
    private Label nom_complet11;

    @FXML
    private JFXButton ajouter;

    @FXML
    private Label nom_complet111;


    @FXML
    private JFXButton actualiser;

    @FXML
    private JFXComboBox<String> filtre_sang;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_complet.setText(profile.getUser().getUsername());
        filtre.setItems(FXCollections.observableArrayList(
                "all","Concentre Globule Rouge","total","plasma","plaquette"
        ));
        filtre_sang.setItems(FXCollections.observableArrayList(
                "all","A+","A-","B+","B-","AB+","AB-","O+","O-"
        ));
        remplireTable("all","all");
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

    private void remplireTable(String filtre,String filtre_sang) {
        ObservableList<Paquet> data = FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet rs;
            if (filtre.equals("all")) {
                if (filtre_sang.equals("all")) {
                    rs = db_handler.execute_select("SELECT num_paquet,donne_par,date_de_Don,type_donnation,GroupeSanguin " +
                            "FROM donneur d,stock s WHERE s.donne_par=d.nom_complet");
                }
                else{
                    rs = db_handler.execute_select("SELECT num_paquet,donne_par,date_de_Don,type_donnation,GroupeSanguin " +
                            "FROM donneur d,stock s WHERE s.donne_par=d.nom_complet and GroupeSanguin='"+filtre_sang+"'");
                }
            }
            else{
                if (filtre_sang.equals("all")) {
                    rs = db_handler.execute_select("SELECT num_paquet,donne_par,date_de_Don,type_donnation,GroupeSanguin " +
                            "FROM donneur d,stock s WHERE s.donne_par=d.nom_complet and type_donnation='"+filtre+"'");
                }
                else{
                    rs = db_handler.execute_select("SELECT num_paquet,donne_par,date_de_Don,type_donnation,GroupeSanguin " +
                            "FROM donneur d,stock s WHERE s.donne_par=d.nom_complet and GroupeSanguin='"+filtre_sang+"' and type_donnation='"+filtre+"'");
                }
            }

            while (rs.next()) {
                data.add(new Paquet(rs.getInt(1),rs.getString(2),LocalDate.parse(rs.getString(3))
                                    ,rs.getString(5),rs.getString(4)));
            }
            num_packet.setCellValueFactory(new PropertyValueFactory<Paquet,Integer>("num_paquet"));
            donnateur.setCellValueFactory(new PropertyValueFactory<Paquet,String>("donne_par"));
            date_don.setCellValueFactory(new PropertyValueFactory<Paquet,LocalDate>("date_de_Don"));
            type.setCellValueFactory(new PropertyValueFactory<Paquet,String>("type_donnation"));
            groupe_sanguin.setCellValueFactory(new PropertyValueFactory<Paquet,String>("sang"));

            listes_paquets.setItems(data);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void actualiser(){
        if (filtre.getSelectionModel().getSelectedItem() != null){
            remplireTable(filtre.getSelectionModel().getSelectedItem(),filtre_sang.getSelectionModel().getSelectedItem());
        }
    }

    public void verifierStock(){

        Db_handler db_handler=new Db_handler();
        String str;
        int values[]=new int[4];

        try {
            ResultSet rs=db_handler.execute_select("Select count(*) from stock "
                                                    +"where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 5 " +
                                                    "AND type_donnation='plaquette'");
            str="nombres de paquet de plaquettes périmé : "+rs.getInt(1)+" \n";
            values[0]=rs.getInt(1);

            rs=db_handler.execute_select("Select count(*) from stock "
                    +"where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 365 " +
                    "AND type_donnation='plasma'");
            str=str.concat("nombres de paquet de plasma périmé : "+rs.getInt(1)+" \n");
            values[1]=rs.getInt(1);

            rs=db_handler.execute_select("Select count(*) from stock "
                    +"where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 42 " +
                    "AND type_donnation='Concentre Globule Rouge'");

            str=str.concat("nombres de paquet de Concentre Globule Rouge périmé : "+rs.getInt(1)+" \n");
            values[2]=rs.getInt(1);

            rs=db_handler.execute_select("Select count(*) from stock "
                    +"where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 35 " +
                    "AND type_donnation='total'");
            str=str.concat("nombres de paquet de total périmé : "+rs.getInt(1)+" \n");
            values[3]=rs.getInt(1);

            Alert alert=new Alert(Alert.AlertType.INFORMATION, str,ButtonType.OK);
            alert.showAndWait();
            /*suppression des paquet périmé*/
            if (Arrays.stream(values).sum() != 0) {
                db_handler.execute_update("Delete from stock "
                        + "where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 5 " +
                        "AND type_donnation='plaquette'");
                db_handler.execute_update("Delete from stock "
                        + "where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 365 " +
                        "AND type_donnation='plasma'");
                db_handler.execute_update("Delete from stock "
                        + "where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 42 " +
                        "AND type_donnation='Concentre Globule Rouge'");
                db_handler.execute_update("Delete from stock "
                        + "where CAST((JulianDay() - JulianDay(date_de_Don)) As INTEGER) > 35 " +
                        "AND type_donnation='total'");
            }
            remplireTable("all","all");

        } catch (SQLException e) {
            e.printStackTrace();
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
