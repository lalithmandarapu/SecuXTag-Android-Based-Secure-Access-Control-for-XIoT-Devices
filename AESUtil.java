package com.example.secuxtag;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESUtil {

    private static final String AES = "AES";
    private static final String AES_MODE = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 128;
    private static final int IV_LENGTH = 12;

    public static String encrypt(String data, String key) throws Exception {
        byte[] keyBytes = key.getBytes();
        byte[] iv = new byte[IV_LENGTH];
        new SecureRandom().nextBytes(iv);

        Cipher cipher = Cipher.getInstance(AES_MODE);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, AES);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());

        byte[] encryptedIVAndText = new byte[IV_LENGTH + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, IV_LENGTH);
        System.arraycopy(encrypted, 0, encryptedIVAndText, IV_LENGTH, encrypted.length);

        return Base64.encodeToString(encryptedIVAndText, Base64.NO_WRAP);
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        byte[] encryptedIvTextBytes = Base64.decode(encryptedData, Base64.NO_WRAP);
        byte[] keyBytes = key.getBytes();

        byte[] iv = new byte[IV_LENGTH];
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);

        int encryptedSize = encryptedIvTextBytes.length - IV_LENGTH;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(encryptedIvTextBytes, IV_LENGTH, encryptedBytes, 0, encryptedSize);

        Cipher cipher = Cipher.getInstance(AES_MODE);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, AES);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);
        byte[] decrypted = cipher.doFinal(encryptedBytes);

        return new String(decrypted);
    }
}
