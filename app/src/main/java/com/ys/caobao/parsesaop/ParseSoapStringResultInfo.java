package com.ys.caobao.parsesaop;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

/**
 * @author gj
 *解析StringResultInfo
 */
public class ParseSoapStringResultInfo {
	/**
	 * 解析
	 * @param soapObject
	 * @return
	 */
	public static StringResultInfo parse(SoapObject soapObject){
		StringResultInfo stringResultInfo = new StringResultInfo();
		String okFlag = ParseStringUnits.getStringFormSoap(soapObject, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			stringResultInfo.OkFlag = true;
		} else {
			stringResultInfo.OkFlag = false;
		}
		//获取ErrMsg
		stringResultInfo.ErrMsg =  ParseStringUnits.getStringFormSoap(soapObject, "ErrMsg");
		
		//获取Data
		stringResultInfo.Data = ParseStringUnits.getStringFormSoap(soapObject,"Data");
		return stringResultInfo;
	}
}
