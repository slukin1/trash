package com.fluttercandies.photo_manager.core;

import com.fluttercandies.photo_manager.core.entity.b;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$15 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$15(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        try {
            byte[] bArr = (byte[]) this.$call.argument("image");
            String str = (String) this.$call.argument("title");
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = (String) this.$call.argument("desc");
            if (str3 == null) {
                str3 = str2;
            }
            String str4 = (String) this.$call.argument("relativePath");
            if (str4 != null) {
                str2 = str4;
            }
            b x11 = this.this$0.f65026g.x(bArr, str, str3, str2);
            if (x11 == null) {
                this.$resultHandler.h((Object) null);
                return;
            }
            this.$resultHandler.h(com.fluttercandies.photo_manager.core.utils.b.f65118a.c(x11));
        } catch (Exception e11) {
            z4.a.c("save image error", e11);
            this.$resultHandler.h((Object) null);
        }
    }
}
