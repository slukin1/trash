package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.b;
import java.io.File;

public final class d extends b {

    public class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f63798a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63799b;

        public a(Context context, String str) {
            this.f63798a = context;
            this.f63799b = str;
        }

        public File a() {
            File externalCacheDir;
            File b11 = b();
            if ((b11 == null || !b11.exists()) && (externalCacheDir = this.f63798a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.f63799b != null ? new File(externalCacheDir, this.f63799b) : externalCacheDir;
            }
            return b11;
        }

        public final File b() {
            File cacheDir = this.f63798a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f63799b != null ? new File(cacheDir, this.f63799b) : cacheDir;
        }
    }

    public d(Context context, String str, long j11) {
        super(new a(context, str), j11);
    }
}
