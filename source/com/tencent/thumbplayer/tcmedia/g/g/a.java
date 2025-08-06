package com.tencent.thumbplayer.tcmedia.g.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f49333a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private long f49334b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f49335c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49336d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49337e;

    /* renamed from: f  reason: collision with root package name */
    private String f49338f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f49339g;

    public a(boolean z11) {
        this.f49339g = z11;
    }

    private final void c(boolean z11) {
        this.f49335c = z11;
        this.f49337e = true;
    }

    private final void d(boolean z11) {
        this.f49336d = z11;
    }

    public final void a() {
        this.f49338f = "";
        this.f49333a.clear();
        this.f49334b = System.currentTimeMillis();
    }

    public final void a(boolean z11) {
        d(z11);
        this.f49334b = System.currentTimeMillis();
    }

    public final void b() {
        this.f49333a.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.f49334b));
    }

    public final void b(boolean z11) {
        c(z11);
        this.f49333a.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.f49334b));
    }

    public final void c() {
        this.f49334b = System.currentTimeMillis();
    }

    public final void d() {
        this.f49333a.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.f49334b));
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f49338f)) {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("\"isVideo\":");
            sb2.append(this.f49339g + " ,");
            if (this.f49337e) {
                sb2.append("\"isReuse\":");
                sb2.append(this.f49335c + " ,");
            }
            sb2.append("\"reuseEnable\":");
            sb2.append(this.f49336d + " ,");
            long j11 = 0;
            for (Map.Entry next : this.f49333a.entrySet()) {
                if (next != null) {
                    j11 += ((Number) next.getValue()).longValue();
                }
                sb2.append("\"" + next.getKey() + "\":");
                sb2.append(((Number) next.getValue()).longValue() + " ,");
            }
            sb2.append("\"totalCodec\":");
            sb2.append(j11);
            sb2.append("}");
            this.f49338f = sb2.toString();
        }
        return this.f49338f;
    }
}
