package com.ta.a.e;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.xiaomi.mipush.sdk.Constants;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40362a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40363b = false;

    public static StackTraceElement a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod()) {
                    if (!stackTraceElement.getClassName().equals(Thread.class.getName())) {
                        if (!stackTraceElement.getClassName().equals(h.class.getName())) {
                            return stackTraceElement;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String b(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    public static String c(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i11 = 0;
        objArr2[0] = str;
        sb2.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i12 = i11 + 1;
                if (i12 >= objArr.length) {
                    break;
                }
                sb2.append(b(objArr[i11], objArr[i12]));
                if (i12 < length - 1) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i11 = i12 + 1;
            }
            if (i11 == objArr.length - 1) {
                sb2.append(objArr[i11]);
            }
        }
        return sb2.toString();
    }

    public static void d(String str, Throwable th2, Object... objArr) {
        if (f40362a) {
            Log.e(j(), c(str, objArr), th2);
        }
    }

    public static void e(String str, Object... objArr) {
        if (f40362a) {
            Log.d(j(), c(str, objArr));
        }
    }

    public static void f(String str, Throwable th2, Object... objArr) {
        if (f40363b) {
            Log.e(j(), c(str, objArr), th2);
        }
    }

    public static void g(String str, Object... objArr) {
        if (f40363b) {
            Log.d(j(), c(str, objArr));
        }
    }

    public static boolean h() {
        return f40362a;
    }

    public static void i() {
        if (f40362a) {
            Log.d(j(), c((String) null, new Object[0]));
        }
    }

    public static String j() {
        String str;
        String str2;
        StackTraceElement a11 = a();
        if (a11 != null) {
            String className = a11.getClassName();
            if (!TextUtils.isEmpty(className)) {
                str = className.substring(className.lastIndexOf(46) + 1);
            } else {
                str = "";
            }
            str2 = a11.getMethodName();
        } else {
            str2 = "";
            str = str2;
        }
        return "Utdid." + str + InstructionFileId.DOT + str2 + InstructionFileId.DOT + String.valueOf(Process.myPid()) + InstructionFileId.DOT + (Thread.currentThread().getId() + "");
    }
}
