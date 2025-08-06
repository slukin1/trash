package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private R f38466a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f38467b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ResultCallback f38468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ErrorResultImpl f38469b;

        public a(ResultCallback resultCallback, ErrorResultImpl errorResultImpl) {
            this.f38468a = resultCallback;
            this.f38469b = errorResultImpl;
        }

        public void run() {
            ResultCallback resultCallback = this.f38468a;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.a(errorResultImpl.f38467b, this.f38469b));
        }
    }

    public ErrorResultImpl(int i11) {
        this.f38467b = i11;
    }

    public final R await() {
        return await(0, (TimeUnit) null);
    }

    @Deprecated
    public void cancel() {
    }

    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public void postRunnable(Looper looper, ResultCallback<R> resultCallback, ErrorResultImpl errorResultImpl) {
        if (looper == null) {
            looper = Looper.myLooper();
        }
        new Handler(looper).post(new a(resultCallback, errorResultImpl));
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public R await(long j11, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return a(this.f38467b, this);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* access modifiers changed from: private */
    public R a(int i11, ErrorResultImpl errorResultImpl) {
        Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            R r11 = (Result) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
            this.f38466a = r11;
            r11.setStatus(new Status(i11));
        } catch (InstantiationException unused) {
            HMSLog.e("ErrorResultImpl", "InstantiationException");
        } catch (IllegalAccessException unused2) {
            HMSLog.e("ErrorResultImpl", "IllegalAccessException");
        }
        return this.f38466a;
    }

    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j11, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        postRunnable(looper, resultCallback, this);
    }
}
