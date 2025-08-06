package com.jumio.sdk.controller;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.Controller;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import java.util.List;
import kotlin.jvm.internal.r;

public final class JumioController {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Controller f24959a;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioController(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i11, int i12, r rVar) {
        this(context, authorizationModel, jumioControllerInterface, (i12 & 8) != 0 ? 0 : i11);
    }

    public final synchronized void cancel() throws IllegalArgumentException, SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            this.f24959a.cancel();
        } else {
            throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
        }
    }

    public final synchronized void finish() throws IllegalArgumentException, SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            try {
                this.f24959a.finish();
            } catch (Exception e11) {
                throw e11;
            }
        } else {
            throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
        }
    }

    public final Controller getController$jumio_core_release() {
        return this.f24959a;
    }

    public final List<JumioConsentItem> getUnconsentedItems() throws SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            return this.f24959a.getUnconsentedItems();
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public final boolean isComplete() {
        return this.f24959a.isComplete();
    }

    public final void persist(Bundle bundle) {
        if (this.f24959a.isActive$jumio_core_release()) {
            this.f24959a.saveState(bundle);
        }
    }

    public final void retry(JumioError jumioError) throws SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            this.f24959a.retry(jumioError);
            return;
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public final JumioCredential start(JumioCredentialInfo jumioCredentialInfo) throws IllegalArgumentException, SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            return this.f24959a.startCredential(jumioCredentialInfo);
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public final void stop() {
        if (this.f24959a.isActive$jumio_core_release()) {
            this.f24959a.persistAllData(true);
        }
    }

    public final void userConsented(JumioConsentItem jumioConsentItem, boolean z11) throws SDKNotConfiguredException {
        if (this.f24959a.isActive$jumio_core_release()) {
            this.f24959a.userConsented(jumioConsentItem, z11);
            return;
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public JumioController(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i11) {
        this.f24959a = new Controller(context, authorizationModel, jumioControllerInterface, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioController(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, int i11, r rVar) {
        this(context, bundle, jumioControllerInterface, (i11 & 8) != 0 ? null : jumioScanPartInterface);
    }

    public JumioController(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface) {
        this.f24959a = new Controller(context, bundle, jumioControllerInterface, jumioScanPartInterface);
    }
}
