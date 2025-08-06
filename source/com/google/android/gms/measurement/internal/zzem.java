package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

public final class zzem extends zzf {
    private final zzel zza;
    private boolean zzb;

    public zzem(zzgd zzgd) {
        super(zzgd);
        Context zzaw = this.zzt.zzaw();
        this.zzt.zzf();
        this.zza = new zzel(this, zzaw, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c7 A[SYNTHETIC, Splitter:B:47:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzg()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            r0.zzf()
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0029:
            if (r5 >= r4) goto L_0x012e
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.zzh()     // Catch:{ SQLiteFullException -> 0x00fc, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00c3, all -> 0x00c0 }
            if (r9 != 0) goto L_0x0036
            r1.zzb = r7     // Catch:{ SQLiteFullException -> 0x00bc, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b8 }
            return r2
        L_0x0036:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bc, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b8 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00bc, SQLiteDatabaseLockedException -> 0x00eb, SQLiteException -> 0x00b8 }
            r11 = 0
            if (r10 == 0) goto L_0x0055
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            if (r0 == 0) goto L_0x0055
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            goto L_0x0055
        L_0x004e:
            r0 = move-exception
            goto L_0x0122
        L_0x0051:
            r0 = move-exception
            goto L_0x00ba
        L_0x0053:
            r0 = move-exception
            goto L_0x00be
        L_0x0055:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r15 = "messages"
            if (r0 < 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "Data loss, local db full"
            r0.zza(r4)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            long r13 = r13 - r11
            java.lang.String r0 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r4 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            r11 = 1
            long r13 = r13 + r11
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            r4[r2] = r11     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            int r0 = r9.delete(r15, r0, r4)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            long r11 = (long) r0     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            long r13 = r13 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            r0.zzd(r4, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
        L_0x00a0:
            r9.insertOrThrow(r15, r8, r3)     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0053, SQLiteDatabaseLockedException -> 0x00b3, SQLiteException -> 0x0051, all -> 0x004e }
            if (r10 == 0) goto L_0x00ae
            r10.close()
        L_0x00ae:
            r9.close()
            r2 = 1
            return r2
        L_0x00b3:
            r8 = r10
            goto L_0x00eb
        L_0x00b5:
            r0 = move-exception
            goto L_0x0123
        L_0x00b8:
            r0 = move-exception
            r10 = r8
        L_0x00ba:
            r8 = r9
            goto L_0x00c5
        L_0x00bc:
            r0 = move-exception
            r10 = r8
        L_0x00be:
            r8 = r9
            goto L_0x00fe
        L_0x00c0:
            r0 = move-exception
            r9 = r8
            goto L_0x0123
        L_0x00c3:
            r0 = move-exception
            r10 = r8
        L_0x00c5:
            if (r8 == 0) goto L_0x00d0
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00d0
            r8.endTransaction()     // Catch:{ all -> 0x0120 }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x0120 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x0120 }
            if (r10 == 0) goto L_0x00e7
            r10.close()
        L_0x00e7:
            if (r8 == 0) goto L_0x011a
            goto L_0x0117
        L_0x00ea:
            r9 = r8
        L_0x00eb:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b5 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x00f6
            r8.close()
        L_0x00f6:
            if (r9 == 0) goto L_0x011a
            r9.close()
            goto L_0x011a
        L_0x00fc:
            r0 = move-exception
            r10 = r8
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x0120 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x0120 }
            if (r10 == 0) goto L_0x0115
            r10.close()
        L_0x0115:
            if (r8 == 0) goto L_0x011a
        L_0x0117:
            r8.close()
        L_0x011a:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0029
        L_0x0120:
            r0 = move-exception
            r9 = r8
        L_0x0122:
            r8 = r10
        L_0x0123:
            if (r8 == 0) goto L_0x0128
            r8.close()
        L_0x0128:
            if (r9 == 0) goto L_0x012d
            r9.close()
        L_0x012d:
            throw r0
        L_0x012e:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.zzq(int, byte[]):boolean");
    }

    public final boolean zzf() {
        return false;
    }

    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:59|60|61|62) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:74|75|76|77) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|48|49|197) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00c4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x012e */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d8 A[SYNTHETIC, Splitter:B:123:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01fd A[SYNTHETIC, Splitter:B:151:0x01fd] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x01db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x024a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x024a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x024a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzi(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "rowid"
            java.lang.String r3 = "Error reading entries from local database"
            r22.zzg()
            boolean r0 = r1.zzb
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r22.zzl()
            if (r0 == 0) goto L_0x026b
            r6 = 5
            r7 = 0
            r9 = r6
            r8 = r7
        L_0x001e:
            if (r8 >= r6) goto L_0x025b
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.zzh()     // Catch:{ SQLiteFullException -> 0x0230, SQLiteDatabaseLockedException -> 0x021d, SQLiteException -> 0x01f8, all -> 0x01f5 }
            if (r15 != 0) goto L_0x002a
            r1.zzb = r10     // Catch:{ SQLiteFullException -> 0x01f0, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01e7, all -> 0x01e2 }
            return r4
        L_0x002a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01f0, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01e7, all -> 0x01e2 }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[]{r2}     // Catch:{ all -> 0x01d3 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01d3 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r11 = r15
            r23 = r15
            r15 = r0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01cf }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x01cb }
            r20 = -1
            if (r0 == 0) goto L_0x005c
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x01cb }
            r11.close()     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            goto L_0x0061
        L_0x005c:
            r11.close()     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            r12 = r20
        L_0x0061:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            r14 = r0
            r15 = r11
            goto L_0x0074
        L_0x0072:
            r14 = r4
            r15 = r14
        L_0x0074:
            java.lang.String r12 = "messages"
            java.lang.String r0 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r13 = new java.lang.String[]{r2, r0, r11}     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r0 = 100
            java.lang.String r19 = java.lang.Integer.toString(r0)     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
            r11 = r23
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x01c7, SQLiteDatabaseLockedException -> 0x01c4, SQLiteException -> 0x01c0, all -> 0x01bc }
        L_0x0091:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            if (r0 == 0) goto L_0x0171
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            int r0 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            r12 = 2
            byte[] r13 = r11.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            if (r0 != 0) goto L_0x00db
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00c4 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x00c4 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00c4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzau> r0 = com.google.android.gms.measurement.internal.zzau.CREATOR     // Catch:{ ParseException -> 0x00c4 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00c4 }
            com.google.android.gms.measurement.internal.zzau r0 = (com.google.android.gms.measurement.internal.zzau) r0     // Catch:{ ParseException -> 0x00c4 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            if (r0 == 0) goto L_0x0091
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x00c2:
            r0 = move-exception
            goto L_0x00d7
        L_0x00c4:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x00c2 }
            java.lang.String r13 = "Failed to load event from local database"
            r0.zza(r13)     // Catch:{ all -> 0x00c2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x00d7:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
        L_0x00db:
            if (r0 != r10) goto L_0x0113
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00f6 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x00f6 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00f6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzlk> r0 = com.google.android.gms.measurement.internal.zzlk.CREATOR     // Catch:{ ParseException -> 0x00f6 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzlk r0 = (com.google.android.gms.measurement.internal.zzlk) r0     // Catch:{ ParseException -> 0x00f6 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0109
        L_0x00f4:
            r0 = move-exception
            goto L_0x010f
        L_0x00f6:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x00f4 }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x00f4 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            r0 = r4
        L_0x0109:
            if (r0 == 0) goto L_0x0091
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x010f:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
        L_0x0113:
            if (r0 != r12) goto L_0x014c
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            int r0 = r13.length     // Catch:{ ParseException -> 0x012e }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x012e }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x012e }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzac> r0 = com.google.android.gms.measurement.internal.zzac.CREATOR     // Catch:{ ParseException -> 0x012e }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x012e }
            com.google.android.gms.measurement.internal.zzac r0 = (com.google.android.gms.measurement.internal.zzac) r0     // Catch:{ ParseException -> 0x012e }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0141
        L_0x012c:
            r0 = move-exception
            goto L_0x0148
        L_0x012e:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x012c }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x012c }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            r0 = r4
        L_0x0141:
            if (r0 == 0) goto L_0x0091
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x0148:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
        L_0x014c:
            r12 = 3
            if (r0 != r12) goto L_0x0160
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            java.lang.String r12 = "Skipping app launch break"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x0160:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            java.lang.String r12 = "Unknown record type in local database"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            goto L_0x0091
        L_0x0171:
            java.lang.String r0 = "messages"
            java.lang.String r12 = "rowid <= ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            java.lang.String r14 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            r13[r7] = r14     // Catch:{ SQLiteFullException -> 0x01b8, SQLiteDatabaseLockedException -> 0x01b5, SQLiteException -> 0x01b1, all -> 0x01ac }
            r14 = r23
            int r0 = r14.delete(r0, r12, r13)     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            int r12 = r5.size()     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            if (r0 >= r12) goto L_0x0198
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            java.lang.String r12 = "Fewer entries removed from local database than expected"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
        L_0x0198:
            r14.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            r14.endTransaction()     // Catch:{ SQLiteFullException -> 0x01a9, SQLiteDatabaseLockedException -> 0x01ee, SQLiteException -> 0x01a7, all -> 0x01a5 }
            r11.close()
            r14.close()
            return r5
        L_0x01a5:
            r0 = move-exception
            goto L_0x01af
        L_0x01a7:
            r0 = move-exception
            goto L_0x01ea
        L_0x01a9:
            r0 = move-exception
            goto L_0x01f3
        L_0x01ac:
            r0 = move-exception
            r14 = r23
        L_0x01af:
            r4 = r11
            goto L_0x01e4
        L_0x01b1:
            r0 = move-exception
            r14 = r23
            goto L_0x01ea
        L_0x01b5:
            r14 = r23
            goto L_0x01ee
        L_0x01b8:
            r0 = move-exception
            r14 = r23
            goto L_0x01f3
        L_0x01bc:
            r0 = move-exception
            r14 = r23
            goto L_0x01e4
        L_0x01c0:
            r0 = move-exception
            r14 = r23
            goto L_0x01e9
        L_0x01c4:
            r14 = r23
            goto L_0x01ed
        L_0x01c7:
            r0 = move-exception
            r14 = r23
            goto L_0x01f2
        L_0x01cb:
            r0 = move-exception
            r14 = r23
            goto L_0x01d6
        L_0x01cf:
            r0 = move-exception
            r14 = r23
            goto L_0x01d5
        L_0x01d3:
            r0 = move-exception
            r14 = r15
        L_0x01d5:
            r11 = r4
        L_0x01d6:
            if (r11 == 0) goto L_0x01db
            r11.close()     // Catch:{ SQLiteFullException -> 0x01e0, SQLiteDatabaseLockedException -> 0x01ed, SQLiteException -> 0x01de, all -> 0x01dc }
        L_0x01db:
            throw r0     // Catch:{ SQLiteFullException -> 0x01e0, SQLiteDatabaseLockedException -> 0x01ed, SQLiteException -> 0x01de, all -> 0x01dc }
        L_0x01dc:
            r0 = move-exception
            goto L_0x01e4
        L_0x01de:
            r0 = move-exception
            goto L_0x01e9
        L_0x01e0:
            r0 = move-exception
            goto L_0x01f2
        L_0x01e2:
            r0 = move-exception
            r14 = r15
        L_0x01e4:
            r15 = r14
            goto L_0x0250
        L_0x01e7:
            r0 = move-exception
            r14 = r15
        L_0x01e9:
            r11 = r4
        L_0x01ea:
            r15 = r14
            goto L_0x01fb
        L_0x01ec:
            r14 = r15
        L_0x01ed:
            r11 = r4
        L_0x01ee:
            r15 = r14
            goto L_0x021f
        L_0x01f0:
            r0 = move-exception
            r14 = r15
        L_0x01f2:
            r11 = r4
        L_0x01f3:
            r15 = r14
            goto L_0x0233
        L_0x01f5:
            r0 = move-exception
            r15 = r4
            goto L_0x0250
        L_0x01f8:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x01fb:
            if (r15 == 0) goto L_0x0206
            boolean r12 = r15.inTransaction()     // Catch:{ all -> 0x024e }
            if (r12 == 0) goto L_0x0206
            r15.endTransaction()     // Catch:{ all -> 0x024e }
        L_0x0206:
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzt     // Catch:{ all -> 0x024e }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ all -> 0x024e }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ all -> 0x024e }
            r12.zzb(r3, r0)     // Catch:{ all -> 0x024e }
            r1.zzb = r10     // Catch:{ all -> 0x024e }
            if (r11 == 0) goto L_0x021a
            r11.close()
        L_0x021a:
            if (r15 == 0) goto L_0x024a
            goto L_0x022c
        L_0x021d:
            r11 = r4
            r15 = r11
        L_0x021f:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x024e }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x022a
            r11.close()
        L_0x022a:
            if (r15 == 0) goto L_0x024a
        L_0x022c:
            r15.close()
            goto L_0x024a
        L_0x0230:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0233:
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzt     // Catch:{ all -> 0x024e }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ all -> 0x024e }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ all -> 0x024e }
            r12.zzb(r3, r0)     // Catch:{ all -> 0x024e }
            r1.zzb = r10     // Catch:{ all -> 0x024e }
            if (r11 == 0) goto L_0x0247
            r11.close()
        L_0x0247:
            if (r15 == 0) goto L_0x024a
            goto L_0x022c
        L_0x024a:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x024e:
            r0 = move-exception
            r4 = r11
        L_0x0250:
            if (r4 == 0) goto L_0x0255
            r4.close()
        L_0x0255:
            if (r15 == 0) goto L_0x025a
            r15.close()
        L_0x025a:
            throw r0
        L_0x025b:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r4
        L_0x026b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.zzi(int):java.util.List");
    }

    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = zzh.delete("messages", (String) null, (String[]) null)) > 0) {
                this.zzt.zzaA().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzb("Error resetting local analytics data. error", e11);
        }
    }

    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    public final boolean zzl() {
        Context zzaw = this.zzt.zzaw();
        this.zzt.zzf();
        return zzaw.getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i11 = 5;
            int i12 = 0;
            while (i12 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzh.beginTransaction();
                    zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return true;
                } catch (SQLiteFullException e11) {
                    this.zzt.zzaA().zzd().zzb("Error deleting app launch break from local database", e11);
                    this.zzb = true;
                    if (sQLiteDatabase == null) {
                        i12++;
                    }
                    sQLiteDatabase.close();
                    i12++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i11);
                    i11 += 20;
                    if (sQLiteDatabase == null) {
                        i12++;
                    }
                    sQLiteDatabase.close();
                    i12++;
                } catch (SQLiteException e12) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzt.zzaA().zzd().zzb("Error deleting app launch break from local database", e12);
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i12++;
                    } else {
                        i12++;
                    }
                } catch (Throwable th2) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th2;
                }
            }
            this.zzt.zzaA().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzac) {
        byte[] zzap = this.zzt.zzv().zzap(zzac);
        if (zzap.length <= 131072) {
            return zzq(2, zzap);
        }
        this.zzt.zzaA().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzau zzau) {
        Parcel obtain = Parcel.obtain();
        zzav.zza(zzau, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzt.zzaA().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzlk zzlk) {
        Parcel obtain = Parcel.obtain();
        zzll.zza(zzlk, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzt.zzaA().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
