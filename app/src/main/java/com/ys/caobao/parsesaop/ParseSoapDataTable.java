package com.ys.caobao.parsesaop;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class ParseSoapDataTable {
	private static final String TAG = "parseSoapDataTable";

	/**
	 * 处理webservice回复，并返回对象列表
	 * 
	 * @param <T>
	 * @param <T>
	 * @param <T>
	 * @param result
	 * @param classes
	 * @param method
	 * @return List<T>
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	// ParseSoapDataTable.parse((SoapObject) sob, GetNuclideActive.class);

	public static <T> List<T> parse(SoapObject result, Class<T> classes) {

		List<T> results = new ArrayList<T>();
		for (int i = 0; i < result.getPropertyCount(); i++) {
			T instance = null;
			try {
				instance = classes.newInstance();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
				Log.e(TAG, e1.getMessage() + "\n" + e1.getCause());
//				return null;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
				Log.e(TAG, e1.getMessage() + "\n" + e1.getCause());
//				return null;
			}
			SoapObject property = (SoapObject) result.getProperty(i);
			// 获取Soap的信息
			PropertyInfo info = new PropertyInfo();
			for (int m = 0; m < property.getPropertyCount(); m++) {
				property.getPropertyInfo(m, info);
				// 获取节点名
				String name = info.getName();
				System.out.println("节点的名字是什么了"+name);
				Field declaredField = null;
				String string = "";
				try {
					declaredField = classes.getDeclaredField(name);
					declaredField.setAccessible(true);
					// 获取节点值并判断是否是“” anyType{} 等等
					string = ParseStringUnits.getStringFromObject(info
							.getValue());
					// 设置值
					declaredField.set(instance, string);
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
					Log.e(TAG,"soapName:"+name);
					Log.e(TAG, "className:" + classes.getName() + "\n");
					Log.e(TAG, "fieldName:" + declaredField == null ? "null"
							: declaredField.getName() + "\n");
					Log.e(TAG, "soapValue:" + string + "\n");
					Log.e(TAG, "soapType:"
							+ info.getValue().getClass().getName() + "\n");
					Log.e(TAG, e.getMessage() + "\n" + e.getCause() + "\n"
							+ classes.getName());
					return null;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					Log.e(TAG,"soapName:"+name);
					Log.e(TAG, "className:" + classes.getName() + "\n");
					Log.e(TAG, "fieldName:" + declaredField == null ? "null"
							: declaredField.getName() + "\n");
					Log.e(TAG, "soapValue:" + string + "\n");
					Log.e(TAG, "soapType:"
							+ info.getValue().getClass().getName() + "\n");
					Log.e(TAG, e.getMessage() + "\n" + e.getCause());
					return null;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					Log.e(TAG,"soapName:"+name);
					Log.e(TAG, "className:" + classes.getName() + "\n");
					Log.e(TAG, "fieldName:" + declaredField == null ? "null"
							: declaredField.getName() + "\n");
					Log.e(TAG, "soapValue:" + string + "\n");
					Log.e(TAG, "soapType:"
							+ info.getValue().getClass().getName() + "\n");
					Log.e(TAG, e.getMessage() + "\n" + e.getCause());
					return null;
				}
			}
			results.add(instance);
		}
		return results;
	}
}
