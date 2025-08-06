package com.fluttercandies.photo_manager.core;

import android.os.Build;
import d10.a;
import io.flutter.plugin.common.MethodCall;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z4.e;

public final class PhotoManagerPlugin$onHandlePermissionResult$20 extends Lambda implements a<Unit> {
    public final /* synthetic */ MethodCall $call;
    public final /* synthetic */ e $resultHandler;
    public final /* synthetic */ PhotoManagerPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoManagerPlugin$onHandlePermissionResult$20(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar) {
        super(0);
        this.$call = methodCall;
        this.this$0 = photoManagerPlugin;
        this.$resultHandler = eVar;
    }

    public final void invoke() {
        try {
            List<String> list = (List) this.$call.argument("ids");
            if (Build.VERSION.SDK_INT >= 30) {
                PhotoManagerPlugin photoManagerPlugin = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
                for (String r11 : list) {
                    arrayList.add(photoManagerPlugin.f65026g.r(r11));
                }
                this.this$0.j().c(CollectionsKt___CollectionsKt.I0(arrayList), this.$resultHandler);
                return;
            }
            this.this$0.j().b(list);
            this.$resultHandler.h(list);
        } catch (Exception e11) {
            z4.a.c("deleteWithIds failed", e11);
            e.k(this.$resultHandler, "deleteWithIds failed", (String) null, (Object) null, 6, (Object) null);
        }
    }
}
