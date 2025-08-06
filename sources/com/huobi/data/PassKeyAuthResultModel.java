package com.huobi.data;

import androidx.annotation.Keep;

@Keep
public final class PassKeyAuthResultModel {
    private final String client_data;
    private final String credential_id;
    private final String raw_authenticator_data;
    private final String signature;
    private final String user_handle;

    public PassKeyAuthResultModel(String str, String str2, String str3, String str4, String str5) {
        this.raw_authenticator_data = str;
        this.signature = str2;
        this.credential_id = str3;
        this.client_data = str4;
        this.user_handle = str5;
    }

    public final String getClient_data() {
        return this.client_data;
    }

    public final String getCredential_id() {
        return this.credential_id;
    }

    public final String getRaw_authenticator_data() {
        return this.raw_authenticator_data;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getUser_handle() {
        return this.user_handle;
    }
}
