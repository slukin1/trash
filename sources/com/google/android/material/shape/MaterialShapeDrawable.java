package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.util.b;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;
import u0.f;

public class MaterialShapeDrawable extends Drawable implements f, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = MaterialShapeDrawable.class.getSimpleName();
    private static final Paint clearPaint = new Paint(1);
    /* access modifiers changed from: private */
    public final BitSet containsIncompatibleShadowOp;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    private final RectF pathBounds;
    /* access modifiers changed from: private */
    public boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.PorterDuffColorFilter calculatePaintColorTintFilter(android.graphics.Paint r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0014
            int r2 = r2.getColor()
            int r3 = r1.compositeElevationOverlayIfNeeded(r2)
            if (r3 == r2) goto L_0x0014
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r0)
            return r2
        L_0x0014:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.calculatePaintColorTintFilter(android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    private void calculatePath(RectF rectF2, Path path2) {
        calculatePathForSize(rectF2, path2);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            Matrix matrix2 = this.matrix;
            float f11 = this.drawableState.scale;
            matrix2.setScale(f11, f11, rectF2.width() / 2.0f, rectF2.height() / 2.0f);
            path2.transform(this.matrix);
        }
        path2.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        final float f11 = -getStrokeInsetLength();
        ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            public CornerSize apply(CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(f11, cornerSize);
            }
        });
        this.strokeShapeAppearance = withTransformedCornerSizes;
        this.pathProvider.calculatePath(withTransformedCornerSizes, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z11) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z11) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z11) {
        if (colorStateList == null || mode == null) {
            return calculatePaintColorTintFilter(paint, z11);
        }
        return calculateTintColorTintFilter(colorStateList, mode, z11);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i11 = 0; i11 < 4; i11++) {
            this.cornerShadowOperation[i11].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i11].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.path, clearPaint);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    private void drawFillShape(Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    private void drawStrokeShape(Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        int i11 = materialShapeDrawableState.shadowCompatMode;
        if (i11 == 1 || materialShapeDrawableState.shadowCompatRadius <= 0 || (i11 != 2 && !requiresCompatShadow())) {
            return false;
        }
        return true;
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.paintStyle;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.paintStyle;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.pathBounds.width() - ((float) getBounds().width()));
            int height = (int) (this.pathBounds.height() - ((float) getBounds().height()));
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f11 = (float) ((getBounds().left - this.drawableState.shadowCompatRadius) - width);
            float f12 = (float) ((getBounds().top - this.drawableState.shadowCompatRadius) - height);
            canvas2.translate(-f11, -f12);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f11, f12, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i11, int i12) {
        return (i11 * (i12 + (i12 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(Canvas canvas) {
        int shadowOffsetX = getShadowOffsetX();
        int shadowOffsetY = getShadowOffsetY();
        if (Build.VERSION.SDK_INT < 21 && this.shadowBitmapDrawingEnable) {
            Rect clipBounds = canvas.getClipBounds();
            int i11 = this.drawableState.shadowCompatRadius;
            clipBounds.inset(-i11, -i11);
            clipBounds.offset(shadowOffsetX, shadowOffsetY);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z11;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || (color2 = this.fillPaint.getColor()) == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, color2))) {
            z11 = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z11 = true;
        }
        if (this.drawableState.strokeColor == null || (color = this.strokePaint.getColor()) == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, color))) {
            return z11;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.tintFilter = calculateTintFilter(materialShapeDrawableState.tintList, materialShapeDrawableState.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(materialShapeDrawableState2.strokeTintList, materialShapeDrawableState2.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
        if (materialShapeDrawableState3.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(materialShapeDrawableState3.tintList.getColorForState(getState(), 0));
        }
        if (!b.a(porterDuffColorFilter, this.tintFilter) || !b.a(porterDuffColorFilter2, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    private void updateZ() {
        float z11 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil((double) (0.75f * z11));
        this.drawableState.shadowCompatOffset = (int) Math.ceil((double) (z11 * 0.25f));
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public final void calculatePathForSize(RectF rectF2, Path path2) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
        float f11 = materialShapeDrawableState.interpolation;
        shapeAppearancePathProvider.calculatePath(shapeAppearanceModel, f11, rectF2, this.pathShadowListener, path2);
    }

    public int compositeElevationOverlayIfNeeded(int i11) {
        float z11 = getZ() + getParentAbsoluteElevation();
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i11, z11) : i11;
    }

    public void draw(Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    public void drawShape(Canvas canvas, Paint paint, Path path2, RectF rectF2) {
        drawShape(canvas, paint, path2, this.drawableState.shapeAppearanceModel, rectF2);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.drawableState.shadowCompatMode != 2) {
            if (isRoundRect()) {
                outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
                return;
            }
            calculatePath(getBoundsAsRectF(), this.path);
            if (this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.path);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated
    public void getPathForSize(int i11, int i12, Path path2) {
        calculatePathForSize(new RectF(0.0f, 0.0f, (float) i11, (float) i12), path2);
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (((double) materialShapeDrawableState.shadowCompatOffset) * Math.sin(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (((double) materialShapeDrawableState.shadowCompatOffset) * Math.cos(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.elevationOverlayProvider != null;
    }

    public boolean isPointInTransparentRegion(int i11, int i12) {
        return getTransparentRegion().contains(i11, i12);
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i11 = this.drawableState.shadowCompatMode;
        return i11 == 0 || i11 == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r1.drawableState.strokeColor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.drawableState.fillColor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.drawableState.tintList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.drawableState.strokeTintList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0039
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.drawableState
            android.content.res.ColorStateList r0 = r0.tintList
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x0012:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.drawableState
            android.content.res.ColorStateList r0 = r0.strokeTintList
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x001e:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.drawableState
            android.content.res.ColorStateList r0 = r0.strokeColor
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x002a:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.drawableState
            android.content.res.ColorStateList r0 = r0.fillColor
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.isStateful():boolean");
    }

    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z11 = updateColorsForState(iArr) || updateTintFilter();
        if (z11) {
            invalidateSelf();
        }
        return z11;
    }

    public boolean requiresCompatShadow() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 < 21 || (!isRoundRect() && !this.path.isConvex() && i11 < 29);
    }

    public void setAlpha(int i11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i11) {
            materialShapeDrawableState.alpha = i11;
            invalidateSelfIgnoreShape();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f11) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f11));
    }

    public void setEdgeIntersectionCheckEnable(boolean z11) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z11);
    }

    public void setElevation(float f11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f11) {
            materialShapeDrawableState.elevation = f11;
            updateZ();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f11) {
            materialShapeDrawableState.interpolation = f11;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        this.drawableState.padding.set(i11, i12, i13, i14);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.paintStyle = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.parentAbsoluteElevation != f11) {
            materialShapeDrawableState.parentAbsoluteElevation = f11;
            updateZ();
        }
    }

    public void setScale(float f11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.scale != f11) {
            materialShapeDrawableState.scale = f11;
            invalidateSelf();
        }
    }

    public void setShadowBitmapDrawingEnable(boolean z11) {
        this.shadowBitmapDrawingEnable = z11;
    }

    public void setShadowColor(int i11) {
        this.shadowRenderer.setShadowColor(i11);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatRotation != i11) {
            materialShapeDrawableState.shadowCompatRotation = i11;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != i11) {
            materialShapeDrawableState.shadowCompatMode = i11;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i11) {
        setElevation((float) i11);
    }

    @Deprecated
    public void setShadowEnabled(boolean z11) {
        setShadowCompatibilityMode(z11 ^ true ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i11) {
        this.drawableState.shadowCompatRadius = i11;
    }

    public void setShadowVerticalOffset(int i11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatOffset != i11) {
            materialShapeDrawableState.shadowCompatOffset = i11;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f11, int i11) {
        setStrokeWidth(f11);
        setStrokeColor(ColorStateList.valueOf(i11));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.strokeTintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f11) {
        this.drawableState.strokeWidth = f11;
        invalidateSelf();
    }

    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.translationZ != f11) {
            materialShapeDrawableState.translationZ = f11;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.useTintColorForShadow != z11) {
            materialShapeDrawableState.useTintColorForShadow = z11;
            invalidateSelf();
        }
    }

    public void setZ(float f11) {
        setTranslationZ(f11 - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f11) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f11);
        return materialShapeDrawable;
    }

    private void drawShape(Canvas canvas, Paint paint, Path path2, ShapeAppearanceModel shapeAppearanceModel, RectF rectF2) {
        if (shapeAppearanceModel.isRoundRect(rectF2)) {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF2) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF2, cornerSize, cornerSize, paint);
            return;
        }
        canvas.drawPath(path2, paint);
    }

    public void setCornerSize(CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(cornerSize));
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i11, int i12) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build());
    }

    public void setStroke(float f11, ColorStateList colorStateList) {
        setStrokeWidth(f11);
        setStrokeColor(colorStateList);
    }

    @Deprecated
    public MaterialShapeDrawable(ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStrokeTint(int i11) {
        setStrokeTint(ColorStateList.valueOf(i11));
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, (ElevationOverlayProvider) null));
    }

    private MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = clearPaint;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new ShapeAppearancePathProvider.PathListener() {
            public void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i11) {
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i11, shapePath.containsIncompatibleShadowOp());
                MaterialShapeDrawable.this.cornerShadowOperation[i11] = shapePath.createShadowCompatOperation(matrix);
            }

            public void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i11) {
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i11 + 4, shapePath.containsIncompatibleShadowOp());
                MaterialShapeDrawable.this.edgeShadowOperation[i11] = shapePath.createShadowCompatOperation(matrix);
            }
        };
    }

    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha = 255;
        public ColorFilter colorFilter;
        public float elevation = 0.0f;
        public ElevationOverlayProvider elevationOverlayProvider;
        public ColorStateList fillColor = null;
        public float interpolation = 1.0f;
        public Rect padding = null;
        public Paint.Style paintStyle = Paint.Style.FILL_AND_STROKE;
        public float parentAbsoluteElevation = 0.0f;
        public float scale = 1.0f;
        public int shadowCompatMode = 0;
        public int shadowCompatOffset = 0;
        public int shadowCompatRadius = 0;
        public int shadowCompatRotation = 0;
        public ShapeAppearanceModel shapeAppearanceModel;
        public ColorStateList strokeColor = null;
        public ColorStateList strokeTintList = null;
        public float strokeWidth;
        public ColorStateList tintList = null;
        public PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
        public float translationZ = 0.0f;
        public boolean useTintColorForShadow = false;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel2, ElevationOverlayProvider elevationOverlayProvider2) {
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.elevationOverlayProvider = elevationOverlayProvider2;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            boolean unused = materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }
    }
}
