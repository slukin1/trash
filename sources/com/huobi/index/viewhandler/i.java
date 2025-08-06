package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexInformationHandler f74452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74453c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74454d;

    public /* synthetic */ i(IndexInformationHandler indexInformationHandler, Context context, NewFlashInformation newFlashInformation) {
        this.f74452b = indexInformationHandler;
        this.f74453c = context;
        this.f74454d = newFlashInformation;
    }

    public final void onClick(View view) {
        this.f74452b.m(this.f74453c, this.f74454d, view);
    }
}
