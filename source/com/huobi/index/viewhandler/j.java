package com.huobi.index.viewhandler;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexInformationHandler f74455b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f74456c;

    public /* synthetic */ j(IndexInformationHandler indexInformationHandler, NewFlashInformation newFlashInformation) {
        this.f74455b = indexInformationHandler;
        this.f74456c = newFlashInformation;
    }

    public final void onClick(View view) {
        this.f74455b.q(this.f74456c, view);
    }
}
