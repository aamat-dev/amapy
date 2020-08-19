package fr.aamat.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ConfirmStage extends Stage {
    private double xOffset = 0.0D;
    private double yOffset = 0.0D;
    private Boolean answer = null;
    private VBox root = new VBox();

    public ConfirmStage(String instruction) {
        this.root.setMinWidth(450.0D);
        this.root.setAlignment(Pos.CENTER);
        this.root.getStylesheets().add("/style/globalStyle.css");
        this.root.getStylesheets().add("/style/confirmStageStyle.css");
        Label label = new Label(instruction);
        label.setId("instruction");
        Button okBtn = new Button("Valider");
        okBtn.setId("okBtn");
        Button koBtn = new Button("Annuler");
        koBtn.setId("koBtn");
        HBox alignBtn = new HBox();
        alignBtn.setAlignment(Pos.CENTER_RIGHT);
        alignBtn.getChildren().addAll(okBtn, koBtn);
        this.root.getChildren().addAll(label, alignBtn);
        Scene scene = new Scene(this.root);
        scene.setFill(Color.TRANSPARENT);
        this.setScene(scene);
        this.initStyle(StageStyle.TRANSPARENT);
        this.initModality(Modality.APPLICATION_MODAL);
        scene.widthProperty().addListener((observable, oldValue, newValue) -> this.setWidth((Double)newValue));
        okBtn.setOnAction((event) -> this.animDialogueStage(true));
        koBtn.setOnAction((event) -> this.animDialogueStage(false));
        scene.setOnMousePressed((event) -> {
            this.xOffset = event.getSceneX();
            this.yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged((event) -> {
            this.setX(event.getScreenX() - this.xOffset);
            this.setY(event.getScreenY() - this.yOffset);
        });
        this.showAndWait();
    }

    private void animDialogueStage(Boolean valide) {
        this.answer = valide;
        String url;
        String classe;
        short angle;
        if (valide) {
            url = "/img/cocheOk.png";
            classe = "ok";
            angle = 360;
        } else {
            url = "/img/cocheKo.png";
            classe = "ko";
            angle = 180;
        }

        this.root.getChildren().clear();
        this.setWidth(125.0D);
        this.setX(this.getX() + this.getWidth() / 2.0D);
        ImageView image = new ImageView(new Image(url));
        image.setFitHeight(70.0D);
        image.setFitWidth(70.0D);
        this.root.getChildren().add(image);
        this.root.getStyleClass().add(classe);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(image.rotateProperty(), (int) angle);
        KeyFrame kf = new KeyFrame(Duration.millis(700.0D), kv);
        KeyValue kv2 = new KeyValue(image.rotateProperty(), (int) angle);
        KeyFrame kf2 = new KeyFrame(Duration.millis(1000.0D), kv2);
        timeline.getKeyFrames().add(kf);
        timeline.getKeyFrames().add(kf2);
        timeline.play();
        timeline.setOnFinished((event) -> this.close());
    }

    public Boolean getAnswer() {
        return this.answer;
    }
}
