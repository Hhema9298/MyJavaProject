package view;

import java.awt.Container;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;

public class AllJobsFrame{
	JFrame frame = new JFrame();
	Container container = new Container(); ;
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		new AllJobsFrame();
	}
	
	public AllJobsFrame() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame();
		container = new Container();
		Connection conn = Jdbcconnection.getDBConnection();
		Statement st = conn.createStatement();
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] {"JobId","JobTitle","JobDescription","CompanyName","Location","KeySkill","Salary","Activate"},0);
		ResultSet rs = st.executeQuery("select * from Job");
				while(rs.next()) 
				{
					int a = rs.getInt("JobId");
					String b = rs.getString("JobTitle");
					String c = rs.getString("JobDescription");
					String d = rs.getString("CompanyName");
					String e = rs.getString("Location");
					String f = rs.getString("KeySkill");
					String g = rs.getString("Salary");
					String h = rs.getString("Active");
					
					model.addRow(new Object[] {a,b,c,d,e,f,g,h});
					//model.addRow(new Object[] {g,a,b,c,e,h});
					table.setModel(model);
					JScrollPane sp = new JScrollPane();
					frame.add(sp);
					frame.add(table);
					table.setBounds(10,10,800,600);
				    frame.setVisible(true);
				    frame.setBounds(10,10,800,700);
				    frame.setTitle("View all job");		
		}	
	}

}





