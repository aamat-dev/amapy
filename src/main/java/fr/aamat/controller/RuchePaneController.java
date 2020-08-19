package fr.aamat.controller;

import fr.aamat.model.Ruche;
import fr.aamat.persistance.RucheDAO;
import fr.aamat.view.ConfirmStage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class RuchePaneController extends AbstractController {
    private RucheDAO rucheDAO = new RucheDAO();
    private ObservableList<Ruche> listDataRuches;
    private Ruche ruche;
    @FXML
    private TextField rechercheBox;
    @FXML
    private ListView<Ruche> listRuches;
    @FXML
    private TextField nomRuche;
    @FXML
    private TextField emplacementRuche;
    @FXML
    private TextArea descriptionRuche;
    @FXML
    private ImageView imageRuche;

    public RuchePaneController() {
    }

    @FXML
    private void handleAjouterRuche() {
        this.listRuches.getSelectionModel().clearSelection();
        this.ruche = new Ruche();
        this.ruche.setNom("Ruche n°" + this.rucheDAO.nextID());
        this.updateCard(this.ruche);
    }

    @FXML
    private void handleSupprimerRuche() {
        Ruche ruche = this.listRuches.getSelectionModel().getSelectedItem();
        if (ruche != null) {
            ConfirmStage confirmStage = new ConfirmStage("Etes-vous sûr de vouloir supprimer cette ruche");
            if (confirmStage.getAnswer()) {
                RucheDAO rucheDAO = new RucheDAO();
                rucheDAO.delete(ruche);
                this.listDataRuches.remove(ruche);
            }
        }

    }

    @FXML
    private void handleSave() {
        if (this.isInputValid()) {
            this.ruche.setDescription(this.descriptionRuche.getText());
            this.ruche.setEmplacement(this.emplacementRuche.getText());
            this.ruche.setNom(this.nomRuche.getText());
            if (this.ruche.getId() == null) {
                this.rucheDAO.create(this.ruche);
            } else {
                this.rucheDAO.update(this.ruche);
            }

            this.updateList();
            this.listRuches.getSelectionModel().select(this.ruche);
        }

    }

    @FXML
    private void handleImage() {
        FileChooser fileChooser = new FileChooser();
        ExtensionFilter extFilterJPG = new ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        ExtensionFilter extFilterPNG = new ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            this.ruche.setUrlImage(file.toURI().toString());
            Image image = new Image(this.ruche.getUrlImage());
            this.imageRuche.setImage(image);
        }

    }

    private boolean isInputValid() {
        boolean test = true;
        if (this.nomRuche.getText() == null || this.nomRuche.getText().length() == 0) {
            test = false;
            this.nomRuche.getStyleClass().add("inputInvalide");
            Tooltip tooltip = new Tooltip("Nom manquant");
            tooltip.setShowDelay(Duration.ZERO);
            this.nomRuche.setTooltip(tooltip);
        }

        return test;
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.updateList();
        this.listRuches.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.updateCard(newValue));
        this.listRuches.getSelectionModel().selectFirst();
        this.resetInputInvalide();
    }

    private void resetInputInvalide() {
        this.nomRuche.textProperty().addListener((observable) -> this.nomRuche.getStyleClass().removeIf((s) -> {
            return s.equals("inputInvalide");
        }));
    }

    private void updateCard(Ruche ruche) {
        if (ruche != null) {
            this.ruche = ruche;
            this.nomRuche.setText(this.ruche.getNom());
            this.emplacementRuche.setText(this.ruche.getEmplacement());
            this.descriptionRuche.setText(this.ruche.getDescription());
            if (this.ruche.getUrlImage() == null) {
                this.imageRuche.setImage(new Image("/img/ruche_default.jpg"));
            } else {
                this.imageRuche.setImage(new Image(this.ruche.getUrlImage()));
            }
        }

    }

    private void updateList() {
        this.listDataRuches = this.rucheDAO.findAll();
        FilteredList<Ruche> filteredData = new FilteredList(this.listDataRuches, (p) -> true);
        this.rechercheBox.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate((ruche) -> {
            if (newValue != null && !newValue.isEmpty()) {
                String lowerCaseFilter = newValue.toLowerCase();
                if (ruche.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return ruche.getEmplacement().toLowerCase().contains(lowerCaseFilter);
                }
            } else {
                return true;
            }
        }));
        SortedList<Ruche> sortedData = new SortedList(filteredData);
        this.listRuches.setItems(sortedData);
        this.listRuches.refresh();
    }
}
