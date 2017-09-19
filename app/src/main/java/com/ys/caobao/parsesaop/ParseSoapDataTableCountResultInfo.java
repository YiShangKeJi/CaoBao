package com.ys.caobao.parsesaop;

import java.util.ArrayList;


import org.ksoap2.serialization.SoapObject;



import android.text.TextUtils;

 

/**
 * @author gj
 *解析DataTable
 */
public class ParseSoapDataTableCountResultInfo {
	/**
	 * 解析
	 * @param object
	 * @param cls
	 * @return
	 */
	public static <T> DataTableCountResultInfo<T> parse(
			SoapObject object, Class<T> cls) {
		//生成一个新的返回对象
		DataTableCountResultInfo<T> dataTableResultCountInfo = new DataTableCountResultInfo<T>();
		//获取okFlag
		String okFlag = ParseStringUnits.getStringFormSoap(object, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			dataTableResultCountInfo.OkFlag = true;
		} else {
			dataTableResultCountInfo.OkFlag = false;
		}
		//获取ErrMsg
		dataTableResultCountInfo.ErrMsg =  ParseStringUnits.getStringFormSoap(object, "ErrMsg");
		
		//获取Count
		dataTableResultCountInfo.Count=ParseStringUnits.getStringFormSoap(object, "Count");
		 
		dataTableResultCountInfo.Data  = new ArrayList<T>();
		//解析dataTable
		if (object.hasProperty("Data")) {
			SoapObject data = (SoapObject) object.getProperty("Data");
			if (data.hasProperty("diffgram")) {
				SoapObject diffgram = (SoapObject) data.getProperty("diffgram");
				if (diffgram.hasProperty("NewDataSet")) {
					SoapObject newDataSet = (SoapObject) diffgram
							.getProperty("NewDataSet");
					dataTableResultCountInfo.Data = ParseSoapDataTable.parse(
							newDataSet, cls);
				}
			}
		}
		return dataTableResultCountInfo;
	}

	
}
