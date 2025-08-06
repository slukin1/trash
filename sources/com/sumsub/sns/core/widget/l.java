package com.sumsub.sns.core.widget;

import android.view.View;
import d10.a;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f31255b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSErrorBottomSheetView f31256c;

    public /* synthetic */ l(a aVar, SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        this.f31255b = aVar;
        this.f31256c = sNSErrorBottomSheetView;
    }

    public final void onClick(View view) {
        SNSErrorBottomSheetView.m27show$lambda7(this.f31255b, this.f31256c, view);
    }
}
