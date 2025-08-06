package com.huobi.account.ui;

import android.view.View;
import pro.huobi.R;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f41864b;

    public /* synthetic */ z(View view) {
        this.f41864b = view;
    }

    public final void run() {
        this.f41864b.findViewById(R.id.attach_button).setVisibility(0);
    }
}
