package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@GwtIncompatible
@Beta
public final class Quantiles {

    public static final class Scale {
        private final int scale;

        public ScaleAndIndex index(int i11) {
            return new ScaleAndIndex(this.scale, i11);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        private Scale(int i11) {
            Preconditions.checkArgument(i11 > 0, "Quantile scale must be positive");
            this.scale = i11;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int divide = (int) LongMath.divide(length, (long) this.scale, RoundingMode.DOWN);
            int i11 = (int) (length - (((long) divide) * ((long) this.scale)));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i11 == 0) {
                return dArr[divide];
            }
            int i12 = divide + 1;
            Quantiles.selectInPlace(i12, dArr, i12, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i12], (double) i11, (double) this.scale);
        }

        private ScaleAndIndex(int i11, int i12) {
            Quantiles.checkIndex(i12, i11);
            this.scale = i11;
            this.index = i12;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            double[] dArr2 = dArr;
            int i11 = 0;
            Preconditions.checkArgument(dArr2.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                HashMap hashMap = new HashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i11 < length) {
                    hashMap.put(Integer.valueOf(iArr[i11]), Double.valueOf(Double.NaN));
                    i11++;
                }
                return Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i12 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i12]) * ((long) (dArr2.length - 1));
                int divide = (int) LongMath.divide(length2, (long) this.scale, RoundingMode.DOWN);
                int i14 = (int) (length2 - (((long) divide) * ((long) this.scale)));
                iArr3[i12] = divide;
                iArr4[i12] = i14;
                iArr5[i13] = divide;
                i13++;
                if (i14 != 0) {
                    iArr5[i13] = divide + 1;
                    i13++;
                }
                i12++;
            }
            Arrays.sort(iArr5, 0, i13);
            Quantiles.selectAllInPlace(iArr5, 0, i13 - 1, dArr, 0, dArr2.length - 1);
            HashMap hashMap2 = new HashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i11 >= iArr7.length) {
                    return Collections.unmodifiableMap(hashMap2);
                }
                int i15 = iArr3[i11];
                int i16 = iArr4[i11];
                if (i16 == 0) {
                    hashMap2.put(Integer.valueOf(iArr7[i11]), Double.valueOf(dArr2[i15]));
                } else {
                    hashMap2.put(Integer.valueOf(iArr7[i11]), Double.valueOf(Quantiles.interpolate(dArr2[i15], dArr2[i15 + 1], (double) i16, (double) this.scale)));
                }
                i11++;
            }
        }

        private ScaleAndIndexes(int i11, int[] iArr) {
            for (int access$300 : iArr) {
                Quantiles.checkIndex(access$300, i11);
            }
            this.scale = i11;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* access modifiers changed from: private */
    public static void checkIndex(int i11, int i12) {
        if (i11 < 0 || i11 > i12) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i12);
        }
    }

    private static int chooseNextSelection(int[] iArr, int i11, int i12, int i13, int i14) {
        if (i11 == i12) {
            return i11;
        }
        int i15 = i13 + i14;
        int i16 = i15 >>> 1;
        while (i12 > i11 + 1) {
            int i17 = (i11 + i12) >>> 1;
            if (iArr[i17] > i16) {
                i12 = i17;
            } else if (iArr[i17] >= i16) {
                return i17;
            } else {
                i11 = i17;
            }
        }
        return (i15 - iArr[i11]) - iArr[i12] > 0 ? i12 : i11;
    }

    /* access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static double interpolate(double d11, double d12, double d13, double d14) {
        if (d11 == Double.NEGATIVE_INFINITY) {
            return d12 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d12 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d11 + (((d12 - d11) * d13) / d14);
    }

    /* access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i11 = 0; i11 < length; i11++) {
            dArr[i11] = (double) iArr[i11];
        }
        return dArr;
    }

    /* access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i11 = 0; i11 < length; i11++) {
            dArr[i11] = (double) jArr[i11];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i11, int i12) {
        boolean z11 = true;
        int i13 = (i11 + i12) >>> 1;
        boolean z12 = dArr[i12] < dArr[i13];
        boolean z13 = dArr[i13] < dArr[i11];
        if (dArr[i12] >= dArr[i11]) {
            z11 = false;
        }
        if (z12 == z13) {
            swap(dArr, i13, i11);
        } else if (z12 != z11) {
            swap(dArr, i11, i12);
        }
    }

    private static int partition(double[] dArr, int i11, int i12) {
        movePivotToStartOfSlice(dArr, i11, i12);
        double d11 = dArr[i11];
        int i13 = i12;
        while (i12 > i11) {
            if (dArr[i12] > d11) {
                swap(dArr, i13, i12);
                i13--;
            }
            i12--;
        }
        swap(dArr, i11, i13);
        return i13;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i11) {
        return new Scale(i11);
    }

    /* access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i11, int i12, double[] dArr, int i13, int i14) {
        int chooseNextSelection = chooseNextSelection(iArr, i11, i12, i13, i14);
        int i15 = iArr[chooseNextSelection];
        selectInPlace(i15, dArr, i13, i14);
        int i16 = chooseNextSelection - 1;
        while (i16 >= i11 && iArr[i16] == i15) {
            i16--;
        }
        if (i16 >= i11) {
            selectAllInPlace(iArr, i11, i16, dArr, i13, i15 - 1);
        }
        int i17 = chooseNextSelection + 1;
        while (i17 <= i12 && iArr[i17] == i15) {
            i17++;
        }
        if (i17 <= i12) {
            selectAllInPlace(iArr, i17, i12, dArr, i15 + 1, i14);
        }
    }

    /* access modifiers changed from: private */
    public static void selectInPlace(int i11, double[] dArr, int i12, int i13) {
        if (i11 == i12) {
            int i14 = i12;
            for (int i15 = i12 + 1; i15 <= i13; i15++) {
                if (dArr[i14] > dArr[i15]) {
                    i14 = i15;
                }
            }
            if (i14 != i12) {
                swap(dArr, i14, i12);
                return;
            }
            return;
        }
        while (i13 > i12) {
            int partition = partition(dArr, i12, i13);
            if (partition >= i11) {
                i13 = partition - 1;
            }
            if (partition <= i11) {
                i12 = partition + 1;
            }
        }
    }

    private static void swap(double[] dArr, int i11, int i12) {
        double d11 = dArr[i11];
        dArr[i11] = dArr[i12];
        dArr[i12] = d11;
    }
}
