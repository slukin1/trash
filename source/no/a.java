package no;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.helper.ContractDataSource;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import dn.d;
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

public final class a implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final a f84462b = new a();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84463a;

    /* renamed from: no.a$a  reason: collision with other inner class name */
    public class C0877a extends TypeToken<Map<String, Object>> {
        public C0877a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends EasySubscriber<String[]> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Response f84466b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f84467c;

        public c(Response response, CountDownLatch countDownLatch) {
            this.f84466b = response;
            this.f84467c = countDownLatch;
        }

        /* renamed from: a */
        public void onNext(String[] strArr) {
            super.onNext(strArr);
            if (strArr[0] != null) {
                r.x().k0(strArr[0]);
                d.f().d();
                d.f().n();
                k.o("LOGIN", "DM-TOKEN onNext " + strArr[0] + a.c(this.f84466b));
            }
        }

        public void onAfter() {
            super.onAfter();
            k.o("LOGIN", "DM-TOKEN onAfter " + a.c(this.f84466b));
            this.f84467c.countDown();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.o("LOGIN", "DM-TOKEN onError2 " + a.c(this.f84466b));
            th2.printStackTrace();
            k.j("DM-TOKEN", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.o("LOGIN", "DM-TOKEN onFailed " + a.c(this.f84466b));
            aPIStatusErrorException.printStackTrace();
            k.j("LOGIN", aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            k.o("LOGIN", "DM-TOKEN login onStart " + a.c(this.f84466b));
        }
    }

    public a() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new C0877a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84463a = gsonBuilder.create();
    }

    public static String b(Request request) {
        return " t - [" + Thread.currentThread().getName() + "] from - " + request.url() + "] isLogin [" + r.x().F0() + "]";
    }

    public static String c(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static a d() {
        return f84462b;
    }

    public static synchronized Response e(Interceptor.Chain chain, Response response) throws InterruptedException, IOException {
        synchronized (a.class) {
            String header = response.request().header("hbsession");
            if (TextUtils.isEmpty(r.x().q()) || r.x().q().equals(header)) {
                r.x().k0((String) null);
                k.o("LOGIN", "DM-TOKEN get-token" + c(response));
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ContractDataSource.f("DM need-ticket" + c(response)).retry(3).subscribeOn(Schedulers.io()).subscribe(new c(response, countDownLatch));
                countDownLatch.await(15, TimeUnit.SECONDS);
                if (!TextUtils.isEmpty(r.x().q())) {
                    k.o("LOGIN", "DM-TOKEN get token after retry " + c(response));
                    Response f11 = f(chain, response, r.x().q());
                    return f11;
                }
                k.o("LOGIN", "DM-TOKEN other " + c(response));
                return response;
            }
            k.o("LOGIN", "DM-TOKEN retry" + c(response));
            Response f12 = f(chain, response, r.x().q());
            return f12;
        }
    }

    public static Response f(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request build = chain.request().newBuilder().header("hbsession", str).build();
        k.o("LOGIN", "DM-TOKEN retryRequest " + b(build));
        k.o("LOGIN", "DM-TOKEN retryRequest headers = " + build.headers());
        if (response.body() != null) {
            response.body().close();
        }
        return chain.proceed(build);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84463a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (map.get("err_code") == null) {
                return proceed;
            }
            long longValue = ((Long) map.get("err_code")).longValue();
            k.f("LOGIN", "DM-TOKEN errCode - " + longValue + c(proceed));
            if (longValue != 1029) {
                if (longValue != 1011) {
                    return proceed;
                }
            }
            k.f("LOGIN", "DM-TOKEN mapTokenError-1" + c(proceed));
            Response e11 = e(chain, proceed);
            k.f("LOGIN", "DM-TOKEN mapTokenError-2" + c(proceed));
            return e11;
        } catch (Exception e12) {
            k.g("LOGIN", "DM-TOKEN Exception", e12);
            e12.printStackTrace();
            k.f("LOGIN", "DM-TOKEN zzzzz " + c(proceed));
            return proceed;
        }
    }
}
