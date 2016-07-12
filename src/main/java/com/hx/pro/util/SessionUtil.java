package com.hx.pro.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SessionUtil {
	public static void setSessionValue(String key, Object object) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> ensession = ac.getSession();
		ensession.put(key, object);
	}
	
	public static Object getSessionValue(String key) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> ensession = ac.getSession();
		return ensession.get(key);
	}
}
