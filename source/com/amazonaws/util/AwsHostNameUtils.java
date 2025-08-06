package com.amazonaws.util;

import com.amazonaws.internal.config.HostRegexToRegionMapping;
import com.amazonaws.internal.config.InternalConfig;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AwsHostNameUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f15540a = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");

    public static String a(String str, String str2) {
        if (str != null) {
            String b11 = b(str);
            if (b11 != null) {
                return b11;
            }
            if (str.endsWith(".amazonaws.com")) {
                return d(str.substring(0, str.length() - 14));
            }
            if (str.endsWith(".amazonaws.com.cn")) {
                return d(str.substring(0, str.length() - 17));
            }
            if (str2 == null) {
                return "us-east-1";
            }
            Matcher matcher = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(str2) + "[.-]([a-z0-9-]+)\\.").matcher(str);
            return matcher.find() ? matcher.group(1) : "us-east-1";
        }
        throw new IllegalArgumentException("hostname cannot be null");
    }

    public static String b(String str) {
        for (HostRegexToRegionMapping next : InternalConfig.Factory.a().g()) {
            if (str.matches(next.a())) {
                return next.b();
            }
        }
        return null;
    }

    @Deprecated
    public static String c(URI uri) {
        String host = uri.getHost();
        if (host.endsWith(".amazonaws.com")) {
            String substring = host.substring(0, host.indexOf(".amazonaws.com"));
            if (substring.endsWith(".s3") || f15540a.matcher(substring).matches()) {
                return "s3";
            }
            if (substring.indexOf(46) == -1) {
                return substring;
            }
            return substring.substring(0, substring.indexOf(46));
        }
        throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + host + ").");
    }

    public static String d(String str) {
        Matcher matcher = f15540a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "us-east-1";
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.equals("vpce")) {
            String[] split = str.split("\\.");
            if (split.length < 2) {
                return "us-east-1";
            }
            substring = split[split.length - 2];
        }
        return "us-gov".equals(substring) ? "us-gov-west-1" : substring;
    }
}
