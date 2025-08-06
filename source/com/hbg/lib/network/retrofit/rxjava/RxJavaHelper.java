package com.hbg.lib.network.retrofit.rxjava;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import e9.e;
import rx.Observable;

public class RxJavaHelper {
    public static /* synthetic */ Boolean d(RequestCallback1 requestCallback1, Object obj) {
        return Boolean.valueOf(requestCallback1 == null || requestCallback1.isAlive());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.onRequestSuccessAsync(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object e(com.hbg.lib.network.retrofit.request.callback.RequestCallback1 r0, java.lang.Object r1) {
        /*
            if (r0 == 0) goto L_0x000a
            java.lang.Object r0 = r0.onRequestSuccessAsync(r1)
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            return r0
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.retrofit.rxjava.RxJavaHelper.e(com.hbg.lib.network.retrofit.request.callback.RequestCallback1, java.lang.Object):java.lang.Object");
    }

    public static <T> Observable.Transformer<T, T> g(RequestCallback1<T> requestCallback1) {
        return new e(requestCallback1);
    }
}
