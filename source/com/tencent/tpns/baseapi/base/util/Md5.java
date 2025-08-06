package com.tencent.tpns.baseapi.base.util;

import com.huochat.community.util.FileTool;
import java.security.MessageDigest;

public class Md5 {
    public static String md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if (b12 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b12));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
