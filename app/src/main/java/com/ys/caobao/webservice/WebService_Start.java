package com.ys.caobao.webservice;

import android.os.Handler;
import android.os.Message;

import org.ksoap2.SoapFault;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/**
 * 建立webservice 函数
 * 
 * @author gj
 * 
 */
public class WebService_Start {

	private Handler han = null;
	private Object s = null;
	private int mask;
	private int arg1 = -1;
	private int arg2 = -1;
	private String nameSpace;
	private String Method;
	private String URL;
	private WebService_CallBack call;
	private boolean isCallBack;
	private List<WebService_Canshu> web_canshu;

	public void addCallBack(Handler han, int mask, String nameSpace,
			String Method, String URL, List<WebService_Canshu> web_canshu,
			WebService_CallBack call) {
		this.han = han;
		this.mask = mask;
		this.nameSpace = nameSpace;
		this.Method = Method;
		this.URL = URL;
		this.web_canshu = web_canshu;
		this.call = call;
		this.isCallBack = true;
		exc();
	}

	/**
	 * @param han
	 * @param mask
	 * @param nameSpace
	 * @param Method
	 * @param URL
	 * @param web_canshu
	 */
	public void addCallBack(Handler han, int mask, String nameSpace,
			String Method, String URL, List<WebService_Canshu> web_canshu) {
		this.han = han;
		this.mask = mask;
		this.nameSpace = nameSpace;
		this.Method = Method;
		this.URL = URL;
		this.web_canshu = web_canshu;
		this.isCallBack = false;
		exc();
	}

	/**
	 * @param han
	 * @param mask
	 * @param nameSpace
	 * @param Method
	 * @param URL
	 * @param web_canshu
	 * @param arg1
	 * @param arg2
	 */
	public void addCallBack(Handler han, int mask, String nameSpace,
			String Method, String URL, List<WebService_Canshu> web_canshu,
			int arg1, int arg2) {
		this.han = han;
		this.mask = mask;
		this.nameSpace = nameSpace;
		this.Method = Method;
		this.URL = URL;
		this.web_canshu = web_canshu;
		this.isCallBack = false;
		this.arg1 = arg1;
		this.arg2 = arg2;
		exc();
	}

	private void exc() {
//		ExecutorService executors = WebServiceExecutorService.INSTANCE
//				.getExecutor();
//		executors.execute(thread);
		thread.start();
	}

	private Thread thread = new Thread() {
		@Override
		public void run() {
			Message message = new Message();
			int what = 0;
			try {
				if (isCallBack) {
					s = call.webService(DO_WebServituce());
				} else {
					s = DO_WebServituce();
				}
				what = mask;
				message.obj = s;

			} catch (SoapFault e) {
				e.getMessage();
				System.out.println(e.getMessage());
				what = WebServiceConfig.FAILT_PULL_XML;
			} catch (IOException e) {
				what = WebServiceConfig.FAILT_TIME_OUT;

			} catch (XmlPullParserException e) {
				what = WebServiceConfig.FAILT_PULL_XML;
			} finally {
				if (arg1 != -1) {
					message.arg1 = arg1;
				}
				if (arg2 != -1) {
					message.arg2 = arg2;
				}
				message.what = what;
				han.sendMessage(message);
			}
		};
	};

	public Object DO_WebServituce() throws IOException, XmlPullParserException,
			SocketTimeoutException {
		Object soap = WebService_Conn.GetWebServiceData(nameSpace, Method, URL,
				web_canshu);
		return soap;

		//
		// return FormatWebServiceGetCheckRecordByCheckUser.getHistory(soap)
		// .toString();
	}
}
