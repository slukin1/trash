package com.sumsub.sns.core.widget;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/sumsub/sns/core/widget/SNSErrorBottomSheetView$special$$inlined$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class SNSErrorBottomSheetView$special$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View $this_doOnAttach;
    public final /* synthetic */ SNSErrorBottomSheetView this$0;

    public SNSErrorBottomSheetView$special$$inlined$doOnAttach$1(View view, SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        this.$this_doOnAttach = view;
        this.this$0 = sNSErrorBottomSheetView;
    }

    public void onViewAttachedToWindow(View view) {
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        BottomSheetBehavior access$getBehavior$p = this.this$0.behavior;
        if (access$getBehavior$p != null) {
            access$getBehavior$p.setState(5);
        }
        this.this$0.setVisibility(8);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
