package androidx.credentials.exceptions.publickeycredential;

import kotlin.jvm.internal.r;

public final class GetPublicKeyCredentialDomException extends GetPublicKeyCredentialException {
    public static final a Companion = new a((r) null);
    public static final String TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private final e1.a domError;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public GetPublicKeyCredentialDomException(e1.a aVar) {
        this(aVar, (CharSequence) null, 2, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPublicKeyCredentialDomException(e1.a aVar, CharSequence charSequence, int i11, r rVar) {
        this(aVar, (i11 & 2) != 0 ? null : charSequence);
    }

    public final e1.a getDomError() {
        return this.domError;
    }

    public GetPublicKeyCredentialDomException(e1.a aVar, CharSequence charSequence) {
        super(TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION + aVar.a(), charSequence);
        this.domError = aVar;
    }
}
