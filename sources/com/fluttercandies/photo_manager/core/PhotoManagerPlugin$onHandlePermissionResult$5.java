package com.fluttercandies.photo_manager.core;

import com.fluttercandies.photo_manager.core.entity.f;
import com.tencent.qcloud.tuicore.TUIConstants;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$5 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$5(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        f a11 = f.f65096f.a((Map) this.$call.argument(TUIConstants.TUIPoll.PLUGIN_POLL_OPTION_CONTENT));
        this.this$0.f65026g.u((List) this.$call.argument("ids"), a11, this.$resultHandler);
    }
}
