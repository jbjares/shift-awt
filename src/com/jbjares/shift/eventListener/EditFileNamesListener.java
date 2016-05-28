package com.jbjares.shift.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EditFileNamesListener implements  ActionListener {
	

	private static final long serialVersionUID = 181722397503699048L;
	
	private JComboBox<String> oldFileCombobox = null;
	private JTextField oldFileTxtField = null;
	
	private JComboBox<String> newFileCombobox = null;
	private JTextField newnewFileTextField = null;
	
	private JTextField mergeFolderTxtField;
	
	

	
	public EditFileNamesListener(JTextField oldFileTxtField, JComboBox oldFileCombobox,JTextField newnewFileTextField, JComboBox newFileCombobox,JTextField mergeFolderTxtField) {
		this.oldFileCombobox=oldFileCombobox;
		this.oldFileTxtField=oldFileTxtField;
		this.newFileCombobox=newFileCombobox;
		this.newnewFileTextField=newnewFileTextField;
		this.mergeFolderTxtField=mergeFolderTxtField;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			File folder = new File(mergeFolderTxtField.getText());
			String oldName = oldFileCombobox.getSelectedItem().toString();
			String newName = oldFileTxtField.getText();
			new File(folder+"/"+oldName).renameTo(new File(folder+"/"+newName));
			
			String newoldName = newFileCombobox.getSelectedItem().toString();
			String newnewName = newnewFileTextField.getText();
			new File(folder+"/"+newoldName).renameTo(new File(folder+"/"+newnewName));
		
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage(),ex);
		}
	}
		
	
	public JComboBox<String> getOldFileCombobox() {
		return oldFileCombobox;
	}


	public void setOldFileCombobox(JComboBox<String> oldFileCombobox) {
		this.oldFileCombobox = oldFileCombobox;
	}


	public JTextField getOldFileTxtField() {
		return oldFileTxtField;
	}


	public void setOldFileTxtField(JTextField oldFileTxtField) {
		this.oldFileTxtField = oldFileTxtField;
	}


	public JComboBox<String> getNewFileCombobox() {
		return newFileCombobox;
	}


	public void setNewFileCombobox(JComboBox<String> newFileCombobox) {
		this.newFileCombobox = newFileCombobox;
	}


 	public JTextField getNewnewFileTextField() {
		return newnewFileTextField;
	}


	public void setNewnewFileTextField(JTextField newnewFileTextField) {
		this.newnewFileTextField = newnewFileTextField;
	}


	public JTextField getMergeFolderTxtField() {
		return mergeFolderTxtField;
	}


	public void setMergeFolderTxtField(JTextField mergeFolderTxtField) {
		this.mergeFolderTxtField = mergeFolderTxtField;
	}



}
