// Klasa Main

package jlogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

	JComboBox cmdLine;
	LogoInterpreter logoInterpreter;
	DefaultListModel outList;
	
	private Main() {
		JFrame frame=new JFrame("JLogo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(512,384));

		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		LogoScreen logoScreen=new LogoScreen();
		cmdLine = new JComboBox();
		cmdLine.setEditable(true);
		cmdLine.addActionListener(this);
		
		outList=new DefaultListModel();
		
		JList list = new JList(outList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(512, 80));
		
		logoScreen.setPreferredSize(new Dimension(512,384));
		panel.add(logoScreen);
		panel.add(cmdLine);
		panel.add(listScroller);
	
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
		
		logoScreen.turtlesSet();
		logoInterpreter=new LogoInterpreter(logoScreen,outList);
		logoInterpreter.start();
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("comboBoxEdited")) {
			
			JComboBox cb = (JComboBox)evt.getSource();
			String line = (String)cb.getSelectedItem();
			
			logoInterpreter.addCmd(line);
			cb.getEditor().selectAll();
		
			int i;
			
			for (i=0;i<cb.getItemCount();i++)
				if (line.equals((String)cb.getItemAt(i))) 
					break;
			
			if (i==cb.getItemCount()) cb.addItem(line);
	
		}
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	
		Main m = new Main();
	}		
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		} );
	}
}

