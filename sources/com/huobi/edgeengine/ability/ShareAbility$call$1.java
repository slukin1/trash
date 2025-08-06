package com.huobi.edgeengine.ability;

import android.view.View;
import com.huobi.edgeengine.model.ShareMode;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import rj.b;

public final class ShareAbility$call$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ b $edgeEngine;
    public final /* synthetic */ ShareMode $shareMode;
    public final /* synthetic */ Ref$ObjectRef<View> $shareView;
    public final /* synthetic */ ShareAbility this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareAbility$call$1(ShareAbility shareAbility, b bVar, Ref$ObjectRef<View> ref$ObjectRef, ShareMode shareMode) {
        super(0);
        this.this$0 = shareAbility;
        this.$edgeEngine = bVar;
        this.$shareView = ref$ObjectRef;
        this.$shareMode = shareMode;
    }

    public final void invoke() {
        this.this$0.d(this.$edgeEngine.d(), (View) this.$shareView.element, this.$shareMode);
    }
}
