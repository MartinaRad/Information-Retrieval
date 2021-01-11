
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem searchItem;
	JMenuItem helpItem;
	JScrollBar scrollBar;
	JScrollPane scrollPane;
	
	static JPanel panel;
	public static JPanel searchPanel;
	static String snippet;
	static JButton button;
	JTextField textField;
	static boolean locationFlag = false;
	static boolean searchFlag = false;
	MyFrame(){
		new SearchText();
		
		
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
		
		searchPanel = new JPanel();
		
		
		textField = new JTextField();
		textField.setFont(new Font("Courier", Font.ITALIC, 16));
		textField.setPreferredSize(new Dimension(500, 40));
		
		button = new JButton("Search");
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_ENTER); //Alt + Enter
		
		searchPanel.add(textField);
		searchPanel.add(button);
		
		
		panel.add(searchPanel, BorderLayout.NORTH);
		this.add(panel);
		this.pack();
		this.setSize(1080, 600); //set size after pack
		this.setVisible(true); //make frame visible	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loadItem) {
			Location location = new Location();
			locationFlag = true;
			System.out.println(locationFlag);
			UI.initUI();
			
			}
		/*if(e.getSource()== searchItem) {
			
		}*/
		if(e.getSource()==button)
		{
			snippet = textField.getText();
			searchFlag = true;
			
			new ResultList();
			panel.add(ResultList.scrollPane, BorderLayout.CENTER);
			this.pack();
			this.setSize(1080, 600);
		}
		if(e.getSource()== helpItem) {
			new NewWindow();
		}
	}

}
