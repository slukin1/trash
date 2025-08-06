package com.jumio.core.interfaces;

import android.net.Uri;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import jumio.core.r0;

public interface DigitalIdScanPartInterface extends r0 {
    /* synthetic */ void cancel();

    /* synthetic */ boolean consume(Uri uri);

    /* synthetic */ void fallback(JumioFallbackReason jumioFallbackReason);

    /* synthetic */ void finish();

    /* synthetic */ String getBaseUrl();

    /* synthetic */ void getHelpAnimation(JumioAnimationView jumioAnimationView);

    /* synthetic */ String getHtml();

    /* synthetic */ void retry(JumioRetryReason jumioRetryReason);

    /* synthetic */ void setBaseUrl(String str);

    /* synthetic */ void setHtml(String str);

    /* synthetic */ void start();

    void thirdPartyVerificationStarted();
}
