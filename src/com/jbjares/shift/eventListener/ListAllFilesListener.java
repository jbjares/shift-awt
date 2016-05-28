package com.jbjares.shift.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListAllFilesListener implements  ActionListener {
	

	private static final long serialVersionUID = 181722397503699048L;
	
	private JTextField txtField = null;
	
	private JComboBox<String> combobox = null;

	
	public ListAllFilesListener(JTextField oldFileTxtField, JComboBox oldFileCombobox) {
		this.txtField=oldFileTxtField;
		this.combobox=oldFileCombobox;
	}


	public JTextField getTxtField() {
		return txtField;
	}


	public void setTxtField(JTextField txtField) {
		this.txtField = txtField;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
			if(txtField==null || txtField.getText()==null || txtField.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"empty txtField!");
				return;
			}
			File folder = new File(txtField.getText());
			if(folder==null || !folder.exists() || !folder.isDirectory()){
				JOptionPane.showMessageDialog(null,"empty folder!");
				return;
			}
			for(File file:folder.listFiles()){
				if(!file.exists()||file.isDirectory()){
					continue;
				}
				combobox.addItem(file.getName());
			}

	}


	public JComboBox<String> getCombobox() {
		return combobox;
	}


	public void setCombobox(JComboBox<String> combobox) {
		this.combobox = combobox;
	}
	
	

}
