package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult> implements HeaderHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15166a = Pattern.compile("expiry-date=\"(.*?)\"");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f15167b = Pattern.compile("ongoing-request=\"(.*?)\"");

    /* renamed from: c  reason: collision with root package name */
    public static final Log f15168c = LogFactory.b(ObjectRestoreHeaderHandler.class);

    /* renamed from: b */
    public void a(T t11, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-restore");
        if (str != null) {
            t11.setRestoreExpirationTime(d(str));
            Boolean c11 = c(str);
            if (c11 != null) {
                t11.setOngoingRestore(c11.booleanValue());
            }
        }
    }

    public final Boolean c(String str) {
        Matcher matcher = f15167b.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }

    public final Date d(String str) {
        Matcher matcher = f15166a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.d(matcher.group(1));
        } catch (Exception e11) {
            f15168c.f("Error parsing expiry-date from x-amz-restore header.", e11);
            return null;
        }
    }
}
