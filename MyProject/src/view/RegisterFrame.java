package view;

import java.awt.event.*; 
import java.sql.SQLException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import controller.Employeecontroller;
import model.Employee;
public class RegisterFrame {

	private JFrame frame;
	private JLabel lRForm,lFirstname,lLastName,lUserID,lPassword,lCPassword,lGender,lRole;
	private JTextField tFirstname,tLastname,tUserID,tGender;
	private JPasswordField pPassword, pCPassword;
	private static Employeecontroller employeecontroller;
	private JTextField tRole;
	Employee emp = new Employee();
	
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RegisterFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	
	public RegisterFrame() throws ClassNotFoundException, SQLException {
		frame = new JFrame("Register Page");
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(100, 100, 490, 500);
		frame.getContentPane().setLayout(null);
		
		lRForm = new JLabel("Registration Form");
		lRForm.setFont(new Font("Calibri", Font.ITALIC, 20));
		lRForm.setForeground(Color.cyan);
		lRForm.setBounds(138, 39, 193, 38);
		frame.getContentPane().add(lRForm);
		
		lFirstname = new JLabel("Firstname");
		lFirstname.setFont(new Font("Calibri", Font.PLAIN, 13));
		lFirstname.setForeground(Color.cyan);
		lFirstname.setBounds(20, 120, 75, 25);
		frame.getContentPane().add(lFirstname);
		
		lLastName = new JLabel("Lastname");
		lLastName.setFont(new Font("Calibri", Font.PLAIN, 13));
		lLastName.setForeground(Color.cyan);
		lLastName.setBounds(20, 155, 75, 25);
		frame.getContentPane().add(lLastName);
		
		lUserID = new JLabel("UserID");
		lUserID.setFont(new Font("Calibri", Font.PLAIN, 13));
		lUserID.setForeground(Color.cyan);
		lUserID.setBounds(20, 195, 75, 25);
		frame.getContentPane().add(lUserID);
		
		lPassword = new JLabel("Create Password");
		lPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lPassword.setForeground(Color.cyan);
		lPassword.setBounds(20, 230, 105, 25);
		frame.getContentPane().add(lPassword);
		
		lCPassword= new JLabel("Confirm Password");
		lCPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lCPassword.setForeground(Color.cyan);
		lCPassword.setBounds(20, 270, 115, 25);
		frame.getContentPane().add(lCPassword);
		
		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 13));
		lGender.setForeground(Color.cyan);
		lGender.setBounds(20, 310, 75, 25);
		frame.getContentPane().add(lGender);
		
		lRole = new JLabel("Role");
		lRole.setFont(new Font("Calibri", Font.PLAIN, 13));
		lRole.setForeground(Color.cyan);
		lRole.setBounds(20, 355, 75, 25);
		frame.getContentPane().add(lRole);
		
		tFirstname = new JTextField();
		tFirstname.setColumns(10);
		tFirstname.setBounds(140, 120, 140, 20);
		frame.getContentPane().add(tFirstname);
		
		tLastname = new JTextField();
		tLastname.setColumns(10);
		tLastname.setBounds(140, 160, 140, 20);
		frame.getContentPane().add(tLastname);
		
		tUserID = new JTextField();
		tUserID.setColumns(10);
		tUserID.setBounds(140, 195, 140, 20);
		frame.getContentPane().add(tUserID);
		
		tGender = new JTextField();
		tGender.setColumns(10);
		tGender.setBounds(140, 310, 140, 20);
		frame.getContentPane().add(tGender);
		
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
				String UFN, ULN, UID, UP, UCP, UG, UR;
				UFN = tFirstname.getText();
				ULN = tLastname.getText();
				UID = tUserID.getText();
				UP = new String(pPassword.getPassword());
				UG = tGender.getText();
				UR = tRole.getText();
				UCP = new String(pCPassword.getPassword());
				
				if(UP.equals(UCP)) {
					employeecontroller.addEmployee(UFN,ULN,UID,UP,UG,UR);		//Values Added to Controller
					JOptionPane.showMessageDialog(frame,"Registered Succesfully");
					frame.dispose();
					try {	
						new LoginFrame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
					else {
					JOptionPane.showMessageDialog(frame, "Check your Password and Retry ..!");
				}
			}
		});
		btnSubmitButton.setBounds(155, 405, 90, 25); 
		frame.getContentPane().add(btnSubmitButton);
		
		tRole = new JTextField();
		tRole.setColumns(10);
		tRole.setBounds(140, 350, 140, 20);	
		frame.setBounds(480,80,420,600);
	    frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().add(tRole);
		frame.setVisible(true);
		
		
	}
	
}
