package com.hbg.lib.data.main;

import android.text.TextUtils;
import android.util.Log;
import c7.b;
import c7.c;
import c7.d;
import com.google.gson.Gson;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.main.bean.TimeStampMap;
import com.hbg.lib.network.pro.core.response.BigInterfaceResponse;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public abstract class BaseDataDiffTools<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68843a;

    public class a extends BaseSubscriber<List<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f68844b;

        public a(Subscriber subscriber) {
            this.f68844b = subscriber;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f68844b.onError(th2);
            this.f68844b.onCompleted();
        }

        public void onNext(List<T> list) {
            this.f68844b.onNext(list);
            this.f68844b.onCompleted();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List k(BigInterfaceResponse bigInterfaceResponse) {
        boolean z11 = true;
        if (bigInterfaceResponse.getFull() != 1) {
            z11 = false;
        }
        List n11 = z11 ? n(bigInterfaceResponse) : o(bigInterfaceResponse);
        Log.d("DataDiffTools", "getOb list.size=" + n11.size());
        return n11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable l(String str, String str2, List list) {
        if (TextUtils.isEmpty(str)) {
            return i(g().getTs(), str2).b().map(new b(this));
        }
        return Observable.just(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Subscriber subscriber) {
        String ts2 = g().getTs();
        String str = "0";
        if (TextUtils.isEmpty(ts2)) {
            ts2 = str;
        }
        if (!this.f68843a) {
            str = ts2;
        }
        this.f68843a = false;
        String curLanguageHeader = AppLanguageHelper.getInstance().getCurLanguageHeader();
        i(str, curLanguageHeader).b().map(new c(this)).flatMap(new d(this, str, curLanguageHeader)).subscribeOn(Schedulers.io()).subscribe(new a(subscriber));
    }

    public abstract String d();

    public abstract Type e();

    public final List<T> f() {
        return new ArrayList(g().getMap().values());
    }

    public final TimeStampMap<T> g() {
        TimeStampMap<T> timeStampMap = null;
        try {
            TimeStampMap<T> timeStampMap2 = (TimeStampMap) new Gson().fromJson(Repo.a(d()), e());
            if (timeStampMap2 != null) {
                timeStampMap = timeStampMap2;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return timeStampMap == null ? new TimeStampMap<>() : timeStampMap;
    }

    public abstract String h(T t11);

    public abstract d9.a<BigInterfaceResponse<List<T>>> i(String str, String str2);

    public Observable<List<T>> j() {
        return Observable.create(new c7.a(this));
    }

    public List<T> n(BigInterfaceResponse<List<T>> bigInterfaceResponse) {
        TimeStampMap timeStampMap = new TimeStampMap();
        timeStampMap.setTs(bigInterfaceResponse.getTs());
        Map map = timeStampMap.getMap();
        map.clear();
        for (Object next : bigInterfaceResponse.getData()) {
            map.put(h(next), next);
        }
        p(timeStampMap);
        return bigInterfaceResponse.getData();
    }

    public List<T> o(BigInterfaceResponse<List<T>> bigInterfaceResponse) {
        List data = bigInterfaceResponse.getData();
        if (data == null || data.size() == 0) {
            return f();
        }
        TimeStampMap g11 = g();
        g11.setTs(bigInterfaceResponse.getTs());
        Map map = g11.getMap();
        for (Object next : data) {
            map.put(h(next), next);
        }
        p(g11);
        return f();
    }

    public final synchronized void p(TimeStampMap<T> timeStampMap) {
        Repo.c(d(), new Gson().toJson((Object) timeStampMap));
    }

    public void q(boolean z11) {
        this.f68843a = z11;
    }
}
