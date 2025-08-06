package com.hbg.module.huobi.im.group.ui.chat;

import android.app.Dialog;
import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImGroupChatFragment f20465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f20466c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIMessageBean f20467d;

    public /* synthetic */ v(ImGroupChatFragment imGroupChatFragment, Dialog dialog, TUIMessageBean tUIMessageBean) {
        this.f20465b = imGroupChatFragment;
        this.f20466c = dialog;
        this.f20467d = tUIMessageBean;
    }

    public final void onClick(View view) {
        this.f20465b.lambda$showBottomDialog$2(this.f20466c, this.f20467d, view);
    }
}
