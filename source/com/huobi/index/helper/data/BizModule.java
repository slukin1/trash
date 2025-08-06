package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomePageBizData;
import com.hbg.lib.network.hbg.core.bean.HomePageData;
import com.huobi.index.bean.IndexBizData;
import java.util.ArrayList;
import java.util.List;

public class BizModule extends HomePageModule<List<IndexBizData>> {

    /* renamed from: c  reason: collision with root package name */
    public String f73281c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f73282d = null;

    public class a extends TypeToken<List<IndexBizData>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<IndexBizData>> {
        public b() {
        }
    }

    public void a() {
        super.a();
        this.f73281c = null;
        this.f73282d = null;
    }

    public String e() {
        return "SP_TAG_BIZ_211201";
    }

    public boolean g() {
        return super.g();
    }

    /* renamed from: k */
    public String b(List<IndexBizData> list) {
        return new Gson().toJson((Object) list, new b().getType());
    }

    /* renamed from: l */
    public List<IndexBizData> c(String str) {
        List<IndexBizData> list = (List) new Gson().fromJson(str, new a().getType());
        this.f73282d = t(list);
        return list;
    }

    public final IndexBizData m(String str) {
        T t11 = this.f73291b;
        if (t11 != null && !((List) t11).isEmpty()) {
            for (IndexBizData indexBizData : (List) this.f73291b) {
                if (str.equalsIgnoreCase(indexBizData.getData().getName())) {
                    return indexBizData;
                }
            }
        }
        return null;
    }

    public String n() {
        return this.f73282d;
    }

    public String o() {
        return this.f73281c;
    }

    public boolean p() {
        return f(33);
    }

    public boolean q() {
        return p();
    }

    /* renamed from: r */
    public List<IndexBizData> i(List<IndexBizData> list) {
        List<IndexBizData> s11 = s(list);
        this.f73282d = t(s11);
        return s11;
    }

    public final List<IndexBizData> s(List<IndexBizData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (IndexBizData next : list) {
                if (next.getData().getFlag() != 1) {
                    IndexBizData m11 = m(next.getData().getName());
                    if (m11 != null) {
                        arrayList.add(m11);
                    }
                } else if (next.getData().getShow() == 1) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() >= 4) {
            return arrayList.subList(0, 4);
        }
        if (arrayList.size() >= 2) {
            return arrayList.subList(0, 2);
        }
        arrayList.clear();
        return arrayList;
    }

    @Deprecated
    public final String t(List<IndexBizData> list) {
        return "";
    }

    public void u(HomePageData homePageData) {
        ArrayList arrayList = new ArrayList();
        for (HomePageBizData indexBizData : homePageData.getAccess()) {
            arrayList.add(new IndexBizData(indexBizData));
        }
        super.j(arrayList);
        this.f73281c = homePageData.getHot();
    }
}
