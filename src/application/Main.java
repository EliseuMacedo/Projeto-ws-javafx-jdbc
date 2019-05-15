package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	//guardar a referência da cena no atributo abaixo
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load(); //carregar a view
			
			scrollPane.setFitToHeight(true); //macete para ajustar a largura do form	
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane); // instanciar cena principal
			
			
			
			primaryStage.setScene(mainScene); // setar cena como principal
			primaryStage.setTitle("Sample JavaFX application"); //titulo aplicação javafx modelo
			primaryStage.show(); //exibir tela
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
