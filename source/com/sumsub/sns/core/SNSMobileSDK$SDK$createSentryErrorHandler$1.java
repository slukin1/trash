package com.sumsub.sns.core;

import android.content.Context;
import com.sumsub.sns.internal.core.common.n0;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$SDK$createSentryErrorHandler$1 extends Lambda implements a<String> {
    public final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSMobileSDK$SDK$createSentryErrorHandler$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final String invoke() {
        try {
            String string = this.$context.getSharedPreferences(n0.f32115c, 0).getString(n0.i.f32195c, "unknown");
            if (string == null) {
                return "unknown";
            }
            return string;
        } catch (Exception unused) {
            return "unknown";
        }
    }
}
