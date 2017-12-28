package com.navinski.student.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.navinski.student.logic.Group;

public class GroupDialog extends JDialog implements ActionListener {
	
	private static final int D_HEIGHT = 150; // visota
	private final static int D_WIDTH = 200; // shirina
	private JSpinner spYear;
	private JComboBox groupList;
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private boolean result = false;
	
	public GroupDialog(int year, List groups) {
		// setup the header
		setTitle("Moving the group");
		
		//some new comment
		//Creating complicated layout
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		// creating variable for setting up location rules
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		
		// First element - header for field selector of groups
		JLabel l = new JLabel("New group: ");
		// after components could be located
		c.gridwidth = GridBagConstraints.RELATIVE;
		// not felling in all the space, reserved for component
		c.fill = GridBagConstraints.NONE;
		// "tying up" components to the right shoulder
		c.anchor = GridBagConstraints.EAST;
		// setting this rule for our component
		gbl.setConstraints(l,  c);
		// adding the component
		getContentPane().add(l);
		
		// second element - list of groups
		groupList = new JComboBox(new Vector(groups));
		// element which takes the rest of all available space
		c.gridwidth = GridBagConstraints.REMAINDER;
		// stretching component through the all space
		c.fill = GridBagConstraints.BOTH;
		// tying it to the left border
		c.anchor = GridBagConstraints.WEST;
		// Setting that rule for our component
		gbl.setConstraints(groupList,  c);
		// Adding component
		getContentPane().add(groupList);
		
		// third element = header for field year
		l = new JLabel("New year: ");
		// after it its possible to place components
		c.gridwidth = GridBagConstraints.RELATIVE;
		// not filling all the space reserved for component
		c.fill = GridBagConstraints.NONE;
		// tying component to the right border
		c.anchor = GridBagConstraints.EAST;
		// setting that rule for our component
		gbl.setConstraints(l,  c);
		// adding component
		getContentPane().add(l);
		
		// same time increasing group for 1 year
		spYear = new JSpinner(new SpinnerNumberModel(year + 1, 1900, 2100, 1));
		// element takes all the width left
		c.gridwidth = GridBagConstraints.REMAINDER;
		// stretching component for the full width
		c.fill = GridBagConstraints.BOTH;
		// tying it to the left border
		c.anchor = GridBagConstraints.WEST;
		// setting this rule for component
		gbl.setConstraints(spYear, c);
		
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.fill = GridBagConstraints.BOTH;
		btnOk.setName("OK");
		// adding listener
		btnOk.addActionListener(this);
		// setting up this rule for our component
		gbl.setConstraints(btnOk, c);
		// adding component
		getContentPane().add(btnCancel);
		
		// setting up the behavior of the form at the time of closing
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// receiving the size of the screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		// and now placing it to the center, calculating its coordinates
		setBounds(((int) d.getWidth() - GroupDialog.D_WIDTH) / 2, 
				((int) d.getHeight() - GroupDialog.D_HEIGHT) / 2,
				GroupDialog.D_WIDTH, GroupDialog.D_HEIGHT);
	}
	
	// returning the year, which set up on the form
	public int getYear() {
		return ((SpinnerNumberModel) spYear.getModel()).getNumber().intValue();
	}
	
	//	returning the group? which set on the form
	public Group getGroup() {
		if(groupList.getModel().getSize() > 0) {
			return (Group) groupList.getSelectedItem();
		}
		return null;
	}

	public boolean getResult() {
		return result;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (src.getName().equals("OK")) {
			result = true;
		}
		if(src.getName().equals("Cancel")) {
			result = false;
		}
		setVisible(false);
		
	}

	
	
	
}
