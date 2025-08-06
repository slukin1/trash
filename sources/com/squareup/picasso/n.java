package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class n implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Call.Factory f30069a;

    /* renamed from: b  reason: collision with root package name */
    public final Cache f30070b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30071c;

    public n(Context context) {
        this(y.e(context));
    }

    public Response a(Request request) throws IOException {
        return this.f30069a.newCall(request).execute();
    }

    public n(File file) {
        this(file, y.a(file));
    }

    public n(File file, long j11) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j11)).build());
        this.f30071c = false;
    }

    public n(OkHttpClient okHttpClient) {
        this.f30071c = true;
        this.f30069a = okHttpClient;
        this.f30070b = okHttpClient.cache();
    }
}
