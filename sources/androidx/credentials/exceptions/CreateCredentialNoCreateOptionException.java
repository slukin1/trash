package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class CreateCredentialNoCreateOptionException extends CreateCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CREATE_CREDENTIAL_NO_CREATE_OPTION = "android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public CreateCredentialNoCreateOptionException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialNoCreateOptionException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialNoCreateOptionException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_NO_CREATE_OPTION, charSequence);
    }
}
