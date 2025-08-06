package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class XMSSUtil {

    public static class CheckingStream extends ObjectInputStream {
        private static final Set components;
        private boolean found = false;
        private final Class mainClass;

        static {
            HashSet hashSet = new HashSet();
            components = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        public CheckingStream(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.mainClass = cls;
        }

        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (!this.found) {
                if (objectStreamClass.getName().equals(this.mainClass.getName())) {
                    this.found = true;
                } else {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else if (!components.contains(objectStreamClass.getName())) {
                throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public static boolean areEqual(byte[][] bArr, byte[][] bArr2) {
        if (hasNullPointer(bArr) || hasNullPointer(bArr2)) {
            throw new NullPointerException("a or b == null");
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (!Arrays.areEqual(bArr[i11], bArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static long bytesToXBigEndian(byte[] bArr, int i11, int i12) {
        Objects.requireNonNull(bArr, "in == null");
        long j11 = 0;
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            j11 = (j11 << 8) | ((long) (bArr[i13] & 255));
        }
        return j11;
    }

    public static int calculateTau(int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (((i11 >> i13) & 1) == 0) {
                return i13;
            }
        }
        return 0;
    }

    public static byte[] cloneArray(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[][] cloneArray(byte[][] bArr) {
        if (!hasNullPointer(bArr)) {
            byte[][] bArr2 = new byte[bArr.length][];
            for (int i11 = 0; i11 < bArr.length; i11++) {
                bArr2[i11] = new byte[bArr[i11].length];
                System.arraycopy(bArr[i11], 0, bArr2[i11], 0, bArr[i11].length);
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void copyBytesAtOffset(byte[] bArr, byte[] bArr2, int i11) {
        Objects.requireNonNull(bArr, "dst == null");
        Objects.requireNonNull(bArr2, "src == null");
        if (i11 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i11 <= bArr.length) {
            for (int i12 = 0; i12 < bArr2.length; i12++) {
                bArr[i11 + i12] = bArr2[i12];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static Object deserialize(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        CheckingStream checkingStream = new CheckingStream(cls, new ByteArrayInputStream(bArr));
        Object readObject = checkingStream.readObject();
        if (checkingStream.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        } else if (cls.isInstance(readObject)) {
            return readObject;
        } else {
            throw new IOException("unexpected class found in ObjectInputStream");
        }
    }

    public static void dumpByteArray(byte[][] bArr) {
        if (!hasNullPointer(bArr)) {
            for (byte[] hexString : bArr) {
                System.out.println(Hex.toHexString(hexString));
            }
            return;
        }
        throw new NullPointerException("x has null pointers");
    }

    public static byte[] extractBytesAtOffset(byte[] bArr, int i11, int i12) {
        Objects.requireNonNull(bArr, "src == null");
        if (i11 < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i12 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i11 + i12 <= bArr.length) {
            byte[] bArr2 = new byte[i12];
            for (int i13 = 0; i13 < i12; i13++) {
                bArr2[i13] = bArr[i11 + i13];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static int getDigestSize(Digest digest) {
        Objects.requireNonNull(digest, "digest == null");
        String algorithmName = digest.getAlgorithmName();
        if (algorithmName.equals("SHAKE128")) {
            return 32;
        }
        if (algorithmName.equals("SHAKE256")) {
            return 64;
        }
        return digest.getDigestSize();
    }

    public static int getLeafIndex(long j11, int i11) {
        return (int) (j11 & ((1 << i11) - 1));
    }

    public static long getTreeIndex(long j11, int i11) {
        return j11 >> i11;
    }

    public static boolean hasNullPointer(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIndexValid(int i11, long j11) {
        if (j11 >= 0) {
            return j11 < (1 << i11);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean isNewAuthenticationPathNeeded(long j11, int i11, int i12) {
        return j11 != 0 && (j11 + 1) % ((long) Math.pow((double) (1 << i11), (double) i12)) == 0;
    }

    public static boolean isNewBDSInitNeeded(long j11, int i11, int i12) {
        return j11 != 0 && j11 % ((long) Math.pow((double) (1 << i11), (double) (i12 + 1))) == 0;
    }

    public static int log2(int i11) {
        int i12 = 0;
        while (true) {
            i11 >>= 1;
            if (i11 == 0) {
                return i12;
            }
            i12++;
        }
    }

    public static void longToBigEndian(long j11, byte[] bArr, int i11) {
        Objects.requireNonNull(bArr, "in == null");
        if (bArr.length - i11 >= 8) {
            bArr[i11] = (byte) ((int) ((j11 >> 56) & 255));
            bArr[i11 + 1] = (byte) ((int) ((j11 >> 48) & 255));
            bArr[i11 + 2] = (byte) ((int) ((j11 >> 40) & 255));
            bArr[i11 + 3] = (byte) ((int) ((j11 >> 32) & 255));
            bArr[i11 + 4] = (byte) ((int) ((j11 >> 24) & 255));
            bArr[i11 + 5] = (byte) ((int) ((j11 >> 16) & 255));
            bArr[i11 + 6] = (byte) ((int) ((j11 >> 8) & 255));
            bArr[i11 + 7] = (byte) ((int) (j11 & 255));
            return;
        }
        throw new IllegalArgumentException("not enough space in array");
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toBytesBigEndian(long j11, int i11) {
        byte[] bArr = new byte[i11];
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            bArr[i12] = (byte) ((int) j11);
            j11 >>>= 8;
        }
        return bArr;
    }
}
