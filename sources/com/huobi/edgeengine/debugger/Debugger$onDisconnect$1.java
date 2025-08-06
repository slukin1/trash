package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.network.NetworkPeerManager;
import d10.a;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class Debugger$onDisconnect$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$onDisconnect$1(Debugger debugger) {
        super(0);
        this.this$0 = debugger;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2306invoke$lambda1$lambda0(Debugger debugger, String str) {
        V8Messenger e11 = debugger.f43968d;
        if (e11 != null) {
            V8Messenger.i(e11, k.f44016a.d(), new JSONObject().put("breakpointId", str), false, 4, (Object) null);
        }
    }

    public final Unit invoke() {
        List<String> a11 = this.this$0.f43970f;
        Debugger debugger = this.this$0;
        for (String str : a11) {
            ExecutorService d11 = debugger.f43967c;
            if (d11 != null) {
                d11.execute(new b(debugger, str));
            }
        }
        this.this$0.f43970f.clear();
        NetworkPeerManager instanceOrNull = NetworkPeerManager.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.removePeer(this.this$0.f43969e);
        }
        this.this$0.f43969e = null;
        V8Messenger e11 = this.this$0.f43968d;
        if (e11 == null) {
            return null;
        }
        e11.j(false);
        return Unit.f56620a;
    }
}
