import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity;
import org.apache.lucene.store.FSDirectory;

public class Index {
	private IndexWriter writer;
	
	public Index(Path indexDir , Analyzer analyzer) {
		FSDirectory dir;
		try {
			
			dir = FSDirectory.open(indexDir);
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			
			TFIDFSimilarity similarity = new ClassicSimilarity();
			config.setSimilarity(similarity);
			writer = new IndexWriter(dir , config);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void indexFiles(ArrayList<File> files) {
		for(File f: files) {
			FileReader fr = null;
			try {
				Document doc = new Document();
				
				fr = new FileReader(f);
				doc.add(new TextField("contents" , fr));
				doc.add(new StringField("filename" , f.getName() , Field.Store.YES));
				doc.add(new StringField("path" , f.getPath() , Field.Store.YES));
				doc.add(new StringField("modDate" , (new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss z")).format(new Date(f.lastModified())) , Field.Store.YES));
				writer.addDocument(doc);
				
				fr.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<SnippetMetaData> search(Query q) {
		ArrayList<SnippetMetaData> snippets = new ArrayList<SnippetMetaData>();
		
		try {	
			IndexReader reader = DirectoryReader.open(writer);
			IndexSearcher searcher = new IndexSearcher(reader);
			
			TFIDFSimilarity similarity = new ClassicSimilarity();
			searcher.setSimilarity(similarity);
			
			TopScoreDocCollector collector = TopScoreDocCollector.create(10);
			
			searcher.search(q ,collector);
			ScoreDoc[] hits = collector.topDocs().scoreDocs;
			
			//printDocInfo(hits , searcher);
			
			for(int i=0; i<hits.length; ++i) {
				int docID = hits[i].doc;
				Document d = searcher.doc(docID);
						
				ArrayList<String> keywords = getMatchingKeywords(q,docID,searcher);
				SnippetMetaData sn = new SnippetMetaData(d.get("filename") , keywords , d.get("path"));
				snippets.add(sn);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return snippets;
	}
	
	public ArrayList<String> getMatchingKeywords(Query q ,int docID , IndexSearcher searcher) throws IOException{
		ArrayList<String> keywords = new ArrayList<String>();
		if(searcher.explain(q, docID).isMatch()) {
			Term term;
			if(q instanceof BooleanQuery) {
				for (BooleanClause clause : (BooleanQuery) q) {
						if(searcher.explain(clause.getQuery(), docID).isMatch()) {
							//System.out.println(clause.toString());
							//System.out.println(searcher.explain(clause.getQuery(), docID));
							term = ((TermQuery)clause.getQuery()).getTerm();
							keywords.add(term.text());
						}
				    }
			}
			if(q instanceof TermQuery) {
				term = ((TermQuery)q).getTerm();
				//System.out.println(term.text());
				keywords.add(term.text());
			}
		}
		return keywords;
	}
	
	public void close() throws IOException {
		writer.deleteAll();
		writer.commit();
		writer.close();
	}
}
