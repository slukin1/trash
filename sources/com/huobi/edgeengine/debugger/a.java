package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;

public final /* synthetic */ class a implements DisconnectReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Debugger f43998a;

    public /* synthetic */ a(Debugger debugger) {
        this.f43998a = debugger;
    }

    public final void onDisconnect() {
        this.f43998a.k();
    }
}
