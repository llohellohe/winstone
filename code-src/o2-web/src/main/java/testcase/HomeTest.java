/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package testcase;

import java.util.HashMap;

import o2.web.mvc.HomeController;

import org.junit.Test;


/**
 * 类HomeTest.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-12 上午11:31:43
 */
public class HomeTest {


    @Test
    public void testShowHomePage() {
        HomeController c = new HomeController();
        c.showHomePage(new HashMap<String, Object>());
    }
}
