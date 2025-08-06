package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzu {
    public final /* synthetic */ zzaa zza;
    private String zzb;
    private boolean zzc;
    private zzgi zzd;
    /* access modifiers changed from: private */
    public BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzu(zzaa zzaa, String str, zzt zzt) {
        this.zza = zzaa;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    public final zzfp zza(int i11) {
        ArrayList arrayList;
        List list;
        zzfo zzb2 = zzfp.zzb();
        zzb2.zza(i11);
        zzb2.zzc(this.zzc);
        zzgi zzgi = this.zzd;
        if (zzgi != null) {
            zzb2.zzd(zzgi);
        }
        zzgh zze2 = zzgi.zze();
        zze2.zzb(zzlj.zzs(this.zze));
        zze2.zzd(zzlj.zzs(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.zzg.keySet()) {
                int intValue2 = intValue.intValue();
                Long l11 = (Long) this.zzg.get(Integer.valueOf(intValue2));
                if (l11 != null) {
                    zzfq zzc2 = zzfr.zzc();
                    zzc2.zzb(intValue2);
                    zzc2.zza(l11.longValue());
                    arrayList2.add((zzfr) zzc2.zzaD());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zze2.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzh.keySet()) {
                zzgj zzd2 = zzgk.zzd();
                zzd2.zzb(num.intValue());
                List list2 = (List) this.zzh.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd2.zza(list2);
                }
                arrayList3.add((zzgk) zzd2.zzaD());
            }
            list = arrayList3;
        }
        zze2.zzc(list);
        zzb2.zzb(zze2);
        return (zzfp) zzb2.zzaD();
    }

    public final void zzc(zzy zzy) {
        int zza2 = zzy.zza();
        Boolean bool = zzy.zzd;
        if (bool != null) {
            BitSet bitSet = this.zzf;
            bool.booleanValue();
            bitSet.set(zza2, true);
        }
        Boolean bool2 = zzy.zze;
        if (bool2 != null) {
            this.zze.set(zza2, bool2.booleanValue());
        }
        if (zzy.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l11 = (Long) map.get(valueOf);
            long longValue = zzy.zzf.longValue() / 1000;
            if (l11 == null || longValue > l11.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzy.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzy.zzc()) {
                list.clear();
            }
            zzoy.zzc();
            zzag zzf2 = this.zza.zzt.zzf();
            String str = this.zzb;
            zzef zzef = zzeg.zzY;
            if (zzf2.zzs(str, zzef) && zzy.zzb()) {
                list.clear();
            }
            zzoy.zzc();
            if (this.zza.zzt.zzf().zzs(this.zzb, zzef)) {
                Long valueOf3 = Long.valueOf(zzy.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzy.zzg.longValue() / 1000));
        }
    }

    public /* synthetic */ zzu(zzaa zzaa, String str, zzgi zzgi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zzt) {
        this.zza = zzaa;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgi;
    }
}
