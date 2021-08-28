package com.zyq.demo.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

public class estest {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
       /*  user1 索引建立成功
       CreateIndexRequest createIndexRequest = new CreateIndexRequest("user1");
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);*/
        SearchRequest searchRequest  = new SearchRequest();
        searchRequest.indices("user1");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchRequest.source(searchSourceBuilder.query(QueryBuilders.matchAllQuery()));
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        final SearchHits hits = search.getHits();
        for (SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
        }/*
        GetRequest getRequest = new GetRequest();
        getRequest.index("user1").id("4");
        GetResponse Response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println("========"+Response);*/
        client.close();
    }
}
