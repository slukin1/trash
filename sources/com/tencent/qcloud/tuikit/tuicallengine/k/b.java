package com.tencent.qcloud.tuikit.tuicallengine.k;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qcloud.tuikit.TUICommonDefine;

public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public TUICommonDefine.Callback f48533a;

    /* renamed from: b  reason: collision with root package name */
    public TUICommonDefine.ValueCallback<T> f48534b;

    /* renamed from: c  reason: collision with root package name */
    public TUICommonDefine.PlayCallback f48535c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f48536d = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TUICommonDefine.Callback callback = b.this.f48533a;
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.k.b$b  reason: collision with other inner class name */
    public class C0608b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f48538a;

        public C0608b(Object obj) {
            this.f48538a = obj;
        }

        public void run() {
            TUICommonDefine.ValueCallback<T> valueCallback = b.this.f48534b;
            if (valueCallback != null) {
                valueCallback.onSuccess(this.f48538a);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f48540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48541b;

        public c(int i11, String str) {
            this.f48540a = i11;
            this.f48541b = str;
        }

        public void run() {
            TUICommonDefine.Callback callback = b.this.f48533a;
            if (callback != null) {
                callback.onError(this.f48540a, this.f48541b);
            }
            TUICommonDefine.ValueCallback<T> valueCallback = b.this.f48534b;
            if (valueCallback != null) {
                valueCallback.onError(this.f48540a, this.f48541b);
            }
        }
    }

    public b(TUICommonDefine.Callback callback) {
        this.f48533a = callback;
    }

    public void a() {
        this.f48536d.post(new a());
    }

    public void a(T t11) {
        this.f48536d.post(new C0608b(t11));
    }

    public b(TUICommonDefine.ValueCallback valueCallback) {
        this.f48534b = valueCallback;
    }

    public void a(int i11, String str) {
        this.f48536d.post(new c(i11, str));
    }

    public b(TUICommonDefine.PlayCallback playCallback) {
        this.f48535c = playCallback;
    }
}
