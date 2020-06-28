package fr.aamat.controller;

import fr.aamat.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML private void handleCloseApplication(){
        System.exit(0);
    }
    @FXML private void handleDeconnexion() throws IOException {
        App.closeAllStage();
        App.showStage("Connection");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
