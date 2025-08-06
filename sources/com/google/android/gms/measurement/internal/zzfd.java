package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import e7.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfd {
    public final /* synthetic */ zzfi zza;
    private final String zzb = "default_event_parameters";
    private final Bundle zzc = new Bundle();
    private Bundle zzd;

    public zzfd(zzfi zzfi, String str, Bundle bundle) {
        this.zza = zzfi;
        Preconditions.checkNotEmpty("default_event_parameters");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:35|36|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r11.zza.zzt.zzaA().zzd().zza("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a5 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d A[Catch:{ NumberFormatException | JSONException -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r11 = this;
            android.os.Bundle r0 = r11.zzd
            if (r0 == 0) goto L_0x0006
            goto L_0x00d6
        L_0x0006:
            com.google.android.gms.measurement.internal.zzfi r0 = r11.zza
            android.content.SharedPreferences r0 = r0.zza()
            java.lang.String r1 = r11.zzb
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x00ce
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ JSONException -> 0x00bd }
            r1.<init>()     // Catch:{ JSONException -> 0x00bd }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00bd }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x00bd }
            r0 = 0
            r3 = r0
        L_0x0021:
            int r4 = r2.length()     // Catch:{ JSONException -> 0x00bd }
            if (r3 >= r4) goto L_0x00ba
            org.json.JSONObject r4 = r2.getJSONObject(r3)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            java.lang.String r5 = "n"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            java.lang.String r6 = "t"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            int r7 = r6.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            r8 = 100
            r9 = 2
            r10 = 1
            if (r7 == r8) goto L_0x005f
            r8 = 108(0x6c, float:1.51E-43)
            if (r7 == r8) goto L_0x0055
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L_0x004b
            goto L_0x0069
        L_0x004b:
            java.lang.String r7 = "s"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0069
            r7 = r0
            goto L_0x006a
        L_0x0055:
            java.lang.String r7 = "l"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0069
            r7 = r9
            goto L_0x006a
        L_0x005f:
            java.lang.String r7 = "d"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0069
            r7 = r10
            goto L_0x006a
        L_0x0069:
            r7 = -1
        L_0x006a:
            java.lang.String r8 = "v"
            if (r7 == 0) goto L_0x009d
            if (r7 == r10) goto L_0x0091
            if (r7 == r9) goto L_0x0085
            com.google.android.gms.measurement.internal.zzfi r4 = r11.zza     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzt     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            java.lang.String r5 = "Unrecognized persisted bundle type. Type"
            r4.zzb(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            goto L_0x00b6
        L_0x0085:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            long r6 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            r1.putLong(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            goto L_0x00b6
        L_0x0091:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            double r6 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            r1.putDouble(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            goto L_0x00b6
        L_0x009d:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            r1.putString(r5, r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a5 }
            goto L_0x00b6
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzfi r4 = r11.zza     // Catch:{ JSONException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzt     // Catch:{ JSONException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()     // Catch:{ JSONException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r5 = "Error reading value from SharedPreferences. Value dropped"
            r4.zza(r5)     // Catch:{ JSONException -> 0x00bd }
        L_0x00b6:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x00ba:
            r11.zzd = r1     // Catch:{ JSONException -> 0x00bd }
            goto L_0x00ce
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzfi r0 = r11.zza
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        L_0x00ce:
            android.os.Bundle r0 = r11.zzd
            if (r0 != 0) goto L_0x00d6
            android.os.Bundle r0 = r11.zzc
            r11.zzd = r0
        L_0x00d6:
            android.os.Bundle r0 = r11.zzd
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfd.zza():android.os.Bundle");
    }

    public final void zzb(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zza.zza().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, str2);
                        jSONObject.put(f.f34662a, obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", s.f70071a);
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                        } else {
                            this.zza.zzt.zzaA().zzd().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e11) {
                        this.zza.zzt.zzaA().zzd().zzb("Cannot serialize bundle value to SharedPreferences", e11);
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle;
    }
}
