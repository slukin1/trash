package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzjl extends AbstractList implements zzli {
    private boolean zza;

    public zzjl(boolean z11) {
        this.zza = z11;
    }

    public void add(int i11, Object obj) {
        zzbW();
        super.add(i11, obj);
    }

    public boolean addAll(int i11, Collection collection) {
        zzbW();
        return super.addAll(i11, collection);
    }

    public void clear() {
        zzbW();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!get(i11).equals(list.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (i11 * 31) + get(i12).hashCode();
        }
        return i11;
    }

    public Object remove(int i11) {
        zzbW();
        return super.remove(i11);
    }

    public final boolean removeAll(Collection collection) {
        zzbW();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzbW();
        return super.retainAll(collection);
    }

    public Object set(int i11, Object obj) {
        zzbW();
        return super.set(i11, obj);
    }

    public final void zzb() {
        if (this.zza) {
            this.zza = false;
        }
    }

    public final void zzbW() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean add(Object obj) {
        zzbW();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        zzbW();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzbW();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
