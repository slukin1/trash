package com.jumio.core.overlay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jumio.core.MobileContext;
import com.jumio.core.R;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mw.a;

public class BaseLivenessOverlay implements Overlay {

    /* renamed from: a  reason: collision with root package name */
    public MobileContext f39437a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39438b;

    /* renamed from: c  reason: collision with root package name */
    public JumioCredentialPart f39439c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, Integer> f39440d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f39441e;

    /* renamed from: f  reason: collision with root package name */
    public List<ImageView> f39442f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39443g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f39444h;
    public int height;

    /* renamed from: i  reason: collision with root package name */
    public int f39445i;
    public int overlayBottomPixel;
    public int overlayLeftPixel;
    public int overlayRightPixel;
    public int overlayTopPixel;
    public ScanMode scanMode;
    public final AtomicInteger visibility = new AtomicInteger();
    public int width;

    public BaseLivenessOverlay(MobileContext mobileContext) {
        this.f39437a = mobileContext;
        Map<Integer, Integer> customizations$jumio_core_release = Overlay.Companion.getCustomizations$jumio_core_release(this.f39437a);
        this.f39440d = customizations$jumio_core_release;
        this.f39441e = new Rect();
        this.f39442f = new ArrayList();
        Integer num = customizations$jumio_core_release.get(Integer.valueOf(R.attr.jumio_scanOverlay_livenessStroke));
        this.f39445i = num != null ? num.intValue() : R.color.jumio_gray_8;
    }

    public static final void a(BaseLivenessOverlay baseLivenessOverlay, int i11) {
        for (ImageView drawable : baseLivenessOverlay.f39442f) {
            Drawable findDrawableByLayerId = ((LayerDrawable) drawable.getDrawable()).findDrawableByLayerId(R.id.liveness_overlay_part_main);
            if (findDrawableByLayerId != null) {
                findDrawableByLayerId.setTint(i11);
            }
        }
    }

    public static /* synthetic */ void resizeOverlay$default(BaseLivenessOverlay baseLivenessOverlay, Float f11, Float f12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = null;
            }
            if ((i11 & 2) != 0) {
                f12 = null;
            }
            baseLivenessOverlay.resizeOverlay(f11, f12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resizeOverlay");
    }

    public void addViews(ViewGroup viewGroup) {
        if (viewGroup.findViewById(R.id.liveness_overlay_root) == null) {
            this.f39444h = viewGroup;
            View inflate = LayoutInflater.from(this.f39437a).inflate(R.layout.jumio_face_liveness_overlay, viewGroup, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            viewGroup.addView(inflate, layoutParams);
            for (Number intValue : CollectionsKt__CollectionsKt.n(Integer.valueOf(R.id.iv_liveness_overlay_top_left), Integer.valueOf(R.id.iv_liveness_overlay_top_right), Integer.valueOf(R.id.iv_liveness_overlay_bottom_left), Integer.valueOf(R.id.iv_liveness_overlay_bottom_right))) {
                ImageView imageView = (ImageView) inflate.findViewById(intValue.intValue());
                if (imageView != null) {
                    this.f39442f.add(imageView);
                }
            }
            resetHoldStillAnimation();
        }
    }

    public void calculate(Rect rect, Rect rect2) {
        this.width = rect.width();
        int height2 = rect.height();
        this.height = height2;
        this.overlayRightPixel = this.width;
        this.overlayBottomPixel = height2;
    }

    public final void changeColorOfOverlayCircle(int i11, long j11) {
        ViewGroup viewGroup = this.f39444h;
        if (viewGroup != null) {
            viewGroup.postDelayed(new a(this, i11), j11);
        }
    }

    public void doDraw(Canvas canvas) {
    }

    public final JumioCredentialPart getCredentialPart() {
        return this.f39439c;
    }

    public final Rect getExtractionArea() {
        return this.f39441e;
    }

    public final boolean getMirrorOverlay() {
        return this.f39438b;
    }

    public final MobileContext getMobileContext() {
        return this.f39437a;
    }

    public Rect getOverlayBounds() {
        return new Rect(this.overlayLeftPixel, this.overlayTopPixel, this.overlayRightPixel, this.overlayBottomPixel);
    }

    public final int getOverlayCircleMainColor() {
        return this.f39445i;
    }

    public final List<ImageView> getOverlayImageViewList() {
        return this.f39442f;
    }

    public final ViewGroup getRootView() {
        return this.f39444h;
    }

    public final Map<Integer, Integer> getStyleMap() {
        return this.f39440d;
    }

    public final boolean isHoldStill() {
        return this.f39443g;
    }

    public void prepareDraw(boolean z11) {
        this.f39438b = z11;
    }

    public final void resetHoldStillAnimation() {
        Handler handler;
        ViewGroup viewGroup = this.f39444h;
        if (!(viewGroup == null || (handler = viewGroup.getHandler()) == null)) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        for (ImageView drawable : this.f39442f) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) ((LayerDrawable) drawable.getDrawable()).findDrawableByLayerId(R.id.liveness_overlay_part_main);
            if (Build.VERSION.SDK_INT >= 23) {
                animatedVectorDrawable.reset();
            } else {
                animatedVectorDrawable.stop();
                animatedVectorDrawable.invalidateSelf();
                animatedVectorDrawable.getCurrent().invalidateSelf();
            }
            animatedVectorDrawable.setTint(this.f39445i);
        }
        this.f39443g = false;
    }

    public final void resizeOverlay(Float f11, Float f12) {
        ViewGroup viewGroup = this.f39444h;
        ViewGroup.LayoutParams layoutParams = null;
        ConstraintLayout constraintLayout = viewGroup != null ? (ConstraintLayout) viewGroup.findViewById(R.id.liveness_overlay_wrapper) : null;
        for (ImageView imageView : this.f39442f) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
            if (f11 != null) {
                f11.floatValue();
                layoutParams2.width = (int) (f11.floatValue() * ((float) imageView.getWidth()));
            }
            if (f12 != null) {
                f12.floatValue();
                layoutParams2.height = (int) (f12.floatValue() * ((float) imageView.getHeight()));
            }
            imageView.requestLayout();
            imageView.setImageBitmap((Bitmap) null);
            imageView.setImageResource(R.drawable.jumio_liveness_overlay_part_layer_list);
            imageView.getDrawable().invalidateSelf();
        }
        resetHoldStillAnimation();
        if (constraintLayout != null) {
            layoutParams = constraintLayout.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = -2;
        }
        if (constraintLayout != null) {
            constraintLayout.requestLayout();
        }
    }

    public final void setCredentialPart(JumioCredentialPart jumioCredentialPart) {
        this.f39439c = jumioCredentialPart;
    }

    public final void setExtractionArea(Rect rect) {
        this.f39441e = rect;
    }

    public final void setHoldStill(boolean z11) {
        this.f39443g = z11;
    }

    public final void setMirrorOverlay(boolean z11) {
        this.f39438b = z11;
    }

    public final void setMobileContext(MobileContext mobileContext) {
        this.f39437a = mobileContext;
    }

    public final void setOverlayCircleMainColor(int i11) {
        this.f39445i = i11;
    }

    public final void setOverlayImageViewList(List<ImageView> list) {
        this.f39442f = list;
    }

    public final void setRootView(ViewGroup viewGroup) {
        this.f39444h = viewGroup;
    }

    public void setScanPart(ScanPartModel scanPartModel) {
        this.scanMode = scanPartModel.getMode();
        this.f39439c = scanPartModel.getCredentialPart();
    }

    public void setVisible(int i11) {
        this.visibility.set(i11);
    }

    public void update(ExtractionUpdateInterface<?> extractionUpdateInterface) {
    }
}
