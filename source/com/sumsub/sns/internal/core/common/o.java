package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.r;

public final class o {
    public static /* synthetic */ com.sumsub.sns.internal.core.data.model.o a(Throwable th2, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return a(th2, obj);
    }

    public static final com.sumsub.sns.internal.core.data.model.o a(Throwable th2, Object obj) {
        boolean z11;
        if (th2 instanceof SNSException.Api) {
            return a((SNSException.Api) th2, obj);
        }
        if (th2 instanceof IOException) {
            z11 = true;
        } else {
            z11 = th2 instanceof SNSException.Network;
        }
        if (z11) {
            return new o.e(th2, obj, (o.a) null, 4, (r) null);
        }
        if (th2 instanceof CancellationException) {
            return null;
        }
        return new o.c(th2, obj, (o.a) null, 4, (r) null);
    }

    public static final com.sumsub.sns.internal.core.data.model.o a(SNSException.Api api, Object obj) {
        Integer errorCode = api.getErrorCode();
        boolean z11 = false;
        if ((((((((((((((errorCode != null && errorCode.intValue() == 1000) || (errorCode != null && errorCode.intValue() == 1001)) || (errorCode != null && errorCode.intValue() == 1002)) || (errorCode != null && errorCode.intValue() == 1003)) || (errorCode != null && errorCode.intValue() == 1004)) || (errorCode != null && errorCode.intValue() == 1005)) || (errorCode != null && errorCode.intValue() == 1006)) || (errorCode != null && errorCode.intValue() == 1007)) || (errorCode != null && errorCode.intValue() == 2000)) || (errorCode != null && errorCode.intValue() == 2001)) || (errorCode != null && errorCode.intValue() == 2002)) || (errorCode != null && errorCode.intValue() == 2003)) || (errorCode != null && errorCode.intValue() == 2004)) || (errorCode != null && errorCode.intValue() == 2005)) {
            z11 = true;
        }
        if (z11) {
            return new o.f(api.getDescription(), api, obj, (o.a) null, 8, (r) null);
        }
        return new o.c(api, obj, (o.a) null, 4, (r) null);
    }

    public static /* synthetic */ com.sumsub.sns.internal.core.data.model.o a(SNSException.Api api, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return a(api, obj);
    }

    public static final String a(Throwable th2, b.c cVar) {
        if (th2 instanceof SNSException.Api) {
            return ((SNSException.Api) th2).getDescription();
        }
        if (th2 instanceof SNSException.Network) {
            return cVar.a(n0.j.f32204d);
        }
        return th2 instanceof SNSException.Unknown ? ((SNSException.Unknown) th2).getLocalizedMessage() : "Unknown exception";
    }
}
