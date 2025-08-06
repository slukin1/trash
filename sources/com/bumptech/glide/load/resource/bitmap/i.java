package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import f4.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface i {

    public static final class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.load.data.b f64102a;

        /* renamed from: b  reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f64103b;

        /* renamed from: c  reason: collision with root package name */
        public final List<ImageHeaderParser> f64104c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f64103b = (com.bumptech.glide.load.engine.bitmap_recycle.b) h.d(bVar);
            this.f64104c = (List) h.d(list);
            this.f64102a = new com.bumptech.glide.load.data.b(inputStream, bVar);
        }

        public void a() {
            this.f64102a.a();
        }

        public int b() throws IOException {
            return com.bumptech.glide.load.a.b(this.f64104c, this.f64102a.c(), this.f64103b);
        }

        public Bitmap c(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f64102a.c(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.e(this.f64104c, this.f64102a.c(), this.f64103b);
        }
    }

    public static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f64105a;

        /* renamed from: b  reason: collision with root package name */
        public final List<ImageHeaderParser> f64106b;

        /* renamed from: c  reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f64107c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f64105a = (com.bumptech.glide.load.engine.bitmap_recycle.b) h.d(bVar);
            this.f64106b = (List) h.d(list);
            this.f64107c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public void a() {
        }

        public int b() throws IOException {
            return com.bumptech.glide.load.a.a(this.f64106b, this.f64107c, this.f64105a);
        }

        public Bitmap c(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f64107c.c().getFileDescriptor(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.d(this.f64106b, this.f64107c, this.f64105a);
        }
    }

    void a();

    int b() throws IOException;

    Bitmap c(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
