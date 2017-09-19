package com.ys.caobao.parsesaop;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

/**
 * @author gj
 *解析IntResultInfo
 */
public class ParseSoapIntResultInfo {
	/**
	 * @param soapObject
	 * @return
	 * 解析
	 */
	public static IntResultInfo parse(SoapObject soapObject){
		IntResultInfo intResultInfo = new IntResultInfo();
		String okFlag = ParseStringUnits.getStringFormSoap(soapObject, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			intResultInfo.OkFlag = true;
		} else {
			intResultInfo.OkFlag = false;
		}
		//获取ErrMsg
		intResultInfo.ErrMsg =  ParseStringUnits.getStringFormSoap(soapObject, "ErrMsg");
		//获取Data
		intResultInfo.Data = Integer.valueOf(ParseStringUnits.getStringFormSoap(soapObject,"Data"));
		return intResultInfo;
	}
}
