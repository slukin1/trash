package com.huobi.sharev2.createimage.create;

import android.graphics.Bitmap;
import kotlin.jvm.internal.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f81060a;

    /* renamed from: b  reason: collision with root package name */
    public final String f81061b;

    /* renamed from: c  reason: collision with root package name */
    public final String f81062c;

    /* renamed from: d  reason: collision with root package name */
    public final String f81063d;

    /* renamed from: e  reason: collision with root package name */
    public final String f81064e;

    /* renamed from: f  reason: collision with root package name */
    public final String f81065f;

    /* renamed from: g  reason: collision with root package name */
    public final String f81066g;

    /* renamed from: h  reason: collision with root package name */
    public final String f81067h;

    /* renamed from: i  reason: collision with root package name */
    public Integer[] f81068i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f81069j;

    public final String a() {
        return this.f81062c;
    }

    public final String b() {
        return this.f81066g;
    }

    public final String c() {
        return this.f81067h;
    }

    public final void d(Bitmap bitmap) {
        this.f81069j = bitmap;
    }

    public final void e(Integer[] numArr) {
        this.f81068i = numArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f81060a, fVar.f81060a) && x.b(this.f81061b, fVar.f81061b) && x.b(this.f81062c, fVar.f81062c) && x.b(this.f81063d, fVar.f81063d) && x.b(this.f81064e, fVar.f81064e) && x.b(this.f81065f, fVar.f81065f) && x.b(this.f81066g, fVar.f81066g) && x.b(this.f81067h, fVar.f81067h);
    }

    public int hashCode() {
        Integer num = this.f81060a;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f81061b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f81062c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f81063d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f81064e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f81065f;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f81066g;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f81067h;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode7 + i11;
    }

    public String toString() {
        return "Element(fontSize=" + this.f81060a + ", fontWeight=" + this.f81061b + ", rect=" + this.f81062c + ", text=" + this.f81063d + ", textColor=" + this.f81064e + ", textAlignment=" + this.f81065f + ", type=" + this.f81066g + ", url=" + this.f81067h + ')';
    }
}
