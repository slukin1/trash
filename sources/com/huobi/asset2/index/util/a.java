package com.huobi.asset2.index.util;

import android.annotation.SuppressLint;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public List<MiningItem> f42766a;

    /* renamed from: b  reason: collision with root package name */
    public List<MiningItem> f42767b;

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static a f42768a = new a();
    }

    public static a a() {
        return b.f42768a;
    }

    public boolean b() {
        return CollectionsUtils.b(this.f42766a) && !CollectionsUtils.b(this.f42767b);
    }

    public void c(List<MiningItem> list, List<MiningItem> list2) {
        this.f42766a.clear();
        this.f42767b.clear();
        this.f42766a.addAll(list);
        this.f42767b.addAll(list2);
    }

    public a() {
        this.f42766a = new ArrayList();
        this.f42767b = new ArrayList();
    }
}
