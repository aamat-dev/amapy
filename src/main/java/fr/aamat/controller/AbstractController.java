package fr.aamat.controller;

import fr.aamat.view.StageManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public abstract class AbstractController implements Initializable {
    private StageManager stageManager;

    public AbstractController() {
    }

    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
