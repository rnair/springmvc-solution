package com.springmvc.solution;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springmvc.solution.dto.EmployeeDTO;
import com.springmvc.solution.service.EmployeeService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<EmployeeDTO> managers = new ArrayList<EmployeeDTO>();
		managers.add(new EmployeeDTO("1", "manager1", "manager1", "21/10/2022", "Department1",
				null, "1000"));
		managers.add(new EmployeeDTO("2", "manager2", "manager2", "21/10/2022", "Department1",
				null, "1000"));
		managers.add(new EmployeeDTO("3", "manager3", "manager3", "21/10/2022", "Department1",
				null, "1000"));
		managers.add(new EmployeeDTO("4", "manager4", "manager4", "21/10/2022", "Department1",
				null, "1000"));

		managers.forEach(m -> {
			service.save(m);
		});
	}

}
