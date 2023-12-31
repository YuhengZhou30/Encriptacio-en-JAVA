package com.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EncriptarC implements Initializable {

    @FXML
    private Button Encriptar,Tornar;
    @FXML
    private TextField CPU_Path,ArchivoPath,DestinoPath;
    @FXML
    private Text textMostrar;

    @FXML
    private void tornar (ActionEvent event) {
        UtilsViews.setViewAnimating("Principal");
    }

    @FXML
    private void encriptar(ActionEvent event) {
        String clavePublica = CPU_Path.getText();
        String archivoACifrar = ArchivoPath.getText();
        String archivoCifrado = DestinoPath.getText();

        try {
            textMostrar.setText("Encriptat correctament !!!");
            ejecutarComando("gpg --encrypt --recipient " + clavePublica + " --output " + archivoCifrado + " " + archivoACifrar);
        } catch (Exception e) {
            textMostrar.setText("ERROR !!!!!");
        }

        textMostrar.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textMostrar.setVisible(false);
    }

    private static void ejecutarComando(String comando) throws Exception {
            Process process = Runtime.getRuntime().exec(comando);
            process.waitFor();
    }
}
