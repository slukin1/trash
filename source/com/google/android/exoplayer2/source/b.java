package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class b implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConcatenatingMediaSource f65997b;

    public /* synthetic */ b(ConcatenatingMediaSource concatenatingMediaSource) {
        this.f65997b = concatenatingMediaSource;
    }

    public final boolean handleMessage(Message message) {
        return this.f65997b.handleMessage(message);
    }
}
