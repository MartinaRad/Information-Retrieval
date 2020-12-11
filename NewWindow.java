

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class NewWindow {
	JFrame frame = new JFrame();
	JLabel titleLabel = new JLabel("Help");
	JTextArea textArea = new JTextArea("Instructions:\n"
			+ "1. Open a document from File > Open.\n"
			+ "2. Extract the keywords from File > Keywords.\n"
			+ "3. Search for topics from the database when selecting File > Search.");
	
	
	public NewWindow() {
		titleLabel.setBounds(50,0,100,50);
		titleLabel.setFont(new Font(null,Font.PLAIN,20));
		
		textArea.setBounds(10,50,270,250);
		textArea.setFont(new Font(null,Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
				
		frame.add(textArea);
		frame.add(titleLabel);
		
		frame.setTitle("Help");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(300,300);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}
