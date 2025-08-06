package com.sumsub.sns.core.widget;

import android.view.View;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f31257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSErrorBottomSheetView f31258c;

    public /* synthetic */ m(boolean z11, SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        this.f31257b = z11;
        this.f31258c = sNSErrorBottomSheetView;
    }

    public final void onClick(View view) {
        SNSErrorBottomSheetView.m25_set_dismissOnTouchOutside_$lambda0(this.f31257b, this.f31258c, view);
    }
}
