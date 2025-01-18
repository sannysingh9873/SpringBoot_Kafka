package com.example.india.utils;

import com.example.india.demo.config.DemoConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest(CommanUtil.class)
public class CommanUtilTest {


   @Mock
    private DemoConfig demoConfig;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

  @Test
    public void getCountryEnabled() {
        PowerMockito.mockStatic(CommanUtil.class);
        PowerMockito.when(CommanUtil.getCountryEnabled(demoConfig)).thenReturn(true);
        Boolean countryEnabled = CommanUtil.getCountryEnabled(demoConfig);
      Assert.assertEquals(countryEnabled,true);
    }


    @Test
    public void getCommanTestMessage() {
        PowerMockito.mockStatic(CommanUtil.class);

        PowerMockito.when(CommanUtil.getMessage("Hero")).thenReturn("heroName");
        String hero = CommanUtil.getMessage("Hero");
        Assert.assertEquals(hero,"heroName");
    }
}
