package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzao extends zzgx {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    public zzao(zzgd zzgd) {
        super(zzgd);
    }

    public final long zza() {
        zzg();
        return this.zze;
    }

    public final long zzb() {
        zzv();
        return this.zza;
    }

    public final String zzc() {
        zzv();
        return this.zzb;
    }

    public final void zzd() {
        zzg();
        this.zzd = null;
        this.zze = 0;
    }

    public final boolean zze() {
        zzg();
        long currentTimeMillis = this.zzt.zzax().currentTimeMillis();
        if (currentTimeMillis - this.zze > Period.DAY_MILLS) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.zzt.zzaw(), "android.permission.GET_ACCOUNTS") != 0) {
            this.zzt.zzaA().zzm().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(this.zzt.zzaw());
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zzd = Boolean.TRUE;
                    this.zze = currentTimeMillis;
                    return true;
                }
                this.zze = currentTimeMillis;
                this.zzd = Boolean.FALSE;
                return false;
            }
            this.zzd = Boolean.TRUE;
            this.zze = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e11) {
            this.zzt.zzaA().zzh().zzb("Exception checking account types", e11);
        }
    }

    public final boolean zzf() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.zzb = lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + lowerCase2;
        return false;
    }
}
