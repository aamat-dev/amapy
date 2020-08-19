package fr.aamat.controller;

import fr.aamat.view.TabManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class ToolBarController extends AbstractController {
    private TabManager tabManager;

    public ToolBarController() {
    }

    @FXML
    private void handleRuchePane() {
        this.tabManager.addTab("RuchePane", "Ruches");
    }

    @FXML
    private void handleColoniePane() {
        this.tabManager.addTab("ColoniePane", "Colonies");
    }

    public void setTabManager(TabManager tabManager) {
        this.tabManager = tabManager;
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
