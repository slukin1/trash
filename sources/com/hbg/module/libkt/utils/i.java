package com.hbg.module.libkt.utils;

import android.text.TextUtils;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f24904a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b11 : MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
