package com.huobi.utils.download;

import com.huobi.dynamiclangs.data.DynamicStringsBean;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class AppLanguageDownloadHelper {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<DynamicStringsBean> f83726a = null;

    /* renamed from: b  reason: collision with root package name */
    public final int f83727b = 500;

    /* renamed from: c  reason: collision with root package name */
    public OkHttpClient f83728c = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();
}
