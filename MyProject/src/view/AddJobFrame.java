package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JTextField;
import controller.Jobcontroller;
import javax.swing.JButton;

public class AddJobFrame {

	private JFrame frame;
	private JTextField textField,textField1,textField2,textField3,textField4,textField5;
	Jobcontroller jobcontroller;


	public AddJobFrame() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 456, 383);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblJobTitle.setForeground(Color.cyan);
		lblJobTitle.setBounds(52, 30, 81, 22);
		frame.getContentPane().add(lblJobTitle);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(163, 31, 179, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblJobDescription.setForeground(Color.cyan);
		lblJobDescription.setBounds(52, 76, 101, 22);
		frame.getContentPane().add(lblJobDescription);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField1.setColumns(10);
		textField1.setBounds(163, 77, 179, 20);
		frame.getContentPane().add(textField1);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCompanyName.setForeground(Color.cyan);
		lblCompanyName.setBounds(52, 120, 114, 22);
		frame.getContentPane().add(lblCompanyName);
		
		JLabel lblLocation = new JLabel("Location ");
		lblLocation.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblLocation.setForeground(Color.cyan);
		lblLocation.setBounds(52, 165, 81, 22);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblKeySkill = new JLabel("Key Skill ");
		lblKeySkill.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblKeySkill.setForeground(Color.cyan);
		lblKeySkill.setBounds(52, 208, 81, 22);
		frame.getContentPane().add(lblKeySkill);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSalary.setForeground(Color.cyan);
		lblSalary.setBounds(52, 253, 81, 22);
		frame.getContentPane().add(lblSalary);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField2.setColumns(10);
		textField2.setBounds(163, 254, 179, 20);
		frame.getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField3.setColumns(10);
		textField3.setBounds(163, 209, 179, 20);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField4.setColumns(10);
		textField4.setBounds(163, 166, 179, 20);
		frame.getContentPane().add(textField4);
		
		textField5 = new JTextField();
		textField5.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField5.setColumns(10);
		textField5.setBounds(163, 121, 179, 20);
		frame.getContentPane().add(textField5);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSubmit.setBounds(148, 310, 89, 23);
		frame.getContentPane().add(btnSubmit);
		jobcontroller = new Jobcontroller();
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2,s3,s4,s5,s6;
				s1=textField.getText();
				s2=textField1.getText();
				s3=textField5.getText();
				s4=textField4.getText();
				s5=textField3.getText();
				s6=textField2.getText();
				jobcontroller.addJob(s1,s2,s3,s4,s5,s6);
				frame=new JFrame();
				JOptionPane.showMessageDialog(frame,"Job Added");
			}
		});
	}
	
}
