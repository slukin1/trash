package com.huobi.edgeengine.debugger;

import d10.a;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class Debugger$setBreakpointByUrl$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ SetBreakpointByUrlRequest $request;
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$setBreakpointByUrl$1(Debugger debugger, SetBreakpointByUrlRequest setBreakpointByUrlRequest) {
        super(0);
        this.this$0 = debugger;
        this.$request = setBreakpointByUrlRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2308invoke$lambda0(Debugger debugger, SetBreakpointByUrlRequest setBreakpointByUrlRequest) {
        V8Messenger e11 = debugger.f43968d;
        if (e11 != null) {
            V8Messenger.i(e11, k.f44016a.i(), (JSONObject) debugger.i().convertValue(setBreakpointByUrlRequest, JSONObject.class), false, 4, (Object) null);
        }
    }

    public final Unit invoke() {
        ExecutorService d11 = this.this$0.f43967c;
        if (d11 == null) {
            return null;
        }
        d11.execute(new d(this.this$0, this.$request));
        return Unit.f56620a;
    }
}
