package com.liepin.qiushi.lucene.core;

import junit.framework.TestCase;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class TestAnalyzer extends TestCase {

	Directory dir;
	Analyzer analyzer;

	@Override
	protected void setUp() throws Exception {
		String txt = "京华时报1月23日报道 昨天，受一股来自中西伯利亚的强冷空气影响，本市出现大风降温天气，白天最高气温只有零下7摄氏度，同时伴有6到7级的偏北风。";
		txt = "中华人民共和国";
		txt = "a wedding dresses	";
		analyzer = new StandardAnalyzer();
		dir = FSDirectory.open(Paths.get("/Users/qiushi/liepin/tmp"));
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig( analyzer);
		IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);
		Document doc = new Document();
		Field field = new Field("txt", txt, Field.Store.YES, Field.Index.ANALYZED);
		doc.add(field);
		indexWriter.addDocument(doc);
		indexWriter.commit();
		indexWriter.close();
		indexWriter.close();
	}
	
//	public void testAnalyzer() throws Throwable{
//		String str = "中华人民共和国";
//		TokenStream ts = analyzer.tokenStream(null, new StringReader(str));
//		ts.reset();
//		while (ts.incrementToken()) {
//			CharTermAttribute c = ts.getAttribute(CharTermAttribute.class);
//			System.out.println(c);
//		}
//	}

	public void testSearch() {
		try {
			IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
			QueryParser qp = new QueryParser("txt", analyzer);
			Query q = qp.parse("wed");
			System.out.println(q);
			TopDocs docs = searcher.search(q, 10);
			for (ScoreDoc doc : docs.scoreDocs) {
				System.out.println(doc.score);
				Document document = searcher.doc(doc.doc);
				System.out.println(document);
				System.out.println(document.get("txt"));
			}
		} catch (CorruptIndexException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

}