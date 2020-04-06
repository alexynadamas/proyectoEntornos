/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Victoria (1Daw)
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuButton menu2;
    @FXML
    private RadioButton hombre;
    @FXML
    private RadioButton mujer;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
    }

    @FXML
    private void seleccionSexo(ActionEvent event) {
    }

    @FXML
    private void andalucia(ActionEvent event) {
        menu.setText("Andalucía");
    }

    @FXML
    private void aragon(ActionEvent event) {
        menu.setText("Aragón");
    }

    @FXML
    private void castillaYLeon(ActionEvent event) {
        menu.setText("Catilla y León");
    }

    @FXML
    private void cataluña(ActionEvent event) {
        menu.setText("Cataluña");
    }

    @FXML
    private void comunidadValenciana(ActionEvent event) {
        menu.setText("Comunidad Valenciana");
    }

    @FXML
    private void galicia(ActionEvent event) {
        menu.setText("Galicia");
    }

    @FXML
    private void comunidadDeMadrid(ActionEvent event) {
        menu.setText("Comunidad de Madrid");
    }

    @FXML
    private void paisVasco(ActionEvent event) {
        menu.setText("País Vasco");
    }

}
