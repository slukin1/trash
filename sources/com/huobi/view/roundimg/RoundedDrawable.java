package com.huobi.view.roundimg;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

public class RoundedDrawable extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "RoundedDrawable";
    private final Bitmap mBitmap;
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final RectF mBitmapRect;
    private final int mBitmapWidth;
    private ColorStateList mBorderColor;
    private final Paint mBorderPaint;
    private final RectF mBorderRect;
    private float mBorderWidth;
    private final RectF mBounds = new RectF();
    private float mCornerRadius;
    private final boolean[] mCornersRounded;
    private final RectF mDrawableRect = new RectF();
    private boolean mOval;
    private boolean mRebuildShader;
    private ImageView.ScaleType mScaleType;
    private final Matrix mShaderMatrix;
    private final RectF mSquareCornersRect;
    private Shader.TileMode mTileModeX;
    private Shader.TileMode mTileModeY;

    /* renamed from: com.huobi.view.roundimg.RoundedDrawable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.roundimg.RoundedDrawable.AnonymousClass1.<clinit>():void");
        }
    }

    public RoundedDrawable(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.mBitmapRect = rectF;
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mSquareCornersRect = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mTileModeX = tileMode;
        this.mTileModeY = tileMode;
        this.mRebuildShader = true;
        this.mCornerRadius = 0.0f;
        this.mCornersRounded = new boolean[]{true, true, true, true};
        this.mOval = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = ColorStateList.valueOf(DEFAULT_BORDER_COLOR);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mBitmap = bitmap;
        int width = bitmap.getWidth();
        this.mBitmapWidth = width;
        int height = bitmap.getHeight();
        this.mBitmapHeight = height;
        rectF.set(0.0f, 0.0f, (float) width, (float) height);
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.mBorderColor.getColorForState(getState(), DEFAULT_BORDER_COLOR));
        paint2.setStrokeWidth(this.mBorderWidth);
    }

    private static boolean all(boolean[] zArr) {
        for (boolean z11 : zArr) {
            if (z11) {
                return false;
            }
        }
        return true;
    }

    private static boolean any(boolean[] zArr) {
        for (boolean z11 : zArr) {
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e11) {
            e11.printStackTrace();
            Log.w(TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static RoundedDrawable fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static Drawable fromDrawable(Drawable drawable) {
        if (drawable == null || (drawable instanceof RoundedDrawable)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i11 = 0; i11 < numberOfLayers; i11++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i11), fromDrawable(layerDrawable.getDrawable(i11)));
            }
            return layerDrawable;
        }
        Bitmap drawableToBitmap = drawableToBitmap(drawable);
        return drawableToBitmap != null ? new RoundedDrawable(drawableToBitmap) : drawable;
    }

    private static boolean only(int i11, boolean[] zArr) {
        int length = zArr.length;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i12 >= length) {
                return true;
            }
            boolean z12 = zArr[i12];
            if (i12 != i11) {
                z11 = false;
            }
            if (z12 != z11) {
                return false;
            }
            i12++;
        }
    }

    private void redrawBitmapForSquareCorners(Canvas canvas) {
        if (!all(this.mCornersRounded) && this.mCornerRadius != 0.0f) {
            RectF rectF = this.mDrawableRect;
            float f11 = rectF.left;
            float f12 = rectF.top;
            float width = rectF.width() + f11;
            float height = this.mDrawableRect.height() + f12;
            float f13 = this.mCornerRadius;
            if (!this.mCornersRounded[0]) {
                this.mSquareCornersRect.set(f11, f12, f11 + f13, f12 + f13);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[1]) {
                this.mSquareCornersRect.set(width - f13, f12, width, f13);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[2]) {
                this.mSquareCornersRect.set(width - f13, height - f13, width, height);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
            if (!this.mCornersRounded[3]) {
                this.mSquareCornersRect.set(f11, height - f13, f13 + f11, height);
                canvas.drawRect(this.mSquareCornersRect, this.mBitmapPaint);
            }
        }
    }

    private void redrawBorderForSquareCorners(Canvas canvas) {
        float f11;
        if (!all(this.mCornersRounded) && this.mCornerRadius != 0.0f) {
            RectF rectF = this.mDrawableRect;
            float f12 = rectF.left;
            float f13 = rectF.top;
            float width = rectF.width() + f12;
            float height = f13 + this.mDrawableRect.height();
            float f14 = this.mCornerRadius;
            float f15 = this.mBorderWidth / 2.0f;
            if (!this.mCornersRounded[0]) {
                Canvas canvas2 = canvas;
                canvas2.drawLine(f12 - f15, f13, f12 + f14, f13, this.mBorderPaint);
                canvas2.drawLine(f12, f13 - f15, f12, f13 + f14, this.mBorderPaint);
            }
            if (!this.mCornersRounded[1]) {
                Canvas canvas3 = canvas;
                float f16 = width;
                canvas3.drawLine((width - f14) - f15, f13, f16, f13, this.mBorderPaint);
                canvas3.drawLine(width, f13 - f15, f16, f13 + f14, this.mBorderPaint);
            }
            if (!this.mCornersRounded[2]) {
                f11 = f14;
                canvas.drawLine((width - f14) - f15, height, width + f15, height, this.mBorderPaint);
                canvas.drawLine(width, height - f11, width, height, this.mBorderPaint);
            } else {
                f11 = f14;
            }
            if (!this.mCornersRounded[3]) {
                canvas.drawLine(f12 - f15, height, f12 + f11, height, this.mBorderPaint);
                canvas.drawLine(f12, height - f11, f12, height, this.mBorderPaint);
            }
        }
    }

    private void updateShaderMatrix() {
        float f11;
        float f12;
        float f13;
        int i11 = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (i11 == 1) {
            this.mBorderRect.set(this.mBounds);
            RectF rectF = this.mBorderRect;
            float f14 = this.mBorderWidth;
            rectF.inset(f14 / 2.0f, f14 / 2.0f);
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setTranslate((float) ((int) (((this.mBorderRect.width() - ((float) this.mBitmapWidth)) * 0.5f) + 0.5f)), (float) ((int) (((this.mBorderRect.height() - ((float) this.mBitmapHeight)) * 0.5f) + 0.5f)));
        } else if (i11 == 2) {
            this.mBorderRect.set(this.mBounds);
            RectF rectF2 = this.mBorderRect;
            float f15 = this.mBorderWidth;
            rectF2.inset(f15 / 2.0f, f15 / 2.0f);
            this.mShaderMatrix.reset();
            float f16 = 0.0f;
            if (((float) this.mBitmapWidth) * this.mBorderRect.height() > this.mBorderRect.width() * ((float) this.mBitmapHeight)) {
                f12 = this.mBorderRect.height() / ((float) this.mBitmapHeight);
                f11 = 0.0f;
                f16 = (this.mBorderRect.width() - (((float) this.mBitmapWidth) * f12)) * 0.5f;
            } else {
                f12 = this.mBorderRect.width() / ((float) this.mBitmapWidth);
                f11 = (this.mBorderRect.height() - (((float) this.mBitmapHeight) * f12)) * 0.5f;
            }
            this.mShaderMatrix.setScale(f12, f12);
            Matrix matrix = this.mShaderMatrix;
            float f17 = this.mBorderWidth;
            matrix.postTranslate(((float) ((int) (f16 + 0.5f))) + (f17 / 2.0f), ((float) ((int) (f11 + 0.5f))) + (f17 / 2.0f));
        } else if (i11 == 3) {
            this.mShaderMatrix.reset();
            if (((float) this.mBitmapWidth) > this.mBounds.width() || ((float) this.mBitmapHeight) > this.mBounds.height()) {
                f13 = Math.min(this.mBounds.width() / ((float) this.mBitmapWidth), this.mBounds.height() / ((float) this.mBitmapHeight));
            } else {
                f13 = 1.0f;
            }
            this.mShaderMatrix.setScale(f13, f13);
            this.mShaderMatrix.postTranslate((float) ((int) (((this.mBounds.width() - (((float) this.mBitmapWidth) * f13)) * 0.5f) + 0.5f)), (float) ((int) (((this.mBounds.height() - (((float) this.mBitmapHeight) * f13)) * 0.5f) + 0.5f)));
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF3 = this.mBorderRect;
            float f18 = this.mBorderWidth;
            rectF3.inset(f18 / 2.0f, f18 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i11 == 5) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF4 = this.mBorderRect;
            float f19 = this.mBorderWidth;
            rectF4.inset(f19 / 2.0f, f19 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i11 == 6) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF5 = this.mBorderRect;
            float f21 = this.mBorderWidth;
            rectF5.inset(f21 / 2.0f, f21 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else if (i11 != 7) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF6 = this.mBorderRect;
            float f22 = this.mBorderWidth;
            rectF6.inset(f22 / 2.0f, f22 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        } else {
            this.mBorderRect.set(this.mBounds);
            RectF rectF7 = this.mBorderRect;
            float f23 = this.mBorderWidth;
            rectF7.inset(f23 / 2.0f, f23 / 2.0f);
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
        }
        this.mDrawableRect.set(this.mBorderRect);
        this.mRebuildShader = true;
    }

    public void draw(Canvas canvas) {
        if (this.mRebuildShader) {
            BitmapShader bitmapShader = new BitmapShader(this.mBitmap, this.mTileModeX, this.mTileModeY);
            Shader.TileMode tileMode = this.mTileModeX;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.mTileModeY == tileMode2) {
                bitmapShader.setLocalMatrix(this.mShaderMatrix);
            }
            this.mBitmapPaint.setShader(bitmapShader);
            this.mRebuildShader = false;
        }
        if (this.mOval) {
            if (this.mBorderWidth > 0.0f) {
                canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                canvas.drawOval(this.mBorderRect, this.mBorderPaint);
                return;
            }
            canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
        } else if (any(this.mCornersRounded)) {
            float f11 = this.mCornerRadius;
            if (this.mBorderWidth > 0.0f) {
                canvas.drawRoundRect(this.mDrawableRect, f11, f11, this.mBitmapPaint);
                canvas.drawRoundRect(this.mBorderRect, f11, f11, this.mBorderPaint);
                redrawBitmapForSquareCorners(canvas);
                redrawBorderForSquareCorners(canvas);
                return;
            }
            canvas.drawRoundRect(this.mDrawableRect, f11, f11, this.mBitmapPaint);
            redrawBitmapForSquareCorners(canvas);
        } else {
            canvas.drawRect(this.mDrawableRect, this.mBitmapPaint);
            if (this.mBorderWidth > 0.0f) {
                canvas.drawRect(this.mBorderRect, this.mBorderPaint);
            }
        }
    }

    public int getAlpha() {
        return this.mBitmapPaint.getAlpha();
    }

    public int getBorderColor() {
        return this.mBorderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public ColorFilter getColorFilter() {
        return this.mBitmapPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Bitmap getSourceBitmap() {
        return this.mBitmap;
    }

    public Shader.TileMode getTileModeX() {
        return this.mTileModeX;
    }

    public Shader.TileMode getTileModeY() {
        return this.mTileModeY;
    }

    public boolean isOval() {
        return this.mOval;
    }

    public boolean isStateful() {
        return this.mBorderColor.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        updateShaderMatrix();
    }

    public boolean onStateChange(int[] iArr) {
        int colorForState = this.mBorderColor.getColorForState(iArr, 0);
        if (this.mBorderPaint.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.mBorderPaint.setColor(colorForState);
        return true;
    }

    public void setAlpha(int i11) {
        this.mBitmapPaint.setAlpha(i11);
        invalidateSelf();
    }

    public RoundedDrawable setBorderColor(int i11) {
        return setBorderColor(ColorStateList.valueOf(i11));
    }

    public RoundedDrawable setBorderWidth(float f11) {
        this.mBorderWidth = f11;
        this.mBorderPaint.setStrokeWidth(f11);
        return this;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public RoundedDrawable setCornerRadius(float f11) {
        setCornerRadius(f11, f11, f11, f11);
        return this;
    }

    public void setDither(boolean z11) {
        this.mBitmapPaint.setDither(z11);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z11) {
        this.mBitmapPaint.setFilterBitmap(z11);
        invalidateSelf();
    }

    public RoundedDrawable setOval(boolean z11) {
        this.mOval = z11;
        return this;
    }

    public RoundedDrawable setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            updateShaderMatrix();
        }
        return this;
    }

    public RoundedDrawable setTileModeX(Shader.TileMode tileMode) {
        if (this.mTileModeX != tileMode) {
            this.mTileModeX = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    public RoundedDrawable setTileModeY(Shader.TileMode tileMode) {
        if (this.mTileModeY != tileMode) {
            this.mTileModeY = tileMode;
            this.mRebuildShader = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap toBitmap() {
        return drawableToBitmap(this);
    }

    public float getCornerRadius(int i11) {
        if (this.mCornersRounded[i11]) {
            return this.mCornerRadius;
        }
        return 0.0f;
    }

    public RoundedDrawable setBorderColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBorderColor = colorStateList;
        this.mBorderPaint.setColor(colorStateList.getColorForState(getState(), DEFAULT_BORDER_COLOR));
        return this;
    }

    public RoundedDrawable setCornerRadius(int i11, float f11) {
        int i12 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i12 != 0) {
            float f12 = this.mCornerRadius;
            if (!(f12 == 0.0f || f12 == f11)) {
                throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
            }
        }
        if (i12 == 0) {
            if (only(i11, this.mCornersRounded)) {
                this.mCornerRadius = 0.0f;
            }
            this.mCornersRounded[i11] = false;
        } else {
            if (this.mCornerRadius == 0.0f) {
                this.mCornerRadius = f11;
            }
            this.mCornersRounded[i11] = true;
        }
        return this;
    }

    public RoundedDrawable setCornerRadius(float f11, float f12, float f13, float f14) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f11));
        hashSet.add(Float.valueOf(f12));
        hashSet.add(Float.valueOf(f13));
        hashSet.add(Float.valueOf(f14));
        hashSet.remove(Float.valueOf(0.0f));
        boolean z11 = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                this.mCornerRadius = floatValue;
            } else {
                this.mCornerRadius = 0.0f;
            }
            boolean[] zArr = this.mCornersRounded;
            zArr[0] = f11 > 0.0f;
            zArr[1] = f12 > 0.0f;
            zArr[2] = f13 > 0.0f;
            if (f14 <= 0.0f) {
                z11 = false;
            }
            zArr[3] = z11;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }
}
