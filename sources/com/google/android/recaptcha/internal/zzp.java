package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class zzp extends Exception {
    public static final zzo zza = new zzo((r) null);
    /* access modifiers changed from: private */
    public static final Map zzb;
    private final zzn zzc;
    private final zzl zzd;
    private final String zze;
    private final Map zzf;

    static {
        zzpb zzpb = zzpb.JS_INTERNAL_ERROR;
        zzn zzn = zzn.zzc;
        zzb = MapsKt__MapsKt.l(l.a(zzpb.JS_NETWORK_ERROR, new zzp(zzn.zze, zzl.zzm, (String) null)), l.a(zzpb, new zzp(zzn, zzl.zzk, (String) null)), l.a(zzpb.JS_INVALID_SITE_KEY, new zzp(zzn.zzf, zzl.zzn, (String) null)), l.a(zzpb.JS_INVALID_SITE_KEY_TYPE, new zzp(zzn.zzg, zzl.zzo, (String) null)), l.a(zzpb.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzp(zzn.zzh, zzl.zzp, (String) null)), l.a(zzpb.JS_INVALID_ACTION, new zzp(zzn.zzi, zzl.zzq, (String) null)), l.a(zzpb.JS_PROGRAM_ERROR, new zzp(zzn, zzl.zzu, (String) null)));
    }

    public zzp(zzn zzn, zzl zzl, String str) {
        this.zzc = zzn;
        this.zzd = zzl;
        this.zze = str;
        zzn zzn2 = zzn.zze;
        RecaptchaErrorCode recaptchaErrorCode = RecaptchaErrorCode.NETWORK_ERROR;
        this.zzf = MapsKt__MapsKt.l(l.a(zzn2, new RecaptchaException(recaptchaErrorCode, (String) null, 2, (r) null)), l.a(zzn.zzk, new RecaptchaException(recaptchaErrorCode, (String) null, 2, (r) null)), l.a(zzn.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, (String) null, 2, (r) null)), l.a(zzn.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, (String) null, 2, (r) null)), l.a(zzn.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, (String) null, 2, (r) null)), l.a(zzn.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, (String) null, 2, (r) null)), l.a(zzn.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (r) null)));
    }

    public final zzl zza() {
        return this.zzd;
    }

    public final zzn zzb() {
        return this.zzc;
    }

    public final RecaptchaException zzc() {
        if (x.b(this.zzd, zzl.zzT)) {
            return new RecaptchaException(RecaptchaErrorCode.INVALID_TIMEOUT, (String) null, 2, (r) null);
        }
        RecaptchaException recaptchaException = (RecaptchaException) this.zzf.get(this.zzc);
        return recaptchaException == null ? new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (r) null) : recaptchaException;
    }

    public final String zzd() {
        return this.zze;
    }
}
