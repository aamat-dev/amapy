package fr.aamat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static HashMap<String, Stage> listStage = new HashMap<>();



    @Override
    public void start(Stage stage) throws IOException {
        showStage("Connection");
    }

    public static void showStage(String fxml) throws IOException {
        scene = new Scene(loadFXML(fxml));
        Stage stage = new Stage();
        stage.setScene(scene);
        listStage.put(fxml,stage);
        stage.show();
    }

   public static void closeStage(String fxml){
        Stage stage = listStage.get(fxml);
        if (stage != null) {
            stage.close();
            listStage.remove(fxml);
        }
    }

    public static void closeAllStage() {
        for (Stage stage: listStage.values()) {
            stage.close();
        }
        listStage.clear();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}