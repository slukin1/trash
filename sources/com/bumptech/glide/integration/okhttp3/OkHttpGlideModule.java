package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import b4.b;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.a;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import java.io.InputStream;

@Deprecated
public class OkHttpGlideModule implements b {
    public void a(Context context, GlideBuilder glideBuilder) {
    }

    public void b(Context context, a aVar, Registry registry) {
        registry.r(s3.a.class, InputStream.class, new OkHttpUrlLoader.Factory());
    }
}
