package com.hbg.module.content.ui.fragment;

import android.view.KeyEvent;
import android.view.View;

public final /* synthetic */ class c implements View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ H5Fragment f18808b;

    public /* synthetic */ c(H5Fragment h5Fragment) {
        this.f18808b = h5Fragment;
    }

    public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
        return H5Fragment.di(this.f18808b, view, i11, keyEvent);
    }
}
