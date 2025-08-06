package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzlp extends zzjl implements RandomAccess, zzlq {
    @Deprecated
    public static final zzlq zza;
    private static final zzlp zzb;
    private final List zzc;

    static {
        zzlp zzlp = new zzlp(false);
        zzb = zzlp;
        zza = zzlp;
    }

    public zzlp() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzka) {
            return ((zzka) obj).zzm(zzlj.zzb);
        }
        return zzlj.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zzbW();
        this.zzc.add(i11, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i11, Collection collection) {
        zzbW();
        if (collection instanceof zzlq) {
            collection = ((zzlq) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzbW();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbW();
        Object remove = this.zzc.remove(i11);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zzbW();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzli zzd(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.zzc);
            return new zzlp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzlq zze() {
        return zzc() ? new zznp(this) : this;
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
        if (obj instanceof zzka) {
            zzka zzka = (zzka) obj;
            String zzm = zzka.zzm(zzlj.zzb);
            if (zzka.zzi()) {
                this.zzc.set(i11, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzlj.zzd(bArr);
        if (zznz.zzd(bArr)) {
            this.zzc.set(i11, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzka zzka) {
        zzbW();
        this.zzc.add(zzka);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzlp(int i11) {
        super(true);
        ArrayList arrayList = new ArrayList(i11);
        this.zzc = arrayList;
    }

    private zzlp(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzlp(boolean z11) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
