package com.hbg.lib.network.content.retrofit;

import android.content.Context;
import com.hbg.lib.network.content.core.bean.WorkOrderConfig;
import com.hbg.lib.network.content.service.MgtContentService;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.tencent.android.tpush.common.Constants;
import d9.a;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import n7.b;

public class MgtContentApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public c9.b f69205a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f69206b = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public String f69207c;

    public void a(String str, Context context, c9.b bVar) {
        this.f69207c = str;
        RetrofitLogger.a(this.f69207c + "-->init");
        this.f69205a = bVar;
        MgtContentRetrofit.d().init(str, context, bVar);
    }

    public a<String> b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, str);
        return new a<>(((MgtContentService) MgtContentRetrofit.request(MgtContentService.class)).userLogin(hashMap).compose(MgtContentRetrofit.h()));
    }

    public a<WorkOrderConfig> workOrderConfigGet() {
        return new a<>(((MgtContentService) MgtContentRetrofit.request(MgtContentService.class)).workOrderConfigGet().compose(MgtContentRetrofit.h()));
    }
}
