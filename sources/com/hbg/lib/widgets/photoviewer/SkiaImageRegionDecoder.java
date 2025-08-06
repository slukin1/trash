package com.hbg.lib.widgets.photoviewer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.davemorrissey.labs.subscaleview.ImageSource;
import ia.d;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaImageRegionDecoder implements d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapRegionDecoder f72149a;

    /* renamed from: b  reason: collision with root package name */
    public final ReadWriteLock f72150b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.Config f72151c;

    @Keep
    public SkiaImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    public final Lock a() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.f72150b.writeLock();
        }
        return this.f72150b.readLock();
    }

    public Bitmap decodeRegion(Rect rect, int i11) {
        a().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.f72149a;
            if (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) {
                throw new IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i11;
            options.inPreferredConfig = this.f72151c;
            Bitmap decodeRegion = this.f72149a.decodeRegion(rect, options);
            if (decodeRegion != null) {
                return decodeRegion;
            }
            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
        } finally {
            a().unlock();
        }
    }

    public Point init(Context context, Uri uri) throws Exception {
        Resources resources;
        int i11;
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resources = context.getResources();
            } else {
                resources = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
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
            this.f72149a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i11), false);
        } else if (uri2.startsWith(ImageSource.ASSET_SCHEME)) {
            this.f72149a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f72149a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                if (inputStream != null) {
                    this.f72149a = BitmapRegionDecoder.newInstance(inputStream, false);
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                } else {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th2;
            }
        }
        return new Point(this.f72149a.getWidth(), this.f72149a.getHeight());
    }

    public synchronized boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder;
        bitmapRegionDecoder = this.f72149a;
        return bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled();
    }

    public synchronized void recycle() {
        this.f72150b.writeLock().lock();
        try {
            this.f72149a.recycle();
            this.f72149a = null;
        } finally {
            this.f72150b.writeLock().unlock();
        }
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.f72150b = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f72151c = config;
        } else if (preferredBitmapConfig != null) {
            this.f72151c = preferredBitmapConfig;
        } else {
            this.f72151c = Bitmap.Config.RGB_565;
        }
    }
}
