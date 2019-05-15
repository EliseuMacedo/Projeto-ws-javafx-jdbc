package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentServices {
	
	public List<Department> findAll(){
		
		//mock retornar dados de mentinrinha
		List<Department> listDep = new ArrayList<>();
		
		listDep.add(new Department(1, "Eletronicos"));
		listDep.add(new Department(2, "Vestuario"));
		listDep.add(new Department(3, "Açougue"));
		listDep.add(new Department(4, "Padaria"));
		listDep.add(new Department(5, "Livros"));
		listDep.add(new Department(6, "Bazar"));
		
		return listDep;
	}

}
