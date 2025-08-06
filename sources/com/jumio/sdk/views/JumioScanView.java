package com.jumio.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import com.jumio.core.R;
import com.jumio.core.views.CameraScanView;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.scanpart.JumioScanPart;
import kotlin.jvm.internal.r;

public final class JumioScanView extends CameraScanView {
    public static final Companion Companion = new Companion((r) null);
    public static final int MODE_FACE = 1;
    public static final int MODE_ID = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f25025n;

    /* renamed from: o  reason: collision with root package name */
    public float f25026o;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public JumioScanView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public JumioScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioScanView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void attach(JumioScanPart jumioScanPart) {
        super.attach(jumioScanPart);
    }

    public JumioCameraFacing getCameraFacing() {
        return super.getCameraFacing();
    }

    public boolean getExtraction() {
        return super.getExtraction();
    }

    public boolean getFlash() {
        return super.getFlash();
    }

    public boolean getHasFlash() {
        return super.getHasFlash();
    }

    public boolean getHasMultipleCameras() {
        return super.getHasMultipleCameras();
    }

    public float getMinRatio() {
        return this.f25025n == 0 ? 1.33f : 1.0f;
    }

    public final int getMode() {
        return this.f25025n;
    }

    public float getRatio() {
        return this.f25026o;
    }

    public boolean isShutterEnabled() {
        return super.isShutterEnabled();
    }

    @a0(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        super.pause();
    }

    @a0(Lifecycle.Event.ON_RESUME)
    public void resume() {
        super.resume();
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        super.setCameraFacing(jumioCameraFacing);
    }

    public void setExtraction(boolean z11) {
        super.setExtraction(z11);
    }

    public void setFlash(boolean z11) {
        super.setFlash(z11);
    }

    public final void setMode(int i11) {
        this.f25025n = i11;
    }

    public void setRatio(float f11) {
        this.f25026o = f11;
    }

    public void switchCamera() {
        super.switchCamera();
    }

    public void takePicture() {
        super.takePicture();
    }

    public JumioScanView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f25026o = getMinRatio();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.JumioScanView, 0, 0);
        try {
            this.f25025n = obtainStyledAttributes.getInt(R.styleable.JumioScanView_jumio_mode, 0);
            setRatio(obtainStyledAttributes.getFloat(R.styleable.JumioScanView_jumio_ratio, getMinRatio()));
            setBrandingLogoTopMargin(obtainStyledAttributes.getDimensionPixelSize(R.styleable.JumioScanView_jumio_branding_logo_top_margin, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
