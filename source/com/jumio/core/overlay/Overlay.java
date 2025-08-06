package com.jumio.core.overlay;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.jumio.core.MobileContext;
import com.jumio.core.R;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.models.ScanPartModel;
import d10.p;
import java.util.Map;
import kotlin.jvm.internal.Lambda;

public interface Overlay {
    public static final int BORDER_STROKE_WIDTH_IN_DP = 2;
    public static final Companion Companion = Companion.f39465a;
    public static final int DETECTED_BORDER_STROKE_WIDTH_IN_DP = 6;

    public static final class Companion {
        public static final int BORDER_STROKE_WIDTH_IN_DP = 2;
        public static final int DETECTED_BORDER_STROKE_WIDTH_IN_DP = 6;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39465a = new Companion();

        public static final class a extends Lambda implements p<TypedArray, Integer, Integer> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39466a = new a();

            public a() {
                super(2);
            }

            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((TypedArray) obj).getColor(((Number) obj2).intValue(), -1));
            }
        }

        public final Map<Integer, Integer> getCustomizations$jumio_core_release(MobileContext mobileContext) {
            return mobileContext.getCustomizations(R.style.Jumio_Overlay_Customization, R.attr.jumio_overlay_customization, new int[]{R.attr.jumio_scanOverlay, R.attr.jumio_scanOverlayFill, R.attr.jumio_scanOverlayTransparent, R.attr.jumio_scanBackground, R.attr.jumio_scanOverlay_livenessStroke, R.attr.jumio_scanOverlay_livenessStrokeAnimation, R.attr.jumio_scanOverlay_livenessStrokeAnimationCompleted}, a.f39466a);
        }
    }

    void addViews(ViewGroup viewGroup);

    void calculate(Rect rect, Rect rect2);

    void doDraw(Canvas canvas);

    Rect getOverlayBounds();

    void prepareDraw(boolean z11);

    void setScanPart(ScanPartModel scanPartModel);

    void setVisible(int i11);

    void update(ExtractionUpdateInterface<?> extractionUpdateInterface);
}
