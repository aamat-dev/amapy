package fr.aamat.view;

import fr.aamat.App;
import fr.aamat.controller.AbstractController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager {
    private Map<String, AbstractController> listController = new HashMap();

    public StageManager() {
    }

    public Parent loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));

        try {
            Parent root = fxmlLoader.load();
            AbstractController controller = fxmlLoader.getController();
            this.listController.put(fxml, controller);
            return root;
        } catch (IOException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public void launchStage(Scene scene) {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public AbstractController getController(String fxml) {
        return this.listController.get(fxml);
    }
}
