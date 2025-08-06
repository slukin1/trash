package okhttp3;

import d10.a;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.internal.Lambda;

public final class Handshake$Companion$get$1 extends Lambda implements a<List<? extends Certificate>> {
    public final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Handshake$Companion$get$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
