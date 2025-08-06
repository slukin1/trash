package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class ClearCredentialUnsupportedException extends ClearCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_CLEAR_CREDENTIAL_UNSUPPORTED_EXCEPTION = "androidx.credentials.TYPE_CLEAR_CREDENTIAL_UNSUPPORTED_EXCEPTION";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public ClearCredentialUnsupportedException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCredentialUnsupportedException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public ClearCredentialUnsupportedException(CharSequence charSequence) {
        super(TYPE_CLEAR_CREDENTIAL_UNSUPPORTED_EXCEPTION, charSequence);
    }
}
