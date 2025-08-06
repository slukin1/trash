package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n3.d;

public class p<T> implements n3.e<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final n3.d<Long> f64125d = n3.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e  reason: collision with root package name */
    public static final n3.d<Integer> f64126e = n3.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f  reason: collision with root package name */
    public static final e f64127f = new e();

    /* renamed from: a  reason: collision with root package name */
    public final f<T> f64128a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f64129b;

    /* renamed from: c  reason: collision with root package name */
    public final e f64130c;

    public class a implements d.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f64131a = ByteBuffer.allocate(8);

        /* renamed from: b */
        public void a(byte[] bArr, Long l11, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f64131a) {
                this.f64131a.position(0);
                messageDigest.update(this.f64131a.putLong(l11.longValue()).array());
            }
        }
    }

    public class b implements d.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f64132a = ByteBuffer.allocate(4);

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f64132a) {
                    this.f64132a.position(0);
                    messageDigest.update(this.f64132a.putInt(num.intValue()).array());
                }
            }
        }
    }

    public static final class c implements f<AssetFileDescriptor> {
        public c() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static final class d implements f<ByteBuffer> {

        public class a extends MediaDataSource {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f64133b;

            public a(ByteBuffer byteBuffer) {
                this.f64133b = byteBuffer;
            }

            public void close() {
            }

            public long getSize() {
                return (long) this.f64133b.limit();
            }

            public int readAt(long j11, byte[] bArr, int i11, int i12) {
                if (j11 >= ((long) this.f64133b.limit())) {
                    return -1;
                }
                this.f64133b.position((int) j11);
                int min = Math.min(i12, this.f64133b.remaining());
                this.f64133b.get(bArr, i11, min);
                return min;
            }
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    public static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t11);
    }

    public static final class g implements f<ParcelFileDescriptor> {
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public p(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar) {
        this(eVar, fVar, f64127f);
    }

    public static n3.e<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new p(eVar, new c((a) null));
    }

    public static n3.e<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new p(eVar, new d());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11, int i12, int i13, DownsampleStrategy downsampleStrategy) {
        Bitmap g11 = (Build.VERSION.SDK_INT < 27 || i12 == Integer.MIN_VALUE || i13 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f64058f) ? null : g(mediaMetadataRetriever, j11, i11, i12, i13, downsampleStrategy);
        return g11 == null ? f(mediaMetadataRetriever, j11, i11) : g11;
    }

    public static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11) {
        return mediaMetadataRetriever.getFrameAtTime(j11, i11);
    }

    @TargetApi(27)
    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11, int i12, int i13, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i14 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i14;
            }
            float b11 = downsampleStrategy.b(parseInt, parseInt2, i12, i13);
            return mediaMetadataRetriever.getScaledFrameAtTime(j11, i11, Math.round(((float) parseInt) * b11), Math.round(b11 * ((float) parseInt2)));
        } catch (Throwable th2) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th2);
            return null;
        }
    }

    public static n3.e<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new p(eVar, new g());
    }

    public boolean a(T t11, Options options) {
        return true;
    }

    public r<Bitmap> b(T t11, int i11, int i12, Options options) throws IOException {
        long longValue = ((Long) options.a(f64125d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.a(f64126e);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.a(DownsampleStrategy.f64060h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f64059g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a11 = this.f64130c.a();
            try {
                this.f64128a.a(a11, t11);
                Bitmap e11 = e(a11, longValue, num.intValue(), i11, i12, downsampleStrategy2);
                a11.release();
                return c.c(e11, this.f64129b);
            } catch (RuntimeException e12) {
                throw new IOException(e12);
            } catch (Throwable th2) {
                a11.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public p(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar, e eVar2) {
        this.f64129b = eVar;
        this.f64128a = fVar;
        this.f64130c = eVar2;
    }
}
