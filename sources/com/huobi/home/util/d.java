package com.huobi.home.util;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huobi.home.util.ViewExtKt;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f72580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewExtKt.c f72581c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnWindowFocusChangeListener f72582d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f72583e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ List f72584f;

    public /* synthetic */ d(View view, ViewExtKt.c cVar, ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener, Ref$ObjectRef ref$ObjectRef, List list) {
        this.f72580b = view;
        this.f72581c = cVar;
        this.f72582d = onWindowFocusChangeListener;
        this.f72583e = ref$ObjectRef;
        this.f72584f = list;
    }

    public final void run() {
        ViewExtKt.b.b(this.f72580b, this.f72581c, this.f72582d, this.f72583e, this.f72584f);
    }
}
