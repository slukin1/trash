package okhttp3.internal.platform;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

public final class BouncyCastlePlatform extends Platform {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final Provider provider;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final BouncyCastlePlatform buildIfSupported() {
            if (isSupported()) {
                return new BouncyCastlePlatform((r) null);
            }
            return null;
        }

        public final boolean isSupported() {
            return BouncyCastlePlatform.isSupported;
        }
    }

    static {
        Companion companion = new Companion((r) null);
        Companion = companion;
        boolean z11 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, companion.getClass().getClassLoader());
            z11 = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z11;
    }

    private BouncyCastlePlatform() {
        this.provider = new BouncyCastleJsseProvider();
    }

    public /* synthetic */ BouncyCastlePlatform(r rVar) {
        this();
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean z11;
        if (!(sSLSocket instanceof BCSSLSocket)) {
            return super.getSelectedProtocol(sSLSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null) {
            z11 = true;
        } else {
            z11 = x.b(applicationProtocol, "");
        }
        if (z11) {
            return null;
        }
        return applicationProtocol;
    }

    public SSLContext newSSLContext() {
        return SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL, this.provider);
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        boolean z11 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z11 = false;
        }
        if (z11) {
            return (X509TrustManager) trustManagers[0];
        }
        throw new IllegalStateException(("Unexpected default trust managers: " + Arrays.toString(trustManagers)).toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}
