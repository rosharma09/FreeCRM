package com.crm.qa.util;

import com.crm.qa.base.TestCRMBase;

public class TestUtil extends TestCRMBase{
	
	public static long page_load_timeout = 30;
	public static long implicit_wait = 20;
	
	public void switchToFrame(String frameName) {
		driverObject.switchTo().frame(frameName);
	}

}
