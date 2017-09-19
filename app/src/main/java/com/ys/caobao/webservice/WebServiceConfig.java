package com.ys.caobao.webservice;

/**
 * WebService的配置文件，包括了webservice的地址，方法， nameSpace， 超时时间
 * 
 * @author gj
 * 
 */
public class WebServiceConfig {
	private static final boolean isTest = false;
	private static final String WEB_URL = "http://47.95.236.10/CBTApp/WebService/";


	/**
	 * 用户信息
	 */
	public static final String User = WEB_URL + "User.asmx";
	/**
	 * 商品信息
	 */
	public static final String Goods = WEB_URL + "Goods.asmx";
	/**
	 * 公共信息
	 */
	public static final String Common = WEB_URL + "Common.asmx";
	/**
	 * 超时时间20s
	 */
	public static final int TIME_OUT = 200000;
	/**
	 * ksoap2 解析xml出错标示
	 */
	public static final int FAILT_PULL_XML = 0xFFFF01;
	/**
	 * ksoap2 超时标示
	 */
	public static final int FAILT_TIME_OUT = 0xFFFF02;
	public static final String NAME_SPACE = "http://tempuri.org/";


	public static final String RegistUser = "RegistUser";
	public static final String Login="Login";
}
