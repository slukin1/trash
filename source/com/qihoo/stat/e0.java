package com.qihoo.stat;

import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import org.json.JSONObject;

public class e0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: d  reason: collision with root package name */
    public static String f28723d = "QException";

    /* renamed from: e  reason: collision with root package name */
    public static String f28724e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f28725f = "";

    /* renamed from: b  reason: collision with root package name */
    public Context f28726b = null;

    /* renamed from: c  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f28727c = null;

    public e0(Context context) {
        this.f28726b = context;
        this.f28727c = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = null;
        try {
            if (TextUtils.isEmpty(f28724e)) {
                f28724e = u.k(f28725f);
            }
            if (!TextUtils.isEmpty(f28724e) && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(str, f28724e);
                    jSONObject = jSONObject2;
                } catch (Exception e11) {
                    e = e11;
                    jSONObject = jSONObject2;
                    g0.b(f28723d, e);
                    return jSONObject;
                } catch (Error e12) {
                    e = e12;
                    jSONObject = jSONObject2;
                    g0.a(f28723d, e);
                    return jSONObject;
                }
            }
            f28724e = "";
        } catch (Exception e13) {
            e = e13;
        } catch (Error e14) {
            e = e14;
            g0.a(f28723d, e);
            return jSONObject;
        }
        return jSONObject;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        f28724e = stringWriter.toString();
        printWriter.close();
        String U = u.U(this.f28726b);
        f28725f = U;
        u.g(U, f28724e);
        d.c(this.f28726b, 2000);
        this.f28727c.uncaughtException(thread, th2);
    }
}
