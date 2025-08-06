package com.hbg.module.libkt.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f24864f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public int f24865a;

    /* renamed from: b  reason: collision with root package name */
    public View f24866b;

    /* renamed from: c  reason: collision with root package name */
    public int f24867c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f24868d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f24869e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b(a aVar, View view, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = -1;
            }
            return aVar.a(view, i11);
        }

        public final ViewTreeObserver.OnGlobalLayoutListener a(View view, int i11) {
            return new b(view, i11, (r) null).d();
        }
    }

    public b(View view, int i11) {
        ViewTreeObserver viewTreeObserver;
        ViewGroup.LayoutParams layoutParams;
        this.f24865a = i11;
        if (view != null) {
            this.f24866b = view;
            if (i11 > 0 && (layoutParams = view.getLayoutParams()) != null) {
                layoutParams.height = this.f24865a;
            }
            this.f24869e = new a(this);
            View view2 = this.f24866b;
            if (!(view2 == null || (viewTreeObserver = view2.getViewTreeObserver()) == null)) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f24869e);
            }
            View view3 = this.f24866b;
            this.f24868d = view3 != null ? view3.getLayoutParams() : null;
        }
    }

    public /* synthetic */ b(View view, int i11, r rVar) {
        this(view, i11);
    }

    public static final void b(b bVar) {
        bVar.e();
    }

    public final int c() {
        int i11 = this.f24865a;
        if (i11 > 0) {
            return i11;
        }
        Rect rect = new Rect();
        View view = this.f24866b;
        if (view != null) {
            view.getWindowVisibleDisplayFrame(rect);
        }
        return rect.bottom;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener d() {
        return this.f24869e;
    }

    public final void e() {
        int c11 = c();
        if (c11 != this.f24867c) {
            ViewGroup.LayoutParams layoutParams = this.f24868d;
            if (layoutParams != null) {
                layoutParams.height = c11;
            }
            View view = this.f24866b;
            if (view != null) {
                view.requestLayout();
            }
            this.f24867c = c11;
        }
    }
}
