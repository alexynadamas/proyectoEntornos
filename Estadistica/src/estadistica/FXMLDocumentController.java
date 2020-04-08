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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javax.swing.JOptionPane;

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
    @FXML
    private Label partidoMasVotado1;
    @FXML
    private Label votosTotales;
    
    private String sexo;
    private int anos;
    private String autonomia;
    private String partidoVotado;
    
    String serverdb = "37.187.137.24";
    String nombredb = "entornos_db";
    String userdb = "entornos_user";
    String passdb = "6ejaipB9p3*yFcsJ";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Ejecuta un INSERT en la base de datos con los valores recopilados del
     * formulario
     *
     * @param event
     */
    @FXML
    private void enviarInformacion(ActionEvent event) {
        anos = Integer.parseInt(edad.getText());
        System.out.println(anos + autonomia + partidoVotado + sexo);
        Connection con = Conexion.conectar(serverdb, nombredb, userdb, passdb);
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("INSERT INTO votos VALUES((SELECT MAX(V.Id)+1 FROM votos V),?,?,?,?);");
            stmt.setString(1, sexo);
            stmt.setInt(2, anos);
            stmt.setString(3, autonomia);
            stmt.setString(4, partidoVotado);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han enviado los datos correctamente.");
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

    /**
     * Calcula el porcentaje de voto de cada partido y los muestra en la
     * interfaz gráfica
     *
     * @param event
     */
    @FXML
    private void pestanyaEstadistica(Event event) {
        PartidoPolitico partidoPp = new PartidoPolitico("PP");
        PartidoPolitico partidoPsoe = new PartidoPolitico("PSOE");
        PartidoPolitico partidoCiudadanos = new PartidoPolitico("Ciudadanos");
        PartidoPolitico partidoPodemos = new PartidoPolitico("PODEMOS");
        PartidoPolitico partidoVox = new PartidoPolitico("VOX");

        PartidoPolitico[] partidos = new PartidoPolitico[5];
        partidos[0] = partidoPp;
        partidos[1] = partidoPsoe;
        partidos[2] = partidoCiudadanos;
        partidos[3] = partidoPodemos;
        partidos[4] = partidoVox;

        Connection con = Conexion.conectar(serverdb, nombredb, userdb, passdb);
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("SELECT partidoVotado FROM votos;");
            ResultSet rs = stmt.executeQuery();
            PartidoPolitico.setNumVotosTotales(0);
            while (rs.next()) {
                String partido = rs.getString("partidoVotado");
                System.out.println(partido);
                switch (partido) {
                    case "PP":
                        partidoPp.anyadirVoto();
                        break;
                    case "PSOE":
                        partidoPsoe.anyadirVoto();
                        break;
                    case "Ciudadanos":
                        partidoCiudadanos.anyadirVoto();
                        break;
                    case "PODEMOS":
                        partidoPodemos.anyadirVoto();
                        break;
                    case "VOX":
                        partidoVox.anyadirVoto();
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Arrays.sort(partidos);  // Ordenar el Array de mayor a menor por cantidad de votos

        // Se cambian las etiquetas en la interfaz gráfica
        partidoMasVotado.setText(partidos[0].toString());
        primero.setText(partidos[0].toString());
        segundo.setText(partidos[1].toString());
        tercero.setText(partidos[2].toString());
        cuarto.setText(partidos[3].toString());
        quinto.setText(partidos[4].toString());
        String aux = Integer.toString(PartidoPolitico.getNumVotosTotales()); 
        votosTotales.setText(aux + " votos");
    }

}
