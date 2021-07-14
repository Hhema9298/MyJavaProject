package dao;


import model.Employee;

public interface IEmployeeDao {
	
	void addEmployee(Employee emp);
	public void getEmployeeById(Employee emp);
	void updateEmployee(Employee emp);
	public void checkLogin(Employee emp);
	void deleteEmp(Employee emp);
	void addSkill(Employee emp);

}
