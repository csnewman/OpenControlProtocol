package com.error22.ocp.debugger;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DebuggerWindow {

	private JFrame frmDebuggerMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new DebuggerWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DebuggerWindow() {
		initialize();
		frmDebuggerMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDebuggerMenu = new JFrame();
		frmDebuggerMenu.setResizable(false);
		frmDebuggerMenu.setTitle("Debugger Menu - OCP - Error22");
		frmDebuggerMenu.setBounds(100, 100, 300, 277);
		frmDebuggerMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDebuggerMenu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Error22 - Open Control Protocol - Debugger");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 274, 14);
		frmDebuggerMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblVersion = new JLabel("V1.0 - Copyright \u00A9 2015 Error22, All Rights Reserved.");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setBounds(10, 226, 274, 14);
		frmDebuggerMenu.getContentPane().add(lblVersion);
		
		JButton btnNewButton = new JButton("Computer Manager");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 40, 274, 30);
		frmDebuggerMenu.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Computer Client");
		button.setEnabled(false);
		button.setBounds(10, 76, 274, 30);
		frmDebuggerMenu.getContentPane().add(button);
		
		JButton btnUnused = new JButton("Unused");
		btnUnused.setEnabled(false);
		btnUnused.setBounds(10, 112, 274, 30);
		frmDebuggerMenu.getContentPane().add(btnUnused);
		
		JButton btnUnused_1 = new JButton("Device Manager");
		btnUnused_1.setEnabled(false);
		btnUnused_1.setBounds(10, 148, 274, 30);
		frmDebuggerMenu.getContentPane().add(btnUnused_1);
		
		JButton btnManualcustom = new JButton("Manual/Custom");
		btnManualcustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDebuggerMenu.dispose();
				new ManualFrame();
			}
		});
		btnManualcustom.setBounds(10, 184, 274, 30);
		frmDebuggerMenu.getContentPane().add(btnManualcustom);
	}
}
