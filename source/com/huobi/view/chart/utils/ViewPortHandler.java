package com.huobi.view.chart.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {
    public Matrix mCenterViewPortMatrixBuffer = new Matrix();
    public float mChartHeight = 0.0f;
    public float mChartWidth = 0.0f;
    public RectF mContentRect = new RectF();
    public final Matrix mMatrixTouch = new Matrix();
    private float mMaxScaleX = Float.MAX_VALUE;
    private float mMaxScaleY = Float.MAX_VALUE;
    private float mMinScaleX = 1.0f;
    private float mMinScaleY = 1.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mTransOffsetX = 0.0f;
    private float mTransOffsetY = 0.0f;
    private float mTransX = 0.0f;
    private float mTransY = 0.0f;
    public final float[] matrixBuffer = new float[9];
    public float[] valsBufferForFitScreen = new float[9];

    public boolean canZoomInMoreX() {
        return this.mScaleX < this.mMaxScaleX;
    }

    public boolean canZoomInMoreY() {
        return this.mScaleY < this.mMaxScaleY;
    }

    public boolean canZoomOutMoreX() {
        return this.mScaleX > this.mMinScaleX;
    }

    public boolean canZoomOutMoreY() {
        return this.mScaleY > this.mMinScaleY;
    }

    public void centerViewPort(float[] fArr, View view) {
        Matrix matrix = this.mCenterViewPortMatrixBuffer;
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public Matrix fitScreen() {
        Matrix matrix = new Matrix();
        fitScreen(matrix);
        return matrix;
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public MPPointF getContentCenter() {
        return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public float getMaxScaleX() {
        return this.mMaxScaleX;
    }

    public float getMaxScaleY() {
        return this.mMaxScaleY;
    }

    public float getMinScaleX() {
        return this.mMinScaleX;
    }

    public float getMinScaleY() {
        return this.mMinScaleY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getSmallestContentExtension() {
        return Math.min(this.mContentRect.width(), this.mContentRect.height());
    }

    public float getTransX() {
        return this.mTransX;
    }

    public float getTransY() {
        return this.mTransY;
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public boolean hasNoDragOffset() {
        return this.mTransOffsetX <= 0.0f && this.mTransOffsetY <= 0.0f;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutX() {
        float f11 = this.mScaleX;
        float f12 = this.mMinScaleX;
        return f11 <= f12 && f12 <= 1.0f;
    }

    public boolean isFullyZoomedOutY() {
        float f11 = this.mScaleY;
        float f12 = this.mMinScaleY;
        return f11 <= f12 && f12 <= 1.0f;
    }

    public boolean isInBounds(float f11, float f12) {
        return isInBoundsX(f11) && isInBoundsY(f12);
    }

    public boolean isInBoundsBottom(float f11) {
        return this.mContentRect.bottom >= ((float) ((int) (f11 * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsLeft(float f11) {
        return this.mContentRect.left <= f11 + 1.0f;
    }

    public boolean isInBoundsRight(float f11) {
        return this.mContentRect.right >= (((float) ((int) (f11 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean isInBoundsTop(float f11) {
        return this.mContentRect.top <= f11;
    }

    public boolean isInBoundsX(float f11) {
        return isInBoundsLeft(f11) && isInBoundsRight(f11);
    }

    public boolean isInBoundsY(float f11) {
        return isInBoundsTop(f11) && isInBoundsBottom(f11);
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float f11;
        matrix.getValues(this.matrixBuffer);
        float[] fArr = this.matrixBuffer;
        float f12 = fArr[2];
        float f13 = fArr[0];
        float f14 = fArr[5];
        float f15 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f13), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, f15), this.mMaxScaleY);
        float f16 = 0.0f;
        if (rectF != null) {
            f16 = rectF.width();
            f11 = rectF.height();
        } else {
            f11 = 0.0f;
        }
        this.mTransX = Math.min(Math.max(f12, ((-f16) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float max = Math.max(Math.min(f14, (f11 * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        this.mTransY = max;
        float[] fArr2 = this.matrixBuffer;
        fArr2[2] = this.mTransX;
        fArr2[0] = this.mScaleX;
        fArr2[5] = max;
        fArr2[4] = this.mScaleY;
        matrix.setValues(fArr2);
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public Matrix refresh(Matrix matrix, View view, boolean z11) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z11) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void resetZoom(Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void restrainViewPort(float f11, float f12, float f13, float f14) {
        this.mContentRect.set(f11, f12, this.mChartWidth - f13, this.mChartHeight - f14);
    }

    public void setChartDimens(float f11, float f12) {
        float offsetLeft = offsetLeft();
        float offsetTop = offsetTop();
        float offsetRight = offsetRight();
        float offsetBottom = offsetBottom();
        this.mChartHeight = f12;
        this.mChartWidth = f11;
        restrainViewPort(offsetLeft, offsetTop, offsetRight, offsetBottom);
    }

    public void setDragOffsetX(float f11) {
        this.mTransOffsetX = Utils.convertDpToPixel(f11);
    }

    public void setDragOffsetY(float f11) {
        this.mTransOffsetY = Utils.convertDpToPixel(f11);
    }

    public void setMaximumScaleX(float f11) {
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.mMaxScaleX = f11;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float f11) {
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.mMaxScaleY = f11;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f11, float f12) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        if (f12 == 0.0f) {
            f12 = Float.MAX_VALUE;
        }
        this.mMinScaleX = f11;
        this.mMaxScaleX = f12;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleY(float f11, float f12) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        if (f12 == 0.0f) {
            f12 = Float.MAX_VALUE;
        }
        this.mMinScaleY = f11;
        this.mMaxScaleY = f12;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleX(float f11) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        this.mMinScaleX = f11;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f11) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        this.mMinScaleY = f11;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix setZoom(float f11, float f12) {
        Matrix matrix = new Matrix();
        setZoom(f11, f12, matrix);
        return matrix;
    }

    public Matrix translate(float[] fArr) {
        Matrix matrix = new Matrix();
        translate(fArr, matrix);
        return matrix;
    }

    public Matrix zoom(float f11, float f12) {
        Matrix matrix = new Matrix();
        zoom(f11, f12, matrix);
        return matrix;
    }

    public Matrix zoomIn(float f11, float f12) {
        Matrix matrix = new Matrix();
        zoomIn(f11, f12, matrix);
        return matrix;
    }

    public Matrix zoomOut(float f11, float f12) {
        Matrix matrix = new Matrix();
        zoomOut(f11, f12, matrix);
        return matrix;
    }

    public void fitScreen(Matrix matrix) {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        matrix.set(this.mMatrixTouch);
        float[] fArr = this.valsBufferForFitScreen;
        for (int i11 = 0; i11 < 9; i11++) {
            fArr[i11] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public void setZoom(float f11, float f12, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f11, f12);
    }

    public void translate(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
    }

    public void zoom(float f11, float f12, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f11, f12);
    }

    public void zoomIn(float f11, float f12, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f11, f12);
    }

    public void zoomOut(float f11, float f12, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f11, f12);
    }

    public Matrix setZoom(float f11, float f12, float f13, float f14) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f11, f12, f13, f14);
        return matrix;
    }

    public Matrix zoom(float f11, float f12, float f13, float f14) {
        Matrix matrix = new Matrix();
        zoom(f11, f12, f13, f14, matrix);
        return matrix;
    }

    public void zoom(float f11, float f12, float f13, float f14, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f11, f12, f13, f14);
    }
}
