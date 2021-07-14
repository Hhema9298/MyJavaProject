package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.Jobcontroller;

import javax.swing.JButton;

public class ActivateJobFrame {

	private JFrame frame;
	JLabel lJobID;
	private JTextField textField;
	Jobcontroller jcontroller;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ActivateJobFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void ActivateJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
		
		lJobID = new JLabel("Job ID :");
		lJobID.setFont(new Font("Calibri", Font.PLAIN, 15));
		lJobID.setForeground(Color.cyan);
		lJobID.setBounds(88, 103, 71, 23);
		frame.getContentPane().add(lJobID);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(169, 102, 184, 23);
		frame.getContentPane().add(textField);
		
		JButton btnActivate = new JButton("ACTIVATE");
		jcontroller = new Jobcontroller();
		btnActivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int EID;			
				EID = Integer.parseInt(textField.getText());
				jcontroller.activateJob(EID);
				JOptionPane.showMessageDialog(frame, "Activated Succesfully");
				frame.dispose();
			}
			
		});
		btnActivate.setBounds(138, 164, 129, 23);
		frame.getContentPane().add(btnActivate);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ActivateJobFrame() throws ClassNotFoundException, SQLException {
		ActivateJob();
	}

}
