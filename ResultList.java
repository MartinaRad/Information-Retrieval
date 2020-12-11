import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultList {
	public static JPanel resultPanel;
	JLabel label;
	JLabel titlelabel;
	//JLabel imagelabel;
	JTextField resultsField;
	ImageIcon image;
	
	
	public ResultList() {
		resultPanel = new JPanel();
		
		resultsField = new JTextField();
		resultsField.setEnabled(false);
		
		titlelabel = new JLabel("title1");
	
		ImageIcon image = new ImageIcon("C:\\Users\\201217056\\Desktop\\wiki.jpg");
		titlelabel.setIcon(image);
		
		String array[] = {"title1", "title2", "title3", "title4"};
		
		GridLayout layout = new GridLayout(10, 2);
		resultPanel.setLayout(layout);
		
		label = new JLabel("Top 10 results: ");
		resultPanel.add(label);
		//resultPanel.add(titlelabel);
		
		for (int i = 0; i < 4; i++)
			{
					//resultPanel.add(label);
					
					String result = (i+1) + ": " + array[i];
					
					resultPanel.add(new JTextField(result));
					//resultPanel.add(label);
					//resultPanel.add(titlelabel);
					//resultPanel.add(imagelabel);
			}
		//resultPanel.add(resultsField, BorderLayout.NORTH);
		resultPanel.setVisible(false);
	}
}
