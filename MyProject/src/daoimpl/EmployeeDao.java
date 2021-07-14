 package daoimpl;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import config.Jdbcconnection;
import dao.IEmployeeDao;
import model.Employee;

public class EmployeeDao implements IEmployeeDao {
	
	Connection conn = null;
	
	public EmployeeDao() throws ClassNotFoundException, SQLException {	
		conn=Jdbcconnection.getDBConnection();
	}

	
	@Override
	public void checkLogin(Employee emp) {
		try {
			
			PreparedStatement pst = conn.prepareStatement("Select * from Employee where UserId=? and Password = ?");
			pst.setString(1, emp.getUserId());
			pst.setString(2, emp.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					emp.setEmpId(rs.getInt(1));
					emp.setFirstname(rs.getString(2));
					emp.setLastname(rs.getString(3));
					emp.setUserId(rs.getString(4));
					emp.setPassword(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setGender(rs.getString(7));
					emp.setSkill(rs.getString(8));
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());	
		}
	}

	
	@Override
	public void addEmployee(Employee emp) {	
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into Employee(Firstname,LastName,UserId,Password,Role,Gender) values (?,?,?,?,?,?)");
			ps.setString(1, emp.getFirstname());
			ps.setString(2, emp.getLastname());
			ps.setString(3, emp.getUserId());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getRole());
			ps.setString(6, emp.getGender());
			
			
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void getEmployeeById(Employee emp) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs =ps.executeQuery();
			JFrame frame = new JFrame();
			JTable table = new JTable();
			DefaultTableModel model = new DefaultTableModel(new String[] {"EmpId","FirstName","LastName","UserID","Password","Gender","Role"},0);
					while(rs.next()) 
					{
						String a = rs.getString("FirstName");
						String b = rs.getString("LastName");
						String c = rs.getString("UserID");
						String d = rs.getString("Password");
						String e = rs.getString("Gender");
						String g = rs.getString("EmpId");
						String h = rs.getString("Role");
						model.addRow(new Object[] {g,a,b,c,d,e,h});
						table.setModel(model);
						JScrollPane sp = new JScrollPane();
						frame.add(sp);
						frame.add(table);
						table.setBounds(10,10,800,600);
					    frame.setVisible(true);
					    frame.setBounds(10,10,800,700);
					    frame.setTitle("View EMP by ID");		
					}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("update Employee set FirstName=?, LastName=? , Password=? where UserId=?");
			ps.setString(1, emp.getFirstname());
			ps.setString(2, emp.getLastname());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getUserId());
			
			int rs = ps.executeUpdate();
			JFrame f = new JFrame();
			if(rs == 1) {
				JOptionPane.showMessageDialog(f, "Updated Successfully");
			}			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void deleteEmp(Employee emp) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select EmpId from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs= ps.executeQuery();
			if(rs!=null) { 
				if(rs.next()) {
				ps = conn.prepareStatement("delete from Employee where EmpId=?");
				ps.setInt(1, emp.getEmpId());
				ps.execute();
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void addSkill(Employee emp) {
		try {
			PreparedStatement ps = conn.prepareStatement("update Employee set Skill=? where UserId=?");
			ps.setString(1, emp.getSkill());
			ps.setString(2, emp.getUserId());
			
			int rs = ps.executeUpdate();
			JFrame f = new JFrame();
			if(rs == 1) {
				JOptionPane.showMessageDialog(f, "Process Completed Successfully");
			}			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}