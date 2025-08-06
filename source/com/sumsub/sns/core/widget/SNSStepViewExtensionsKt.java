package com.sumsub.sns.core.widget;

import android.view.View;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u0015\u0010\b\u001a\u00020\t*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\t*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"value", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "snsStepState", "Landroid/view/View;", "getSnsStepState", "(Landroid/view/View;)Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "setSnsStepState", "(Landroid/view/View;Lcom/sumsub/sns/internal/core/widget/SNSStepState;)V", "snsStepStateDrawable", "", "getSnsStepStateDrawable", "(Landroid/view/View;)[I", "toDrawableState", "getToDrawableState", "(Lcom/sumsub/sns/internal/core/widget/SNSStepState;)[I", "idensic-mobile-sdk-aar_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SNSStepViewExtensionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SNSStepState.values().length];
            iArr[SNSStepState.INIT.ordinal()] = 1;
            iArr[SNSStepState.PENDING.ordinal()] = 2;
            iArr[SNSStepState.APPROVED.ordinal()] = 3;
            iArr[SNSStepState.REJECTED.ordinal()] = 4;
            iArr[SNSStepState.PROCESSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SNSStepState getSnsStepState(View view) {
        SNSStepState sNSStepState;
        a aVar = view instanceof a ? (a) view : null;
        return (aVar == null || (sNSStepState = aVar.getSNSStepState()) == null) ? SNSStepState.INIT : sNSStepState;
    }

    public static final int[] getSnsStepStateDrawable(View view) {
        SNSStepState sNSStepState;
        a aVar = view instanceof a ? (a) view : null;
        if (aVar == null || (sNSStepState = aVar.getSNSStepState()) == null) {
            sNSStepState = SNSStepState.INIT;
        }
        return getToDrawableState(sNSStepState);
    }

    public static final int[] getToDrawableState(SNSStepState sNSStepState) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[sNSStepState.ordinal()];
        if (i11 == 1) {
            return SNSStepAttrs.INSTANCE.getSTATE_INIT();
        }
        if (i11 == 2) {
            return SNSStepAttrs.INSTANCE.getSTATE_PENDING();
        }
        if (i11 == 3) {
            return SNSStepAttrs.INSTANCE.getSTATE_APPROVED();
        }
        if (i11 == 4) {
            return SNSStepAttrs.INSTANCE.getSTATE_REJECTED();
        }
        if (i11 == 5) {
            return SNSStepAttrs.INSTANCE.getSTATE_PROCESSING();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void setSnsStepState(View view, SNSStepState sNSStepState) {
        if ((view instanceof a ? (a) view : null) != null) {
            ((a) view).setSNSStepState(sNSStepState);
        }
    }
}
