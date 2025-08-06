package com.huobi.uiKit.window.floatkeeper;

import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.badge.BadgeDrawable;
import com.huobi.uiKit.window.floatkeeper.core.FloatingContainerView;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class HbFloatKeeper$container$2 extends Lambda implements a<FloatingContainerView> {
    public static final HbFloatKeeper$container$2 INSTANCE = new HbFloatKeeper$container$2();

    public HbFloatKeeper$container$2() {
        super(0);
    }

    public final FloatingContainerView invoke() {
        FloatingContainerView floatingContainerView = new FloatingContainerView(Utils.a(), (AttributeSet) null, 0, 6, (r) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.setMargins(13, layoutParams.topMargin, layoutParams.rightMargin, 500);
        return floatingContainerView;
    }
}
