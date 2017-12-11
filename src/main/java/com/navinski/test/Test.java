package com.navinski.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test extends JFrame implements ListSelectionListener, ActionListener {

	private JList list;
//	private JButton add = new JButton("Add");
	
	public Test() {
//		// we will need Vector for list initialization
//		Vector v = new Vector();
//		v.add("1");
//		v.add("2");
//		v.add("3");
//		v.add("4");
//		v.add("5");
		
		list = new JList();
		// here we seting up the way of highlighting one parameter
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// lets create a model and pass it to our list instead of its standart implementation
		DefaultListModel dlm = new DefaultListModel();
		list.setModel(dlm);
		
		// list will be sending messages to the form
		list.addListSelectionListener(this);
		
		JButton add = new JButton("Add");
		JButton del = new JButton("Del");
		
		// button will be sending messages to the form
		add.addActionListener(this);
		del.addActionListener(this);
		
		add.setName("add");
		del.setName("del");
		
		// creating panel for our buttons and making it layout
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 2));
		p.add(add);
		p.add(del);
		
		// adding list to the panel
		getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);
		
		// adding button to the bottom panel
		getContentPane().add(p,  BorderLayout.SOUTH);
		
		// setting the bounds
		setBounds(100, 100, 200, 200);
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {
			System.out.println("New index: " + list.getSelectedIndex());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		DefaultListModel dlm = (DefaultListModel) list.getModel();
		
		JButton sender = (JButton) e.getSource();
		
		if (sender.getName().equals("add")){
				dlm.addElement(String.valueOf(dlm.getSize()));
		}
		// Lets check the name before deleting and check index if its =-1,
        // if it is means there are no selected line
        if (sender.getName().equals("del") && list.getSelectedIndex() >= 0) {
            dlm.remove(list.getSelectedIndex());
        }
//		// model allows addition of new element
//		dlm.addElement(String.valueOf(dlm.getSize()));
	}

	public static void main(String args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Test t = new Test();
				t.setDefaultCloseOperation(t.EXIT_ON_CLOSE);
				t.setVisible(true);
			}
		});
	}

	
}
