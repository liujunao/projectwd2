package com.commons;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by lenovo on 2017/7/7.
 */
public class DesUtil {

    private static final String ENCODE = "UTF-8";

    /**
     * 根据键值进行加密
     * @param data
     * @return
     */
    public static String encrypt(String data,String key) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, UnsupportedEncodingException {
        byte[] bytes = encrypt(data.getBytes(ENCODE),key.getBytes(ENCODE));
        String string = new BASE64Encoder().encode(bytes);
        return string;
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //生成一个可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();

        //从原始密钥数据创建DESKeySpec对象
        DESKeySpec desKeySpec = new DESKeySpec(key);

        //创建有一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");

        //用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,secureRandom);
        return cipher.doFinal(data);
    }

    /**
     * 根据键值进行解密
     * @param data
     * @param key：加密键byte数组
     * @return
     * @throws IOException
     */
    public static String decrypt(String data,String key) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        if (data == null){
            return null;
        }
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(data);
        byte[] bytes1 = decrypt(bytes,key.getBytes(ENCODE));
        return new String(bytes1,ENCODE);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //生成一个可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();

        //从原始密钥数据创建DESKeySpec对象
        DESKeySpec desKeySpec = new DESKeySpec(key);

        //创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        //Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");

        //用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,secureRandom);

        return cipher.doFinal(data);
    }
}
