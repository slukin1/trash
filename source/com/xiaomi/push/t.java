package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

public class t {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f52614a;

        /* renamed from: a  reason: collision with other field name */
        private final StringBuilder f3446a;

        /* renamed from: b  reason: collision with root package name */
        private final String f52615b;

        public a() {
            this(":", Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f3446a.length() > 0) {
                    this.f3446a.append(this.f52615b);
                }
                StringBuilder sb2 = this.f3446a;
                sb2.append(str);
                sb2.append(this.f52614a);
                sb2.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f3446a.toString();
        }

        public a(String str, String str2) {
            this.f3446a = new StringBuilder();
            this.f52614a = str;
            this.f52615b = str2;
        }
    }

    public static int a(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i11;
        }
    }

    public static int b(String str, int i11) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i11 : i11;
    }

    public static long a(String str, long j11) {
        if (TextUtils.isEmpty(str)) {
            return j11;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j11;
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
