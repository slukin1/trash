package com.sumsub.sns.internal.ml.facedetector.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: o  reason: collision with root package name */
    public static final a f35086o = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f35087a;

    /* renamed from: b  reason: collision with root package name */
    public final double f35088b;

    /* renamed from: c  reason: collision with root package name */
    public final double f35089c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35090d;

    /* renamed from: e  reason: collision with root package name */
    public final int f35091e;

    /* renamed from: f  reason: collision with root package name */
    public final double f35092f;

    /* renamed from: g  reason: collision with root package name */
    public final double f35093g;

    /* renamed from: h  reason: collision with root package name */
    public final double f35094h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Integer> f35095i;

    /* renamed from: j  reason: collision with root package name */
    public final List<Integer> f35096j;

    /* renamed from: k  reason: collision with root package name */
    public final List<Integer> f35097k;

    /* renamed from: l  reason: collision with root package name */
    public final List<Double> f35098l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f35099m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f35100n;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b a() {
            ArrayList arrayList = r0;
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(8);
            arrayList2.add(16);
            arrayList2.add(16);
            arrayList2.add(16);
            ArrayList arrayList3 = r0;
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(Double.valueOf(1.0d));
            ArrayList arrayList5 = r1;
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = r1;
            ArrayList arrayList8 = new ArrayList();
            return new b(4, 0.1484375d, 0.75d, 128, 128, 0.5d, 0.5d, 1.0d, arrayList5, arrayList7, arrayList, arrayList3, true, false, (r) null);
        }

        public a() {
        }
    }

    public /* synthetic */ b(int i11, double d11, double d12, int i12, int i13, double d13, double d14, double d15, List list, List list2, List list3, List list4, boolean z11, boolean z12, r rVar) {
        this(i11, d11, d12, i12, i13, d13, d14, d15, list, list2, list3, list4, z11, z12);
    }

    public static final b o() {
        return f35086o.a();
    }

    public final double a() {
        return this.f35092f;
    }

    public final double b() {
        return this.f35093g;
    }

    public final List<Double> c() {
        return this.f35098l;
    }

    public final List<Integer> d() {
        return this.f35096j;
    }

    public final List<Integer> e() {
        return this.f35095i;
    }

    public final int f() {
        return this.f35090d;
    }

    public final int g() {
        return this.f35091e;
    }

    public final double h() {
        return this.f35094h;
    }

    public final double i() {
        return this.f35089c;
    }

    public final double j() {
        return this.f35088b;
    }

    public final int k() {
        return this.f35087a;
    }

    public final List<Integer> l() {
        return this.f35097k;
    }

    public final boolean m() {
        return this.f35099m;
    }

    public final boolean n() {
        return this.f35100n;
    }

    public b(int i11, double d11, double d12, int i12, int i13, double d13, double d14, double d15, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Double> list4, boolean z11, boolean z12) {
        this.f35087a = i11;
        this.f35088b = d11;
        this.f35089c = d12;
        this.f35090d = i12;
        this.f35091e = i13;
        this.f35092f = d13;
        this.f35093g = d14;
        this.f35094h = d15;
        this.f35095i = list;
        this.f35096j = list2;
        this.f35097k = list3;
        this.f35098l = list4;
        this.f35099m = z11;
        this.f35100n = z12;
    }
}
