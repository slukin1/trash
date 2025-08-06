package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.huobi.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Shimmer {
    private static final int COMPONENT_COUNT = 4;
    public boolean alphaShimmer = true;
    public long animationDuration = 1000;
    public boolean autoStart = true;
    public int baseColor = 1291845631;
    public final RectF bounds = new RectF();
    public boolean clipToChildren = true;
    public final int[] colors = new int[4];
    public int direction = 0;
    public float dropoff = 0.5f;
    public int fixedHeight = 0;
    public int fixedWidth = 0;
    public float heightRatio = 1.0f;
    public int highlightColor = -1;
    public float intensity = 0.0f;
    public final float[] positions = new float[4];
    public int repeatCount = -1;
    public long repeatDelay;
    public int repeatMode = 1;
    public int shape = 0;
    public float tilt = 20.0f;
    public float widthRatio = 1.0f;

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }

        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder setBaseColor(int i11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (i11 & FlexItem.MAX_SIZE) | (shimmer.baseColor & RoundedDrawable.DEFAULT_BORDER_COLOR);
            return getThis();
        }

        public ColorHighlightBuilder setHighlightColor(int i11) {
            this.mShimmer.highlightColor = i11;
            return getThis();
        }

        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            if (typedArray.hasValue(2)) {
                setBaseColor(typedArray.getColor(2, this.mShimmer.baseColor));
            }
            if (typedArray.hasValue(12)) {
                setHighlightColor(typedArray.getColor(12, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public int height(int i11) {
        int i12 = this.fixedHeight;
        return i12 > 0 ? i12 : Math.round(this.heightRatio * ((float) i11));
    }

    public void updateBounds(int i11, int i12) {
        double max = (double) Math.max(i11, i12);
        int round = Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians((double) (this.tilt % 90.0f)))) - max)) / 2.0f) * 3;
        float f11 = (float) (-round);
        this.bounds.set(f11, f11, (float) (width(i11) + round), (float) (height(i12) + round));
    }

    public void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i11 = this.baseColor;
            iArr[0] = i11;
            int i12 = this.highlightColor;
            iArr[1] = i12;
            iArr[2] = i12;
            iArr[3] = i11;
            return;
        }
        int[] iArr2 = this.colors;
        int i13 = this.highlightColor;
        iArr2[0] = i13;
        iArr2[1] = i13;
        int i14 = this.baseColor;
        iArr2[2] = i14;
        iArr2[3] = i14;
    }

    public void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    public int width(int i11) {
        int i12 = this.fixedWidth;
        return i12 > 0 ? i12 : Math.round(this.widthRatio * ((float) i11));
    }

    public static abstract class Builder<T extends Builder<T>> {
        public final Shimmer mShimmer = new Shimmer();

        private static float clamp(float f11, float f12, float f13) {
            return Math.min(f12, Math.max(f11, f13));
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0));
        }

        public abstract T getThis();

        public T setAutoStart(boolean z11) {
            this.mShimmer.autoStart = z11;
            return getThis();
        }

        public T setBaseAlpha(float f11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f11) * 255.0f)) << 24) | (shimmer.baseColor & FlexItem.MAX_SIZE);
            return getThis();
        }

        public T setClipToChildren(boolean z11) {
            this.mShimmer.clipToChildren = z11;
            return getThis();
        }

        public T setDirection(int i11) {
            this.mShimmer.direction = i11;
            return getThis();
        }

        public T setDropoff(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.dropoff = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f11);
        }

        public T setDuration(long j11) {
            if (j11 >= 0) {
                this.mShimmer.animationDuration = j11;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j11);
        }

        public T setFixedHeight(int i11) {
            if (i11 >= 0) {
                this.mShimmer.fixedHeight = i11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height: " + i11);
        }

        public T setFixedWidth(int i11) {
            if (i11 >= 0) {
                this.mShimmer.fixedWidth = i11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width: " + i11);
        }

        public T setHeightRatio(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.heightRatio = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f11);
        }

        public T setHighlightAlpha(float f11) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f11) * 255.0f)) << 24) | (shimmer.baseColor & FlexItem.MAX_SIZE);
            return getThis();
        }

        public T setIntensity(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.intensity = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f11);
        }

        public T setRepeatCount(int i11) {
            this.mShimmer.repeatCount = i11;
            return getThis();
        }

        public T setRepeatDelay(long j11) {
            if (j11 >= 0) {
                this.mShimmer.repeatDelay = j11;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j11);
        }

        public T setRepeatMode(int i11) {
            this.mShimmer.repeatMode = i11;
            return getThis();
        }

        public T setShape(int i11) {
            this.mShimmer.shape = i11;
            return getThis();
        }

        public T setTilt(float f11) {
            this.mShimmer.tilt = f11;
            return getThis();
        }

        public T setWidthRatio(float f11) {
            if (f11 >= 0.0f) {
                this.mShimmer.widthRatio = f11;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f11);
        }

        public T consumeAttributes(TypedArray typedArray) {
            if (typedArray.hasValue(3)) {
                setClipToChildren(typedArray.getBoolean(3, this.mShimmer.clipToChildren));
            }
            if (typedArray.hasValue(0)) {
                setAutoStart(typedArray.getBoolean(0, this.mShimmer.autoStart));
            }
            if (typedArray.hasValue(1)) {
                setBaseAlpha(typedArray.getFloat(1, 0.3f));
            }
            if (typedArray.hasValue(11)) {
                setHighlightAlpha(typedArray.getFloat(11, 1.0f));
            }
            if (typedArray.hasValue(7)) {
                setDuration((long) typedArray.getInt(7, (int) this.mShimmer.animationDuration));
            }
            if (typedArray.hasValue(14)) {
                setRepeatCount(typedArray.getInt(14, this.mShimmer.repeatCount));
            }
            if (typedArray.hasValue(15)) {
                setRepeatDelay((long) typedArray.getInt(15, (int) this.mShimmer.repeatDelay));
            }
            if (typedArray.hasValue(16)) {
                setRepeatMode(typedArray.getInt(16, this.mShimmer.repeatMode));
            }
            if (typedArray.hasValue(5)) {
                int i11 = typedArray.getInt(5, this.mShimmer.direction);
                if (i11 == 1) {
                    setDirection(1);
                } else if (i11 == 2) {
                    setDirection(2);
                } else if (i11 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            if (typedArray.hasValue(17)) {
                if (typedArray.getInt(17, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            if (typedArray.hasValue(6)) {
                setDropoff(typedArray.getFloat(6, this.mShimmer.dropoff));
            }
            if (typedArray.hasValue(9)) {
                setFixedWidth(typedArray.getDimensionPixelSize(9, this.mShimmer.fixedWidth));
            }
            if (typedArray.hasValue(8)) {
                setFixedHeight(typedArray.getDimensionPixelSize(8, this.mShimmer.fixedHeight));
            }
            if (typedArray.hasValue(13)) {
                setIntensity(typedArray.getFloat(13, this.mShimmer.intensity));
            }
            if (typedArray.hasValue(19)) {
                setWidthRatio(typedArray.getFloat(19, this.mShimmer.widthRatio));
            }
            if (typedArray.hasValue(10)) {
                setHeightRatio(typedArray.getFloat(10, this.mShimmer.heightRatio));
            }
            if (typedArray.hasValue(18)) {
                setTilt(typedArray.getFloat(18, this.mShimmer.tilt));
            }
            return getThis();
        }
    }
}
