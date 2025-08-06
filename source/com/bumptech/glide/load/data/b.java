package com.bumptech.glide.load.data;

import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b implements a<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclableBufferedInputStream f63671a;

    public static final class a implements a.C0699a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f63672a;

        public a(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f63672a = bVar;
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public a<InputStream> b(InputStream inputStream) {
            return new b(inputStream, this.f63672a);
        }
    }

    public b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f63671a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(UploadObjectRequest.MIN_PART_SIZE);
    }

    public void a() {
        this.f63671a.b();
    }

    public void b() {
        this.f63671a.release();
    }

    /* renamed from: d */
    public InputStream c() throws IOException {
        this.f63671a.reset();
        return this.f63671a;
    }
}
