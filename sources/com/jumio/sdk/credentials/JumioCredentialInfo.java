package com.jumio.sdk.credentials;

import java.io.Serializable;

public final class JumioCredentialInfo implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final JumioCredentialCategory f24966a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24967b;

    public JumioCredentialInfo(JumioCredentialCategory jumioCredentialCategory, String str) {
        this.f24966a = jumioCredentialCategory;
        this.f24967b = str;
    }

    public final JumioCredentialCategory getCategory() {
        return this.f24966a;
    }

    public final String getId() {
        return this.f24967b;
    }
}
