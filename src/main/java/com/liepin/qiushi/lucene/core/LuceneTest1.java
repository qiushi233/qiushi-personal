package com.liepin.qiushi.lucene.core;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * Created by qiushi on 2016/3/3.
 */
public class LuceneTest1 {

    private static String text = "mp3 wedding dresses";
    private static Analyzer analyzer = null;
    private static IndexWriter writer = null;
    private static Directory dir = null;

    public static void setup() throws Exception {
        analyzer = new StandardAnalyzer();
        dir = FSDirectory.open(Paths.get("D:/2"));
        IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(dir, writerConfig);
    }

    public static void index() throws Exception {
        Document doc = new Document();
        doc.add(new TextField("name", text, Field.Store.YES));
        writer.addDocument(doc);
        writer.commit();
        writer.close();
    }

    public static void delete() throws Exception {
        writer.deleteDocuments(new Term("name", "mp3"));
        writer.commit();
        writer.close();
    }

    public static void search() throws Exception {
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(dir));
        QueryParser qp = new QueryParser("name", analyzer);
        Query q = qp.parse("mp3");
        System.err.println(q);
        TopDocs topDocs = searcher.search(q, 10);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            int docId = scoreDoc.doc;
            float score = scoreDoc.score;
            Document doc = searcher.doc(docId);
            System.out.println(score + "\t" + doc.toString());
        }

    }

    public static void main(String[] args) throws Exception {
        setup();
        System.out.println("-----------------------------");
        //index();
        System.out.println("-----------------------------");
        search();
        System.out.println("-----------------------------");
        //delete();
        System.out.println("-----------------------------");
        //search();
        System.out.println("-----------------------------");


    }
}
