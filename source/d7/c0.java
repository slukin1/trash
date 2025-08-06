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

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68986a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f68987b = new ArrayList();

    public static boolean d(String str) {
        return f68987b.contains(str);
    }

    public static List<String> e() {
        ArrayList arrayList;
        synchronized (f68986a) {
            arrayList = new ArrayList(f68987b);
        }
        return arrayList;
    }

    public static Observable<List<String>> f(boolean z11) {
        String g11 = g();
        if (z11 && h()) {
            return Observable.just(e());
        }
        List arrayList = new ArrayList();
        if (!h()) {
            i(g11);
            if (h()) {
                arrayList = e();
            }
        }
        Observable<R> doOnNext = b.a().getOtcOptionsCurrency().b().compose(RxJavaHelper.g((RequestCallback1) null)).onErrorReturn(b0.f53493b).doOnNext(new a0(g11));
        if (arrayList.isEmpty()) {
            return doOnNext;
        }
        Observable<List<String>> just = Observable.just(arrayList);
        b.a().getOtcOptionsCurrency().b().doOnNext(new z(g11)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
        return just;
    }

    public static String g() {
        return b1.a().b().b();
    }

    public static boolean h() {
        return !f68987b.isEmpty();
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "default_key";
        }
        String d11 = ConfigPreferences.d("user_config", "config_app_otc_options_currency" + str);
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
            m(arrayList, str);
        }
    }

    public static void m(List<String> list, String str) {
        if (list != null) {
            d.b(str + "====" + list);
            synchronized (f68986a) {
                List<String> list2 = f68987b;
                list2.clear();
                list2.addAll(list);
            }
            if (TextUtils.isEmpty(str)) {
                str = "default_key";
            }
            try {
                ConfigPreferences.m("user_config", "config_app_otc_options_currency" + str, new Gson().toJson((Object) list));
            } catch (Exception unused) {
                k.c("OtcOptionsSymbolConfigUtil save error");
            }
        }
    }
}
