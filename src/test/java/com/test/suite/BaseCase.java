package com.test.suite;

import com.custom.common.db.*;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseCase {
	static Logger log = LoggerFactory.getLogger(BaseCase.class);
	protected String dbconfig = "dbservers.xml";
	protected String log4jconfig = "log4j.properties";
	protected String szName = "sz_db";
	public static IDB db = null;
	protected IDBCon szDb = null;


	@BeforeMethod
	public void beforeMethod() throws Exception {

	}

	@AfterMethod
	public void afterMethod() throws Exception {

	}

	@BeforeClass
	public void beforeClass() {
		log.debug("测试开始------");

		String log4jfilepath = getPath() + log4jconfig;
		PropertyConfigurator.configure(log4jfilepath);
		szDb=getconn();

	}

	@AfterClass
	public void afterClass() throws Exception {
		log.debug("测试结束------");
	}

	private String getPath() {
		String r = test.class.getClassLoader().getSystemResource("").toString();
		String path = r.replace("file:/", "").replace("bin/", "");
		return path;

	}
	public IDBCon getconn(){
		String dbconfigpath = getPath() + dbconfig;
		DBConfigure.configure(dbconfigpath);
		db = DBFactory.getInstance(szName);
		szDb = db.getCon();
		return szDb;
	}

}
