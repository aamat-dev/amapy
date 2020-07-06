package fr.aamat.controller;

import fr.aamat.model.Ruche;
import fr.aamat.persistance.RucheDAO;
import fr.aamat.view.StageManager;
import fr.aamat.view.Vues;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static fr.aamat.view.StageManager.getController;
import static fr.aamat.view.StageManager.hideInDashboardStage;

public class RucheController extends AbstractController {

    @FXML private TextField nomBox;
    @FXML private TextArea descriptionBox;

    @FXML private void handleHide(){
        hideInDashboardStage(StageManager.BorderPanePosition.Right);
    }

    @FXML private void handleValidation(){

        Ruche ruche = new Ruche();
        ruche.setNom(nomBox.getText());
        ruche.setDescription(descriptionBox.getText());

        RucheDAO rucheDAO = new RucheDAO();
        rucheDAO.create(ruche);

        MenuPrincipalController menuPrincipalController = (MenuPrincipalController) getController(Vues.MenuPrincipal);
        menuPrincipalController.updateRucheList();

        hideInDashboardStage(StageManager.BorderPanePosition.Right);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
