package com.test.inter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.testng.Assert;
import com.test.suite.Env;
import com.custom.common.db.IDBCon;
import com.custom.common.db.ResultMap;
import com.custom.common.json.JsonEntity;
import com.test.http.AbstractHttpApi;
import com.test.http.ContentBody.HttpJson;
import com.test.http.Request.HttpRequest;
public class testDataInter extends AbstractHttpApi{
    String testcase;
    {
        super.domain = Env.domain;
        super.url = "/sbdevice/dataEvt/receive";
        super.method = HttpRequest.METHOD_POST;
        super.header.put("Content-Type", "application/json;charset=UTF-8");
        super.contentRequest = new HttpJson();
    }
    public testDataInter(String testcase){
        this.testcase=testcase;
    }
    public void init(String params) {

        //contentRequest.put("testcase", testcase);
        //contentRequest.put("code", code);
       //contentRequest.put("message", message);
        contentRequest.put("params", params);
    }

    @Override
    public void beforeRequest() {


    }

    @Override
    public void afterRequest() {
        if (contentResponse.getStatus() != 200) {
            return;
        }
        JsonEntity rjson = new JsonEntity(contentResponse.getContent());
        if (!rjson.get("isSuccess").toString().equals("0")) {
            return;
        }
        System.out.println(rjson.toString());

    }
}
