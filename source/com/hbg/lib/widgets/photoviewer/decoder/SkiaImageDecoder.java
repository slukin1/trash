package com.hbg.lib.widgets.photoviewer.decoder;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView;

public class SkiaImageDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f72265a;

    @Keep
    public SkiaImageDecoder() {
        this((Bitmap.Config) null);
    }

    public SkiaImageDecoder(Bitmap.Config config) {
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.f72265a = config;
        } else if (preferredBitmapConfig != null) {
            this.f72265a = preferredBitmapConfig;
        } else {
            this.f72265a = Bitmap.Config.RGB_565;
        }
    }
}
