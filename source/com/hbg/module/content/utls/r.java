package com.hbg.module.content.utls;

import android.view.View;
import oc.a;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f18950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TipsPopDialog f18951c;

    public /* synthetic */ r(a aVar, TipsPopDialog tipsPopDialog) {
        this.f18950b = aVar;
        this.f18951c = tipsPopDialog;
    }

    public final void onClick(View view) {
        TipsPopDialog.d(this.f18950b, this.f18951c, view);
    }
}
