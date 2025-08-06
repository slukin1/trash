package com.huochat.community.util;

import android.util.Base64;
import java.nio.charset.Charset;

public class Base64Tool {
    private Base64Tool() {
    }

    public static String decode(String str) {
        return new String(Base64.decode(str, 0), Charset.forName("utf-8"));
    }

    public static String encode(String str) {
        return new String(Base64.encode(str.getBytes(), 0), Charset.forName("utf-8"));
    }
}
