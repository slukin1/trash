package com.sumsub.sns.core.widget;

import android.view.View;
import d10.a;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f31253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSErrorBottomSheetView f31254c;

    public /* synthetic */ k(a aVar, SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        this.f31253b = aVar;
        this.f31254c = sNSErrorBottomSheetView;
    }

    public final void onClick(View view) {
        SNSErrorBottomSheetView.m26show$lambda6(this.f31253b, this.f31254c, view);
    }
}
