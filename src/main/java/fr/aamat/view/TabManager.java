package fr.aamat.view;

import fr.aamat.controller.AbstractController;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabManager extends TabPane {
    private TabPane tabPane;
    private StageManager stageManager;
    private List<String> listTabs = new ArrayList();

    public TabManager(MainView mainView, StageManager stageManager) {
        this.stageManager = stageManager;
        this.tabPane = new TabPane();
        this.tabPane.getStylesheets().add("/style/globalStyle.css");
        this.tabPane.getStylesheets().add("/style/tabPaneStyle.css");
        mainView.setCenter(this.tabPane);
        this.tabPane.prefWidthProperty().bind(mainView.widthProperty());
        this.tabPane.prefHeightProperty().bind(mainView.heightProperty());
    }

    public void addTab(String fxml, String titre) {
        if (!this.listTabs.contains(fxml)) {
            Tab tab = new Tab(titre);
            tab.setContent(this.stageManager.loadFXML(fxml));
            this.tabPane.getTabs().add(tab);
            this.listTabs.add(fxml);
            AbstractController controller = this.stageManager.getController(fxml);
            controller.setStageManager(this.stageManager);
            tab.setOnClosed((event) -> this.listTabs.remove(fxml));
        }

    }

    public StageManager getStageManager() {
        return this.stageManager;
    }
}
