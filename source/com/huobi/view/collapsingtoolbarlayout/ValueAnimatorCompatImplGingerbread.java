package com.huobi.view.collapsingtoolbarlayout;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.huobi.view.collapsingtoolbarlayout.ValueAnimatorCompat;
import java.util.ArrayList;

class ValueAnimatorCompatImplGingerbread extends ValueAnimatorCompat.Impl {
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private float mAnimatedFraction;
    private long mDuration = 200;
    private final float[] mFloatValues = new float[2];
    private final int[] mIntValues = new int[2];
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> mListeners;
    private final Runnable mRunnable = new Runnable() {
        public void run() {
            ValueAnimatorCompatImplGingerbread.this.update();
        }
    };
    private long mStartTime;
    private ArrayList<ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy> mUpdateListeners;

    private void dispatchAnimationCancel() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.mListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mListeners.get(i11).onAnimationCancel();
            }
        }
    }

    private void dispatchAnimationEnd() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.mListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mListeners.get(i11).onAnimationEnd();
            }
        }
    }

    private void dispatchAnimationStart() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.mListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mListeners.get(i11).onAnimationStart();
            }
        }
    }

    private void dispatchAnimationUpdate() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mUpdateListeners.get(i11).onAnimationUpdate();
            }
        }
    }

    public void addListener(ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(animatorListenerProxy);
    }

    public void addUpdateListener(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListenerProxy);
    }

    public void cancel() {
        this.mIsRunning = false;
        sHandler.removeCallbacks(this.mRunnable);
        dispatchAnimationCancel();
        dispatchAnimationEnd();
    }

    public void end() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            sHandler.removeCallbacks(this.mRunnable);
            this.mAnimatedFraction = 1.0f;
            dispatchAnimationUpdate();
            dispatchAnimationEnd();
        }
    }

    public float getAnimatedFloatValue() {
        float[] fArr = this.mFloatValues;
        return AnimationUtils.lerp(fArr[0], fArr[1], getAnimatedFraction());
    }

    public float getAnimatedFraction() {
        return this.mAnimatedFraction;
    }

    public int getAnimatedIntValue() {
        int[] iArr = this.mIntValues;
        return AnimationUtils.lerp(iArr[0], iArr[1], getAnimatedFraction());
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void setDuration(long j11) {
        this.mDuration = j11;
    }

    public void setFloatValues(float f11, float f12) {
        float[] fArr = this.mFloatValues;
        fArr[0] = f11;
        fArr[1] = f12;
    }

    public void setIntValues(int i11, int i12) {
        int[] iArr = this.mIntValues;
        iArr[0] = i11;
        iArr[1] = i12;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mIsRunning = true;
            this.mAnimatedFraction = 0.0f;
            startInternal();
        }
    }

    public final void startInternal() {
        this.mStartTime = SystemClock.uptimeMillis();
        dispatchAnimationUpdate();
        dispatchAnimationStart();
        sHandler.postDelayed(this.mRunnable, 10);
    }

    public final void update() {
        if (this.mIsRunning) {
            float constrain = MathUtils.constrain(((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.mDuration), 0.0f, 1.0f);
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                constrain = interpolator.getInterpolation(constrain);
            }
            this.mAnimatedFraction = constrain;
            dispatchAnimationUpdate();
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.mDuration) {
                this.mIsRunning = false;
                dispatchAnimationEnd();
            }
        }
        if (this.mIsRunning) {
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }
}
