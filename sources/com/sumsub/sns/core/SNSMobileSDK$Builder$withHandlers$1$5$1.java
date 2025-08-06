package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$5$1", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "onEvent", "", "event", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$Builder$withHandlers$1$5$1 implements SNSEventHandler {
    public final /* synthetic */ l<SNSEvent, Unit> $it;

    public SNSMobileSDK$Builder$withHandlers$1$5$1(l<? super SNSEvent, Unit> lVar) {
        this.$it = lVar;
    }

    public void onEvent(SNSEvent sNSEvent) {
        this.$it.invoke(sNSEvent);
    }
}
