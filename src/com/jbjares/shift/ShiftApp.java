package com.jbjares.shift;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.jbjares.shift.eventListener.EditFileNamesListener;
import com.jbjares.shift.eventListener.ListAllFilesListener;

public class ShiftApp {

	private JFrame frame;
	private JTextField oldoldFileTextField;
	private JTextField newnewFileTextField;
	private JTextField oldFileTxtField;
	private JTextField newFileTxtField;
	private JTextField mergeFolderTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShiftApp window = new ShiftApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShiftApp() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel editTab = new JPanel();
		tabbedPane.addTab("Edit", null, editTab, null);
		GridBagLayout gbl_editTab = new GridBagLayout();
		gbl_editTab.columnWidths = new int[]{0, 0, 0, 0};
		gbl_editTab.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_editTab.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_editTab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		editTab.setLayout(gbl_editTab);
		
		JLabel lblExistentFileBase = new JLabel("Old File Base Folder:");
		GridBagConstraints gbc_lblExistentFileBase = new GridBagConstraints();
		gbc_lblExistentFileBase.insets = new Insets(0, 0, 5, 5);
		gbc_lblExistentFileBase.anchor = GridBagConstraints.EAST;
		gbc_lblExistentFileBase.gridx = 1;
		gbc_lblExistentFileBase.gridy = 1;
		editTab.add(lblExistentFileBase, gbc_lblExistentFileBase);
		
		oldFileTxtField = new JTextField();
		GridBagConstraints gbc_oldFileTxtField = new GridBagConstraints();
		gbc_oldFileTxtField.insets = new Insets(0, 0, 5, 0);
		gbc_oldFileTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_oldFileTxtField.gridx = 2;
		gbc_oldFileTxtField.gridy = 1;
		editTab.add(oldFileTxtField, gbc_oldFileTxtField);
		oldFileTxtField.setColumns(10);
		
		JLabel lblFileBseFolder = new JLabel("New File Bse Folder: ");
		GridBagConstraints gbc_lblFileBseFolder = new GridBagConstraints();
		gbc_lblFileBseFolder.anchor = GridBagConstraints.EAST;
		gbc_lblFileBseFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileBseFolder.gridx = 1;
		gbc_lblFileBseFolder.gridy = 2;
		editTab.add(lblFileBseFolder, gbc_lblFileBseFolder);
		
		newFileTxtField = new JTextField();
		GridBagConstraints gbc_newFileTxtField = new GridBagConstraints();
		gbc_newFileTxtField.insets = new Insets(0, 0, 5, 0);
		gbc_newFileTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newFileTxtField.gridx = 2;
		gbc_newFileTxtField.gridy = 2;
		editTab.add(newFileTxtField, gbc_newFileTxtField);
		newFileTxtField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Folder to Hold Files: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		editTab.add(lblNewLabel, gbc_lblNewLabel);
		
		mergeFolderTxtField = new JTextField();
		GridBagConstraints gbc_mergeFolderTxtField = new GridBagConstraints();
		gbc_mergeFolderTxtField.insets = new Insets(0, 0, 5, 0);
		gbc_mergeFolderTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mergeFolderTxtField.gridx = 2;
		gbc_mergeFolderTxtField.gridy = 4;
		editTab.add(mergeFolderTxtField, gbc_mergeFolderTxtField);
		mergeFolderTxtField.setColumns(10);
		
		JButton editCanceBtn = new JButton("Cancel");
		GridBagConstraints gbc_editCanceBtn = new GridBagConstraints();
		gbc_editCanceBtn.anchor = GridBagConstraints.EAST;
		gbc_editCanceBtn.insets = new Insets(0, 0, 5, 5);
		gbc_editCanceBtn.gridx = 1;
		gbc_editCanceBtn.gridy = 6;
		editTab.add(editCanceBtn, gbc_editCanceBtn);
		
		editCanceBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JButton editConfirmBtn = new JButton("Confirm");
		GridBagConstraints gbc_editConfirmBtn = new GridBagConstraints();
		gbc_editConfirmBtn.insets = new Insets(0, 0, 5, 0);
		gbc_editConfirmBtn.anchor = GridBagConstraints.EAST;
		gbc_editConfirmBtn.gridx = 2;
		gbc_editConfirmBtn.gridy = 6;
		editTab.add(editConfirmBtn, gbc_editConfirmBtn);

		
				
		JPanel shiftTab = new JPanel();
		tabbedPane.addTab("Shift", null, shiftTab, null);
		GridBagLayout gbl_shiftTab = new GridBagLayout();
		gbl_shiftTab.columnWidths = new int[]{0, 0, 0};
		gbl_shiftTab.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_shiftTab.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_shiftTab.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		shiftTab.setLayout(gbl_shiftTab);
		
		JLabel actualFileLabel = new JLabel("Actual File: ");
		GridBagConstraints gbc_actualFileLabel = new GridBagConstraints();
		gbc_actualFileLabel.anchor = GridBagConstraints.EAST;
		gbc_actualFileLabel.insets = new Insets(0, 0, 5, 5);
		gbc_actualFileLabel.gridx = 0;
		gbc_actualFileLabel.gridy = 1;
		shiftTab.add(actualFileLabel, gbc_actualFileLabel);
		
		JComboBox oldFileCombobox = new JComboBox();

		GridBagConstraints gbc_oldFileCombobox = new GridBagConstraints();
		gbc_oldFileCombobox.insets = new Insets(0, 0, 5, 0);
		gbc_oldFileCombobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_oldFileCombobox.gridx = 1;
		gbc_oldFileCombobox.gridy = 1;
		shiftTab.add(oldFileCombobox, gbc_oldFileCombobox);
		
		JLabel actualFileNameLabel = new JLabel("Actual File - New Name: ");
		GridBagConstraints gbc_actualFileNameLabel = new GridBagConstraints();
		gbc_actualFileNameLabel.anchor = GridBagConstraints.EAST;
		gbc_actualFileNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_actualFileNameLabel.gridx = 0;
		gbc_actualFileNameLabel.gridy = 2;
		shiftTab.add(actualFileNameLabel, gbc_actualFileNameLabel);
		
		oldoldFileTextField = new JTextField();
		GridBagConstraints gbc_oldoldFileTextField = new GridBagConstraints();
		gbc_oldoldFileTextField.insets = new Insets(0, 0, 5, 0);
		gbc_oldoldFileTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_oldoldFileTextField.gridx = 1;
		gbc_oldoldFileTextField.gridy = 2;
		shiftTab.add(oldoldFileTextField, gbc_oldoldFileTextField);
		oldoldFileTextField.setColumns(10);

		
		JLabel newFileLabel = new JLabel("New File - New Name");
		GridBagConstraints gbc_newFileLabel = new GridBagConstraints();
		gbc_newFileLabel.anchor = GridBagConstraints.EAST;
		gbc_newFileLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newFileLabel.gridx = 0;
		gbc_newFileLabel.gridy = 3;
		shiftTab.add(newFileLabel, gbc_newFileLabel);
		
		JComboBox newFileComboBox = new JComboBox();
		GridBagConstraints gbc_newFileComboBox = new GridBagConstraints();
		gbc_newFileComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_newFileComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_newFileComboBox.gridx = 1;
		gbc_newFileComboBox.gridy = 3;
		shiftTab.add(newFileComboBox, gbc_newFileComboBox);
		editConfirmBtn.addActionListener(new ListAllFilesListener(newFileTxtField,newFileComboBox));
		
		JLabel lblRenameTheNew = new JLabel("Rename The New File: ");
		GridBagConstraints gbc_lblRenameTheNew = new GridBagConstraints();
		gbc_lblRenameTheNew.anchor = GridBagConstraints.EAST;
		gbc_lblRenameTheNew.insets = new Insets(0, 0, 5, 5);
		gbc_lblRenameTheNew.gridx = 0;
		gbc_lblRenameTheNew.gridy = 4;
		shiftTab.add(lblRenameTheNew, gbc_lblRenameTheNew);
		
		newnewFileTextField = new JTextField();
		GridBagConstraints gbc_newnewFileTextField = new GridBagConstraints();
		gbc_newnewFileTextField.insets = new Insets(0, 0, 5, 0);
		gbc_newnewFileTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newnewFileTextField.gridx = 1;
		gbc_newnewFileTextField.gridy = 4;
		shiftTab.add(newnewFileTextField, gbc_newnewFileTextField);
		newnewFileTextField.setColumns(10);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		

		
		JButton editDefaultBtn = new JButton("Default");
		GridBagConstraints gbc_editDefaultBtn = new GridBagConstraints();
		gbc_editDefaultBtn.anchor = GridBagConstraints.EAST;
		gbc_editDefaultBtn.insets = new Insets(0, 0, 0, 5);
		gbc_editDefaultBtn.gridx = 1;
		gbc_editDefaultBtn.gridy = 7;
		editTab.add(editDefaultBtn, gbc_editDefaultBtn);
		
		JButton shiftCanceBtn = new JButton("Cancel");
		GridBagConstraints gbc_shiftCanceBtn = new GridBagConstraints();
		gbc_shiftCanceBtn.anchor = GridBagConstraints.EAST;
		gbc_shiftCanceBtn.insets = new Insets(0, 0, 5, 5);
		gbc_shiftCanceBtn.gridx = 0;
		gbc_shiftCanceBtn.gridy = 6;
		shiftTab.add(shiftCanceBtn, gbc_shiftCanceBtn);
		
		shiftCanceBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JButton shiftConfirmBtn = new JButton("Confirm");
		GridBagConstraints gbc_shiftConfirmBtn = new GridBagConstraints();
		gbc_shiftConfirmBtn.insets = new Insets(0, 0, 5, 0);
		gbc_shiftConfirmBtn.anchor = GridBagConstraints.EAST;
		gbc_shiftConfirmBtn.gridx = 1;
		gbc_shiftConfirmBtn.gridy = 6;
		shiftTab.add(shiftConfirmBtn, gbc_shiftConfirmBtn);
		
		JButton sgiftDefaultBtn = new JButton("Default");
		sgiftDefaultBtn.setVisible(Boolean.FALSE);
		sgiftDefaultBtn.setEnabled(false);
		sgiftDefaultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_sgiftDefaultBtn = new GridBagConstraints();
		gbc_sgiftDefaultBtn.anchor = GridBagConstraints.EAST;
		gbc_sgiftDefaultBtn.insets = new Insets(0, 0, 5, 5);
		gbc_sgiftDefaultBtn.gridx = 0;
		gbc_sgiftDefaultBtn.gridy = 7;
		shiftTab.add(sgiftDefaultBtn, gbc_sgiftDefaultBtn);
		
		//==========
		editConfirmBtn.addActionListener(new ListAllFilesListener(oldFileTxtField,oldFileCombobox));
		shiftConfirmBtn.addActionListener(new EditFileNamesListener(oldoldFileTextField, oldFileCombobox, newnewFileTextField, newFileComboBox, mergeFolderTxtField));
		editDefaultBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newFileTxtField.setText("C:\\ProgramFilesDevel\\jboss-as-7.1.1.Final\\standalone\\configuration");
				oldFileTxtField.setText("C:\\ProgramFilesDevel\\jboss-as-7.1.1.Final\\standalone\\configuration");
				mergeFolderTxtField.setText("C:\\ProgramFilesDevel\\jboss-as-7.1.1.Final\\standalone\\configuration");
			}
		});
		
	}


}
