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
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SecondSceneController implements Initializable {
	@FXML
	private ImageView haircutView;
	@FXML
	private Label TotalAmount, HaircutChoosen;

	Parent root;
	Stage stage;
	Scene scene;

	DataSingleton data = DataSingleton.getInstance();
	LinkedList linkedList = data.getLinkedList();
	Alert Error = new Alert(AlertType.ERROR);

	// Setting item values
	private String HaircutN = "None", additionalN = "None";
	private double hairCutP = 0.00;
	private double additionalP = 0.00, TotalC = 0.00;

	// Setting images
	private Image myImage1 = new Image(getClass().getResourceAsStream("/HairStyles/ShopLogo.jpg"));

	private Image myImage2 = new Image(getClass().getResourceAsStream("/HairStyles/SonGoku.png"));

	private Image myImage3 = new Image(getClass().getResourceAsStream("/HairStyles/Dreamworks.png"));

	private Image myImage4 = new Image(getClass().getResourceAsStream("/HairStyles/Kim____Un.png"));

	private Image myImage5 = new Image(getClass().getResourceAsStream("/HairStyles/Krillin.png"));

	private Image myImage6 = new Image(getClass().getResourceAsStream("/HairStyles/Mein Fuhrer.png"));

	private Image myImage7 = new Image(getClass().getResourceAsStream("/HairStyles/Steve.png"));

	private Image myImage8 = new Image(getClass().getResourceAsStream("/HairStyles/Pepe.png"));

	public void defaultImage(MouseEvent e) {
		haircutView.setImage(myImage1);
	}

	// Display/Select Haircut "SonGoku"
	public void displayImage1(MouseEvent e) {
		haircutView.setImage(myImage2);
	}

	public void selectImage1(MouseEvent e) {
		HaircutN = "SonGoku";
		hairCutP = 90.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	// Display/Select Haircut "Krillin"
	public void displayImage2(MouseEvent e) {
		haircutView.setImage(myImage3);
	}

	public void selectImage2(MouseEvent e) {
		HaircutN = "Krillin";
		hairCutP = 70.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	// Display/Select Haircut "Steve"
	public void displayImage3(MouseEvent e) {
		haircutView.setImage(myImage4);

	}

	public void selectImage3(MouseEvent e) {
		HaircutN = "Steve";
		hairCutP = 100.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	// Display Select Haircut "Dreamworks"
	public void displayImage4(MouseEvent e) {
		haircutView.setImage(myImage5);
	}

	public void selectImage4(MouseEvent e) {
		HaircutN = "DreamWorks";
		hairCutP = 100.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	// Display/Select Haircut "Mein Fuhrer"
	public void displayImage5(MouseEvent e) {
		haircutView.setImage(myImage6);
	}

	public void selectImage5(MouseEvent e) {
		HaircutN = "Mein Fuhrer";
		hairCutP = 80.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	// "Display/Select Haircut "Park So Jun"
	public void displayImage6(MouseEvent e) {
		haircutView.setImage(myImage7);
	}

	public void selectImage6(MouseEvent e) {
		HaircutN = "Kim____Un";
		hairCutP = 70.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	public void displayImage7(MouseEvent e) {
		haircutView.setImage(myImage8);
	}

	// Display/Select Hairstyle "Rizal"
	public void selectImage7(MouseEvent e) {
		HaircutN = "Pepe";
		hairCutP = 80.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	public void selectImageA1(MouseEvent e) {
		additionalN = "Shave";
		additionalP = 50.00;
		TotalC = hairCutP + additionalP;

		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	public void selectImageA2(MouseEvent e) {
		additionalN = "Facial";
		additionalP = 80.00;
		TotalC = hairCutP + additionalP;

		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	public void Clear(ActionEvent e) {
		HaircutN = "None";
		additionalN = "None";
		hairCutP = 0.00;
		additionalP = 0.00;
		TotalC = hairCutP + additionalP;

		HaircutChoosen.setText(HaircutN);
		haircutView.setImage(myImage1);
		TotalAmount.setText(String.valueOf("P" + TotalC));
	}

	public void changeScene(ActionEvent event) throws IOException {

		String dialouge = "Please pick a haircut!";

		if (!HaircutN.equals("None")) {

			data.setHairCut(HaircutN);
			data.setAdditional(additionalN);
			data.setTotalCost(TotalC);

			root = FXMLLoader.load(getClass().getResource("ThirdScene.fxml"));
			stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.show();

		} else {
			Error.setAlertType(AlertType.ERROR);
			Error.setContentText(dialouge);
			Error.show();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Error.getDialogPane().getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	}
}
