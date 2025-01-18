package com.example.india.utils;

import com.example.india.demo.config.DemoConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CommanUtilTest2 {

    @Mock
    private DemoConfig demoConfig;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCommanTestMessage() {

        String hero = CommanUtil.getMessage("Hero");
        Mockito.when(demoConfig.getIpEnabled()).thenReturn(true);
        CommanUtil.getCountryEnabled(demoConfig);
        //  assertEquals(hero,"Hero");
    }
}