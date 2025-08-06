package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.yalantis.ucrop.UCropDevelopConfig;
import com.yalantis.ucrop.UCropImageEngine;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.RectUtils;

public class TransformImageView extends AppCompatImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final String TAG = "TransformImageView";
    public boolean mBitmapDecoded;
    public boolean mBitmapLaidOut;
    public final float[] mCurrentImageCenter;
    public final float[] mCurrentImageCorners;
    public Matrix mCurrentImageMatrix;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private Uri mImageInputUri;
    private String mImageOutputPath;
    private Uri mImageOutputUri;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues;
    private int mMaxBitmapSize;
    public int mThisHeight;
    public int mThisWidth;
    public TransformImageListener mTransformImageListener;

    public interface TransformImageListener {
        void onLoadComplete();

        void onLoadFailure(Exception exc);

        void onRotate(float f11);

        void onScale(float f11);
    }

    public TransformImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    private void useCustomLoaderCrop(final Uri uri, final Uri uri2) {
        int[] maxImageSize = BitmapLoadUtils.getMaxImageSize(getContext(), uri);
        if (maxImageSize[0] <= 0 || maxImageSize[1] <= 0) {
            useDefaultLoaderCrop(uri, uri2);
            return;
        }
        UCropDevelopConfig.imageEngine.loadImage(getContext(), uri, maxImageSize[0], maxImageSize[1], new UCropImageEngine.OnCallbackListener<Bitmap>() {
            public void onCall(Bitmap bitmap) {
                if (bitmap == null) {
                    TransformImageView.this.useDefaultLoaderCrop(uri, uri2);
                    return;
                }
                TransformImageView.this.setBitmapLoadedResult(bitmap.copy(bitmap.getConfig(), true), new ExifInfo(0, 0, 0), uri, uri2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void useDefaultLoaderCrop(Uri uri, Uri uri2) {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new BitmapLoadCallback() {
            public void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2) {
                TransformImageView.this.setBitmapLoadedResult(bitmap, exifInfo, uri, uri2);
            }

            public void onFailure(Exception exc) {
                Log.e(TransformImageView.TAG, "onFailure: setImageUri", exc);
                TransformImageListener transformImageListener = TransformImageView.this.mTransformImageListener;
                if (transformImageListener != null) {
                    transformImageListener.onLoadFailure(exc);
                }
            }
        });
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public Uri getImageInputUri() {
        return this.mImageInputUri;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public Uri getImageOutputUri() {
        return this.mImageOutputUri;
    }

    public float getMatrixAngle(Matrix matrix) {
        return (float) (-(Math.atan2((double) getMatrixValue(matrix, 1), (double) getMatrixValue(matrix, 0)) * 57.29577951308232d));
    }

    public float getMatrixScale(Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) getMatrixValue(matrix, 0), 2.0d) + Math.pow((double) getMatrixValue(matrix, 3), 2.0d));
    }

    public float getMatrixValue(Matrix matrix, int i11) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i11];
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize <= 0) {
            this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize(getContext());
        }
        return this.mMaxBitmapSize;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).getBitmap();
    }

    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void onImageLaidOut() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Log.d(TAG, String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)}));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.mInitialImageCorners = RectUtils.getCornersFromRect(rectF);
            this.mInitialImageCenter = RectUtils.getCenterFromRect(rectF);
            this.mBitmapLaidOut = true;
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onLoadComplete();
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11 || (this.mBitmapDecoded && !this.mBitmapLaidOut)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            onImageLaidOut();
        }
    }

    public void postRotate(float f11, float f12, float f13) {
        if (f11 != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f11, f12, f13);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onRotate(getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    public void postScale(float f11, float f12, float f13) {
        if (f11 != 0.0f) {
            this.mCurrentImageMatrix.postScale(f11, f11, f12, f13);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.onScale(getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postTranslate(float f11, float f12) {
        if (f11 != 0.0f || f12 != 0.0f) {
            this.mCurrentImageMatrix.postTranslate(f11, f12);
            setImageMatrix(this.mCurrentImageMatrix);
        }
    }

    public void printMatrix(String str, Matrix matrix) {
        float matrixValue = getMatrixValue(matrix, 2);
        float matrixValue2 = getMatrixValue(matrix, 5);
        float matrixScale = getMatrixScale(matrix);
        float matrixAngle = getMatrixAngle(matrix);
        Log.d(TAG, str + ": matrix: { x: " + matrixValue + ", y: " + matrixValue2 + ", scale: " + matrixScale + ", angle: " + matrixAngle + " }");
    }

    public void setBitmapLoadedResult(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2) {
        String str;
        this.mImageInputUri = uri;
        this.mImageOutputUri = uri2;
        this.mImageInputPath = FileUtils.isContent(uri.toString()) ? uri.toString() : uri.getPath();
        if (uri2 != null) {
            str = FileUtils.isContent(uri2.toString()) ? uri2.toString() : uri2.getPath();
        } else {
            str = null;
        }
        this.mImageOutputPath = str;
        this.mExifInfo = exifInfo;
        this.mBitmapDecoded = true;
        setImageBitmap(bitmap);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        updateCurrentImagePoints();
    }

    public void setImageUri(Uri uri, Uri uri2, boolean z11) {
        if (UCropDevelopConfig.imageEngine == null || !z11) {
            useDefaultLoaderCrop(uri, uri2);
        } else {
            useCustomLoaderCrop(uri, uri2);
        }
    }

    public void setMaxBitmapSize(int i11) {
        this.mMaxBitmapSize = i11;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w(TAG, "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.mMaxBitmapSize = 0;
        init();
    }
}
