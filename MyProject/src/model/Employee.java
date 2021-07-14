package model;

public class Employee {
	private int empId;
	private String Firstname;
	private String Lastname;
	private String userId;
	private String password;
	private String role;
	private String gender;
	private String skill;

	
	// Constructor method
	
	public Employee() {
		
	}
	
	

	public Employee(String firstname, String lastname, String userId, String password, String role, String gender) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.gender = gender;
		
	}
	
	// Getter and Setter Methods 
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", userId=" + userId
				+ ", password=" + password + ", Role=" + role + ", gender=" + gender + "]";
	}

	
}
