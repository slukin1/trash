package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.conscrypt.Conscrypt;

public final class ConscryptSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    public SocketAdapter create(SSLSocket sSLSocket) {
        return new ConscryptSocketAdapter();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        return ConscryptPlatform.Companion.isSupported() && Conscrypt.isConscrypt(sSLSocket);
    }
}
