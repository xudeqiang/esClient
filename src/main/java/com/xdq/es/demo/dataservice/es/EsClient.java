package com.xdq.es.demo.dataservice.es;

import com.xdq.es.demo.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@Slf4j
public class EsClient {

    @Autowired
    AppConfig appConfig;

    private TransportClient client;

    /**
     * getConnection:(获取es连接).
     * @author xbq Date:2018年3月21日上午11:52:02
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"resource", "unchecked"})
    public TransportClient getConnection() throws Exception {
        // 设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        // 创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(new TransportAddress(InetAddress.getByName(appConfig.getHost()), Integer.valueOf(appConfig.getPort())));

        return client;
    }

    public TransportClient getClient(){
        if(client==null){
            try{
                client = this.getConnection();
            }catch(Exception e){
                log.error(String.format("获取ES连接异常：",e));
            }
        }
        return client;
    }

}
