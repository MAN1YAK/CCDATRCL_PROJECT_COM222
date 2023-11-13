package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FirstSceneController implements Initializable {

	@FXML
	private ImageView haircutView;

	@FXML
	private TextField name;

	@FXML
	private Button nextMain;

	Alert Error = new Alert(AlertType.ERROR);

	Parent root;
	Stage stage;
	Scene scene;

	DataSingleton data = DataSingleton.getInstance();
	String dialouge = "Please enter name";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		name.setPromptText("Enter Name");
		name.setFocusTraversable(false);
	}

	public void nextScene(ActionEvent event) throws IOException {

		Error.getDialogPane().getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		if (!name.getText().isBlank() && !name.getText().isEmpty()) {

			data.setUserName(name.getText());

			root = FXMLLoader.load(getClass().getResource("SecondScene.fxml"));
			stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);

			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.show();

		} else {
			// show error if there is no user input
			Error.setContentText(dialouge);
			Error.show();
			name.clear();
		}
	}

}

