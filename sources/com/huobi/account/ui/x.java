package com.huobi.account.ui;

import android.view.View;
import android.widget.RadioGroup;
import com.huobi.account.ui.HuobiZopimChatActivity;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HuobiZopimChatActivity.d f41846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioGroup f41847c;

    public /* synthetic */ x(HuobiZopimChatActivity.d dVar, RadioGroup radioGroup) {
        this.f41846b = dVar;
        this.f41847c = radioGroup;
    }

    public final void onClick(View view) {
        this.f41846b.i(this.f41847c, view);
    }
}
