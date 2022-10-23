package com.springmvc.solution.dto;

public class EmployeeDTO {

	private String id;
	private String firstName;
	private String lastName;
	private String dob;
	private String department;
	private EmployeeDTO manager;
	private String salary;

	public EmployeeDTO() {}
	
	
	public EmployeeDTO(String id, String firstName, String lastName, String dob, String department, EmployeeDTO manager,
			String salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.department = department;
		this.manager = manager;
		this.salary = salary;
	}
	
	public EmployeeDTO(String id, String fname) {
		this.id = id;
		this.firstName = fname;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public EmployeeDTO getManager() {
		return manager;
	}

	public void setManager(EmployeeDTO manager) {
		this.manager = manager;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", department="
				+ department + ", manager=" + manager + ", salary=" + salary + "]";
	}

}
