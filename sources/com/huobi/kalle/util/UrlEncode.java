package com.huobi.kalle.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncode {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException("UTF-8 encoding not supported!");
        }
    }
}
