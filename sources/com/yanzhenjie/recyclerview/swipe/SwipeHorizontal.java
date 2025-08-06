package com.yanzhenjie.recyclerview.swipe;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

public abstract class SwipeHorizontal {

    /* renamed from: a  reason: collision with root package name */
    public int f52630a;

    /* renamed from: b  reason: collision with root package name */
    public View f52631b;

    /* renamed from: c  reason: collision with root package name */
    public Checker f52632c = new Checker();

    public static final class Checker {

        /* renamed from: a  reason: collision with root package name */
        public int f52633a;

        /* renamed from: b  reason: collision with root package name */
        public int f52634b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52635c;
    }

    public SwipeHorizontal(int i11, View view) {
        this.f52630a = i11;
        this.f52631b = view;
    }

    public abstract void a(OverScroller overScroller, int i11, int i12);

    public abstract void b(OverScroller overScroller, int i11, int i12);

    public boolean c() {
        View view = this.f52631b;
        if (!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0) {
            return false;
        }
        return true;
    }

    public abstract Checker d(int i11, int i12);

    public int e() {
        return this.f52630a;
    }

    public View f() {
        return this.f52631b;
    }

    public int g() {
        return this.f52631b.getWidth();
    }

    public abstract boolean h(int i11, float f11);

    public boolean i(int i11) {
        return i11 == 0 && (-f().getWidth()) * e() != 0;
    }
}
