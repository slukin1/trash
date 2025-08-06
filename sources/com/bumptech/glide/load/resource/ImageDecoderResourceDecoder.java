package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.h;
import java.io.IOException;
import n3.d;
import n3.e;

public abstract class ImageDecoderResourceDecoder<T> implements e<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    public final h f64031a = h.a();

    public class a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f64032a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64033b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f64034c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DecodeFormat f64035d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownsampleStrategy f64036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PreferredColorSpace f64037f;

        /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$a$a  reason: collision with other inner class name */
        public class C0705a implements ImageDecoder.OnPartialImageListener {
            public C0705a() {
            }

            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public a(int i11, int i12, boolean z11, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f64032a = i11;
            this.f64033b = i12;
            this.f64034c = z11;
            this.f64035d = decodeFormat;
            this.f64036e = downsampleStrategy;
            this.f64037f = preferredColorSpace;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z11 = false;
            if (ImageDecoderResourceDecoder.this.f64031a.c(this.f64032a, this.f64033b, this.f64034c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f64035d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0705a());
            Size size = imageInfo.getSize();
            int i11 = this.f64032a;
            if (i11 == Integer.MIN_VALUE) {
                i11 = size.getWidth();
            }
            int i12 = this.f64033b;
            if (i12 == Integer.MIN_VALUE) {
                i12 = size.getHeight();
            }
            float b11 = this.f64036e.b(size.getWidth(), size.getHeight(), i11, i12);
            int round = Math.round(((float) size.getWidth()) * b11);
            int round2 = Math.round(((float) size.getHeight()) * b11);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b11);
            }
            imageDecoder.setTargetSize(round, round2);
            int i13 = Build.VERSION.SDK_INT;
            if (i13 >= 28) {
                if (this.f64037f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z11 = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z11 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i13 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    public abstract r<T> c(ImageDecoder.Source source, int i11, int i12, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    /* renamed from: d */
    public final r<T> b(ImageDecoder.Source source, int i11, int i12, Options options) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) options.a(com.bumptech.glide.load.resource.bitmap.e.f64078f);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.a(DownsampleStrategy.f64060h);
        d dVar = com.bumptech.glide.load.resource.bitmap.e.f64082j;
        return c(source, i11, i12, new a(i11, i12, options.a(dVar) != null && ((Boolean) options.a(dVar)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) options.a(com.bumptech.glide.load.resource.bitmap.e.f64079g)));
    }

    /* renamed from: e */
    public final boolean a(ImageDecoder.Source source, Options options) {
        return true;
    }
}
