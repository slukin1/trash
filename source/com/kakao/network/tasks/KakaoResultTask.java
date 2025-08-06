package com.kakao.network.tasks;

import android.os.Handler;
import android.os.Looper;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.exception.ResponseStatusError;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import uw.c;

public abstract class KakaoResultTask<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f25070c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final ResponseCallback<T> f25071a;

    /* renamed from: b  reason: collision with root package name */
    public final Callable<T> f25072b;

    public class a implements Callable<T> {

        /* renamed from: com.kakao.network.tasks.KakaoResultTask$a$a  reason: collision with other inner class name */
        public class C0217a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f25074b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f25075c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f25076d;

            public C0217a(Exception exc, Object obj, CountDownLatch countDownLatch) {
                this.f25074b = exc;
                this.f25075c = obj;
                this.f25076d = countDownLatch;
            }

            public void run() {
                c cVar;
                try {
                    ResponseCallback<T> responseCallback = KakaoResultTask.this.f25071a;
                    if (responseCallback != null) {
                        Exception exc = this.f25074b;
                        if (exc != null) {
                            if (exc instanceof ResponseStatusError) {
                                cVar = new c((ResponseStatusError) exc);
                            } else {
                                cVar = new c(exc);
                            }
                            KakaoResultTask.this.f25071a.onFailureForUiThread(cVar);
                        } else {
                            responseCallback.onSuccessForUiThread(this.f25075c);
                        }
                        this.f25076d.countDown();
                    }
                } finally {
                    this.f25076d.countDown();
                }
            }
        }

        public a() {
        }

        public T call() throws Exception {
            T t11 = null;
            try {
                ResponseCallback<T> responseCallback = KakaoResultTask.this.f25071a;
                if (responseCallback != null) {
                    responseCallback.onDidStart();
                }
                KakaoResultTask.this.e();
                e = null;
                t11 = KakaoResultTask.this.b();
            } catch (Exception e11) {
                e = e11;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            KakaoResultTask.f25070c.post(new C0217a(e, t11, countDownLatch));
            countDownLatch.await();
            KakaoResultTask.this.d();
            ResponseCallback<T> responseCallback2 = KakaoResultTask.this.f25071a;
            if (responseCallback2 != null) {
                responseCallback2.onDidEnd();
            }
            return t11;
        }
    }

    public KakaoResultTask() {
        this.f25072b = new a();
        this.f25071a = null;
    }

    public abstract T b() throws Exception;

    public final Callable<T> c() {
        return this.f25072b;
    }

    public void d() {
    }

    public void e() {
    }

    public KakaoResultTask(ResponseCallback<T> responseCallback) {
        this.f25072b = new a();
        this.f25071a = responseCallback;
    }
}
