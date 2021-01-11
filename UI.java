import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	
	private Scanner scan;
	public static Path indexPath;
	public static Path filesPath;
	public static String query;
	public static ArrayList<SnippetInfo> snippets;
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		UI userInt = new UI();
		
		while(true)
		{
			//System.out.println("Hello");
			
			if(MyFrame.locationFlag==true)
			{
				System.out.println("Hello");
				userInt.initUI();
				
				LuceneAO lucene = new LuceneAO(UI.indexPath, UI.filesPath);
				
				if(MyFrame.searchFlag == true)
				{
					while(true) {		
						String query = UI.getQuery();
						if(query.equals("quit")) break;
						
						snippets = lucene.search(query);
						for(SnippetInfo snippet : snippets) {
							System.out.println(snippet.title);
							for(String keyword: snippet.keywords) {
								System.out.println("  " + keyword);
							}
						}
					}
					lucene.close();
					userInt.scan.close();
					break;
				}
				
			}
		}

	}
	
	public static String getQuery() {
		System.out.println("Enter Query (type 'quit' to quit):");
		return MyFrame.snippet;
		//return scan.nextLine();
	}
	
	/*
	 * Take type of File we want to index and call initPaths() 
	 */
	public static void initUI() {
		//this.scan = new Scanner(System.in);
		initPaths();
		
	}
	
	
	/*
	 * Takes path given by user and check if they exist.
	 * */
	private static void initPaths() {
		boolean valid= false;
		File dir;
		
		while(!valid) {
			System.out.println("Enter full path to directory in which index will be stored:\n"
					+ "(c:/Folder/IndexFolder)");
			dir = new File(Location.Index_Path);
			System.out.println("new path:" + dir);
			
			//dir = new File(scan.nextLine());
			if(!dir.exists()) {
				System.out.println("False path");
			}else {
				indexPath = dir.toPath();
				System.out.println(indexPath.getClass().getSimpleName());
				valid= true;
			}
		}
		valid = false;
		dir = null;
		
		while(!valid) {
			System.out.println("Enter full path to directory containing file to be indexed:\n"
					+ "(c:/Folder/FileFolder)");
			
			dir = Location.location;
			//dir = new File(scan.nextLine());
			if(!dir.exists()) {
				System.out.println("False path");
			}else {
				filesPath = dir.toPath();
				System.out.println(filesPath.getClass().getSimpleName());
				valid= true;
			}
		}
	}
}

