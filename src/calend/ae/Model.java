package calend.ae;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Model extends Application {
	
	public Label
		resultGToZ,
		resultZToG;
	public TextField
		yearTextField,
		monthTextField,
		dayTextField,
		zwamiTextField;
		
	public static void main(String[]args) {
		launch(args);
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
			result = Zwami.toZwami(date);
		
		resultGToZ.setText("The date in Zwami is: " + result);
	}
	
	public void onClickZToG(Event e) {
		String
			zwami = zwamiTextField.getText(),
			result = "";
		LocalDate
			date = Zwami.toGreg(zwami);
		DateTimeFormatter
			iso = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		result = date.format(iso);
		
		resultZToG.setText(zwami + " corresponds to " + result);
	}
}