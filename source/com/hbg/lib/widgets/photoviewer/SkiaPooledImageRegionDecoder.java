package com.hbg.lib.widgets.photoviewer;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.davemorrissey.labs.subscaleview.ImageSource;
import ia.d;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class SkiaPooledImageRegionDecoder implements d {

    /* renamed from: i  reason: collision with root package name */
    public static final String f72152i = "SkiaPooledImageRegionDecoder";

    /* renamed from: j  reason: collision with root package name */
    public static boolean f72153j = false;

    /* renamed from: a  reason: collision with root package name */
    public c f72154a;

    /* renamed from: b  reason: collision with root package name */
    public final ReadWriteLock f72155b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.Config f72156c;

    /* renamed from: d  reason: collision with root package name */
    public Context f72157d;

    /* renamed from: e  reason: collision with root package name */
    public Uri f72158e;

    /* renamed from: f  reason: collision with root package name */
    public long f72159f;

    /* renamed from: g  reason: collision with root package name */
    public final Point f72160g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f72161h;

    public class a extends Thread {
        public a() {
        }

        public void run() {
            while (SkiaPooledImageRegionDecoder.this.f72154a != null) {
                SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                if (skiaPooledImageRegionDecoder.e(skiaPooledImageRegionDecoder.f72154a.n(), SkiaPooledImageRegionDecoder.this.f72159f)) {
                    try {
                        if (SkiaPooledImageRegionDecoder.this.f72154a != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.f("Starting decoder");
                            SkiaPooledImageRegionDecoder.this.i();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = SkiaPooledImageRegionDecoder.this;
                            skiaPooledImageRegionDecoder2.f("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } catch (Exception e11) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder3 = SkiaPooledImageRegionDecoder.this;
                        skiaPooledImageRegionDecoder3.f("Failed to start decoder: " + e11.getMessage());
                    }
                } else {
                    return;
                }
            }
        }
    }

    public class b implements FileFilter {
        public b() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    @Keep
    public static void setDebug(boolean z11) {
        f72153j = z11;
    }

    public Bitmap decodeRegion(Rect rect, int i11) {
        BitmapRegionDecoder d11;
        f("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.f72160g.x || rect.height() < this.f72160g.y) {
            k();
        }
        this.f72155b.readLock().lock();
        try {
            c cVar = this.f72154a;
            if (cVar != null) {
                d11 = cVar.g();
                if (d11 != null) {
                    if (!d11.isRecycled()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = i11;
                        options.inPreferredConfig = this.f72156c;
                        Bitmap decodeRegion = d11.decodeRegion(rect, options);
                        if (decodeRegion != null) {
                            this.f72154a.m(d11);
                            this.f72155b.readLock().unlock();
                            return decodeRegion;
                        }
                        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                    }
                }
                if (d11 != null) {
                    this.f72154a.m(d11);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (Throwable th2) {
            this.f72155b.readLock().unlock();
            throw th2;
        }
    }

    public boolean e(int i11, long j11) {
        if (i11 >= 4) {
            f("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j12 = ((long) i11) * j11;
        if (j12 > 20971520) {
            f("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        } else if (i11 >= h()) {
            f("No additional encoders allowed, limited by CPU cores (" + h() + ")");
            return false;
        } else if (j()) {
            f("No additional encoders allowed, memory is low");
            return false;
        } else {
            f("Additional decoder allowed, current count is " + i11 + ", estimated native memory " + (j12 / 1048576) + "Mb");
            return true;
        }
    }

    public final void f(String str) {
        if (f72153j) {
            Log.d(f72152i, str);
        }
    }

    public final int g() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new b()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public final int h() {
        if (Build.VERSION.SDK_INT >= 17) {
            return Runtime.getRuntime().availableProcessors();
        }
        return g();
    }

    public final void i() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        Resources resources;
        int i11;
        String uri = this.f72158e.toString();
        long j11 = Long.MAX_VALUE;
        if (uri.startsWith("android.resource://")) {
            String authority = this.f72158e.getAuthority();
            if (this.f72157d.getPackageName().equals(authority)) {
                resources = this.f72157d.getResources();
            } else {
                resources = this.f72157d.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.f72158e.getPathSegments();
            int size = pathSegments.size();
            if (size != 2 || !pathSegments.get(0).equals("drawable")) {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i11 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i11 = 0;
            } else {
                i11 = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            }
            try {
                j11 = this.f72157d.getResources().openRawResourceFd(i11).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.f72157d.getResources().openRawResource(i11), false);
        } else if (uri.startsWith(ImageSource.ASSET_SCHEME)) {
            String substring = uri.substring(22);
            try {
                j11 = this.f72157d.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.f72157d.getAssets().open(substring, 1), false);
        } else if (uri.startsWith("file://")) {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri.substring(7), false);
            try {
                File file = new File(uri);
                if (file.exists()) {
                    j11 = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoder = newInstance;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.f72157d.getContentResolver();
                inputStream = contentResolver.openInputStream(this.f72158e);
                BitmapRegionDecoder newInstance2 = BitmapRegionDecoder.newInstance(inputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f72158e, "r");
                    if (openAssetFileDescriptor != null) {
                        j11 = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                bitmapRegionDecoder = newInstance2;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused6) {
                    }
                }
            }
        }
        this.f72159f = j11;
        this.f72160g.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.f72155b.writeLock().lock();
        try {
            c cVar = this.f72154a;
            if (cVar != null) {
                cVar.h(bitmapRegionDecoder);
            }
        } finally {
            this.f72155b.writeLock().unlock();
        }
    }

    public Point init(Context context, Uri uri) throws Exception {
        this.f72157d = context;
        this.f72158e = uri;
        i();
        return this.f72160g;
    }

    public synchronized boolean isReady() {
        c cVar;
        cVar = this.f72154a;
        return cVar != null && !cVar.j();
    }

    public final boolean j() {
        ActivityManager activityManager = (ActivityManager) this.f72157d.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public final void k() {
        if (this.f72161h.compareAndSet(false, true) && this.f72159f < Long.MAX_VALUE) {
            f("Starting lazy init of additional decoders");
            new a().start();
        }
    }

    public synchronized void recycle() {
        this.f72155b.writeLock().lock();
        try {
            c cVar = this.f72154a;
            if (cVar != null) {
                cVar.l();
                this.f72154a = null;
                this.f72157d = null;
                this.f72158e = null;
            }
        } finally {
            this.f72155b.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.f72154a = new c((a) null);
        this.f72155b = new ReentrantReadWriteLock(true);
        this.f72159f = Long.MAX_VALUE;
        this.f72160g = new Point(0, 0);
        this.f72161h = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f72156c = config;
        } else if (preferredBitmapConfig != null) {
            this.f72156c = preferredBitmapConfig;
        } else {
            this.f72156c = Bitmap.Config.RGB_565;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Semaphore f72164a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<BitmapRegionDecoder, Boolean> f72165b;

        public c() {
            this.f72164a = new Semaphore(0, true);
            this.f72165b = new ConcurrentHashMap();
        }

        public final BitmapRegionDecoder g() {
            this.f72164a.acquireUninterruptibly();
            return i();
        }

        public final synchronized void h(BitmapRegionDecoder bitmapRegionDecoder) {
            this.f72165b.put(bitmapRegionDecoder, Boolean.FALSE);
            this.f72164a.release();
        }

        public final synchronized BitmapRegionDecoder i() {
            for (Map.Entry next : this.f72165b.entrySet()) {
                if (!((Boolean) next.getValue()).booleanValue()) {
                    next.setValue(Boolean.TRUE);
                    return (BitmapRegionDecoder) next.getKey();
                }
            }
            return null;
        }

        public final synchronized boolean j() {
            return this.f72165b.isEmpty();
        }

        public final synchronized boolean k(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry next : this.f72165b.entrySet()) {
                if (bitmapRegionDecoder == next.getKey()) {
                    if (!((Boolean) next.getValue()).booleanValue()) {
                        return false;
                    }
                    next.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        public final synchronized void l() {
            while (!this.f72165b.isEmpty()) {
                BitmapRegionDecoder g11 = g();
                g11.recycle();
                this.f72165b.remove(g11);
            }
        }

        public final void m(BitmapRegionDecoder bitmapRegionDecoder) {
            if (k(bitmapRegionDecoder)) {
                this.f72164a.release();
            }
        }

        public final synchronized int n() {
            return this.f72165b.size();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
