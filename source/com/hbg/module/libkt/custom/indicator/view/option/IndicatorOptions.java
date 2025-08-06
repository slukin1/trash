package com.hbg.module.libkt.custom.indicator.view.option;

import android.graphics.Color;
import com.hbg.module.libkt.base.ext.c;

public final class IndicatorOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f24847a;

    /* renamed from: b  reason: collision with root package name */
    public int f24848b;

    /* renamed from: c  reason: collision with root package name */
    public int f24849c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f24850d;

    /* renamed from: e  reason: collision with root package name */
    public int f24851e = Color.parseColor("#8C18171C");

    /* renamed from: f  reason: collision with root package name */
    public int f24852f = Color.parseColor("#8C6C6D72");

    /* renamed from: g  reason: collision with root package name */
    public float f24853g;

    /* renamed from: h  reason: collision with root package name */
    public float f24854h;

    /* renamed from: i  reason: collision with root package name */
    public float f24855i;

    /* renamed from: j  reason: collision with root package name */
    public float f24856j;

    /* renamed from: k  reason: collision with root package name */
    public int f24857k;

    /* renamed from: l  reason: collision with root package name */
    public float f24858l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f24859m;

    public IndicatorOptions() {
        float a11 = (float) c.a(8.0f);
        this.f24855i = a11;
        this.f24856j = a11;
        this.f24853g = a11;
    }

    public final int a() {
        return this.f24852f;
    }

    public final float b() {
        return this.f24856j;
    }

    public final int c() {
        return this.f24857k;
    }

    public final int d() {
        return this.f24848b;
    }

    public final int e() {
        return this.f24851e;
    }

    public final float f() {
        return this.f24855i;
    }

    public final int g() {
        return this.f24847a;
    }

    public final int h() {
        return this.f24850d;
    }

    public final boolean i() {
        return this.f24859m;
    }

    public final int j() {
        return this.f24849c;
    }

    public final float k() {
        return this.f24858l;
    }

    public final float l() {
        return this.f24853g;
    }

    public final float m() {
        float f11 = this.f24854h;
        return f11 > 0.0f ? f11 : this.f24855i / ((float) 2);
    }

    public final void n(int i11) {
        this.f24852f = i11;
    }

    public final void o(int i11) {
        this.f24857k = i11;
    }

    public final void p(int i11) {
        this.f24848b = i11;
    }

    public final void q(int i11) {
        this.f24851e = i11;
    }

    public final void r(float f11) {
        this.f24855i = f11;
    }

    public final void s(int i11) {
        this.f24847a = i11;
    }

    public final void t(int i11) {
        this.f24850d = i11;
    }

    public final void u(int i11) {
        this.f24849c = i11;
    }

    public final void v(float f11) {
        this.f24858l = f11;
    }

    public final void w(int i11, int i12) {
        this.f24851e = i11;
        this.f24852f = i12;
    }

    public final void x(float f11) {
        this.f24853g = f11;
    }

    public final void y(float f11) {
        this.f24854h = f11;
    }

    public final void z(float f11, float f12) {
        this.f24855i = f11;
        this.f24856j = f12;
    }
}
