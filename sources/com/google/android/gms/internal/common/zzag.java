package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzag extends zzac implements List, RandomAccess {
    private static final zzak zza = new zzae(zzai.zza, 0);

    public static zzag zzi(Object[] objArr, int i11) {
        if (i11 == 0) {
            return zzai.zza;
        }
        return new zzai(objArr, i11);
    }

    public static zzag zzj(Iterable iterable) {
        Objects.requireNonNull(iterable);
        if (iterable instanceof Collection) {
            return zzk((Collection) iterable);
        }
        Iterator it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return zzai.zza;
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return zzm(next);
        }
        zzad zzad = new zzad(4);
        zzad.zzb(next);
        zzad.zzc(it2);
        zzad.zzc = true;
        return zzi(zzad.zza, zzad.zzb);
    }

    public static zzag zzk(Collection collection) {
        if (collection instanceof zzac) {
            zzag zzd = ((zzac) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzah.zza(array2, length);
        return zzi(array2, length);
    }

    public static zzag zzl() {
        return zzai.zza;
    }

    public static zzag zzm(Object obj) {
        Object[] objArr = {obj};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzag zzn(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(int i11, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i11 = 0;
                    while (i11 < size) {
                        if (zzr.zza(get(i11), list.get(i11))) {
                            i11++;
                        }
                    }
                    return true;
                }
                Iterator it2 = iterator();
                Iterator it3 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it3.hasNext()) {
                            if (!zzr.zza(it2.next(), it3.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it3.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (i11 * 31) + get(i12).hashCode();
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (obj.equals(get(i11))) {
                return i11;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Object remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Object set(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }

    public int zza(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i12] = get(i12);
        }
        return size;
    }

    @InlineMe(replacement = "this")
    @Deprecated
    public final zzag zzd() {
        return this;
    }

    public final zzaj zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzag subList(int i11, int i12) {
        zzs.zzc(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        if (i13 == 0) {
            return zzai.zza;
        }
        return new zzaf(this, i11, i13);
    }

    /* renamed from: zzo */
    public final zzak listIterator(int i11) {
        zzs.zzb(i11, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzae(this, i11);
    }
}
