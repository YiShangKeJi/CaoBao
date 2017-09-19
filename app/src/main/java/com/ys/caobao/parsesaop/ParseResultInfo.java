package com.ys.caobao.parsesaop;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

public class ParseResultInfo {
	/**
	 * 解析
	 * @param soapObject
	 * @return
	 */
	public static ResultInfo parse(SoapObject soapObject){
		ResultInfo resultInfo = new ResultInfo();
		String okFlag = ParseStringUnits.getStringFormSoap(soapObject, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			resultInfo.OkFlag = true;
		} else {
			resultInfo.OkFlag = false;
		}
		//获取ErrMsg
		resultInfo.ErrMsg =  ParseStringUnits.getStringFormSoap(soapObject, "ErrMsg");
		return resultInfo;
	}
}
