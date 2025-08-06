package com.hbg.lib.network.etf.retrofit;

import android.content.Context;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.text.SimpleDateFormat;
import java.util.Locale;
import t7.b;

public class EtfApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public c9.b f70202a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f70203b = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public String f70204c;

    public void a(String str, Context context, c9.b bVar) {
        this.f70204c = str;
        RetrofitLogger.a(this.f70204c + "-->init");
        this.f70202a = bVar;
        EtfRetrofit.e().init(str, context, bVar);
    }
}
