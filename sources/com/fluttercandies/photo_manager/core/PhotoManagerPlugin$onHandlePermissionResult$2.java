package com.fluttercandies.photo_manager.core;

import com.facebook.places.model.PlaceFields;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.utils.b;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$2 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$2(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        int intValue = ((Number) this.$call.argument("type")).intValue();
        int intValue2 = ((Number) this.$call.argument(PlaceFields.PAGE)).intValue();
        int intValue3 = ((Number) this.$call.argument("size")).intValue();
        FilterOption c11 = this.this$0.l(this.$call);
        this.$resultHandler.h(b.f65118a.d(this.this$0.f65026g.g((String) this.$call.argument("id"), intValue, intValue2, intValue3, c11)));
    }
}
