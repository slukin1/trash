package com.hbg.module.content.custom;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class i implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveTraderDialog f18133b;

    public /* synthetic */ i(LiveTraderDialog liveTraderDialog) {
        this.f18133b = liveTraderDialog;
    }

    public final boolean handleMessage(Message message) {
        return LiveTraderDialog.Ah(this.f18133b, message);
    }
}
