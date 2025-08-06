package com.huobi.index.viewhandler;

import android.widget.LinearLayout;
import com.huobi.index.bean.IndexContract;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexContract.ElemsDTO f74436b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f74437c;

    public /* synthetic */ c(IndexContract.ElemsDTO elemsDTO, LinearLayout linearLayout) {
        this.f74436b = elemsDTO;
        this.f74437c = linearLayout;
    }

    public final void call(Object obj) {
        IndexContractHandler.g(this.f74436b, this.f74437c, (Void) obj);
    }
}
