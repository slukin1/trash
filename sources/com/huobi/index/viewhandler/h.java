package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexInformationHandler f74449b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74450c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74451d;

    public /* synthetic */ h(IndexInformationHandler indexInformationHandler, Context context, NewFlashInformation newFlashInformation) {
        this.f74449b = indexInformationHandler;
        this.f74450c = context;
        this.f74451d = newFlashInformation;
    }

    public final void onClick(View view) {
        this.f74449b.n(this.f74450c, this.f74451d, view);
    }
}
