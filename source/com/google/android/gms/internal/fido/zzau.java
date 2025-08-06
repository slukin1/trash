package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class zzau extends zzaq implements Set {
    private transient zzat zza;

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

    public static zzau zzi(Object obj, Object obj2) {
        return zzk(2, obj, obj2);
    }

    private static zzau zzk(int i11, Object... objArr) {
        if (i11 == 0) {
            return zzax.zza;
        }
        if (i11 != 1) {
            int zzf = zzf(i11);
            Object[] objArr2 = new Object[zzf];
            int i12 = zzf - 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < i11) {
                Object obj = objArr[i13];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int zza2 = zzap.zza(hashCode);
                    while (true) {
                        int i16 = zza2 & i12;
                        Object obj2 = objArr2[i16];
                        if (obj2 != null) {
                            if (obj2.equals(obj)) {
                                break;
                            }
                            zza2++;
                        } else {
                            objArr[i15] = obj;
                            objArr2[i16] = obj;
                            i14 += hashCode;
                            i15++;
                            break;
                        }
                    }
                    i13++;
                } else {
                    throw new NullPointerException("at index " + i13);
                }
            }
            Arrays.fill(objArr, i15, i11, (Object) null);
            if (i15 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzay(obj3);
            }
            if (zzf(i15) < zzf / 2) {
                return zzk(i15, objArr);
            }
            if (i15 <= 0) {
                objArr = Arrays.copyOf(objArr, i15);
            }
            return new zzax(objArr, i14, objArr2, i12, i15);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzay(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzau) && zzj() && ((zzau) obj).zzj() && hashCode() != obj.hashCode()) {
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
    public abstract zzaz iterator();

    public final zzat zzg() {
        zzat zzat = this.zza;
        if (zzat != null) {
            return zzat;
        }
        zzat zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public zzat zzh() {
        Object[] array = toArray();
        int i11 = zzat.zzd;
        return zzat.zzg(array, array.length);
    }

    public boolean zzj() {
        return false;
    }
}
