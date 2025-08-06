package com.huobi.network.interceptor;

import android.text.TextUtils;
import bh.j;
import com.hbg.lib.network.retrofit.response.IResponse;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.statistics.GrowingIOStatics;
import i6.d;
import i6.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mo.a;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import tg.r;

public abstract class BaseTokenErrorCheckInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public volatile CountDownLatch f78035a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f78036b;

    public static abstract class BaseTokenErrorHandleResponse implements IResponse {
        public abstract String getErrCode();

        public abstract String getErrMsg();

        public abstract String getStatus();

        public boolean isSuccess() {
            return false;
        }

        public boolean isTokenError() {
            return true;
        }
    }

    public static class BaseTokenWrapper {

        /* renamed from: a  reason: collision with root package name */
        public String f78037a;

        /* renamed from: b  reason: collision with root package name */
        public int f78038b;

        public int a() {
            return this.f78038b;
        }

        public String b() {
            return this.f78037a;
        }

        public void c(int i11) {
            this.f78038b = i11;
        }

        public void d(String str) {
            this.f78037a = str;
        }
    }

    public abstract void a();

    public abstract Response b(Interceptor.Chain chain, Response response, String str, int i11) throws IOException;

    public abstract String c();

    public abstract String d();

    public void e(Request request, BaseTokenErrorHandleResponse baseTokenErrorHandleResponse, Response response) {
        if (baseTokenErrorHandleResponse != null && !baseTokenErrorHandleResponse.isSuccess() && baseTokenErrorHandleResponse.isTokenError()) {
            m(request, baseTokenErrorHandleResponse, response);
        }
    }

    public final Response f(Response response, Interceptor.Chain chain) {
        ResponseBody body = response.body();
        try {
            BaseTokenErrorHandleResponse j11 = j(chain.request().url().host(), body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8));
            int g11 = g(j11);
            if (g11 == -1) {
                e(chain.request(), j11, response);
            } else if (g11 != 0) {
                i("handleTokenErrorCheck--token is error url [" + chain.request().url().toString() + "]");
                String name = Thread.currentThread().getName();
                if (this.f78035a == null) {
                    synchronized (this) {
                        if (this.f78035a == null) {
                            this.f78035a = new CountDownLatch(1);
                            this.f78036b = name;
                            a();
                            i("handleTokenErrorCheck--initlock curThreadName = " + name);
                        }
                    }
                }
                if (this.f78036b != null && !this.f78036b.equals(name)) {
                    i("handleTokenErrorCheck--waitlock curThreadName = " + name);
                    this.f78035a.await(10, TimeUnit.SECONDS);
                }
                String d11 = d();
                if (!TextUtils.isEmpty(d11)) {
                    Response b11 = b(chain, response, d11, g11);
                    BaseTokenErrorHandleResponse n11 = n(b11, g11);
                    return (n11 == null || !n11.isSuccess()) ? response : b11;
                }
                Response l11 = l(chain, response, j11, g11);
                if (l11 != null) {
                    return l11;
                }
            }
        } catch (Exception e11) {
            d.f(c(), e11);
        }
        return response;
    }

    public abstract int g(BaseTokenErrorHandleResponse baseTokenErrorHandleResponse);

    public int h(Interceptor.Chain chain) {
        return 0;
    }

    public void i(String str) {
        k.o(c(), str);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        String str;
        int h11 = h(chain);
        if (h11 == 1) {
            try {
                String name = Thread.currentThread().getName();
                if (this.f78035a == null) {
                    synchronized (this) {
                        if (this.f78035a == null) {
                            this.f78035a = new CountDownLatch(1);
                            this.f78036b = name;
                        }
                    }
                }
                if (!this.f78036b.equals(name) && this.f78035a != null) {
                    this.f78035a.await(10, TimeUnit.SECONDS);
                }
                if (TextUtils.isEmpty(d())) {
                    BaseTokenWrapper k11 = k(h11);
                    if (k11 == null) {
                        str = null;
                    } else {
                        str = k11.b();
                    }
                    d.j(c(), "3 . getToken token is " + str + " url [" + chain.request().url().toString() + "]");
                    if (this.f78035a != null) {
                        synchronized (this) {
                            if (this.f78035a != null) {
                                this.f78035a.countDown();
                                this.f78035a = null;
                            }
                            this.f78036b = null;
                        }
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        Response proceed = chain.proceed(chain.request());
        if (proceed == null || !proceed.isSuccessful() || (body = proceed.body()) == null) {
            return proceed;
        }
        body.source().request(Long.MAX_VALUE);
        Response f11 = f(proceed, chain);
        return f11 == null ? proceed : f11;
    }

    public abstract BaseTokenErrorHandleResponse j(String str, String str2);

    public abstract BaseTokenWrapper k(int i11);

    public final Response l(Interceptor.Chain chain, Response response, BaseTokenErrorHandleResponse baseTokenErrorHandleResponse, int i11) throws IOException {
        String str;
        int i12;
        BaseTokenWrapper k11 = k(i11);
        if (k11 == null) {
            str = null;
        } else {
            str = k11.b();
        }
        if (k11 == null) {
            i12 = -1;
        } else {
            i12 = k11.a();
        }
        i("retryConnect--getToken token is " + str + " url [" + chain.request().url().toString() + "]");
        if (this.f78035a != null) {
            String name = Thread.currentThread().getName();
            if (this.f78036b != null && this.f78036b.equals(name)) {
                i("retryConnect--reset lock curThreadName=" + name);
                this.f78035a.countDown();
                this.f78035a = null;
                this.f78036b = null;
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (i12 != 1) {
                e(chain.request(), baseTokenErrorHandleResponse, response);
            }
            return null;
        }
        Response b11 = b(chain, response, str, i11);
        BaseTokenErrorHandleResponse n11 = n(b11, i11);
        if (b11 == null || n11 == null) {
            e(chain.request(), baseTokenErrorHandleResponse, b11);
            return null;
        }
        e(chain.request(), n11, b11);
        return b11;
    }

    public void m(Request request, BaseTokenErrorHandleResponse baseTokenErrorHandleResponse, Response response) {
        String errCode = baseTokenErrorHandleResponse.getErrCode();
        String errMsg = baseTokenErrorHandleResponse.getErrMsg();
        r x11 = r.x();
        x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", false);
        EventBus.d().k(new a(errCode, errMsg));
        EventBus.d().k(new p6.a(errCode, errMsg));
        i("tokenFailed--clear userInfo and go login");
        if (!TextUtils.isEmpty(errMsg)) {
            HuobiToastUtil.l(j.c(), errMsg);
        }
        try {
            GrowingIOStatics.j(request.toString(), request.headers().toString(), response.toString());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public abstract BaseTokenErrorHandleResponse n(Response response, int i11) throws IOException;
}
