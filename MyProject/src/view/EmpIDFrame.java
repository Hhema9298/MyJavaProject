package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.Employeecontroller;

import javax.swing.JButton;

public class EmpIDFrame {

	private JFrame frame;
	private JLabel lEnterEmployeeId;
	private JTextField textField;
	private JButton btnSubmit;
	private static Employeecontroller employeecontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EmpIDFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void EmployeeID() throws ClassNotFoundException, SQLException {
		frame = new JFrame("Employee ID");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lEnterEmployeeId = new JLabel("Enter Employee ID");
		lEnterEmployeeId.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEnterEmployeeId.setForeground(Color.cyan);
		lEnterEmployeeId.setBounds(37, 93, 145, 23);
		frame.getContentPane().add(lEnterEmployeeId);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(192, 92, 184, 23);
		frame.getContentPane().add(textField);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(138, 153, 129, 23);
		frame.getContentPane().add(btnSubmit);
		employeecontroller = new Employeecontroller();
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int EID;
				EID = Integer.parseInt(textField.getText());	
				employeecontroller.getEmployeeById(EID);
			}
		});
	}
	
	public EmpIDFrame() throws ClassNotFoundException, SQLException {
		EmployeeID();
	}
}
