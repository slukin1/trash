package com.huobi.kalle;

import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Headers extends om.a<String, String> {

    /* renamed from: b  reason: collision with root package name */
    public static final TimeZone f74664b = TimeZone.getTimeZone("GMT");

    /* renamed from: c  reason: collision with root package name */
    public static final String f74665c = z();

    /* renamed from: d  reason: collision with root package name */
    public static final String f74666d = D();

    public class a implements Comparator<String> {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public Headers() {
        super(new TreeMap(new a()));
    }

    public static Map<String, String> C(Headers headers) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : headers.c()) {
            linkedHashMap.put((String) entry.getKey(), TextUtils.join("; ", (List) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static String D() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.VERSION.RELEASE);
        stringBuffer.append("; ");
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            stringBuffer.append(language.toLowerCase(locale));
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(country.toLowerCase(locale));
            }
        } else {
            stringBuffer.append(TUIThemeManager.LANGUAGE_EN);
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str = Build.MODEL;
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        if (Build.ID.length() > 0) {
            stringBuffer.append(" Api/");
            stringBuffer.append(Build.ID);
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/5.0 %sSafari/534.30", new Object[]{stringBuffer, "Mobile "});
    }

    public static String E(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf > 0 && str2.equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                return nextToken.substring(indexOf + 1).trim();
            }
        }
        return str3;
    }

    public static String J(Headers headers) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : headers.c()) {
            try {
                jSONObject.put((String) entry.getKey(), new JSONArray((List) entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    public static long l(Headers headers) {
        long j11;
        long j12;
        long currentTimeMillis = System.currentTimeMillis();
        String r11 = headers.r();
        if (!TextUtils.isEmpty(r11)) {
            StringTokenizer stringTokenizer = new StringTokenizer(r11, Constants.ACCEPT_TIME_SEPARATOR_SP);
            j12 = 0;
            j11 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                    return 0;
                }
                if (lowerCase.startsWith("max-age=")) {
                    j12 = Long.parseLong(lowerCase.substring(8)) * 1000;
                } else if (lowerCase.startsWith("must-revalidate")) {
                    return 0;
                } else {
                    if (lowerCase.startsWith("stale-while-revalidate=")) {
                        j11 = Long.parseLong(lowerCase.substring(23)) * 1000;
                    }
                }
            }
        } else {
            j12 = 0;
            j11 = 0;
        }
        if (!TextUtils.isEmpty(r11)) {
            long j13 = currentTimeMillis + j12;
            return j11 > 0 ? j13 + j11 : j13;
        }
        long x11 = headers.x();
        long u11 = headers.u();
        if (x11 > u11) {
            return (currentTimeMillis + x11) - u11;
        }
        return 0;
    }

    public static long m(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(f74664b);
        return simpleDateFormat.parse(str).getTime();
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.toLowerCase(Locale.ENGLISH).split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : split) {
            String substring = str2.substring(0, 1);
            String substring2 = str2.substring(1, str2.length());
            sb2.append(substring.toUpperCase(Locale.ENGLISH));
            sb2.append(substring2);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        }
        return sb2.toString();
    }

    public static String o(long j11) {
        Date date = new Date(j11);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(f74664b);
        return simpleDateFormat.format(date);
    }

    public static Headers p(String str) throws JSONException {
        Headers headers = new Headers();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = new JSONArray(jSONObject.optString(next));
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                headers.a(next, jSONArray.optString(i11));
            }
        }
        return headers;
    }

    public static String z() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb2 = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb2.append('-');
            sb2.append(country);
            sb2.append(',');
            sb2.append(language);
        }
        return sb2.toString();
    }

    public long A() {
        return v(HttpHeaders.LAST_MODIFIED);
    }

    public String B() {
        return y(HttpHeaders.LOCATION);
    }

    public List<String> F(String str) {
        return super.f(n(str));
    }

    public void G(Headers headers) {
        for (Map.Entry entry : headers.c()) {
            I((String) entry.getKey(), (List) entry.getValue());
        }
    }

    public void H(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            super.g(n(str), str2);
        }
    }

    public void I(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && !list.isEmpty()) {
            super.h(n(str), list);
        }
    }

    public void i(Headers headers) {
        for (Map.Entry entry : headers.c()) {
            String str = (String) entry.getKey();
            for (String j11 : (List) entry.getValue()) {
                a(str, j11);
            }
        }
    }

    /* renamed from: j */
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            super.a(n(str), str2);
        }
    }

    public void k(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && !list.isEmpty()) {
            super.b(n(str), list);
        }
    }

    public List<String> q(String str) {
        return super.d(n(str));
    }

    public String r() {
        List<String> q11 = q(HttpHeaders.CACHE_CONTROL);
        if (q11 == null) {
            q11 = Collections.emptyList();
        }
        return TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, q11);
    }

    public long s() {
        String y11 = y("Content-Length");
        if (TextUtils.isEmpty(y11)) {
            y11 = "0";
        }
        return Long.parseLong(y11);
    }

    public String t() {
        return y("Content-Type");
    }

    public long u() {
        return v(HttpHeaders.DATE);
    }

    public final long v(String str) {
        String y11 = y(str);
        if (TextUtils.isEmpty(y11)) {
            return 0;
        }
        try {
            return m(y11);
        } catch (ParseException unused) {
            return 0;
        }
    }

    public String w() {
        return y(HttpHeaders.ETAG);
    }

    public long x() {
        return v(HttpHeaders.EXPIRES);
    }

    public String y(String str) {
        return (String) super.e(n(str));
    }
}
