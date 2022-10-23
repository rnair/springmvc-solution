package com.springmvc.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.solution.dto.EmployeeDTO;
import com.springmvc.solution.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/add")
	public String showAddForm(Model model) {
		EmployeeDTO employee = new EmployeeDTO();
		List<EmployeeDTO> emps = service.getAll();
		model.addAttribute("managers", emps);
		model.addAttribute("employee", employee);
		return "employee.add";
	}

	@PostMapping("/add")
	public String createEmployee(@ModelAttribute EmployeeDTO employee, Model model) {
		EmployeeDTO saved = service.save(employee);
		model.addAttribute("employee", saved);
		model.addAttribute("responseMessage", "Succesfully created employee.");
		return "redirect:add";
	}

	@GetMapping("/list")
	public String list(@ModelAttribute EmployeeDTO employee, Model model) {
		model.addAttribute("employee", employee);
		return "employee.list";
	}

	@GetMapping("/update")
	public String showUpdateForm(@ModelAttribute EmployeeDTO employee, Model model) {
		if (employee == null || employee.getId() == null) {
			employee = (EmployeeDTO) model.getAttribute("employee");
		}
		EmployeeDTO e = service.getById(employee.getId());
		List<EmployeeDTO> managers = service.getAll();
		model.addAttribute("managers", managers);
		model.addAttribute("employee", e);
		return "employee.update";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute EmployeeDTO employee, Model model, RedirectAttributes redirectAttrs) {
		EmployeeDTO saved = service.update(employee);
		redirectAttrs.addAttribute("responseMessage", "Succesfully updated employee.");
		redirectAttrs.addFlashAttribute("employee", saved);
		return "redirect:update";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		try {
			return new ResponseEntity<List<EmployeeDTO>>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
