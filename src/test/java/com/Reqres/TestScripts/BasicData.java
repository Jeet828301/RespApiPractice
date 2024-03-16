package com.Reqres.TestScripts;

import java.util.HashMap;
import java.util.Map;

public class BasicData {
	private BasicData() {
	}

	private static ThreadLocal<Map<String, Object>> threadData = new ThreadLocal<>();;
	private static Map<String, Object> getData = new HashMap<>();

	public static void setData(String key, Object value) {
		threadData.set(getData);
		threadData.get().put(key, value);
	}

	public static Object getData(String key) {
		return threadData.get().get(key);
	}

}
