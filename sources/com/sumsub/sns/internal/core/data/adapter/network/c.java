package com.sumsub.sns.internal.core.data.adapter.network;

import com.sumsub.log.logger.Logger;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.common.x0;
import com.sumsub.sns.internal.log.LoggerType;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public final class c<S, E> implements Call<S> {

    /* renamed from: a  reason: collision with root package name */
    public final Call<S> f32333a;

    /* renamed from: b  reason: collision with root package name */
    public final Converter<ResponseBody, E> f32334b;

    /* renamed from: c  reason: collision with root package name */
    public final x0 f32335c;

    public static final class a implements Callback<S> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callback<S> f32336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c<S, E> f32337b;

        public a(Callback<S> callback, c<S, E> cVar) {
            this.f32336a = callback;
            this.f32337b = cVar;
        }

        public void onFailure(Call<S> call, Throwable th2) {
            Throwable th3;
            Logger c11 = com.sumsub.sns.internal.log.a.f34862a.c(CollectionsKt__CollectionsJVMKt.e(LoggerType.LOG_CAT));
            com.sumsub.log.logger.a.d(c11, "ApiResponseCall", "failure on " + call.request().url(), (Throwable) null, 4, (Object) null);
            if (th2 instanceof IOException) {
                th3 = new SNSException.Network(th2);
            } else {
                th3 = new SNSException.Unknown(th2);
            }
            this.f32336a.onFailure(this.f32337b, th3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: com.sumsub.sns.core.data.model.SNSException$Unknown} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: com.sumsub.sns.core.data.model.SNSException$Api} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.sumsub.sns.core.data.model.SNSException$Api} */
        /* JADX WARNING: type inference failed for: r10v5, types: [java.lang.Throwable] */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
            if (r11 == null) goto L_0x00ad;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(retrofit2.Call<S> r10, retrofit2.Response<S> r11) {
            /*
                r9 = this;
                java.lang.Object r0 = r11.body()
                okhttp3.ResponseBody r1 = r11.errorBody()
                boolean r2 = r11.isSuccessful()
                if (r2 == 0) goto L_0x001f
                retrofit2.Callback<S> r10 = r9.f32336a
                com.sumsub.sns.internal.core.data.adapter.network.c<S, E> r1 = r9.f32337b
                okhttp3.Headers r11 = r11.headers()
                retrofit2.Response r11 = retrofit2.Response.success(r0, (okhttp3.Headers) r11)
                r10.onResponse(r1, r11)
                goto L_0x00f3
            L_0x001f:
                r11 = 0
                if (r1 != 0) goto L_0x0023
                goto L_0x0039
            L_0x0023:
                long r2 = r1.contentLength()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x002e
                goto L_0x0039
            L_0x002e:
                com.sumsub.sns.internal.core.data.adapter.network.c<S, E> r0 = r9.f32337b     // Catch:{ Exception -> 0x0039 }
                retrofit2.Converter r0 = r0.f32334b     // Catch:{ Exception -> 0x0039 }
                java.lang.Object r0 = r0.convert(r1)     // Catch:{ Exception -> 0x0039 }
                goto L_0x003a
            L_0x0039:
                r0 = r11
            L_0x003a:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = " url="
                r1.append(r2)
                okhttp3.Request r10 = r10.request()
                if (r10 == 0) goto L_0x004f
                okhttp3.HttpUrl r10 = r10.url()
                goto L_0x0050
            L_0x004f:
                r10 = r11
            L_0x0050:
                r1.append(r10)
                java.lang.String r10 = r1.toString()
                java.lang.String r1 = "resources/serviceLogger/"
                r2 = 0
                r3 = 2
                boolean r1 = kotlin.text.StringsKt__StringsKt.R(r10, r1, r2, r3, r11)
                if (r1 != 0) goto L_0x008f
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                com.sumsub.sns.internal.log.LoggerType[] r3 = new com.sumsub.sns.internal.log.LoggerType[r3]
                com.sumsub.sns.internal.log.LoggerType r4 = com.sumsub.sns.internal.log.LoggerType.SDK_CLIENT
                r3[r2] = r4
                com.sumsub.sns.internal.log.LoggerType r2 = com.sumsub.sns.internal.log.LoggerType.KIBANA
                r4 = 1
                r3[r4] = r2
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.n(r3)
                com.sumsub.log.logger.Logger r3 = r1.c(r2)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "failure on "
                r1.append(r2)
                r1.append(r10)
                java.lang.String r5 = r1.toString()
                r6 = 0
                r7 = 4
                r8 = 0
                java.lang.String r4 = "ApiResponseCall"
                com.sumsub.log.logger.a.d(r3, r4, r5, r6, r7, r8)
            L_0x008f:
                boolean r10 = r0 instanceof com.sumsub.sns.internal.core.data.model.remote.response.b
                if (r10 == 0) goto L_0x00e2
                com.sumsub.sns.internal.core.data.model.remote.response.b r0 = (com.sumsub.sns.internal.core.data.model.remote.response.b) r0
                java.lang.String r10 = r0.n()
                if (r10 == 0) goto L_0x00ad
                com.sumsub.sns.internal.core.data.adapter.network.c<S, E> r1 = r9.f32337b
                com.sumsub.sns.internal.core.common.x0 r1 = r1.f32335c
                java.lang.CharSequence r10 = r1.a(r10)
                if (r10 == 0) goto L_0x00ab
                java.lang.String r11 = r10.toString()
            L_0x00ab:
                if (r11 != 0) goto L_0x00ca
            L_0x00ad:
                com.sumsub.sns.internal.core.data.adapter.network.c<S, E> r10 = r9.f32337b
                com.sumsub.sns.internal.core.common.x0 r10 = r10.f32335c
                java.lang.Integer r11 = r0.l()
                java.lang.String r11 = java.lang.String.valueOf(r11)
                java.lang.CharSequence r10 = r10.a(r11)
                if (r10 == 0) goto L_0x00c6
                java.lang.String r11 = r10.toString()
                goto L_0x00ca
            L_0x00c6:
                java.lang.String r11 = r0.j()
            L_0x00ca:
                r2 = r11
                com.sumsub.sns.core.data.model.SNSException$Api r10 = new com.sumsub.sns.core.data.model.SNSException$Api
                java.lang.Integer r3 = r0.f()
                java.lang.String r4 = r0.h()
                java.lang.Integer r5 = r0.l()
                java.lang.String r6 = r0.n()
                r1 = r10
                r1.<init>(r2, r3, r4, r5, r6)
                goto L_0x00ec
            L_0x00e2:
                com.sumsub.sns.core.data.model.SNSException$Unknown r10 = new com.sumsub.sns.core.data.model.SNSException$Unknown
                java.lang.Exception r11 = new java.lang.Exception
                r11.<init>()
                r10.<init>(r11)
            L_0x00ec:
                retrofit2.Callback<S> r11 = r9.f32336a
                com.sumsub.sns.internal.core.data.adapter.network.c<S, E> r0 = r9.f32337b
                r11.onFailure(r0, r10)
            L_0x00f3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.adapter.network.c.a.onResponse(retrofit2.Call, retrofit2.Response):void");
        }
    }

    public c(Call<S> call, Converter<ResponseBody, E> converter, x0 x0Var) {
        this.f32333a = call;
        this.f32334b = converter;
        this.f32335c = x0Var;
    }

    public void cancel() {
        this.f32333a.cancel();
    }

    public void enqueue(Callback<S> callback) {
        this.f32333a.enqueue(new a(callback, this));
    }

    public Response<S> execute() {
        throw new UnsupportedOperationException("ApiResponseCall doesn't support execute");
    }

    public boolean isCanceled() {
        return this.f32333a.isCanceled();
    }

    public boolean isExecuted() {
        return this.f32333a.isExecuted();
    }

    public Request request() {
        return this.f32333a.request();
    }

    public Timeout timeout() {
        return this.f32333a.timeout();
    }

    /* renamed from: a */
    public c<S, E> clone() {
        return new c<>(this.f32333a.clone(), this.f32334b, this.f32335c);
    }
}
