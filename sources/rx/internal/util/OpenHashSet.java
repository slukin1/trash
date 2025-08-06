package rx.internal.util;

import java.util.Arrays;
import rx.functions.Action1;
import rx.internal.util.unsafe.Pow2;

public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    public T[] keys;
    public final float loadFactor;
    public int mask;
    public int maxSize;
    public int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public static int mix(int i11) {
        int i12 = i11 * -1640531527;
        return i12 ^ (i12 >>> 16);
    }

    public boolean add(T t11) {
        T t12;
        T[] tArr = this.keys;
        int i11 = this.mask;
        int mix = mix(t11.hashCode()) & i11;
        T t13 = tArr[mix];
        if (t13 != null) {
            if (t13.equals(t11)) {
                return false;
            }
            do {
                mix = (mix + 1) & i11;
                t12 = tArr[mix];
                if (t12 == null) {
                }
            } while (!t12.equals(t11));
            return false;
        }
        tArr[mix] = t11;
        int i12 = this.size + 1;
        this.size = i12;
        if (i12 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public void clear(Action1<? super T> action1) {
        if (this.size != 0) {
            T[] tArr = this.keys;
            for (T t11 : tArr) {
                if (t11 != null) {
                    action1.call(t11);
                }
            }
            Arrays.fill(tArr, (Object) null);
            this.size = 0;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void rehash() {
        T[] tArr = this.keys;
        int length = tArr.length;
        int i11 = length << 1;
        int i12 = i11 - 1;
        T[] tArr2 = new Object[i11];
        int i13 = this.size;
        while (true) {
            int i14 = i13 - 1;
            if (i13 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int mix = mix(tArr[length].hashCode()) & i12;
                if (tArr2[mix] != null) {
                    do {
                        mix = (mix + 1) & i12;
                    } while (tArr2[mix] != null);
                }
                tArr2[mix] = tArr[length];
                i13 = i14;
            } else {
                this.mask = i12;
                this.maxSize = (int) (((float) i11) * this.loadFactor);
                this.keys = tArr2;
                return;
            }
        }
    }

    public boolean remove(T t11) {
        T t12;
        T[] tArr = this.keys;
        int i11 = this.mask;
        int mix = mix(t11.hashCode()) & i11;
        T t13 = tArr[mix];
        if (t13 == null) {
            return false;
        }
        if (t13.equals(t11)) {
            return removeEntry(mix, tArr, i11);
        }
        do {
            mix = (mix + 1) & i11;
            t12 = tArr[mix];
            if (t12 == null) {
                return false;
            }
        } while (!t12.equals(t11));
        return removeEntry(mix, tArr, i11);
    }

    public boolean removeEntry(int i11, T[] tArr, int i12) {
        int i13;
        T t11;
        this.size--;
        while (true) {
            int i14 = i11 + 1;
            while (true) {
                i13 = i14 & i12;
                t11 = tArr[i13];
                if (t11 == null) {
                    tArr[i11] = null;
                    return true;
                }
                int mix = mix(t11.hashCode()) & i12;
                if (i11 <= i13) {
                    if (i11 >= mix || mix > i13) {
                        break;
                    }
                    i14 = i13 + 1;
                } else {
                    if (i11 >= mix && mix > i13) {
                        break;
                    }
                    i14 = i13 + 1;
                }
            }
            tArr[i11] = t11;
            i11 = i13;
        }
    }

    public void terminate() {
        this.size = 0;
        this.keys = new Object[0];
    }

    public T[] values() {
        return this.keys;
    }

    public OpenHashSet(int i11) {
        this(i11, 0.75f);
    }

    public OpenHashSet(int i11, float f11) {
        this.loadFactor = f11;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f11 * ((float) roundToPowerOfTwo));
        this.keys = new Object[roundToPowerOfTwo];
    }
}
