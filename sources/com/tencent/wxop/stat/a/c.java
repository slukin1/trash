package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f50934a;

    /* renamed from: ay  reason: collision with root package name */
    private int f50935ay;

    /* renamed from: bn  reason: collision with root package name */
    private int f50936bn = 100;

    /* renamed from: bo  reason: collision with root package name */
    private Thread f50937bo = null;

    public c(Context context, int i11, Throwable th2, f fVar) {
        super(context, i11, fVar);
        a(99, th2);
    }

    public c(Context context, int i11, Throwable th2, Thread thread) {
        super(context, i11, (f) null);
        a(2, th2);
        this.f50937bo = thread;
    }

    private void a(int i11, Throwable th2) {
        if (th2 != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            this.f50934a = stringWriter.toString();
            this.f50935ay = i11;
            printWriter.close();
        }
    }

    public final e ac() {
        return e.ERROR;
    }

    public final boolean b(JSONObject jSONObject) {
        r.a(jSONObject, "er", this.f50934a);
        jSONObject.put("ea", this.f50935ay);
        int i11 = this.f50935ay;
        if (i11 != 2 && i11 != 3) {
            return true;
        }
        new d(this.f50946bv).a(jSONObject, this.f50937bo);
        return true;
    }
}
