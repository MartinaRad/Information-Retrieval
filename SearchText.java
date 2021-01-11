

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchText implements ActionListener {
	public static JPanel searchPanel;
	static String snippet;
	static JButton button;
	JTextField textField;
	
	static boolean searchFlag = false;
	
	public SearchText() {
		searchPanel = new JPanel();
		
		
		textField = new JTextField();
		textField.setFont(new Font("Courier", Font.ITALIC, 16));
		textField.setPreferredSize(new Dimension(500, 40));
		
		button = new JButton("Search");
		button.addActionListener(this);
		button.setMnemonic(KeyEvent.VK_ENTER); //Alt + Enter
		
		searchPanel.add(textField);
		searchPanel.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			
			snippet = textField.getText();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			searchFlag = true;
			/*UI.getQuery();
			System.out.println(snippet);	//to delete
			button.setEnabled(false);
			textField.setEnabled(false);
			*
			new ResultList();
			MyFrame.panel.add(ResultList.scrollPane, BorderLayout.CENTER);
			*/
			//ResultList.resultPanel.setVisible(true);
			//searchPanel.add(ResultList.scrollPane, BorderLayout.CENTER);
					
		}
	}
}
