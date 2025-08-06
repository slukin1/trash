package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import v7.b;

public class MineCurrencyProvider {
    private static final List<MineAccountItem> mList = new ArrayList();
    private static final Map<String, MineAccountItem> mMap = new HashMap();
    /* access modifiers changed from: private */
    public static final List<MineAccountItem> mTransferableList = new ArrayList();

    public static List<MineAccountItem> cloneCurrencyList() {
        ArrayList arrayList;
        List<MineAccountItem> list = mList;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        return arrayList;
    }

    public static List<MineAccountItem> cloneTransferableCurrencyList() {
        ArrayList arrayList;
        List<MineAccountItem> list = mTransferableList;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        return arrayList;
    }

    public static Observable<List<MineAccountItem>> createCurrencyObservable(boolean z11) {
        Observable<List<MineAccountItem>> cacheObservable;
        if (!z11 || (cacheObservable = getCacheObservable()) == null) {
            return getNetObservable();
        }
        getNetObservable().subscribeOn(Schedulers.io()).subscribe(new BaseEasySubscriber());
        return cacheObservable;
    }

    private static Observable<List<MineAccountItem>> getCacheObservable() {
        if (mList.isEmpty()) {
            List<MineAccountItem> readFromFile = MineCurrencyUtil.readFromFile();
            if (!readFromFile.isEmpty()) {
                initData(readFromFile);
            }
        }
        List<MineAccountItem> cloneCurrencyList = cloneCurrencyList();
        if (!cloneCurrencyList.isEmpty()) {
            return Observable.just(cloneCurrencyList);
        }
        return null;
    }

    private static Observable<List<MineAccountItem>> getNetObservable() {
        return b.a().getMineCurrencyList().b().flatMap(b.f70275b);
    }

    private static void initData(List<MineAccountItem> list) {
        Map<String, MineAccountItem> map = mMap;
        synchronized (map) {
            map.clear();
            if (list != null) {
                for (MineAccountItem next : list) {
                    mMap.put(next.getCurrency(), next);
                }
            }
        }
        List<MineAccountItem> list2 = mList;
        synchronized (list2) {
            list2.clear();
            if (list != null) {
                list2.addAll(list);
                Observable.from(list2).filter(a.f70274b).toList().subscribe(new BaseSubscriber<List<MineAccountItem>>() {
                    public void onNext(List<MineAccountItem> list) {
                        super.onNext(list);
                        MineCurrencyProvider.mTransferableList.clear();
                        MineCurrencyProvider.mTransferableList.addAll(list);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Observable lambda$getNetObservable$0(List list) {
        initData(list);
        MineCurrencyUtil.store(list);
        return Observable.just(list);
    }

    public static MineAccountItem queryMineAccountItem(String str) {
        if (str == null) {
            return null;
        }
        return mMap.get(str.toUpperCase(Locale.US));
    }
}
