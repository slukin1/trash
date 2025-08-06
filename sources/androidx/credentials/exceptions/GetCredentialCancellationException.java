package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class GetCredentialCancellationException extends GetCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION = "android.credentials.GetCredentialException.TYPE_USER_CANCELED";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public GetCredentialCancellationException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialCancellationException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public GetCredentialCancellationException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION, charSequence);
    }
}
