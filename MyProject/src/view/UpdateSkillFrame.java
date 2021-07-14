package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Employeecontroller;
import model.Employee;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateSkillFrame {

	private JFrame frame;
	private JLabel lSkillName;
	private JTextField textField;
	Employeecontroller employeecontroller;

	public UpdateSkillFrame(Employee emp) throws ClassNotFoundException, SQLException {
		
		employeecontroller = new Employeecontroller();
		frame = new JFrame();
	    frame.setBounds(480,80,420,600);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		lSkillName = new JLabel("Update Skill");
		lSkillName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lSkillName.setForeground(Color.cyan);
		lSkillName.setBounds(64, 55, 80, 22);
		frame.getContentPane().add(lSkillName);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField.setBounds(166, 56, 179, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UID, Skill;
				Skill= textField.getText();
				UID= emp.getUserId();
				employeecontroller.addSkill(Skill,UID);
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSubmit.setBounds(132, 178, 89, 23);
		frame.getContentPane().add(btnSubmit);
			
	}
	
}
