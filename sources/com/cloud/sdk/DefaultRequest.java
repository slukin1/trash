package com.cloud.sdk;

import com.cloud.sdk.http.HttpMethodName;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class DefaultRequest<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f64704a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f64705b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f64706c;

    /* renamed from: d  reason: collision with root package name */
    public URI f64707d;

    /* renamed from: e  reason: collision with root package name */
    public final WebServiceRequest f64708e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMethodName f64709f;

    public DefaultRequest(WebServiceRequest webServiceRequest) {
        this.f64705b = new LinkedHashMap();
        this.f64706c = new HashMap();
        this.f64709f = HttpMethodName.POST;
        this.f64708e = webServiceRequest == null ? WebServiceRequest.f64712c : webServiceRequest;
    }

    public URI a() {
        return this.f64707d;
    }

    public Map<String, String> b() {
        return this.f64706c;
    }

    public HttpMethodName c() {
        return this.f64709f;
    }

    public Map<String, String> d() {
        return this.f64705b;
    }

    public String e() {
        return this.f64704a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c());
        sb2.append(" ");
        sb2.append(a());
        sb2.append(" ");
        String e11 = e();
        if (e11 == null) {
            sb2.append("/");
        } else {
            if (!e11.startsWith("/")) {
                sb2.append("/");
            }
            sb2.append(e11);
        }
        sb2.append(" ");
        if (!d().isEmpty()) {
            sb2.append("Parameters: (");
            for (String next : d().keySet()) {
                sb2.append(next);
                sb2.append(l.f34627b);
                sb2.append(d().get(next));
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        if (!b().isEmpty()) {
            sb2.append("Headers: (");
            for (String next2 : b().keySet()) {
                sb2.append(next2);
                sb2.append(l.f34627b);
                sb2.append(b().get(next2));
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        return sb2.toString();
    }

    public DefaultRequest() {
        this((WebServiceRequest) null);
    }
}
