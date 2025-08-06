package com.jumio.sdk.scanpart;

import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import java.io.Serializable;

public final class JumioScanPart implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final ScanPart<?> f25014a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25015b = true;

    public JumioScanPart(ScanPart<?> scanPart) {
        this.f25014a = scanPart;
    }

    public final void cancel() throws SDKNotConfiguredException {
        if (!this.f25015b) {
            throw new SDKNotConfiguredException("This part can not be used anymore".toString());
        } else if (this.f25014a.isCancelable()) {
            this.f25014a.cancel();
            this.f25014a.getCredential().finishScanPart$jumio_core_release(this);
            this.f25015b = false;
        } else {
            throw new SDKNotConfiguredException("This part is not cancelable at the moment".toString());
        }
    }

    public final void fallback() throws SDKNotConfiguredException {
        if (this.f25015b) {
            this.f25014a.fallback(JumioFallbackReason.USER_ACTION);
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final void finish() throws SDKNotConfiguredException {
        if (!this.f25015b) {
            throw new SDKNotConfiguredException("This part can not be used anymore".toString());
        } else if (this.f25014a.isComplete()) {
            this.f25014a.finish();
            this.f25014a.getCredential().finishScanPart$jumio_core_release(this);
            this.f25015b = false;
        } else {
            throw new IllegalArgumentException("This part is not yet finished".toString());
        }
    }

    public final boolean getHasFallback() {
        return this.f25014a.getHasFallback();
    }

    public final void getHelpAnimation(JumioAnimationView jumioAnimationView) throws SDKNotConfiguredException {
        if (this.f25015b) {
            this.f25014a.getHelpAnimation(jumioAnimationView);
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final JumioScanMode getScanMode() {
        return this.f25014a.getScanMode();
    }

    public final ScanPart<?> getScanPart$jumio_core_release() {
        return this.f25014a;
    }

    public final void retry(JumioRetryReason jumioRetryReason) throws SDKNotConfiguredException {
        if (this.f25015b) {
            this.f25014a.retry(jumioRetryReason);
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final void start() throws SDKNotConfiguredException {
        if (this.f25015b) {
            this.f25014a.start();
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }
}
