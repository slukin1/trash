package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    public final /* synthetic */ String $packageName;

    public AndroidSocketAdapter$Companion$factory$1(String str) {
        this.$packageName = str;
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        return AndroidSocketAdapter.Companion.build(sSLSocket.getClass());
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        String name = sSLSocket.getClass().getName();
        return StringsKt__StringsJVMKt.M(name, this.$packageName + '.', false, 2, (Object) null);
    }
}
