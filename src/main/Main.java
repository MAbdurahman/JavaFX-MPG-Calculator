package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        try {
            Image icon = new Image(Main.class.getResourceAsStream("/img/miles-per-gallon-icon.png"));
            primaryStage.getIcons().add(icon);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        primaryStage.setTitle(" JavaFX- MPG-Calculator");
        primaryStage.setScene(new Scene(root, 600, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
