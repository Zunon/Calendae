package calend.ae;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;

import io.zunon.LibZwami;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

	private ArrayList<GridPane>
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
		dateGreg,
		dateHijri;
	public GridPane
		fromGregorian,
		fromZwami,
		root;
	public Label
		result;
	public static String
		hidden = "Gregorian";
	public TextField
		zwamiTextField;
	private DateTimeFormatter
		hijri = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withChronology(Chronology.of("Hijrah-umalqura")),
		iso = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	
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
			resultText = LibZwami.toZwami(date);
		
		result.setText("The date in Zwami is: " + resultText);
	}
	
	public void onClickGToH(Event e){
		LocalDate
			greg = dateGreg.getValue();
		String
			resultText = greg.format(hijri);
		result.setText("The date in Hijri is: "+resultText);
	}
	
	public void onClickHToZ(Event e) {
		LocalDate
			hijri = dateHijri.getValue();
		String
			resultText = LibZwami.toZwami(hijri);
		result.setText("The date in Zwami: "+resultText);
	}
	
	public void onClickHToG(Event e) {
		LocalDate
			hijri = dateHijri.getValue();
		String
			resultText = hijri.format(iso);
		result.setText("The date in Gregorian: "+resultText);
	}
	
	public void onClickZToH(Event e) {
		String
			zwami = zwamiTextField.getText(),
			resultText = LibZwami.toGreg(zwami).format(hijri);
		result.setText("The date in Hijri: "+resultText);
	}
	
	public void onClickZToG(Event e) {
		String
			zwami = zwamiTextField.getText(),
			resultText = "";
		LocalDate
			date = LibZwami.toGreg(zwami);
		resultText = date.format(iso);
		
		result.setText("The date in Gregorian: " + resultText);
	}
	
	public void changeGridPanes(Event e) {
		String
			newValue = from.getValue();
		updateStage(newValue);
		showAndHideButtons();
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
	
	public void showAndHideButtons(Event e) {
		showAndHideButtons();
	}
	private void showAndHideButtons() {
		ArrayList<Button>
			buttons = new ArrayList<>();
		panes.forEach(
			    e -> e.getChildren().stream()
									.filter(f -> f.getClass().getSimpleName().equals("Button"))
									.forEach(f -> buttons.add((Button)f)));
		buttons.forEach(button -> {
			button.setVisible(button.getId().startsWith(from.getValue()) && button.getId().endsWith(to.getValue()));
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		root.getChildren().stream()
						  .filter(e -> e.getClass().getSimpleName().equals("GridPane"))
						  .forEach(e -> panes.add((GridPane)e));
		dateHijri.setChronology(Chronology.of("Hijrah-umalqura"));
	}

}