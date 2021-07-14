package controller;

import java.sql.SQLException;
import daoimpl.EmployeeDao;
import model.Employee;

public class Employeecontroller {
	EmployeeDao empDao = null;
	Employee emp;

	public Employeecontroller() throws ClassNotFoundException, SQLException {
		empDao = new EmployeeDao();
		emp = new Employee();
	}
		
		public void addEmployee(String UFN, String ULN, String UID, String UP, String UG, String UR) {
			Employee emp = new Employee();
			 emp.setFirstname(UFN);
			 emp.setLastname(ULN);
			 emp.setUserId(UID);
			 emp.setPassword(UP);
			 emp.setGender(UG);
			 emp.setRole(UR); 
			 empDao.addEmployee(emp);  
		}

		public Employee checkLogin(String UID, String UP) {

			emp.setUserId(UID);
			emp.setPassword(UP);
			empDao.checkLogin(emp); 
			return emp;
		}

		
		public Employee getEmployeeById(int id) {
			Employee emp= new Employee();
			emp.setEmpId(id);
			empDao.getEmployeeById(emp);
			return emp;
				
		}
			
		public Employee updateEmployee(String UFN,String ULN,String UP,String UID) {
			Employee emp = new Employee();
			emp.setFirstname(UFN);
			emp.setLastname(ULN);
			emp.setPassword(UP);
			emp.setUserId(UID);
			empDao.updateEmployee(emp);
			return emp;	
		}
			
		public Employee deleteEmp(int EID) {
			Employee emp = new Employee();
			emp.setEmpId(EID);
			empDao.deleteEmp(emp);
			return emp;
		}
		
		public void addSkill(String skill, String UID) {
			emp.setSkill(skill);
			emp.setUserId(UID);
			empDao.addSkill(emp);	
		}
									
}