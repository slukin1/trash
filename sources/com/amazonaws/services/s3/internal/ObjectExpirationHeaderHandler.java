package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectExpirationHeaderHandler<T extends ObjectExpirationResult> implements HeaderHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15163a = Pattern.compile("expiry-date=\"(.*?)\"");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f15164b = Pattern.compile("rule-id=\"(.*?)\"");

    /* renamed from: c  reason: collision with root package name */
    public static final Log f15165c = LogFactory.b(ObjectExpirationHeaderHandler.class);

    /* renamed from: b */
    public void a(T t11, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-expiration");
        if (str != null) {
            t11.setExpirationTime(c(str));
            t11.setExpirationTimeRuleId(d(str));
        }
    }

    public final Date c(String str) {
        Matcher matcher = f15163a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.d(matcher.group(1));
        } catch (Exception e11) {
            f15165c.f("Error parsing expiry-date from x-amz-expiration header.", e11);
            return null;
        }
    }

    public final String d(String str) {
        Matcher matcher = f15164b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
