import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class UI {
	
	public static Path indexPath;
	public static Path filesPath;
	public static String query;
	public static ArrayList<SnippetInfo> snippets;
	
	public static void main(String[] args) {
		new MyFrame();
		new UI();
	}
	
	/*
	 * Take type of File we want to index and call initPaths() 
	 */
	public static void initUI() {
			initPaths();
	}
	
	/*
	 * Takes path given by user and check if they exist.
	 * */
	private static void initPaths() {
		boolean valid= false;
		File dir;
		
		while(!valid) {
			dir = new File(Location.Index_Path);
			if(!dir.exists()) {
				System.out.println("False path");
			}else {
				MyFrame.locationFlag = true;
				indexPath = dir.toPath();
				valid= true;
			}
		}
		valid = false;
		dir = null;
		
		while(!valid) {
			dir = Location.location;
			if(!dir.exists()) {
				System.out.println("False path");
			}else {
				MyFrame.locationFlag = true;
				filesPath = dir.toPath();
				valid= true;
			}
		}
	}
}

