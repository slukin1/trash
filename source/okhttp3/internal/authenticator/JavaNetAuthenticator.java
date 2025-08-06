package okhttp3.internal.authenticator;

import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.HBOkHttpDNS;
import com.huobi.woodpecker.aop.WoodPeckerHttpDNSFailRetryAspect;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.r;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;

public final class JavaNetAuthenticator implements Authenticator {
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private final Dns defaultDns;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return ((Dns) objArr2[1]).lookup((String) objArr2[2]);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ajc$preClinit();
    }

    public JavaNetAuthenticator() {
        this((Dns) null, 1, (r) null);
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("JavaNetAuthenticator.kt", JavaNetAuthenticator.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("401", "lookup", "okhttp3.Dns", "java.lang.String", "arg0", "java.net.UnknownHostException", "java.util.List"), 90);
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) != 1) {
            return ((InetSocketAddress) proxy.address()).getAddress();
        }
        String host = httpUrl.host();
        JoinPoint c11 = c.c(ajc$tjp_0, this, dns, host);
        return (InetAddress) CollectionsKt___CollectionsKt.a0(dns instanceof HBOkHttpDNS ? WoodPeckerHttpDNSFailRetryAspect.d().e(new AjcClosure1(new Object[]{this, dns, host, c11}).linkClosureAndJoinPoint(4112)) : dns.lookup(host));
    }

    public Request authenticate(Route route, Response response) throws IOException {
        Proxy proxy;
        Dns dns;
        PasswordAuthentication passwordAuthentication;
        Address address;
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        boolean z11 = response.code() == 407;
        if (route == null || (proxy = route.proxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge next : challenges) {
            if (StringsKt__StringsJVMKt.w(OAuthConstants.AUTHORIZATION_BASIC, next.scheme(), true)) {
                if (route == null || (address = route.address()) == null || (dns = address.dns()) == null) {
                    dns = this.defaultDns;
                }
                if (z11) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), connectToInetAddress(proxy, url, dns), inetSocketAddress.getPort(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                } else {
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(url.host(), connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    return request.newBuilder().header(z11 ? HttpHeaders.PROXY_AUTHORIZATION : "Authorization", Credentials.basic(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), next.charset())).build();
                }
            }
        }
        return null;
    }

    public JavaNetAuthenticator(Dns dns) {
        this.defaultDns = dns;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i11, r rVar) {
        this((i11 & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
