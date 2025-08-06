package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huobi.index.bean.IndexFeatureItem;
import java.util.List;

public class AccountQuickModule extends HomePageModule<List<IndexFeatureItem>> {

    public class a extends TypeToken<List<IndexFeatureItem>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<IndexFeatureItem>> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_ACCOUNT_QUICK_211201";
    }

    public boolean g() {
        return true;
    }

    /* renamed from: k */
    public String b(List<IndexFeatureItem> list) {
        return new Gson().toJson((Object) list, new b().getType());
    }

    /* renamed from: l */
    public List<IndexFeatureItem> c(String str) {
        return (List) new Gson().fromJson(str, new a().getType());
    }

    public boolean m() {
        return true;
    }

    /* renamed from: n */
    public List<IndexFeatureItem> i(List<IndexFeatureItem> list) {
        if (list == null) {
            return null;
        }
        return list.size() >= 100 ? list.subList(0, 99) : list;
    }
}
