package com.jeesite.modules.sz.util;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;


public class LightMapKeyUtil {


    public static String rsaEncode()  {
        try{
            String code = MD5Util.getMD5Str("dj123456");
            // 定义加密字符串
            String content = "szdj|"+code+"|"+new Date().getTime();
            byte[] data = content.getBytes("UTF-8");
            // 定义公有密钥
            String key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJJfsLg+gyTR8HyylVVbwDk8zbCr8eDMP7mdg3QUePLcVYS4+qOfwkrgEAB+1bXXZ5oHz4emplPpqlTFuOneenMCAwEAAQ==";
            // 密钥执行 BASE64 解密
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] decoded = Base64.decodeBase64(key);
            RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            // 计算数据段
            int blockSize = publicKey.getModulus().bitLength() / 8 - 11;
            int outputSize = cipher.getOutputSize(data.length);
            int leavedSize = data.length % blockSize;
            int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0;
            // 执行分段加密
            while (data.length - i * blockSize > 0) {
                if (data.length - i * blockSize > blockSize) {
                    cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
                } else {
                    cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
                }
                i++;
            }
            // 返回结果
            return byte2Hex(raw);
        } catch (Exception e){

        }

        return "";

    }

    /**
     * 把字节数据转换成十六进制字符串
     * @param bs 字节数组
     * @return String 十六进制字符串
     */

    private static String byte2Hex(byte[] bs) {
        if (bs == null || bs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, c = bs.length; i < c; i++) {
            String stmp = Integer.toHexString(bs[i] & 0xFF);
            if (stmp.length() < 2) {
                sb.append("0");
                sb.append(stmp);
            } else {
                sb.append(stmp);
            }
        }
        return sb.toString().toUpperCase().trim();
    }
}
