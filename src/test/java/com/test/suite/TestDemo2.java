package com.test.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestDemo2 {
    @Test
    public void test1() throws Exception {
        Logger log = LoggerFactory.getLogger(TestDemo2.class);
        log.debug("**************demo2************************");
    }
}
