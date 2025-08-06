package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Protocol;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final DeferredSocketAdapter.Factory factory = new BouncyCastleSocketAdapter$Companion$factory$1();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DeferredSocketAdapter.Factory getFactory() {
            return BouncyCastleSocketAdapter.factory;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        if (matchesSocket(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            parameters.setApplicationProtocols((String[]) Platform.Companion.alpnProtocolNames(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean z11;
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

    public boolean isSupported() {
        return BouncyCastlePlatform.Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        return sSLSocket instanceof BCSSLSocket;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
