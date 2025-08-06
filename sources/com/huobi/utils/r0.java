package com.huobi.utils;

import androidx.fragment.app.FragmentActivity;
import com.huobi.finance.bean.TsvMsg;
import com.huobi.utils.s0;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f83771b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f83772c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TsvMsg f83773d;

    public /* synthetic */ r0(FragmentActivity fragmentActivity, String str, TsvMsg tsvMsg) {
        this.f83771b = fragmentActivity;
        this.f83772c = str;
        this.f83773d = tsvMsg;
    }

    public final void run() {
        s0.a.c(this.f83771b, this.f83772c, this.f83773d);
    }
}
