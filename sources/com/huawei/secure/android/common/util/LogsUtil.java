package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.regex.Pattern;

public class LogsUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f38662a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static class a extends Throwable {

        /* renamed from: d  reason: collision with root package name */
        private static final long f38663d = 7129050843360571879L;

        /* renamed from: a  reason: collision with root package name */
        private String f38664a;

        /* renamed from: b  reason: collision with root package name */
        private Throwable f38665b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f38666c;

        public a(Throwable th2) {
            this.f38666c = th2;
        }

        public void a(Throwable th2) {
            this.f38665b = th2;
        }

        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.f38665b;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        public String getMessage() {
            return this.f38664a;
        }

        public String toString() {
            Throwable th2 = this.f38666c;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.f38664a == null) {
                return name;
            }
            String str = name + l.f34627b;
            if (this.f38664a.startsWith(str)) {
                return this.f38664a;
            }
            return str + this.f38664a;
        }

        public void a(String str) {
            this.f38664a = str;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (f38662a.matcher(String.valueOf(charAt)).matches()) {
                if (i11 % 2 == 0) {
                    charAt = '*';
                }
                i11++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(a(str2));
        }
        return sb2.toString();
    }

    public static String c(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                sb2.append(a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, c(str2, false));
        }
    }

    public static void e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, b(str2, str3));
        }
    }

    public static void f(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, c(str2, false));
        }
    }
}
