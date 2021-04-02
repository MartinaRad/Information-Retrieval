
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem helpItem;
	JScrollBar scrollBar;
	JScrollPane scrollPane;
	
	static JPanel panel;
	JPanel searchPanel;
	static String snippet;
	JButton button;
	JTextField textField;
	static boolean locationFlag = false;
	MyFrame(){
		this.setTitle("Information Retrieval");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		//create Panel in the main Frame:
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//create Menu Bar Buttons:
		menuBar = new JMenuBar();
		
		loadItem = new JMenuItem("Choose Folder");
		helpItem = new JMenuItem("Help");
		
		loadItem.addActionListener(this);
		helpItem.addActionListener(this);
		
		loadItem.setMnemonic(KeyEvent.VK_C); // Alt + C
		helpItem.setMnemonic(KeyEvent.VK_H); // Alt + h
		
		menuBar.add(loadItem);
		menuBar.add(helpItem);
		
		this.setJMenuBar(menuBar);
		
		//create new Panel for Search Field
		searchPanel = new JPanel();
		
		textField = new JTextField();
		textField.setFont(new Font("Courier", Font.ITALIC, 16));
		textField.setPreferredSize(new Dimension(500, 40));
		
		button = new JButton("Search");
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_ENTER); //Alt + Enter
		
		searchPanel.add(textField);
		searchPanel.add(button);
		
		panel.add(searchPanel, BorderLayout.NORTH);	//add the search panel to the main frame panel
		this.add(panel);	//add main frame panel to main frame
		this.pack();
		this.setSize(1080, 600); //set size after pack
		this.setVisible(true); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loadItem) {
			new Location();	//enter new location
			}

		if(e.getSource()==button)
		{
			if(locationFlag)	//location has to be true
				{
				if (ResultList.isDrawn) {
					panel.remove(ResultList.scrollPane);	//deletes result panel, so a new search can be made
					this.pack();
					this.setSize(1080, 600);
					ResultList.isDrawn = false; 
					
				}
					snippet = textField.getText();	//query
					new ResultList();	//calls results
					panel.add(ResultList.scrollPane, BorderLayout.CENTER);	//adds result panel to main panel
					this.pack();
					this.setSize(1080, 600);
				}
			else
			{
				JOptionPane.showMessageDialog(button, "Enter File Directory!", "Error", JOptionPane.PLAIN_MESSAGE);	//error message if location is wrong
			}
		}
		if(e.getSource()== helpItem) {
			JOptionPane.showMessageDialog(panel, "1. Choose Directory Containg File to be Indexed (Choose Folder).\n"
			+ "2. Type Search Query.");
		}
	}

}
