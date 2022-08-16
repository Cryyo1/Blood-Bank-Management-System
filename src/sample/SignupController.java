package sample;

import Db_Handlers.Db_handler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

        @FXML
        private JFXTextField fullname;

        @FXML
        private JFXTextField username;

        @FXML
        private JFXTextField email;

        @FXML
        private JFXComboBox<String> groupe_sanguin;

        @FXML
        private JFXComboBox<String> Rh;

        @FXML
        private JFXPasswordField password;

        @FXML
        private JFXButton valider;

        @Override
        public void initialize(URL url, ResourceBundle rb) {

            Rh.setItems(FXCollections.observableArrayList(
                    "+","-"
            ));
            groupe_sanguin.setItems(FXCollections.observableArrayList(
                    "A","B","AB","O"
            ));

        }

        public void creeCompte(){
                try {
                        if(username.getText().length()>0 && password.getText().length()>0
                        && fullname.getText().length()>0 && groupe_sanguin.getSelectionModel().getSelectedItem().length()>0
                        && Rh.getSelectionModel().getSelectedItem().length()>0 && email.getText().length()>0) {
                                Db_handler db_handler = new Db_handler();
                                db_handler.execute_update("insert into users values('" + username.getText() + "','" + password.getText() + "','user')");
                                String bloodtype =groupe_sanguin.getSelectionModel().getSelectedItem() + Rh.getSelectionModel().getSelectedItem();
                                db_handler.execute_update("insert into preferenceProfile(nom_complet,email,groupesanguin,username)" +
                                        " values('" + fullname.getText() + "','" + email.getText() + "','" + bloodtype + "','" + username.getText() + "')");
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "compte cree veuillez connecter", ButtonType.OK);
                                alert.showAndWait();
                                Stage stage = (Stage) valider.getScene().getWindow();
                                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                                stage.setTitle("principale");
                                Scene scene = new Scene(root, 720, 464);
                                stage.setScene(scene);
                                stage.show();
                        }else{
                                Alert alert=new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs svp !! ", ButtonType.OK);
                                alert.showAndWait();
                        }

                }catch(Exception e){
                        Alert alert=new Alert(Alert.AlertType.ERROR, "une erreur s'est produite \n veuillez vérifier vos donnés et réessayer ", ButtonType.OK);
                        alert.showAndWait();
                }
        }
}
