package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import d10.p;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$4$1", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "onActionResult", "Lcom/sumsub/sns/core/SNSActionResult;", "actionId", "", "actionType", "answer", "allowContinuing", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$Builder$withHandlers$1$4$1 implements SNSActionResultHandler {
    public final /* synthetic */ p<String, String, SNSActionResult> $it;

    public SNSMobileSDK$Builder$withHandlers$1$4$1(p<? super String, ? super String, ? extends SNSActionResult> pVar) {
        this.$it = pVar;
    }

    public SNSActionResult onActionResult(String str, String str2, String str3, boolean z11) {
        return this.$it.invoke(str, str3);
    }
}
