package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class GetCredentialInterruptedException extends GetCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION = "android.credentials.GetCredentialException.TYPE_INTERRUPTED";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public GetCredentialInterruptedException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialInterruptedException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public GetCredentialInterruptedException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION, charSequence);
    }
}
