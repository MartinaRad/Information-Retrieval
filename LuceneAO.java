import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;

public class LuceneAO {
	public Path indexPath;
	public Path filesPath;
	public Analyzer analyzer;
	Index index;
	HashMap<String,String> paths = new HashMap<String,String>();
	
	public LuceneAO(Path indexPath, Path filesPath) {
		this.filesPath = filesPath;
		this.indexPath = indexPath;
		
		this.addFiles(filesPath.toFile());
		this.createAnalyzer();
		
		index = new Index(indexPath,analyzer);
	
		index.indexFiles(listIndexableFiles());
	}
	
	private ArrayList<File> listIndexableFiles(){
		Set<String> keySet = paths.keySet(); 
		ArrayList<File> fileList = new ArrayList<File>(keySet.size());
		for(String path :keySet ){
			fileList.add(new File(path));
		}
		return fileList;
	}
	
	public ArrayList<SnippetInfo> search(String orig) {
		Query q = null;
		try {
			q = new QueryParser("contents" , analyzer).parse(orig);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		ArrayList<SnippetMetaData> resultsData = index.search(q);
		return genSnippets(resultsData);
	}
	
	private ArrayList<SnippetInfo> genSnippets(ArrayList<SnippetMetaData> snippetsData) {
		ArrayList<SnippetInfo> results= new ArrayList<SnippetInfo>();
		
		for(SnippetMetaData data: snippetsData) {
			Image img = null;
			try {
				String imgPath =paths.get(data.filePath);
				if(imgPath != null) {
					System.out.println(paths.get(data.filePath));
					img = ImageIO.read(new File(paths.get(data.filePath)));
				}
			} catch (IOException e) {
				e.printStackTrace();
			};
			results.add(new SnippetInfo(data.title ,data.keywords,img));
		}
		return results;
	}
	
	private void createAnalyzer() {
		CustomAnalyzer analyzer = null;
		try {
			analyzer = CustomAnalyzer.builder()
					.withTokenizer("standard")
					.addTokenFilter("stop")
					.addTokenFilter("lowercase")
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.analyzer = analyzer;
	}
	
	private void addFiles(File file) {
		if(file.isDirectory()) {
			for(File f : file.listFiles()) {
				addFiles(f);
			}
		}else {
			if(file.getPath().endsWith(".txt")) {
				
				File[] parentDir = file.getParentFile().listFiles();
				File img = null;
				String type = "";
				
				for(int i =0; i<parentDir.length; i++) {
					if(parentDir[i].getAbsolutePath().equals(file.getAbsolutePath())) {
						if(i+ 1 < parentDir.length) {
							try {
								String mimetype = Files.probeContentType(parentDir[i+1].toPath());
								type = mimetype.split("/")[0];
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(type.equals("image")) {
								img = parentDir[i+1];
							}
						}
					}
				}
				if(img != null) {
					paths.put(file.getAbsolutePath(), img.getAbsolutePath());
				}else {
					paths.put(file.getAbsolutePath(), null);
				}
			}
		}
	}
	
	public void close() {
		try {
			index.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
