package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
			FXMLLoader.load(getClass().getResource("SecondScene.fxml"));
			FXMLLoader.load(getClass().getResource("ThirdScene.fxml"));
			
			Scene scene = new Scene(root);

			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);

			Image myImage1 = new Image(getClass().getResourceAsStream("/HairStyles/ShopLogo.jpg"));
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ST.Peter's Cut");
			primaryStage.getIcons().add(myImage1);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
