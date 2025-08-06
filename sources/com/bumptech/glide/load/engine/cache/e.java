package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.b;
import java.io.File;

public final class e extends b {

    public class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f63800a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63801b;

        public a(Context context, String str) {
            this.f63800a = context;
            this.f63801b = str;
        }

        public File a() {
            File cacheDir = this.f63800a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f63801b != null ? new File(cacheDir, this.f63801b) : cacheDir;
        }
    }

    public e(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public e(Context context, String str, long j11) {
        super(new a(context, str), j11);
    }
}
