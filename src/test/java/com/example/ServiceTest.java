package com.example;

import com.itmuch.cloud.EurekaApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by biweiqian on 2016/12/02.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplication.class)
@TestPropertySource(
        locations = {"classpath:application.yml"})
public class ServiceTest extends AbstractJUnit4SpringContextTests {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceTest.class);

    @org.junit.Test
    public void tests1() {
        char a = '你';
        System.out.println(a);
    }
}
