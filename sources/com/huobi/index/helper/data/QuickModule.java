package com.huobi.index.helper.data;

import bh.j;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huobi.index.bean.IndexFeatureItem;
import java.util.List;
import pro.huobi.R;
import tg.r;
import yl.o;

public class QuickModule extends HomePageModule<List<IndexFeatureItem>> {

    public class a extends TypeToken<List<IndexFeatureItem>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<IndexFeatureItem>> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_QUICK_211201";
    }

    public boolean g() {
        if (r.x().F0()) {
            return !r.x().X();
        }
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
        return g();
    }

    /* renamed from: n */
    public List<IndexFeatureItem> i(List<IndexFeatureItem> list) {
        if (list == null) {
            return null;
        }
        if (list.size() >= 100) {
            list = list.subList(0, 99);
        }
        for (IndexFeatureItem next : list) {
            next.imgUrl = next.newImgUrl;
        }
        if (o.B() && list.size() > 7) {
            list = list.subList(0, 7);
        }
        if (list.get(list.size() - 1).jumpMode != 999) {
            IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
            indexFeatureItem.title = j.d(R.string.n_home_index_earn_more);
            indexFeatureItem.imgUrl = "index_quick_more";
            indexFeatureItem.jumpMode = 999;
            list.add(indexFeatureItem);
        }
        return list;
    }
}
