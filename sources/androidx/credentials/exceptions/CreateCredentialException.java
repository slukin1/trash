package androidx.credentials.exceptions;

import kotlin.jvm.internal.r;

public abstract class CreateCredentialException extends Exception {
    private final CharSequence errorMessage;
    private final String type;

    public CreateCredentialException(String str) {
        this(str, (CharSequence) null, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialException(String str, CharSequence charSequence, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : charSequence);
    }

    public CharSequence getErrorMessage() {
        return this.errorMessage;
    }

    public String getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateCredentialException(String str, CharSequence charSequence) {
        super(charSequence != null ? charSequence.toString() : null);
        this.type = str;
        this.errorMessage = charSequence;
    }
}
