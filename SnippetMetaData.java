import java.util.ArrayList;

public class SnippetMetaData {
	public String title;
	public ArrayList<String> keywords;
	public String filePath;
	
	public SnippetMetaData(String title, ArrayList<String> keywords, String filePath) {
		this.title = title;
		this.keywords = keywords;
		this.filePath = filePath;
	}
}
