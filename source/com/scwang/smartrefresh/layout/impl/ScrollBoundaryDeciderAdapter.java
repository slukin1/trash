package com.scwang.smartrefresh.layout.impl;

import android.view.MotionEvent;
import android.view.View;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import ky.k;

public class ScrollBoundaryDeciderAdapter implements k {

    /* renamed from: a  reason: collision with root package name */
    public MotionEvent f29914a;

    /* renamed from: b  reason: collision with root package name */
    public k f29915b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29916c;

    public boolean a(View view) {
        k kVar = this.f29915b;
        if (kVar != null) {
            return kVar.a(view);
        }
        if (this.f29916c) {
            return !ScrollBoundaryUtil.d(view, this.f29914a);
        }
        return ScrollBoundaryUtil.a(view, this.f29914a);
    }

    public boolean b(View view) {
        k kVar = this.f29915b;
        if (kVar != null) {
            return kVar.b(view);
        }
        return ScrollBoundaryUtil.b(view, this.f29914a);
    }

    public void c(MotionEvent motionEvent) {
        this.f29914a = motionEvent;
    }

    public void d(boolean z11) {
        this.f29916c = z11;
    }

    public void e(k kVar) {
        this.f29915b = kVar;
    }
}
