package com.fluttercandies.photo_manager.core;

import com.fluttercandies.photo_manager.core.utils.b;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$3 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$3(PhotoManagerPlugin photoManagerPlugin, MethodCall methodCall, e eVar) {
        super(0);
        this.this$0 = photoManagerPlugin;
        this.$call = methodCall;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        this.$resultHandler.h(b.f65118a.d(this.this$0.f65026g.h(this.this$0.m(this.$call, "id"), this.this$0.k(this.$call, "type"), this.this$0.k(this.$call, "start"), this.this$0.k(this.$call, "end"), this.this$0.l(this.$call))));
    }
}
