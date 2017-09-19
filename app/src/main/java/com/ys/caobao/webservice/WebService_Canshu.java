package com.ys.caobao.webservice;

/**
 * 
 * 上传的Webservice 参数
 * @author gj
 *
 */
public class WebService_Canshu {

	private String key;
	private String value;

	public WebService_Canshu(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public WebService_Canshu() {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
