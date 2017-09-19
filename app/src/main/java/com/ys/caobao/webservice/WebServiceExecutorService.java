package com.ys.caobao.webservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * webservice线程池
 * 
 * @author gj
 * 
 */
public enum WebServiceExecutorService {
	INSTANCE;
	private ExecutorService executorService;

	private WebServiceExecutorService() {
		executorService = Executors.newFixedThreadPool(5);
	}
	public ExecutorService getExecutor() {
		return executorService;
	}
}
