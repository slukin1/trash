package com.huobi.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import b4.b;
import bh.u;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.a;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.g;
import com.bumptech.glide.load.engine.cache.d;
import com.bumptech.glide.load.engine.cache.f;
import com.bumptech.glide.module.LibraryGlideModule;
import com.caverock.androidsvg.SVG;
import com.hbg.lib.common.glide.SvgDecoder;
import com.hbg.lib.common.glide.SvgDrawableTranscoder;
import com.huobi.otc.pdf.PdfPageData;
import com.huobi.otc.pdf.PdfPageLoader;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import q3.b;

public class CustomModule extends LibraryGlideModule implements b {
    public void a(Context context, GlideBuilder glideBuilder) {
        glideBuilder.c(new d(context, "PreferredDiskCache", 262144000));
        b.a aVar = new b.a(context);
        int d11 = (int) (((double) aVar.a().d()) * 1.2d);
        int b11 = (int) (((double) aVar.a().b()) * 1.2d);
        Log.e("CustomModule", "CustomModule applyOptions customMemoryCacheSize:" + d11 + " customBitmapPoolSize:" + b11);
        glideBuilder.d(new f((long) d11));
        glideBuilder.b(new g((long) b11));
    }

    public void b(Context context, a aVar, Registry registry) {
        Class<SVG> cls = SVG.class;
        registry.q(cls, PictureDrawable.class, new SvgDrawableTranscoder()).a(InputStream.class, cls, new SvgDecoder());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15, timeUnit).readTimeout(15, timeUnit).writeTimeout(15, timeUnit).retryOnConnectionFailure(false);
        u.b(builder);
        registry.r(s3.a.class, InputStream.class, new OkHttpUrlLoader.Factory(builder.build()));
        registry.b(PdfPageData.class, Bitmap.class, new PdfPageLoader.Factory());
    }
}
