package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.HttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AmazonWebServiceClient {

    /* renamed from: k  reason: collision with root package name */
    public static final Log f14759k = LogFactory.b(AmazonWebServiceClient.class);

    /* renamed from: a  reason: collision with root package name */
    public volatile URI f14760a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f14761b;

    /* renamed from: c  reason: collision with root package name */
    public ClientConfiguration f14762c;

    /* renamed from: d  reason: collision with root package name */
    public AmazonHttpClient f14763d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RequestHandler2> f14764e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public long f14765f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Signer f14766g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f14767h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f14768i;

    /* renamed from: j  reason: collision with root package name */
    public volatile Region f14769j;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f14762c = clientConfiguration;
        this.f14763d = new AmazonHttpClient(clientConfiguration, httpClient);
    }

    @Deprecated
    public static boolean s() {
        return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
    }

    public void g(RequestHandler2 requestHandler2) {
        this.f14764e.add(requestHandler2);
    }

    public final String h() {
        int i11;
        String simpleName = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
        String serviceName = ServiceNameFactory.getServiceName(simpleName);
        if (serviceName != null) {
            return serviceName;
        }
        int indexOf = simpleName.indexOf("JavaClient");
        if (indexOf == -1 && (indexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int indexOf2 = simpleName.indexOf("Amazon");
        if (indexOf2 == -1) {
            indexOf2 = simpleName.indexOf("AWS");
            if (indexOf2 != -1) {
                i11 = 3;
            } else {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
        } else {
            i11 = 6;
        }
        if (indexOf2 < indexOf) {
            return StringUtils.b(simpleName.substring(indexOf2 + i11, indexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
    }

    public final Signer i(String str, String str2, String str3, boolean z11) {
        Signer signer;
        String e11 = this.f14762c.e();
        if (e11 == null) {
            signer = SignerFactory.b(str, str2);
        } else {
            signer = SignerFactory.c(e11, str);
        }
        if (signer instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) signer;
            if (str3 != null) {
                regionAwareSigner.setRegionName(str3);
            } else if (str2 != null && z11) {
                regionAwareSigner.setRegionName(str2);
            }
        }
        synchronized (this) {
            this.f14769j = Region.f(str2);
        }
        return signer;
    }

    public final Signer j(URI uri, String str, boolean z11) {
        if (uri != null) {
            String p11 = p();
            return i(p11, AwsHostNameUtils.a(uri.getHost(), p11), str, z11);
        }
        throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
    }

    @Deprecated
    public final void k(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        l(aWSRequestMetrics, request, response, false);
    }

    @Deprecated
    public final void l(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z11) {
        if (request != null) {
            aWSRequestMetrics.b(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.c().c();
            m(request).a(request, response);
        }
        if (z11) {
            aWSRequestMetrics.e();
        }
    }

    @Deprecated
    public final RequestMetricCollector m(Request<?> request) {
        RequestMetricCollector requestMetricCollector = request.q().getRequestMetricCollector();
        if (requestMetricCollector != null) {
            return requestMetricCollector;
        }
        RequestMetricCollector o11 = o();
        return o11 == null ? AwsSdkMetrics.getRequestMetricCollector() : o11;
    }

    public String n() {
        return this.f14768i;
    }

    @Deprecated
    public RequestMetricCollector o() {
        return this.f14763d.f();
    }

    public String p() {
        if (this.f14767h == null) {
            synchronized (this) {
                if (this.f14767h == null) {
                    this.f14767h = h();
                    String str = this.f14767h;
                    return str;
                }
            }
        }
        return this.f14767h;
    }

    public Signer q(URI uri) {
        return j(uri, this.f14761b, true);
    }

    public final String r() {
        return this.f14761b;
    }

    @Deprecated
    public final boolean t() {
        RequestMetricCollector v11 = v();
        return v11 != null && v11.b();
    }

    @Deprecated
    public final boolean u(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector requestMetricCollector = amazonWebServiceRequest.getRequestMetricCollector();
        if (requestMetricCollector == null || !requestMetricCollector.b()) {
            return t();
        }
        return true;
    }

    @Deprecated
    public RequestMetricCollector v() {
        RequestMetricCollector f11 = this.f14763d.f();
        return f11 == null ? AwsSdkMetrics.getRequestMetricCollector() : f11;
    }

    public void w(String str) {
        URI y11 = y(str);
        Signer j11 = j(y11, this.f14761b, false);
        synchronized (this) {
            this.f14760a = y11;
            this.f14766g = j11;
        }
    }

    public void x(Region region) {
        String str;
        if (region != null) {
            String p11 = p();
            if (region.i(p11)) {
                str = region.g(p11);
                int indexOf = str.indexOf("://");
                if (indexOf >= 0) {
                    str = str.substring(indexOf + 3);
                }
            } else {
                str = String.format("%s.%s.%s", new Object[]{n(), region.d(), region.a()});
            }
            URI y11 = y(str);
            Signer i11 = i(p11, region.d(), this.f14761b, false);
            synchronized (this) {
                this.f14760a = y11;
                this.f14766g = i11;
            }
            return;
        }
        throw new IllegalArgumentException("No region provided");
    }

    public final URI y(String str) {
        if (!str.contains("://")) {
            str = this.f14762c.c().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
