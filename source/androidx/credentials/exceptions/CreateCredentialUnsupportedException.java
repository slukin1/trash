package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class CreateCredentialUnsupportedException extends CreateCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CREATE_CREDENTIAL_UNSUPPORTED_EXCEPTION = "androidx.credentials.TYPE_CREATE_CREDENTIAL_UNSUPPORTED_EXCEPTION";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public CreateCredentialUnsupportedException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialUnsupportedException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialUnsupportedException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_UNSUPPORTED_EXCEPTION, charSequence);
    }
}
