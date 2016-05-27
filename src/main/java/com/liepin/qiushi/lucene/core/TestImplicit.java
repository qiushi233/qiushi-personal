package com.liepin.qiushi.lucene.core;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiushi on 16/3/25.
 */
public class TestImplicit {

    public static CloudSolrClient c = null;

    public static void main(String[] args) throws Exception {
        setUp();
        ///add();
        //delete();
        c.commit();
        c.close();
    }

    private static void delete() throws SolrServerException, IOException {
        c.deleteById("userfeed", "111");
        //c.deleteByQuery("userfeed", "feed_id:111");
        //c.deletebyid
    }

    private static void add() throws SolrServerException, IOException {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("feed_id", "111");
        doc.addField("totoro_router_key", "shard1");
        doc.addField("totoro_index_version", "10");

        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.addField("feed_id", "222");
        doc2.addField("totoro_router_key", "shard2");
        doc2.addField("totoro_index_version", "10");

        SolrInputDocument doc3 = new SolrInputDocument();
        doc3.addField("feed_id", "333");
        //doc3.addField("totoro_router_key", "shard2");
        doc3.addField("totoro_index_version", "10");

        List<SolrInputDocument> list = new ArrayList<SolrInputDocument>();
        list.add(doc);
        list.add(doc2);
//        list.add(doc3);

        c.add(list);
    }

    private static void setUp() {
        //c = new CloudSolrClient("10.10.100.150:3181,10.10.100.150:3182,10.10.100.150:3183/solr/search/group6");
        c = new CloudSolrClient("10.10.102.121:3181,10.10.102.121:3182,10.10.102.121:3183/solr/search/group6");
        c.setDefaultCollection("userfeed");

    }
}
