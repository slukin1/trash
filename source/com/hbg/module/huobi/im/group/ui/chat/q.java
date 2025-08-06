package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public final /* synthetic */ class q implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HbSharePrimeMessageHolder f20458b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20459c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f20460d;

    public /* synthetic */ q(HbSharePrimeMessageHolder hbSharePrimeMessageHolder, TUIMessageBean tUIMessageBean, int i11) {
        this.f20458b = hbSharePrimeMessageHolder;
        this.f20459c = tUIMessageBean;
        this.f20460d = i11;
    }

    public final boolean onLongClick(View view) {
        return this.f20458b.lambda$layoutVariableViews$0(this.f20459c, this.f20460d, view);
    }
}
