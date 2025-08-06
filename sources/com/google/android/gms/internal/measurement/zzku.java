package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

final class zzku extends zzjl implements RandomAccess, zzmp {
    private static final zzku zza = new zzku(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    public zzku() {
        this(new float[10], 0, true);
    }

    private final String zzf(int i11) {
        int i12 = this.zzc;
        return "Index:" + i11 + ", Size:" + i12;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        float floatValue = ((Float) obj).floatValue();
        zzbW();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
        float[] fArr = this.zzb;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.zzb, i11, fArr2, i11 + 1, this.zzc - i11);
            this.zzb = fArr2;
        }
        this.zzb[i11] = floatValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbW();
        byte[] bArr = zzlj.zzd;
        Objects.requireNonNull(collection);
        if (!(collection instanceof zzku)) {
            return super.addAll(collection);
        }
        zzku zzku = (zzku) collection;
        int i11 = zzku.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.zzb;
            if (i13 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(zzku.zzb, 0, this.zzb, this.zzc, zzku.zzc);
            this.zzc = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzku)) {
            return super.equals(obj);
        }
        zzku zzku = (zzku) obj;
        if (this.zzc != zzku.zzc) {
            return false;
        }
        float[] fArr = zzku.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (Float.floatToIntBits(this.zzb[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzg(i11);
        return Float.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.zzb[i12]);
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == floatValue) {
                return i12;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbW();
        zzg(i11);
        float[] fArr = this.zzb;
        float f11 = fArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Float.valueOf(f11);
    }

    public final void removeRange(int i11, int i12) {
        zzbW();
        if (i12 >= i11) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i12, fArr, i11, this.zzc - i12);
            this.zzc -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbW();
        zzg(i11);
        float[] fArr = this.zzb;
        float f11 = fArr[i11];
        fArr[i11] = floatValue;
        return Float.valueOf(f11);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzli zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzku(Arrays.copyOf(this.zzb, i11), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f11) {
        zzbW();
        int i11 = this.zzc;
        float[] fArr = this.zzb;
        if (i11 == fArr.length) {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        fArr3[i12] = f11;
    }

    private zzku(float[] fArr, int i11, boolean z11) {
        super(z11);
        this.zzb = fArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
