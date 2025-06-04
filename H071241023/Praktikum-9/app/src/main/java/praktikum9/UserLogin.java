package praktikum9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.File;
import java.net.URL;

public class UserLogin extends Application {
    public Image uploadedImage;

    @Override
    public void start(Stage stage) {

        Label labelJudul = new Label("Input User Account");
        labelJudul.setId("judul");

        Label labelWarning = new Label("Harap isi semua field!");
        labelWarning.setStyle("-fx-text-fill: red");
        labelWarning.setVisible(true);

        Label labelNickName = new Label("Nick Name:");
        TextField fieldNickName = new TextField();
        fieldNickName.setPromptText("Input Nickname!");
        labelNickName.getStyleClass().add("form-label");
        fieldNickName.getStyleClass().add("form-input");

        Label labelFullName = new Label("Full Name:");
        TextField fieldFullName = new TextField();
        fieldFullName.setPromptText("Input Fullname!");
        labelFullName.getStyleClass().add("form-label");
        fieldFullName.getStyleClass().add("form-input");

        HBox nickName = new HBox(10, labelNickName, fieldNickName);
        nickName.setAlignment(Pos.CENTER);
        nickName.getStyleClass().add("form-row");

        HBox fullName = new HBox(10, labelFullName, fieldFullName);
        fullName.setAlignment(Pos.CENTER);
        fullName.getStyleClass().add("form-row");

        Image defaultImage = new Image(getClass().getResource("/images/profile.jpg").toExternalForm());

        ImageView imageView = new ImageView(defaultImage);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(false);
        imageView.setClip(new Circle(50, 50, 50));
        imageView.getStyleClass().add("profile-image");

        Button btnUpload = new Button("Upload Photo");
        Button btnSubmit = new Button("Submit");
        btnSubmit.setDisable(true);
        btnUpload.getStyleClass().add("button-form");
        btnSubmit.getStyleClass().add("button-form");

        btnUpload.setOnAction(e -> { //event handlerrr
            if (!fieldNickName.getText().trim().isEmpty() && !fieldFullName.getText().trim().isEmpty()) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Pilih Foto");
                fileChooser.getExtensionFilters()
                        .add(new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    uploadedImage = new Image(selectedFile.toURI().toString());
                    imageView.setImage(uploadedImage);
                    checkAllInputs(fieldNickName, fieldFullName, btnSubmit, uploadedImage);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Form tidak lengkap");
                alert.setHeaderText(null);
                alert.setContentText("Isi Nickname dan Fullname terlebih dahulu!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
                dialogPane.getStyleClass().add("custom-alert");
                alert.showAndWait();
            }
        });
        
        HBox buttonBox = new HBox(20, btnUpload, btnSubmit);
        buttonBox.setAlignment(Pos.CENTER);

        VBox mainContent = new VBox(15, labelJudul, nickName, fullName, imageView, buttonBox, labelWarning);
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new Insets(20));

        BorderPane layout1 = new BorderPane(mainContent);
        layout1.getStyleClass().add("root");
        Scene scene1 = new Scene(layout1, 600, 500);
        
        ImageView imageViewHome = new ImageView(defaultImage);
        imageViewHome.setFitWidth(100);
        imageViewHome.setFitHeight(100);
        imageViewHome.setPreserveRatio(false);
        imageViewHome.setClip(new Circle(50, 50, 50));
        
        Label labelNickDisplay = new Label();
        Label labelFullDisplay = new Label();
        
        VBox textInfoBox = new VBox(8, labelNickDisplay, labelFullDisplay);
        textInfoBox.setAlignment(Pos.CENTER_LEFT);
        
        HBox contentHome = new HBox(20, imageViewHome, textInfoBox);
        contentHome.setAlignment(Pos.CENTER_LEFT);
        contentHome.setPadding(new Insets(20));
        
        Button btnUploadPost = new Button("Add Post");
        Button btnKembali = new Button("Back");
        btnUploadPost.getStyleClass().add("button-form");
        btnKembali.getStyleClass().add("button-form");
        
        HBox topButtons = new HBox(20, btnKembali, btnUploadPost);
        topButtons.setAlignment(Pos.CENTER);
        
        TilePane postContainer = new TilePane();
        postContainer.setHgap(10);
        postContainer.setVgap(10);
        postContainer.setPadding(new Insets(10));
        postContainer.setPrefColumns(3);
        postContainer.setAlignment(Pos.CENTER);
        postContainer.setPrefWidth(500);
        postContainer.getStyleClass().add("tile-pane");
        
        ScrollPane scrollPane = new ScrollPane(postContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(300);

        btnUploadPost.setOnAction(e -> {
            Stage postStage = new Stage();
            postStage.setTitle("Upload Post");

            ImageView postImagePreview = new ImageView();
            postImagePreview.setFitWidth(200);
            postImagePreview.setFitHeight(200);
            postImagePreview.setPreserveRatio(true);

            Button btnChooseImage = new Button("Choose Image");
            TextArea captionArea = new TextArea();
            captionArea.setPromptText("Caption:");
            captionArea.getStyleClass().add("text-area");
            Button btnSubmitPost = new Button("Post!");
            btnSubmitPost.getStyleClass().add("button-form");

            btnChooseImage.setOnAction(ev -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(
                        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
                File selectedFile = fileChooser.showOpenDialog(postStage);
                if (selectedFile != null) {
                    Image postImage = new Image(selectedFile.toURI().toString());
                    postImagePreview.setImage(postImage);
                    btnSubmitPost.setUserData(postImage);
                }
            });

            btnSubmitPost.setOnAction(ev -> {
                Image img = (Image) btnSubmitPost.getUserData();
                String captionText = captionArea.getText();

                if (img != null && !captionText.isEmpty()) {
                    StackPane imageStack = new StackPane();
                    ImageView imgView = new ImageView(img);
                    imgView.setFitWidth(150);
                    imgView.setFitHeight(150);
                    imgView.setPreserveRatio(false);

                    Rectangle clip = new Rectangle(150, 150);
                    clip.setArcWidth(20);
                    clip.setArcHeight(20);
                    imgView.setClip(clip);

                    StackPane captionOverlay = new StackPane();
                    captionOverlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8);");
                    captionOverlay.setVisible(false);
                    captionOverlay.setMaxSize(150, 150);

                    Label captionLabel = new Label(captionText);
                    captionLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px;");
                    captionLabel.setWrapText(true);

                    captionOverlay.getChildren().add(captionLabel);
                    captionOverlay.setAlignment(Pos.CENTER);

                    imageStack.getChildren().addAll(imgView, captionOverlay);

                    imageStack.setOnMouseEntered(event -> {
                        captionOverlay.setVisible(true);
                        ScaleTransition st = new ScaleTransition(Duration.millis(150), imageStack);
                        st.setToX(1.05);
                        st.setToY(1.05);
                        st.play();
                    });

                    imageStack.setOnMouseExited(event -> {
                        captionOverlay.setVisible(false);
                        ScaleTransition st = new ScaleTransition(Duration.millis(150), imageStack);
                        st.setToX(1.0);
                        st.setToY(1.0);
                        st.play();
                    });

                    imageStack.setOnMouseClicked(event -> {
                        Stage previewStage = new Stage();
                        ImageView preview = new ImageView(img);
                        preview.setPreserveRatio(true);
                        preview.setFitWidth(400);
                        preview.setFitHeight(400);
                        VBox previewBox = new VBox(preview);
                        previewBox.setAlignment(Pos.CENTER);
                        previewBox.setPadding(new Insets(20));
                        Scene previewScene = new Scene(previewBox, 450, 450);
                        previewStage.setScene(previewScene);
                        previewStage.setTitle("Image Preview");
                        previewStage.show();
                    });
                    
                    VBox postBox = new VBox(imageStack);
                    postBox.setStyle(
                            "-fx-padding: 10; -fx-border-color: transparent; -fx-border-radius: 8; -fx-background-radius: 8;");
                    postBox.setAlignment(Pos.CENTER);

                    postContainer.getChildren().add(postBox);
                    postStage.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText(null);
                    alert.setContentText("Isi caption terlebih dahulu!");

                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
                    dialogPane.getStyleClass().add("custom-alert");
                    alert.showAndWait();
    }
            });

            VBox layoutPost = new VBox(10, btnChooseImage, postImagePreview, captionArea, btnSubmitPost);
            layoutPost.setAlignment(Pos.CENTER);
            layoutPost.setPadding(new Insets(15));
            layoutPost.getStyleClass().add("root");

            Scene postScene = new Scene(layoutPost, 300, 400);
            postScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
            postStage.setScene(postScene);
            postStage.initOwner(stage);
            postStage.show();
        });

        VBox layoutHome = new VBox(30, contentHome, topButtons, scrollPane);
        layoutHome.setAlignment(Pos.TOP_CENTER);
        layoutHome.setPrefHeight(700);
        layoutHome.setPadding(new Insets(20));
        layoutHome.getStyleClass().add("root");
        Scene sceneHome = new Scene(layoutHome, 600, 500);
        
        URL cssUrl = getClass().getResource("/style.css");
        if (cssUrl != null) {
            scene1.getStylesheets().add(cssUrl.toExternalForm());
            sceneHome.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.out.println("style.css not found!");
        }
        
        btnSubmit.setOnAction(event -> {
            String nickname = fieldNickName.getText().trim();
            String fullname = fieldFullName.getText().trim();

            imageViewHome.setImage(uploadedImage);
            labelNickDisplay.setText(nickname);
            labelFullDisplay.setText(fullname);
            labelNickDisplay.getStyleClass().add("label-bio-display");
            labelFullDisplay.getStyleClass().add("label-bio-display");
            stage.setScene(sceneHome);
        });

        fieldNickName.textProperty().addListener((obs, oldText, newText) -> {
            checkAllInputs(fieldNickName, fieldFullName, btnSubmit, uploadedImage);
        });

        fieldFullName.textProperty().addListener((obs, oldText, newText) -> {
            checkAllInputs(fieldNickName, fieldFullName, btnSubmit, uploadedImage);
        });


        btnKembali.setOnAction(e -> stage.setScene(scene1));

        stage.setTitle("My Moment");
        stage.setScene(scene1);
        stage.show();
    }
    
    private void checkAllInputs(TextField fieldNickName, TextField fieldFullName, Button btnSubmit, Image uploadedImage) {
        boolean allFilled = !fieldNickName.getText().trim().isEmpty()
                && !fieldFullName.getText().trim().isEmpty()
                && uploadedImage != null;

        btnSubmit.setDisable(!allFilled);
    }

    public static void main(String[] args) {
        launch(args);
    }
}