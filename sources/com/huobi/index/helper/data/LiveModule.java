package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveModule extends HomePageModule<List<LiveDetailBean>> {

    /* renamed from: c  reason: collision with root package name */
    public final Lock f73298c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f73299d = new ArrayList();

    public class a extends TypeToken<List<LiveDetailBean>> {
        public a() {
        }
    }

    public String e() {
        return "SP_TAG_INFORMATION_211201";
    }

    public void h() {
        if (this.f73291b == null) {
            super.h();
        }
    }

    /* renamed from: k */
    public String b(List<LiveDetailBean> list) {
        return new Gson().toJson((Object) list);
    }

    /* renamed from: l */
    public List<LiveDetailBean> c(String str) {
        return (List) new Gson().fromJson(str, new a().getType());
    }

    public List<LiveDetailBean> m() {
        this.f73298c.lock();
        try {
            return (List) super.d();
        } finally {
            this.f73298c.unlock();
        }
    }

    public boolean n() {
        return true;
    }

    /* renamed from: o */
    public List<LiveDetailBean> i(List<LiveDetailBean> list) {
        return list;
    }

    public void p(List<LiveDetailBean> list) {
        this.f73298c.lock();
        super.j(list);
        this.f73298c.unlock();
    }

    public void q(List<s9.a> list) {
        this.f73299d.clear();
        this.f73299d.addAll(list);
    }
}
