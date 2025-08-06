package com.huobi.edgeengine.debugger;

import d10.a;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class Debugger$setScriptSource$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ JSONObject $params;
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$setScriptSource$1(Debugger debugger, JSONObject jSONObject) {
        super(0);
        this.this$0 = debugger;
        this.$params = jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2310invoke$lambda0(Debugger debugger, JSONObject jSONObject) {
        V8Messenger e11 = debugger.f43968d;
        if (e11 != null) {
            e11.k(k.f44016a.k(), jSONObject);
        }
    }

    public final Unit invoke() {
        ExecutorService d11 = this.this$0.f43967c;
        if (d11 == null) {
            return null;
        }
        d11.execute(new f(this.this$0, this.$params));
        return Unit.f56620a;
    }
}
