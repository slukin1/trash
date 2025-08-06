package com.sumsub.sns.internal.videoident.presentation;

import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;
import kotlin.text.Regex;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36976a = 1920;

    public static final SNSViewState.e b(SNSViewState.e eVar, b.c cVar, Exception exc) {
        String str;
        k G = eVar.G();
        if (G != null) {
            if (exc instanceof SNSException.Network) {
                str = cVar.a("sns_videoident_error_connectionFailedNetwork");
            } else {
                str = cVar.a("sns_videoident_error_connectionFailedFatal");
            }
            G.a(str);
        }
        return eVar;
    }

    public static final SNSViewState.e b(SNSViewState.e eVar, b.c cVar, long j11) {
        String a11 = cVar.a(h.f36701w);
        eVar.e(a11 != null ? new Regex("\\{timeInMinutes\\}").replace((CharSequence) a11, String.valueOf(RangesKt___RangesKt.e(j11 / ((long) 60), 1))) : null);
        return eVar;
    }
}
