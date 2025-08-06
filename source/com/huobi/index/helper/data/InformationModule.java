package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InformationModule extends HomePageModule<List<NewFlashInformation>> {

    /* renamed from: c  reason: collision with root package name */
    public final Lock f73294c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f73295d = new ArrayList();

    public class a extends TypeToken<List<NewFlashInformation>> {
        public a() {
        }
    }

    public String e() {
        return "SP_TAG_INFORMATION_211201";
    }

    /* renamed from: k */
    public String b(List<NewFlashInformation> list) {
        return new Gson().toJson((Object) list);
    }

    /* renamed from: l */
    public List<NewFlashInformation> c(String str) {
        return (List) new Gson().fromJson(str, new a().getType());
    }

    /* renamed from: m */
    public List<NewFlashInformation> i(List<NewFlashInformation> list) {
        return list;
    }
}
