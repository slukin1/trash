package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
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

    public static int beginObjectHeader(Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i11) {
        zzb(parcel, i11);
    }

    public static void writeBigDecimal(Parcel parcel, int i11, BigDecimal bigDecimal, boolean z11) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i11, BigDecimal[] bigDecimalArr, boolean z11) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i11);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i12 = 0; i12 < length; i12++) {
                parcel.writeByteArray(bigDecimalArr[i12].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i12].scale());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i11, BigInteger bigInteger, boolean z11) {
        if (bigInteger != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i11, BigInteger[] bigIntegerArr, boolean z11) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int i11, boolean z11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i11, boolean[] zArr, boolean z11) {
        if (zArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i11, List<Boolean> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(list.get(i12).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i11, Boolean bool, boolean z11) {
        if (bool != null) {
            zzc(parcel, i11, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i11, Bundle bundle, boolean z11) {
        if (bundle != null) {
            int zza = zza(parcel, i11);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i11, byte b11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(b11);
    }

    public static void writeByteArray(Parcel parcel, int i11, byte[] bArr, boolean z11) {
        if (bArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i11, byte[][] bArr, boolean z11) {
        if (bArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i11, SparseArray<byte[]> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeByteArray(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeChar(Parcel parcel, int i11, char c11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(c11);
    }

    public static void writeCharArray(Parcel parcel, int i11, char[] cArr, boolean z11) {
        if (cArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i11, double d11) {
        zzc(parcel, i11, 8);
        parcel.writeDouble(d11);
    }

    public static void writeDoubleArray(Parcel parcel, int i11, double[] dArr, boolean z11) {
        if (dArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i11, List<Double> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeDouble(list.get(i12).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i11, Double d11, boolean z11) {
        if (d11 != null) {
            zzc(parcel, i11, 8);
            parcel.writeDouble(d11.doubleValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i11, SparseArray<Double> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeDouble(sparseArray.valueAt(i12).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i11, float f11) {
        zzc(parcel, i11, 4);
        parcel.writeFloat(f11);
    }

    public static void writeFloatArray(Parcel parcel, int i11, float[] fArr, boolean z11) {
        if (fArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i11, List<Float> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeFloat(list.get(i12).floatValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i11, Float f11, boolean z11) {
        if (f11 != null) {
            zzc(parcel, i11, 4);
            parcel.writeFloat(f11.floatValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i11, SparseArray<Float> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeFloat(sparseArray.valueAt(i12).floatValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i11, IBinder iBinder, boolean z11) {
        if (iBinder != null) {
            int zza = zza(parcel, i11);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i11, IBinder[] iBinderArr, boolean z11) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i11, List<IBinder> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i11, SparseArray<IBinder> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeStrongBinder(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeInt(Parcel parcel, int i11, int i12) {
        zzc(parcel, i11, 4);
        parcel.writeInt(i12);
    }

    public static void writeIntArray(Parcel parcel, int i11, int[] iArr, boolean z11) {
        if (iArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i11, List<Integer> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(list.get(i12).intValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i11, Integer num, boolean z11) {
        if (num != null) {
            zzc(parcel, i11, 4);
            parcel.writeInt(num.intValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeList(Parcel parcel, int i11, List list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i11, long j11) {
        zzc(parcel, i11, 8);
        parcel.writeLong(j11);
    }

    public static void writeLongArray(Parcel parcel, int i11, long[] jArr, boolean z11) {
        if (jArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i11, List<Long> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeLong(list.get(i12).longValue());
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int i11, Long l11, boolean z11) {
        if (l11 != null) {
            zzc(parcel, i11, 8);
            parcel.writeLong(l11.longValue());
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i11, Parcel parcel2, boolean z11) {
        if (parcel2 != null) {
            int zza = zza(parcel, i11);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i11, Parcel[] parcelArr, boolean z11) {
        if (parcelArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int i11, List<Parcel> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcel parcel2 = list.get(i12);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i11, SparseArray<Parcel> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                Parcel valueAt = sparseArray.valueAt(i12);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i11, Parcelable parcelable, int i12, boolean z11) {
        if (parcelable != null) {
            int zza = zza(parcel, i11);
            parcelable.writeToParcel(parcel, i12);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writePendingIntent(Parcel parcel, int i11, PendingIntent pendingIntent, boolean z11) {
        if (pendingIntent != null) {
            int zza = zza(parcel, i11);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i11, short s11) {
        zzc(parcel, i11, 4);
        parcel.writeInt(s11);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i11, SparseBooleanArray sparseBooleanArray, boolean z11) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i11);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i11, SparseIntArray sparseIntArray, boolean z11) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseIntArray.keyAt(i12));
                parcel.writeInt(sparseIntArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i11, SparseLongArray sparseLongArray, boolean z11) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseLongArray.keyAt(i12));
                parcel.writeLong(sparseLongArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeString(Parcel parcel, int i11, String str, boolean z11) {
        if (str != null) {
            int zza = zza(parcel, i11);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i11, String[] strArr, boolean z11) {
        if (strArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i11, List<String> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i11, SparseArray<String> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                parcel.writeString(sparseArray.valueAt(i12));
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i11, T[] tArr, int i12, boolean z11) {
        if (tArr != null) {
            int zza = zza(parcel, i11);
            parcel.writeInt(r7);
            for (T t11 : tArr) {
                if (t11 == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, t11, i12);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i11, List<T> list, boolean z11) {
        if (list != null) {
            int zza = zza(parcel, i11);
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                Parcelable parcelable = (Parcelable) list.get(i12);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i11, SparseArray<T> sparseArray, boolean z11) {
        if (sparseArray != null) {
            int zza = zza(parcel, i11);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                parcel.writeInt(sparseArray.keyAt(i12));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i12);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z11) {
            zzc(parcel, i11, 0);
        }
    }

    private static int zza(Parcel parcel, int i11) {
        parcel.writeInt(i11 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i11) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i11 - 4);
        parcel.writeInt(dataPosition - i11);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i11, int i12) {
        parcel.writeInt(i11 | (i12 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i11) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i11);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
