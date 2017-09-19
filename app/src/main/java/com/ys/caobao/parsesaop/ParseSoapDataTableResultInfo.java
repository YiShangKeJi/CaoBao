package com.ys.caobao.parsesaop;

import java.util.ArrayList;

import org.ksoap2.serialization.SoapObject;

import android.text.TextUtils;

 

/**
 * @author gj
 *解析DataTable
 */
public class ParseSoapDataTableResultInfo {
	/**
	 * 解析
	 * @param object
	 * @param cls
	 * @return
	 */
	public static <T> DataTableResultInfo<T> parse(
			SoapObject object, Class<T> cls) {

		
		//生成一个新的返回对象
		DataTableResultInfo<T> dataTableResultInfo = new DataTableResultInfo<T>();
		if(object == null){
			dataTableResultInfo.OkFlag =false;
			dataTableResultInfo.ErrMsg="获取数据失败";
			return dataTableResultInfo;
		}
		
		//获取okFlag
		String okFlag = ParseStringUnits.getStringFormSoap(object, "OkFlag");
		//判断okFlag是否成功
		if (TextUtils.equals("1", okFlag)) {
			dataTableResultInfo.OkFlag = true;
		} else {
			dataTableResultInfo.OkFlag = false;
		}
		//获取ErrMsg
		dataTableResultInfo.ErrMsg =  ParseStringUnits.getStringFormSoap(object, "ErrMsg");
		
		
		dataTableResultInfo.Data  = new ArrayList<T>();
		//解析dataTable
		if (object.hasProperty("Data")) {
			SoapObject data = (SoapObject) object.getProperty("Data");
			if (data.hasProperty("diffgram")) {
				SoapObject diffgram = (SoapObject) data.getProperty("diffgram");
				if (diffgram.hasProperty("NewDataSet")) {
					SoapObject newDataSet = (SoapObject) diffgram
							.getProperty("NewDataSet");
					dataTableResultInfo.Data = ParseSoapDataTable.parse(
							newDataSet, cls);
				}
			}
		}
		return dataTableResultInfo;
	}

	
}
