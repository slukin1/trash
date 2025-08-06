package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public final class ClearCustomCredentialException extends ClearCredentialException {
    private final String type;

    public ClearCustomCredentialException(String str) {
        this(str, (CharSequence) null, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCustomCredentialException(String str, CharSequence charSequence, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : charSequence);
    }

    public String getType() {
        return this.type;
    }

    public ClearCustomCredentialException(String str, CharSequence charSequence) {
        super(str, charSequence);
        this.type = str;
        if (!(getType().length() > 0)) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
