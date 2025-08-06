package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f74444b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74445c;

    public /* synthetic */ f(Context context, NewFlashInformation newFlashInformation) {
        this.f74444b = context;
        this.f74445c = newFlashInformation;
    }

    public final void onClick(View view) {
        IndexInformationHandler.o(this.f74444b, this.f74445c, view);
    }
}
