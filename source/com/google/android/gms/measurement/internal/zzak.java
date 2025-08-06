package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzak extends zzku {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {Constants.EXTRA_KEY_APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", MTPushConstants.NotificationTime.KEY_DAYS, "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzaj zzj;
    /* access modifiers changed from: private */
    public final zzkq zzk = new zzkq(this.zzt.zzax());

    public zzak(zzlh zzlh) {
        super(zzlh);
        this.zzt.zzf();
        this.zzj = new zzaj(this, this.zzt.zzaw(), "google_app_measurement.db");
    }

    public static final void zzV(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zzh().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j11 = cursor.getLong(0);
                cursor.close();
                return j11;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Database error", str, e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final long zzaa(String str, String[] strArr, long j11) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzh().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j12 = rawQuery.getLong(0);
                rawQuery.close();
                return j12;
            }
            rawQuery.close();
            return j11;
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Database error", str, e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void zzA(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzd("Error deleting user property. appId", zzet.zzn(str), this.zzt.zzj().zzf(str2), e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0333, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0347, code lost:
        if (zzh().insertWithOnConflict("property_filters", (java.lang.String) null, r11, 5) != -1) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0349, code lost:
        r1.zzt.zzaA().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzet.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x035d, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1.zzt.zzaA().zzd().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzet.zzn(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03ac, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x017a, code lost:
        r11 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0186, code lost:
        if (r11.hasNext() == false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0192, code lost:
        if (((com.google.android.gms.internal.measurement.zzet) r11.next()).zzj() != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0194, code lost:
        r1.zzt.zzaA().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzet.zzn(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ad, code lost:
        r11 = r0.zzg().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c3, code lost:
        if (r11.hasNext() == false) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r12 = (com.google.android.gms.internal.measurement.zzek) r11.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01df, code lost:
        if (r12.zzg().isEmpty() == false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e1, code lost:
        r0 = r1.zzt.zzaA().zzk();
        r9 = com.google.android.gms.measurement.internal.zzet.zzn(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f9, code lost:
        if (r12.zzp() == false) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01fb, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0206, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0208, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r20));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0213, code lost:
        r3 = r12.zzbx();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022c, code lost:
        if (r12.zzp() == false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022e, code lost:
        r9 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0237, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0238, code lost:
        r7.put("filter_id", r9);
        r7.put("event_name", r12.zzg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0248, code lost:
        if (r12.zzq() == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x024a, code lost:
        r9 = java.lang.Boolean.valueOf(r12.zzn());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0253, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0254, code lost:
        r7.put("session_scoped", r9);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0268, code lost:
        if (zzh().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x026a, code lost:
        r1.zzt.zzaA().zzd().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzet.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027d, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0299, code lost:
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a7, code lost:
        if (r0.hasNext() == false) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a9, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c3, code lost:
        if (r3.zze().isEmpty() == false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c5, code lost:
        r0 = r1.zzt.zzaA().zzk();
        r8 = com.google.android.gms.measurement.internal.zzet.zzn(r24);
        r9 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02dd, code lost:
        if (r3.zzj() == false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02df, code lost:
        r3 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e8, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02e9, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r9, java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f2, code lost:
        r7 = r3.zzbx();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r2);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0309, code lost:
        if (r3.zzj() == false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x030b, code lost:
        r12 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0314, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0315, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zze());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0327, code lost:
        if (r3.zzk() == false) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0329, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0332, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzei r9 = (com.google.android.gms.internal.measurement.zzei) r9
            com.google.android.gms.internal.measurement.zzkx r9 = r9.zzbB()
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            int r11 = r9.zza()
            if (r11 == 0) goto L_0x009d
            r11 = 0
        L_0x002b:
            int r12 = r9.zza()
            if (r11 >= r12) goto L_0x009d
            com.google.android.gms.internal.measurement.zzek r12 = r9.zze(r11)
            com.google.android.gms.internal.measurement.zzkx r12 = r12.zzbB()
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12
            com.google.android.gms.internal.measurement.zzkx r13 = r12.zzav()
            com.google.android.gms.internal.measurement.zzej r13 = (com.google.android.gms.internal.measurement.zzej) r13
            java.lang.String r14 = r12.zze()
            java.lang.String r14 = com.google.android.gms.measurement.internal.zzhc.zzb(r14)
            if (r14 == 0) goto L_0x0050
            r13.zzb(r14)
            r14 = 1
            goto L_0x0051
        L_0x0050:
            r14 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r7 = r12.zza()
            if (r15 >= r7) goto L_0x0088
            com.google.android.gms.internal.measurement.zzem r7 = r12.zzd(r15)
            java.lang.String r10 = r7.zze()
            r16 = r12
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzhd.zza
            r17 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzhd.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zziq.zzb(r10, r12, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()
            com.google.android.gms.internal.measurement.zzel r7 = (com.google.android.gms.internal.measurement.zzel) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzlb r4 = r7.zzaD()
            com.google.android.gms.internal.measurement.zzem r4 = (com.google.android.gms.internal.measurement.zzem) r4
            r13.zzc(r15, r4)
            r14 = 1
        L_0x0081:
            int r15 = r15 + 1
            r12 = r16
            r4 = r17
            goto L_0x0052
        L_0x0088:
            r17 = r4
            if (r14 == 0) goto L_0x0098
            r9.zzc(r11, r13)
            com.google.android.gms.internal.measurement.zzlb r4 = r9.zzaD()
            com.google.android.gms.internal.measurement.zzei r4 = (com.google.android.gms.internal.measurement.zzei) r4
            r3.set(r8, r4)
        L_0x0098:
            int r11 = r11 + 1
            r4 = r17
            goto L_0x002b
        L_0x009d:
            r17 = r4
            int r4 = r9.zzb()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zzb()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzet r7 = r9.zzf(r4)
            java.lang.String r10 = r7.zze()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzhe.zza
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzhe.zzb
            java.lang.String r10 = com.google.android.gms.measurement.internal.zziq.zzb(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            r7.zza(r10)
            r9.zzd(r4, r7)
            com.google.android.gms.internal.measurement.zzlb r7 = r9.zzaD()
            com.google.android.gms.internal.measurement.zzei r7 = (com.google.android.gms.internal.measurement.zzei) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r17
            goto L_0x0012
        L_0x00dc:
            r17 = r4
            r23.zzW()
            r23.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.zzh()
            r4.beginTransaction()
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r7 = r23.zzh()     // Catch:{ all -> 0x0495 }
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0495 }
            r10 = 0
            r9[r10] = r2     // Catch:{ all -> 0x0495 }
            r7.delete(r6, r0, r9)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0495 }
            r9[r10] = r2     // Catch:{ all -> 0x0495 }
            r7.delete(r5, r0, r9)     // Catch:{ all -> 0x0495 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0112:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x03b2
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ all -> 0x0495 }
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0495 }
            boolean r10 = r0.zzk()     // Catch:{ all -> 0x0495 }
            if (r10 != 0) goto L_0x0144
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            r0.zzb(r8, r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x0144:
            int r10 = r0.zza()     // Catch:{ all -> 0x0495 }
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0150:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x017a
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0495 }
            boolean r12 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r12 != 0) goto L_0x0150
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r0.zzc(r8, r9, r10)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x017a:
            java.util.List r11 = r0.zzh()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0182:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x01ad
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzet r12 = (com.google.android.gms.internal.measurement.zzet) r12     // Catch:{ all -> 0x0495 }
            boolean r12 = r12.zzj()     // Catch:{ all -> 0x0495 }
            if (r12 != 0) goto L_0x0182
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r0.zzc(r8, r9, r10)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x01ad:
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x01b5:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "data"
            java.lang.String r13 = "session_scoped"
            java.lang.String r14 = "filter_id"
            java.lang.String r9 = "audience_id"
            java.lang.String r15 = "app_id"
            if (r12 == 0) goto L_0x0299
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0495 }
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)     // Catch:{ all -> 0x0495 }
            java.lang.String r21 = r12.zzg()     // Catch:{ all -> 0x0495 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0495 }
            if (r21 == 0) goto L_0x0213
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            boolean r13 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r13 == 0) goto L_0x0206
            int r12 = r12.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0495 }
            r20 = r12
            goto L_0x0208
        L_0x0206:
            r20 = 0
        L_0x0208:
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x0495 }
            r0.zzd(r8, r9, r11, r12)     // Catch:{ all -> 0x0495 }
            r21 = r7
            goto L_0x0375
        L_0x0213:
            byte[] r3 = r12.zzbx()     // Catch:{ all -> 0x0495 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r7.<init>()     // Catch:{ all -> 0x0495 }
            r7.put(r15, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r7.put(r9, r15)     // Catch:{ all -> 0x0495 }
            boolean r9 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r9 == 0) goto L_0x0237
            int r9 = r12.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0238
        L_0x0237:
            r9 = 0
        L_0x0238:
            r7.put(r14, r9)     // Catch:{ all -> 0x0495 }
            java.lang.String r9 = "event_name"
            java.lang.String r14 = r12.zzg()     // Catch:{ all -> 0x0495 }
            r7.put(r9, r14)     // Catch:{ all -> 0x0495 }
            boolean r9 = r12.zzq()     // Catch:{ all -> 0x0495 }
            if (r9 == 0) goto L_0x0253
            boolean r9 = r12.zzn()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0254
        L_0x0253:
            r9 = 0
        L_0x0254:
            r7.put(r13, r9)     // Catch:{ all -> 0x0495 }
            r7.put(r8, r3)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ SQLiteException -> 0x0283 }
            r8 = 5
            r9 = 0
            long r7 = r3.insertWithOnConflict(r5, r9, r7, r8)     // Catch:{ SQLiteException -> 0x0283 }
            r12 = -1
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x027d
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt     // Catch:{ SQLiteException -> 0x0283 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ SQLiteException -> 0x0283 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0283 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ SQLiteException -> 0x0283 }
            r3.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0283 }
        L_0x027d:
            r3 = r25
            r7 = r21
            goto L_0x01b5
        L_0x0283:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0375
        L_0x0299:
            r21 = r7
            java.util.List r0 = r0.zzh()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0495 }
        L_0x02a3:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0495 }
            if (r3 == 0) goto L_0x03ac
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzet r3 = (com.google.android.gms.internal.measurement.zzet) r3     // Catch:{ all -> 0x0495 }
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = r3.zze()     // Catch:{ all -> 0x0495 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0495 }
            if (r7 == 0) goto L_0x02f2
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            boolean r11 = r3.zzj()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x02e8
            int r3 = r3.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0495 }
            goto L_0x02e9
        L_0x02e8:
            r3 = 0
        L_0x02e9:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0495 }
            r0.zzd(r7, r8, r9, r3)     // Catch:{ all -> 0x0495 }
            goto L_0x0375
        L_0x02f2:
            byte[] r7 = r3.zzbx()     // Catch:{ all -> 0x0495 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r11.<init>()     // Catch:{ all -> 0x0495 }
            r11.put(r15, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r11.put(r9, r12)     // Catch:{ all -> 0x0495 }
            boolean r12 = r3.zzj()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x0314
            int r12 = r3.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0495 }
            goto L_0x0315
        L_0x0314:
            r12 = 0
        L_0x0315:
            r11.put(r14, r12)     // Catch:{ all -> 0x0495 }
            java.lang.String r12 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zze()     // Catch:{ all -> 0x0495 }
            r11.put(r12, r0)     // Catch:{ all -> 0x0495 }
            boolean r0 = r3.zzk()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x0332
            boolean r0 = r3.zzi()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0333
        L_0x0332:
            r0 = 0
        L_0x0333:
            r11.put(r13, r0)     // Catch:{ all -> 0x0495 }
            r11.put(r8, r7)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ SQLiteException -> 0x0361 }
            r3 = 0
            r7 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r11, r7)     // Catch:{ SQLiteException -> 0x0361 }
            r18 = -1
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x035d
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0361 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ SQLiteException -> 0x0361 }
            r0.zzb(r3, r7)     // Catch:{ SQLiteException -> 0x0361 }
            goto L_0x0375
        L_0x035d:
            r0 = r22
            goto L_0x02a3
        L_0x0361:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0495 }
        L_0x0375:
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ all -> 0x0495 }
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0495 }
            r3 = 0
            r7[r3] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r8 = 1
            r7[r8] = r3     // Catch:{ all -> 0x0495 }
            r3 = r17
            r0.delete(r6, r3, r7)     // Catch:{ all -> 0x0495 }
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x0495 }
            r8 = 0
            r7[r8] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0495 }
            r0.delete(r5, r3, r7)     // Catch:{ all -> 0x0495 }
            r17 = r3
            r7 = r21
            r3 = r25
            goto L_0x0112
        L_0x03ac:
            r3 = r25
            r7 = r21
            goto L_0x0112
        L_0x03b2:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r0.<init>()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0495 }
        L_0x03bc:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x03dc
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzei r6 = (com.google.android.gms.internal.measurement.zzei) r6     // Catch:{ all -> 0x0495 }
            boolean r7 = r6.zzk()     // Catch:{ all -> 0x0495 }
            if (r7 == 0) goto L_0x03d7
            int r6 = r6.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0495 }
            goto L_0x03d8
        L_0x03d7:
            r9 = r3
        L_0x03d8:
            r0.add(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x03bc
        L_0x03dc:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0495 }
            r23.zzW()     // Catch:{ all -> 0x0495 }
            r23.zzg()     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "select count(1) from audience_filter_values where app_id=?"
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x047a }
            r6 = 0
            r7[r6] = r2     // Catch:{ SQLiteException -> 0x047a }
            long r5 = r1.zzZ(r5, r7)     // Catch:{ SQLiteException -> 0x047a }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzag r7 = r7.zzf()     // Catch:{ all -> 0x0495 }
            r8 = 2000(0x7d0, float:2.803E-42)
            com.google.android.gms.measurement.internal.zzef r9 = com.google.android.gms.measurement.internal.zzeg.zzF     // Catch:{ all -> 0x0495 }
            int r7 = r7.zze(r2, r9)     // Catch:{ all -> 0x0495 }
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0495 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0495 }
            long r8 = (long) r7     // Catch:{ all -> 0x0495 }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x0413
            goto L_0x048e
        L_0x0413:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r5.<init>()     // Catch:{ all -> 0x0495 }
            r10 = 0
        L_0x0419:
            int r6 = r0.size()     // Catch:{ all -> 0x0495 }
            if (r10 >= r6) goto L_0x0435
            java.lang.Object r6 = r0.get(r10)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x048e
            int r6 = r6.intValue()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0495 }
            r5.add(r6)     // Catch:{ all -> 0x0495 }
            int r10 = r10 + 1
            goto L_0x0419
        L_0x0435:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0495 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r5.<init>()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = "("
            r5.append(r6)     // Catch:{ all -> 0x0495 }
            r5.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "audience_filter_values"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r6.<init>()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r6.append(r8)     // Catch:{ all -> 0x0495 }
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = " order by rowid desc limit -1 offset ?)"
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0495 }
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0495 }
            r8 = 0
            r6[r8] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r2 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0495 }
            r7 = 1
            r6[r7] = r2     // Catch:{ all -> 0x0495 }
            r3.delete(r5, r0, r6)     // Catch:{ all -> 0x0495 }
            goto L_0x048e
        L_0x047a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zzn(r24)     // Catch:{ all -> 0x0495 }
            r3.zzc(r5, r2, r0)     // Catch:{ all -> 0x0495 }
        L_0x048e:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0495 }
            r4.endTransaction()
            return
        L_0x0495:
            r0 = move-exception
            r4.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzB(java.lang.String, java.util.List):void");
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    public final void zzD(zzh zzh2) {
        Preconditions.checkNotNull(zzh2);
        zzg();
        zzW();
        String zzv = zzh2.zzv();
        Preconditions.checkNotNull(zzv);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzv);
        contentValues.put("app_instance_id", zzh2.zzw());
        contentValues.put("gmp_app_id", zzh2.zzA());
        contentValues.put("resettable_device_id_hash", zzh2.zzC());
        contentValues.put("last_bundle_index", Long.valueOf(zzh2.zzo()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzh2.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzh2.zzn()));
        contentValues.put(Constants.EXTRA_KEY_APP_VERSION, zzh2.zzy());
        contentValues.put("app_store", zzh2.zzx());
        contentValues.put("gmp_version", Long.valueOf(zzh2.zzm()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzh2.zzj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzh2.zzan()));
        contentValues.put(MTPushConstants.NotificationTime.KEY_DAYS, Long.valueOf(zzh2.zzi()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzh2.zzg()));
        contentValues.put("daily_events_count", Long.valueOf(zzh2.zzf()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzh2.zzd()));
        contentValues.put("config_fetched_time", Long.valueOf(zzh2.zzc()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzh2.zzl()));
        contentValues.put("app_version_int", Long.valueOf(zzh2.zzb()));
        contentValues.put("firebase_instance_id", zzh2.zzz());
        contentValues.put("daily_error_events_count", Long.valueOf(zzh2.zze()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzh2.zzh()));
        contentValues.put("health_monitor_sample", zzh2.zzB());
        zzh2.zza();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzh2.zzam()));
        contentValues.put("admob_app_id", zzh2.zzt());
        contentValues.put("dynamite_version", Long.valueOf(zzh2.zzk()));
        contentValues.put("session_stitching_token", zzh2.zzD());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzh2.zzap()));
        contentValues.put("target_os_version", Long.valueOf(zzh2.zzr()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzh2.zzq()));
        List zzE = zzh2.zzE();
        if (zzE != null) {
            if (zzE.isEmpty()) {
                this.zzt.zzaA().zzk().zzb("Safelisted events should not be an empty list. appId", zzv);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, zzE));
            }
        }
        zzop.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeg.zzak) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase zzh3 = zzh();
            if (((long) zzh3.update("apps", contentValues, "app_id = ?", new String[]{zzv})) == 0 && zzh3.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.zzt.zzaA().zzd().zzb("Failed to insert/update app (got -1). appId", zzet.zzn(zzv));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error storing app. appId", zzet.zzn(zzv), e11);
        }
    }

    public final void zzE(zzaq zzaq) {
        Preconditions.checkNotNull(zzaq);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaq.zza);
        contentValues.put("name", zzaq.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaq.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaq.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaq.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaq.zzg));
        contentValues.put("last_bundled_day", zzaq.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaq.zzi);
        contentValues.put("last_sampling_rate", zzaq.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzaq.zze));
        Boolean bool = zzaq.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zzh().insertWithOnConflict(DbParams.TABLE_EVENTS, (String) null, contentValues, 5) == -1) {
                this.zzt.zzaA().zzd().zzb("Failed to insert/update event aggregates (got -1). appId", zzet.zzn(zzaq.zza));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error storing event aggregates. appId", zzet.zzn(zzaq.zza), e11);
        }
    }

    public final boolean zzF() {
        return zzZ("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzG() {
        return zzZ("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzH() {
        return zzZ("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzI() {
        Context zzaw = this.zzt.zzaw();
        this.zzt.zzf();
        return zzaw.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zzJ(String str, Long l11, long j11, zzft zzft) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzft);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l11);
        byte[] zzbx = zzft.zzbx();
        this.zzt.zzaA().zzj().zzc("Saving complex main event, appId, data size", this.zzt.zzj().zzd(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l11);
        contentValues.put("children_to_process", Long.valueOf(j11));
        contentValues.put("main_event", zzbx);
        try {
            if (zzh().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzaA().zzd().zzb("Failed to insert complex main event (got -1). appId", zzet.zzn(str));
            return false;
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error storing complex main event. appId", zzet.zzn(str), e11);
            return false;
        }
    }

    public final boolean zzK(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zzW();
        String str = zzac.zza;
        Preconditions.checkNotNull(str);
        if (zzp(str, zzac.zzc.zzb) == null) {
            long zzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzt.zzf();
            if (zzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzac.zzb);
        contentValues.put("name", zzac.zzc.zzb);
        zzV(contentValues, "value", Preconditions.checkNotNull(zzac.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzac.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzac.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzac.zzh));
        contentValues.put("timed_out_event", this.zzt.zzv().zzap(zzac.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzac.zzd));
        contentValues.put("triggered_event", this.zzt.zzv().zzap(zzac.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzac.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzac.zzj));
        contentValues.put("expired_event", this.zzt.zzv().zzap(zzac.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                this.zzt.zzaA().zzd().zzb("Failed to insert/update conditional user property (got -1)", zzet.zzn(str));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error storing conditional user property", zzet.zzn(str), e11);
        }
        return true;
    }

    public final boolean zzL(zzlm zzlm) {
        Preconditions.checkNotNull(zzlm);
        zzg();
        zzW();
        if (zzp(zzlm.zza, zzlm.zzc) == null) {
            if (zzlp.zzak(zzlm.zzc)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzlm.zza}) >= ((long) this.zzt.zzf().zzf(zzlm.zza, zzeg.zzG, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzlm.zzc)) {
                long zzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlm.zza, zzlm.zzb});
                this.zzt.zzf();
                if (zzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzlm.zza);
        contentValues.put("origin", zzlm.zzb);
        contentValues.put("name", zzlm.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzlm.zzd));
        zzV(contentValues, "value", zzlm.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                this.zzt.zzaA().zzd().zzb("Failed to insert/update user property (got -1). appId", zzet.zzn(zzlm.zza));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error storing user property. appId", zzet.zzn(zzlm.zza), e11);
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzU(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzle r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r20.zzg()
            r20.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.zzh()     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r5 = ""
            r13 = -1
            r15 = 2
            r12 = 1
            r11 = 0
            if (r4 == 0) goto L_0x0071
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
        L_0x003a:
            if (r4 == 0) goto L_0x003e
            java.lang.String r5 = "rowid <= ? and "
        L_0x003e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r4.append(r7)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r5 != 0) goto L_0x0062
            r4.close()
            return
        L_0x0062:
            java.lang.String r3 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()     // Catch:{ SQLiteException -> 0x006e }
            goto L_0x00b3
        L_0x006e:
            r0 = move-exception
            goto L_0x020e
        L_0x0071:
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0080
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r6[r11] = r3     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            goto L_0x0084
        L_0x0080:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
        L_0x0084:
            if (r4 == 0) goto L_0x0088
            java.lang.String r5 = " and rowid <= ?"
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r4.append(r7)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r5 = " order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x020c, all -> 0x020a }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r5 != 0) goto L_0x00ac
            r4.close()
            return
        L_0x00ac:
            java.lang.String r5 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()     // Catch:{ SQLiteException -> 0x006e }
        L_0x00b3:
            r16 = r4
            r17 = r5
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r8 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            r9 = 0
            r10 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r15 = r11
            r11 = r18
            r12 = r19
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            boolean r4 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            if (r4 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r12.close()
            return
        L_0x00f4:
            byte[] r4 = r12.getBlob(r15)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzgc r5 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzmh r4 = com.google.android.gms.measurement.internal.zzlj.zzm(r5, r4)     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzlb r4 = r4.zzaD()     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ IOException -> 0x01d8 }
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            if (r5 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzk()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
        L_0x0121:
            r12.close()     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r2.zza = r4     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            r13 = 3
            if (r4 == 0) goto L_0x0141
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r5[r15] = r3     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r14 = 1
            r5[r14] = r17     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r7 = 2
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r7 = r4
            r8 = r5
            goto L_0x014d
        L_0x0141:
            r14 = 1
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            r5 = 2
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r6[r15] = r3     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r6[r14] = r17     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r7 = r4
            r8 = r6
        L_0x014d:
            java.lang.String r5 = "raw_events"
            java.lang.String r4 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r6, r9, r10}     // Catch:{ SQLiteException -> 0x01fc, all -> 0x01f6 }
            r9 = 0
            r10 = 0
            java.lang.String r11 = "rowid"
            r16 = 0
            r4 = r0
            r17 = r12
            r12 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r0 == 0) goto L_0x01c1
        L_0x0171:
            long r5 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x006e }
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x01a2 }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r7, r0)     // Catch:{ IOException -> 0x01a2 }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ IOException -> 0x01a2 }
            java.lang.String r7 = r4.getString(r14)     // Catch:{ SQLiteException -> 0x006e }
            r0.zzi(r7)     // Catch:{ SQLiteException -> 0x006e }
            r7 = 2
            long r8 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x006e }
            r0.zzm(r8)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0     // Catch:{ SQLiteException -> 0x006e }
            boolean r0 = r2.zza(r5, r0)     // Catch:{ SQLiteException -> 0x006e }
            if (r0 != 0) goto L_0x01b7
            r4.close()
            return
        L_0x01a2:
            r0 = move-exception
            r7 = 2
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x006e }
            r5.zzc(r6, r8, r0)     // Catch:{ SQLiteException -> 0x006e }
        L_0x01b7:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x006e }
            if (r0 != 0) goto L_0x0171
            r4.close()
            return
        L_0x01c1:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x006e }
            r0.zzb(r2, r5)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()
            return
        L_0x01d8:
            r0 = move-exception
            r17 = r12
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x01f4, all -> 0x01f2 }
            r17.close()
            return
        L_0x01f2:
            r0 = move-exception
            goto L_0x01f9
        L_0x01f4:
            r0 = move-exception
            goto L_0x01ff
        L_0x01f6:
            r0 = move-exception
            r17 = r12
        L_0x01f9:
            r3 = r17
            goto L_0x0229
        L_0x01fc:
            r0 = move-exception
            r17 = r12
        L_0x01ff:
            r4 = r17
            goto L_0x020e
        L_0x0202:
            r0 = move-exception
            r3 = r16
            goto L_0x0229
        L_0x0206:
            r0 = move-exception
            r4 = r16
            goto L_0x020e
        L_0x020a:
            r0 = move-exception
            goto L_0x0229
        L_0x020c:
            r0 = move-exception
            r4 = r3
        L_0x020e:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x0227 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0227 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0227 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0227 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0227 }
            if (r4 == 0) goto L_0x0226
            r4.close()
        L_0x0226:
            return
        L_0x0227:
            r0 = move-exception
            r3 = r4
        L_0x0229:
            if (r3 == 0) goto L_0x022e
            r3.close()
        L_0x022e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzU(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzle):void");
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            return zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzd("Error deleting conditional property", zzet.zzn(str), this.zzt.zzj().zzf(str2), e11);
            return 0;
        }
    }

    public final boolean zzb() {
        return false;
    }

    public final long zzc(String str, String str2) {
        long j11;
        SQLiteException e11;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh2 = zzh();
        zzh2.beginTransaction();
        try {
            j11 = zzaa("select " + "first_open_count" + " from app2 where app_id=?", new String[]{str}, -1);
            if (j11 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zzh2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzt.zzaA().zzd().zzc("Failed to insert column (got -1). appId", zzet.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                j11 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + j11));
                if (((long) zzh2.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.zzt.zzaA().zzd().zzc("Failed to update column (got 0). appId", zzet.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                zzh2.setTransactionSuccessful();
                zzh2.endTransaction();
                return j11;
            } catch (SQLiteException e12) {
                e11 = e12;
            }
        } catch (SQLiteException e13) {
            j11 = 0;
            e11 = e13;
            try {
                this.zzt.zzaA().zzd().zzd("Error inserting column. appId", zzet.zzn(str), "first_open_count", e11);
                zzh2.endTransaction();
                return j11;
            } catch (Throwable th2) {
                zzh2.endTransaction();
                throw th2;
            }
        }
    }

    public final long zzd() {
        return zzaa("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zze() {
        return zzaa("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zzf(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzk().zzb("Error opening database", e11);
            throw e11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzW()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zzh()     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00ba }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgd r8 = r7.zzt     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00ba }
            r1.close()
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.zzlj.zzm(r3, r2)     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzlb r2 = r2.zzaD()     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzlh r8 = r7.zzf     // Catch:{ SQLiteException -> 0x00ba }
            r8.zzu()     // Catch:{ SQLiteException -> 0x00ba }
            java.util.List r8 = r2.zzi()     // Catch:{ SQLiteException -> 0x00ba }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00ba }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00ba }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00ba }
        L_0x0056:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00ba }
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x00ba }
            boolean r5 = r3.zzu()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzv()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzy()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zzw()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x009e:
            r1.close()
            return r2
        L_0x00a2:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzt     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r8)     // Catch:{ SQLiteException -> 0x00ba }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00ba }
            r1.close()
            return r0
        L_0x00ba:
            r8 = move-exception
            goto L_0x00c0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00d7
        L_0x00be:
            r8 = move-exception
            r1 = r0
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d4
            r1.close()
        L_0x00d4:
            return r0
        L_0x00d5:
            r8 = move-exception
            r0 = r1
        L_0x00d7:
            if (r0 == 0) goto L_0x00dc
            r0.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzi(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0121 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0125 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0159 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0177 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x017a A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0189 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01d4 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01f8 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x020f A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0221 A[Catch:{ SQLiteException -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x025b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzh zzj(java.lang.String r39) {
        /*
            r38 = this;
            r1 = r38
            r2 = r39
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r39)
            r38.zzg()
            r38.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r38.zzh()     // Catch:{ SQLiteException -> 0x023c, all -> 0x023a }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37}     // Catch:{ SQLiteException -> 0x023c, all -> 0x023a }
            java.lang.String r7 = "app_id=?"
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x023c, all -> 0x023a }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x023c, all -> 0x023a }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x023c, all -> 0x023a }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0238 }
            if (r5 != 0) goto L_0x0073
            r4.close()
            return r3
        L_0x0073:
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzlh r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x0238 }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x0238 }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzJ(r6)     // Catch:{ SQLiteException -> 0x0238 }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzY(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzag(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzac(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzad(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzab(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzL(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzK(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzZ(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzU(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 != 0) goto L_0x00df
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r6 = r12
            goto L_0x00e0
        L_0x00df:
            r6 = r0
        L_0x00e0:
            r5.zzae(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzT(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzR(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzQ(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzO(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzN(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzW(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 == 0) goto L_0x0125
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x012a
        L_0x0125:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0238 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0238 }
        L_0x012a:
            r5.zzM(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzX(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzP(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzS(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzaa(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 23
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 != 0) goto L_0x0162
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 == 0) goto L_0x0160
            goto L_0x0162
        L_0x0160:
            r6 = r12
            goto L_0x0163
        L_0x0162:
            r6 = r0
        L_0x0163:
            r5.zzI(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 24
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzH(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 25
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 == 0) goto L_0x017a
            r6 = 0
            goto L_0x017e
        L_0x017a:
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x017e:
            r5.zzV(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r6 = 26
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 != 0) goto L_0x019b
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            java.lang.String r7 = ","
            r8 = -1
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ SQLiteException -> 0x0238 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzah(r6)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x019b:
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzag r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzef r7 = com.google.android.gms.measurement.internal.zzeg.zzao     // Catch:{ SQLiteException -> 0x0238 }
            boolean r6 = r6.zzs(r2, r7)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 != 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzag r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzef r7 = com.google.android.gms.measurement.internal.zzeg.zzam     // Catch:{ SQLiteException -> 0x0238 }
            boolean r6 = r6.zzs(r3, r7)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 == 0) goto L_0x01c3
        L_0x01ba:
            r6 = 28
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzai(r6)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x01c3:
            com.google.android.gms.internal.measurement.zzrd.zzc()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzag r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzef r7 = com.google.android.gms.measurement.internal.zzeg.zzaq     // Catch:{ SQLiteException -> 0x0238 }
            boolean r6 = r6.zzs(r3, r7)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 == 0) goto L_0x01e7
            r6 = 29
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r7 != 0) goto L_0x01e3
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r6 == 0) goto L_0x01e3
            goto L_0x01e4
        L_0x01e3:
            r0 = r12
        L_0x01e4:
            r5.zzak(r0)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x01e7:
            com.google.android.gms.internal.measurement.zzpz.zzc()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzef r6 = com.google.android.gms.measurement.internal.zzeg.zzaE     // Catch:{ SQLiteException -> 0x0238 }
            boolean r0 = r0.zzs(r3, r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r0 == 0) goto L_0x0201
            r0 = 30
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzal(r6)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x0201:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzef r6 = com.google.android.gms.measurement.internal.zzeg.zzaH     // Catch:{ SQLiteException -> 0x0238 }
            boolean r0 = r0.zzs(r3, r6)     // Catch:{ SQLiteException -> 0x0238 }
            if (r0 == 0) goto L_0x0218
            r0 = 31
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0238 }
            r5.zzaj(r6)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x0218:
            r5.zzF()     // Catch:{ SQLiteException -> 0x0238 }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0238 }
            if (r0 == 0) goto L_0x0234
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0238 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0238 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r39)     // Catch:{ SQLiteException -> 0x0238 }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0238 }
        L_0x0234:
            r4.close()
            return r5
        L_0x0238:
            r0 = move-exception
            goto L_0x023e
        L_0x023a:
            r0 = move-exception
            goto L_0x0259
        L_0x023c:
            r0 = move-exception
            r4 = r3
        L_0x023e:
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ all -> 0x0257 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ all -> 0x0257 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ all -> 0x0257 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zzn(r39)     // Catch:{ all -> 0x0257 }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x0257 }
            if (r4 == 0) goto L_0x0256
            r4.close()
        L_0x0256:
            return r3
        L_0x0257:
            r0 = move-exception
            r3 = r4
        L_0x0259:
            if (r3 == 0) goto L_0x025e
            r3.close()
        L_0x025e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzac zzk(java.lang.String r31, java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r8 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            r30.zzg()
            r30.zzW()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r30.zzh()     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r12 = "origin"
            java.lang.String r13 = "value"
            java.lang.String r14 = "active"
            java.lang.String r15 = "trigger_event_name"
            java.lang.String r16 = "trigger_timeout"
            java.lang.String r17 = "timed_out_event"
            java.lang.String r18 = "creation_timestamp"
            java.lang.String r19 = "triggered_event"
            java.lang.String r20 = "triggered_timestamp"
            java.lang.String r21 = "time_to_live"
            java.lang.String r22 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            r2 = 0
            r14[r2] = r31     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            r3 = 1
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0104, all -> 0x0102 }
            boolean r4 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0100 }
            if (r4 != 0) goto L_0x0056
            r10.close()
            return r9
        L_0x0056:
            java.lang.String r4 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x0100 }
            if (r4 != 0) goto L_0x005e
            java.lang.String r4 = ""
        L_0x005e:
            r17 = r4
            java.lang.Object r6 = r1.zzq(r10, r3)     // Catch:{ SQLiteException -> 0x0100 }
            int r0 = r10.getInt(r0)     // Catch:{ SQLiteException -> 0x0100 }
            if (r0 == 0) goto L_0x006d
            r21 = r3
            goto L_0x006f
        L_0x006d:
            r21 = r2
        L_0x006f:
            r0 = 3
            java.lang.String r22 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0100 }
            r0 = 4
            long r24 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlh r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlj r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0100 }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0100 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzau> r3 = com.google.android.gms.measurement.internal.zzau.CREATOR     // Catch:{ SQLiteException -> 0x0100 }
            android.os.Parcelable r0 = r0.zzi(r2, r3)     // Catch:{ SQLiteException -> 0x0100 }
            r23 = r0
            com.google.android.gms.measurement.internal.zzau r23 = (com.google.android.gms.measurement.internal.zzau) r23     // Catch:{ SQLiteException -> 0x0100 }
            r0 = 6
            long r19 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlh r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlj r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0100 }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0100 }
            android.os.Parcelable r0 = r0.zzi(r2, r3)     // Catch:{ SQLiteException -> 0x0100 }
            r26 = r0
            com.google.android.gms.measurement.internal.zzau r26 = (com.google.android.gms.measurement.internal.zzau) r26     // Catch:{ SQLiteException -> 0x0100 }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0100 }
            r0 = 9
            long r27 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlh r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlj r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0100 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0100 }
            android.os.Parcelable r0 = r0.zzi(r2, r3)     // Catch:{ SQLiteException -> 0x0100 }
            r29 = r0
            com.google.android.gms.measurement.internal.zzau r29 = (com.google.android.gms.measurement.internal.zzau) r29     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzlk r18 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ SQLiteException -> 0x0100 }
            r2 = r18
            r3 = r32
            r7 = r17
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ SQLiteException -> 0x0100 }
            r15 = r0
            r16 = r31
            r15.<init>(r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r29)     // Catch:{ SQLiteException -> 0x0100 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0100 }
            if (r2 == 0) goto L_0x00fc
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r31)     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0100 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch:{ SQLiteException -> 0x0100 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ SQLiteException -> 0x0100 }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0100 }
        L_0x00fc:
            r10.close()
            return r0
        L_0x0100:
            r0 = move-exception
            goto L_0x0106
        L_0x0102:
            r0 = move-exception
            goto L_0x012b
        L_0x0104:
            r0 = move-exception
            r10 = r9
        L_0x0106:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x0129 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0129 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r31)     // Catch:{ all -> 0x0129 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ all -> 0x0129 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ all -> 0x0129 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0129 }
            if (r10 == 0) goto L_0x0128
            r10.close()
        L_0x0128:
            return r9
        L_0x0129:
            r0 = move-exception
            r9 = r10
        L_0x012b:
            if (r9 == 0) goto L_0x0130
            r9.close()
        L_0x0130:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final zzai zzl(long j11, String str, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return zzm(j11, str, 1, false, false, z13, false, z15);
    }

    public final zzai zzm(long j11, String str, long j12, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        String[] strArr = {str};
        zzai zzai = new zzai();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh2 = zzh();
            cursor = zzh2.query("apps", new String[]{MTPushConstants.NotificationTime.KEY_DAYS, "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.zzt.zzaA().zzk().zzb("Not updating daily counts, app is not known. appId", zzet.zzn(str));
                cursor.close();
                return zzai;
            }
            if (cursor.getLong(0) == j11) {
                zzai.zzb = cursor.getLong(1);
                zzai.zza = cursor.getLong(2);
                zzai.zzc = cursor.getLong(3);
                zzai.zzd = cursor.getLong(4);
                zzai.zze = cursor.getLong(5);
            }
            if (z11) {
                zzai.zzb += j12;
            }
            if (z12) {
                zzai.zza += j12;
            }
            if (z13) {
                zzai.zzc += j12;
            }
            if (z14) {
                zzai.zzd += j12;
            }
            if (z15) {
                zzai.zze += j12;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(MTPushConstants.NotificationTime.KEY_DAYS, Long.valueOf(j11));
            contentValues.put("daily_public_events_count", Long.valueOf(zzai.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzai.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzai.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzai.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzai.zze));
            zzh2.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzai;
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error updating daily counts. appId", zzet.zzn(str), e11);
            if (cursor != null) {
                cursor.close();
            }
            return zzai;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaq zzn(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r15 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r27.zzg()
            r27.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r19 = 0
            android.database.sqlite.SQLiteDatabase r2 = r27.zzh()     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.String r3 = "events"
            r10 = 0
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.String r5 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r6[r10] = r28     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r11 = 1
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r2 != 0) goto L_0x005c
            r13.close()
            return r19
        L_0x005c:
            long r5 = r13.getLong(r10)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            long r7 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            long r16 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r0 = 3
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r3 = 0
            if (r2 == 0) goto L_0x0074
            r20 = r3
            goto L_0x0078
        L_0x0074:
            long r20 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
        L_0x0078:
            r0 = 4
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r2 == 0) goto L_0x0082
            r0 = r19
            goto L_0x008a
        L_0x0082:
            long r22 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
        L_0x008a:
            r2 = 5
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x0094
            r18 = r19
            goto L_0x009e
        L_0x0094:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r18 = r2
        L_0x009e:
            r2 = 6
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x00a8
            r22 = r19
            goto L_0x00b2
        L_0x00a8:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r22 = r2
        L_0x00b2:
            r2 = 7
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 != 0) goto L_0x00cb
            long r23 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r25 = 1
            int r2 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r2 != 0) goto L_0x00c4
            r10 = r11
        L_0x00c4:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r23 = r2
            goto L_0x00cd
        L_0x00cb:
            r23 = r19
        L_0x00cd:
            r2 = 8
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x00d7
            r9 = r3
            goto L_0x00dc
        L_0x00d7:
            long r2 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r9 = r2
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzaq r24 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r2 = r24
            r3 = r28
            r4 = r29
            r11 = r16
            r25 = r13
            r13 = r20
            r15 = r0
            r16 = r18
            r17 = r22
            r18 = r23
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            boolean r0 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r28)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            r0.zzb(r2, r3)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
        L_0x010d:
            r25.close()
            return r24
        L_0x0111:
            r0 = move-exception
            goto L_0x0118
        L_0x0113:
            r0 = move-exception
            goto L_0x011e
        L_0x0115:
            r0 = move-exception
            r25 = r13
        L_0x0118:
            r19 = r25
            goto L_0x014e
        L_0x011b:
            r0 = move-exception
            r25 = r13
        L_0x011e:
            r13 = r25
            goto L_0x0126
        L_0x0121:
            r0 = move-exception
            goto L_0x014e
        L_0x0123:
            r0 = move-exception
            r13 = r19
        L_0x0126:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Error querying events. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r28)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch:{ all -> 0x014b }
            r6 = r29
            java.lang.String r5 = r5.zzd(r6)     // Catch:{ all -> 0x014b }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x014b }
            if (r13 == 0) goto L_0x014a
            r13.close()
        L_0x014a:
            return r19
        L_0x014b:
            r0 = move-exception
            r19 = r13
        L_0x014e:
            if (r19 == 0) goto L_0x0153
            r19.close()
        L_0x0153:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzn(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzlm zzp(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.zzW()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zzh()     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r12 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            java.lang.String r14 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r2 = 0
            r15[r2] = r20     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r3 = 1
            r15[r3] = r9     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0080, all -> 0x007e }
            boolean r4 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x007c }
            if (r4 != 0) goto L_0x0043
            r11.close()
            return r10
        L_0x0043:
            long r6 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x007c }
            java.lang.Object r8 = r1.zzq(r11, r3)     // Catch:{ SQLiteException -> 0x007c }
            if (r8 != 0) goto L_0x0051
            r11.close()
            return r10
        L_0x0051:
            java.lang.String r4 = r11.getString(r0)     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzlm r0 = new com.google.android.gms.measurement.internal.zzlm     // Catch:{ SQLiteException -> 0x007c }
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x007c }
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x007c }
            if (r2 == 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r20)     // Catch:{ SQLiteException -> 0x007c }
            r2.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x007c }
        L_0x0078:
            r11.close()
            return r0
        L_0x007c:
            r0 = move-exception
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            goto L_0x00a7
        L_0x0080:
            r0 = move-exception
            r11 = r10
        L_0x0082:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r20)     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = r5.zzf(r9)     // Catch:{ all -> 0x00a5 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x00a5 }
            if (r11 == 0) goto L_0x00a4
            r11.close()
        L_0x00a4:
            return r10
        L_0x00a5:
            r0 = move-exception
            r10 = r11
        L_0x00a7:
            if (r10 == 0) goto L_0x00ac
            r10.close()
        L_0x00ac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzp(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzlm");
    }

    public final Object zzq(Cursor cursor, int i11) {
        int type = cursor.getType(i11);
        if (type == 0) {
            this.zzt.zzaA().zzd().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i11));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i11));
            }
            if (type == 3) {
                return cursor.getString(i11);
            }
            if (type != 4) {
                this.zzt.zzaA().zzd().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzt.zzaA().zzd().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zzh()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0022, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0025
        L_0x0020:
            r0 = move-exception
            goto L_0x003e
        L_0x0022:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0025:
            com.google.android.gms.measurement.internal.zzgd r3 = r6.zzt     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzr():java.lang.String");
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb2.append(" and name glob ?");
        }
        return zzt(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List zzt(String str, String[] strArr) {
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh2 = zzh();
            String[] strArr2 = {"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            this.zzt.zzf();
            Cursor query = zzh2.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.zzt.zzf();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zzq = zzq(query, 3);
                        boolean z11 = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j11 = query.getLong(6);
                        zzlj zzu = this.zzf.zzu();
                        byte[] blob = query.getBlob(7);
                        Parcelable.Creator<zzau> creator = zzau.CREATOR;
                        arrayList.add(new zzac(string, string2, new zzlk(string3, query.getLong(10), zzq, string2), query.getLong(8), z11, string4, (zzau) zzu.zzi(blob, creator), j11, (zzau) this.zzf.zzu().zzi(query.getBlob(9), creator), query.getLong(11), (zzau) this.zzf.zzu().zzi(query.getBlob(12), creator)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        zzer zzd2 = this.zzt.zzaA().zzd();
                        this.zzt.zzf();
                        zzd2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzb("Error querying conditional user property value", e11);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List zzu(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.zzt.zzf();
            Cursor query = zzh().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j11 = query.getLong(2);
                    Object zzq = zzq(query, 3);
                    if (zzq == null) {
                        this.zzt.zzaA().zzd().zzb("Read invalid user property value, ignoring it. appId", zzet.zzn(str));
                    } else {
                        arrayList.add(new zzlm(str, str2, string, j11, zzq));
                    }
                } while (query.moveToNext());
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzc("Error querying user properties. appId", zzet.zzn(str), e11);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0126 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzv(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            r17.zzg()
            r17.zzW()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            r12 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0108 }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x0108 }
            r14 = r18
            r3.add(r14)     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x0106 }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x0106 }
            if (r5 != 0) goto L_0x0038
            r15 = r19
            r3.add(r15)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0102 }
            goto L_0x003a
        L_0x0038:
            r15 = r19
        L_0x003a:
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x0102 }
            if (r5 != 0) goto L_0x0059
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0102 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0102 }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0102 }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0102 }
        L_0x0059:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x0102 }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x0102 }
            android.database.sqlite.SQLiteDatabase r3 = r17.zzh()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r5 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0102 }
            r4.zzf()     // Catch:{ SQLiteException -> 0x0102 }
            r9 = 0
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r16
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0102 }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0102 }
            if (r3 != 0) goto L_0x009d
            r12.close()
            return r2
        L_0x009d:
            int r3 = r2.size()     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0102 }
            r4.zzf()     // Catch:{ SQLiteException -> 0x0102 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00c3
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0102 }
            r5.zzf()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0102 }
            r0.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x0102 }
            goto L_0x00fe
        L_0x00c3:
            r3 = 0
            java.lang.String r7 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x0102 }
            r3 = 1
            long r8 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x0102 }
            r3 = 2
            java.lang.Object r10 = r1.zzq(r12, r3)     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r15 = r12.getString(r13)     // Catch:{ SQLiteException -> 0x0102 }
            if (r10 != 0) goto L_0x00ec
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ SQLiteException -> 0x0102 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0102 }
            java.lang.String r4 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r18)     // Catch:{ SQLiteException -> 0x0102 }
            r3.zzd(r4, r5, r15, r0)     // Catch:{ SQLiteException -> 0x0102 }
            goto L_0x00f8
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzlm r3 = new com.google.android.gms.measurement.internal.zzlm     // Catch:{ SQLiteException -> 0x0102 }
            r4 = r3
            r5 = r18
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0102 }
            r2.add(r3)     // Catch:{ SQLiteException -> 0x0102 }
        L_0x00f8:
            boolean r3 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0102 }
            if (r3 != 0) goto L_0x009d
        L_0x00fe:
            r12.close()
            return r2
        L_0x0102:
            r0 = move-exception
            goto L_0x010d
        L_0x0104:
            r0 = move-exception
            goto L_0x012a
        L_0x0106:
            r0 = move-exception
            goto L_0x010b
        L_0x0108:
            r0 = move-exception
            r14 = r18
        L_0x010b:
            r15 = r19
        L_0x010d:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x0104 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0104 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r18)     // Catch:{ all -> 0x0104 }
            r2.zzd(r3, r4, r15, r0)     // Catch:{ all -> 0x0104 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0104 }
            if (r12 == 0) goto L_0x0129
            r12.close()
        L_0x0129:
            return r0
        L_0x012a:
            if (r12 == 0) goto L_0x012f
            r12.close()
        L_0x012f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzak.zzv(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    public final void zzx() {
        zzW();
        zzh().endTransaction();
    }

    public final void zzy(List list) {
        zzg();
        zzW();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzI()) {
            String str = "(" + TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list) + ")";
            if (zzZ("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                this.zzt.zzaA().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e11) {
                this.zzt.zzaA().zzd().zzb("Error incrementing retry count. error", e11);
            }
        }
    }

    public final void zzz() {
        zzg();
        zzW();
        if (zzI()) {
            long zza2 = this.zzf.zzs().zza.zza();
            long elapsedRealtime = this.zzt.zzax().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            this.zzt.zzf();
            if (abs > ((Long) zzeg.zzy.zza((Object) null)).longValue()) {
                this.zzf.zzs().zza.zzb(elapsedRealtime);
                zzg();
                zzW();
                if (zzI()) {
                    SQLiteDatabase zzh2 = zzh();
                    this.zzt.zzf();
                    int delete = zzh2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzt.zzax().currentTimeMillis()), String.valueOf(zzag.zzA())});
                    if (delete > 0) {
                        this.zzt.zzaA().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
