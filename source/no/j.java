package no;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.otc.helper.OtcLoginHelper;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import rx.schedulers.Schedulers;
import tg.r;

public final class j implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final j f84492b = new j();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84493a;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends EasySubscriber<String[]> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84496b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84497c;

        public c(Response response, CountDownLatch countDownLatch) {
            this.f84496b = response;
            this.f84497c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(String[] strArr) {
            super.onNext(strArr);
            if (strArr[0] != null) {
                r.x().t0(strArr[0]);
                k.o("LOGIN", "OTC-TOKEN login onNext " + strArr[0] + j.c(this.f84496b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "OTC-TOKEN login onAfter " + j.c(this.f84496b));
            this.f84497c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "OTC-TOKEN login onError2 " + j.c(this.f84496b));
            th2.printStackTrace();
            k.j("LOGIN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "OTC-TOKEN login onFailed " + j.c(this.f84496b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "OTC-TOKEN login onStart " + j.c(this.f84496b));
        }
    }

    public j() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84493a = gsonBuilder.create();
    }

    public static String b(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String c(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static j d() {
        return f84492b;
    }

    public static synchronized Response e(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (j.class) {
            String header = response.request().header("token");
            if (TextUtils.isEmpty(r.x().E()) || r.x().E().equals(header)) {
                r.x().t0((String) null);
                k.o("LOGIN", "OTC-TOKEN get-token" + c(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                OtcLoginHelper.f("OTC need-ticket" + c(response)).retry(3).subscribeOn(Schedulers.io()).subscribe(new c(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().E())) {
                    k.o("LOGIN", "OTC-TOKEN get token after retry " + c(response));
                    Response f11 = f(chain, response, r.x().E());
                    return f11;
                }
                k.o("LOGIN", "OTC-TOKEN other " + c(response));
                return response;
            }
            k.o("LOGIN", "OTC-TOKEN retry request" + c(response));
            Response f12 = f(chain, response, r.x().E());
            return f12;
        }
    }

    public static Response f(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("token", str).build();
        k.o("LOGIN", "OTC-TOKEN retryRequest " + b(build));
        k.o("LOGIN", "OTC-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84493a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            long j11 = 0;
            if (map != null) {
                map.remove("data");
                if (map.containsKey("code")) {
                    j11 = ((Long) map.get("code")).longValue();
                }
                k.f("LOGIN", "OTC-TOKEN code - " + j11 + c(proceed));
                if (j11 == 200) {
                    return proceed;
                }
            }
            if (j11 != 401) {
                k.f("LOGIN", "OTC-TOKEN mapTokenError-3" + c(proceed));
                return proceed;
            } else if (r.x().F0()) {
                k.f("LOGIN", "OTC-TOKEN mapTokenError-1" + c(proceed));
                Response e11 = e(chain, proceed);
                k.f("LOGIN", "OTC-TOKEN mapTokenError-2" + c(proceed));
                return e11;
            } else {
                EventBus.d().k(new mo.a(String.valueOf(j11), ""));
                EventBus.d().k(new p6.a(String.valueOf(j11), ""));
                return proceed;
            }
        } catch (Exception e12) {
            k.g("LOGIN", "OTC-TOKEN token Exception", e12);
            e12.printStackTrace();
            k.f("LOGIN", "OTC-TOKEN token zzzzz " + c(proceed));
            return proceed;
        }
    }
}
