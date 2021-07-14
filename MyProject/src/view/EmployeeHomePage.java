package view;

import javax.swing.*;
import model.Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeHomePage {

	private JFrame frame;

	
	public EmployeeHomePage(Employee emp) throws ClassNotFoundException, SQLException {
			
		frame = new JFrame("Employee Home Page");
		frame.setBounds(480,80,420,600);
	    frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lWelcome = new JLabel("Welcome to DashBoard");
		lWelcome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lWelcome.setForeground(Color.cyan);
		lWelcome.setBounds(133, 55, 203, 30);
		frame.getContentPane().add(lWelcome);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBounds(44, 107, 265, 30);
		frame.getContentPane().add(btnViewProfile);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewProfile(emp);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(125, 154, 265, 30);
		frame.getContentPane().add(btnUpdateProfile);
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					new UpdateProfile(emp);
				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
			}
		});	
		
		JButton btnApplyJob = new JButton("Apply for a Job");
		btnApplyJob.setBounds(44, 277, 265, 30);
		frame.getContentPane().add(btnApplyJob);
		btnApplyJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ApplyJobFrame(emp);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setBounds(97, 320, 265, 30);
		frame.getContentPane().add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				frame.dispose();
				new LoginFrame();
				frame.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
					}
				
			}
			
		});
			
			
		JButton btnAddSkill = new JButton("Add Skill");
		btnAddSkill.setBounds(44, 195, 265, 30);
		frame.getContentPane().add(btnAddSkill);
		btnAddSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddSkillFrame(emp);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}
			
		});
				
			

		
		JButton btnUpdateSkill = new JButton("Update your Skill");
		btnUpdateSkill.setBounds(125, 236, 265, 30);
		frame.getContentPane().add(btnUpdateSkill);
		btnUpdateSkill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				new UpdateSkillFrame(emp);
			} catch (Exception e1) {
				e1.printStackTrace();
					}
				
			}
			
		});

	}
	
}
