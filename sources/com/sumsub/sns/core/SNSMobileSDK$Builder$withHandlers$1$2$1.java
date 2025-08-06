package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.model.SNSSDKState;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$2$1", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "onStateChanged", "", "previousState", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "currentState", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$Builder$withHandlers$1$2$1 implements SNSStateChangedHandler {
    public final /* synthetic */ p<SNSSDKState, SNSSDKState, Unit> $it;

    public SNSMobileSDK$Builder$withHandlers$1$2$1(p<? super SNSSDKState, ? super SNSSDKState, Unit> pVar) {
        this.$it = pVar;
    }

    public void onStateChanged(SNSSDKState sNSSDKState, SNSSDKState sNSSDKState2) {
        this.$it.invoke(sNSSDKState2, sNSSDKState);
    }
}
