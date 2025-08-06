package com.sumsub.sns.internal.core.common;

import java.util.regex.Pattern;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f32282a = new t();

    /* renamed from: b  reason: collision with root package name */
    public static final String f32283b = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>";

    /* renamed from: c  reason: collision with root package name */
    public static final String f32284c = "</\\w+>";

    /* renamed from: d  reason: collision with root package name */
    public static final String f32285d = "<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>";

    /* renamed from: e  reason: collision with root package name */
    public static final String f32286e = "&[a-zA-Z][a-zA-Z0-9]+;";

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f32287f = Pattern.compile("(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)>.*</\\w+>)|(<\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)+\\s*|\\s*)/>)|(&[a-zA-Z][a-zA-Z0-9]+;)", 32);

    public final Pattern a() {
        return f32287f;
    }
}
