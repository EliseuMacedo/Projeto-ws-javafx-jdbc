package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentServices;

public class DepartmentListController implements Initializable {
	
	//declarar uma dependencia aqui para deparment service
	private DepartmentServices service;
	
	//carregar o departamento aqui
	private ObservableList<Department> obsList;

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
	
	//inversão de controle
	public void setDepartmentService (DepartmentServices service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initializeNodes();

	}

	private void initializeNodes() {

		// comando para iniciar apropriadamente o comportamento das colunas da tabela
		tableColumId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumNome.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Pegar uma referencia para o stage atual da janela principal para o
		// tableviewDepartment acompanhar o tamanho.

		Stage stage = (Stage) Main.getMainScene().getWindow(); // windows é uma referencia para janela que é super
																// classe do stage - downcasting

		// comando para table view department acompanhar a janela
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	//método responsável por acessar o serviço, carregar os departamentos e enviar para ObservableList
	//depois associar obsList e carregar na tela
	public void updateTableView() {
		
		if(service == null) {
			
			throw new IllegalStateException();
		}
		
		List<Department> listDeps = service.findAll();
		//carregar a lista dentro de obsList
		
		obsList = FXCollections.observableArrayList(listDeps);
		
		tableViewDepartment.setItems(obsList);
		
	}
}
