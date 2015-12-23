package calend.ae;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

import io.zunon.LibZwami;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Model extends Application implements Initializable {
	
	public ChoiceBox<String>
		from,
		to;
	public GridPane
		fromGreg,
		fromZwami;
	public Label
		resultGToZ,
		resultZToG;
	public TextField
		yearTextField,
		monthTextField,
		dayTextField,
		zwamiTextField;
	public static String
		hidden="Gregorian";
		
	public static void main(String[]args) {
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fromZwami.setVisible(false);
	}
	
	@Override
	public void start(Stage stg) throws Exception{
		Parent tabs = FXMLLoader.load(getClass().getResource("View.fxml"));
		stg.setTitle("Calendae");
		stg.setScene(new Scene(tabs, 450, 250));
		stg.setResizable(false);
		stg.show();
	}
	
	public void onClickGToZ(Event e) {
		int
			year = Integer.parseInt(yearTextField.getText()),
			month = Integer.parseInt(monthTextField.getText()),
			dayOfMonth = Integer.parseInt(dayTextField.getText());
		LocalDate
			date = LocalDate.of(year, month, dayOfMonth);
		String
			result = LibZwami.toZwami(date);
		
		resultGToZ.setText("The date in Zwami is: " + result);
	}
	
	public void onClickZToG(Event e) {
		String
			zwami = zwamiTextField.getText(),
			result = "";
		LocalDate
			date = LibZwami.toGreg(zwami);
		DateTimeFormatter
			iso = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		result = date.format(iso);
		
		resultZToG.setText(zwami + " corresponds to " + result);
	}
	
	public void changeGridPanes(Event e) {
		String
			newValue = from.getValue();
		switch(newValue) {
		case "Gregorian":
			fromZwami.setVisible(false);
			fromGreg.setVisible(true);
			to.getItems().remove("Gregorian");
			to.getItems().add(hidden);
			to.setValue(hidden);
			hidden = "Gregorian";
			break;
		case "Zwami":
			fromZwami.setVisible(true);
			fromGreg.setVisible(false);
			to.getItems().remove("Zwami");
			to.getItems().add(hidden);
			to.setValue(hidden);
			hidden = "Zwami";
			break;
		}
	}

}