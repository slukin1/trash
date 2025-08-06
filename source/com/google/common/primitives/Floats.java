package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible(emulated = true)
public final class Floats {
    public static final int BYTES = 4;

    @GwtCompatible
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final float[] array;
        public final int end;
        public final int start;

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != floatArrayAsList.array[floatArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Floats.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Float) || (access$000 = Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Float) || (access$100 = Floats.lastIndexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Float> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i13 = this.start;
            return new FloatArrayAsList(fArr, i11 + i13, i13 + i12);
        }

        public float[] toFloatArray() {
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

        public FloatArrayAsList(float[] fArr, int i11, int i12) {
            this.array = fArr;
            this.start = i11;
            this.end = i12;
        }

        public Float get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Float.valueOf(this.array[this.start + i11]);
        }

        public Float set(int i11, Float f11) {
            Preconditions.checkElementIndex(i11, size());
            float[] fArr = this.array;
            int i12 = this.start;
            float f12 = fArr[i12 + i11];
            fArr[i12 + i11] = ((Float) Preconditions.checkNotNull(f11)).floatValue();
            return Float.valueOf(f12);
        }
    }

    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        public static final FloatConverter INSTANCE = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        public String doBackward(Float f11) {
            return f11.toString();
        }

        public Float doForward(String str) {
            return Float.valueOf(str);
        }
    }

    public enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Float.compare(fArr[i11], fArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }
    }

    private Floats() {
    }

    public static List<Float> asList(float... fArr) {
        if (fArr.length == 0) {
            return Collections.emptyList();
        }
        return new FloatArrayAsList(fArr);
    }

    public static int compare(float f11, float f12) {
        return Float.compare(f11, f12);
    }

    public static float[] concat(float[]... fArr) {
        int i11 = 0;
        for (float[] length : fArr) {
            i11 += length.length;
        }
        float[] fArr2 = new float[i11];
        int i12 = 0;
        for (float[] fArr3 : fArr) {
            System.arraycopy(fArr3, 0, fArr2, i12, fArr3.length);
            i12 += fArr3.length;
        }
        return fArr2;
    }

    @Beta
    public static float constrainToRange(float f11, float f12, float f13) {
        Preconditions.checkArgument(f12 <= f13, "min (%s) must be less than or equal to max (%s)", (Object) Float.valueOf(f12), (Object) Float.valueOf(f13));
        return Math.min(Math.max(f11, f12), f13);
    }

    public static boolean contains(float[] fArr, float f11) {
        for (float f12 : fArr) {
            if (f12 == f11) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return fArr.length < i11 ? Arrays.copyOf(fArr, i11 + i12) : fArr;
    }

    public static int hashCode(float f11) {
        return Float.valueOf(f11).hashCode();
    }

    public static int indexOf(float[] fArr, float f11) {
        return indexOf(fArr, f11, 0, fArr.length);
    }

    public static boolean isFinite(float f11) {
        return Float.NEGATIVE_INFINITY < f11 && f11 < Float.POSITIVE_INFINITY;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(fArr.length * 12);
        sb2.append(fArr[0]);
        for (int i11 = 1; i11 < fArr.length; i11++) {
            sb2.append(str);
            sb2.append(fArr[i11]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(float[] fArr, float f11) {
        return lastIndexOf(fArr, f11, 0, fArr.length);
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f11 = fArr[0];
        for (int i11 = 1; i11 < fArr.length; i11++) {
            f11 = Math.max(f11, fArr[i11]);
        }
        return f11;
    }

    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f11 = fArr[0];
        for (int i11 = 1; i11 < fArr.length; i11++) {
            f11 = Math.min(f11, fArr[i11]);
        }
        return f11;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i11 = 0; i11 < length; i11++) {
            fArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).floatValue();
        }
        return fArr;
    }

    @GwtIncompatible
    @Beta
    public static Float tryParse(String str) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int indexOf(float[] fArr, float f11, int i11, int i12) {
        while (i11 < i12) {
            if (fArr[i11] == f11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(float[] fArr, float f11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (fArr[i13] == f11) {
                return i13;
            }
        }
        return -1;
    }

    public static int indexOf(float[] fArr, float[] fArr2) {
        Preconditions.checkNotNull(fArr, "array");
        Preconditions.checkNotNull(fArr2, "target");
        if (fArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (fArr.length - fArr2.length) + 1) {
            int i12 = 0;
            while (i12 < fArr2.length) {
                if (fArr[i11 + i12] != fArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(float[] fArr, int i11, int i12) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i11, i12, fArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            float f11 = fArr[i11];
            fArr[i11] = fArr[i13];
            fArr[i13] = f11;
            i11++;
        }
    }

    public static void sortDescending(float[] fArr, int i11, int i12) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i11, i12, fArr.length);
        Arrays.sort(fArr, i11, i12);
        reverse(fArr, i11, i12);
    }
}
