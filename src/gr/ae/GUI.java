package gr.ae;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	
	private static Button
		submitGToZ = new Button("Submit"),
		submitZToG = new Button("Submit");
	private static GridPane
		scn = new GridPane();
	private static Label
		zwm = new Label("Zwami: "),
		yer = new Label("Year: "),
		mth = new Label("Month: "),
		day = new Label("Day: ");
	private static Label
		resGToZ = new Label(),
		resZToG = new Label();
	private static TextField
		yrt = new TextField(),
		mnt = new TextField(),
		dyt = new TextField(),
		zwt = new TextField();
		
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stg){
		stg.setTitle("Grae");
		Tab
			toZwami = new Tab("to Zwami"),
			toGreg = new Tab("to Gregorian");
		TabPane
			tabs = new TabPane();
		GridPane
			gToZ = configureGtoZ(),
			zToG = configureZtoG();
		toGreg.setContent(zToG);
		toZwami.setContent(gToZ);
		tabs.getTabs().add(toZwami);
		tabs.getTabs().add(toGreg);
		submitGToZ.setOnAction(GUI::onClickGToZ);
		submitZToG.setOnAction(GUI::onClickZToG);
		stg.setScene(new Scene(tabs, 450, 250));
		stg.show();
	}
	
	private static void onClickGToZ(Event e) {
		int
			year = Integer.parseInt(yrt.getText()),
			month = Integer.parseInt(mnt.getText()),
			dayOfMonth = Integer.parseInt(dyt.getText());
		LocalDate
			date = LocalDate.of(year, month, dayOfMonth);
		String
			result = Zwami.toZwami(date);
		
		resGToZ.setText("The date in Zwami is: " + result);
	}
	
	private static void onClickZToG(Event e) {
		String
			zwami = zwt.getText(),
			result = Zwami.toGreg(zwami).toString();
		
		resZToG.setText(zwami + " corresponds to " + result);
	}

	private GridPane configureGtoZ() {
		scn = new GridPane();
		
		scn.setAlignment(Pos.CENTER);
		scn.setHgap(10);
		scn.setVgap(10);
		
		scn.add(resGToZ, 1, 0);
		
		scn.add(yer, 0, 1);
		scn.add(mth, 0, 2);
		scn.add(day, 0, 3);
		
		scn.add(yrt, 2, 1);
		scn.add(mnt, 2, 2);
		scn.add(dyt, 2, 3);
		
		scn.add(submitGToZ, 1, 4);
		
		return scn;
	}
	
	private GridPane configureZtoG() {
		scn = new GridPane();
		
		scn.setAlignment(Pos.CENTER);
		scn.setHgap(10);
		scn.setVgap(10);
		
		scn.add(resZToG, 1, 0);
		scn.add(zwm, 0, 1);
		scn.add(zwt, 2, 1);
		scn.add(submitZToG, 1, 2);
		
		return scn;
	}

}
