package fr.aamat.controller;

import fr.aamat.App;
import fr.aamat.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionController implements Initializable {

    @FXML private TextField apiculteur;
    @FXML private PasswordField password;

    @FXML private void handleConnexion() throws IOException {
        App.showStage("DashBoard");
        App.closeStage("Connection");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        apiculteur.setText("Gilles AMAT");
        password.setText("amapy");
    }

}
