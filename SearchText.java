

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchText implements ActionListener {
	public static JPanel searchPanel;
	JButton button;
	JTextField textField;
	public SearchText() {
		searchPanel = new JPanel();
		
		textField = new JTextField();
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
			String snippet = textField.getText();
			System.out.println(snippet);	//to delete
			button.setEnabled(false);
			textField.setEnabled(false);
			ResultList.resultPanel.setVisible(true);
		}
	}
}
