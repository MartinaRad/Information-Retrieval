

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ShowText {
	//text Panel
	public static JPanel textPanel = new JPanel();
	JLabel titleLabel = new JLabel(); //title
	JTextArea textArea = new JTextArea(); //snippet of text article
	JTextArea keywordsArea = new JTextArea();
	
		
	public ShowText(){
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		
		//delete later 
		
		//example of strings:
		String title = "Title example";
		String text = "It started out as just another Saturday.  April 26, 1986.  John R. MacDougall, 25, spent the day alone at his satellite TV dealership in Ocala Florida, waiting for customers who never came.  \"It was,\" he says, \"a normal day in the doldrums of the satellite TV industry.\" But that night, MacDougall";
		String keywords[] = {"term1", "term2", "term3"};
		String joinString = String.join(", ", keywords);
		
		//Text Panel
		titleLabel.setText(title);
		titleLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		textArea.setText(text);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		

		keywordsArea.setText("Keywords: " + joinString);
		keywordsArea.setFont(new Font("Helvetica", Font.BOLD + Font.ITALIC, 12));
		keywordsArea.setLineWrap(true);
		keywordsArea.setEditable(false);
				
		//add components:
		
		textPanel.add(titleLabel);
		
		textPanel.add(textArea);
		Dimension minSize = new Dimension(10, 5);
		Dimension prefSize = new Dimension(10, 10);
		Dimension maxSize = new Dimension(10, 10);
		textPanel.add(new Box.Filler(minSize, prefSize, maxSize));	//size of text area
		
		textPanel.add(keywordsArea);

		textPanel.setVisible(false);
		

	}
}
