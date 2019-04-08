package com.example.jeedemo.restclients;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HashingUtils {

	private static final String HMAC_HASH_ALGORITHM = "HmacSHA256";

	public static String hash(String key, String data) {
		try {
			Mac sha256_HMAC = Mac.getInstance(HMAC_HASH_ALGORITHM);
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(UTF_8), HMAC_HASH_ALGORITHM);
			sha256_HMAC.init(secret_key);
			return toHexString(sha256_HMAC.doFinal(data.getBytes(UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			// No need to handle
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		return "";
	}

	private static String toHexString(byte[] bytes) {
		return new BigInteger(1, bytes).toString(16);
	}
}