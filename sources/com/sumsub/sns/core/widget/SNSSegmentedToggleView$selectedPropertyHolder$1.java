package com.sumsub.sns.core.widget;

import j1.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/sumsub/sns/core/widget/SNSSegmentedToggleView$selectedPropertyHolder$1", "Lj1/a;", "Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView;", "view", "", "getValue", "value", "", "setValue", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSSegmentedToggleView$selectedPropertyHolder$1 extends a<SNSSegmentedToggleView> {
    public final /* synthetic */ SNSSegmentedToggleView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSSegmentedToggleView$selectedPropertyHolder$1(SNSSegmentedToggleView sNSSegmentedToggleView) {
        super("selectedItem");
        this.this$0 = sNSSegmentedToggleView;
    }

    public float getValue(SNSSegmentedToggleView sNSSegmentedToggleView) {
        return this.this$0.selected * 1000.0f;
    }

    public void setValue(SNSSegmentedToggleView sNSSegmentedToggleView, float f11) {
        this.this$0.selected = f11 / 1000.0f;
        this.this$0.postInvalidateOnAnimation();
    }
}
