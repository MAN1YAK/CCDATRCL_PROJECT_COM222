package application;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ThirdSceneController implements Initializable {

	@FXML
	private Label infoLabel;
	@FXML
	private Label SearchNameLabel;
	@FXML
	private Label SearchHairLabel;
	@FXML
	private Label SearchAdditonalLabel;
	@FXML
	private Label TotalCostLabel;
	@FXML
	private TextField searchCustomer;
	@FXML
	private TextField deleteCustomer;
	@FXML
	private ImageView imageView3;

	public int searchNumber;
	private Image myImage1;

	private Parent root;
	private Stage stage;
	private Scene scene;

	private DataSingleton data = DataSingleton.getInstance();
	private LinkedList linkedList = data.getLinkedList();
	private Calendar calendar = data.getCal();

	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("EEEE hh:mm a");

	private Alert Error = new Alert(AlertType.NONE);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// set reservation time
		date = calendar.getTime();
		String strDate = sdf.format(date);

		// put customer node in linked list
		linkedList.insertAtEnd(linkedList.head, linkedList.countNodes(linkedList.head) + 1, data.getUserName(),
				data.getHairCut(), data.getAdditional(), strDate, data.getTotalCost());

		infoLabel.setText(linkedList.display());

		// set hints
		deleteCustomer.setFocusTraversable(false);
		searchCustomer.setFocusTraversable(false);

		searchCustomer.setPromptText("Enter id");
		deleteCustomer.setPromptText("Enter id");

		Error.getDialogPane().getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// set text view to only accept integer input
		UnaryOperator<TextFormatter.Change> filter = change -> {
			String text = change.getText();

			if (text.matches("\\d?")) {
				return change;
			}
			return null;
		};

		searchCustomer.setTextFormatter(new TextFormatter<String>(filter));
		deleteCustomer.setTextFormatter(new TextFormatter<String>(filter));

		// set initial image
		myImage1 = new Image(getClass().getResourceAsStream("/HairStyles/ShopLogo.jpg"));
		imageView3.setImage(myImage1);

	}

	public void searchButton(ActionEvent e) {

		String dialouge = "Please enter a customer id";
		String dialouge2 = "ID not found";

		try {
			if (!searchCustomer.getText().equals("0")) {
				searchNumber = Integer.parseInt(searchCustomer.getText());
				search(searchNumber);
			} else {
				// show error if user input is either zero or not in the array list
				Error.setAlertType(AlertType.ERROR);
				Error.setContentText(dialouge2);
				Error.show();
			}
		} catch (Exception exception) {
			// show error if user input is empty
			Error.setAlertType(AlertType.ERROR);
			Error.setContentText(dialouge);
			Error.show();
		}
		searchCustomer.clear();
	}

	public void search(int num) {

		String dialouge = "ID not found";

		if (linkedList.SearchName(num) != "None") {
			// put data found into labels and imageview
			SearchNameLabel.setText("Name: " + linkedList.SearchName(num));
			SearchHairLabel.setText("Haircut: " + linkedList.SearchHaircut(num));
			SearchAdditonalLabel.setText("Additional: " + linkedList.SearchAdditional(num));
			TotalCostLabel.setText("Total Cost: P" + String.valueOf(linkedList.SearchTotalCost(num)));
			myImage1 = new Image(
					getClass().getResourceAsStream("/HairStyles/" + linkedList.SearchHaircut(num) + ".png"));
			imageView3.setImage(myImage1);

		} else {
			// show error if id is not found
			Error.setAlertType(AlertType.ERROR);
			Error.setContentText(dialouge);
			Error.show();
			// clears the customer details
			SearchNameLabel.setText("Name ");
			SearchHairLabel.setText("Haircut ");
			SearchAdditonalLabel.setText("Additional ");
			TotalCostLabel.setText("Total Cost");
			myImage1 = new Image(getClass().getResourceAsStream("/HairStyles/ShopLogo.jpg"));
			imageView3.setImage(myImage1);
		}

	}

	public void deleteButton(ActionEvent e) {

		String dialouge = "Please enter a customer id1";
		String dialouge2 = "ID not found";

		try {
			if (!deleteCustomer.getText().equals("0")) {
				searchNumber = Integer.parseInt(deleteCustomer.getText());
				delete(searchNumber);
			} else {
				// show error if user input is either 0 or not in the linked list
				Error.setAlertType(AlertType.ERROR);
				Error.setContentText(dialouge2);
				Error.show();
			}
		} catch (Exception exception) {
			// show error if text field is blank
			Error.setAlertType(AlertType.ERROR);
			Error.setContentText(dialouge);
			Error.show();
		}

		deleteCustomer.clear();
	}

	public void delete(int num) {

		String dialouge = "ID not found";

		if (linkedList.updateDelete(linkedList.head, searchNumber) != false) {
			infoLabel.setText(linkedList.display());
		} else {
			// show error if id is not found
			Error.setAlertType(AlertType.ERROR);
			Error.setContentText(dialouge);
			Error.show();
		}

	}

	public void changeScene(ActionEvent event) throws IOException {

		// add time when scene
		calendar.add(Calendar.MINUTE, 10);

		root = FXMLLoader.load(getClass().getResource("FirstScene.fxml"));
		stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);

		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}

	public void Clear(ActionEvent event) throws IOException {
		linkedList.clearLList();
		infoLabel.setText(linkedList.display());
	}
}
