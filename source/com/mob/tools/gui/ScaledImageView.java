package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;

public class ScaledImageView extends ImageView implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare = scaledTouchSlop;
        this.dragScrollMinDistSquare = scaledTouchSlop * scaledTouchSlop;
        setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap captureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (captureView == null) {
                MobLog.getInstance().w("ivPhoto.getDrawingCache() returns null");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(captureView, rect.left, rect.top, rect.width(), rect.height());
            captureView.recycle();
            return createBitmap;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                Matrix matrix2 = new Matrix();
                this.matrix = matrix2;
                matrix2.set(getImageMatrix());
                Matrix matrix3 = new Matrix();
                this.savedMatrix = matrix3;
                matrix3.set(this.matrix);
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.mode = 1;
            } else if (action == 1) {
                OnMatrixChangedListener onMatrixChangedListener = this.listener;
                if (onMatrixChangedListener != null) {
                    onMatrixChangedListener.onMactrixChage(this.matrix);
                }
                float x11 = motionEvent.getX(0) - this.downPoint[0];
                float y11 = motionEvent.getY(0) - this.downPoint[1];
                if (this.mode == 1 && (x11 * x11) + (y11 * y11) <= ((float) this.dragScrollMinDistSquare)) {
                    performClick();
                }
                this.mode = 0;
            } else if (action == 2) {
                int i11 = this.mode;
                if (i11 == 1) {
                    float[] fArr = {motionEvent.getX(0), motionEvent.getY(0)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix4 = this.matrix;
                    float f11 = fArr[0];
                    float[] fArr2 = this.downPoint;
                    matrix4.postTranslate(f11 - fArr2[0], fArr[1] - fArr2[1]);
                } else if (i11 == 2) {
                    float[] fArr3 = {motionEvent.getX(1), motionEvent.getY(1)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix5 = this.matrix;
                    float f12 = fArr3[0];
                    float[] fArr4 = this.downPoint;
                    matrix5.postTranslate(f12 - fArr4[0], fArr3[1] - fArr4[1]);
                } else if (i11 == 3) {
                    float[] fArr5 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float[] fArr6 = {motionEvent.getX(1), motionEvent.getY(1)};
                    float f13 = fArr5[0] - fArr6[0];
                    float f14 = fArr5[1] - fArr6[1];
                    this.matrix.set(this.savedMatrix);
                    float sqrt = (float) Math.sqrt((double) (((f13 * f13) + (f14 * f14)) / this.distSquare));
                    float[] fArr7 = {(fArr5[0] + fArr6[0]) / 2.0f, (fArr5[1] + fArr6[1]) / 2.0f};
                    this.matrix.postScale(sqrt, sqrt, fArr7[0], fArr7[1]);
                }
            } else if (action == 5) {
                float[] fArr8 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr9 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f15 = fArr8[0] - fArr9[0];
                float f16 = fArr8[1] - fArr9[1];
                this.distSquare = (f15 * f15) + (f16 * f16);
                this.mode = 3;
            } else if (action == 6) {
                this.downPoint = new float[]{motionEvent.getX(1), motionEvent.getY(1)};
                this.savedMatrix.set(this.matrix);
                this.mode = 2;
            } else if (action == 261) {
                float[] fArr10 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr11 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f17 = fArr10[0] - fArr11[0];
                float f18 = fArr10[1] - fArr11[1];
                this.distSquare = (f17 * f17) + (f18 * f18);
                this.mode = 3;
            } else if (action != 262) {
                return false;
            } else {
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.savedMatrix.set(this.matrix);
                this.mode = 1;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            float[] fArr = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix2.setValues(fArr);
            Bitmap bitmap2 = this.bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (createBitmap != null && !createBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix3 = new Matrix();
            this.matrix = matrix3;
            matrix3.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * ((float) this.bitmap.getWidth()), fArr[4] * ((float) this.bitmap.getHeight())};
            float[] fArr3 = {(((float) iArr[0]) - fArr2[0]) / 2.0f, (((float) iArr[1]) - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    public void rotateRight() {
        try {
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            float[] fArr = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix2.setValues(fArr);
            Bitmap bitmap2 = this.bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (createBitmap != null && !createBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix3 = new Matrix();
            this.matrix = matrix3;
            matrix3.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * ((float) this.bitmap.getWidth()), fArr[4] * ((float) this.bitmap.getHeight())};
            float[] fArr3 = {(((float) iArr[0]) - fArr2[0]) / 2.0f, (((float) iArr[1]) - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
        setImageBitmap(bitmap2);
        int[] iArr = {getWidth(), getHeight()};
        int[] iArr2 = {this.bitmap.getWidth(), this.bitmap.getHeight()};
        int[] fixRect = BitmapHelper.fixRect(iArr2, iArr);
        int[] iArr3 = {(iArr[0] - fixRect[0]) / 2, (iArr[1] - fixRect[1]) / 2};
        float[] fArr = {((float) fixRect[0]) / ((float) iArr2[0]), ((float) fixRect[1]) / ((float) iArr2[1])};
        Matrix matrix2 = new Matrix();
        this.matrix = matrix2;
        matrix2.set(getImageMatrix());
        this.matrix.postScale(fArr[0], fArr[1]);
        this.matrix.postTranslate((float) iArr3[0], (float) iArr3[1]);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        Matrix matrix2 = this.matrix;
        if (matrix2 != null) {
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(matrix2);
            }
            setImageMatrix(this.matrix);
        }
    }

    public void zoomIn() {
        Matrix matrix2 = new Matrix();
        this.matrix = matrix2;
        matrix2.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        Matrix matrix2 = new Matrix();
        this.matrix = matrix2;
        matrix2.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
