package com.cloud.sdk.util;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.regex.Pattern;

public class HttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f64719a = Pattern.compile(Pattern.quote("+") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("*") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%7E") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Pattern.quote("%2F"));
}
