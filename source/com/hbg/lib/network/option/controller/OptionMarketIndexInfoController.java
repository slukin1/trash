package com.hbg.lib.network.option.controller;

import android.text.TextUtils;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q8.a;
import q8.b;
import rx.Observable;

public class OptionMarketIndexInfoController {

    /* renamed from: a  reason: collision with root package name */
    public static final List<OptionMarketIndexInfo> f69246a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, OptionMarketIndexInfo> f69247b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, List<OptionMarketIndexInfo>> f69248c = new HashMap();

    public static Observable<List<OptionMarketIndexInfo>> c(boolean z11, String str) {
        Observable<List<OptionMarketIndexInfo>> just;
        if (z11) {
            if (TextUtils.isEmpty(str)) {
                List<OptionMarketIndexInfo> list = f69246a;
                if (!list.isEmpty()) {
                    synchronized (list) {
                        just = Observable.just(new ArrayList(list));
                    }
                    return just;
                }
            }
            OptionMarketIndexInfo optionMarketIndexInfo = f69247b.get(str);
            if (optionMarketIndexInfo != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(optionMarketIndexInfo);
                return Observable.just(arrayList);
            }
        }
        return g((String) null, (String) null, str).map(new a(str));
    }

    public static Observable<List<OptionMarketIndexInfo>> d(boolean z11, String str, String str2) {
        if (z11) {
            Map<String, List<OptionMarketIndexInfo>> map = f69248c;
            if (!map.isEmpty()) {
                List list = map.get(str + "_" + str2);
                if (list != null && !list.isEmpty()) {
                    return Observable.just(list);
                }
            }
        }
        return g(str, str2, (String) null).map(new b(str, str2));
    }

    public static /* synthetic */ List e(String str, List list) {
        int indexOf;
        List<OptionMarketIndexInfo> list2 = f69246a;
        synchronized (list2) {
            if (TextUtils.isEmpty(str)) {
                list2.clear();
                list2.addAll(list);
            } else {
                try {
                    OptionMarketIndexInfo optionMarketIndexInfo = f69247b.get(str);
                    if (optionMarketIndexInfo != null && (indexOf = list2.indexOf(optionMarketIndexInfo)) >= 0) {
                        list2.remove(optionMarketIndexInfo);
                        list2.addAll(indexOf, list);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        Map<String, OptionMarketIndexInfo> map = f69247b;
        synchronized (map) {
            if (TextUtils.isEmpty(str)) {
                map.clear();
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                OptionMarketIndexInfo optionMarketIndexInfo2 = (OptionMarketIndexInfo) it2.next();
                if (optionMarketIndexInfo2 != null) {
                    f69247b.put(optionMarketIndexInfo2.getContractCode(), optionMarketIndexInfo2);
                }
            }
        }
        return list;
    }

    public static /* synthetic */ List f(String str, String str2, List list) {
        Map<String, List<OptionMarketIndexInfo>> map = f69248c;
        synchronized (map) {
            map.put(str + "_" + str2, list);
        }
        return list;
    }

    public static Observable<List<OptionMarketIndexInfo>> g(String str, String str2, String str3) {
        return p8.a.a().m(str, str2, str3).b();
    }
}
