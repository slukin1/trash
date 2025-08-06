package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

final class zzel extends SQLiteOpenHelper {
    public final /* synthetic */ zzem zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzel(zzem zzem, Context context, String str) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzem;
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e11) {
            throw e11;
        } catch (SQLiteException unused) {
            this.zza.zzt.zzaA().zzd().zza("Opening the local database failed, dropping and recreating it");
            this.zza.zzt.zzf();
            if (!this.zza.zzt.zzaw().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzt.zzaA().zzd().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e12) {
                this.zza.zzt.zzaA().zzd().zzb("Failed to open local database. Events will bypass local storage", e12);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzal.zzb(this.zza.zzt.zzaA(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzal.zza(this.zza.zzt.zzaA(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", (String[]) null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
