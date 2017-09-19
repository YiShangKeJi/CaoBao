package com.ys.caobao.webservice;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.OkHttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
/**
 * WebService 连接函数
 * 
 * @author gj
 * 
 */
public class WebService_Conn {
	public static Object GetWebServiceData(String nameSpace, String doMethod,
			String wsurl, List<WebService_Canshu> List) throws IOException,
			XmlPullParserException, SocketTimeoutException {

		// 1定义必要的常量
		Object result = null;
		String soapAction = nameSpace + doMethod;
		// 2得到KSOAP2的核心对象,并将参数传递给SoapObject
		String wsurl1 = wsurl + "?wsdl";
		SoapObject request = new SoapObject(nameSpace, doMethod);

		// ---------------------------------------------------------------------------------------------

		if (List != null) {
			for (WebService_Canshu web : List) {
				if(!web.getKey().equals("$change")) {
					request.addProperty(web.getKey(), web.getValue());
				}
			}
		}

		// ----------------------------------------------------------------------------------------------

		// 3造信封
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.bodyOut = request;// 将含有参数的SoapObject装到信封里面
		envelope.dotNet = true;// 声明一下服务器是.net做的
		// 4造一条通向目的地的大路
		OkHttpTransportSE   se  = new OkHttpTransportSE(wsurl1,WebServiceConfig.TIME_OUT);
		//HttpTransportSE se = new HttpTransportSE(wsurl1,WebServiceConfig.TIME_OUT);

		se.debug = false;
		List<HeaderProperty> headers = new ArrayList<HeaderProperty>();
		// 5进行通信
		headers .add(new HeaderProperty("Connection", "close"));
		se.call(soapAction, envelope,headers);
		// 判断一下返回的信息是否到达本地,如果到达，则从信封里面取出结果
		result = envelope.getResponse();// 取出结果，放的时候是SoapObject对象，取的时候同样是SoapObject对象
		return result;
	}
}
