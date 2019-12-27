package com.wyh.lucene;

import java.nio.file.Paths;
import java.util.Date;

import com.wyh.entity.Blog;
import com.wyh.util.DateUtil;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 * 博客索引类
 * @author Administrator
 *
 */
public class BlogIndex {

    private Directory dir;

    /**
     * 获取IndexWriter实例
     * @return
     * @throws Exception
     */
    private IndexWriter getWriter()throws Exception{
        dir= FSDirectory.open(Paths.get("C://lucene"));
        SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        IndexWriter writer=new IndexWriter(dir, iwc);
        return writer;
    }

    /**
     * 添加博客索引
     * @param blog
     * @throws Exception
     */
    public void addIndex(Blog blog)throws Exception{
        IndexWriter writer=getWriter();
        Document doc=new Document();
        doc.add(new StringField("id",String.valueOf(blog.getId()), Field.Store.YES));
        doc.add(new TextField("title",blog.getTitle(),Field.Store.YES));
        doc.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
        doc.add(new TextField("content",blog.getContentNoTag(),Field.Store.YES));
        writer.addDocument(doc);
        writer.close();
    }

}
