
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class ReadTextFile {
	JPanel textPanel;
	JFileChooser fileChooser = new JFileChooser();
	static JTextArea textArea = new JTextArea();
	File file;

	public ReadTextFile() {		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());

		textArea.setEditable(false);
		
		//delete later:
		fileChooser.setCurrentDirectory(new File(":C//Desktop"));
		int response = fileChooser.showOpenDialog(null); //select file to open
		if(response == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			try {
				//opening file
				BufferedReader input = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
				
				String getLine = null;
				int count = 1; //number of lines
				while((getLine=input.readLine())!=null && (count<=10)) //print a snippet of the file - only the first 10 lines
				{
					textArea.append(getLine);
					textArea.append("\n");
					count++;
					System.out.println(getLine);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
