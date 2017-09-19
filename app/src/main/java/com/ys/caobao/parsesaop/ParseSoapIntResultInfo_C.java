package com.ys.caobao.parsesaop;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

/**
 * @author gj
 *解析IntResultInfo
 */
public class ParseSoapIntResultInfo_C {
	/**
	 * @param soapObject
	 * @return 
	 * @return
	 * 解析
	 */
	public static <T extends IntResultInfo> T parse(SoapObject soapObject,Class<T> cls){
		T newInstance = null;
			try {
				newInstance = cls.newInstance();
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			}
		String okFlag = ParseStringUnits.getStringFormSoap(soapObject, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			newInstance.OkFlag = true;
		} else {
			newInstance.OkFlag = false;
		}
		//获取ErrMsg
		newInstance.ErrMsg =  ParseStringUnits.getStringFormSoap(soapObject, "ErrMsg");
		//获取Data
		newInstance.Data = Integer.valueOf(ParseStringUnits.getStringFormSoap(soapObject,"Data"));
		return newInstance;
	}
}
