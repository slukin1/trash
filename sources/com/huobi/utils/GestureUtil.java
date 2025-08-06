package com.huobi.utils;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huochat.community.util.FileTool;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import tg.r;

public class GestureUtil {
    public static void a() {
        String s11 = r.x().s();
        SP.o("user_config", s11 + "_" + "config_gesture");
    }

    public static String b(String str) {
        String s11 = r.x().s();
        try {
            byte[] digest = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest((s11 + str).getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if (b12 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(b12));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException("MD5 should be supported?", e11);
        } catch (UnsupportedEncodingException e12) {
            throw new RuntimeException("UTF-8 should be supported?", e12);
        }
    }

    public static boolean c() {
        String s11 = r.x().s();
        return !TextUtils.isEmpty(ConfigPreferences.e("user_config", s11 + "_" + "config_gesture", ""));
    }

    public static boolean d(String str, String str2) {
        return str.equals(b(str2));
    }

    public static void e(String str) {
        String s11 = r.x().s();
        try {
            byte[] bytes = (s11 + str).getBytes("UTF-8");
            ConfigPreferences.m("user_config", s11 + "_" + "config_gesture", MD5Utils.b(bytes));
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("UTF-8 should be supported?", e11);
        }
    }
}
