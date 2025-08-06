package d7;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import i6.d;
import i6.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import v7.b;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68988a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f68989b = new ArrayList();

    public static List<String> d() {
        ArrayList arrayList;
        synchronized (f68988a) {
            arrayList = new ArrayList(f68989b);
        }
        return arrayList;
    }

    public static Observable<List<String>> e(boolean z11) {
        String f11 = f();
        if (z11 && g()) {
            return Observable.just(d());
        }
        List arrayList = new ArrayList();
        if (!g()) {
            h(f11);
            if (g()) {
                arrayList = d();
            }
        }
        Observable<List<String>> doOnNext = b.a().getOtcOptionsOrderCurrency().b().onErrorReturn(f0.f53503b).doOnNext(new d0(f11));
        if (arrayList.isEmpty()) {
            return doOnNext;
        }
        Observable<List<String>> just = Observable.just(arrayList);
        b.a().getOtcOptionsOrderCurrency().b().doOnNext(new e0(f11)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
        return just;
    }

    public static String f() {
        return b1.a().b().b();
    }

    public static boolean g() {
        return !f68989b.isEmpty();
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "default_key_order";
        }
        String d11 = ConfigPreferences.d("user_config", "config_app_otc_options_currency_order" + str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(d11)) {
            try {
                Iterator<JsonElement> it2 = new JsonParser().parse(d11).getAsJsonArray().iterator();
                Gson gson = new Gson();
                while (it2.hasNext()) {
                    arrayList.add((String) gson.fromJson(it2.next(), String.class));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("OtcOptionsCurrencyConfigUtil-->readFromFile", e11);
            }
        }
        if (!arrayList.isEmpty()) {
            l(arrayList, str);
        }
    }

    public static void l(List<String> list, String str) {
        if (list != null) {
            d.b(str + "====" + list);
            synchronized (f68988a) {
                List<String> list2 = f68989b;
                list2.clear();
                list2.addAll(list);
            }
            if (TextUtils.isEmpty(str)) {
                str = "default_key_order";
            }
            try {
                ConfigPreferences.m("user_config", "config_app_otc_options_currency_order" + str, new Gson().toJson((Object) list));
            } catch (Exception unused) {
                k.c("OtcOptionsSymbolConfigUtil save error");
            }
        }
    }
}
