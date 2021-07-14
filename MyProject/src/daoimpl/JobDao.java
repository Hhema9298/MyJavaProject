package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;
import dao.IJobDao;
import model.Job;

public class JobDao implements IJobDao {

	Connection conn = null;
	
	public JobDao() throws ClassNotFoundException, SQLException {
		conn = Jdbcconnection.getDBConnection();
	}
	
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList = new ArrayList<Job>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Job");
			if(rs!=null) {
				Job j = null;
				
				while(rs.next()) {
					j = new Job();
					j.getJobId();
					j.getJobTitle();
					j.getJobDescription();
					j.getCompanyName();
					j.getLocation();
					j.getKeySkill();
					j.getSalary();
					j.getActive();
					allJobList.add(j);
				}	
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return allJobList;
	}

	@Override
	public void addJob(Job j) {
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement("insert into Job(JobTitle,JobDescription,Companyname,Location,Keyskill,Salary) values (?,?,?,?,?,?);");
			ps.setString(1, j.getJobTitle());
			ps.setString(2, j.getJobDescription());
			ps.setString(3, j.getCompanyName());
			ps.setString(4, j.getLocation());
			ps.setString(5, j.getKeySkill());
			ps.setString(6, j.getSalary());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 @Override
	public void updateJob(Job j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateJob(Job j) {
		PreparedStatement ps;
		try {
				ps = conn.prepareStatement("update Job set Active= 'No' where  JobId=?");
				ps.setInt(1, j.getJobId());
				ps.executeUpdate();
		}			 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteJob(Job j) {
		PreparedStatement ps;
		try {
				ps = conn.prepareStatement("delete from Job where JobId=?");
				ps.setInt(1, j.getJobId());
				ps.execute();	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void activateJob(Job j) {
		PreparedStatement ps;
		try {
				ps = conn.prepareStatement("update Job set Active= 'Yes' where  JobId=?");
				ps.setInt(1, j.getJobId());
				ps.executeUpdate();		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}  

	public void getJobById(Job j) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from Job where JobId=?");
			ps.setInt(1, j.getJobId());
			ResultSet rs =ps.executeQuery();
			JFrame frame = new JFrame();
			JTable table = new JTable();
			DefaultTableModel model = new DefaultTableModel(new String[] {"JobId","JobTitle","JobDescription","Companyname","Location","Keyskill","Salary","Active"},0);
					while(rs.next()) 
					{
						int a = rs.getInt("JobId");
						String b = rs.getString("FirstName");
						String c = rs.getString("LastName");
						String d = rs.getString("UserID");
						String e = rs.getString("Password");
						String f = rs.getString("Role");
						String g = rs.getString("Gender");
						String h = rs.getString("Active");
						
						model.addRow(new Object[] {a,b,c,d,e,f,g,h});
						table.setModel(model);
						JScrollPane sp = new JScrollPane();
						frame.add(sp);
						frame.add(table);
						table.setBounds(10,10,800,600);
					    frame.setVisible(true);
					    frame.setBounds(10,10,800,700);
					    frame.setTitle("View JOB by ID");		
					}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
