package com.hbg.lib.widgets.expandable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlParamTool {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f72026a = Pattern.compile("(mailto:|(news|(ht|f)tp(s?))://|((?<![\\p{L}0-9_.])(www\\.)))[-A-Za-z0-9+$&@#/%?=~_|!:,.;]*[-A-Za-z0-9+$&@#/%=~_|]");

    /* renamed from: b  reason: collision with root package name */
    public static String f72027b = "[\\u4e00-\\u9fa5]";

    public static class UrlResult {

        /* renamed from: a  reason: collision with root package name */
        public String f72028a;

        /* renamed from: b  reason: collision with root package name */
        public int f72029b;

        /* renamed from: c  reason: collision with root package name */
        public int f72030c;
    }

    public static List<UrlResult> a(String str) {
        if (!b(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f72026a.matcher(str);
        while (matcher.find()) {
            UrlResult urlResult = new UrlResult();
            urlResult.f72028a = matcher.group();
            urlResult.f72029b = matcher.start();
            urlResult.f72030c = matcher.end();
            arrayList.add(urlResult);
        }
        return arrayList;
    }

    public static boolean b(String str) {
        return str.contains("://") || str.contains("www.");
    }
}
