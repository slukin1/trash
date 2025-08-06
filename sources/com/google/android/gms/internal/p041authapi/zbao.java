package com.google.android.gms.internal.p041authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api.zbao  reason: invalid package */
public final class zbao extends GoogleApi implements CredentialSavingClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd = zbbb.zba();

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbal zbal = new zbal();
        zbb = zbal;
        zbc = new Api("Auth.Api.Identity.CredentialSaving.API", zbal, clientKey);
    }

    public zbao(Activity activity, zbc zbc2) {
        super(activity, zbc, zbc2, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.RESULT_INTERNAL_ERROR;
        }
        Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
        return status == null ? Status.RESULT_INTERNAL_ERROR : status;
    }

    public final Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.checkNotNull(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.Builder zba2 = SaveAccountLinkingTokenRequest.zba(saveAccountLinkingTokenRequest);
        zba2.zba(this.zbd);
        SaveAccountLinkingTokenRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbg).run(new zbaj(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1535).build());
    }

    public final Task<SavePasswordResult> savePassword(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        SavePasswordRequest.Builder zba2 = SavePasswordRequest.zba(savePasswordRequest);
        zba2.zba(this.zbd);
        SavePasswordRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbe).run(new zbak(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1536).build());
    }

    public zbao(Context context, zbc zbc2) {
        super(context, zbc, zbc2, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
