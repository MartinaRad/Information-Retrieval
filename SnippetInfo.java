import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SnippetInfo {
	public String title; 
	public ArrayList <String> keywords;
	public Image img; 
	

	private void SnippetInfo(String title, ArrayList<String> keywords, String img) {
		this.title = title; 
		this.keywords = keywords;
		this.img = Toolkit.getDefaultToolkit().getImage(img);
	}
	
	private void SnippetInfo() {
		this.title = null; 
		this.keywords = null;
		this.img = null;
	}

public static ArrayList<SnippetInfo>SnippetInit() {
	SnippetInfo List1 = new SnippetInfo();
	SnippetInfo List2 = new SnippetInfo();
	SnippetInfo List3 = new SnippetInfo();
	SnippetInfo List4 = new SnippetInfo();
	SnippetInfo List5 = new SnippetInfo();
	ArrayList <String> keywords = new ArrayList <String>();
	keywords.add("data1");
	keywords.add("data2");
	keywords.add("data1");
	keywords.add("data2");
	List1.SnippetInfo("Title1", keywords, "C:\\Users\\201217056\\Desktop\\1.png");
	List2.SnippetInfo("Title2", keywords, "C:\\Users\\201217056\\Desktop\\wiki.jpg");
	List3.SnippetInfo("Title3", keywords, "C:\\Users\\201217056\\Desktop\\wiki.jpg");
	List4.SnippetInfo("Title4", keywords, "C:\\Users\\201217056\\Desktop\\wiki.jpg");
	List5.SnippetInfo("Title5", keywords, "C:\\Users\\201217056\\Desktop\\wiki.jpg");
	ArrayList <SnippetInfo> List = new ArrayList <SnippetInfo>();
	List.add(List1);
	List.add(List2);
	List.add(List3);
	List.add(List4);
	List.add(List5);
	return List;
}
}
