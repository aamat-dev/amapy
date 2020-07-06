package fr.aamat.controller;

import fr.aamat.model.Ruche;
import fr.aamat.persistance.RucheDAO;
import fr.aamat.view.Vues;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static fr.aamat.view.StageManager.*;

public class MenuPrincipalController extends AbstractController {

    @FXML private TableView<Ruche> rucheList;
    @FXML private TableColumn<Ruche, String> rucheColumn;

    @FXML private void handleCloseApplication(){
        System.exit(0);
    }

    @FXML private void handleDeconnexion() {
        closeAllStage();
        showStage(Vues.Connection);
    }

    @FXML private void handleRuche() {
        showInDashboardStage(Vues.Ruche, BorderPanePosition.Right);
    }

    public void updateRucheList(){
        rucheList.getItems().clear();
        RucheDAO rucheDAO = new RucheDAO();
        rucheList.getItems().addAll(rucheDAO.findAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateRucheList();
        rucheColumn.setCellValueFactory(new PropertyValueFactory<Ruche, String>("nom"));

    }


}
