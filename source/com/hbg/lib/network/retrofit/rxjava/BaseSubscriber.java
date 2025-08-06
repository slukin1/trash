package com.hbg.lib.network.retrofit.rxjava;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import rx.Subscriber;

public class BaseSubscriber<T> extends Subscriber<T> {
    public void onAfter() {
    }

    public void onCompleted() {
        onAfter();
    }

    public void onError(Throwable th2) {
        printLog(th2);
        onAfter();
    }

    public void onNext(T t11) {
    }

    public void onStart() {
        super.onStart();
    }

    public void printLog(Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException)) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(th2 + "\n");
            if (stackTrace != null) {
                for (StackTraceElement append : stackTrace) {
                    sb2.append(append);
                    sb2.append("\n");
                }
            }
            RetrofitLogger.g(sb2.toString());
        }
    }
}
