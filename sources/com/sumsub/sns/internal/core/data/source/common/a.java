package com.sumsub.sns.internal.core.data.source.common;

import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.Locale;
import java.util.Map;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;

public interface a {
    Object a(String str, boolean z11, c<? super g> cVar);

    Object a(c<? super Map<String, ? extends Object>> cVar);

    String a();

    void a(SNSSDKState sNSSDKState);

    void a(String str);

    Object b(c<? super SNSSDKState> cVar);

    d<SNSSDKState> b();

    Object c(c<? super Locale> cVar);
}
