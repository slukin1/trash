package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class zzbo implements zzbn {
    private final String zza;

    public zzbo(String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zznf zznf : zzni.zzk(bArr).zzH()) {
            if (!CollectionsKt__CollectionsKt.n("INIT_TOTAL", "EXECUTE_TOTAL").contains(zznf.zzj().name()) || !zznf.zzT()) {
                zznf.zzJ();
                zznf.zzK();
                zznf.zzj().name();
                zznf.zzU();
            } else {
                zznf.zzJ();
                zznf.zzK();
                zznf.zzj().name();
                zznf.zzg().zzk();
                zznf.zzg().zzf();
                zznf.zzU();
            }
        }
    }

    public final boolean zza(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                httpURLConnection = (HttpURLConnection) new URL(this.zza).openConnection();
            } else if (URLUtil.isHttpsUrl(this.zza)) {
                httpURLConnection = (HttpsURLConnection) new URL(this.zza).openConnection();
            } else {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            if (httpURLConnection.getResponseCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            e11.getMessage();
            return false;
        }
    }
}
