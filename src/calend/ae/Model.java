package calend.ae;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;

import io.zunon.LibZwami;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Model extends Application implements Initializable {

	private ArrayList<Node>
		panes = new ArrayList<>();
	public Button
		GregorianToHijri,
		GregorianToZwami,
		HijriToGregorian,
		HijriToZwami,
		ZwamiToGregorian,
		ZwamiToHijri;
	public ChoiceBox<String>
		from,
		to;
	public DatePicker
		dateGreg;
	public GridPane
		fromGregorian,
		fromZwami,
		root;
	// TODO use one universal label instead of three
	public Label
		resultGregorian,
		resultHijri,
		resultZwami;
	public static String
		hidden = "Gregorian";
	public TextField
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
		LocalDate
			date = dateGreg.getValue();
		String
			result = LibZwami.toZwami(date);
		
		resultGregorian.setText("The date in Zwami is: " + result);
	}
	
	public void onClickGToH(Event e){
		// TODO add conversion
	}
	
	public void onClickHToZ(Event e) {
		// TODO add conversion
	}
	
	public void onClickHToG(Event e) {
		// TODO add conversion
	}
	
	public void onClickZToH(Event e) {
		// TODO add conversion
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
		
		resultZwami.setText(zwami + " corresponds to " + result);
	}
	
	public void changeGridPanes(Event e) {
		String
			newValue = from.getValue();
		updateStage(newValue);
	}

	private void updateStage(String newInput) {
		panes.forEach(e -> {
			e.setVisible(e.getId().endsWith(newInput));
		});
		to.getItems().remove(newInput);
		to.getItems().add(hidden);
		to.setValue(hidden);
		hidden = newInput;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		root.getChildren().stream()
						  .filter(e -> e.getClass().getSimpleName().equals("GridPane"))
						  .forEach(panes::add);
	}

}