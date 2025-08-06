package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class NoCredentialException extends GetCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL = "android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public NoCredentialException() {
        this((CharSequence) null, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoCredentialException(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public NoCredentialException(CharSequence charSequence) {
        super(TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL, charSequence);
    }
}
