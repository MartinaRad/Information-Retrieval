

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class MyFrame extends JFrame implements ActionListener{
	
	JScrollPane scrollPane = new JScrollPane();
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem keywordsItem;
	JMenuItem searchItem;
	JMenuItem helpItem;
	
	//delete
	JLabel imagelabel;
	
	MyFrame(){
		new SearchText();
		new ShowText();
		new ResultList();
		
		this.setLayout(new BorderLayout());
		this.setTitle("Information Retrieval");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		
		loadItem = new JMenuItem("Load File...");
		saveItem = new JMenuItem("Save");
		keywordsItem = new JMenuItem("Extract Keywords");
		searchItem = new JMenuItem("Search");
		helpItem = new JMenuItem("Help");
		
		loadItem.addActionListener(this);
		keywordsItem.addActionListener(this);
		searchItem.addActionListener(this);
		saveItem.addActionListener(this);
		helpItem.addActionListener(this);
		
		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f
		loadItem.setMnemonic(KeyEvent.VK_L); // Alt + l
		keywordsItem.setMnemonic(KeyEvent.VK_K); // Alt + k
		searchItem.setMnemonic(KeyEvent.VK_S); // Alt + s
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h
		helpItem.setMnemonic(KeyEvent.VK_H); // Alt + h
		
		fileMenu.add(loadItem);
		fileMenu.add(keywordsItem);
		fileMenu.add(searchItem);
		fileMenu.add(saveItem);
		helpMenu.add(helpItem);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
		this.add(scrollPane);
		this.add(SearchText.searchPanel, BorderLayout.NORTH);
		this.add(ShowText.textPanel, BorderLayout.CENTER);
		this.add(ResultList.resultPanel, BorderLayout.SOUTH);
		this.pack();
		this.setSize(1080, 600); //set size after pack
		this.setVisible(true); //make frame visible

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loadItem) {
			//ReadTextFile txtFile = new ReadTextFile();
			this.getContentPane().add(ReadTextFile.textArea, BorderLayout.PAGE_START);
			this.setVisible(true);
		}
		if(e.getSource()== keywordsItem) {
			System.out.println("Keywords: ");
		}
		if(e.getSource()== searchItem) {
			System.out.println("Documents from database:");
		}
		if(e.getSource()== saveItem) {
			System.out.println("File saved!");
		}
		if(e.getSource()== helpItem) {
			new NewWindow();
		}
	}
}
