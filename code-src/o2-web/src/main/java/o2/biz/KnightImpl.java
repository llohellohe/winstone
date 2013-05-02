/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package o2.biz;

import org.springframework.beans.factory.InitializingBean;

/**
 * ��Knight.java��ʵ��������TODO ��ʵ������ 
 * @author yangqi 2013-3-24 ����9:34:50
 */
public class KnightImpl implements Knight, InitializingBean {
    
    static Knight instance = new KnightImpl();

    static {
        System.out.println("I am initing");
    }

    public KnightImpl() {
        System.out.println("I am constructing");
    }
    public void embarkOnQuest(){
       System.out.println("hello yangqi"); 
    }
    
    public static Knight instance() {
        return instance;
    }

    public void init() {
        System.out.println("I AM INIT METHOD");
    }

    public void destory() {
        System.out.println("I AM DESTORY METHOD");
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");

    }
}
