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
 * ��HomeTest.java��ʵ��������TODO ��ʵ������
 * 
 * @author yangqi 2013-5-12 ����11:31:43
 */
public class HomeTest {


    @Test
    public void testShowHomePage() throws InterruptedException {
        HomeController c = new HomeController();
        c.showHomePage(new HashMap<String, Object>());

        Thread.sleep(Long.MAX_VALUE);
    }
}
