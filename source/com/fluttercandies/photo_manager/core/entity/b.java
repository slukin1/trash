package com.fluttercandies.photo_manager.core.entity;

import android.net.Uri;
import com.fluttercandies.photo_manager.core.utils.IDBUtils;
import com.fluttercandies.photo_manager.core.utils.c;
import java.io.File;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f65071a;

    /* renamed from: b  reason: collision with root package name */
    public String f65072b;

    /* renamed from: c  reason: collision with root package name */
    public final long f65073c;

    /* renamed from: d  reason: collision with root package name */
    public final long f65074d;

    /* renamed from: e  reason: collision with root package name */
    public final int f65075e;

    /* renamed from: f  reason: collision with root package name */
    public final int f65076f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65077g;

    /* renamed from: h  reason: collision with root package name */
    public final String f65078h;

    /* renamed from: i  reason: collision with root package name */
    public final long f65079i;

    /* renamed from: j  reason: collision with root package name */
    public final int f65080j;

    /* renamed from: k  reason: collision with root package name */
    public Double f65081k;

    /* renamed from: l  reason: collision with root package name */
    public Double f65082l;

    /* renamed from: m  reason: collision with root package name */
    public final String f65083m;

    /* renamed from: n  reason: collision with root package name */
    public final String f65084n;

    public b(String str, String str2, long j11, long j12, int i11, int i12, int i13, String str3, long j13, int i14, Double d11, Double d12, String str4, String str5) {
        this.f65071a = str;
        this.f65072b = str2;
        this.f65073c = j11;
        this.f65074d = j12;
        this.f65075e = i11;
        this.f65076f = i12;
        this.f65077g = i13;
        this.f65078h = str3;
        this.f65079i = j13;
        this.f65080j = i14;
        this.f65081k = d11;
        this.f65082l = d12;
        this.f65083m = str4;
        this.f65084n = str5;
    }

    public final long a() {
        return this.f65074d;
    }

    public final String b() {
        return this.f65078h;
    }

    public final long c() {
        return this.f65073c;
    }

    public final int d() {
        return this.f65076f;
    }

    public final String e() {
        return this.f65071a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f65071a, bVar.f65071a) && x.b(this.f65072b, bVar.f65072b) && this.f65073c == bVar.f65073c && this.f65074d == bVar.f65074d && this.f65075e == bVar.f65075e && this.f65076f == bVar.f65076f && this.f65077g == bVar.f65077g && x.b(this.f65078h, bVar.f65078h) && this.f65079i == bVar.f65079i && this.f65080j == bVar.f65080j && x.b(this.f65081k, bVar.f65081k) && x.b(this.f65082l, bVar.f65082l) && x.b(this.f65083m, bVar.f65083m) && x.b(this.f65084n, bVar.f65084n);
    }

    public final Double f() {
        return this.f65081k;
    }

    public final Double g() {
        return this.f65082l;
    }

    public final String h() {
        return this.f65084n;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.f65071a.hashCode() * 31) + this.f65072b.hashCode()) * 31) + a.a(this.f65073c)) * 31) + a.a(this.f65074d)) * 31) + this.f65075e) * 31) + this.f65076f) * 31) + this.f65077g) * 31) + this.f65078h.hashCode()) * 31) + a.a(this.f65079i)) * 31) + this.f65080j) * 31;
        Double d11 = this.f65081k;
        int i11 = 0;
        int hashCode2 = (hashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.f65082l;
        int hashCode3 = (hashCode2 + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str = this.f65083m;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f65084n;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    public final long i() {
        return this.f65079i;
    }

    public final int j() {
        return this.f65080j;
    }

    public final String k() {
        return this.f65072b;
    }

    public final String l() {
        if (IDBUtils.f65111a.f()) {
            return this.f65083m;
        }
        return new File(this.f65072b).getParent();
    }

    public final int m() {
        return this.f65077g;
    }

    public final Uri n() {
        c cVar = c.f65119a;
        return cVar.b(this.f65071a, cVar.a(this.f65077g));
    }

    public final int o() {
        return this.f65075e;
    }

    public final void p(String str) {
        this.f65072b = str;
    }

    public String toString() {
        return "AssetEntity(id=" + this.f65071a + ", path=" + this.f65072b + ", duration=" + this.f65073c + ", createDt=" + this.f65074d + ", width=" + this.f65075e + ", height=" + this.f65076f + ", type=" + this.f65077g + ", displayName=" + this.f65078h + ", modifiedDate=" + this.f65079i + ", orientation=" + this.f65080j + ", lat=" + this.f65081k + ", lng=" + this.f65082l + ", androidQRelativePath=" + this.f65083m + ", mimeType=" + this.f65084n + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r22, java.lang.String r23, long r24, long r26, int r28, int r29, int r30, java.lang.String r31, long r32, int r34, java.lang.Double r35, java.lang.Double r36, java.lang.String r37, java.lang.String r38, int r39, kotlin.jvm.internal.r r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r17 = r2
            goto L_0x000c
        L_0x000a:
            r17 = r35
        L_0x000c:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0013
            r18 = r2
            goto L_0x0015
        L_0x0013:
            r18 = r36
        L_0x0015:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x001c
            r19 = r2
            goto L_0x001e
        L_0x001c:
            r19 = r37
        L_0x001e:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0025
            r20 = r2
            goto L_0x0027
        L_0x0025:
            r20 = r38
        L_0x0027:
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r8 = r26
            r10 = r28
            r11 = r29
            r12 = r30
            r13 = r31
            r14 = r32
            r16 = r34
            r3.<init>(r4, r5, r6, r8, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.entity.b.<init>(java.lang.String, java.lang.String, long, long, int, int, int, java.lang.String, long, int, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
