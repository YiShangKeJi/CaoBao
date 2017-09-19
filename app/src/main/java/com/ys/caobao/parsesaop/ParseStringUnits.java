package com.ys.caobao.parsesaop;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

public class ParseStringUnits {
	/**
	 * 获取Soap的值，并格式化
	 * @param object
	 * @param str
	 * @return
	 */
	public static String getStringFormSoap(SoapObject object, String str) {
		if(object ==null){
			return "";
		}
		if (object.hasProperty(str)) {
			Object property = object.getProperty(str);
			if (property != null) {
				String tmp = String.valueOf(property);
				if (TextUtils.equals("anyType{}", tmp)) {
					return "";
				} else {
					return tmp;
				}
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	/**
	 * 格式化Info里面的value
	 * @param object
	 * @return
	 */
	public static String getStringFromObject(Object object) {
		if (object != null) {
			String tmp = String.valueOf(object);
			if (TextUtils.equals("anyType{}", tmp)) {
				return "";
			} else {
				return tmp;
			}
		} else {
			return "";
		}
	}
}
