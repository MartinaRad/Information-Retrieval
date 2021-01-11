import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SnippetInfo2 {
	public String title; 
	public ArrayList <String> keywords;
	public Image img; 
	

	protected void SnippetInfo(String title, ArrayList<String> keywords, String img) {
		this.title = title; 
		this.keywords = keywords;
		this.img = Toolkit.getDefaultToolkit().getImage(img);
	}
/*	
	private ArrayList<SnippetInfo> SnippetInfo() {
		this.title = null; 
		this.keywords = null;
		this.img = null;
	}
/*
public static ArrayList<SnippetInfo2>SnippetInit() {
	SnippetInfo2 List1 = new SnippetInfo2();
	SnippetInfo2 List2 = new SnippetInfo2();
	SnippetInfo2 List3 = new SnippetInfo2();
	SnippetInfo2 List4 = new SnippetInfo2();
	SnippetInfo2 List5 = new SnippetInfo2();
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
	ArrayList <SnippetInfo2> List = new ArrayList <SnippetInfo2>();
	List.add(List1);
	List.add(List2);
	List.add(List3);
	List.add(List4);
	List.add(List5);
	return List;
}*/
}
