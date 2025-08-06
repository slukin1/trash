package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i11, Exchange exchange2, Request request2, int i12, int i13, int i14) {
        this.call = realCall;
        this.interceptors = list;
        this.index = i11;
        this.exchange = exchange2;
        this.request = request2;
        this.connectTimeoutMillis = i12;
        this.readTimeoutMillis = i13;
        this.writeTimeoutMillis = i14;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i11, Exchange exchange2, Request request2, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = realInterceptorChain.index;
        }
        if ((i15 & 2) != 0) {
            exchange2 = realInterceptorChain.exchange;
        }
        Exchange exchange3 = exchange2;
        if ((i15 & 4) != 0) {
            request2 = realInterceptorChain.request;
        }
        Request request3 = request2;
        if ((i15 & 8) != 0) {
            i12 = realInterceptorChain.connectTimeoutMillis;
        }
        int i16 = i12;
        if ((i15 & 16) != 0) {
            i13 = realInterceptorChain.readTimeoutMillis;
        }
        int i17 = i13;
        if ((i15 & 32) != 0) {
            i14 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i11, exchange3, request3, i16, i17, i14);
    }

    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i11, Exchange exchange2, Request request2, int i12, int i13, int i14) {
        return new RealInterceptorChain(this.call, this.interceptors, i11, exchange2, request2, i12, i13, i14);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    public Response proceed(Request request2) throws IOException {
        boolean z11 = false;
        if (this.index < this.interceptors.size()) {
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                if (exchange2.getFinder$okhttp().sameHostAndPort(request2.url())) {
                    if (!(this.calls == 1)) {
                        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, (Exchange) null, request2, 0, 0, 0, 58, (Object) null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (!(this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1)) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z11 = true;
                }
                if (z11) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public Request request() {
        return this.request;
    }

    public Interceptor.Chain withConnectTimeout(int i11, TimeUnit timeUnit) {
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, Util.checkDuration("connectTimeout", (long) i11, timeUnit), 0, 0, 55, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withReadTimeout(int i11, TimeUnit timeUnit) {
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, Util.checkDuration("readTimeout", (long) i11, timeUnit), 0, 47, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withWriteTimeout(int i11, TimeUnit timeUnit) {
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, 0, Util.checkDuration("writeTimeout", (long) i11, timeUnit), 31, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
