package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class CreateCredentialInterruptedException extends CreateCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION = "android.credentials.CreateCredentialException.TYPE_INTERRUPTED";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public CreateCredentialInterruptedException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialInterruptedException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialInterruptedException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION, charSequence);
    }
}
