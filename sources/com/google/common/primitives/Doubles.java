package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Doubles {
    public static final int BYTES = 8;
    @GwtIncompatible
    public static final Pattern FLOATING_POINT_PATTERN = fpPattern();

    @GwtCompatible
    public static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final double[] array;
        public final int end;
        public final int start;

        public DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != doubleArrayAsList.array[doubleArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Doubles.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Double) || (access$000 = Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Double) || (access$100 = Doubles.lastIndexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Double> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i13 = this.start;
            return new DoubleArrayAsList(dArr, i11 + i13, i13 + i12);
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i11 = this.start;
            while (true) {
                i11++;
                if (i11 < this.end) {
                    sb2.append(", ");
                    sb2.append(this.array[i11]);
                } else {
                    sb2.append(']');
                    return sb2.toString();
                }
            }
        }

        public DoubleArrayAsList(double[] dArr, int i11, int i12) {
            this.array = dArr;
            this.start = i11;
            this.end = i12;
        }

        public Double get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Double.valueOf(this.array[this.start + i11]);
        }

        public Double set(int i11, Double d11) {
            Preconditions.checkElementIndex(i11, size());
            double[] dArr = this.array;
            int i12 = this.start;
            double d12 = dArr[i12 + i11];
            dArr[i12 + i11] = ((Double) Preconditions.checkNotNull(d11)).doubleValue();
            return Double.valueOf(d12);
        }
    }

    public static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        public static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }

        public String doBackward(Double d11) {
            return d11.toString();
        }

        public Double doForward(String str) {
            return Double.valueOf(str);
        }
    }

    public enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Double.compare(dArr[i11], dArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }
    }

    private Doubles() {
    }

    public static List<Double> asList(double... dArr) {
        if (dArr.length == 0) {
            return Collections.emptyList();
        }
        return new DoubleArrayAsList(dArr);
    }

    public static int compare(double d11, double d12) {
        return Double.compare(d11, d12);
    }

    public static double[] concat(double[]... dArr) {
        int i11 = 0;
        for (double[] length : dArr) {
            i11 += length.length;
        }
        double[] dArr2 = new double[i11];
        int i12 = 0;
        for (double[] dArr3 : dArr) {
            System.arraycopy(dArr3, 0, dArr2, i12, dArr3.length);
            i12 += dArr3.length;
        }
        return dArr2;
    }

    @Beta
    public static double constrainToRange(double d11, double d12, double d13) {
        Preconditions.checkArgument(d12 <= d13, "min (%s) must be less than or equal to max (%s)", (Object) Double.valueOf(d12), (Object) Double.valueOf(d13));
        return Math.min(Math.max(d11, d12), d13);
    }

    public static boolean contains(double[] dArr, double d11) {
        for (double d12 : dArr) {
            if (d12 == d11) {
                return true;
            }
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return dArr.length < i11 ? Arrays.copyOf(dArr, i11 + i12) : dArr;
    }

    @GwtIncompatible
    private static Pattern fpPattern() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)" + "(?:[eE][+-]?\\d+#)?[fFdD]?") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + ("0[xX]" + "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)" + "[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int hashCode(double d11) {
        return Double.valueOf(d11).hashCode();
    }

    public static int indexOf(double[] dArr, double d11) {
        return indexOf(dArr, d11, 0, dArr.length);
    }

    public static boolean isFinite(double d11) {
        return Double.NEGATIVE_INFINITY < d11 && d11 < Double.POSITIVE_INFINITY;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(dArr.length * 12);
        sb2.append(dArr[0]);
        for (int i11 = 1; i11 < dArr.length; i11++) {
            sb2.append(str);
            sb2.append(dArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(double[] dArr, double d11) {
        return lastIndexOf(dArr, d11, 0, dArr.length);
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static double max(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d11 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            d11 = Math.max(d11, dArr[i11]);
        }
        return d11;
    }

    public static double min(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d11 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            d11 = Math.min(d11, dArr[i11]);
        }
        return d11;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    @Beta
    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i11 = 0; i11 < length; i11++) {
            dArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).doubleValue();
        }
        return dArr;
    }

    @GwtIncompatible
    @Beta
    public static Double tryParse(String str) {
        if (!FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int indexOf(double[] dArr, double d11, int i11, int i12) {
        while (i11 < i12) {
            if (dArr[i11] == d11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(double[] dArr, double d11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (dArr[i13] == d11) {
                return i13;
            }
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double[] dArr2) {
        Preconditions.checkNotNull(dArr, "array");
        Preconditions.checkNotNull(dArr2, "target");
        if (dArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (dArr.length - dArr2.length) + 1) {
            int i12 = 0;
            while (i12 < dArr2.length) {
                if (dArr[i11 + i12] != dArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(double[] dArr, int i11, int i12) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i11, i12, dArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            double d11 = dArr[i11];
            dArr[i11] = dArr[i13];
            dArr[i13] = d11;
            i11++;
        }
    }

    public static void sortDescending(double[] dArr, int i11, int i12) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i11, i12, dArr.length);
        Arrays.sort(dArr, i11, i12);
        reverse(dArr, i11, i12);
    }
}
