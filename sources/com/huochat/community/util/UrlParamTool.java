package com.huochat.community.util;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huobi.vulcan.model.VulcanInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlParamTool {
    public static String CHINESE_REG = "[\\u4e00-\\u9fa5]";
    public static final Pattern URL_PATTERN = Pattern.compile("(mailto:|(news|(ht|f)tp(s?))://|((?<![\\p{L}0-9_.])(www\\.)))[-A-Za-z0-9+$&@#/%?=~_|!:,.;]*[-A-Za-z0-9+$&@#/%=~_|]");

    public static class UrlResult {
        public int end;
        public int start;
        public String url;
    }

    public static List<UrlResult> applyFilter(String str) {
        if (!canContainUrl(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = URL_PATTERN.matcher(str);
        while (matcher.find()) {
            UrlResult urlResult = new UrlResult();
            urlResult.url = matcher.group();
            urlResult.start = matcher.start();
            urlResult.end = matcher.end();
            arrayList.add(urlResult);
        }
        return arrayList;
    }

    private static String byte2hex(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString.toUpperCase());
        }
        return sb2.toString();
    }

    private static boolean canContainUrl(String str) {
        return str.contains("://") || str.contains("www.");
    }

    public static String combineParamsWithUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "?" + "token=" + encodeParam(str2) + "&language=" + encodeParam(str3);
    }

    public static boolean containUrl(String str) {
        String trim = trimChineseChars(str).trim();
        if (!TextUtils.isEmpty(trim) && URL_PATTERN.matcher(trim).find()) {
            return true;
        }
        return false;
    }

    public static String encodeEncryptParam(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(Base64Tool.encode(str), "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return str;
    }

    public static String encodeParam(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return str;
    }

    public static Map<String, Object> getDataMap(Intent intent) {
        if (intent == null) {
            return new HashMap();
        }
        Uri data = intent.getData();
        HashMap hashMap = new HashMap();
        if (data != null) {
            hashMap.put("url", data.toString());
            hashMap.put("scheme", data.getScheme());
            hashMap.put(VulcanInfo.HOST, data.getHost());
            hashMap.put("path", data.getPath());
            Set<String> queryParameterNames = data.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String next : queryParameterNames) {
                    String queryParameter = data.getQueryParameter(next);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        hashMap.put(next, queryParameter);
                    }
                }
            }
        }
        return hashMap;
    }

    private static byte[] getMD5Digest(String str) throws IOException {
        try {
            return MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes("UTF-8"));
        } catch (GeneralSecurityException e11) {
            throw new IOException(e11);
        }
    }

    public static String getSignByParam(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        Set<String> keySet = map.keySet();
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(keySet);
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            sb2.append(str);
            sb2.append(map.get(str));
        }
        try {
            return byte2hex(getMD5Digest(sb2.toString()));
        } catch (IOException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String getTopDomain(String str) {
        try {
            Matcher matcher = Pattern.compile("[\\w-]+\\.(com|cn|im|so|io|fm|vc|org|net)\\b()*", 2).matcher(str);
            matcher.find();
            return matcher.group();
        } catch (Exception e11) {
            System.out.println("[getTopDomain ERROR]====>");
            e11.printStackTrace();
            return "";
        }
    }

    public static String getUrlDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|22|23|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0053 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> getUrlParam(java.lang.String r8) {
        /*
            java.lang.String r0 = "?"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x005d }
            if (r2 == 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r2 = r8.contains(r0)     // Catch:{ Exception -> 0x005d }
            if (r2 != 0) goto L_0x0015
            return r1
        L_0x0015:
            int r0 = r8.indexOf(r0)     // Catch:{ Exception -> 0x005d }
            r2 = 1
            int r0 = r0 + r2
            java.lang.String r8 = r8.substring(r0)     // Catch:{ Exception -> 0x005d }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x005d }
            if (r0 == 0) goto L_0x0026
            return r1
        L_0x0026:
            java.lang.String r0 = "&"
            java.lang.String[] r8 = r8.split(r0)     // Catch:{ Exception -> 0x005d }
            r0 = 0
            r3 = r0
        L_0x002e:
            int r4 = r8.length     // Catch:{ Exception -> 0x005d }
            if (r3 >= r4) goto L_0x005d
            r4 = r8[r3]     // Catch:{ Exception -> 0x005d }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x005d }
            if (r5 == 0) goto L_0x003a
            goto L_0x005a
        L_0x003a:
            java.lang.String r5 = "="
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x005d }
            int r5 = r4.length     // Catch:{ Exception -> 0x005d }
            r6 = 2
            if (r5 == r6) goto L_0x0045
            goto L_0x005a
        L_0x0045:
            r5 = r4[r0]     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            r6 = r4[r2]     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            java.lang.String r7 = "utf-8"
            java.lang.String r6 = java.net.URLDecoder.decode(r6, r7)     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            r1.put(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            goto L_0x005a
        L_0x0053:
            r5 = r4[r0]     // Catch:{ Exception -> 0x005d }
            r4 = r4[r2]     // Catch:{ Exception -> 0x005d }
            r1.put(r5, r4)     // Catch:{ Exception -> 0x005d }
        L_0x005a:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.UrlParamTool.getUrlParam(java.lang.String):java.util.Map");
    }

    public static String trimChineseChars(String str) {
        return Pattern.compile(CHINESE_REG).matcher(str).replaceAll("");
    }
}
