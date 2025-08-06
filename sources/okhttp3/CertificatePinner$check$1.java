package okhttp3;

import d10.a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class CertificatePinner$check$1 extends Lambda implements a<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List<Certificate> $peerCertificates;
    public final /* synthetic */ CertificatePinner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CertificatePinner$check$1(CertificatePinner certificatePinner, List<? extends Certificate> list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    public final List<X509Certificate> invoke() {
        List<Certificate> list;
        CertificateChainCleaner certificateChainCleaner$okhttp = this.this$0.getCertificateChainCleaner$okhttp();
        if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname)) == null) {
            list = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (Certificate certificate : list) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
