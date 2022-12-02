package com.qcby.hongyanfriendcircle.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.config
 * @ClassName: RestClientConfig
 * @Author: zxh
 * @Description: ElasticSearch配置客户端
 * @Date: 2022/1/4 19:28
 * @Version: 1.0
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("8.134.208.99:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

}
