package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtIncompatible
@Beta
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {

        /* renamed from: x1  reason: collision with root package name */
        private final double f66954x1;

        /* renamed from: y1  reason: collision with root package name */
        private final double f66955y1;

        public LinearTransformation and(double d11, double d12) {
            boolean z11 = true;
            Preconditions.checkArgument(DoubleUtils.isFinite(d11) && DoubleUtils.isFinite(d12));
            double d13 = this.f66954x1;
            if (d11 != d13) {
                return withSlope((d12 - this.f66955y1) / (d11 - d13));
            }
            if (d12 == this.f66955y1) {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            return new VerticalLinearTransformation(this.f66954x1);
        }

        public LinearTransformation withSlope(double d11) {
            Preconditions.checkArgument(!Double.isNaN(d11));
            if (DoubleUtils.isFinite(d11)) {
                return new RegularLinearTransformation(d11, this.f66955y1 - (this.f66954x1 * d11));
            }
            return new VerticalLinearTransformation(this.f66954x1);
        }

        private LinearTransformationBuilder(double d11, double d12) {
            this.f66954x1 = d11;
            this.f66955y1 = d12;
        }
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        public static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        public LinearTransformation inverse() {
            return this;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        public double transform(double d11) {
            return Double.NaN;
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d11) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d11));
        return new RegularLinearTransformation(0.0d, d11);
    }

    public static LinearTransformationBuilder mapping(double d11, double d12) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d11) && DoubleUtils.isFinite(d12));
        return new LinearTransformationBuilder(d11, d12);
    }

    public static LinearTransformation vertical(double d11) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d11));
        return new VerticalLinearTransformation(d11);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d11);

    public static final class VerticalLinearTransformation extends LinearTransformation {
        @LazyInit
        public LinearTransformation inverse;

        /* renamed from: x  reason: collision with root package name */
        public final double f66956x;

        public VerticalLinearTransformation(double d11) {
            this.f66956x = d11;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f66956x, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return true;
        }

        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f66956x)});
        }

        public double transform(double d11) {
            throw new IllegalStateException();
        }

        public VerticalLinearTransformation(double d11, LinearTransformation linearTransformation) {
            this.f66956x = d11;
            this.inverse = linearTransformation;
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {
        @LazyInit
        public LinearTransformation inverse;
        public final double slope;
        public final double yIntercept;

        public RegularLinearTransformation(double d11, double d12) {
            this.slope = d11;
            this.yIntercept = d12;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            double d11 = this.slope;
            if (d11 != 0.0d) {
                return new RegularLinearTransformation(1.0d / d11, (this.yIntercept * -1.0d) / d11, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
        }

        public double transform(double d11) {
            return (d11 * this.slope) + this.yIntercept;
        }

        public RegularLinearTransformation(double d11, double d12, LinearTransformation linearTransformation) {
            this.slope = d11;
            this.yIntercept = d12;
            this.inverse = linearTransformation;
        }
    }
}
