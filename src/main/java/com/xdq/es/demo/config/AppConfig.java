package com.xdq.es.demo.config;

import lombok.Data;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Configuration
@Data
public class AppConfig {

    @Value("${es.cluster.host}")
    private String host;

    @Value("${es.cluster.port}")
    private String port;

    @Value("${es.cluster.name}")
    private String clusterName;

}
