package sample;

import Db_Handlers.Db_handler;
import System_Classes.Don;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import static sample.LoginController.profile;

public class HistoriqueController implements Initializable {

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
    private TableView<Don> listes_dons;

    @FXML
    private TableColumn<Don, Integer> num_don;

    @FXML
    private TableColumn<Don, Date> Date_don;

    @FXML
    private TableColumn<Don, String> Endroid_don;

    @FXML
    private TableColumn<Don, String> donneur;

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

    public void remplirTable(){
        ObservableList<Don> data = FXCollections.observableArrayList();
        try {
            Db_handler db_handler = new Db_handler();
            ResultSet resultSet = db_handler.execute_select("select num_don,date_don,hopital_name,nom_complet " +
                                                                    "from Don d,hopital h " +
                                                                    "WHERE d.id_hopital=h.hopital_id");
            while (resultSet.next()) {
                data.add(new Don(resultSet.getInt(1), LocalDate.parse(resultSet.getString(2)),
                        resultSet.getString(3),resultSet.getString(4)));
            }
            num_don.setCellValueFactory(new PropertyValueFactory<Don,Integer>("num_don"));
            Date_don.setCellValueFactory(new PropertyValueFactory<Don,Date>("date_don"));
            Endroid_don.setCellValueFactory(new PropertyValueFactory<Don,String>("Location"));
            donneur.setCellValueFactory(new PropertyValueFactory<Don,String>("nom_donneur"));

            listes_dons.setItems(data);

        }catch(Exception e){
            e.printStackTrace();
        }

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

}
