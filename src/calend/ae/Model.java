package calend.ae;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Model extends Application {
		
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stg) throws IOException{
		stg.setTitle("Grae");
		Parent tabs = FXMLLoader.load(getClass().getResource("View.fxml"));
		stg.setScene(new Scene(tabs, 450, 250));
		stg.show();
	}
}