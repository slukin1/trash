package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    /* access modifiers changed from: private */
    public final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    public static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j11, float f11, float f12, float f13, float f14, float f15, float f16, boolean z11) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j11;
            this.mOldX = f11;
            this.mOldY = f12;
            this.mCenterDiffX = f13;
            this.mCenterDiffY = f14;
            this.mOldScale = f15;
            this.mDeltaScale = f16;
            this.mWillBeImageInBoundsAfterTranslate = z11;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeOut = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffX, (float) this.mDurationMs);
                float easeOut2 = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffY, (float) this.mDurationMs);
                float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    float[] fArr = cropImageView.mCurrentImageCenter;
                    cropImageView.postTranslate(easeOut - (fArr[0] - this.mOldX), easeOut2 - (fArr[1] - this.mOldY));
                    if (!this.mWillBeImageInBoundsAfterTranslate) {
                        cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                    }
                    if (!cropImageView.isImageWrapCropBounds()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    public static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j11, float f11, float f12, float f13, float f14) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j11;
            this.mOldScale = f11;
            this.mDeltaScale = f12;
            this.mDestX = f13;
            this.mDestY = f14;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                    cropImageView.post(this);
                    return;
                }
                cropImageView.setImageToWrapCropBounds();
            }
        }
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArr = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f11 = trapToRect.left - trapToRect2.left;
        float f12 = trapToRect.top - trapToRect2.top;
        float f13 = trapToRect.right - trapToRect2.right;
        float f14 = trapToRect.bottom - trapToRect2.bottom;
        float[] fArr2 = new float[4];
        if (f11 <= 0.0f) {
            f11 = 0.0f;
        }
        fArr2[0] = f11;
        if (f12 <= 0.0f) {
            f12 = 0.0f;
        }
        fArr2[1] = f12;
        if (f13 >= 0.0f) {
            f13 = 0.0f;
        }
        fArr2[2] = f13;
        if (f14 >= 0.0f) {
            f14 = 0.0f;
        }
        fArr2[3] = f14;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr2);
        return fArr2;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            calculateImageScaleBounds((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    private void setupInitialImagePosition(float f11, float f12) {
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        float max = Math.max(this.mCropRect.width() / f11, this.mCropRect.height() / f12);
        RectF rectF = this.mCropRect;
        float f13 = ((height - (f12 * max)) / 2.0f) + rectF.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(((width - (f11 * max)) / 2.0f) + rectF.left, f13);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int i11, BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle());
        CropParameters cropParameters = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i11, getImageInputPath(), getImageOutputPath(), getExifInfo());
        cropParameters.setContentImageInputUri(getImageInputUri());
        cropParameters.setContentImageOutputUri(getImageOutputUri());
        new BitmapCropTask(getContext(), getViewBitmap(), imageState, cropParameters, bitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.mTargetAspectRatio == 0.0f) {
                this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
            }
            int i11 = this.mThisWidth;
            float f11 = this.mTargetAspectRatio;
            int i12 = (int) (((float) i11) / f11);
            int i13 = this.mThisHeight;
            if (i12 > i13) {
                int i14 = (int) (((float) i13) * f11);
                int i15 = (i11 - i14) / 2;
                this.mCropRect.set((float) i15, 0.0f, (float) (i14 + i15), (float) i13);
            } else {
                int i16 = (i13 - i12) / 2;
                this.mCropRect.set(0.0f, (float) i16, (float) i11, (float) (i12 + i16));
            }
            calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
            setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
            CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
            if (cropBoundsChangeListener != null) {
                cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
            }
            TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onScale(getCurrentScale());
                this.mTransformImageListener.onRotate(getCurrentAngle());
            }
        }
    }

    public void postRotate(float f11) {
        postRotate(f11, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void postScale(float f11, float f12, float f13) {
        if (f11 > 1.0f && getCurrentScale() * f11 <= getMaxScale()) {
            super.postScale(f11, f12, f13);
        } else if (f11 < 1.0f && getCurrentScale() * f11 >= getMinScale()) {
            super.postScale(f11, f12, f13);
        }
    }

    public void processStyledAttributes(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.mTargetAspectRatio = 0.0f;
        } else {
            this.mTargetAspectRatio = abs / abs2;
        }
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBoundsAnimDuration(long j11) {
        if (j11 > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j11;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int i11) {
        this.mMaxResultImageSizeX = i11;
    }

    public void setMaxResultImageSizeY(int i11) {
        this.mMaxResultImageSizeY = i11;
    }

    public void setMaxScaleMultiplier(float f11) {
        this.mMaxScaleMultiplier = f11;
    }

    public void setTargetAspectRatio(float f11) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f11;
            return;
        }
        if (f11 == 0.0f) {
            this.mTargetAspectRatio = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.mTargetAspectRatio = f11;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    public void zoomImageToPosition(float f11, float f12, float f13, long j11) {
        if (f11 > getMaxScale()) {
            f11 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j11, currentScale, f11 - currentScale, f12, f13);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f11) {
        zoomInImage(f11, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f11) {
        zoomOutImage(f11, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(copyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(copyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    public void setImageToWrapCropBounds(boolean z11) {
        float f11;
        float f12;
        float f13;
        if (this.mBitmapLaidOut && !isImageWrapCropBounds()) {
            float[] fArr = this.mCurrentImageCenter;
            float f14 = fArr[0];
            float f15 = fArr[1];
            float currentScale = getCurrentScale();
            float centerX = this.mCropRect.centerX() - f14;
            float centerY = this.mCropRect.centerY() - f15;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] fArr2 = this.mCurrentImageCorners;
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            this.mTempMatrix.mapPoints(copyOf);
            boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
            if (isImageWrapCropBounds) {
                float[] calculateImageIndents = calculateImageIndents();
                f12 = -(calculateImageIndents[1] + calculateImageIndents[3]);
                f13 = -(calculateImageIndents[0] + calculateImageIndents[2]);
                f11 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
                f13 = centerX;
                f11 = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
                f12 = centerY;
            }
            if (z11) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f14, f15, f13, f12, currentScale, f11, isImageWrapCropBounds);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
                return;
            }
            postTranslate(f13, f12);
            if (!isImageWrapCropBounds) {
                zoomInImage(currentScale + f11, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void zoomInImage(float f11, float f12, float f13) {
        if (f11 <= getMaxScale()) {
            postScale(f11 / getCurrentScale(), f12, f13);
        }
    }

    public void zoomOutImage(float f11, float f12, float f13) {
        if (f11 >= getMinScale()) {
            postScale(f11 / getCurrentScale(), f12, f13);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500;
    }

    private void calculateImageScaleBounds(float f11, float f12) {
        float min = Math.min(Math.min(this.mCropRect.width() / f11, this.mCropRect.width() / f12), Math.min(this.mCropRect.height() / f12, this.mCropRect.height() / f11));
        this.mMinScale = min;
        this.mMaxScale = min * this.mMaxScaleMultiplier;
    }
}
