package com.huobi.home.util;

import android.graphics.Rect;
import android.view.View;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class ViewExtKt$onVisibilityChange$checkVisibility$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ int $KEY_VISIBILITY;
    public final /* synthetic */ p<View, Boolean, Unit> $block;
    public final /* synthetic */ View $this_onVisibilityChange;
    public final /* synthetic */ Rect $visibleRect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewExtKt$onVisibilityChange$checkVisibility$1(View view, int i11, Rect rect, p<? super View, ? super Boolean, Unit> pVar) {
        super(0);
        this.$this_onVisibilityChange = view;
        this.$KEY_VISIBILITY = i11;
        this.$visibleRect = rect;
        this.$block = pVar;
    }

    public final void invoke() {
        Object tag = this.$this_onVisibilityChange.getTag(this.$KEY_VISIBILITY);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        boolean z11 = ViewExtKt.f(this.$this_onVisibilityChange, this.$visibleRect) > 0.0f;
        if (bool == null) {
            if (z11) {
                p<View, Boolean, Unit> pVar = this.$block;
                View view = this.$this_onVisibilityChange;
                Boolean bool2 = Boolean.TRUE;
                pVar.invoke(view, bool2);
                this.$this_onVisibilityChange.setTag(this.$KEY_VISIBILITY, bool2);
            }
        } else if (!x.b(bool, Boolean.valueOf(z11))) {
            this.$block.invoke(this.$this_onVisibilityChange, Boolean.valueOf(z11));
            this.$this_onVisibilityChange.setTag(this.$KEY_VISIBILITY, Boolean.valueOf(z11));
        }
    }
}
