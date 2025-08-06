package com.fluttercandies.photo_manager.core;

import com.tencent.qcloud.tuicore.TUIConstants;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class PhotoManagerPlugin$onHandlePermissionResult$14 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$14(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
    }

    public final void invoke() {
        if (x.b((Boolean) this.$call.argument(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION), Boolean.TRUE)) {
            this.this$0.f65025f.g();
        } else {
            this.this$0.f65025f.h();
        }
    }
}
