package com.amazonaws.services.s3.internal;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class S3HttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15182a = Pattern.compile(Pattern.quote("+") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("*") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%7E") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%2F") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%3A") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%27") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%28") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%29") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%21") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%5B") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%5D") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%24"));

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String b(String str, boolean z11) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = f15182a.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = " ";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = Constants.WAVE_SEPARATOR;
                } else if (z11 && "%2F".equals(group)) {
                    group = "/";
                } else if (z11 && "%3A".equals(group)) {
                    group = ":";
                } else if (z11 && "%27".equals(group)) {
                    group = "'";
                } else if (z11 && "%28".equals(group)) {
                    group = "(";
                } else if (z11 && "%29".equals(group)) {
                    group = ")";
                } else if (z11 && "%21".equals(group)) {
                    group = TopicOperation.OPERATION_PAIR_DIVIDER;
                } else if (z11 && "%5B".equals(group)) {
                    group = "[";
                } else if (z11 && "%5D".equals(group)) {
                    group = "]";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }
}
