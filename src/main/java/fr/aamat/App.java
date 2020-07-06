package fr.aamat;

import fr.aamat.view.Vues;
import javafx.application.Application;
import javafx.stage.Stage;

import static fr.aamat.view.StageManager.showStage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) {
        showStage(Vues.Connection);
    }


    public static void main(String[] args) {
        launch();
    }

}