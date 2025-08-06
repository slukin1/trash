package com.sumsub.sns.core.widget;

import com.sumsub.sns.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSStepAttrs;", "", "()V", "STATE_APPROVED", "", "getSTATE_APPROVED", "()[I", "STATE_INIT", "getSTATE_INIT", "STATE_PENDING", "getSTATE_PENDING", "STATE_PROCESSING", "getSTATE_PROCESSING", "STATE_REJECTED", "getSTATE_REJECTED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSStepAttrs {
    public static final SNSStepAttrs INSTANCE = new SNSStepAttrs();
    private static final int[] STATE_APPROVED = {R.attr.sns_stateApproved};
    private static final int[] STATE_INIT = {R.attr.sns_stateInit};
    private static final int[] STATE_PENDING = {R.attr.sns_statePending};
    private static final int[] STATE_PROCESSING = {R.attr.sns_stateProcessing};
    private static final int[] STATE_REJECTED = {R.attr.sns_stateRejected};

    private SNSStepAttrs() {
    }

    public final int[] getSTATE_APPROVED() {
        return STATE_APPROVED;
    }

    public final int[] getSTATE_INIT() {
        return STATE_INIT;
    }

    public final int[] getSTATE_PENDING() {
        return STATE_PENDING;
    }

    public final int[] getSTATE_PROCESSING() {
        return STATE_PROCESSING;
    }

    public final int[] getSTATE_REJECTED() {
        return STATE_REJECTED;
    }
}
