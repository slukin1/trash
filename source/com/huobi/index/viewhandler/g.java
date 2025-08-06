package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexInformationHandler f74446b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74447c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74448d;

    public /* synthetic */ g(IndexInformationHandler indexInformationHandler, Context context, NewFlashInformation newFlashInformation) {
        this.f74446b = indexInformationHandler;
        this.f74447c = context;
        this.f74448d = newFlashInformation;
    }

    public final void onClick(View view) {
        this.f74446b.p(this.f74447c, this.f74448d, view);
    }
}
