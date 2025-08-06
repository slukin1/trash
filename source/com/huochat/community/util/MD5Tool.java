package com.huochat.community.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Tool {
    private static String bytestoHexStr(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
        }
        return sb2.toString();
    }

    private static String fillMD5Result(String str) {
        if (str.length() >= 32) {
            return str;
        }
        return "0" + str;
    }

    public static String getFileMD5(File file) {
        if (file.isFile() && file.exists()) {
            byte[] bArr = new byte[1024];
            try {
                MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return bytestoHexStr(instance.digest());
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static String getMD5Str(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(str.getBytes());
            return fillMD5Result(new BigInteger(1, instance.digest()).toString(16));
        } catch (Exception e11) {
            e11.printStackTrace();
            return str.hashCode() + "";
        }
    }
}
