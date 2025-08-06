package com.jumio.core.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogLevel;
import com.jumio.commons.utils.DrawingUtil;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.MobileContext;
import com.jumio.core.R;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.models.PhysicalIdScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class JVisionOverlay implements Overlay {

    /* renamed from: a  reason: collision with root package name */
    public MobileContext f39446a;

    /* renamed from: b  reason: collision with root package name */
    public int f39447b;
    public final Paint borderPaint = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public int f39448c;

    /* renamed from: d  reason: collision with root package name */
    public int f39449d;
    public boolean detectLines;
    public boolean dimBackground;
    public boolean drawBrackets;

    /* renamed from: e  reason: collision with root package name */
    public Rect f39450e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final Paint f39451f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public final Paint f39452g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Path f39453h;
    public int height;
    public boolean horizontalCrop;

    /* renamed from: i  reason: collision with root package name */
    public List<? extends Path> f39454i;

    /* renamed from: j  reason: collision with root package name */
    public Path f39455j;

    /* renamed from: k  reason: collision with root package name */
    public Path f39456k;

    /* renamed from: l  reason: collision with root package name */
    public Path f39457l;

    /* renamed from: m  reason: collision with root package name */
    public JumioCredentialPart f39458m;

    /* renamed from: n  reason: collision with root package name */
    public DocumentFormat f39459n;

    /* renamed from: o  reason: collision with root package name */
    public int f39460o;
    public int overlayBottomMargin;
    public int overlayBottomPixel;
    public int overlayHeight;
    public int overlayLeftMargin;
    public int overlayLeftPixel;
    public int overlayRightMargin;
    public int overlayRightPixel;
    public int overlayTopMargin;
    public int overlayTopPixel;

    /* renamed from: p  reason: collision with root package name */
    public int f39461p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f39462q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f39463r;

    /* renamed from: s  reason: collision with root package name */
    public final Map<Integer, Integer> f39464s;
    public ScanMode scanMode;
    public int topLeftCornerRadius;
    public int topRightCornerRadius;
    public boolean useCenterCrop;
    public final AtomicInteger visibility;
    public int width;

    public JVisionOverlay(MobileContext mobileContext) {
        this.f39446a = mobileContext;
        new Paint();
        this.f39453h = new Path();
        this.f39454i = CollectionsKt__CollectionsKt.k();
        this.f39455j = new Path();
        this.f39456k = new Path();
        this.f39457l = new Path();
        this.f39459n = DocumentFormat.NONE;
        this.visibility = new AtomicInteger();
        this.f39464s = Overlay.Companion.getCustomizations$jumio_core_release(this.f39446a);
    }

    public void addViews(ViewGroup viewGroup) {
    }

    public final float area(Rect rect) {
        return ((float) rect.width()) * ((float) rect.height());
    }

    public void calculate(Rect rect, Rect rect2) {
        this.width = rect.width();
        int height2 = rect.height();
        this.height = height2;
        boolean z11 = false;
        this.horizontalCrop = false;
        this.f39450e = rect2;
        if (this.useCenterCrop) {
            this.overlayLeftPixel = rect2.left;
            this.overlayRightPixel = rect2.right;
            this.overlayTopPixel = rect2.top;
            this.overlayBottomPixel = rect2.bottom;
            if (this.width > height2) {
                z11 = true;
            }
            this.horizontalCrop = z11;
            return;
        }
        DocumentFormat documentFormat = this.f39459n;
        if (documentFormat == DocumentFormat.NONE) {
            this.overlayLeftPixel = 0;
            this.overlayTopPixel = 0;
            this.overlayRightPixel = this.width;
            this.overlayBottomPixel = height2;
        } else if (documentFormat == DocumentFormat.ID1 || documentFormat == DocumentFormat.ID2) {
            int i11 = this.width;
            if (((float) i11) / ((float) height2) >= 1.3333334f) {
                this.overlayHeight = height2;
                int i12 = (height2 * 4) / 3;
                this.f39447b = i12;
                this.f39448c = rect2.top;
                this.f39449d = ((i11 - i12) / 2) + rect2.left;
            } else {
                this.f39447b = i11;
                int i13 = (i11 * 3) / 4;
                this.overlayHeight = i13;
                this.f39448c = ((height2 - i13) / 2) + rect2.top;
                this.f39449d = rect2.left;
            }
            this.overlayLeftMargin = documentFormat.getOverlayLeftInPx(this.f39447b);
            this.overlayRightMargin = this.f39459n.getOverlayRightInPx(this.f39447b);
            this.overlayTopMargin = this.f39459n.getOverlayTopInPx(this.overlayHeight);
            int overlayBottomInPx = this.f39459n.getOverlayBottomInPx(this.overlayHeight);
            this.overlayBottomMargin = overlayBottomInPx;
            int i14 = this.width;
            int i15 = this.overlayRightMargin;
            int i16 = this.f39449d;
            this.overlayRightPixel = i14 - (i15 + i16);
            int i17 = this.height;
            int i18 = this.f39448c;
            this.overlayBottomPixel = i17 - (overlayBottomInPx + i18);
            this.overlayLeftPixel = this.overlayLeftMargin + i16;
            this.overlayTopPixel = this.overlayTopMargin + i18;
        } else if (documentFormat == DocumentFormat.ID3) {
            this.overlayLeftMargin = documentFormat.getOverlayLeftInPx(this.width);
            this.overlayRightMargin = this.f39459n.getOverlayRightInPx(this.width);
            this.overlayTopMargin = this.f39459n.getOverlayTopInPx(this.height);
            this.overlayBottomMargin = this.f39459n.getOverlayBottomInPx(this.height);
            if (((double) (((float) this.width) / ((float) this.height))) >= this.f39459n.getOverlayRatio()) {
                this.f39448c = 0;
                this.f39449d = (this.width - ((((int) (this.f39459n.getOverlayRatio() * ((double) ((this.height - this.overlayTopMargin) - this.overlayBottomMargin)))) + this.overlayLeftMargin) + this.overlayRightMargin)) / 2;
            } else {
                this.f39449d = 0;
                int overlayRatio = (this.height - ((((int) (((double) ((this.width - this.overlayLeftMargin) - this.overlayRightMargin)) / this.f39459n.getOverlayRatio())) + this.overlayTopMargin) + this.overlayBottomMargin)) / 2;
                this.f39448c = overlayRatio;
                z11 = overlayRatio;
            }
            int i19 = this.width;
            int i21 = this.f39449d;
            this.f39447b = i19 - (i21 * 2);
            int i22 = this.height;
            int i23 = this.f39448c;
            this.overlayHeight = (i22 - i23) - (z11 ? 1 : 0);
            this.overlayRightPixel = (i19 - i21) - this.overlayRightMargin;
            this.overlayBottomPixel = (i22 - z11) - this.overlayBottomMargin;
            this.overlayLeftPixel = this.overlayLeftMargin + i21;
            this.overlayTopPixel = this.overlayTopMargin + i23;
        }
    }

    public void doDraw(Canvas canvas) {
        if (this.visibility.get() == 0 && this.f39463r) {
            if (!this.f39457l.isEmpty()) {
                canvas.drawPath(this.f39457l, this.f39452g);
            }
            if (!this.f39455j.isEmpty()) {
                canvas.drawPath(this.f39455j, this.f39451f);
            }
            if (!this.f39453h.isEmpty()) {
                canvas.drawPath(this.f39453h, this.borderPaint);
            }
            if (!this.f39454i.isEmpty()) {
                for (Path drawPath : this.f39454i) {
                    canvas.drawPath(drawPath, this.borderPaint);
                }
            }
            Log log = Log.INSTANCE;
            LogLevel logLevel = LogLevel.OFF;
        }
    }

    public final Paint getBackgroundPaint() {
        return this.f39452g;
    }

    public final JumioCredentialPart getCredentialPart() {
        return this.f39458m;
    }

    public final Rect getExtractionArea() {
        return this.f39450e;
    }

    public final Paint getLargeBorderPaint() {
        return this.f39451f;
    }

    public final int getLeftOffset() {
        return this.f39449d;
    }

    public final boolean getMirrorOverlay() {
        return this.f39462q;
    }

    public final MobileContext getMobileContext() {
        return this.f39446a;
    }

    public Rect getOverlayBounds() {
        return new Rect(this.overlayLeftPixel, this.overlayTopPixel, this.overlayRightPixel, this.overlayBottomPixel);
    }

    public final int getOverlayWidth() {
        return this.f39447b;
    }

    public final Map<Integer, Integer> getStyleMap() {
        return this.f39464s;
    }

    public final int getTopOffset() {
        return this.f39448c;
    }

    public void prepareDraw(boolean z11) {
        updateOverlayConfiguration(this.f39446a);
        this.f39462q = z11;
        Paint paint = this.borderPaint;
        Map<Integer, Integer> map = this.f39464s;
        int i11 = R.attr.jumio_scanOverlay;
        Integer num = map.get(Integer.valueOf(i11));
        paint.setColor(num != null ? num.intValue() : -1);
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setDither(true);
        this.borderPaint.setStrokeJoin(Paint.Join.ROUND);
        this.borderPaint.setStrokeCap(Paint.Cap.ROUND);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx((Context) this.f39446a, 2));
        Paint paint2 = this.f39451f;
        Integer num2 = this.f39464s.get(Integer.valueOf(i11));
        paint2.setColor(num2 != null ? num2.intValue() : Color.parseColor("#80000000"));
        this.f39451f.setAlpha(0);
        this.f39451f.setStyle(Paint.Style.STROKE);
        this.f39451f.setDither(true);
        this.f39451f.setStrokeJoin(Paint.Join.ROUND);
        this.f39451f.setStrokeCap(Paint.Cap.ROUND);
        this.f39451f.setAntiAlias(true);
        this.f39451f.setStrokeWidth((float) ScreenUtil.dpToPx((Context) this.f39446a, 6));
        Paint paint3 = this.f39452g;
        Integer num3 = this.f39464s.get(Integer.valueOf(R.attr.jumio_scanBackground));
        paint3.setColor(num3 != null ? num3.intValue() : Color.parseColor("#99000000"));
        this.f39452g.setStyle(Paint.Style.FILL);
        this.f39452g.setDither(true);
        this.f39452g.setStrokeJoin(Paint.Join.ROUND);
        this.f39452g.setStrokeCap(Paint.Cap.ROUND);
        this.f39452g.setAntiAlias(true);
        Log log = Log.INSTANCE;
        LogLevel logLevel = LogLevel.OFF;
        if (this.drawBrackets) {
            if (this.useCenterCrop) {
                this.f39454i = DrawingUtil.INSTANCE.createCroppedEdgePathListFromRect(getOverlayBounds(), this.horizontalCrop);
            } else {
                this.f39453h = DrawingUtil.INSTANCE.createRectWithRoundedCornersAsPath(getOverlayBounds(), this.topLeftCornerRadius, this.topRightCornerRadius, this.f39460o, this.f39461p);
            }
            int dpToPx = ScreenUtil.dpToPx((Context) this.f39446a, 4) / 2;
            Rect rect = new Rect(getOverlayBounds().left - dpToPx, getOverlayBounds().top - dpToPx, getOverlayBounds().right + dpToPx, getOverlayBounds().bottom + dpToPx);
            DrawingUtil drawingUtil = DrawingUtil.INSTANCE;
            this.f39455j = drawingUtil.createRectWithRoundedCornersAsPath(rect, this.topLeftCornerRadius + dpToPx, this.topRightCornerRadius + dpToPx, this.f39460o + dpToPx, this.f39461p + dpToPx);
            this.f39456k = drawingUtil.createRectWithRoundedCornersAsPath(new Rect(getOverlayBounds().left, getOverlayBounds().top, getOverlayBounds().right, getOverlayBounds().bottom), this.topLeftCornerRadius, this.topRightCornerRadius, this.f39460o, this.f39461p);
        } else {
            this.f39453h.reset();
        }
        if (this.dimBackground) {
            Path path = new Path();
            this.f39457l = path;
            path.setFillType(Path.FillType.EVEN_ODD);
            this.f39457l.addRect(0.0f, 0.0f, (float) this.width, (float) this.height, Path.Direction.CW);
            this.f39457l.addPath(this.f39456k);
        } else {
            this.f39457l.reset();
        }
        this.f39463r = true;
    }

    public final void setCredentialPart(JumioCredentialPart jumioCredentialPart) {
        this.f39458m = jumioCredentialPart;
    }

    public final void setExtractionArea(Rect rect) {
        this.f39450e = rect;
    }

    public final void setLeftOffset(int i11) {
        this.f39449d = i11;
    }

    public final void setMirrorOverlay(boolean z11) {
        this.f39462q = z11;
    }

    public final void setMobileContext(MobileContext mobileContext) {
        this.f39446a = mobileContext;
    }

    public final void setOverlayWidth(int i11) {
        this.f39447b = i11;
    }

    public void setScanPart(ScanPartModel scanPartModel) {
        this.scanMode = scanPartModel.getMode();
        this.f39458m = scanPartModel.getCredentialPart();
        if (scanPartModel instanceof PhysicalIdScanPartModel) {
            DocumentFormat format = ((PhysicalIdScanPartModel) scanPartModel).getFormat();
            this.f39459n = format;
            this.useCenterCrop = this.useCenterCrop && format != DocumentFormat.NONE;
        }
        updateOverlayConfiguration(this.f39446a);
    }

    public final void setTopOffset(int i11) {
        this.f39448c = i11;
    }

    public void setVisible(int i11) {
        this.visibility.set(i11);
    }

    public void update(ExtractionUpdateInterface<?> extractionUpdateInterface) {
    }

    public void updateOverlayConfiguration(Context context) {
        boolean z11 = true;
        if (this.useCenterCrop) {
            if (((this.f39450e.isEmpty() || this.width == 0 || this.height == 0) ? 0.0f : (((float) this.f39450e.width()) * ((float) this.f39450e.height())) / (((float) this.width) * ((float) this.height))) > 0.76f) {
                z11 = false;
            }
            this.dimBackground = z11;
            this.drawBrackets = z11;
            this.detectLines = false;
            this.topLeftCornerRadius = 0;
            this.topRightCornerRadius = 0;
            this.f39460o = 0;
            this.f39461p = 0;
            return;
        }
        DocumentFormat documentFormat = this.f39459n;
        if (documentFormat == DocumentFormat.ID1 || documentFormat == DocumentFormat.ID2) {
            this.drawBrackets = true;
            this.dimBackground = true;
            this.detectLines = false;
            int dpToPx = ScreenUtil.dpToPx(context, 16);
            this.topLeftCornerRadius = dpToPx;
            this.topRightCornerRadius = dpToPx;
            this.f39460o = dpToPx;
            this.f39461p = dpToPx;
        } else if (documentFormat == DocumentFormat.ID3) {
            this.drawBrackets = true;
            this.dimBackground = true;
            this.detectLines = false;
            this.topLeftCornerRadius = 0;
            this.topRightCornerRadius = 0;
            int dpToPx2 = ScreenUtil.dpToPx(context, 16);
            this.f39460o = dpToPx2;
            this.f39461p = dpToPx2;
        } else {
            this.drawBrackets = false;
            this.dimBackground = false;
            this.detectLines = false;
        }
    }
}
