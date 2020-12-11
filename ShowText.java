

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ShowText {
	//text Panel
	public static JPanel textPanel = new JPanel();
	JLabel titleLabel = new JLabel(); //title
	JTextArea textArea = new JTextArea(); //snippet of text article
	ImageIcon image = new ImageIcon(); //image of article?
	JTextArea keywordsArea = new JTextArea();
		
	public ShowText(){
		textPanel.setLayout(new BorderLayout());
		//delete later 
		//example of strings:
		String title = "Title example";
		String text = "It started out as just another Saturday.  April 26, 1986.  John R.\r\n"
				+ "MacDougall, 25, spent the day alone at his satellite TV dealership in Ocala,\r\n"
				+ "Florida, waiting for customers who never came.  \"It was,\" he says, \"a normal\r\n"
				+ "day in the doldrums of the satellite TV industry.\" But that night, MacDougall,\r\n"
				+ "5 feet 11, 225 pounds, and prone to nervously running his fingers through his\r\n"
				+ "reddish blond hair and adjusting his glasses, would transform into Captain\r\n"
				+ "Midnight and set the world of satellite television spinning.\r\n"
				+ "\r\n";
		String keywords[] = {"term1", "term2", "term3"};
		String joinString = String.join(", ", keywords);
		
		//Text Panel
		titleLabel.setText(title);
		titleLabel.setFont(new Font("Helvetica", Font.BOLD, 16));

		textArea.setText(text);
		textArea.setEditable(false);
				
		keywordsArea.setText("Keywords: " + joinString);
		keywordsArea.setFont(new Font("Helvetica", Font.BOLD + Font.ITALIC, 14));
		keywordsArea.setEditable(false);
		
		textPanel.add(titleLabel, BorderLayout.NORTH);
		textPanel.add(textArea, BorderLayout.CENTER);
		textPanel.add(keywordsArea, BorderLayout.SOUTH);
		textPanel.setVisible(false);

	}
}
