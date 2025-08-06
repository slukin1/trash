package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Bytes {

    @GwtCompatible
    public static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] array;
        public final int end;
        public final int start;

        public ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (this.array[this.start + i11] != byteArrayAsList.array[byteArrayAsList.start + i11]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i11 = 1;
            for (int i12 = this.start; i12 < this.end; i12++) {
                i11 = (i11 * 31) + Bytes.hashCode(this.array[i12]);
            }
            return i11;
        }

        public int indexOf(Object obj) {
            int access$000;
            if (!(obj instanceof Byte) || (access$000 = Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$000 - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int access$100;
            if (!(obj instanceof Byte) || (access$100 = Bytes.lastIndexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return access$100 - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        public List<Byte> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            if (i11 == i12) {
                return Collections.emptyList();
            }
            byte[] bArr = this.array;
            int i13 = this.start;
            return new ByteArrayAsList(bArr, i11 + i13, i13 + i12);
        }

        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
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

        public ByteArrayAsList(byte[] bArr, int i11, int i12) {
            this.array = bArr;
            this.start = i11;
            this.end = i12;
        }

        public Byte get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Byte.valueOf(this.array[this.start + i11]);
        }

        public Byte set(int i11, Byte b11) {
            Preconditions.checkElementIndex(i11, size());
            byte[] bArr = this.array;
            int i12 = this.start;
            byte b12 = bArr[i12 + i11];
            bArr[i12 + i11] = ((Byte) Preconditions.checkNotNull(b11)).byteValue();
            return Byte.valueOf(b12);
        }
    }

    private Bytes() {
    }

    public static List<Byte> asList(byte... bArr) {
        if (bArr.length == 0) {
            return Collections.emptyList();
        }
        return new ByteArrayAsList(bArr);
    }

    public static byte[] concat(byte[]... bArr) {
        int i11 = 0;
        for (byte[] length : bArr) {
            i11 += length.length;
        }
        byte[] bArr2 = new byte[i11];
        int i12 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i12, bArr3.length);
            i12 += bArr3.length;
        }
        return bArr2;
    }

    public static boolean contains(byte[] bArr, byte b11) {
        for (byte b12 : bArr) {
            if (b12 == b11) {
                return true;
            }
        }
        return false;
    }

    public static byte[] ensureCapacity(byte[] bArr, int i11, int i12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Invalid minLength: %s", i11);
        if (i12 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid padding: %s", i12);
        return bArr.length < i11 ? Arrays.copyOf(bArr, i11 + i12) : bArr;
    }

    public static int hashCode(byte b11) {
        return b11;
    }

    public static int indexOf(byte[] bArr, byte b11) {
        return indexOf(bArr, b11, 0, bArr.length);
    }

    public static int lastIndexOf(byte[] bArr, byte b11) {
        return lastIndexOf(bArr, b11, 0, bArr.length);
    }

    public static void reverse(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        reverse(bArr, 0, bArr.length);
    }

    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).toByteArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = ((Number) Preconditions.checkNotNull(array[i11])).byteValue();
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public static int indexOf(byte[] bArr, byte b11, int i11, int i12) {
        while (i11 < i12) {
            if (bArr[i11] == b11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(byte[] bArr, byte b11, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (bArr[i13] == b11) {
                return i13;
            }
        }
        return -1;
    }

    public static int indexOf(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr, "array");
        Preconditions.checkNotNull(bArr2, "target");
        if (bArr2.length == 0) {
            return 0;
        }
        int i11 = 0;
        while (i11 < (bArr.length - bArr2.length) + 1) {
            int i12 = 0;
            while (i12 < bArr2.length) {
                if (bArr[i11 + i12] != bArr2[i12]) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return i11;
        }
        return -1;
    }

    public static void reverse(byte[] bArr, int i11, int i12) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i11, i12, bArr.length);
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[i13];
            bArr[i13] = b11;
            i11++;
        }
    }
}
