package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class CreateCredentialProviderConfigurationException extends CreateCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION = "androidx.credentials.TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public CreateCredentialProviderConfigurationException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialProviderConfigurationException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialProviderConfigurationException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION, charSequence);
    }
}
