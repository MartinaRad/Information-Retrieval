import java.io.File;

import javax.swing.JFileChooser;

public class Location {
	JFileChooser fileChooser;
	File file;
	public static File location;
	public static String Index_Path;
	
	public Location() {
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int response = fileChooser.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			location = fileChooser.getSelectedFile();	
			Index_Path = foldercr(System.getProperty("user.dir"));	//index directory
			UI.initUI();
		this.location = location;
		this.Index_Path = Index_Path;
		}
		if(response == JFileChooser.CANCEL_OPTION) {
			MyFrame.locationFlag = false;
		}
	}
	
	public static String foldercr(String dir) {
		new File(dir+"\\Index").mkdir();
		return dir+"\\Index";
	}
	
}
