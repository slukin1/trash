package com.sumsub.sns.internal.core.common;

import java.net.URL;
import kotlin.text.Regex;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f32064a = 5;

    public static final boolean a(String str) {
        return new Regex("[0-9a-f]{24}").matches(str);
    }

    public static final boolean b(String str) {
        return str != null && str.length() >= 5;
    }

    public static final boolean c(String str) {
        try {
            new URL(str).toURI();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
