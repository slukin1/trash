package com.huobi.home.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import d10.p;

public final /* synthetic */ class b implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f72575a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f72576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rect f72577c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p f72578d;

    public /* synthetic */ b(View view, int i11, Rect rect, p pVar) {
        this.f72575a = view;
        this.f72576b = i11;
        this.f72577c = rect;
        this.f72578d = pVar;
    }

    public final void onWindowFocusChanged(boolean z11) {
        ViewExtKt.e(this.f72575a, this.f72576b, this.f72577c, this.f72578d, z11);
    }
}
