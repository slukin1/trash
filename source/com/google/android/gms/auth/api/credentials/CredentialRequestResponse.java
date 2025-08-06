package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

@Deprecated
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    public Credential getCredential() {
        return ((CredentialRequestResult) getResult()).getCredential();
    }
}
