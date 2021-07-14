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

import controller.Jobcontroller;

import javax.swing.JButton;

public class JobIDFrame {

	private JFrame frame;
	private JLabel lEnterJobId;
	private JTextField textField;
	private JButton btnSubmit;
	private static Jobcontroller jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new JobIDFrame();
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
		
		lEnterJobId = new JLabel("Enter JOB ID");
		lEnterJobId.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEnterJobId.setForeground(Color.cyan);
		lEnterJobId.setBounds(37, 93, 145, 23);
		frame.getContentPane().add(lEnterJobId);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(192, 92, 184, 23);
		frame.getContentPane().add(textField);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(138, 153, 129, 23);
		frame.getContentPane().add(btnSubmit);
		jobcontroller = new Jobcontroller();
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int JID;
				JID = Integer.parseInt(textField.getText());	
				jobcontroller.getJobById(JID);
			}
		});
	}
	public JobIDFrame() throws ClassNotFoundException, SQLException {
		EmployeeID();
	}
}
