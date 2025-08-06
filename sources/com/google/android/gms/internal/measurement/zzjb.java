package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class zzjb extends zziw implements Set {
    private transient zzja zza;

    public static int zzf(int i11) {
        int max = Math.max(i11, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzjb zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[15];
        objArr2[0] = "_in";
        objArr2[1] = "_xa";
        objArr2[2] = "_xu";
        objArr2[3] = "_aq";
        objArr2[4] = "_aa";
        objArr2[5] = "_ai";
        System.arraycopy(objArr, 0, objArr2, 6, 9);
        return zzk(15, objArr2);
    }

    private static zzjb zzk(int i11, Object... objArr) {
        if (i11 == 0) {
            return zzjf.zza;
        }
        if (i11 != 1) {
            int zzf = zzf(i11);
            Object[] objArr2 = new Object[zzf];
            int i12 = zzf - 1;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                Object obj = objArr[i15];
                zzjd.zza(obj, i15);
                int hashCode = obj.hashCode();
                int zza2 = zzit.zza(hashCode);
                while (true) {
                    int i16 = zza2 & i12;
                    Object obj2 = objArr2[i16];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zza2++;
                    } else {
                        objArr[i14] = obj;
                        objArr2[i16] = obj;
                        i13 += hashCode;
                        i14++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i14, i11, (Object) null);
            if (i14 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzjg(obj3);
            }
            if (zzf(i14) < zzf / 2) {
                return zzk(i14, objArr);
            }
            if (i14 < 10) {
                objArr = Arrays.copyOf(objArr, i14);
            }
            return new zzjf(objArr, i13, objArr2, i12, i14);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzjg(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzjb) && zzj() && ((zzjb) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            i11 += next != null ? next.hashCode() : 0;
        }
        return i11;
    }

    /* renamed from: zzd */
    public abstract zzjh iterator();

    public final zzja zzg() {
        zzja zzja = this.zza;
        if (zzja != null) {
            return zzja;
        }
        zzja zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public zzja zzh() {
        Object[] array = toArray();
        int i11 = zzja.zzd;
        return zzja.zzg(array, array.length);
    }

    public boolean zzj() {
        return false;
    }
}
