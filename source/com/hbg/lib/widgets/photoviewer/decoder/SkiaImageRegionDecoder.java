package com.hbg.lib.widgets.photoviewer.decoder;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SkiaImageRegionDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final ReadWriteLock f72266a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap.Config f72267b;

    @Keep
    public SkiaImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.f72266a = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f72267b = config;
        } else if (preferredBitmapConfig != null) {
            this.f72267b = preferredBitmapConfig;
        } else {
            this.f72267b = Bitmap.Config.RGB_565;
        }
    }
}
