package com.google.zxing.client.android;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.camera.CameraManager;
import com.hbg.lib.common.utils.PixelUtils;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public final class ViewfinderView extends View {
    private static final long ANIMATION_DELAY = 80;
    private static final int CURRENT_POINT_OPACITY = 160;
    private static final int MAX_RESULT_POINTS = 20;
    private static final int POINT_SIZE = 6;
    private static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    public static final int style_gridding = 0;
    public static final int style_hybrid = 2;
    public static final int style_radar = 1;
    private int SCAN_VELOCITY;
    private CameraManager cameraManager;
    private int frameColor;
    private Path framePath;
    private Paint framePathPaint;
    private int framePathWith;
    private int innerCornerColor;
    private int innerCornerLength;
    private int innerCornerWidth;
    private boolean isCircle;
    private final int laserColor;
    private List<ResultPoint> lastPossibleResultPoints;
    private int leftPadding;
    private int mBoundaryColor = -1;
    private float mBoundaryStrokeWidth = 8.0f;
    private float mCornerLineLenRatio = 0.06f;
    private int mFirstScancolor;
    private int mGriddingDensity = 40;
    private float mGriddingLineWidth = 1.0f;
    private Path mGriddingPath;
    /* access modifiers changed from: private */
    public LinearGradient mLinearGradient_Gridding;
    /* access modifiers changed from: private */
    public LinearGradient mLinearGradient_Radar;
    private int mScanAnimatorDuration = 1800;
    /* access modifiers changed from: private */
    public Matrix mScanMatrix;
    private Paint mScanPaint_Gridding;
    private Paint mScanPaint_Radio;
    private int mScanStyle = 2;
    private int mScancolor;
    private int mSecondScancolor;
    private int mThirdScancolor;
    private ValueAnimator mValueAnimator;
    private final int maskColor;
    private final Paint paint = new Paint(1);
    private List<ResultPoint> possibleResultPoints;
    private int rectRadius;
    private Bitmap resultBitmap;
    private final int resultColor;
    private final int resultPointColor;
    private Bitmap scanLight;
    private int scanLineTop;
    private int scannerAlpha;
    private String textHint;
    private int textHintBgColor;
    private int textHintColor;
    private int textHintHeight;
    private int textHintMarginTop;
    private int textHintTextSize;
    private int topPadding;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.maskColor = resources.getColor(R.color.viewfinder_mask);
        this.resultColor = resources.getColor(R.color.result_view);
        this.laserColor = resources.getColor(R.color.viewfinder_laser);
        this.resultPointColor = resources.getColor(R.color.possible_result_points);
        this.scannerAlpha = 0;
        this.possibleResultPoints = new ArrayList(5);
        this.lastPossibleResultPoints = null;
        this.innerCornerColor = ContextCompat.getColor(context, R.color.viewfinder_corner_color);
        this.innerCornerLength = PixelUtils.a(16.0f);
        this.innerCornerWidth = PixelUtils.a(2.5f);
        this.SCAN_VELOCITY = 4;
        this.textHintBgColor = ContextCompat.getColor(context, R.color.scan_text_hint_bg);
        this.textHintMarginTop = PixelUtils.a(15.0f);
        this.textHintHeight = PixelUtils.a(30.0f);
        this.textHintColor = ContextCompat.getColor(context, R.color.scan_text_hint_text_color);
        this.textHint = "";
        this.textHintTextSize = PixelUtils.a(14.0f);
        this.leftPadding = PixelUtils.a(30.0f);
        this.topPadding = PixelUtils.a(15.0f);
        Paint paint2 = new Paint(1);
        this.mScanPaint_Gridding = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mScanPaint_Gridding.setStrokeWidth(this.mGriddingLineWidth);
        Paint paint3 = new Paint(1);
        this.mScanPaint_Radio = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mScancolor = resources.getColor(R.color.viewfinder_grid_color);
        this.mFirstScancolor = resources.getColor(R.color.viewfinder_grid_first_color);
        this.mSecondScancolor = resources.getColor(R.color.viewfinder_grid_second_color);
        this.mThirdScancolor = resources.getColor(R.color.viewfinder_grid_third_color);
        Matrix matrix = new Matrix();
        this.mScanMatrix = matrix;
        matrix.setTranslate(0.0f, 30.0f);
        this.framePath = new Path();
        this.framePathPaint = new Paint();
        this.frameColor = ContextCompat.getColor(context, R.color.viewfinder_frame_color);
        this.framePathWith = PixelUtils.a(0.5f);
        this.rectRadius = PixelUtils.a(2.5f);
    }

    private void drawFrameBounds(Canvas canvas, Rect rect) {
        this.framePathPaint.setColor(this.frameColor);
        this.framePathPaint.setStyle(Paint.Style.STROKE);
        this.framePathPaint.setStrokeWidth((float) this.framePathWith);
        this.framePath.moveTo((float) rect.left, (float) rect.top);
        this.framePath.lineTo((float) rect.left, (float) rect.bottom);
        this.framePath.lineTo((float) rect.right, (float) rect.bottom);
        this.framePath.lineTo((float) rect.right, (float) rect.top);
        this.framePath.lineTo((float) rect.left, (float) rect.top);
        canvas.drawPath(this.framePath, this.framePathPaint);
        this.paint.setColor(this.innerCornerColor);
        this.paint.setStyle(Paint.Style.FILL);
        int i11 = this.innerCornerWidth;
        int i12 = this.innerCornerLength;
        int i13 = rect.left;
        int i14 = rect.top;
        RectF rectF = new RectF((float) i13, (float) i14, (float) (i13 + i11), (float) (i14 + i12));
        int i15 = this.rectRadius;
        canvas.drawRoundRect(rectF, (float) i15, (float) i15, this.paint);
        int i16 = rect.left;
        int i17 = rect.top;
        RectF rectF2 = new RectF((float) i16, (float) i17, (float) (i16 + i12), (float) (i17 + i11));
        int i18 = this.rectRadius;
        canvas.drawRoundRect(rectF2, (float) i18, (float) i18, this.paint);
        int i19 = rect.right;
        int i21 = rect.top;
        RectF rectF3 = new RectF((float) (i19 - i11), (float) i21, (float) i19, (float) (i21 + i12));
        int i22 = this.rectRadius;
        canvas.drawRoundRect(rectF3, (float) i22, (float) i22, this.paint);
        int i23 = rect.right;
        int i24 = rect.top;
        RectF rectF4 = new RectF((float) (i23 - i12), (float) i24, (float) i23, (float) (i24 + i11));
        int i25 = this.rectRadius;
        canvas.drawRoundRect(rectF4, (float) i25, (float) i25, this.paint);
        int i26 = rect.left;
        int i27 = rect.bottom;
        RectF rectF5 = new RectF((float) i26, (float) (i27 - i12), (float) (i26 + i11), (float) i27);
        int i28 = this.rectRadius;
        canvas.drawRoundRect(rectF5, (float) i28, (float) i28, this.paint);
        int i29 = rect.left;
        int i30 = rect.bottom;
        RectF rectF6 = new RectF((float) i29, (float) (i30 - i11), (float) (i29 + i12), (float) i30);
        int i31 = this.rectRadius;
        canvas.drawRoundRect(rectF6, (float) i31, (float) i31, this.paint);
        int i32 = rect.right;
        int i33 = rect.bottom;
        RectF rectF7 = new RectF((float) (i32 - i11), (float) (i33 - i12), (float) i32, (float) i33);
        int i34 = this.rectRadius;
        canvas.drawRoundRect(rectF7, (float) i34, (float) i34, this.paint);
        int i35 = rect.right;
        int i36 = rect.bottom;
        RectF rectF8 = new RectF((float) (i35 - i12), (float) (i36 - i11), (float) i35, (float) i36);
        int i37 = this.rectRadius;
        canvas.drawRoundRect(rectF8, (float) i37, (float) i37, this.paint);
    }

    private void drawScanLight(Canvas canvas, Rect rect) {
        if (this.scanLineTop == 0) {
            this.scanLineTop = rect.top;
        }
        int i11 = this.scanLineTop;
        if (i11 >= rect.bottom - 30) {
            this.scanLineTop = rect.top;
        } else {
            this.scanLineTop = i11 + this.SCAN_VELOCITY;
        }
        int i12 = rect.left;
        int i13 = this.scanLineTop;
        canvas.drawBitmap(this.scanLight, (Rect) null, new Rect(i12, i13, rect.right, i13 + 30), this.paint);
    }

    private void drawTextHint(Canvas canvas, Rect rect) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setFlags(1);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(this.textHintColor);
        textPaint.setTextSize((float) this.textHintTextSize);
        textPaint.getFontMetrics(new Paint.FontMetrics());
        float f11 = (float) rect.left;
        float f12 = (float) (rect.bottom + this.textHintMarginTop);
        StaticLayout staticLayout = new StaticLayout(this.textHint, textPaint, rect.width(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        canvas.save();
        canvas.translate(f11, f12);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private void initBoundaryAndAnimator(Rect rect) {
        if (this.mValueAnimator == null) {
            initScanValueAnim(rect.height());
        }
    }

    private void initGriddingPathAndStyle(Rect rect) {
        if (this.mGriddingPath == null) {
            this.mGriddingPath = new Path();
            float width = ((float) rect.width()) / (((float) this.mGriddingDensity) + 0.0f);
            float height = ((float) rect.height()) / (((float) this.mGriddingDensity) + 0.0f);
            for (int i11 = 0; i11 <= this.mGriddingDensity; i11++) {
                float f11 = ((float) i11) * width;
                this.mGriddingPath.moveTo(((float) rect.left) + f11, (float) rect.top);
                this.mGriddingPath.lineTo(((float) rect.left) + f11, (float) rect.bottom);
            }
            for (int i12 = 0; i12 <= this.mGriddingDensity; i12++) {
                float f12 = ((float) i12) * height;
                this.mGriddingPath.moveTo((float) rect.left, ((float) rect.top) + f12);
                this.mGriddingPath.lineTo((float) rect.right, ((float) rect.top) + f12);
            }
        }
        if (this.mLinearGradient_Gridding == null) {
            LinearGradient linearGradient = new LinearGradient(0.0f, (float) rect.top, 0.0f, ((float) rect.bottom) + (((float) rect.height()) * 0.01f), new int[]{0, 0, this.mScancolor, 0}, new float[]{0.0f, 0.65f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Gridding = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Gridding.setShader(this.mLinearGradient_Gridding);
        }
    }

    private void initRadarStyle(Rect rect) {
        if (this.mLinearGradient_Radar == null) {
            LinearGradient linearGradient = new LinearGradient(0.0f, (float) rect.top, 0.0f, ((float) rect.bottom) + (((float) rect.height()) * 0.01f), new int[]{0, 0, this.mFirstScancolor, this.mSecondScancolor, this.mThirdScancolor, 0}, new float[]{0.0f, 0.85f, 0.9f, 0.95f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Radar = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Radio.setShader(this.mLinearGradient_Radar);
        }
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        List<ResultPoint> list = this.possibleResultPoints;
        synchronized (list) {
            list.add(resultPoint);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        Bitmap bitmap = this.resultBitmap;
        this.resultBitmap = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void initScanValueAnim(int i11) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mValueAnimator = valueAnimator;
        valueAnimator.setDuration((long) this.mScanAnimatorDuration);
        this.mValueAnimator.setFloatValues(new float[]{(float) (-i11), 0.0f});
        this.mValueAnimator.setRepeatMode(1);
        this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mValueAnimator.setRepeatCount(10000);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ViewfinderView.this.mScanMatrix != null && ViewfinderView.this.mLinearGradient_Gridding != null) {
                    ViewfinderView.this.mScanMatrix.setTranslate(0.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    ViewfinderView.this.mLinearGradient_Gridding.setLocalMatrix(ViewfinderView.this.mScanMatrix);
                    ViewfinderView.this.mLinearGradient_Radar.setLocalMatrix(ViewfinderView.this.mScanMatrix);
                    ViewfinderView.this.invalidate();
                }
            }
        });
        this.mValueAnimator.start();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mValueAnimator = null;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        CameraManager cameraManager2 = this.cameraManager;
        if (cameraManager2 != null) {
            Rect framingRect = cameraManager2.getFramingRect();
            Rect framingRectInPreview = this.cameraManager.getFramingRectInPreview();
            if (framingRect != null && framingRectInPreview != null) {
                int width = getWidth();
                int height = getHeight();
                this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
                float f11 = (float) width;
                canvas.drawRect(0.0f, 0.0f, f11, (float) framingRect.top, this.paint);
                canvas.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.paint);
                float f12 = f11;
                canvas.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f12, (float) (framingRect.bottom + 1), this.paint);
                canvas.drawRect(0.0f, (float) (framingRect.bottom + 1), f12, (float) height, this.paint);
                if (this.resultBitmap != null) {
                    this.paint.setAlpha(160);
                    canvas.drawBitmap(this.resultBitmap, (Rect) null, framingRect, this.paint);
                    return;
                }
                drawFrameBounds(canvas, framingRect);
                drawTextHint(canvas, framingRect);
                initBoundaryAndAnimator(framingRect);
                int i11 = this.mScanStyle;
                if (i11 == 0) {
                    initGriddingPathAndStyle(framingRect);
                    canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
                } else if (i11 == 1) {
                    initRadarStyle(framingRect);
                    canvas.drawRect(framingRect, this.mScanPaint_Radio);
                } else if (i11 != 2) {
                    initGriddingPathAndStyle(framingRect);
                    canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
                } else {
                    initGriddingPathAndStyle(framingRect);
                    initRadarStyle(framingRect);
                    canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
                    canvas.drawRect(framingRect, this.mScanPaint_Radio);
                }
                postInvalidateDelayed(ANIMATION_DELAY, framingRect.left - 6, framingRect.top - 6, framingRect.right + 6, framingRect.bottom + 6);
            }
        }
    }

    public void setCameraManager(CameraManager cameraManager2) {
        this.cameraManager = cameraManager2;
    }

    public void setTextHint(String str) {
        this.textHint = str;
    }
}
