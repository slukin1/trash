package com.sumsub.sns.core.widget.autocompletePhone;

import android.view.View;
import java.util.List;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f31223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f31224c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PhoneNumberKit f31225d;

    public /* synthetic */ a(List list, boolean z11, PhoneNumberKit phoneNumberKit) {
        this.f31223b = list;
        this.f31224c = z11;
        this.f31225d = phoneNumberKit;
    }

    public final void onClick(View view) {
        PhoneNumberKit.m47attachToInput$lambda7(this.f31223b, this.f31224c, this.f31225d, view);
    }
}
