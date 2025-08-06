package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class zzaa extends zzku {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzlh zzlh) {
        super(zzlh);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i11, int i12) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i11));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02d6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d7, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02f5, code lost:
        if (r5 != null) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0401, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0741, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0742, code lost:
        r29 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0749, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x074a, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0769, code lost:
        if (r5 == null) goto L_0x076c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0772, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x08e6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x08ec, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x08ed, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x090c, code lost:
        if (r3 == null) goto L_0x090f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0917, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0a38, code lost:
        if (r7 != false) goto L_0x0a43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0171, code lost:
        if (r5 != null) goto L_0x014f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02d6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:105:0x0287] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x05b6  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0749 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:240:0x06a3] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0772  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x081f  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x08ec A[ExcHandler: all (th java.lang.Throwable), Splitter:B:319:0x0864] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0917  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0a69  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x0afd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b0 A[Catch:{ SQLiteException -> 0x0220 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01be A[SYNTHETIC, Splitter:B:65:0x01be] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0249  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            r64 = this;
            r10 = r64
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            r0 = r65
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r68
            r10.zzd = r0
            r0 = r69
            r10.zze = r0
            java.util.Iterator r0 = r66.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzY
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzX
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r7[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017a
            if (r14 == 0) goto L_0x017a
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String r17 = "event_filters"
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015a, all -> 0x0157 }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015a, all -> 0x0157 }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015a, all -> 0x0157 }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015a, all -> 0x0157 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0155 }
            if (r0 == 0) goto L_0x014b
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0155 }
            com.google.android.gms.internal.measurement.zzej r13 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r13, r0)     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x012b }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0155 }
            if (r13 != 0) goto L_0x010c
            goto L_0x013d
        L_0x010c:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0155 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0155 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0155 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0155 }
            if (r16 != 0) goto L_0x0125
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0155 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0155 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0155 }
            goto L_0x0127
        L_0x0125:
            r12 = r16
        L_0x0127:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0155 }
            goto L_0x013d
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r2.zzt     // Catch:{ SQLiteException -> 0x0155 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ SQLiteException -> 0x0155 }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0155 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x0155 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0155 }
        L_0x013d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0155 }
            if (r0 != 0) goto L_0x0148
            r5.close()
            r12 = r4
            goto L_0x017b
        L_0x0148:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014b:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0155 }
        L_0x014f:
            r5.close()
            goto L_0x017a
        L_0x0153:
            r0 = move-exception
            goto L_0x0174
        L_0x0155:
            r0 = move-exception
            goto L_0x015c
        L_0x0157:
            r0 = move-exception
            r5 = 0
            goto L_0x0174
        L_0x015a:
            r0 = move-exception
            r5 = 0
        L_0x015c:
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x0153 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0153 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0153 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0153 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0153 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0153 }
            if (r5 == 0) goto L_0x017a
            goto L_0x014f
        L_0x0174:
            if (r5 == 0) goto L_0x0179
            r5.close()
        L_0x0179:
            throw r0
        L_0x017a:
            r12 = r0
        L_0x017b:
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String r17 = "audience_filter_values"
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x022a, all -> 0x0226 }
            java.lang.String r19 = "app_id=?"
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x022a, all -> 0x0226 }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x022a, all -> 0x0226 }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x022a, all -> 0x0226 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0220 }
            if (r0 != 0) goto L_0x01be
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0220 }
            r4.close()
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x024d
        L_0x01be:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0220 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0220 }
        L_0x01c3:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0220 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0220 }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zze()     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r13, r0)     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x01eb }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0220 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0220 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x0209
        L_0x01eb:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r13 = r2.zzt     // Catch:{ SQLiteException -> 0x0220 }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x0220 }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0220 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x021e }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x021c }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x021c }
        L_0x0209:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x021c }
            if (r0 != 0) goto L_0x0215
            r4.close()
            r13 = r17
            goto L_0x024d
        L_0x0215:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c3
        L_0x021c:
            r0 = move-exception
            goto L_0x0230
        L_0x021e:
            r0 = move-exception
            goto L_0x0223
        L_0x0220:
            r0 = move-exception
            r18 = r6
        L_0x0223:
            r19 = r7
            goto L_0x0230
        L_0x0226:
            r0 = move-exception
            r5 = 0
            goto L_0x0afb
        L_0x022a:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0230:
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x0af9 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0af9 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0af9 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0af9 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0af9 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0af9 }
            if (r4 == 0) goto L_0x024c
            r4.close()
        L_0x024c:
            r13 = r0
        L_0x024d:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x025c
            r12 = r8
            r13 = r9
        L_0x0256:
            r28 = r18
            r29 = r19
            goto L_0x05aa
        L_0x025c:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0405
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r3 = r0.zzh()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String r6 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r16 = r8
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02d4, all -> 0x02d6 }
            r17 = 0
            r8[r17] = r4     // Catch:{ SQLiteException -> 0x02d4, all -> 0x02d6 }
            r17 = 1
            r8[r17] = r4     // Catch:{ SQLiteException -> 0x02d4, all -> 0x02d6 }
            android.database.Cursor r5 = r5.rawQuery(r6, r8)     // Catch:{ SQLiteException -> 0x02d4, all -> 0x02d6 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02d2 }
            if (r6 == 0) goto L_0x02ca
        L_0x029b:
            r6 = 0
            int r8 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02d2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ SQLiteException -> 0x02d2 }
            java.lang.Object r8 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02d2 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ SQLiteException -> 0x02d2 }
            if (r8 != 0) goto L_0x02b4
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02d2 }
            r8.<init>()     // Catch:{ SQLiteException -> 0x02d2 }
            r0.put(r6, r8)     // Catch:{ SQLiteException -> 0x02d2 }
        L_0x02b4:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02d2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02d2 }
            r8.add(r6)     // Catch:{ SQLiteException -> 0x02d2 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02d2 }
            if (r6 != 0) goto L_0x029b
        L_0x02c6:
            r5.close()
            goto L_0x02f8
        L_0x02ca:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02d2 }
            goto L_0x02c6
        L_0x02cf:
            r0 = move-exception
            goto L_0x03ff
        L_0x02d2:
            r0 = move-exception
            goto L_0x02de
        L_0x02d4:
            r0 = move-exception
            goto L_0x02dd
        L_0x02d6:
            r0 = move-exception
            r5 = 0
            goto L_0x03ff
        L_0x02da:
            r0 = move-exception
            r16 = r8
        L_0x02dd:
            r5 = 0
        L_0x02de:
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r4)     // Catch:{ all -> 0x02cf }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02cf }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02cf }
            if (r5 == 0) goto L_0x02f8
            goto L_0x02c6
        L_0x02f8:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x030b
            goto L_0x03fd
        L_0x030b:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0313:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x03fd
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgi r6 = (com.google.android.gms.internal.measurement.zzgi) r6
            java.lang.Object r8 = r0.get(r5)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x03ef
            boolean r17 = r8.isEmpty()
            if (r17 == 0) goto L_0x033d
            goto L_0x03ef
        L_0x033d:
            com.google.android.gms.measurement.internal.zzlh r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r5 = r5.zzu()
            java.util.List r7 = r6.zzi()
            java.util.List r5 = r5.zzr(r7, r8)
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L_0x03fa
            com.google.android.gms.internal.measurement.zzkx r7 = r6.zzbB()
            com.google.android.gms.internal.measurement.zzgh r7 = (com.google.android.gms.internal.measurement.zzgh) r7
            r7.zzf()
            r7.zzb(r5)
            com.google.android.gms.measurement.internal.zzlh r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r5 = r5.zzu()
            r20 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzr(r0, r8)
            r7.zzh()
            r7.zzd(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r5 = r6.zzh()
            java.util.Iterator r5 = r5.iterator()
        L_0x0380:
            boolean r21 = r5.hasNext()
            if (r21 == 0) goto L_0x03a8
            java.lang.Object r21 = r5.next()
            r22 = r3
            r3 = r21
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            int r21 = r3.zza()
            r23 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            boolean r5 = r8.contains(r5)
            if (r5 != 0) goto L_0x03a3
            r0.add(r3)
        L_0x03a3:
            r3 = r22
            r5 = r23
            goto L_0x0380
        L_0x03a8:
            r22 = r3
            r7.zze()
            r7.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x03bd:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03db
            java.lang.Object r5 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r5 = (com.google.android.gms.internal.measurement.zzgk) r5
            int r6 = r5.zzb()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r6 = r8.contains(r6)
            if (r6 != 0) goto L_0x03bd
            r0.add(r5)
            goto L_0x03bd
        L_0x03db:
            r7.zzg()
            r7.zzc(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzlb r3 = r7.zzaD()
            com.google.android.gms.internal.measurement.zzgi r3 = (com.google.android.gms.internal.measurement.zzgi) r3
            r1.put(r0, r3)
            goto L_0x03f6
        L_0x03ef:
            r20 = r0
            r22 = r3
            r1.put(r5, r6)
        L_0x03f6:
            r0 = r20
            r3 = r22
        L_0x03fa:
            r7 = 2
            goto L_0x0313
        L_0x03fd:
            r0 = r1
            goto L_0x0408
        L_0x03ff:
            if (r5 == 0) goto L_0x0404
            r5.close()
        L_0x0404:
            throw r0
        L_0x0405:
            r16 = r8
            r0 = r13
        L_0x0408:
            java.util.Iterator r20 = r2.iterator()
        L_0x040c:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x05a5
            java.lang.Object r1 = r20.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r21 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0474
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x043e
            goto L_0x0474
        L_0x043e:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0446:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0474
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x0446
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x046f
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x0470
        L_0x046f:
            r3 = 0
        L_0x0470:
            r7.put(r4, r3)
            goto L_0x0446
        L_0x0474:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x04c0
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x0482
            goto L_0x04c0
        L_0x0482:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x048a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c0
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x048a
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x048a
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x048a
        L_0x04c0:
            r23 = r0
            if (r1 == 0) goto L_0x050f
            r0 = 0
        L_0x04c5:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x050f
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzlj.zzw(r2, r0)
            if (r2 == 0) goto L_0x0501
            com.google.android.gms.measurement.internal.zzgd r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzi()
            boolean r2 = com.google.android.gms.measurement.internal.zzlj.zzw(r2, r0)
            if (r2 == 0) goto L_0x0503
            r5.set(r0)
            goto L_0x050a
        L_0x0501:
            r22 = r9
        L_0x0503:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x050a:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x04c5
        L_0x050f:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            if (r15 == 0) goto L_0x057c
            if (r14 == 0) goto L_0x057c
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x057c
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x057c
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x0531
            goto L_0x057c
        L_0x0531:
            java.util.Iterator r0 = r0.iterator()
        L_0x0535:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x057c
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x055d
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x055d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x056e
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x056e:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0535
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0535
        L_0x057c:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r64
            r28 = r18
            r29 = r19
            r17 = r12
            r12 = r16
            r65 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)
            r1.put(r2, r0)
            r9 = r13
            r12 = r17
            r0 = r23
            r13 = r65
            goto L_0x040c
        L_0x05a5:
            r13 = r9
            r12 = r16
            goto L_0x0256
        L_0x05aa:
            boolean r0 = r66.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05b6
        L_0x05b2:
            r24 = r11
            goto L_0x0815
        L_0x05b6:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r66.iterator()
        L_0x05c5:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x05b2
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzft r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x05c5
            com.google.android.gms.measurement.internal.zzlh r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzh()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzaq r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x062e
            com.google.android.gms.measurement.internal.zzgd r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzaA()
            com.google.android.gms.measurement.internal.zzer r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzet.zzn(r8)
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzaq r7 = new com.google.android.gms.measurement.internal.zzaq
            r30 = r7
            java.lang.String r32 = r0.zzh()
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r0.zzd()
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r31 = r8
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)
            goto L_0x0663
        L_0x062e:
            com.google.android.gms.measurement.internal.zzaq r7 = new com.google.android.gms.measurement.internal.zzaq
            r47 = r7
            java.lang.String r0 = r14.zza
            r48 = r0
            java.lang.String r0 = r14.zzb
            r49 = r0
            long r8 = r14.zzc
            r15 = 1
            long r50 = r8 + r15
            long r8 = r14.zzd
            long r52 = r8 + r15
            long r8 = r14.zze
            long r54 = r8 + r15
            long r8 = r14.zzf
            r56 = r8
            long r8 = r14.zzg
            r58 = r8
            java.lang.Long r0 = r14.zzh
            r60 = r0
            java.lang.Long r0 = r14.zzi
            r61 = r0
            java.lang.Long r0 = r14.zzj
            r62 = r0
            java.lang.Boolean r0 = r14.zzk
            r63 = r0
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r60, r61, r62, r63)
        L_0x0663:
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r0 = r0.zzh()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0776
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r15 = r0.zzh()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r65 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r15.zzh()
            java.lang.String r17 = "event_filters"
            r66 = r5
            r24 = r11
            r11 = r28
            r5 = r29
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x0741, all -> 0x0749 }
            java.lang.String r19 = "app_id=? AND event_name=?"
            r29 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x073f, all -> 0x0749 }
            r20 = 0
            r0[r20] = r3     // Catch:{ SQLiteException -> 0x073f, all -> 0x0749 }
            r20 = 1
            r0[r20] = r14     // Catch:{ SQLiteException -> 0x073f, all -> 0x0749 }
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x073f, all -> 0x0749 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0739 }
            if (r0 == 0) goto L_0x0729
            r28 = r11
        L_0x06ca:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0725 }
            com.google.android.gms.internal.measurement.zzej r11 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x0703 }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r11, r0)     // Catch:{ IOException -> 0x0703 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0703 }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x0703 }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x0703 }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x0725 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0725 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x0725 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0725 }
            if (r16 != 0) goto L_0x06fb
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0735 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0735 }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x0735 }
            goto L_0x06ff
        L_0x06fb:
            r22 = r7
            r7 = r16
        L_0x06ff:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x0735 }
            goto L_0x0717
        L_0x0703:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.zzgd r7 = r15.zzt     // Catch:{ SQLiteException -> 0x0735 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzaA()     // Catch:{ SQLiteException -> 0x0735 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x0735 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x0735 }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x0735 }
        L_0x0717:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0735 }
            if (r0 != 0) goto L_0x0722
            r5.close()
            r0 = r2
            goto L_0x076c
        L_0x0722:
            r7 = r22
            goto L_0x06ca
        L_0x0725:
            r0 = move-exception
            r22 = r7
            goto L_0x0754
        L_0x0729:
            r22 = r7
            r28 = r11
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0735 }
        L_0x0731:
            r5.close()
            goto L_0x076c
        L_0x0735:
            r0 = move-exception
            goto L_0x0754
        L_0x0737:
            r0 = move-exception
            goto L_0x0770
        L_0x0739:
            r0 = move-exception
            r22 = r7
            r28 = r11
            goto L_0x0754
        L_0x073f:
            r0 = move-exception
            goto L_0x0744
        L_0x0741:
            r0 = move-exception
            r29 = r5
        L_0x0744:
            r22 = r7
            r28 = r11
            goto L_0x0753
        L_0x0749:
            r0 = move-exception
            r5 = 0
            goto L_0x0770
        L_0x074c:
            r0 = move-exception
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x0753:
            r5 = 0
        L_0x0754:
            com.google.android.gms.measurement.internal.zzgd r2 = r15.zzt     // Catch:{ all -> 0x0737 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0737 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0737 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0737 }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x0737 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0737 }
            if (r5 == 0) goto L_0x076c
            goto L_0x0731
        L_0x076c:
            r4.put(r14, r0)
            goto L_0x077e
        L_0x0770:
            if (r5 == 0) goto L_0x0775
            r5.close()
        L_0x0775:
            throw r0
        L_0x0776:
            r65 = r2
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x077e:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0786:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x080c
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x07b0
            com.google.android.gms.measurement.internal.zzgd r3 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x0786
        L_0x07b0:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x07bb:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x07ff
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r15 = r10.zzd
            java.lang.Long r14 = r10.zze
            int r7 = r7.zzb()
            boolean r21 = r10.zzf(r3, r7)
            r7 = r14
            r14 = r11
            r16 = r7
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r7 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r7 == 0) goto L_0x07f6
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x07bb
        L_0x07f6:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x07ff:
            if (r7 != 0) goto L_0x0786
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x0786
        L_0x080c:
            r2 = r65
            r5 = r66
            r11 = r24
            r3 = 0
            goto L_0x05c5
        L_0x0815:
            boolean r0 = r67.isEmpty()
            if (r0 == 0) goto L_0x081f
        L_0x081b:
            r11 = r28
            goto L_0x0a4f
        L_0x081f:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r67.iterator()
        L_0x0828:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x081b
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x091b
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r6 = r0.zzh()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            java.lang.String r14 = "property_filters"
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x08e8, all -> 0x08ec }
            java.lang.String r16 = "app_id=? AND property_name=?"
            r65 = r3
            r3 = 2
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x08e6, all -> 0x08ec }
            r3 = 0
            r0[r3] = r7     // Catch:{ SQLiteException -> 0x08e6, all -> 0x08ec }
            r3 = 1
            r0[r3] = r5     // Catch:{ SQLiteException -> 0x08e6, all -> 0x08ec }
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r3 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x08e6, all -> 0x08ec }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x08e4 }
            if (r0 == 0) goto L_0x08dc
        L_0x0887:
            r13 = 1
            byte[] r0 = r3.getBlob(r13)     // Catch:{ SQLiteException -> 0x08e4 }
            com.google.android.gms.internal.measurement.zzes r14 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x08bc }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r14, r0)     // Catch:{ IOException -> 0x08bc }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x08bc }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x08bc }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x08bc }
            r14 = 0
            int r15 = r3.getInt(r14)     // Catch:{ SQLiteException -> 0x08e4 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x08e4 }
            java.lang.Object r16 = r8.get(r15)     // Catch:{ SQLiteException -> 0x08e4 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08e4 }
            if (r16 != 0) goto L_0x08b6
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08e4 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x08e4 }
            r8.put(r15, r13)     // Catch:{ SQLiteException -> 0x08e4 }
            goto L_0x08b8
        L_0x08b6:
            r13 = r16
        L_0x08b8:
            r13.add(r0)     // Catch:{ SQLiteException -> 0x08e4 }
            goto L_0x08d1
        L_0x08bc:
            r0 = move-exception
            r14 = 0
            com.google.android.gms.measurement.internal.zzgd r13 = r6.zzt     // Catch:{ SQLiteException -> 0x08e4 }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x08e4 }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x08e4 }
            java.lang.String r15 = "Failed to merge filter"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ SQLiteException -> 0x08e4 }
            r13.zzc(r15, r14, r0)     // Catch:{ SQLiteException -> 0x08e4 }
        L_0x08d1:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x08e4 }
            if (r0 != 0) goto L_0x0887
            r3.close()
            r0 = r8
            goto L_0x090f
        L_0x08dc:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x08e4 }
        L_0x08e0:
            r3.close()
            goto L_0x090f
        L_0x08e4:
            r0 = move-exception
            goto L_0x08f7
        L_0x08e6:
            r0 = move-exception
            goto L_0x08f6
        L_0x08e8:
            r0 = move-exception
            r65 = r3
            goto L_0x08f6
        L_0x08ec:
            r0 = move-exception
            r5 = 0
            goto L_0x0915
        L_0x08ef:
            r0 = move-exception
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x08f6:
            r3 = 0
        L_0x08f7:
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzt     // Catch:{ all -> 0x0913 }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()     // Catch:{ all -> 0x0913 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzd()     // Catch:{ all -> 0x0913 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0913 }
            r6.zzc(r12, r7, r0)     // Catch:{ all -> 0x0913 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0913 }
            if (r3 == 0) goto L_0x090f
            goto L_0x08e0
        L_0x090f:
            r2.put(r5, r0)
            goto L_0x0921
        L_0x0913:
            r0 = move-exception
            r5 = r3
        L_0x0915:
            if (r5 == 0) goto L_0x091a
            r5.close()
        L_0x091a:
            throw r0
        L_0x091b:
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x0921:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0929:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a47
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0954
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0a47
        L_0x0954:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x095f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a36
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzet r7 = (com.google.android.gms.internal.measurement.zzet) r7
            com.google.android.gms.measurement.internal.zzgd r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()
            java.lang.String r8 = r8.zzr()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x09c9
            com.google.android.gms.measurement.internal.zzgd r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x0999
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x099a
        L_0x0999:
            r15 = 0
        L_0x099a:
            com.google.android.gms.measurement.internal.zzgd r13 = r10.zzt
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzj()
            r66 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzlh r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r8 = r8.zzu()
            java.lang.String r8 = r8.zzq(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x09cb
        L_0x09c9:
            r66 = r0
        L_0x09cb:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a0c
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x09da
            goto L_0x0a0c
        L_0x09da:
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a02
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzu r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r66
            goto L_0x095f
        L_0x0a02:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a38
        L_0x0a0c:
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a2b
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a2c
        L_0x0a2b:
            r7 = 0
        L_0x0a2c:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a3a
        L_0x0a36:
            r66 = r0
        L_0x0a38:
            if (r7 != 0) goto L_0x0a43
        L_0x0a3a:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0a43:
            r0 = r66
            goto L_0x0929
        L_0x0a47:
            r3 = r65
            r29 = r9
            r28 = r11
            goto L_0x0828
        L_0x0a4f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a63:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0af8
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfp r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzlh r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r3 = r3.zzh()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgi r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbx()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r24
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0adf }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0add }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0af4
            com.google.android.gms.measurement.internal.zzgd r0 = r3.zzt     // Catch:{ SQLiteException -> 0x0add }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0add }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0add }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ SQLiteException -> 0x0add }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0add }
            goto L_0x0af4
        L_0x0add:
            r0 = move-exception
            goto L_0x0ae1
        L_0x0adf:
            r0 = move-exception
            r9 = 0
        L_0x0ae1:
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0af4:
            r24 = r4
            goto L_0x0a63
        L_0x0af8:
            return r1
        L_0x0af9:
            r0 = move-exception
            r5 = r4
        L_0x0afb:
            if (r5 == 0) goto L_0x0b00
            r5.close()
        L_0x0b00:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean zzb() {
        return false;
    }
}
