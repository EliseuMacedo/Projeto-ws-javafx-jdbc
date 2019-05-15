package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	// todo o objeto
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumId; // Model, tipo
	@FXML
	private TableColumn<Department, String> tableColumNome;
	@FXML
	private Button btNovo;

	@FXML
	public void onBtNovoAction() {
		System.out.println("onBtnovoAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initializeNodes();

	}

	private void initializeNodes() {

		// comando para iniciar apropriadamente o comportamento das colunas da tabela
		tableColumId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumId.setCellValueFactory(new PropertyValueFactory<>("Nome"));

		// Pegar uma referencia para o stage atual da janela principal para o
		// tableviewDepartment acompanhar o tamanho.

		Stage stage = (Stage) Main.getMainScene().getWindow(); // windows é uma referencia para janela que é super
																// classe do stage - downcasting

		// comando para table view department acompanhar a janela
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
}
