package y3;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Options;
import f4.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import l3.a;
import l3.c;
import n3.e;

public class a implements e<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    public static final C0733a f66665f = new C0733a();

    /* renamed from: g  reason: collision with root package name */
    public static final b f66666g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Context f66667a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ImageHeaderParser> f66668b;

    /* renamed from: c  reason: collision with root package name */
    public final b f66669c;

    /* renamed from: d  reason: collision with root package name */
    public final C0733a f66670d;

    /* renamed from: e  reason: collision with root package name */
    public final b f66671e;

    /* renamed from: y3.a$a  reason: collision with other inner class name */
    public static class C0733a {
        public l3.a a(a.C0722a aVar, GifHeader gifHeader, ByteBuffer byteBuffer, int i11) {
            return new c(aVar, gifHeader, byteBuffer, i11);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<GifHeaderParser> f66672a = i.f(0);

        public synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f66672a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.p(byteBuffer);
        }

        public synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f66672a.offer(gifHeaderParser);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f66666g, f66665f);
    }

    public static int e(GifHeader gifHeader, int i11, int i12) {
        int i13;
        int min = Math.min(gifHeader.a() / i12, gifHeader.d() / i11);
        if (min == 0) {
            i13 = 0;
        } else {
            i13 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i13);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i11 + "x" + i12 + "], actual dimens: [" + gifHeader.d() + "x" + gifHeader.a() + "]");
        }
        return max;
    }

    public final d c(ByteBuffer byteBuffer, int i11, int i12, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long b11 = f4.e.b();
        try {
            GifHeader c11 = gifHeaderParser.c();
            if (c11.b() > 0) {
                if (c11.c() == 0) {
                    if (options.a(h.f66713a) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    l3.a a11 = this.f66670d.a(this.f66671e, c11, byteBuffer, e(c11, i11, i12));
                    a11.a(config);
                    a11.f();
                    Bitmap e11 = a11.e();
                    if (e11 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f4.e.a(b11));
                        }
                        return null;
                    }
                    d dVar = new d(new c(this.f66667a, a11, u3.b.a(), i11, i12, e11));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f4.e.a(b11));
                    }
                    return dVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f4.e.a(b11));
            }
        }
    }

    /* renamed from: d */
    public d b(ByteBuffer byteBuffer, int i11, int i12, Options options) {
        GifHeaderParser a11 = this.f66669c.a(byteBuffer);
        try {
            return c(byteBuffer, i11, i12, a11, options);
        } finally {
            this.f66669c.b(a11);
        }
    }

    /* renamed from: f */
    public boolean a(ByteBuffer byteBuffer, Options options) throws IOException {
        return !((Boolean) options.a(h.f66714b)).booleanValue() && com.bumptech.glide.load.a.f(this.f66668b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0733a aVar) {
        this.f66667a = context.getApplicationContext();
        this.f66668b = list;
        this.f66670d = aVar;
        this.f66671e = new b(eVar, bVar);
        this.f66669c = bVar2;
    }
}
