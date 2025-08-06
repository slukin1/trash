package com.fluttercandies.photo_manager.core;

import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$8 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ boolean $haveLocationPermission;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$8(MethodCall methodCall, boolean z11, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.$haveLocationPermission = z11;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        this.this$0.f65026g.k((String) this.$call.argument("id"), !this.$haveLocationPermission ? false : ((Boolean) this.$call.argument("isOrigin")).booleanValue(), this.$resultHandler);
    }
}
