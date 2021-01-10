
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MyFrame extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem searchItem;
	JMenuItem helpItem;
	JScrollBar scrollBar;
	JScrollPane scrollPane;
	
	JPanel panel;
	
	
	MyFrame(){
		new SearchText();
		new ShowText();
		new ResultList();
		
		panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		this.setTitle("Information Retrieval");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		
		loadItem = new JMenuItem("Choose Folder");
		searchItem = new JMenuItem("Search");
		helpItem = new JMenuItem("Help");
		
		loadItem.addActionListener(this);
		searchItem.addActionListener(this);
		helpItem.addActionListener(this);
		
		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f
		loadItem.setMnemonic(KeyEvent.VK_C); // Alt + C
		searchItem.setMnemonic(KeyEvent.VK_S); // Alt + s
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h
		helpItem.setMnemonic(KeyEvent.VK_H); // Alt + h
		
		fileMenu.add(loadItem);
		fileMenu.add(searchItem);
		helpMenu.add(helpItem);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		
		
		this.add(panel);
		this.pack();
		this.setSize(1080, 600); //set size after pack
		this.setVisible(true); //make frame visible

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loadItem) {
			Location location = new Location();
		}
		if(e.getSource()== searchItem) {
				panel.add(SearchText.searchPanel, BorderLayout.NORTH);
				panel.add(ResultList.scrollPane, BorderLayout.CENTER);
				this.add(panel);
				this.pack();
				this.setSize(1080, 600); //set size after pack
		}
		
		if(e.getSource()== helpItem) {
			new NewWindow();
		}
	}

}
