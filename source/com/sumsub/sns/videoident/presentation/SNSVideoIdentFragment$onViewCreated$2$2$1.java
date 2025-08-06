package com.sumsub.sns.videoident.presentation;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "invoke", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$onViewCreated$2$2$1 extends Lambda implements l<CoordinatorLayout, Integer> {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$onViewCreated$2$2$1(SNSVideoIdentFragment sNSVideoIdentFragment) {
        super(1);
        this.this$0 = sNSVideoIdentFragment;
    }

    public final Integer invoke(CoordinatorLayout coordinatorLayout) {
        return Integer.valueOf(this.this$0.calculateExpandedOffset(coordinatorLayout));
    }
}
