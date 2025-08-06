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

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68992a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f68993b = new ArrayList();

    public static Observable<List<String>> d(boolean z11) {
        String e11 = e();
        if (z11 && g()) {
            return Observable.just(f());
        }
        List arrayList = new ArrayList();
        if (!g()) {
            h(e11);
            if (g()) {
                arrayList = f();
            }
        }
        Observable<List<String>> doOnNext = b.a().getOtcOptionsSymbol().b().onErrorReturn(j0.f53514b).doOnNext(new i0(e11));
        if (arrayList.isEmpty()) {
            return doOnNext;
        }
        Observable<List<String>> just = Observable.just(arrayList);
        b.a().getOtcOptionsSymbol().b().doOnNext(new h0(e11)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
        return just;
    }

    public static String e() {
        return b1.a().b().b();
    }

    public static List<String> f() {
        ArrayList arrayList;
        synchronized (f68992a) {
            arrayList = new ArrayList(f68993b);
        }
        return arrayList;
    }

    public static boolean g() {
        return !f68993b.isEmpty();
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "default_key";
        }
        String d11 = ConfigPreferences.d("user_config", "config_app_otc_options_symbol" + str);
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
                RetrofitLogger.c("OtcOptionsSymbolConfigUtil-->readFromFile", e11);
            }
        }
        if (!arrayList.isEmpty()) {
            l(arrayList, str);
        }
    }

    public static void l(List<String> list, String str) {
        if (list != null) {
            d.b(str + "====" + list);
            synchronized (f68992a) {
                List<String> list2 = f68993b;
                list2.clear();
                list2.addAll(list);
            }
            if (TextUtils.isEmpty(str)) {
                str = "default_key";
            }
            try {
                ConfigPreferences.m("user_config", "config_app_otc_options_symbol" + str, new Gson().toJson((Object) list));
            } catch (Exception unused) {
                k.c("OtcOptionsSymbolConfigUtil save error");
            }
        }
    }
}
