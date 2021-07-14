package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;

import controller.Employeecontroller;
import model.Employee;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame{

	private JFrame frame;
	private JLabel lUserLabel,lPassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLoginButton,btnRegister;
	private static Employeecontroller employeecontroller;
	Employee emp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginFrame();				
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
		
	public LoginFrame() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame("Home page");
		frame.setBounds(480,80,420,600);
	    frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lUserLabel = new JLabel("Username");
		lUserLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		lUserLabel.setBounds(100, 100, 200, 30);
		lUserLabel.setForeground(Color.cyan);
		frame.getContentPane().add(lUserLabel);
		
		lPassword = new JLabel("Password");
		lPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
		lPassword.setBounds(100, 200, 200, 30);
		lPassword.setForeground(Color.cyan);
		frame.getContentPane().add(lPassword);
		
		textField = new JTextField();
		textField.setBounds(100, 150, 200, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		 
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 250, 200, 30);
		frame.getContentPane().add(passwordField);
		
		btnLoginButton = new JButton("Login");
		btnLoginButton.setBounds(100, 300, 200, 30);
		btnLoginButton.setFont(new Font("Calibri", Font.PLAIN, 13));
		frame.getContentPane().add(btnLoginButton);
		employeecontroller = new Employeecontroller();
		btnLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Employee emp =new Employee();
				String UID, UP;
				UID=textField.getText();
				UP=new String(passwordField.getPassword());
				emp = employeecontroller.checkLogin(UID, UP);
				
				if(emp.getUserId()==null && emp.getPassword()==null) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"You are not authorized user! Retry or Register!");
				}
				else 
					if(emp.getRole().equals("HRA")) {
							try {
							frame.dispose();	
							new HRAFrame();
								
							} catch (ClassNotFoundException | SQLException ex) {
								
								ex.printStackTrace();
							}
						}
						else if(emp.getRole()!=null){
							try {
								frame.dispose();
								new EmployeeHomePage(emp);
							} catch (ClassNotFoundException | SQLException e) {
								
								e.printStackTrace();
							}
					}
					else {
						JFrame f=new JFrame();
						JOptionPane.showMessageDialog(f,"User not activated !...");
					}
				} 
			
		});
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(100, 350, 200, 30);
		frame.add(btnRegister);
		btnRegister.setFont(new Font("Calibri", Font.PLAIN, 13));
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new RegisterFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
