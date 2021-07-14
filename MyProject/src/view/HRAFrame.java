package view;

import javax.swing.*;
import model.Employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HRAFrame {
	private JFrame frame;
	private JLabel lHRAPortal;
	private JButton btnAllEmployees, btnViewEmpID, btnViewAllJobs,btnDeactivateJob, btnActivateJob, btnLogout;
	Employee emp = new Employee();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new HRAFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		HRAFrame() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame("HRA Portal");
	    frame.setBounds(480,80,420,600);
	    frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lHRAPortal = new JLabel("Welcome to HRA Portal");
		lHRAPortal.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lHRAPortal.setForeground(Color.cyan);
		lHRAPortal.setBounds(128, 33, 175, 20);
		frame.getContentPane().add(lHRAPortal);
		
		
		JButton bAddJob = new JButton("Add Job");
		bAddJob.setFont(new Font("Arial", Font.PLAIN, 13));
		bAddJob.setBounds(100, 30, 200, 30);
		frame.getContentPane().add(bAddJob);
		bAddJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});

		
		
		
		JButton bDeleteJob = new JButton("Delete Job");
		bDeleteJob.setFont(new Font("Arial", Font.PLAIN, 13));
		bDeleteJob.setBounds(100, 80, 200, 30);
		frame.getContentPane().add(bDeleteJob);
		bDeleteJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});

		
		
		
		btnActivateJob = new JButton("Activate Job");
		btnActivateJob.setFont(new Font("Arial", Font.PLAIN, 13));
		btnActivateJob.setBounds(100, 130, 200, 30);
		frame.getContentPane().add(btnActivateJob);
		btnActivateJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ActivateJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});

		
		btnDeactivateJob = new JButton("Deactivate Job");
		btnDeactivateJob.setFont(new Font("Arial", Font.PLAIN, 13));
		btnDeactivateJob.setBounds(100, 180, 200, 30);
		frame.getContentPane().add(btnDeactivateJob);
		btnDeactivateJob.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DeactivateJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});


		btnViewAllJobs = new JButton("View All Jobs");
		btnViewAllJobs.setFont(new Font("Arial", Font.PLAIN, 13));
		btnViewAllJobs.setBounds(100, 230, 200, 30);
		frame.getContentPane().add(btnViewAllJobs);
		btnViewAllJobs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobsFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		
		
		btnViewEmpID = new JButton("View Employees By ID");
		btnViewEmpID.setFont(new Font("Arial", Font.PLAIN, 13));
		btnViewEmpID.setBounds(100, 280, 200, 30);
		frame.getContentPane().add(btnViewEmpID);
		btnViewEmpID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EmpIDFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});


		btnAllEmployees = new JButton("View All Employees");
		btnAllEmployees.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAllEmployees.setBounds(100, 330, 200, 30);
		frame.getContentPane().add(btnAllEmployees);
		btnAllEmployees.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				try {
					new AllEmployeesFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}	
			}	
		});
		
		

		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.setFont(new Font("Arial", Font.PLAIN, 13));
		btnDeleteEmployee.setBounds(100, 380, 200, 30);
		frame.getContentPane().add(btnDeleteEmployee);
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteEmpFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		
		
		
		
		btnLogout = new JButton("LogOut");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 13));
		btnLogout.setBounds(100, 430, 200, 30);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					new LoginFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
}
