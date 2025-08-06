package okhttp3;

import com.adjust.sdk.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.x;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String str, int i11, Dns dns2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator, Proxy proxy2, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        this.dns = dns2;
        this.socketFactory = socketFactory2;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier2;
        this.certificatePinner = certificatePinner2;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy2;
        this.proxySelector = proxySelector2;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? Constants.SCHEME : "http").host(str).port(i11).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m3085deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m3086deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m3087deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m3088deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m3089deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m3090deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m3091deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m3092deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m3093deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m3094deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m3095deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return x.b(this.url, address.url) && equalsNonHost$okhttp(address);
        }
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        return x.b(this.dns, address.dns) && x.b(this.proxyAuthenticator, address.proxyAuthenticator) && x.b(this.protocols, address.protocols) && x.b(this.connectionSpecs, address.connectionSpecs) && x.b(this.proxySelector, address.proxySelector) && x.b(this.proxy, address.proxy) && x.b(this.sslSocketFactory, address.sslSocketFactory) && x.b(this.hostnameVerifier, address.hostnameVerifier) && x.b(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.host());
        sb3.append(':');
        sb3.append(this.url.port());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append('}');
        return sb3.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }
}
