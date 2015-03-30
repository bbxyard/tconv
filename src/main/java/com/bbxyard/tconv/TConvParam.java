package com.bbxyard.tconv;

import java.util.HashMap;

public class TConvParam {
	public TConvParam(String caption, String tabHead, String extparams) {
		// TODO Auto-generated constructor stub
		attrMap = new HashMap<String, String>();
	}
	
	public String query(String attr) {
		String value = attrMap.get(attr);
		return value;
	}
	
	private String caption;
	private String tabHead;
	private HashMap<String, String>	attrMap;
}
