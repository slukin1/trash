package com.huobi.view.collapsingtoolbarlayout;

import android.view.animation.Interpolator;

class ValueAnimatorCompat {
    private final Impl mImpl;

    public interface AnimatorListener {
        void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);
    }

    public static class AnimatorListenerAdapter implements AnimatorListener {
        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat);
    }

    public interface Creator {
        ValueAnimatorCompat createAnimator();
    }

    public static abstract class Impl {

        public interface AnimatorListenerProxy {
            void onAnimationCancel();

            void onAnimationEnd();

            void onAnimationStart();
        }

        public interface AnimatorUpdateListenerProxy {
            void onAnimationUpdate();
        }

        public abstract void addListener(AnimatorListenerProxy animatorListenerProxy);

        public abstract void addUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        public abstract void cancel();

        public abstract void end();

        public abstract float getAnimatedFloatValue();

        public abstract float getAnimatedFraction();

        public abstract int getAnimatedIntValue();

        public abstract long getDuration();

        public abstract boolean isRunning();

        public abstract void setDuration(long j11);

        public abstract void setFloatValues(float f11, float f12);

        public abstract void setIntValues(int i11, int i12);

        public abstract void setInterpolator(Interpolator interpolator);

        public abstract void start();
    }

    public ValueAnimatorCompat(Impl impl) {
        this.mImpl = impl;
    }

    public void addListener(final AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mImpl.addListener(new Impl.AnimatorListenerProxy() {
                public void onAnimationCancel() {
                    animatorListener.onAnimationCancel(ValueAnimatorCompat.this);
                }

                public void onAnimationEnd() {
                    animatorListener.onAnimationEnd(ValueAnimatorCompat.this);
                }

                public void onAnimationStart() {
                    animatorListener.onAnimationStart(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.addListener((Impl.AnimatorListenerProxy) null);
        }
    }

    public void addUpdateListener(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.mImpl.addUpdateListener(new Impl.AnimatorUpdateListenerProxy() {
                public void onAnimationUpdate() {
                    animatorUpdateListener.onAnimationUpdate(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.addUpdateListener((Impl.AnimatorUpdateListenerProxy) null);
        }
    }

    public void cancel() {
        this.mImpl.cancel();
    }

    public void end() {
        this.mImpl.end();
    }

    public float getAnimatedFloatValue() {
        return this.mImpl.getAnimatedFloatValue();
    }

    public float getAnimatedFraction() {
        return this.mImpl.getAnimatedFraction();
    }

    public int getAnimatedIntValue() {
        return this.mImpl.getAnimatedIntValue();
    }

    public long getDuration() {
        return this.mImpl.getDuration();
    }

    public boolean isRunning() {
        return this.mImpl.isRunning();
    }

    public void setDuration(long j11) {
        this.mImpl.setDuration(j11);
    }

    public void setFloatValues(float f11, float f12) {
        this.mImpl.setFloatValues(f11, f12);
    }

    public void setIntValues(int i11, int i12) {
        this.mImpl.setIntValues(i11, i12);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mImpl.setInterpolator(interpolator);
    }

    public void start() {
        this.mImpl.start();
    }
}
