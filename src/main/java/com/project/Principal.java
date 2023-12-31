package com.project;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class Principal {

    @FXML
    private Button Encriptar, Desencriptar;

    @FXML
    private void encriptar(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void desencriptar(ActionEvent event) {
        UtilsViews.setViewAnimating("View2");
    }
}
