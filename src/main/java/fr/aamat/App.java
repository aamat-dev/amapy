package fr.aamat;

import fr.aamat.controller.ToolBarController;
import fr.aamat.view.MainView;
import fr.aamat.view.StageManager;
import fr.aamat.view.TabManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public App() {
    }

    public void start(Stage stage) {
        StageManager stageManager = new StageManager();
        MainView mainView = new MainView();
        VBox menuBar = (VBox)stageManager.loadFXML("MenuBar");
        mainView.setTop(menuBar);
        TabManager tabManager = new TabManager(mainView, stageManager);
        ToolBarController controller = (ToolBarController)stageManager.getController("MenuBar");
        controller.setTabManager(tabManager);
        Scene scene = new Scene(mainView, 1000.0D, 800.0D);
        stage.setMinWidth(1000.0D);
        stage.setMinHeight(800.0D);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
