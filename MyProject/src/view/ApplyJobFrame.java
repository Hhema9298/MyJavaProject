package  view;

import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;
import controller.Jobcontroller;
import model.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class ApplyJobFrame{
	JFrame frame = new JFrame();
	Jobcontroller jobcontroller;
	
	public ApplyJobFrame(Employee emp) throws ClassNotFoundException, SQLException {
		Connection con=Jdbcconnection.getDBConnection();
		Statement st=con.createStatement();
		jobcontroller = new Jobcontroller();
		
		
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId", "JobTitle", "CompanyName","Location","Salary"}, 0);
		ResultSet rst=st.executeQuery("select * from Job where Active ='Yes'");
		while(rst.next())
 		{
		    int a = rst.getInt("JobId");
		    String b = rst.getString("JobTitle");
		    String d = rst.getString("CompanyName");
		    String e = rst.getString("Location");
		    String g = rst.getString("Salary");
		    model.addRow(new Object[] {a,b,d,e,g});
		    table.setModel(model);
		    JScrollPane sp=new JScrollPane(table);
		    
		    
		    JTextField tJobId = new JTextField();
		    tJobId.setBounds(130,500, 200, 30);
			frame.add(tJobId);
			
			
			JButton bActive = new JButton("APPLY");
			bActive.setBounds(350,500, 200, 30);
			frame.add(bActive);
			bActive.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {			 
					 try {
						 int JID; 
						 
						 JID = Integer.parseInt(tJobId.getText());
						 PreparedStatement ps = con.prepareStatement("select * from job where JobId=?");
						 ps.setInt(1,JID);
						 ResultSet rs= ps.executeQuery();
						 if(rs.next()) {
							 String jobTitle, jobCollection, jskill, eskill;
							 Pattern p1,p2;
							 Matcher m1,m2;
							 
							 jobTitle = rs.getString("JobTitle");
							 jobCollection ="WebDeveloper|AppDeveloper|AndroidDeveloper|FullstackDeveloper";
							 
							 p1 = Pattern.compile(jobTitle);
							 m1 = p1.matcher(jobCollection);
						                                                                                                                                                
							 if(m1.find()==true){
								  jskill= "Java|JAVA|java|Spring|Springboot|JSP|Jsp|jsp"
								  		+ "|Servlet|Servlet|Hibernate";
							 
							
								eskill = emp.getSkill();
							 
							 	p2 = Pattern.compile(jskill);
								m2 = p2.matcher(eskill);
								int count =0;
								while(m2.find()) {
									count++;
								}
								
								if(count>=3) {
									JFrame f= new JFrame();
									JOptionPane.showMessageDialog(f, "You are Selected for the Interview");
								}else {
									JFrame f= new JFrame();
									JOptionPane.showMessageDialog(f, "Sorry, Better luck next time");
								}

							 }
						 }
					} catch (Exception e1) {
						e1.printStackTrace();
					} 		 
				} 
			}); 
			
			JButton bBack = new JButton("BACK");
			bBack.setBounds(570,500, 200, 30);
			frame.add(bBack);
			bBack.addActionListener(new ActionListener(){
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 frame.dispose();
				 }
					 	 });
			

		    
		    
		    frame.add(sp);
		    frame.add(table);
		    table.setBounds(10,10,900,650);
		    frame.setBounds(250,60,900,650);
		    frame.setVisible(true);
		    frame.setTitle("All JOBS");
		}
	}

}
