package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class CreateCredentialUnknownException extends CreateCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION = "android.credentials.CreateCredentialException.TYPE_UNKNOWN";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public CreateCredentialUnknownException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialUnknownException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialUnknownException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION, charSequence);
    }
}
