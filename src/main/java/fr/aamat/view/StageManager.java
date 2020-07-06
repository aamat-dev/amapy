package fr.aamat.view;

import fr.aamat.App;
import fr.aamat.controller.AbstractController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class StageManager {

    private static HashMap<Vues, Stage> listStage = new HashMap<>();
    private static HashMap<Vues, AbstractController> listController = new HashMap<>();

    public static void showStage(Vues fxml) {
        Scene scene = new Scene(loadFXML(fxml));
        Stage stage = new Stage();
        stage.setScene(scene);
        listStage.put(fxml, stage);
        stage.show();
    }

    public enum BorderPanePosition {
        Top, Left, Right, Bottom, Center
    }


    public static void loadInDashboardStage(BorderPanePosition position, Node node) {
        Stage stage = listStage.get(Vues.MenuPrincipal);
        BorderPane borderPane = (BorderPane) stage.getScene().getRoot();
        switch (position) {
            case Center:
                borderPane.setCenter(node);
                break;
            case Top:
                borderPane.setTop(node);
                break;
            case Left:
                borderPane.setLeft(node);
                break;
            case Right:
                borderPane.setRight(node);
                break;
            case Bottom:
                borderPane.setBottom(node);
                break;
        }
    }

    public static void showInDashboardStage(Vues fxml, BorderPanePosition position) {
            Parent root = loadFXML(fxml);
            loadInDashboardStage(position,root);
    }

    public static void hideInDashboardStage(BorderPanePosition position) {
        loadInDashboardStage(position,null);
    }

    public static void closeStage(Vues fxml) {
        Stage stage = listStage.get(fxml);
        if (stage != null) {
            stage.close();
            listStage.remove(fxml);
        }
    }

    public static void closeAllStage() {
        for (Stage stage : listStage.values()) {
            stage.close();
        }
        listStage.clear();
    }

    private static Parent loadFXML(Vues fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));
        try {
            Parent root = fxmlLoader.load();
            AbstractController controller = fxmlLoader.getController();
            listController.put(fxml, controller);

            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AbstractController getController(Vues fxml) {
        AbstractController controller = listController.get(fxml);
        return controller;
    }
}
