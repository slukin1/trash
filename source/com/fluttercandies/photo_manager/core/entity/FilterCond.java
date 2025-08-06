package com.fluttercandies.photo_manager.core.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

public final class FilterCond {

    /* renamed from: d  reason: collision with root package name */
    public static final a f65052d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f65053a;

    /* renamed from: b  reason: collision with root package name */
    public SizeConstraint f65054b;

    /* renamed from: c  reason: collision with root package name */
    public DurationConstraint f65055c;

    public static final class DurationConstraint {

        /* renamed from: a  reason: collision with root package name */
        public long f65056a;

        /* renamed from: b  reason: collision with root package name */
        public long f65057b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65058c;

        public final boolean a() {
            return this.f65058c;
        }

        public final long b() {
            return this.f65057b;
        }

        public final long c() {
            return this.f65056a;
        }

        public final void d(boolean z11) {
            this.f65058c = z11;
        }

        public final void e(long j11) {
            this.f65057b = j11;
        }

        public final void f(long j11) {
            this.f65056a = j11;
        }
    }

    public static final class SizeConstraint {

        /* renamed from: a  reason: collision with root package name */
        public int f65059a;

        /* renamed from: b  reason: collision with root package name */
        public int f65060b;

        /* renamed from: c  reason: collision with root package name */
        public int f65061c;

        /* renamed from: d  reason: collision with root package name */
        public int f65062d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65063e;

        public final boolean a() {
            return this.f65063e;
        }

        public final int b() {
            return this.f65062d;
        }

        public final int c() {
            return this.f65060b;
        }

        public final int d() {
            return this.f65061c;
        }

        public final int e() {
            return this.f65059a;
        }

        public final void f(boolean z11) {
            this.f65063e = z11;
        }

        public final void g(int i11) {
            this.f65062d = i11;
        }

        public final void h(int i11) {
            this.f65060b = i11;
        }

        public final void i(int i11) {
            this.f65061c = i11;
        }

        public final void j(int i11) {
            this.f65059a = i11;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public final String[] a() {
        Long[] lArr = {Long.valueOf(c().c()), Long.valueOf(c().b())};
        ArrayList arrayList = new ArrayList(2);
        for (int i11 = 0; i11 < 2; i11++) {
            arrayList.add(String.valueOf(lArr[i11].longValue()));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String b() {
        if (!c().a()) {
            return "duration >=? AND duration <=?";
        }
        return "( duration IS NULL OR ( " + "duration >=? AND duration <=?" + " ) )";
    }

    public final DurationConstraint c() {
        DurationConstraint durationConstraint = this.f65055c;
        if (durationConstraint != null) {
            return durationConstraint;
        }
        return null;
    }

    public final SizeConstraint d() {
        SizeConstraint sizeConstraint = this.f65054b;
        if (sizeConstraint != null) {
            return sizeConstraint;
        }
        return null;
    }

    public final void e(DurationConstraint durationConstraint) {
        this.f65055c = durationConstraint;
    }

    public final void f(boolean z11) {
        this.f65053a = z11;
    }

    public final void g(SizeConstraint sizeConstraint) {
        this.f65054b = sizeConstraint;
    }

    public final String[] h() {
        List<Number> x02 = ArraysKt___ArraysKt.x0(new Integer[]{Integer.valueOf(d().e()), Integer.valueOf(d().c()), Integer.valueOf(d().d()), Integer.valueOf(d().b())});
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(x02, 10));
        for (Number intValue : x02) {
            arrayList.add(String.valueOf(intValue.intValue()));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String i() {
        return "width >= ? AND width <= ? AND height >= ? AND height <=?";
    }
}
