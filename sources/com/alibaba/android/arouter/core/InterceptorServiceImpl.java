package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.MapUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Route(path = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14055a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f14056b = new Object();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Postcard f14057b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InterceptorCallback f14058c;

        public a(Postcard postcard, InterceptorCallback interceptorCallback) {
            this.f14057b = postcard;
            this.f14058c = interceptorCallback;
        }

        public void run() {
            c2.a aVar = new c2.a(a2.a.f3484f.size());
            try {
                InterceptorServiceImpl.s(0, aVar, this.f14057b);
                aVar.await((long) this.f14057b.getTimeout(), TimeUnit.SECONDS);
                if (aVar.getCount() > 0) {
                    this.f14058c.onInterrupt(new HandlerException("The interceptor processing timed out."));
                } else if (this.f14057b.getTag() != null) {
                    this.f14058c.onInterrupt(new HandlerException(this.f14057b.getTag().toString()));
                } else {
                    this.f14058c.onContinue(this.f14057b);
                }
            } catch (Exception e11) {
                this.f14058c.onInterrupt(e11);
            }
        }
    }

    public static class b implements InterceptorCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2.a f14060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Postcard f14062c;

        public b(c2.a aVar, int i11, Postcard postcard) {
            this.f14060a = aVar;
            this.f14061b = i11;
            this.f14062c = postcard;
        }

        public void onContinue(Postcard postcard) {
            this.f14060a.countDown();
            InterceptorServiceImpl.s(this.f14061b + 1, this.f14060a, postcard);
        }

        public void onInterrupt(Throwable th2) {
            this.f14062c.setTag(th2 == null ? new HandlerException("No message.") : th2.getMessage());
            this.f14060a.a();
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f14063b;

        public c(Context context) {
            this.f14063b = context;
        }

        public void run() {
            if (MapUtils.b(a2.a.f3483e)) {
                for (Map.Entry<Integer, Class<? extends IInterceptor>> value : a2.a.f3483e.entrySet()) {
                    Class cls = (Class) value.getValue();
                    try {
                        IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iInterceptor.init(this.f14063b);
                        a2.a.f3484f.add(iInterceptor);
                    } catch (Exception e11) {
                        throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + cls.getName() + "], reason = [" + e11.getMessage() + "]");
                    }
                }
                boolean unused = InterceptorServiceImpl.f14055a = true;
                b2.a.f12290c.info(ILogger.defaultTag, "ARouter interceptors init over.");
                synchronized (InterceptorServiceImpl.f14056b) {
                    InterceptorServiceImpl.f14056b.notifyAll();
                }
            }
        }
    }

    public static void s(int i11, c2.a aVar, Postcard postcard) {
        if (i11 < a2.a.f3484f.size()) {
            a2.a.f3484f.get(i11).process(postcard, new b(aVar, i11, postcard));
        }
    }

    public static void w() {
        synchronized (f14056b) {
            while (!f14055a) {
                try {
                    f14056b.wait(10000);
                } catch (InterruptedException e11) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e11.getMessage() + "]");
                }
            }
        }
    }

    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        List<IInterceptor> list = a2.a.f3484f;
        if (list == null || list.size() <= 0) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        w();
        if (!f14055a) {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        } else {
            LogisticsCenter.f14066b.execute(new a(postcard, interceptorCallback));
        }
    }

    public void init(Context context) {
        LogisticsCenter.f14066b.execute(new c(context));
    }
}
