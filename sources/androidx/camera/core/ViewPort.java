package androidx.camera.core;

import android.util.Rational;
import androidx.core.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPort {
    public static final int FILL_CENTER = 1;
    public static final int FILL_END = 2;
    public static final int FILL_START = 0;
    public static final int FIT = 3;
    private Rational mAspectRatio;
    private int mLayoutDirection;
    private int mRotation;
    private int mScaleType;

    public static final class Builder {
        private static final int DEFAULT_LAYOUT_DIRECTION = 0;
        private static final int DEFAULT_SCALE_TYPE = 1;
        private final Rational mAspectRatio;
        private int mLayoutDirection = 0;
        private final int mRotation;
        private int mScaleType = 1;

        public Builder(Rational rational, int i11) {
            this.mAspectRatio = rational;
            this.mRotation = i11;
        }

        public ViewPort build() {
            h.h(this.mAspectRatio, "The crop aspect ratio must be set.");
            return new ViewPort(this.mScaleType, this.mAspectRatio, this.mRotation, this.mLayoutDirection);
        }

        public Builder setLayoutDirection(int i11) {
            this.mLayoutDirection = i11;
            return this;
        }

        public Builder setScaleType(int i11) {
            this.mScaleType = i11;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScaleType {
    }

    public ViewPort(int i11, Rational rational, int i12, int i13) {
        this.mScaleType = i11;
        this.mAspectRatio = rational;
        this.mRotation = i12;
        this.mLayoutDirection = i13;
    }

    public Rational getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getScaleType() {
        return this.mScaleType;
    }
}
