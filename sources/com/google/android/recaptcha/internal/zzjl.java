package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzjl extends zzgh implements RandomAccess, zzjm {
    @Deprecated
    public static final zzjm zza;
    private static final zzjl zzb;
    private final List zzc;

    static {
        zzjl zzjl = new zzjl(false);
        zzb = zzjl;
        zza = zzjl;
    }

    public zzjl() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgw) {
            return ((zzgw) obj).zzn(zzjc.zzb);
        }
        return zzjc.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zza();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection collection) {
        zza();
        if (collection instanceof zzjm) {
            collection = ((zzjm) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zza();
        Object remove = this.zzc.remove(i11);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zza();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzjb zzd(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzjl(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzjm zze() {
        return zzc() ? new zzlq(this) : this;
    }

    public final Object zzf(int i11) {
        return this.zzc.get(i11);
    }

    /* renamed from: zzg */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgw) {
            zzgw zzgw = (zzgw) obj;
            String zzn = zzgw.zzn(zzjc.zzb);
            if (zzgw.zzj()) {
                this.zzc.set(i11, zzn);
            }
            return zzn;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzjc.zzd(bArr);
        if (zzma.zze(bArr)) {
            this.zzc.set(i11, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzgw zzgw) {
        zza();
        this.zzc.add(zzgw);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjl(int i11) {
        super(true);
        ArrayList arrayList = new ArrayList(i11);
        this.zzc = arrayList;
    }

    private zzjl(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzjl(boolean z11) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
