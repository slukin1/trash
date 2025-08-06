package com.hbg.lib.widgets.photoviewer.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import androidx.annotation.Keep;
import com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaPooledImageRegionDecoder {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f72268g = false;

    /* renamed from: a  reason: collision with root package name */
    public a f72269a;

    /* renamed from: b  reason: collision with root package name */
    public final ReadWriteLock f72270b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.Config f72271c;

    /* renamed from: d  reason: collision with root package name */
    public long f72272d;

    /* renamed from: e  reason: collision with root package name */
    public final Point f72273e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f72274f;

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    @Keep
    public static void setDebug(boolean z11) {
        f72268g = z11;
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.f72269a = new a((a) null);
        this.f72270b = new ReentrantReadWriteLock(true);
        this.f72272d = Long.MAX_VALUE;
        this.f72273e = new Point(0, 0);
        this.f72274f = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f72271c = config;
        } else if (preferredBitmapConfig != null) {
            this.f72271c = preferredBitmapConfig;
        } else {
            this.f72271c = Bitmap.Config.RGB_565;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Semaphore f72275a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<BitmapRegionDecoder, Boolean> f72276b;

        public a() {
            this.f72275a = new Semaphore(0, true);
            this.f72276b = new ConcurrentHashMap();
        }

        public /* synthetic */ a(a aVar) {
            this();
        }
    }
}
