package okhttp3.internal.connection;

import d10.a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;

public final class RealConnection$connectTls$2 extends Lambda implements a<List<? extends X509Certificate>> {
    public final /* synthetic */ RealConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.this$0 = realConnection;
    }

    public final List<X509Certificate> invoke() {
        List<Certificate> peerCertificates = this.this$0.handshake.peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
