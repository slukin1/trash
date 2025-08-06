package com.huobi.edgeengine.debugger;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.inspector.V8Inspector;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Lcom/eclipsesource/v8/inspector/V8Inspector;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class V8Messenger$v8Inspector$2 extends Lambda implements a<V8Inspector> {
    public final /* synthetic */ V8 $v8;
    public final /* synthetic */ V8Messenger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V8Messenger$v8Inspector$2(V8 v82, V8Messenger v8Messenger) {
        super(0);
        this.$v8 = v82;
        this.this$0 = v8Messenger;
    }

    public final V8Inspector invoke() {
        return V8Inspector.createV8Inspector(this.$v8, this.this$0, "V8Messenger");
    }
}
