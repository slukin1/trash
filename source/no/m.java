package no;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;

public final class m implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final m f84498b = new m();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84499a;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends EasySubscriber<ProUserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84502b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean[] f84503c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84504d;

        public c(Response response, boolean[] zArr, CountDownLatch countDownLatch) {
            this.f84502b = response;
            this.f84503c = zArr;
            this.f84504d = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(ProUserToken proUserToken) {
            super.onNext(proUserToken);
            if (proUserToken != null) {
                r.x().v0(proUserToken.getToken());
                k.o("LOGIN", "PRO-TOKEN login onNext " + proUserToken.getToken() + m.e(this.f84502b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "PRO-TOKEN login onAfter " + m.e(this.f84502b));
            this.f84504d.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "PRO-TOKEN login onError2 " + m.e(this.f84502b));
            k.j("LOGIN", th2);
            if (th2 instanceof SSLException) {
                this.f84503c[0] = true;
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "PRO-TOKEN login onFailed " + m.e(this.f84502b));
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "PRO-TOKEN login onStart " + m.e(this.f84502b));
        }
    }

    public class d extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84505b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84506c;

        public d(Response response, CountDownLatch countDownLatch) {
            this.f84505b = response;
            this.f84506c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            if (!TextUtils.isEmpty(str)) {
                r.x().r0(str);
                k.o("LOGIN", "PRO-NEW-KYC-TOKEN login onNext " + str + m.e(this.f84505b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "PRO-NEW-KYC-TOKEN login onAfter " + m.e(this.f84505b));
            this.f84506c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "PRO-NEW-KYC-TOKEN login onError2 " + m.e(this.f84505b));
            th2.printStackTrace();
            k.j("LOGIN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "PRO-NEW-KYC-TOKEN login onFailed " + m.e(this.f84505b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "PRO-NEW-KYC-TOKEN login onStart " + m.e(this.f84505b));
        }
    }

    public m() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84499a = gsonBuilder.create();
    }

    public static String d(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String e(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static m f() {
        return f84498b;
    }

    public static synchronized Response k(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (m.class) {
            String header = response.request().header("HB-KYC-TOKEN");
            String C = r.x().C();
            if (TextUtils.isEmpty(C) || C.equals(header)) {
                r.x().r0((String) null);
                k.o("LOGIN", "PRO-NEW-KYC-TOKEN get-token" + e(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                UserCenterRemoteDataSource.A().Q("KYC need-ticket" + e(response)).compose(p.c0()).flatMap(k.f58696b).subscribeOn(Schedulers.io()).subscribe(new d(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().C())) {
                    k.o("LOGIN", "PRO-NEW-KYC-TOKEN get token after retry " + e(response));
                    Response m11 = m(chain, response, r.x().C());
                    return m11;
                }
                k.o("LOGIN", "PRO-NEW-KYC-TOKEN other " + e(response));
                return response;
            }
            k.o("LOGIN", "PRO-NEW-KYC-TOKEN retry request" + e(response));
            Response m12 = m(chain, response, C);
            return m12;
        }
    }

    public static synchronized Response l(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (m.class) {
            String header = response.request().header("HB-PRO-TOKEN");
            boolean[] zArr = {false};
            if (TextUtils.isEmpty(r.x().H()) || r.x().H().equals(header)) {
                r.x().v0((String) null);
                k.o("LOGIN", "PRO-TOKEN get-token" + e(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    UserCenterRemoteDataSource.A().Q("PRO need-ticket" + e(response)).compose(p.c0()).flatMap(l.f58697b).subscribeOn(Schedulers.io()).subscribe(new c(response, zArr, countDownLatch));
                } catch (Exception unused) {
                }
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().H())) {
                    k.o("LOGIN", "PRO-TOKEN get token after retry " + e(response));
                    Response n11 = n(chain, response, r.x().H());
                    return n11;
                }
                k.o("LOGIN", "PRO-TOKEN other " + e(response));
                if (!zArr[0]) {
                    return response;
                }
                k.f("LOGIN", "SSLException occurs, set response empty." + e(response));
                k.f("LOGIN", "SSLException occurs, set response empty. 原逻辑会上传到FireBase 现在添加到日志");
                Response build = response.newBuilder().body((ResponseBody) null).build();
                return build;
            }
            k.o("LOGIN", "PRO-TOKEN retry" + e(response));
            Response n12 = n(chain, response, r.x().H());
            return n12;
        }
    }

    public static Response m(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("HB-KYC-TOKEN", str).build();
        k.o("LOGIN", "PRO-NEW-KYC-TOKEN retryRequest " + d(build));
        k.o("LOGIN", "PRO-NEW-KYC-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public static Response n(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("HB-PRO-TOKEN", str).build();
        k.o("LOGIN", "PRO-TOKEN retryRequest " + d(build));
        k.o("LOGIN", "PRO-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public final boolean g(Map map) {
        if (map.get("code") == null) {
            return false;
        }
        String obj = map.get("code").toString();
        obj.hashCode();
        return obj.equals("7000021");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ed, code lost:
        if (r0.equals("10001") == false) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(java.util.Map r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "status"
            java.lang.Object r2 = r0.get(r1)
            r3 = 1
            if (r2 == 0) goto L_0x002c
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = i6.m.a0(r1)
            if (r2 == 0) goto L_0x002c
            int r1 = i6.m.k0(r1)
            r2 = -9
            if (r1 == r2) goto L_0x002b
            r2 = -7
            if (r1 == r2) goto L_0x002b
            r2 = 10001(0x2711, float:1.4014E-41)
            if (r1 == r2) goto L_0x002b
            r2 = 10017(0x2721, float:1.4037E-41)
            if (r1 == r2) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            return r3
        L_0x002c:
            r1 = 0
            java.lang.String r2 = "err-code"
            java.lang.Object r4 = r0.get(r2)
            if (r4 == 0) goto L_0x003c
            java.lang.Object r1 = r0.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x004a
        L_0x003c:
            java.lang.String r2 = "err_code"
            java.lang.Object r4 = r0.get(r2)
            if (r4 == 0) goto L_0x004a
            java.lang.Object r1 = r0.get(r2)
            java.lang.String r1 = (java.lang.String) r1
        L_0x004a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r4 = 6
            java.lang.String r5 = "token-not-valid"
            r6 = 5
            java.lang.String r7 = "token-not-exist"
            r8 = 4
            java.lang.String r9 = "10001"
            r10 = 3
            java.lang.String r11 = "555"
            r12 = 2
            java.lang.String r13 = "login-required"
            java.lang.String r14 = "uc-invalid-identity"
            java.lang.String r15 = "login-failed"
            r16 = -1
            r17 = 0
            if (r2 != 0) goto L_0x00b8
            r1.hashCode()
            int r2 = r1.hashCode()
            switch(r2) {
                case -1970694367: goto L_0x00aa;
                case -1820299981: goto L_0x00a1;
                case -825293437: goto L_0x0098;
                case 52629: goto L_0x008f;
                case 46730162: goto L_0x0086;
                case 1452062889: goto L_0x007d;
                case 1467080110: goto L_0x0074;
                default: goto L_0x0071;
            }
        L_0x0071:
            r1 = r16
            goto L_0x00b3
        L_0x0074:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x007b
            goto L_0x0071
        L_0x007b:
            r1 = r4
            goto L_0x00b3
        L_0x007d:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0084
            goto L_0x0071
        L_0x0084:
            r1 = r6
            goto L_0x00b3
        L_0x0086:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x008d
            goto L_0x0071
        L_0x008d:
            r1 = r8
            goto L_0x00b3
        L_0x008f:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0096
            goto L_0x0071
        L_0x0096:
            r1 = r10
            goto L_0x00b3
        L_0x0098:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x009f
            goto L_0x0071
        L_0x009f:
            r1 = r12
            goto L_0x00b3
        L_0x00a1:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00a8
            goto L_0x0071
        L_0x00a8:
            r1 = r3
            goto L_0x00b3
        L_0x00aa:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x00b1
            goto L_0x0071
        L_0x00b1:
            r1 = r17
        L_0x00b3:
            switch(r1) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00b7;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            goto L_0x00b8
        L_0x00b7:
            return r3
        L_0x00b8:
            java.lang.String r1 = "code"
            java.lang.Object r2 = r0.get(r1)
            if (r2 == 0) goto L_0x0139
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = r0.toString()
            r0.hashCode()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1970694367: goto L_0x0121;
                case -1820299981: goto L_0x0118;
                case -825293437: goto L_0x010f;
                case 52629: goto L_0x0106;
                case 1507425: goto L_0x00fb;
                case 1507426: goto L_0x00f0;
                case 46730162: goto L_0x00e9;
                case 1452062889: goto L_0x00e0;
                case 1467080110: goto L_0x00d6;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            r4 = r16
            goto L_0x012a
        L_0x00d6:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x00dd
            goto L_0x00d2
        L_0x00dd:
            r4 = 8
            goto L_0x012a
        L_0x00e0:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x00e7
            goto L_0x00d2
        L_0x00e7:
            r4 = 7
            goto L_0x012a
        L_0x00e9:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x012a
            goto L_0x00d2
        L_0x00f0:
            java.lang.String r1 = "1003"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f9
            goto L_0x00d2
        L_0x00f9:
            r4 = r6
            goto L_0x012a
        L_0x00fb:
            java.lang.String r1 = "1002"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0104
            goto L_0x00d2
        L_0x0104:
            r4 = r8
            goto L_0x012a
        L_0x0106:
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x010d
            goto L_0x00d2
        L_0x010d:
            r4 = r10
            goto L_0x012a
        L_0x010f:
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x0116
            goto L_0x00d2
        L_0x0116:
            r4 = r12
            goto L_0x012a
        L_0x0118:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x011f
            goto L_0x00d2
        L_0x011f:
            r4 = r3
            goto L_0x012a
        L_0x0121:
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0128
            goto L_0x00d2
        L_0x0128:
            r4 = r17
        L_0x012a:
            switch(r4) {
                case 0: goto L_0x0138;
                case 1: goto L_0x0138;
                case 2: goto L_0x0138;
                case 3: goto L_0x0138;
                case 4: goto L_0x012e;
                case 5: goto L_0x0138;
                case 6: goto L_0x0138;
                case 7: goto L_0x0138;
                case 8: goto L_0x0138;
                default: goto L_0x012d;
            }
        L_0x012d:
            goto L_0x0139
        L_0x012e:
            tg.r r0 = tg.r.x()
            boolean r0 = r0.X()
            r0 = r0 ^ r3
            return r0
        L_0x0138:
            return r3
        L_0x0139:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: no.m.h(java.util.Map):boolean");
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84499a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (g(map)) {
                k.f("LOGIN", "PRO-NEW-KYC-TOKEN mapTokenError-1" + e(proceed));
                Response k11 = k(chain, proceed);
                k.f("LOGIN", "PRO-NEW-KYC-TOKEN mapTokenError-2" + e(proceed));
                return k11;
            } else if (h(map)) {
                k.f("LOGIN", "PRO-TOKEN mapTokenError-1" + e(proceed));
                Response l11 = l(chain, proceed);
                k.f("LOGIN", "PRO-TOKEN mapTokenError-2" + e(proceed));
                return l11;
            } else {
                k.f("LOGIN", "PRO-TOKEN no token error code" + e(proceed));
                return proceed;
            }
        } catch (Exception e11) {
            k.g("LOGIN", "PRO-TOKEN Exception", e11);
            e11.printStackTrace();
            k.f("LOGIN", "PRO-TOKEN token zzzzz " + e(proceed));
            return proceed;
        }
    }
}
