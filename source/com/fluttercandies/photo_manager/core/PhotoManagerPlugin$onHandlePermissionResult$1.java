package com.fluttercandies.photo_manager.core;

import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.utils.b;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$1(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        int intValue = ((Number) this.$call.argument("type")).intValue();
        boolean booleanValue = ((Boolean) this.$call.argument("hasAll")).booleanValue();
        FilterOption c11 = this.this$0.l(this.$call);
        this.$resultHandler.h(b.f65118a.f(this.this$0.f65026g.l(intValue, booleanValue, ((Boolean) this.$call.argument("onlyAll")).booleanValue(), c11)));
    }
}
