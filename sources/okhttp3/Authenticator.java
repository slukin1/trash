package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.r;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

public interface Authenticator {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator((Dns) null, 1, (r) null);
    public static final Authenticator NONE = new Companion.AuthenticatorNone();

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class AuthenticatorNone implements Authenticator {
            public Request authenticate(Route route, Response response) {
                return null;
            }
        }

        private Companion() {
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
