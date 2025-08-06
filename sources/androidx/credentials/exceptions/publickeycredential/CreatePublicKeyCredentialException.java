package androidx.credentials.exceptions.publickeycredential;

import androidx.credentials.exceptions.CreateCredentialException;
import kotlin.jvm.internal.r;

public class CreatePublicKeyCredentialException extends CreateCredentialException {
    private final String type;

    public CreatePublicKeyCredentialException(String str) {
        this(str, (CharSequence) null, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreatePublicKeyCredentialException(String str, CharSequence charSequence, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : charSequence);
    }

    public String getType() {
        return this.type;
    }

    public CreatePublicKeyCredentialException(String str, CharSequence charSequence) {
        super(str, charSequence);
        this.type = str;
        if (!(getType().length() > 0)) {
            throw new IllegalArgumentException("type must not be empty".toString());
        }
    }
}
