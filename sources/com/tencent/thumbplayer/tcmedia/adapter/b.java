package com.tencent.thumbplayer.tcmedia.adapter;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.HashMap;

public class b {

    /* renamed from: t  reason: collision with root package name */
    private static String f48861t = "TPPlaybackInfo";

    /* renamed from: a  reason: collision with root package name */
    private String f48862a;

    /* renamed from: b  reason: collision with root package name */
    private String f48863b;

    /* renamed from: c  reason: collision with root package name */
    private int f48864c;

    /* renamed from: d  reason: collision with root package name */
    private int f48865d;

    /* renamed from: e  reason: collision with root package name */
    private long f48866e;

    /* renamed from: f  reason: collision with root package name */
    private long f48867f;

    /* renamed from: g  reason: collision with root package name */
    private long f48868g;

    /* renamed from: h  reason: collision with root package name */
    private String f48869h;

    /* renamed from: i  reason: collision with root package name */
    private int f48870i;

    /* renamed from: j  reason: collision with root package name */
    private long f48871j;

    /* renamed from: k  reason: collision with root package name */
    private int f48872k;

    /* renamed from: l  reason: collision with root package name */
    private long f48873l;

    /* renamed from: m  reason: collision with root package name */
    private int f48874m;

    /* renamed from: n  reason: collision with root package name */
    private long f48875n;

    /* renamed from: o  reason: collision with root package name */
    private long f48876o;

    /* renamed from: p  reason: collision with root package name */
    private long f48877p;

    /* renamed from: q  reason: collision with root package name */
    private int f48878q;

    /* renamed from: r  reason: collision with root package name */
    private String f48879r;

    /* renamed from: s  reason: collision with root package name */
    private long f48880s = -1;

    /* renamed from: u  reason: collision with root package name */
    private int f48881u;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new b();
        }
        String[] split = str.split("\n");
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < split.length; i11++) {
            if (!split[i11].startsWith("#") && split[i11].contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                String[] split2 = split[i11].split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 == null || split2.length < 2) {
                    String str2 = f48861t;
                    StringBuilder sb2 = new StringBuilder("parseInfo, ");
                    sb2.append((split2 == null || split2.length <= 0) ? "param null, " : split2[0]);
                    sb2.append("is empty");
                    TPLogUtil.i(str2, sb2.toString());
                } else {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        b bVar = new b();
        if (hashMap.containsKey("ContainerFormat")) {
            bVar.b((String) hashMap.get("ContainerFormat"));
        }
        if (hashMap.containsKey("VideoCodec")) {
            bVar.d((String) hashMap.get("VideoCodec"));
        }
        if (hashMap.containsKey("AudioCodec")) {
            bVar.e((String) hashMap.get("AudioCodec"));
        }
        if (hashMap.containsKey("Width")) {
            bVar.a(Long.valueOf((String) hashMap.get("Width")).longValue());
        }
        if (hashMap.containsKey("Height")) {
            bVar.b(Long.valueOf((String) hashMap.get("Height")).longValue());
        }
        if (hashMap.containsKey("VideoBitRate")) {
            bVar.c(Long.valueOf((String) hashMap.get("VideoBitRate")).longValue());
        }
        if (hashMap.containsKey("AudioBitRate")) {
            bVar.d(Long.valueOf((String) hashMap.get("AudioBitRate")).longValue());
        }
        if (hashMap.containsKey("SampleRate")) {
            bVar.e(Long.valueOf((String) hashMap.get("SampleRate")).longValue());
        }
        if (hashMap.containsKey("Channels")) {
            bVar.d(Integer.valueOf((String) hashMap.get("Channels")).intValue());
        }
        if (hashMap.containsKey("Definition")) {
            bVar.c((String) hashMap.get("Definition"));
        }
        return bVar;
    }

    public long a() {
        return this.f48866e;
    }

    public void a(int i11) {
        this.f48864c = i11;
    }

    public void a(long j11) {
        this.f48866e = j11;
    }

    public long b() {
        return this.f48867f;
    }

    public void b(int i11) {
        this.f48878q = i11;
    }

    public void b(long j11) {
        this.f48867f = j11;
    }

    public void b(String str) {
        this.f48862a = str;
    }

    public String c() {
        return this.f48862a;
    }

    public void c(int i11) {
        this.f48870i = i11;
    }

    public void c(long j11) {
        this.f48868g = j11;
    }

    public void c(String str) {
        this.f48879r = str;
    }

    public String d() {
        return this.f48879r;
    }

    public void d(int i11) {
        this.f48872k = i11;
    }

    public void d(long j11) {
        this.f48871j = j11;
    }

    public void d(String str) {
        this.f48863b = str;
    }

    public int e() {
        return this.f48864c;
    }

    public void e(int i11) {
        this.f48874m = i11;
    }

    public void e(long j11) {
        this.f48873l = j11;
    }

    public void e(String str) {
        this.f48869h = str;
    }

    public long f() {
        return this.f48868g;
    }

    public void f(int i11) {
        this.f48881u = i11;
    }

    public void f(long j11) {
        this.f48875n = j11;
    }

    public long g() {
        return this.f48871j;
    }

    public void g(int i11) {
        this.f48865d = i11;
    }

    public void g(long j11) {
        this.f48880s = j11;
    }

    public int h() {
        return this.f48874m;
    }

    public void h(long j11) {
        this.f48876o = j11;
    }

    public long i() {
        return this.f48875n;
    }

    public void i(long j11) {
        this.f48877p = j11;
    }

    public long j() {
        return this.f48880s;
    }

    public long k() {
        return this.f48876o;
    }

    public long l() {
        return this.f48877p;
    }

    public int m() {
        return this.f48881u;
    }

    public int n() {
        return this.f48865d;
    }

    public void o() {
        this.f48862a = null;
        this.f48863b = null;
        this.f48864c = 0;
        this.f48865d = 0;
        this.f48866e = 0;
        this.f48867f = 0;
        this.f48868g = 0;
        this.f48869h = null;
        this.f48870i = 0;
        this.f48871j = 0;
        this.f48872k = 0;
        this.f48873l = 0;
        this.f48878q = 2;
        this.f48874m = 0;
        this.f48875n = 0;
        this.f48876o = 0;
        this.f48877p = 0;
        this.f48881u = 0;
        this.f48880s = -1;
    }
}
