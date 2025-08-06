package com.huawei.hms.common.internal.safeparcel;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                java.lang.String r1 = java.lang.String.valueOf(r3)
                int r1 = r1.length()
                int r1 = r1 + 41
                r0.<init>(r1)
                r0.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r0.append(r3)
                int r3 = r4.dataPosition()
                r0.append(r3)
                java.lang.String r3 = " size="
                r0.append(r3)
                int r3 = r4.dataSize()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    private SafeParcelReader() {
    }

    private static void a(Parcel parcel, int i11, int i12, int i13) {
        if (i12 != i13) {
            String hexString = Integer.toHexString(i12);
            StringBuilder sb2 = new StringBuilder(hexString.length() + 46);
            sb2.append("Expected size ");
            sb2.append(i13);
            sb2.append(" got ");
            sb2.append(i12);
            sb2.append(" (0x");
            sb2.append(hexString);
            sb2.append(")");
            throw new ParseException(sb2.toString(), parcel);
        }
    }

    private static boolean a(int i11, int i12) {
        long j11 = ((long) i11) + ((long) i12);
        return j11 > 2147483647L || j11 < -2147483648L;
    }

    private static void b(Parcel parcel, int i11, int i12) {
        int readSize = readSize(parcel, i11);
        if (readSize != i12) {
            String hexString = Integer.toHexString(readSize);
            StringBuilder sb2 = new StringBuilder(hexString.length() + 46);
            sb2.append("Expected size ");
            sb2.append(i12);
            sb2.append(" got ");
            sb2.append(readSize);
            sb2.append(" (0x");
            sb2.append(hexString);
            sb2.append(")");
            throw new ParseException(sb2.toString(), parcel);
        }
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigDecimal[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new BigInteger[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new boolean[0];
        }
        a(parcel, readSize, dataPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBooleanArray;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static Bundle createBundle(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new byte[0];
        }
        a(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createByteArray;
    }

    public static byte[][] createByteArrayArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        byte[][] bArr = new byte[readInt][];
        for (int i12 = 0; i12 < readInt; i12++) {
            bArr[i12] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bArr;
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<byte[]> sparseArray = new SparseArray<>(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static char[] createCharArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new char[0];
        }
        a(parcel, readSize, dataPosition);
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createCharArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new double[0];
        }
        a(parcel, readSize, dataPosition);
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createDoubleArray;
    }

    public static ArrayList<Double> createDoubleList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Double> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<Double> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static float[] createFloatArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new float[0];
        }
        a(parcel, readSize, dataPosition);
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createFloatArray;
    }

    public static ArrayList<Float> createFloatList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Float> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<Float> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new IBinder[0];
        }
        a(parcel, readSize, dataPosition);
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArray;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<IBinder> sparseArray = new SparseArray<>(readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static int[] createIntArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new int[0];
        }
        a(parcel, readSize, dataPosition);
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static long[] createLongArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new long[0];
        }
        a(parcel, readSize, dataPosition);
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createLongArray;
    }

    public static ArrayList<Long> createLongList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<Long> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static Parcel createParcel(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        return obtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new Parcel[0];
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                parcelArr[i12] = null;
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i12] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    public static ArrayList<Parcel> createParcelList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                arrayList.add((Object) null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt2, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 == 0) {
                sparseArray.append(readInt2, (Object) null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                a(parcel, readInt3, dataPosition2);
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <P extends Parcelable> P createParcelable(Parcel parcel, int i11, Parcelable.Creator<P> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        P p11 = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        return p11;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return readSparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseIntArray;
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int i11) {
        SparseLongArray sparseLongArray = null;
        if (parcel == null) {
            return null;
        }
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        if (Build.VERSION.SDK_INT >= 18) {
            sparseLongArray = new SparseLongArray();
        }
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            if (Build.VERSION.SDK_INT >= 18) {
                sparseLongArray.append(parcel.readInt(), parcel.readLong());
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseLongArray;
    }

    public static String createString(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        return readString;
    }

    public static String[] createStringArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new String[0];
        }
        a(parcel, readSize, dataPosition);
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArrayList;
    }

    public static SparseArray<String> createStringSparseArray(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        SparseArray<String> sparseArray = new SparseArray<>();
        int readInt = parcel.readInt();
        a(parcel, readInt);
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <C> C[] createTypedArray(Parcel parcel, int i11, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return creator.newArray(0);
        }
        a(parcel, readSize, dataPosition);
        C[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return createTypedArray;
    }

    public static <C> ArrayList<C> createTypedList(Parcel parcel, int i11, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        ArrayList<C> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return createTypedArrayList;
    }

    public static <C> SparseArray<C> createTypedSparseArray(Parcel parcel, int i11, Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        a(parcel, readInt);
        SparseArray<C> sparseArray = new SparseArray<>();
        for (int i12 = 0; i12 < readInt; i12++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static void ensureAtEnd(Parcel parcel, int i11) {
        if (parcel.dataPosition() != i11) {
            throw new ParseException("Overread allowed size end=" + i11, parcel);
        }
    }

    public static int getFieldId(int i11) {
        return i11 & 65535;
    }

    public static boolean readBoolean(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return Boolean.FALSE;
        }
        a(parcel, i11, readSize, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte readByte(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return (byte) parcel.readInt();
    }

    public static char readChar(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return (char) parcel.readInt();
    }

    public static double readDouble(Parcel parcel, int i11) {
        b(parcel, i11, 8);
        return parcel.readDouble();
    }

    public static Double readDoubleObject(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i11, readSize, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i11, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        a(parcel, readSize, dataPosition);
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return parcel.readInt();
    }

    public static Integer readIntegerObject(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i11, readSize, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void readList(Parcel parcel, int i11, List list, ClassLoader classLoader) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        if (readSize != 0) {
            a(parcel, readSize, dataPosition);
            parcel.readList(list, classLoader);
            parcel.setDataPosition(readSize + dataPosition);
        }
    }

    public static long readLong(Parcel parcel, int i11) {
        b(parcel, i11, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        if (readSize == 0) {
            return null;
        }
        a(parcel, i11, readSize, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short readShort(Parcel parcel, int i11) {
        b(parcel, i11, 4);
        return (short) parcel.readInt();
    }

    public static int readSize(Parcel parcel, int i11) {
        return (i11 & -65536) != -65536 ? (i11 >> 16) & 65535 : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i11) {
        int readSize = readSize(parcel, i11);
        int dataPosition = parcel.dataPosition();
        a(parcel, readSize, dataPosition);
        parcel.setDataPosition(readSize + dataPosition);
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != 20293) {
            String str = "Expected object header. Got 0x";
            String hexString = Integer.toHexString(readHeader);
            if (hexString.length() != 0) {
                str = str.concat(hexString);
            }
            throw new ParseException(str, parcel);
        }
        int i11 = readSize + dataPosition;
        if (i11 >= dataPosition && i11 <= parcel.dataSize()) {
            return i11;
        }
        throw new ParseException("invalid start=" + dataPosition + " end=" + i11, parcel);
    }

    private static void a(Parcel parcel, int i11, int i12) {
        if (i11 < 0 || a(i11, i12)) {
            throw new ParseException("dataPosition cannot be beyond integer scope", parcel);
        }
    }

    private static void a(Parcel parcel, int i11) {
        if (i11 > 1024) {
            throw new ParseException("arraySize cannot be beyond 65535", parcel);
        }
    }
}
