package com.huobi.edgeengine.debugger;

import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import tj.c;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/huobi/edgeengine/debugger/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class Debugger$getScriptSource$1 extends Lambda implements a<g> {
    public final /* synthetic */ JSONObject $params;
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$getScriptSource$1(Debugger debugger, JSONObject jSONObject) {
        super(0);
        this.this$0 = debugger;
        this.$params = jSONObject;
    }

    public final g invoke() {
        try {
            return new g(this.this$0.f43965a.a(((GetScriptSourceRequest) this.this$0.i().convertValue(this.$params, GetScriptSourceRequest.class)).f43972a));
        } catch (Exception e11) {
            return new g(c.a().c(e11));
        }
    }
}
