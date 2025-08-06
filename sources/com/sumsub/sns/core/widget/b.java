package com.sumsub.sns.core.widget;

import android.view.View;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f31236b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSCommonBottomSheetView f31237c;

    public /* synthetic */ b(boolean z11, SNSCommonBottomSheetView sNSCommonBottomSheetView) {
        this.f31236b = z11;
        this.f31237c = sNSCommonBottomSheetView;
    }

    public final void onClick(View view) {
        SNSCommonBottomSheetView.m16_set_dismissOnTouchOutside_$lambda0(this.f31236b, this.f31237c, view);
    }
}
