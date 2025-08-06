package com.hbg.module.huobi.im.group.ui.chat;

import android.app.Dialog;
import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImGroupChatFragment f20468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f20469c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f20470d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20471e;

    public /* synthetic */ w(ImGroupChatFragment imGroupChatFragment, Dialog dialog, boolean z11, TUIMessageBean tUIMessageBean) {
        this.f20468b = imGroupChatFragment;
        this.f20469c = dialog;
        this.f20470d = z11;
        this.f20471e = tUIMessageBean;
    }

    public final void onClick(View view) {
        this.f20468b.lambda$showBottomDialog$3(this.f20469c, this.f20470d, this.f20471e, view);
    }
}
