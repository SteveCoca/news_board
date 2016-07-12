package com.hx.pro.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5EncodeUtil {
	
	/**
	 * 先des加密，再将des加密后的字符串MD5加密
	 * @throws Exception 
	 */
	public static String encodeStr(String str) throws Exception {
		DesUtil desUtil = new DesUtil();
		String newstr = desUtil.encrypt(str);
		String lastStr = md5encode(newstr);
		return lastStr;
	}
	
	private static String md5encode(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
}
