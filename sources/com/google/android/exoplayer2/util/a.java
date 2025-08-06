package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListenerSet f66083b;

    public /* synthetic */ a(ListenerSet listenerSet) {
        this.f66083b = listenerSet;
    }

    public final boolean handleMessage(Message message) {
        return this.f66083b.handleMessage(message);
    }
}
