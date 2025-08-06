package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzft;

final class zzw {
    public final /* synthetic */ zzaa zza;
    private zzft zzb;
    private Long zzc;
    private long zzd;

    public /* synthetic */ zzw(zzaa zzaa, zzv zzv) {
        this.zza = zzaa;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fa, code lost:
        if (r14 == null) goto L_0x00ff;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzft zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzft r19) {
        /*
            r17 = this;
            r1 = r17
            r3 = r18
            r8 = r19
            java.lang.String r0 = r19.zzh()
            java.util.List r9 = r19.zzi()
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r2 = r2.zzf
            r2.zzu()
            java.lang.String r2 = "_eid"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzlj.zzD(r8, r2)
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0233
            java.lang.String r5 = "_ep"
            boolean r5 = r0.equals(r5)
            r6 = 0
            if (r5 == 0) goto L_0x01e6
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzf
            r0.zzu()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzlj.zzD(r8, r0)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r5 = 0
            if (r0 == 0) goto L_0x0055
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzh()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zzb(r2, r4)
            return r5
        L_0x0055:
            com.google.android.gms.internal.measurement.zzft r0 = r1.zzb
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x006d
            java.lang.Long r0 = r1.zzc
            if (r0 == 0) goto L_0x006d
            long r13 = r4.longValue()
            java.lang.Long r0 = r1.zzc
            long r15 = r0.longValue()
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
        L_0x006d:
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzf
            com.google.android.gms.measurement.internal.zzak r13 = r0.zzh()
            r13.zzg()
            r13.zzW()
            android.database.sqlite.SQLiteDatabase r0 = r13.zzh()     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            java.lang.String r14 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r15 = 2
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            r15[r12] = r3     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            java.lang.String r16 = r4.toString()     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            r15[r11] = r16     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            android.database.Cursor r14 = r0.rawQuery(r14, r15)     // Catch:{ SQLiteException -> 0x00e9, all -> 0x00e5 }
            boolean r0 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x00e3 }
            if (r0 != 0) goto L_0x00aa
            com.google.android.gms.measurement.internal.zzgd r0 = r13.zzt     // Catch:{ SQLiteException -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r15 = "Main event not found"
            r0.zza(r15)     // Catch:{ SQLiteException -> 0x00e3 }
            r14.close()
            r0 = r5
            goto L_0x0100
        L_0x00aa:
            byte[] r0 = r14.getBlob(r12)     // Catch:{ SQLiteException -> 0x00e3 }
            long r15 = r14.getLong(r11)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x00e3 }
            com.google.android.gms.internal.measurement.zzfs r5 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00ce }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r5, r0)     // Catch:{ IOException -> 0x00ce }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ IOException -> 0x00ce }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x00ce }
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0     // Catch:{ IOException -> 0x00ce }
            android.util.Pair r0 = android.util.Pair.create(r0, r15)     // Catch:{ SQLiteException -> 0x00e3 }
            r14.close()
            goto L_0x0100
        L_0x00ce:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r5 = r13.zzt     // Catch:{ SQLiteException -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ SQLiteException -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r15 = "Failed to merge main event. appId, eventId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zzn(r18)     // Catch:{ SQLiteException -> 0x00e3 }
            r5.zzd(r15, r12, r4, r0)     // Catch:{ SQLiteException -> 0x00e3 }
            goto L_0x00fc
        L_0x00e3:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e5:
            r0 = move-exception
            r5 = 0
            goto L_0x01e0
        L_0x00e9:
            r0 = move-exception
            r14 = 0
        L_0x00eb:
            com.google.android.gms.measurement.internal.zzgd r5 = r13.zzt     // Catch:{ all -> 0x01de }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ all -> 0x01de }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ all -> 0x01de }
            java.lang.String r12 = "Error selecting main event"
            r5.zzb(r12, r0)     // Catch:{ all -> 0x01de }
            if (r14 == 0) goto L_0x00ff
        L_0x00fc:
            r14.close()
        L_0x00ff:
            r0 = 0
        L_0x0100:
            if (r0 == 0) goto L_0x01cb
            java.lang.Object r5 = r0.first
            if (r5 != 0) goto L_0x0108
            goto L_0x01cb
        L_0x0108:
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5
            r1.zzb = r5
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r12 = r0.longValue()
            r1.zzd = r12
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzf
            r0.zzu()
            com.google.android.gms.internal.measurement.zzft r0 = r1.zzb
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzlj.zzD(r0, r2)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.zzc = r0
        L_0x0127:
            long r12 = r1.zzd
            r14 = -1
            long r12 = r12 + r14
            r1.zzd = r12
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x016c
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzgd r0 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r0.zzb(r4, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x015b }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x015b }
            r6 = 0
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x015b }
            r0.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x015b }
            goto L_0x017d
        L_0x015b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zzb(r3, r0)
            goto L_0x017d
        L_0x016c:
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            long r5 = r1.zzd
            com.google.android.gms.internal.measurement.zzft r7 = r1.zzb
            r3 = r18
            r2.zzJ(r3, r4, r5, r7)
        L_0x017d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzft r2 = r1.zzb
            java.util.List r2 = r2.zzi()
            java.util.Iterator r2 = r2.iterator()
        L_0x018c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01ad
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3
            com.google.android.gms.measurement.internal.zzaa r4 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r4 = r4.zzf
            r4.zzu()
            java.lang.String r4 = r3.zzg()
            com.google.android.gms.internal.measurement.zzfx r4 = com.google.android.gms.measurement.internal.zzlj.zzC(r8, r4)
            if (r4 != 0) goto L_0x018c
            r0.add(r3)
            goto L_0x018c
        L_0x01ad:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x01b8
            r0.addAll(r9)
            r9 = r0
            goto L_0x01c9
        L_0x01b8:
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzh()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zzb(r2, r10)
        L_0x01c9:
            r0 = r10
            goto L_0x0233
        L_0x01cb:
            com.google.android.gms.measurement.internal.zzaa r0 = r1.zza
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzh()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zzc(r2, r10, r4)
            r2 = 0
            return r2
        L_0x01de:
            r0 = move-exception
            r5 = r14
        L_0x01e0:
            if (r5 == 0) goto L_0x01e5
            r5.close()
        L_0x01e5:
            throw r0
        L_0x01e6:
            r1.zzc = r4
            r1.zzb = r8
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r2 = r2.zzf
            r2.zzu()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r5 = "_epc"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzlj.zzD(r8, r5)
            if (r5 == 0) goto L_0x01fe
            r2 = r5
        L_0x01fe:
            java.lang.Long r2 = (java.lang.Long) r2
            long r10 = r2.longValue()
            r1.zzd = r10
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x021c
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zza
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzh()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.zzb(r3, r0)
            goto L_0x0233
        L_0x021c:
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zza
            com.google.android.gms.measurement.internal.zzlh r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzh()
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r1.zzd
            r3 = r18
            r7 = r19
            r2.zzJ(r3, r4, r5, r7)
        L_0x0233:
            com.google.android.gms.internal.measurement.zzkx r2 = r19.zzbB()
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2
            r2.zzi(r0)
            r2.zzg()
            r2.zzd(r9)
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zza(java.lang.String, com.google.android.gms.internal.measurement.zzft):com.google.android.gms.internal.measurement.zzft");
    }
}
