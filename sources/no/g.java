package no;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.kyc.bean.PhpLogin;
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

public final class g implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final g f84480b = new g();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84481a;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends EasySubscriber<PhpLogin> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84485c;

        public c(Response response, CountDownLatch countDownLatch) {
            this.f84484b = response;
            this.f84485c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(PhpLogin phpLogin) {
            super.onNext(phpLogin);
            if (phpLogin.getToken() != null) {
                r.x().u0(phpLogin.getToken());
                k.o("LOGIN", "MGT-TOKEN login onNext " + phpLogin.getToken() + g.d(this.f84484b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "MGT-TOKEN login onAfter " + g.d(this.f84484b));
            this.f84485c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "MGT-TOKEN login onError2 " + g.d(this.f84484b));
            th2.printStackTrace();
            k.j("LOGIN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "MGT-TOKEN login onFailed " + g.d(this.f84484b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "MGT-TOKEN login onStart " + g.d(this.f84484b));
        }
    }

    public g() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84481a = gsonBuilder.create();
    }

    public static String c(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String d(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static g e() {
        return f84480b;
    }

    public static synchronized Response h(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (g.class) {
            String header = response.request().header("HB-OLD-TOKEN");
            if (TextUtils.isEmpty(r.x().G()) || r.x().G().equals(header)) {
                r.x().u0((String) null);
                k.o("LOGIN", "MGT-TOKEN get-token" + d(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                UserCenterRemoteDataSource.A().Q("MGT need-ticket" + d(response)).compose(p.c0()).flatMap(f.f58694b).subscribeOn(Schedulers.io()).subscribe(new c(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().G())) {
                    k.o("LOGIN", "MGT-TOKEN get token after retry " + d(response));
                    Response i11 = i(chain, response, r.x().G());
                    return i11;
                }
                k.o("LOGIN", "MGT-TOKEN other " + d(response));
                return response;
            }
            k.o("LOGIN", "MGT-TOKEN retry request" + d(response));
            Response i12 = i(chain, response, r.x().G());
            return i12;
        }
    }

    public static Response i(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("HB-OLD-TOKEN", str).build();
        k.o("LOGIN", "MGT-TOKEN retryRequest " + c(build));
        k.o("LOGIN", "MGT-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public final boolean f(Map map) {
        return map.get("err-code") != null && "555".equals(map.get("err-code").toString());
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84481a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (f(map)) {
                k.f("LOGIN", "MGT-TOKEN mapTokenError-1" + d(proceed));
                Response h11 = h(chain, proceed);
                k.f("LOGIN", "MGT-TOKEN mapTokenError-2" + d(proceed));
                return h11;
            }
            k.f("LOGIN", "MGT-TOKEN no token error code" + d(proceed));
            return proceed;
        } catch (Exception e11) {
            k.g("LOGIN", "MGT-TOKEN Exception", e11);
            e11.printStackTrace();
            k.f("LOGIN", "MGT-TOKEN zzzzz " + d(proceed));
            return proceed;
        }
    }
}
