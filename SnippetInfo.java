import java.awt.Image;
import java.util.ArrayList;

public class SnippetInfo {
	public String title;
	public ArrayList<String> keywords;
	public Image img;
	
	public SnippetInfo(String title, ArrayList<String> keywords, Image img) {
		this.title = title;
		this.keywords = keywords;
		this.img = img;
	}
}
