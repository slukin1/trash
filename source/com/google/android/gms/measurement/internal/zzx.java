package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzek;

final class zzx extends zzy {
    public final /* synthetic */ zzaa zza;
    private final zzek zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(zzaa zzaa, String str, int i11, zzek zzek) {
        super(str, i11);
        this.zza = zzaa;
        this.zzh = zzek;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return this.zzh.zzo();
    }

    public final boolean zzc() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r5v16, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03fa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r16, java.lang.Long r17, com.google.android.gms.internal.measurement.zzft r18, long r19, com.google.android.gms.measurement.internal.zzaq r21, boolean r22) {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.zzaa r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            java.lang.String r2 = r0.zzb
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzY
            boolean r1 = r1.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzek r2 = r0.zzh
            boolean r2 = r2.zzn()
            if (r2 == 0) goto L_0x0021
            r2 = r21
            long r2 = r2.zze
            goto L_0x0023
        L_0x0021:
            r2 = r19
        L_0x0023:
            com.google.android.gms.measurement.internal.zzaa r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            java.lang.String r4 = r4.zzr()
            r5 = 2
            boolean r4 = android.util.Log.isLoggable(r4, r5)
            r5 = 0
            if (r4 == 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzaa r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzj()
            int r6 = r0.zzc
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.internal.measurement.zzek r7 = r0.zzh
            boolean r7 = r7.zzp()
            if (r7 == 0) goto L_0x005c
            com.google.android.gms.internal.measurement.zzek r7 = r0.zzh
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x005d
        L_0x005c:
            r7 = r5
        L_0x005d:
            com.google.android.gms.measurement.internal.zzaa r8 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzt
            com.google.android.gms.measurement.internal.zzeo r8 = r8.zzj()
            com.google.android.gms.internal.measurement.zzek r9 = r0.zzh
            java.lang.String r9 = r9.zzg()
            java.lang.String r8 = r8.zzd(r9)
            java.lang.String r9 = "Evaluating filter. audience, filter, event"
            r4.zzd(r9, r6, r7, r8)
            com.google.android.gms.measurement.internal.zzaa r4 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzj()
            com.google.android.gms.measurement.internal.zzaa r6 = r0.zza
            com.google.android.gms.measurement.internal.zzlh r6 = r6.zzf
            com.google.android.gms.measurement.internal.zzlj r6 = r6.zzu()
            com.google.android.gms.internal.measurement.zzek r7 = r0.zzh
            java.lang.String r6 = r6.zzp(r7)
            java.lang.String r7 = "Filter definition"
            r4.zzb(r7, r6)
        L_0x0093:
            com.google.android.gms.internal.measurement.zzek r4 = r0.zzh
            boolean r4 = r4.zzp()
            r6 = 0
            if (r4 == 0) goto L_0x0440
            com.google.android.gms.internal.measurement.zzek r4 = r0.zzh
            int r4 = r4.zzb()
            r7 = 256(0x100, float:3.59E-43)
            if (r4 <= r7) goto L_0x00a8
            goto L_0x0440
        L_0x00a8:
            com.google.android.gms.internal.measurement.zzek r4 = r0.zzh
            boolean r4 = r4.zzk()
            com.google.android.gms.internal.measurement.zzek r7 = r0.zzh
            boolean r7 = r7.zzm()
            com.google.android.gms.internal.measurement.zzek r8 = r0.zzh
            boolean r8 = r8.zzn()
            r9 = 1
            if (r4 != 0) goto L_0x00c4
            if (r7 != 0) goto L_0x00c4
            if (r8 == 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r4 = r6
            goto L_0x00c5
        L_0x00c4:
            r4 = r9
        L_0x00c5:
            if (r22 == 0) goto L_0x00f3
            if (r4 != 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzaa r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            int r2 = r0.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.zzh
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x00ed
            com.google.android.gms.internal.measurement.zzek r3 = r0.zzh
            int r3 = r3.zzb()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x00ed:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zzc(r3, r2, r5)
            return r9
        L_0x00f3:
            com.google.android.gms.internal.measurement.zzek r7 = r0.zzh
            java.lang.String r8 = r18.zzh()
            boolean r10 = r7.zzo()
            if (r10 == 0) goto L_0x0115
            com.google.android.gms.internal.measurement.zzer r10 = r7.zzf()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzy.zzh(r2, r10)
            if (r2 != 0) goto L_0x010b
            goto L_0x03e1
        L_0x010b:
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0115
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e1
        L_0x0115:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.List r3 = r7.zzh()
            java.util.Iterator r3 = r3.iterator()
        L_0x0122:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x015f
            java.lang.Object r10 = r3.next()
            com.google.android.gms.internal.measurement.zzem r10 = (com.google.android.gms.internal.measurement.zzem) r10
            java.lang.String r11 = r10.zze()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0157
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            java.lang.String r7 = "null or empty param name in filter. event"
            r2.zzb(r7, r3)
            goto L_0x03e1
        L_0x0157:
            java.lang.String r10 = r10.zze()
            r2.add(r10)
            goto L_0x0122
        L_0x015f:
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.List r10 = r18.zzi()
            java.util.Iterator r10 = r10.iterator()
        L_0x016c:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01ff
            java.lang.Object r11 = r10.next()
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11
            java.lang.String r12 = r11.zzg()
            boolean r12 = r2.contains(r12)
            if (r12 == 0) goto L_0x016c
            boolean r12 = r11.zzw()
            if (r12 == 0) goto L_0x01a0
            java.lang.String r12 = r11.zzg()
            boolean r13 = r11.zzw()
            if (r13 == 0) goto L_0x019b
            long r13 = r11.zzd()
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            goto L_0x019c
        L_0x019b:
            r11 = r5
        L_0x019c:
            r3.put(r12, r11)
            goto L_0x016c
        L_0x01a0:
            boolean r12 = r11.zzu()
            if (r12 == 0) goto L_0x01be
            java.lang.String r12 = r11.zzg()
            boolean r13 = r11.zzu()
            if (r13 == 0) goto L_0x01b9
            double r13 = r11.zza()
            java.lang.Double r11 = java.lang.Double.valueOf(r13)
            goto L_0x01ba
        L_0x01b9:
            r11 = r5
        L_0x01ba:
            r3.put(r12, r11)
            goto L_0x016c
        L_0x01be:
            boolean r12 = r11.zzy()
            if (r12 == 0) goto L_0x01d0
            java.lang.String r12 = r11.zzg()
            java.lang.String r11 = r11.zzh()
            r3.put(r12, r11)
            goto L_0x016c
        L_0x01d0:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r8 = r11.zzg()
            java.lang.String r7 = r7.zze(r8)
            java.lang.String r8 = "Unknown value for param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x01ff:
            java.util.List r2 = r7.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0207:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x03df
            java.lang.Object r7 = r2.next()
            com.google.android.gms.internal.measurement.zzem r7 = (com.google.android.gms.internal.measurement.zzem) r7
            boolean r10 = r7.zzh()
            if (r10 == 0) goto L_0x0221
            boolean r10 = r7.zzg()
            if (r10 == 0) goto L_0x0221
            r10 = r9
            goto L_0x0222
        L_0x0221:
            r10 = r6
        L_0x0222:
            java.lang.String r11 = r7.zze()
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            java.lang.String r7 = "Event has empty param name. event"
            r2.zzb(r7, r3)
            goto L_0x03e1
        L_0x024b:
            java.lang.Object r12 = r3.get(r11)
            boolean r13 = r12 instanceof java.lang.Long
            if (r13 == 0) goto L_0x02a0
            boolean r13 = r7.zzi()
            if (r13 != 0) goto L_0x0284
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No number filter for long param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x0284:
            java.lang.Long r12 = (java.lang.Long) r12
            long r11 = r12.longValue()
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.zzy.zzh(r11, r7)
            if (r7 != 0) goto L_0x0296
            goto L_0x03e1
        L_0x0296:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0207
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e1
        L_0x02a0:
            boolean r13 = r12 instanceof java.lang.Double
            if (r13 == 0) goto L_0x02f1
            boolean r13 = r7.zzi()
            if (r13 != 0) goto L_0x02d5
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No number filter for double param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x02d5:
            java.lang.Double r12 = (java.lang.Double) r12
            double r11 = r12.doubleValue()
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.zzy.zzg(r11, r7)
            if (r7 != 0) goto L_0x02e7
            goto L_0x03e1
        L_0x02e7:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0207
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e1
        L_0x02f1:
            boolean r13 = r12 instanceof java.lang.String
            if (r13 == 0) goto L_0x0387
            boolean r13 = r7.zzk()
            if (r13 == 0) goto L_0x030e
            java.lang.String r12 = (java.lang.String) r12
            com.google.android.gms.internal.measurement.zzey r7 = r7.zzd()
            com.google.android.gms.measurement.internal.zzaa r11 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r11 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzaA()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.zzy.zzf(r12, r7, r11)
            goto L_0x0324
        L_0x030e:
            boolean r13 = r7.zzi()
            if (r13 == 0) goto L_0x035d
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = com.google.android.gms.measurement.internal.zzlj.zzy(r12)
            if (r13 == 0) goto L_0x0332
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.zzy.zzi(r12, r7)
        L_0x0324:
            if (r7 != 0) goto L_0x0328
            goto L_0x03e1
        L_0x0328:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0207
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e1
        L_0x0332:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "Invalid param value for number filter. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x035d:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No filter for String param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x0387:
            if (r12 != 0) goto L_0x03b5
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r5 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzt
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()
            java.lang.String r5 = r5.zze(r11)
            java.lang.String r7 = "Missing param for filter. event, param"
            r2.zzc(r7, r3, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e1
        L_0x03b5:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()
            com.google.android.gms.measurement.internal.zzaa r3 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.zzaa r7 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "Unknown param type. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e1
        L_0x03df:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
        L_0x03e1:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()
            if (r5 != 0) goto L_0x03f2
            java.lang.String r3 = "null"
            goto L_0x03f3
        L_0x03f2:
            r3 = r5
        L_0x03f3:
            java.lang.String r7 = "Event filter result"
            r2.zzb(r7, r3)
            if (r5 != 0) goto L_0x03fb
            return r6
        L_0x03fb:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.zzd = r2
            boolean r3 = r5.booleanValue()
            if (r3 != 0) goto L_0x0406
            return r9
        L_0x0406:
            r0.zze = r2
            if (r4 == 0) goto L_0x043f
            boolean r2 = r18.zzu()
            if (r2 == 0) goto L_0x043f
            long r2 = r18.zzd()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.zzh
            boolean r3 = r3.zzm()
            if (r3 == 0) goto L_0x0430
            if (r1 == 0) goto L_0x042d
            com.google.android.gms.internal.measurement.zzek r1 = r0.zzh
            boolean r1 = r1.zzo()
            if (r1 != 0) goto L_0x042b
            goto L_0x042d
        L_0x042b:
            r2 = r16
        L_0x042d:
            r0.zzg = r2
            goto L_0x043f
        L_0x0430:
            if (r1 == 0) goto L_0x043d
            com.google.android.gms.internal.measurement.zzek r1 = r0.zzh
            boolean r1 = r1.zzo()
            if (r1 != 0) goto L_0x043b
            goto L_0x043d
        L_0x043b:
            r2 = r17
        L_0x043d:
            r0.zzf = r2
        L_0x043f:
            return r9
        L_0x0440:
            com.google.android.gms.measurement.internal.zzaa r1 = r0.zza
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzk()
            java.lang.String r2 = r0.zzb
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zzn(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.zzh
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x0464
            com.google.android.gms.internal.measurement.zzek r3 = r0.zzh
            int r3 = r3.zzb()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x0464:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zzc(r4, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzft, long, com.google.android.gms.measurement.internal.zzaq, boolean):boolean");
    }
}
