package com.huobi.vulcan.core;

import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public class Signature {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f20599a = new a();

    public class a extends ThreadLocal<SimpleDateFormat> {
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) throws IOException {
        if (map == null) {
            return "";
        }
        if ("https://l10n-pro.huobi.cn".equalsIgnoreCase(str4) || "https://l10n-pro.dangpu.com".equalsIgnoreCase(str4)) {
            str4 = "https://www.huobi.pro";
        }
        if (!TextUtils.isEmpty(str5)) {
            str5 = str5.replaceAll("/\\-/x", "");
        }
        StringBuilder sb2 = new StringBuilder(1024);
        sb2.append(str3.toUpperCase());
        sb2.append(10);
        sb2.append(str4.toLowerCase());
        sb2.append(10);
        sb2.append(str5);
        sb2.append(10);
        map.clear();
        map.remove("Signature");
        map.put("AWSAccessKeyId", str);
        map.put("SignatureVersion", "2");
        map.put("SignatureMethod", "HmacSHA256");
        map.put("Timestamp", b());
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            sb2.append((String) entry.getKey());
            sb2.append('=');
            sb2.append(c((String) entry.getValue()));
            sb2.append('&');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        lu.a.b("Signature", "createSignature:" + sb2.toString());
        try {
            String l11 = CipherUtils.l(sb2.toString(), str2);
            map.put("Signature", l11.trim());
            return l11.trim();
        } catch (SignatureException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String b() {
        SimpleDateFormat simpleDateFormat = f20599a.get();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        return simpleDateFormat.format(new Date());
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException("UTF-8 encoding not supported!");
        }
    }

    public static String d(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb2.append((String) next.getKey());
            sb2.append('=');
            sb2.append((String) next.getValue());
            sb2.append('&');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }
}
