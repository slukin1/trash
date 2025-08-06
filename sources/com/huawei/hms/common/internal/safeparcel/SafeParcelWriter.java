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
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static void a(Parcel parcel, int i11, int i12) {
        if (parcel != null) {
            if (i12 >= 65535) {
                parcel.writeInt(i11 | -65536);
                parcel.writeInt(i12);
                return;
            }
            parcel.writeInt(i11 | (i12 << 16));
        }
    }

    private static void b(Parcel parcel, int i11) {
        if (parcel != null) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11 - 4);
            parcel.writeInt(dataPosition - i11);
            parcel.setDataPosition(dataPosition);
        }
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i11) {
        b(parcel, i11);
    }

    public static void writeBigDecimal(Parcel parcel, int i11, BigDecimal bigDecimal, boolean z11) {
        if (parcel != null) {
            if (bigDecimal != null) {
                int a11 = a(parcel, i11);
                parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
                parcel.writeInt(bigDecimal.scale());
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i11, BigDecimal[] bigDecimalArr, boolean z11) {
        if (parcel != null) {
            if (bigDecimalArr != null) {
                int a11 = a(parcel, i11);
                int length = bigDecimalArr.length;
                parcel.writeInt(length);
                for (int i12 = 0; i12 < length; i12++) {
                    parcel.writeByteArray(bigDecimalArr[i12].unscaledValue().toByteArray());
                    parcel.writeInt(bigDecimalArr[i12].scale());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBigInteger(Parcel parcel, int i11, BigInteger bigInteger, boolean z11) {
        if (parcel != null) {
            if (bigInteger != null) {
                int a11 = a(parcel, i11);
                parcel.writeByteArray(bigInteger.toByteArray());
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i11, BigInteger[] bigIntegerArr, boolean z11) {
        if (parcel != null) {
            if (bigIntegerArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeInt(r5);
                for (BigInteger byteArray : bigIntegerArr) {
                    parcel.writeByteArray(byteArray.toByteArray());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBoolean(Parcel parcel, int i11, boolean z11) {
        if (parcel != null) {
            a(parcel, i11, 4);
            if (z11) {
                parcel.writeInt(1);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i11, boolean[] zArr, boolean z11) {
        if (parcel != null) {
            if (zArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeBooleanArray(zArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBooleanList(Parcel parcel, int i11, List<Boolean> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(list.get(i12).booleanValue() ? 1 : 0);
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i11, Boolean bool, boolean z11) {
        if (parcel != null) {
            if (bool != null) {
                a(parcel, i11, 4);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeBundle(Parcel parcel, int i11, Bundle bundle, boolean z11) {
        if (parcel != null) {
            if (bundle != null) {
                int a11 = a(parcel, i11);
                parcel.writeBundle(bundle);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeByte(Parcel parcel, int i11, byte b11) {
        if (parcel != null) {
            a(parcel, i11, 4);
            parcel.writeInt(b11);
        }
    }

    public static void writeByteArray(Parcel parcel, int i11, byte[] bArr, boolean z11) {
        if (parcel != null) {
            if (bArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeByteArray(bArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i11, byte[][] bArr, boolean z11) {
        if (parcel != null) {
            if (bArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeInt(r5);
                for (byte[] writeByteArray : bArr) {
                    parcel.writeByteArray(writeByteArray);
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i11, SparseArray<byte[]> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    parcel.writeByteArray(sparseArray.valueAt(i12));
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeChar(Parcel parcel, int i11, char c11) {
        if (parcel != null) {
            a(parcel, i11, 4);
            parcel.writeInt(c11);
        }
    }

    public static void writeCharArray(Parcel parcel, int i11, char[] cArr, boolean z11) {
        if (parcel != null) {
            if (cArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeCharArray(cArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeDouble(Parcel parcel, int i11, double d11) {
        if (parcel != null) {
            a(parcel, i11, 8);
            parcel.writeDouble(d11);
        }
    }

    public static void writeDoubleArray(Parcel parcel, int i11, double[] dArr, boolean z11) {
        if (parcel != null) {
            if (dArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeDoubleArray(dArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeDoubleList(Parcel parcel, int i11, List<Double> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeDouble(list.get(i12).doubleValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i11, Double d11, boolean z11) {
        if (parcel != null) {
            if (d11 != null) {
                a(parcel, i11, 8);
                parcel.writeDouble(d11.doubleValue());
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i11, SparseArray<Double> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    parcel.writeDouble(sparseArray.valueAt(i12).doubleValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeFloat(Parcel parcel, int i11, float f11) {
        if (parcel != null) {
            a(parcel, i11, 4);
            parcel.writeFloat(f11);
        }
    }

    public static void writeFloatArray(Parcel parcel, int i11, float[] fArr, boolean z11) {
        if (parcel != null) {
            if (fArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeFloatArray(fArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeFloatList(Parcel parcel, int i11, List<Float> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeFloat(list.get(i12).floatValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeFloatObject(Parcel parcel, int i11, Float f11, boolean z11) {
        if (parcel != null) {
            if (f11 != null) {
                a(parcel, i11, 4);
                parcel.writeFloat(f11.floatValue());
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i11, SparseArray<Float> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    parcel.writeFloat(sparseArray.valueAt(i12).floatValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIBinder(Parcel parcel, int i11, IBinder iBinder, boolean z11) {
        if (parcel != null) {
            if (iBinder != null) {
                int a11 = a(parcel, i11);
                parcel.writeStrongBinder(iBinder);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i11, IBinder[] iBinderArr, boolean z11) {
        if (parcel != null) {
            if (iBinderArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeBinderArray(iBinderArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIBinderList(Parcel parcel, int i11, List<IBinder> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                parcel.writeBinderList(list);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i11, SparseArray<IBinder> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    parcel.writeStrongBinder(sparseArray.valueAt(i12));
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeInt(Parcel parcel, int i11, int i12) {
        if (parcel != null) {
            a(parcel, i11, 4);
            parcel.writeInt(i12);
        }
    }

    public static void writeIntArray(Parcel parcel, int i11, int[] iArr, boolean z11) {
        if (parcel != null) {
            if (iArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeIntArray(iArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIntegerList(Parcel parcel, int i11, List<Integer> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(list.get(i12).intValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i11, Integer num, boolean z11) {
        if (parcel != null) {
            if (num != null) {
                a(parcel, i11, 4);
                parcel.writeInt(num.intValue());
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeList(Parcel parcel, int i11, List list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                parcel.writeList(list);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeLong(Parcel parcel, int i11, long j11) {
        if (parcel != null) {
            a(parcel, i11, 8);
            parcel.writeLong(j11);
        }
    }

    public static void writeLongArray(Parcel parcel, int i11, long[] jArr, boolean z11) {
        if (parcel != null) {
            if (jArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeLongArray(jArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeLongList(Parcel parcel, int i11, List<Long> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeLong(list.get(i12).longValue());
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeLongObject(Parcel parcel, int i11, Long l11, boolean z11) {
        if (parcel != null) {
            if (l11 != null) {
                a(parcel, i11, 8);
                parcel.writeLong(l11.longValue());
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeParcel(Parcel parcel, int i11, Parcel parcel2, boolean z11) {
        if (parcel != null) {
            if (parcel2 != null) {
                int a11 = a(parcel, i11);
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeParcelArray(Parcel parcel, int i11, Parcel[] parcelArr, boolean z11) {
        if (parcel != null) {
            if (parcelArr != null) {
                int a11 = a(parcel, i11);
                int length = parcelArr.length;
                parcel.writeInt(length);
                for (int i12 = 0; i12 < length; i12++) {
                    if (parcelArr[i12] == null) {
                        parcel.writeInt(0);
                    } else {
                        parcel.writeInt(parcelArr[i12].dataSize());
                        parcel.appendFrom(parcelArr[i12], 0, parcelArr[i12].dataSize());
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeParcelList(Parcel parcel, int i11, List<Parcel> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    Parcel parcel2 = list.get(i12);
                    if (parcel2 == null) {
                        parcel.writeInt(0);
                    } else {
                        parcel.writeInt(parcel2.dataSize());
                        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i11, SparseArray<Parcel> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    Parcel valueAt = sparseArray.valueAt(i12);
                    if (valueAt == null) {
                        parcel.writeInt(0);
                    } else {
                        parcel.writeInt(valueAt.dataSize());
                        parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeParcelable(Parcel parcel, int i11, Parcelable parcelable, int i12, boolean z11) {
        if (parcel != null) {
            if (parcelable != null) {
                int a11 = a(parcel, i11);
                parcelable.writeToParcel(parcel, i12);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeShort(Parcel parcel, int i11, short s11) {
        if (parcel != null) {
            a(parcel, i11, 4);
            parcel.writeInt(s11);
        }
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i11, SparseBooleanArray sparseBooleanArray, boolean z11) {
        if (parcel != null) {
            if (sparseBooleanArray != null) {
                int a11 = a(parcel, i11);
                parcel.writeSparseBooleanArray(sparseBooleanArray);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i11, SparseIntArray sparseIntArray, boolean z11) {
        if (parcel != null) {
            if (sparseIntArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseIntArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseIntArray.keyAt(i12));
                    parcel.writeInt(sparseIntArray.valueAt(i12));
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i11, SparseLongArray sparseLongArray, boolean z11) {
        if (parcel != null) {
            if (sparseLongArray != null) {
                int a11 = a(parcel, i11);
                int size = Build.VERSION.SDK_INT >= 18 ? sparseLongArray.size() : 0;
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    int i13 = Build.VERSION.SDK_INT;
                    if (i13 >= 18) {
                        parcel.writeInt(sparseLongArray.keyAt(i12));
                    }
                    if (i13 >= 18) {
                        parcel.writeLong(sparseLongArray.valueAt(i12));
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeString(Parcel parcel, int i11, String str, boolean z11) {
        if (parcel != null) {
            if (str != null) {
                int a11 = a(parcel, i11);
                parcel.writeString(str);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeStringArray(Parcel parcel, int i11, String[] strArr, boolean z11) {
        if (parcel != null) {
            if (strArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeStringArray(strArr);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeStringList(Parcel parcel, int i11, List<String> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                parcel.writeStringList(list);
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i11, SparseArray<String> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    parcel.writeString(sparseArray.valueAt(i12));
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i11, P[] pArr, int i12, boolean z11) {
        if (parcel != null) {
            if (pArr != null) {
                int a11 = a(parcel, i11);
                parcel.writeInt(a11);
                int length = pArr.length;
                for (int i13 = 0; i13 < length; i13++) {
                    if (pArr[i13] != null) {
                        a(parcel, pArr[i13], i12);
                    } else {
                        parcel.writeInt(0);
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i11, List<T> list, boolean z11) {
        if (parcel != null) {
            if (list != null) {
                int a11 = a(parcel, i11);
                int size = list.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    Parcelable parcelable = (Parcelable) list.get(i12);
                    if (parcelable != null) {
                        a(parcel, parcelable, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i11, SparseArray<T> sparseArray, boolean z11) {
        if (parcel != null) {
            if (sparseArray != null) {
                int a11 = a(parcel, i11);
                int size = sparseArray.size();
                parcel.writeInt(size);
                for (int i12 = 0; i12 < size; i12++) {
                    parcel.writeInt(sparseArray.keyAt(i12));
                    Parcelable parcelable = (Parcelable) sparseArray.valueAt(i12);
                    if (parcelable != null) {
                        a(parcel, parcelable, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                }
                b(parcel, a11);
            } else if (z11) {
                a(parcel, i11, 0);
            }
        }
    }

    private static int a(Parcel parcel, int i11) {
        parcel.writeInt(i11 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <P extends Parcelable> void a(Parcel parcel, P p11, int i11) {
        if (parcel != null) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            p11.writeToParcel(parcel, i11);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }
    }
}
