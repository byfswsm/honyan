package com.qcby.hongyanfriendcircle.util;


import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.util
 * @ClassName: ElasticSearchUtils
 * @Author: zxh
 * @Description: ElasticSearch的封装
 * @Date: 2022/1/5 9:59
 * @Version: 1.0
 */
@Component
public class ElasticSearchUtils {

    private RestHighLevelClient restHighLevelClient;

    @Autowired
    public ElasticSearchUtils(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public ResultJson query(QueryBuilder queryBuilder) throws IOException {
        SearchRequest searchRequest = new SearchRequest("products");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("总条数 = " + search.getHits().getTotalHits().value);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            String id = hit.getId();
            String sourceAsString = hit.getSourceAsString();
            System.out.println("id = "+id+" source = "+sourceAsString);
        }
        return null;
    }

}
