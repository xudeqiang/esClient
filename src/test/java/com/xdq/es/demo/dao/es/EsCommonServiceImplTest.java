package com.xdq.es.demo.dao.es;

import com.xdq.es.demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class EsCommonServiceImplTest {

    @Autowired
    EsCommonServiceImpl esCommonServiceImpl;
    @Test
    public void insertData(){
        esCommonServiceImpl.insert();
        System.out.println(esCommonServiceImpl.toString());
    }
}
