package com.hx.pro.util;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

public class DesUtil {
	private static String strDefaultKey = "news4us*160708";
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;

	public DesUtil() throws Exception {
		this(strDefaultKey);
	}
	
	public DesUtil(String key) throws Exception {
		Security.addProvider(new SunJCE());
		Key localKey = getKey(key.getBytes());
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(1, localKey);
		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(2, localKey);
	}
	
	/**
	 * 加密 （byte[]类型）
	 */
	public byte[] encrypt(byte[] paramArrayOfByte) throws Exception {
		return encryptCipher.doFinal(paramArrayOfByte);
	}
	
	/**
	 * 加密 （String类型）
	 */
	public String encrypt(String paramString) throws Exception {
		return byteArr2HexStr(encrypt(paramString.getBytes()));
	}
	
	/**
	 * 解密 （byte[]类型）
	 */
	public byte[] decrypt(byte[] paramArrayOfByte) throws Exception {
		return decryptCipher.doFinal(paramArrayOfByte);
	}
	
	/**
	 * 解密 （String类型）
	 */
	public String decrypt(String paramString) throws Exception {
		return new String(decrypt(hexStr2ByteArr(paramString)));
	}
	
	private String byteArr2HexStr(byte[] paramArrayOfByte) throws Exception {
		int i = paramArrayOfByte.length;
		StringBuffer localStringBuffer = new StringBuffer(i * 2);
		for (int j = 0; j < i; j++) {
			int k = paramArrayOfByte[j];
			while (k < 0) {
				k += 256;
			}
			if (k < 16) {
				localStringBuffer.append("0");
			}
			localStringBuffer.append(Integer.toString(k, 16));
		}
		return localStringBuffer.toString();
	}
	
	private byte[] hexStr2ByteArr(String paramString) throws Exception {
		byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
		int i = arrayOfByte1.length;
		byte[] arrayOfByte2 = new byte[i / 2];
		for (int j = 0; j < i; j += 2) {
			String str = new String(arrayOfByte1, j, 2);
			arrayOfByte2[(j / 2)] = (byte) Integer.parseInt(str, 16);
		}
		return arrayOfByte2;
	}
	
	private Key getKey(byte[] paramArrayOfByte) throws Exception {
		byte[] arrayOfByte = new byte[8];
		for (int i = 0; (i < paramArrayOfByte.length) && (i < arrayOfByte.length); i++) {
			arrayOfByte[i] = paramArrayOfByte[i];
		}
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte, "DES");
		return localSecretKeySpec;
	}
}
