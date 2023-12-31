package com.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DesencriptarC implements Initializable {

    @FXML
    private Button Desencriptar,Tornar;
    @FXML
    private TextField CPR_Path,ArchivoPath_des,DestinoPath,Contrasenya;

    @FXML
    private Text textMostrar;

    @FXML
    private void tornar (ActionEvent event) {
        UtilsViews.setViewAnimating("Principal");
    }

    @FXML
    private void desencriptar(ActionEvent event) {
        String archivoCifrado = ArchivoPath_des.getText();
        String clavePrivada = CPR_Path.getText();
        String contrasena = Contrasenya.getText();
        String archivoDescifrado = DestinoPath.getText();

        String comando = "gpg --decrypt --passphrase " + contrasena + " --output " + archivoDescifrado + " --batch --yes --armor " + archivoCifrado;

        if (!clavePrivada.isEmpty()) {
            comando += " --secret-keyring " + clavePrivada;
        }

        try {
            textMostrar.setText("Desencriptat correctament !!!");
            ejecutarComando(comando);
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
