package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public final class zzeu extends WebViewClient {
    public final /* synthetic */ zzez zza;

    public zzeu(zzez zzez) {
        this.zza = zzez;
    }

    public final void onLoadResource(WebView webView, String str) {
        System.currentTimeMillis();
    }

    public final void onPageFinished(WebView webView, String str) {
        zzez zzez = this.zza;
        zzez.zzi.zza(zzez.zzp.zza(zzne.INIT_NETWORK));
        long zza2 = this.zza.zzn.zza(TimeUnit.MICROSECONDS);
        zzv zzv = zzv.zza;
        zzv.zza(zzx.zzl.zza(), zza2);
    }

    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        zzn zzn = zzn.zze;
        zzl zzl = (zzl) this.zza.zzk.get(Integer.valueOf(i11));
        if (zzl == null) {
            zzl = zzl.zzY;
        }
        zzp zzp = new zzp(zzn, zzl, (String) null);
        this.zza.zzk().hashCode();
        zzp.getMessage();
        this.zza.zzk().o(zzp);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        zzfb zzfb = zzfb.zza;
        if (!zzfb.zzb(parse) || zzfb.zza(parse)) {
            return super.shouldInterceptRequest(webView, str);
        }
        zzp zzp = new zzp(zzn.zzc, zzl.zzac, (String) null);
        this.zza.zzk().hashCode();
        parse.toString();
        this.zza.zzk().o(zzp);
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    }
}
