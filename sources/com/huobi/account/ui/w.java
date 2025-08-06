package com.huobi.account.ui;

import android.view.View;
import android.widget.RadioGroup;
import com.huobi.account.ui.HuobiZopimChatActivity;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HuobiZopimChatActivity.d f41837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioGroup f41838c;

    public /* synthetic */ w(HuobiZopimChatActivity.d dVar, RadioGroup radioGroup) {
        this.f41837b = dVar;
        this.f41838c = radioGroup;
    }

    public final void onClick(View view) {
        this.f41837b.j(this.f41838c, view);
    }
}
