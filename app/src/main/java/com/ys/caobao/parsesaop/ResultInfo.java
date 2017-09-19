package com.ys.caobao.parsesaop;

/**
 * @author gj
 *储存返回的数据
 */
public class ResultInfo {
    /**
     * 1 表示执行成功；0表示执行失败
     */
    public boolean OkFlag;
    /**
     * 执行失败时的错误说明
     */
    public String ErrMsg = "";
}
