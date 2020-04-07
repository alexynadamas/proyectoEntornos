<<<<<<< HEAD
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica;

import conexion.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button enviar;
    @FXML
    private TextField edad;
    @FXML
    private Button total;
    @FXML
    private Label primero;
    @FXML
    private Label segundo;
    @FXML
    private Label tercero;
    @FXML
    private Label cuarto;
    @FXML
    private Label quinto;
    @FXML
    private Label partidoMasVotado;
    @FXML
    private MenuItem andalucia;
    @FXML
    private MenuItem aragon;
    @FXML
    private MenuItem castillaYLeon;
    @FXML
    private MenuItem catalunya;
    @FXML
    private MenuItem cValenciana;
    @FXML
    private MenuItem galicia;
    @FXML
    private MenuItem cMadrid;
    @FXML
    private MenuItem paisVasco;
    @FXML
    private MenuItem pp;
    @FXML
    private MenuItem psoe;
    @FXML
    private MenuItem ciudadanos;
    @FXML
    private MenuItem podemos;
    @FXML
    private MenuItem vox;

    private String sexo;
    private int anos;
    private String autonomia;
    private String partidoVotado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
        anos = Integer.parseInt(edad.getText());
        System.out.println(anos + autonomia + partidoVotado + sexo);
        Connection con = Conexion.conectar("entornos_db", "entornos_user", "6ejaipB9p3*yFcsJ");
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("INSERT INTO votos VALUES((SELECT MAX(V.Id)+1 FROM votos V),?,?,?,?)");
            stmt.setString(1, sexo);
            stmt.setInt(2, anos);
            stmt.setString(3, autonomia);
            stmt.setString(4, partidoVotado);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void seleccionSexoHombre(ActionEvent event) {
        sexo = hombre.getText();
        mujer.setSelected(false);
    }

    @FXML
    private void seleccionSexoMujer(ActionEvent event) {
        sexo = mujer.getText();
        hombre.setSelected(false);
    }

    @FXML
    private void sacarAutonomiaAndalucia(ActionEvent event) {
        menu.setText(andalucia.getText());
        autonomia = andalucia.getText();
    }

    @FXML
    private void sacarAutonomiaAragon(ActionEvent event) {
        menu.setText(aragon.getText());
        autonomia = aragon.getText();
    }

    @FXML
    private void sacarAutonomiaCastillaYLeon(ActionEvent event) {
        menu.setText(castillaYLeon.getText());
        autonomia = castillaYLeon.getText();
    }

    @FXML
    private void sacarAutonomiaCatalunya(ActionEvent event) {
        menu.setText(catalunya.getText());
        autonomia = catalunya.getText();
    }

    @FXML
    private void sacarAutonomiaCValenciana(ActionEvent event) {
        menu.setText(cValenciana.getText());
        autonomia = cValenciana.getText();
    }

    @FXML
    private void sacarAutonomiaGalicia(ActionEvent event) {
        menu.setText(galicia.getText());
        autonomia = galicia.getText();
    }

    @FXML
    private void sacarAutonomiaCMadrid(ActionEvent event) {
        menu.setText(cMadrid.getText());
        autonomia = cMadrid.getText();
    }

    @FXML
    private void sacarAutonomiaPaisVasco(ActionEvent event) {
        menu.setText(paisVasco.getText());
        autonomia = paisVasco.getText();
    }

    @FXML
    private void sacarPartidoPP(ActionEvent event) {
        menu2.setText(pp.getText());
        partidoVotado = pp.getText();
    }

    @FXML
    private void sacarPartidoPSOE(ActionEvent event) {
        menu2.setText(psoe.getText());
        partidoVotado = psoe.getText();
    }

    @FXML
    private void sacarPartidoCiudadanos(ActionEvent event) {
        menu2.setText(ciudadanos.getText());
        partidoVotado = ciudadanos.getText();
    }

    @FXML
    private void sacarPartidoPodemos(ActionEvent event) {
        menu2.setText(podemos.getText());
        partidoVotado = podemos.getText();
    }

    @FXML
    private void sacarPartidoVox(ActionEvent event) {
        menu2.setText(vox.getText());
        partidoVotado = vox.getText();
        System.out.println("Arriba españa");
    }

}
>>>>>>> Se añade el código: almacenar los datos en la base de datos
