package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRequest<T> implements Request<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f14794a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14795b = false;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f14796c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f14797d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public URI f14798e;

    /* renamed from: f  reason: collision with root package name */
    public String f14799f;

    /* renamed from: g  reason: collision with root package name */
    public final AmazonWebServiceRequest f14800g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMethodName f14801h = HttpMethodName.POST;

    /* renamed from: i  reason: collision with root package name */
    public InputStream f14802i;

    /* renamed from: j  reason: collision with root package name */
    public long f14803j;

    /* renamed from: k  reason: collision with root package name */
    public AWSRequestMetrics f14804k;

    /* renamed from: l  reason: collision with root package name */
    public String f14805l;

    /* renamed from: m  reason: collision with root package name */
    public String f14806m;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.f14799f = str;
        this.f14800g = amazonWebServiceRequest;
    }

    public void a(String str, String str2) {
        this.f14797d.put(str, str2);
    }

    public void b(InputStream inputStream) {
        this.f14802i = inputStream;
    }

    @Deprecated
    public AWSRequestMetrics c() {
        return this.f14804k;
    }

    public void d(String str) {
        this.f14794a = str;
    }

    public long e() {
        return this.f14803j;
    }

    @Deprecated
    public void f(AWSRequestMetrics aWSRequestMetrics) {
        if (this.f14804k == null) {
            this.f14804k = aWSRequestMetrics;
            return;
        }
        throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
    }

    public void g(Map<String, String> map) {
        this.f14797d.clear();
        this.f14797d.putAll(map);
    }

    public InputStream getContent() {
        return this.f14802i;
    }

    public Map<String, String> getHeaders() {
        return this.f14797d;
    }

    public Map<String, String> getParameters() {
        return this.f14796c;
    }

    public String h() {
        return this.f14805l;
    }

    public boolean i() {
        return this.f14795b;
    }

    public HttpMethodName j() {
        return this.f14801h;
    }

    public void k(HttpMethodName httpMethodName) {
        this.f14801h = httpMethodName;
    }

    public String l() {
        return this.f14794a;
    }

    public String m() {
        return this.f14806m;
    }

    public String n() {
        return this.f14799f;
    }

    public void o(long j11) {
        this.f14803j = j11;
    }

    public void p(String str, String str2) {
        this.f14796c.put(str, str2);
    }

    public AmazonWebServiceRequest q() {
        return this.f14800g;
    }

    public void r(boolean z11) {
        this.f14795b = z11;
    }

    public void s(Map<String, String> map) {
        this.f14796c.clear();
        this.f14796c.putAll(map);
    }

    public URI t() {
        return this.f14798e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j());
        sb2.append(" ");
        sb2.append(t());
        sb2.append(" ");
        String l11 = l();
        if (l11 == null) {
            sb2.append("/");
        } else {
            if (!l11.startsWith("/")) {
                sb2.append("/");
            }
            sb2.append(l11);
        }
        sb2.append(" ");
        if (!getParameters().isEmpty()) {
            sb2.append("Parameters: (");
            for (String next : getParameters().keySet()) {
                sb2.append(next);
                sb2.append(l.f34627b);
                sb2.append(getParameters().get(next));
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb2.append("Headers: (");
            for (String next2 : getHeaders().keySet()) {
                sb2.append(next2);
                sb2.append(l.f34627b);
                sb2.append(getHeaders().get(next2));
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        return sb2.toString();
    }

    public void u(URI uri) {
        this.f14798e = uri;
    }
}
