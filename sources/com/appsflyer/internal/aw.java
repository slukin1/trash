package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class aw<T> {
    public final FutureTask<T> AFInAppEventParameterName = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (aw.this.values()) {
                return aw.this.AFKeystoreWrapper();
            }
            return null;
        }
    });
    private final String[] AFKeystoreWrapper;
    public final String valueOf;
    public final Context values;

    public aw(Context context, String str, String... strArr) {
        this.values = context;
        this.valueOf = str;
        this.AFKeystoreWrapper = strArr;
    }

    public T AFInAppEventType() {
        try {
            return this.AFInAppEventParameterName.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            AFLogger.AFInAppEventType(e11.getMessage(), e11);
            return null;
        }
    }

    public abstract T AFKeystoreWrapper();

    public final boolean values() {
        try {
            ProviderInfo resolveContentProvider = this.values.getPackageManager().resolveContentProvider(this.valueOf, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.AFKeystoreWrapper).contains(aa.values(this.values.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e11) {
            AFLogger.AFInAppEventType(e11.getMessage(), e11);
            return false;
        }
    }
}
