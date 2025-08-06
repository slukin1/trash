package com.amazonaws.util;

import com.adjust.sdk.Constants;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15549a = Pattern.compile(Pattern.quote("+") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("*") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%7E") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%2F"));

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f15550b;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Pattern.quote("%2A"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(Pattern.quote("%2B"));
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        f15550b = Pattern.compile(sb2.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2, false);
    }

    public static String b(String str, String str2, boolean z11) {
        if (str2 != null && str2.length() > 0) {
            if (str2.startsWith("/")) {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } else if (!str.endsWith("/")) {
                str = str + "/";
            }
            String f11 = f(str2, true);
            if (z11) {
                f11 = f11.replace("//", "/%2F");
            }
            return str + f11;
        } else if (str.endsWith("/")) {
            return str;
        } else {
            return str + "/";
        }
    }

    public static String c(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + str2;
    }

    public static String d(Request<?> request) {
        String str;
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        try {
            for (Map.Entry next : request.getParameters().entrySet()) {
                String encode = URLEncoder.encode((String) next.getKey(), "UTF-8");
                String str2 = (String) next.getValue();
                if (str2 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str2, "UTF-8");
                }
                if (!z11) {
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                } else {
                    z11 = false;
                }
                sb2.append(encode);
                sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb2.append(str);
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static boolean e(URI uri) {
        String b11 = StringUtils.b(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if ("http".equals(b11) && port == 80) {
            return false;
        }
        if (!Constants.SCHEME.equals(b11) || port != 443) {
            return true;
        }
        return false;
    }

    public static String f(String str, boolean z11) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = f15549a.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = "%20";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR;
                } else if (z11 && "%2F".equals(group)) {
                    group = "/";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static boolean g(Request<?> request) {
        return HttpMethodName.POST.equals(request.j()) && (request.getContent() == null);
    }
}
