package view;

import java.awt.Container;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;

public class AllEmployeesFrame{
	JFrame frame = new JFrame();
	Container container = new Container(); ;
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		new AllEmployeesFrame();
	}
	
	public AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame();
		container = new Container();
		Connection conn = Jdbcconnection.getDBConnection();
		Statement st = conn.createStatement();
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] {"EmpId","FirstName","LastName","UserID","Gender","Role"},0);
		ResultSet rs = st.executeQuery("select * from Employee where EmpId between 2 and 10");
				while(rs.next()) 
				{
					String a = rs.getString("FirstName");
					String b = rs.getString("LastName");
					String c = rs.getString("UserID");
					//String d = rs.getString("Password");
					String e = rs.getString("Gender");
					String g = rs.getString("EmpId");
					String h = rs.getString("Role");
					model.addRow(new Object[] {g,a,b,c,e,h});
					table.setModel(model);
					JScrollPane sp = new JScrollPane();
					frame.add(sp);
					frame.add(table);
					table.setBounds(10,10,800,600);
				    frame.setVisible(true);
				    frame.setBounds(10,10,800,700);
				    frame.setTitle("View all employees");		
		}	
	}

}
