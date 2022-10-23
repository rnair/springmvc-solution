package com.springmvc.solution.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.springmvc.solution.dto.EmployeeDTO;
import com.springmvc.solution.entity.Employee;
import com.springmvc.solution.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	@Transactional
	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> emps = new ArrayList<EmployeeDTO>();

		repository.findAll().forEach(e -> {
			EmployeeDTO emp = convertToDTO(e);
			emps.add(emp);
		});
		return emps;
	}

	@Transactional
	public EmployeeDTO getById(String id) {
		Assert.hasText(id, "Employeed Id must not be empty");
		Employee e = repository.findById(Long.valueOf(id)).get();
		return convertToDTO(e);
	}

	@Transactional
	public EmployeeDTO save(EmployeeDTO dto) {
		Employee toSave = new Employee();
		convertToEntity(dto, toSave);
		Employee e = repository.save(toSave);

		dto.setId(e.getId().toString());
		return dto;
	}

	@Transactional
	public EmployeeDTO update(EmployeeDTO employee) {
		Assert.notNull(employee, "Employee details must not be empty.");
		Assert.hasText(employee.getId(), "Employeed Id must not be empty");
		Employee existing = repository.findById(Long.valueOf(employee.getId())).get();
		Employee toUpdate = convertToEntity(employee, existing);
		return convertToDTO(repository.save(toUpdate));
	}

	private Employee convertToEntity(EmployeeDTO dto, Employee toSave) {
		toSave.setDepartment(dto.getDepartment());
		try {
			toSave.setDob(SDF.parse(dto.getDob()));
		} catch (ParseException e1) {
			throw new RuntimeException("Invalid date format, cant parse it.");
		}
		toSave.setFirstName(dto.getFirstName());
		toSave.setLastName(dto.getLastName());
		toSave.setSalary(dto.getSalary());

		if (dto.getManager() != null && !dto.getManager().getId().isEmpty()) {
			Employee manager = repository.findById(Long.valueOf(dto.getManager().getId())).orElse(null);
			toSave.setManager(manager);
		}
		return toSave;
	}

	private EmployeeDTO convertToDTO(Employee e) {
		EmployeeDTO emp = new EmployeeDTO();
		emp.setFirstName(e.getFirstName());
		emp.setLastName(e.getLastName());
		if (e.getManager() != null) {
			emp.setManager(new EmployeeDTO(e.getManager().getId().toString(), e.getManager().getFirstName()));
		}
		emp.setSalary(e.getSalary());
		emp.setDob(SDF.format(e.getDob()));
		emp.setDepartment(e.getDepartment());
		emp.setId(e.getId().toString());
		return emp;
	}
}
