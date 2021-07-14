package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import daoimpl.EmployeeDao;
import model.Employee;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewProfile extends EmployeeDao{

	private JFrame frame;
	private JLabel lEmpProfile,lEmpID,lFname,lLname,lGender,lRole;
	private JTextField textField,textField1,textField2,textField3,textField4;
	private JButton btnOK;
	
	
		public ViewProfile(Employee emp) throws Exception{
			
			
		frame = new JFrame("Viewing Profile");
		frame.setBounds(480,80,420,600);
	    frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lEmpProfile = new JLabel("Employee Profile");
		lEmpProfile.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lEmpProfile.setForeground(Color.cyan);
		lEmpProfile.setBounds(150, 35, 162, 25);
		frame.getContentPane().add(lEmpProfile);
		
		lEmpID = new JLabel("Employee ID");
		lEmpID.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEmpID.setForeground(Color.cyan);
		lEmpID.setBounds(60, 90, 80, 25);
		frame.getContentPane().add(lEmpID);
		
		lFname = new JLabel("First Name");
		lFname.setFont(new Font("Calibri", Font.PLAIN, 15));
		lFname.setForeground(Color.cyan);
		lFname.setBounds(60, 135, 80, 25);
		frame.getContentPane().add(lFname);
		
		lLname = new JLabel("Last Name");
		lLname.setFont(new Font("Calibri", Font.PLAIN, 15));
		lLname.setForeground(Color.cyan);
		lLname.setBounds(60, 180, 80, 25);
		frame.getContentPane().add(lLname);
		
		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 15));
		lGender.setForeground(Color.cyan);
		lGender.setBounds(60, 225, 80, 25);
		frame.getContentPane().add(lGender);
		
		lRole = new JLabel("Role");
		lRole.setFont(new Font("Calibri", Font.PLAIN, 15));
		lRole.setForeground(Color.cyan);
		lRole.setBounds(60, 265, 80, 25);
		frame.getContentPane().add(lRole);
				
		textField = new JTextField(Integer.toString(emp.getEmpId()));
		textField.setBounds(170, 90, 180, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		textField1 = new JTextField(emp.getFirstname());
		textField1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField1.setColumns(10);
		textField1.setBounds(170, 135, 180, 20);
		frame.getContentPane().add(textField1);
		
		
		textField2 = new JTextField(emp.getLastname());
		textField2.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField2.setColumns(10);
		textField2.setBounds(170, 180, 180, 20);
		frame.getContentPane().add(textField2);
		
		
		textField3 = new JTextField(emp.getGender());
		textField3.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField3.setColumns(10);
		textField3.setBounds(170, 225, 180, 20);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField(emp.getRole());
		textField4.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField4.setColumns(10);
		textField4.setBounds(170, 265, 180, 20);
		frame.getContentPane().add(textField4);
		
		
			
		btnOK = new JButton("Back");
		btnOK.setForeground(Color.BLACK);
		btnOK.setFont(new Font("Calibri", Font.BOLD, 14));
		btnOK.setBounds(170, 365, 90, 25);
		frame.getContentPane().add(btnOK);
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
		});
		
		}
	}