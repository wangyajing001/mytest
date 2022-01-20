package com.test.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestDemo{
    Logger log = LoggerFactory.getLogger(TestDemo.class);
    @Test(invocationCount = 1,alwaysRun=true)
    public void test1() throws Exception {
//        IDBCon sz_db = BaseCase.db.getCon();
//        ResultMap rm = sz_db.select("SELECT * FROM gm_clock  WHERE ACCOUNT='wyj001' LIMIT 1");
//        System.out.println(rm.index(0));
        log.debug("**************demo1**************测试1**********");
    }
    @Test(invocationCount = 1,alwaysRun=true)
    public void test2() throws Exception {
        log.debug("**************demo1**************测试2**********");
    }

//    @Test(dataProvider = "TingcheData", dataProviderClass = com.test.com.test.data.testData.class)
//    public void runTest(String testcase, String params, String code, String message) throws Exception {
//        //String testId = context.getCurrentXmlTest().getParameter("test_id");
//
//        testDataInter test =new testDataInter(testcase);
//        test.init(params);
//        test.run();
//        System.out.println(test.contentResponse.getStatus());
//
//    }
}
