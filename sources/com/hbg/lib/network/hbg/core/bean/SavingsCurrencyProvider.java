package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.schedulers.Schedulers;
import v7.b;

public class SavingsCurrencyProvider {
    private static final String SP_KEY_CURRENCY = "SP_KEY_SAVINGS_CURRENCY";
    private static SavingsCurrencyProvider sInstance = new SavingsCurrencyProvider();
    private final List<String> mList = new ArrayList();

    private SavingsCurrencyProvider() {
    }

    private List<String> cloneCurrencyList() {
        ArrayList arrayList;
        synchronized (this.mList) {
            arrayList = new ArrayList(this.mList);
        }
        return arrayList;
    }

    private Observable<List<String>> getCacheObservable() {
        List<String> readFromSp;
        if (this.mList.isEmpty() && (readFromSp = readFromSp()) != null && !readFromSp.isEmpty()) {
            initData(readFromSp);
        }
        List<String> cloneCurrencyList = cloneCurrencyList();
        if (!cloneCurrencyList.isEmpty()) {
            return Observable.just(cloneCurrencyList);
        }
        return null;
    }

    public static SavingsCurrencyProvider getInstance() {
        return sInstance;
    }

    private Observable<List<String>> getNetObservable() {
        return b.a().D().b().flatMap(new c(this));
    }

    private void initData(List<String> list) {
        synchronized (this.mList) {
            this.mList.clear();
            if (list != null) {
                this.mList.addAll(list);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable lambda$getNetObservable$0(List list) {
        initData(list);
        storeToSp(list);
        return Observable.just(list);
    }

    private List<String> readFromSp() {
        String d11 = SPUtil.d(SP_KEY_CURRENCY, "");
        if (!TextUtils.isEmpty(d11)) {
            return (List) new Gson().fromJson(d11, new TypeToken<List<String>>() {
            }.getType());
        }
        return null;
    }

    private void storeToSp(List<String> list) {
        String str;
        if (list != null) {
            try {
                str = new Gson().toJson((Object) list);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("SavingsCurrencyProvider-->store", e11);
            }
            SPUtil.m(SP_KEY_CURRENCY, str);
        }
        str = "";
        SPUtil.m(SP_KEY_CURRENCY, str);
    }

    public Observable<List<String>> createCurrencyObservable(boolean z11) {
        Observable<List<String>> cacheObservable;
        if (!z11 || (cacheObservable = getCacheObservable()) == null) {
            return getNetObservable();
        }
        getNetObservable().subscribeOn(Schedulers.io()).subscribe(new BaseEasySubscriber());
        return cacheObservable;
    }
}
