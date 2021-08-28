package com.zyq.demo.esdemo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class EsTest2 {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
        //CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        //  client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        GetIndexRequest getRequest =  new GetIndexRequest("user");

        GetIndexResponse getIndexResponse =  client.indices().get(getRequest,RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());

        client.close();
    }
}
