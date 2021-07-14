package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;

import controller.Jobcontroller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeactivateJobFrame {

	private JFrame frame;
	private JLabel lEnterAJob;
	private JTextField textField;
	private JButton btnDeactivate;
	Jobcontroller jcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new DeactivateJobFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void DeactivateJob() throws ClassNotFoundException, SQLException {
		frame = new JFrame("Deactivate Job");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lEnterAJob = new JLabel("Enter a Job ID");
		lEnterAJob.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEnterAJob.setForeground(Color.cyan);
		lEnterAJob.setBounds(75, 93, 104, 23);
		frame.getContentPane().add(lEnterAJob);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(189, 92, 184, 23);
		frame.getContentPane().add(textField);
		
		btnDeactivate = new JButton("DEACTIVATE");
		jcontroller = new Jobcontroller();
		btnDeactivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EID;			
				EID = Integer.parseInt(textField.getText());
				jcontroller.deactivateJob(EID);
				JOptionPane.showMessageDialog(frame, "Deactivated Succesfully");
				frame.dispose();
			}
		});
		btnDeactivate.setBounds(158, 154, 129, 23);
		frame.getContentPane().add(btnDeactivate);
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeactivateJobFrame() throws ClassNotFoundException, SQLException {
		DeactivateJob();
	}
}
