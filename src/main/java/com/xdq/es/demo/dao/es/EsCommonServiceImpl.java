package com.xdq.es.demo.dao.es;

import com.alibaba.fastjson.JSONObject;
import com.xdq.es.demo.dataservice.es.EsClient;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EsCommonServiceImpl implements EsCommonService{

    @Autowired
    EsClient esClient;

    @Autowired
    public void insert(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderNo", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "001");
        jsonObject.put("orderName", "购买元宝");
        jsonObject.put("orderTime", new Date());
        jsonObject.put("price", 1.5);
        jsonObject.put("ip", "192.168.1.111");

        IndexResponse response = esClient.getClient().prepareIndex("xudeqiang", "order").setSource(jsonObject.toString(), XContentType.JSON).get();
        System.out.println("索引名称：" + response.getIndex());
        System.out.println("类型：" + response.getType());
        System.out.println("文档ID：" + response.getId()); // 第一次使用是1
        System.out.println("当前实例状态：" + response.status());
    }

}
