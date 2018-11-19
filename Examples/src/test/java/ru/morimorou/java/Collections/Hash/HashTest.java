package ru.morimorou.java.Collections.Hash;

// hash - это результат операции хеширования, которая осуществляет свертку данных


import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTest {

    @Test
    public void testHest() {
        System.out.println();

        final Integer number1 = 1;
        System.out.println("Number1.hash.code(): " + number1.hashCode());
        System.out.println("md5(number1): " + md5(number1.toString()));
        System.out.println("sha256(number2): " + sha256(number1.toString()));
        System.out.println();

        final Integer number2 = 2;
        System.out.println("Number1.hash.code(): " + number2.hashCode());
        System.out.println("md5(number1): " + md5(number2.toString()));
        System.out.println("sha256(number2): " + sha256(number2.toString()));
        System.out.println();

    }

    private String md5(String md5) {
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes());
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
                e.printStackTrace();
        }
        return null;
    }


    private String sha256(String value) {
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            final byte[] array = md.digest(value.getBytes());
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
