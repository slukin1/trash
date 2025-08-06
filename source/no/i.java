package no;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;

public final class i implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final i f84486b = new i();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84487a;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84490b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84491c;

        public c(Response response, CountDownLatch countDownLatch) {
            this.f84490b = response;
            this.f84491c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            if (!TextUtils.isEmpty(str)) {
                r.x().r0(str);
                k.o("LOGIN", "NEW-KYC-TOKEN login onNext " + str + i.d(this.f84490b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "NEW-KYC-TOKEN login onAfter " + i.d(this.f84490b));
            this.f84491c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "NEW-KYC-TOKEN login onError2 " + i.d(this.f84490b));
            th2.printStackTrace();
            k.j("LOGIN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "NEW-KYC-TOKEN login onFailed " + i.d(this.f84490b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "NEW-KYC-TOKEN login onStart " + i.d(this.f84490b));
        }
    }

    public i() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84487a = gsonBuilder.create();
    }

    public static String c(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String d(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static i e() {
        return f84486b;
    }

    public static synchronized Response h(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (i.class) {
            String header = response.request().header("HB-KYC-TOKEN");
            if (TextUtils.isEmpty(r.x().C()) || r.x().C().equals(header)) {
                r.x().r0((String) null);
                k.o("LOGIN", "NEW-KYC-TOKEN get-token" + d(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                UserCenterRemoteDataSource.A().Q("KYC need-ticket" + d(response)).compose(p.c0()).flatMap(h.f58695b).subscribeOn(Schedulers.io()).subscribe(new c(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().C())) {
                    k.o("LOGIN", "NEW-KYC-TOKEN get token after retry " + d(response));
                    Response i11 = i(chain, response, r.x().C());
                    return i11;
                }
                k.o("LOGIN", "NEW-KYC-TOKEN other " + d(response));
                return response;
            }
            k.o("LOGIN", "NEW-KYC-TOKEN retry request" + d(response));
            Response i12 = i(chain, response, r.x().C());
            return i12;
        }
    }

    public static Response i(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("HB-KYC-TOKEN", str).build();
        k.o("LOGIN", "NEW-KYC-TOKEN retryRequest " + c(build));
        k.o("LOGIN", "NEW-KYC-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public final boolean f(Map map) {
        return map.get("code") != null && "200013".equals(map.get("code").toString());
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84487a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (f(map)) {
                k.f("LOGIN", "NEW-KYC-TOKEN mapTokenError-1" + d(proceed));
                Response h11 = h(chain, proceed);
                k.f("LOGIN", "NEW-KYC-TOKEN mapTokenError-2" + d(proceed));
                return h11;
            }
            k.f("LOGIN", "NEW-KYC-TOKEN no token error code" + d(proceed));
            return proceed;
        } catch (Exception e11) {
            k.g("LOGIN", "NEW-KYC-TOKEN Exception", e11);
            e11.printStackTrace();
            k.f("LOGIN", "NEW-KYC-TOKEN zzzzz " + d(proceed));
            return proceed;
        }
    }
}
