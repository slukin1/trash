package com.hbg.lib.network.inst.retrofit;

import android.content.Context;
import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.hbg.lib.network.inst.service.InstService;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.tencent.android.tpush.common.Constants;
import d9.a;
import f8.b;
import java.util.HashMap;

public class InstApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public c9.b f70312a;

    /* renamed from: b  reason: collision with root package name */
    public String f70313b;

    public void a(String str, Context context, c9.b bVar) {
        this.f70313b = str;
        RetrofitLogger.a(this.f70313b + "-->init");
        this.f70312a = bVar;
        InstRetrofit.d().init(str, context, bVar);
    }

    public a<String> b(String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(Constants.FLAG_TICKET, str);
        hashMap.put("x-b3-traceid", str);
        return new a<>(((InstService) InstRetrofit.request(InstService.class)).userLogin(hashMap).compose(InstRetrofit.e()).map(g8.a.f54790b));
    }

    public a<InstStateInfo> getInstStateInfo() {
        return new a<>(((InstService) InstRetrofit.request(InstService.class)).getInstStateInfo().compose(InstRetrofit.e()));
    }
}
