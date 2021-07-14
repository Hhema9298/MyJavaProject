package view;

import java.awt.Color;
import java.awt.event.*; 
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import controller.Employeecontroller;
import model.Employee;
public class UpdateProfile {

	private JFrame frame;
	private JLabel lRForm,lFirstname,lLastName,lPassword,lCPassword;
	private JTextField tFirstname,tLastname;
	private JPasswordField pPassword, pCPassword;
	private static Employeecontroller employeecontroller;
	Employee emp;

	
	
	UpdateProfile(Employee emp) throws ClassNotFoundException, SQLException {
		frame = new JFrame("Update Profile");
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(480,80,420,600);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		
		lRForm = new JLabel("Update Form");
		lRForm.setFont(new Font("Calibri", Font.ITALIC, 20));
		lRForm.setForeground(Color.cyan);
		lRForm.setBounds(138, 39, 193, 38);
		frame.getContentPane().add(lRForm);
		
		lFirstname = new JLabel("Change Firstname");
		lFirstname.setBounds(20, 120, 120, 25);
		lFirstname.setForeground(Color.cyan);
		frame.getContentPane().add(lFirstname);
		tFirstname = new JTextField();
		tFirstname.setBounds(140, 120, 140, 20);
		frame.getContentPane().add(tFirstname);
		
		
		lLastName = new JLabel("Change Lastname");
		lLastName.setFont(new Font("Calibri", Font.PLAIN, 13));
		lLastName.setForeground(Color.cyan);
		lLastName.setBounds(20, 155, 125, 25);
		frame.getContentPane().add(lLastName);
		
		lPassword = new JLabel("Change Password");
		lPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lPassword.setForeground(Color.cyan);
		lPassword.setBounds(20, 230, 105, 25);
		frame.getContentPane().add(lPassword);
		
		lCPassword= new JLabel("Confirm Password");
		lCPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lCPassword.setForeground(Color.cyan);
		lCPassword.setBounds(20, 270, 115, 25);
		frame.getContentPane().add(lCPassword);
		
		tLastname = new JTextField();
		tLastname.setColumns(10);
		tLastname.setBounds(140, 160, 140, 20);
		frame.getContentPane().add(tLastname);
		
		pCPassword = new JPasswordField();
		pCPassword.setBounds(140, 270, 140, 20);
		frame.getContentPane().add(pCPassword);
		
		pPassword = new JPasswordField();
		pPassword.setBounds(140, 230, 140, 20);
		frame.getContentPane().add(pPassword);
		
		JButton btnSubmitButton = new JButton("Submit");
		employeecontroller = new Employeecontroller();
		btnSubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String UFN, ULN, UP, UCP,UID;
					UID = emp.getUserId();
					UFN = tFirstname.getText();
					ULN = tLastname.getText();
					UP = new String(pPassword.getPassword());
					UCP = new String(pCPassword.getPassword());
				if(UP.equals(UCP)) {
					employeecontroller.updateEmployee(UFN,ULN,UP,UID);		//Values Added to Controller
					frame.dispose();
					}
					else {
					JOptionPane.showMessageDialog(frame, "Check your Password and Retry ..!");
				}
			}
	});
		btnSubmitButton.setBounds(140, 405, 90, 25); 
		frame.getContentPane().add(btnSubmitButton);
		frame.setVisible(true);
	
		JButton btnOK = new JButton("Back");
		btnOK.setForeground(Color.BLACK);
		btnOK.setFont(new Font("Calibri", Font.BOLD, 14));
		btnOK.setBounds(140, 440, 90, 25);
		frame.getContentPane().add(btnOK);
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EmployeeHomePage(emp);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
