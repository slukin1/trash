package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import d10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Debugger$enable$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ JsonRpcPeer $peer;
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$enable$1(Debugger debugger, JsonRpcPeer jsonRpcPeer) {
        super(0);
        this.this$0 = debugger;
        this.$peer = jsonRpcPeer;
    }

    public final void invoke() {
        this.this$0.f43969e = this.$peer;
        this.this$0.l();
        this.$peer.registerDisconnectReceiver(new a(this.this$0));
    }
}
