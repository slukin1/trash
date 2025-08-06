package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.e;
import f4.c;
import f4.g;
import java.io.IOException;
import java.io.InputStream;
import n3.e;

public class n implements e<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final e f64115a;

    /* renamed from: b  reason: collision with root package name */
    public final b f64116b;

    public static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final RecyclableBufferedInputStream f64117a;

        /* renamed from: b  reason: collision with root package name */
        public final c f64118b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, c cVar) {
            this.f64117a = recyclableBufferedInputStream;
            this.f64118b = cVar;
        }

        public void a() {
            this.f64117a.b();
        }

        public void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException {
            IOException a11 = this.f64118b.a();
            if (a11 != null) {
                if (bitmap != null) {
                    eVar.c(bitmap);
                }
                throw a11;
            }
        }
    }

    public n(e eVar, b bVar) {
        this.f64115a = eVar;
        this.f64116b = bVar;
    }

    /* renamed from: c */
    public r<Bitmap> b(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z11;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z11 = false;
        } else {
            z11 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f64116b);
        }
        c b11 = c.b(recyclableBufferedInputStream);
        try {
            return this.f64115a.g(new g(b11), i11, i12, options, new a(recyclableBufferedInputStream, b11));
        } finally {
            b11.release();
            if (z11) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return this.f64115a.p(inputStream);
    }
}
