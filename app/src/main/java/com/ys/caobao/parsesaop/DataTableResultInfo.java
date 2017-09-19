package com.ys.caobao.parsesaop;

import java.util.List;

/**
 * @author gj
 *
 * @param <T>
 *  用于 WebService 返回 DataTable 结果的类型
 */
public class DataTableResultInfo<T> extends ResultInfo{
	/**
	 * 存储结果的数据表
	 */
	public List<T> Data;
}
