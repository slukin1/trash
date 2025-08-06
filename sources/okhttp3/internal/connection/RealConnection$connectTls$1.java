package okhttp3.internal.connection;

import d10.a;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;

public final class RealConnection$connectTls$1 extends Lambda implements a<List<? extends Certificate>> {
    public final /* synthetic */ Address $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake;
        this.$address = address;
    }

    public final List<Certificate> invoke() {
        return this.$certificatePinner.getCertificateChainCleaner$okhttp().clean(this.$unverifiedHandshake.peerCertificates(), this.$address.url().host());
    }
}
