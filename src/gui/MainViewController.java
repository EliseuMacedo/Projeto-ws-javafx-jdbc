package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamento;
	@FXML
	private MenuItem menuItemSobre;

	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("Vendendor");
	}

	@FXML
	public void onMenuItemDepartamentoAction() {
		System.out.println("Departamento");
	}

	@FXML
	public void onMenuItemSobreAction() {
		
		//vou carregar a view about dentro da tela mainView
		loadView("/gui/AboutView.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	// função para chamar outra janela
	private synchronized void loadView(String caminhoCompleto) {

		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoCompleto));
			VBox newVbox = loader.load();

			// peguei a referencia para a Scene
			Scene mainScene = Main.getMainScene();

			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); // Esse método pega o primeiro
																					// elemento da minha view.

			// pegar referencia para o menu
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear(); // limpar todos os filhos de mainVbox

			// adicionar no mainVbox o mainMenu e depois os filhos no newVbox
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando a página", e.getMessage(), AlertType.ERROR);
		}
	}
	
	

}
