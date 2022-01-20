package com.test;
import com.test.suite.BaseCase;
import com.custom.common.db.IDBCon;
import com.custom.common.db.ResultMap;
public class testdb{
    public static void main(String argv[])throws Exception{
        BaseCase base =new BaseCase();
        IDBCon sz_db = base.getconn();
        ResultMap rm = sz_db.select("SELECT * FROM gm_clock  WHERE ACCOUNT='wyj001' LIMIT 1");
        System.out.println(rm.index(0));
    }
}
