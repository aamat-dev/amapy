package fr.aamat.controller;

import fr.aamat.view.Vues;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static fr.aamat.view.StageManager.closeStage;
import static fr.aamat.view.StageManager.showStage;

public class ConnectionController extends AbstractController {

    @FXML private TextField apiculteur;
    @FXML private PasswordField password;

    @FXML private void handleConnexion() {
        showStage(Vues.MenuPrincipal);
        closeStage(Vues.Connection);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        apiculteur.setText("Gilles AMAT");
        password.setText("amapy");
    }

}
