package com.alibaba.sdk.android.tbrest;

import android.content.Context;
import c3.b;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import java.util.Map;

public class SendService {

    /* renamed from: l  reason: collision with root package name */
    public static final SendService f14685l = new SendService();

    /* renamed from: a  reason: collision with root package name */
    public Context f14686a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f14687b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f14688c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f14689d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f14690e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f14691f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f14692g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f14693h = null;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f14694i = Boolean.FALSE;

    /* renamed from: j  reason: collision with root package name */
    public String f14695j = null;

    /* renamed from: k  reason: collision with root package name */
    public a f14696k = new a();

    public static class RestThread implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public String f14697b;

        /* renamed from: c  reason: collision with root package name */
        public Context f14698c;

        /* renamed from: d  reason: collision with root package name */
        public String f14699d;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f14700e = Boolean.FALSE;

        /* renamed from: f  reason: collision with root package name */
        public long f14701f;

        /* renamed from: g  reason: collision with root package name */
        public String f14702g;

        /* renamed from: h  reason: collision with root package name */
        public int f14703h;

        /* renamed from: i  reason: collision with root package name */
        public Object f14704i;

        /* renamed from: j  reason: collision with root package name */
        public Object f14705j;

        /* renamed from: k  reason: collision with root package name */
        public Object f14706k;

        /* renamed from: l  reason: collision with root package name */
        public Map<String, String> f14707l;

        /* renamed from: m  reason: collision with root package name */
        public SendService f14708m;

        public void run() {
            try {
                if (this.f14700e.booleanValue()) {
                    b.b(this.f14708m, this.f14697b, this.f14698c, this.f14699d, this.f14701f, this.f14702g, this.f14703h, this.f14704i, this.f14705j, this.f14706k, this.f14707l);
                } else {
                    b.a(this.f14708m, this.f14697b, this.f14698c, this.f14699d, this.f14701f, this.f14702g, this.f14703h, this.f14704i, this.f14705j, this.f14706k, this.f14707l);
                }
            } catch (Exception e11) {
                LogUtil.c("send log asyn error ", e11);
            }
        }
    }

    public final Boolean a() {
        if (this.f14687b != null && this.f14690e != null && this.f14688c != null && this.f14686a != null) {
            return Boolean.TRUE;
        }
        LogUtil.b("have send args is null，you must init first. appId " + this.f14687b + " appVersion " + this.f14690e + " appKey " + this.f14688c);
        return Boolean.FALSE;
    }

    public void b(Context context, String str, String str2, String str3, String str4, String str5) {
        this.f14686a = context;
        this.f14687b = str;
        this.f14688c = str2;
        this.f14690e = str3;
        this.f14691f = str4;
        this.f14692g = str5;
    }

    public Boolean c(String str, long j11, String str2, int i11, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str3;
        if (!a().booleanValue()) {
            return Boolean.FALSE;
        }
        if (str == null) {
            String str4 = this.f14693h;
            if (str4 == null) {
                str4 = "h-adashx.ut.taobao.com";
            }
            str3 = str4;
        } else {
            str3 = str;
        }
        return Boolean.valueOf(b.a(this, this.f14688c, this.f14686a, str3, j11, str2, i11, obj, obj2, obj3, map));
    }
}
