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

public final class e implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final e f84474b = new e();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84475a;

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
        public final /* synthetic */ Response f84478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84479c;

        public c(Response response, CountDownLatch countDownLatch) {
            this.f84478b = response;
            this.f84479c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            if (!TextUtils.isEmpty(str)) {
                r.x().q0(str);
                k.o("LOGIN", "MGT-CONTENT-TOKEN login onNext " + str + e.d(this.f84478b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "MGT-CONTENT-TOKEN login onAfter " + e.d(this.f84478b));
            this.f84479c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "MGT-CONTENT-TOKEN login onError2 " + e.d(this.f84478b));
            th2.printStackTrace();
            k.j("LOGIN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "MGT-CONTENT-TOKEN login onFailed " + e.d(this.f84478b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "MGT-CONTENT-TOKEN login onStart " + e.d(this.f84478b));
        }
    }

    public e() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84475a = gsonBuilder.create();
    }

    public static String c(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String d(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static e e() {
        return f84474b;
    }

    public static synchronized Response h(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (e.class) {
            String header = response.request().header("HB-MP-TOKEN");
            if (TextUtils.isEmpty(r.x().B()) || r.x().B().equals(header)) {
                r.x().q0((String) null);
                k.o("LOGIN", "MGT-CONTENT-TOKEN get-token" + d(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                UserCenterRemoteDataSource.A().Q("MGT need-ticket" + d(response)).compose(p.c0()).flatMap(d.f58693b).subscribeOn(Schedulers.io()).subscribe(new c(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().B())) {
                    k.o("LOGIN", "MGT-CONTENT-TOKEN get token after retry " + d(response));
                    Response i11 = i(chain, response, r.x().B());
                    return i11;
                }
                k.o("LOGIN", "MGT-CONTENT-TOKEN other " + d(response));
                return response;
            }
            k.o("LOGIN", "MGT-CONTENT-TOKEN retry request" + d(response));
            Response i12 = i(chain, response, r.x().B());
            return i12;
        }
    }

    public static Response i(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("HB-MP-TOKEN", str).build();
        k.o("LOGIN", "MGT-CONTENT-TOKEN retryRequest " + c(build));
        k.o("LOGIN", "MGT-CONTENT-TOKEN retryRequest headers = " + build.headers());
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
            Map map = (Map) this.f84475a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (f(map)) {
                k.f("LOGIN", "MGT-CONTENT-TOKEN mapTokenError-1" + d(proceed));
                Response h11 = h(chain, proceed);
                k.f("LOGIN", "MGT-CONTENT-TOKEN mapTokenError-2" + d(proceed));
                return h11;
            }
            k.f("LOGIN", "MGT-CONTENT-TOKEN no token error code" + d(proceed));
            return proceed;
        } catch (Exception e11) {
            k.g("LOGIN", "MGT-CONTENT-TOKEN Exception", e11);
            e11.printStackTrace();
            k.f("LOGIN", "MGT-CONTENT-TOKEN zzzzz " + d(proceed));
            return proceed;
        }
    }
}
