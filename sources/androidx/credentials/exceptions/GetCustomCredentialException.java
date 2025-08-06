package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class GetCustomCredentialException extends GetCredentialException {
    private final String type;

    public GetCustomCredentialException(String str) {
        this(str, (CharSequence) null, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCustomCredentialException(String str, CharSequence charSequence, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : charSequence);
    }

    public String getType() {
        return this.type;
    }

    public GetCustomCredentialException(String str, CharSequence charSequence) {
        super(str, charSequence);
        this.type = str;
        if (!(getType().length() > 0)) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
