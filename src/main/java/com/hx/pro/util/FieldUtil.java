package com.hx.pro.util;

import java.lang.reflect.Field;

public class FieldUtil {
	/**
	 * @Title: mergeObject 
	 * @Description: 合并实体
	 * @param origin 原始实体
	 * @param destination 传值实体
	 */
	public static <T> void mergeObject(T origin, T destination) {
		if (origin == null)
			return;
		if (!origin.getClass().equals(destination.getClass()))
			return;
		Field[] fields = origin.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				fields[i].setAccessible(true);
				Object value = fields[i].get(destination);
				if (null != value) {
					fields[i].set(origin, value);
				}
				fields[i].setAccessible(false);
			} catch (Exception e) {
			}
		}
	}
}
