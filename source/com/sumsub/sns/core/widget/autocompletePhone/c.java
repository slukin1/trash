package com.sumsub.sns.core.widget.autocompletePhone;

import android.view.View;
import java.util.List;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f31233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f31234c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PhoneNumberKitV2 f31235d;

    public /* synthetic */ c(List list, List list2, PhoneNumberKitV2 phoneNumberKitV2) {
        this.f31233b = list;
        this.f31234c = list2;
        this.f31235d = phoneNumberKitV2;
    }

    public final void onClick(View view) {
        PhoneNumberKitV2.m49_init_$lambda12(this.f31233b, this.f31234c, this.f31235d, view);
    }
}
