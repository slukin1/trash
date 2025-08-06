package com.huobi.account.ui;

import android.view.View;
import com.huobi.account.ui.SecurityPasskeyListActivity;
import com.huobi.login.usercenter.data.source.bean.PasskeyListData;

public final /* synthetic */ class q1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PasskeyListData.Passkey f41791b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41792c;

    public /* synthetic */ q1(PasskeyListData.Passkey passkey, String str) {
        this.f41791b = passkey;
        this.f41792c = str;
    }

    public final void onClick(View view) {
        SecurityPasskeyListActivity.b.c(this.f41791b, this.f41792c, view);
    }
}
