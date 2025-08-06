package com.sumsub.sns.core;

import android.content.Intent;
import com.google.android.gms.security.ProviderInstaller;
import com.sumsub.sns.internal.log.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$SDK$1$1", "Lcom/google/android/gms/security/ProviderInstaller$ProviderInstallListener;", "onProviderInstallFailed", "", "errorCode", "", "resolveIntent", "Landroid/content/Intent;", "onProviderInstalled", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSMobileSDK$SDK$1$1 implements ProviderInstaller.ProviderInstallListener {
    public void onProviderInstallFailed(int i11, Intent intent) {
        a aVar = a.f34862a;
        com.sumsub.log.logger.a.a(aVar, b.f30747a, "onProviderInstallFailed: " + i11, (Throwable) null, 4, (Object) null);
    }

    public void onProviderInstalled() {
        com.sumsub.log.logger.a.a(a.f34862a, b.f30747a, "onProviderInstalled", (Throwable) null, 4, (Object) null);
    }
}
