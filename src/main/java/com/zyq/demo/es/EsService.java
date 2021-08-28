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

@Service
public class EsService {
        @Autowired
        private RestHighLevelClient restHighLevelClient;

    public void EsTest() throws Exception {
        String Type ="JSON";
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user1").id("4");
        User user = new User();
        user.setAge(18);
        user.setName("张三4");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        indexRequest.source(s, XContentType.JSON).type(Type);
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("index=="+index);
        restHighLevelClient.close();

    }

    public EsResponse<?> queryEs(EsRequest request)throws Exception  {
       //查询  user下的ID为1001的数据
        GetRequest getRequest = new GetRequest();
        getRequest.index("user1").id("4");
        GetResponse Response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(Response);
        restHighLevelClient.close();
 /*
        // 删除
        DeleteRequest  deleteRequest = new DeleteRequest();
        deleteRequest.index("user").id("1001");
        restHighLevelClient.delete(deleteRequest,RequestOptions.DEFAULT);
        restHighLevelClient.close();
        // 改
        UpdateRequest updateRequest = new UpdateRequest();*/
        //批量新增

/*
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","age",30));
        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","lisi"));
        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","wangwu"));
*/
        // 高级查询
     /*   SearchRequest searchRequest  = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchRequest.source(searchSourceBuilder.query(QueryBuilders.matchAllQuery()));
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        final SearchHits hits = search.getHits();
        for (SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        return null;
    }
}
