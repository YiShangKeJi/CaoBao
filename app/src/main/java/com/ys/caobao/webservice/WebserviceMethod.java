package com.ys.caobao.webservice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

import com.ys.caobao.request.BaseRequest;
import com.ys.caobao.request.User.Login;
import com.ys.caobao.request.User.RegistUser;

public class WebserviceMethod {
	/**
	 * 用户信息
	 */
	public static class User {
		/**
		 * 用户注册
		 *
		 * @param handler
		 * @param what
		 * @param request
		 */
		public static void RegistUser(Handler handler, int what,
									  RegistUser request) {
			WebService_Start service_Start = new WebService_Start();
			service_Start.addCallBack(handler, what,
					WebServiceConfig.NAME_SPACE,//空间名
					WebServiceConfig.RegistUser,//方法
					WebServiceConfig.User, //路径
					getCansh(request));//参数
		}

		/**
		 * 用户登录
		 *
		 * @param handler
		 * @param what
		 * @param request
		 */
		public static void Login(Handler handler, int what,
								 Login request) {
			WebService_Start service_Start = new WebService_Start();
			service_Start.addCallBack(handler, what,
					WebServiceConfig.NAME_SPACE,
					WebServiceConfig.Login,
					WebServiceConfig.User,
					getCansh(request));
		}
	}
		/**
		 * 商品信息
		 */
		public static class Goods {

		}
		/**
		 * 公共信息
		 */
		public static class Common {

		}
	private static <T extends BaseRequest> List<WebService_Canshu> getCansh(
			T object) {
		if(object == null){
			return new ArrayList<WebService_Canshu>();
		}
		
		List<WebService_Canshu> relist = new ArrayList<WebService_Canshu>();

		Field[] fields = object.getClass().getFields();
		for (Field tmp : fields) {
			tmp.setAccessible(true);
			try {
				WebService_Canshu webService_Canshu = new WebService_Canshu(
						tmp.getName(), (String) tmp.get(object));
				relist.add(webService_Canshu);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return relist;
	}
}
