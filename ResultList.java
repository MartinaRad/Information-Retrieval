

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultList {
	public static JPanel resultPanel = new JPanel();
	JLabel label;
	JLabel imageLabel;
	ImageIcon image;
	JLabel keywordsLabel;
	
	
	public ResultList() {
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));

		//Top Label:
		label = new JLabel("Top 10 results: ");
		label.setFont(new Font("Courier", Font.BOLD, 18));
		resultPanel.add(label);
		
		
		//Title:
		String title = "title example";	//delete later

		
		//Keywords:
		keywordsLabel = new JLabel(); //keywords
		String keywords[] = {"term1", "term2", "term3"};	//delete later
		String joinString = String.join(", ", keywords);
		
		keywordsLabel.setText("Keywords: " + joinString);
		keywordsLabel.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 14));

		//Image:
		
		ImageIcon image = new ImageIcon("C:\\Users\\201217056\\Desktop\\wiki.jpg");
		imageLabel = new JLabel();
		imageLabel.setText(title);
		imageLabel.setIcon(image);
		imageLabel.setFont(new Font("Courier", Font.BOLD, 18));
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		imageLabel.setVerticalTextPosition(JLabel.TOP);
		
	
		
		resultPanel.add(imageLabel);
		resultPanel.add(keywordsLabel);
	

		resultPanel.setVisible(false);
	}
}
