package com.sumsub.sns.core;

import android.content.Context;
import com.sumsub.sns.core.data.listener.SNSUrlHandler;
import d10.p;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$7$1", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "onUrl", "", "context", "Landroid/content/Context;", "url", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$Builder$withHandlers$1$7$1 implements SNSUrlHandler {
    public final /* synthetic */ p<Context, String, Boolean> $it;

    public SNSMobileSDK$Builder$withHandlers$1$7$1(p<? super Context, ? super String, Boolean> pVar) {
        this.$it = pVar;
    }

    public boolean onUrl(Context context, String str) {
        return this.$it.invoke(context, str).booleanValue();
    }
}
