package com.huobi.index.viewhandler;

import android.widget.RelativeLayout;
import com.huobi.index.bean.IndexFeatureItem;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexQuickHandler f74475b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f74476c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f74477d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f74478e;

    public /* synthetic */ o(IndexQuickHandler indexQuickHandler, RelativeLayout relativeLayout, boolean z11, IndexFeatureItem indexFeatureItem) {
        this.f74475b = indexQuickHandler;
        this.f74476c = relativeLayout;
        this.f74477d = z11;
        this.f74478e = indexFeatureItem;
    }

    public final void run() {
        this.f74475b.g(this.f74476c, this.f74477d, this.f74478e);
    }
}
