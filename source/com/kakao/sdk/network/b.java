package com.kakao.sdk.network;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"", "a", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "origin", "network_release"}, k = 2, mv = {1, 6, 0})
public final class b {
    public static final Throwable a(Throwable th2) {
        return th2 instanceof ExceptionWrapper ? ((ExceptionWrapper) th2).getOrigin() : th2;
    }
}
