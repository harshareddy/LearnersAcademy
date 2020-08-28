package com.learnersacademy.utils;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class EncryptionDecryptionAES {

	private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private static final String UNICODE_FORMAT = "UTF8";

	public static SecretKey TrippleDes() throws Exception {

		String myEncryptionKey = "ThisIsSpartaThisIsSparta";
		String myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		byte[] arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
		KeySpec ks = new DESedeKeySpec(arrayBytes);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		SecretKey secretKey = skf.generateSecret(ks);
		return secretKey;
	}

	public String encrypt(String plainText) throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		SecretKey secretKey = TrippleDes();
		Cipher cipher;
		cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public String decrypt(String encryptedText) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		SecretKey secretKey = TrippleDes();
		Cipher cipher;
		cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
}
