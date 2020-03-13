package com.LMS.genericUtils;

import org.testng.annotations.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {

    private Encryption() {
    }


    public static SecretKey keyGenerator() {
        String key = "thebestsecretkey";
        return new SecretKeySpec(key.getBytes(), "AES");
    }

    /**
     * Encrypt the details
     *
     * @param plainText
     * @param secretKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(final String plainText, final SecretKey secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        byte[] plainTextByte = plainText.getBytes();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedByte);
    }

    /**
     * Decrypt the details
     *
     * @param encryptedText
     * @param secretKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decrypt(final String encryptedText, final SecretKey secretKey) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        Cipher cipher = null;
        byte[] decryptedByte = null;

        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptedByte = cipher.doFinal(encryptedTextByte);
        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }


        return new String(decryptedByte);
    }


    /**
     * This method is to encrypt the password
     */
    @Test
    public void encrytPassword() {
        SecretKey secretKey = Encryption.keyGenerator();

        try {
            String x = encrypt("portaltest", secretKey);
            System.out.println("Encrypted: "+x);
            String y = decrypt(x, secretKey);
            System.out.println("Decrypted: "+y);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}

