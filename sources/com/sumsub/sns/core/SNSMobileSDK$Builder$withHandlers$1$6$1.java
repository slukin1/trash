package com.sumsub.sns.core;

import android.content.Context;
import android.view.View;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import d10.t;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$6$1", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "onVerificationStep", "Landroid/view/View;", "context", "Landroid/content/Context;", "verificationStep", "", "idDocumentType", "scene", "position", "countryCode", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$Builder$withHandlers$1$6$1 implements SNSInstructionsViewHandler {
    public final /* synthetic */ t<Context, String, String, String, String, String, View> $it;

    public SNSMobileSDK$Builder$withHandlers$1$6$1(t<? super Context, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends View> tVar) {
        this.$it = tVar;
    }

    public View onVerificationStep(Context context, String str, String str2, String str3, String str4, String str5) {
        return this.$it.invoke(context, str, str2, str3, str4, str5);
    }
}
