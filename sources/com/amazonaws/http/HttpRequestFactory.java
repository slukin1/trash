package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestFactory {
    public final void a(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI t11 = request.t();
        String host = t11.getHost();
        if (HttpUtils.e(t11)) {
            host = host + ":" + t11.getPort();
        }
        map.put("Host", host);
        for (Map.Entry next : request.getHeaders().entrySet()) {
            map.put(next.getKey(), next.getValue());
        }
        if (map.get("Content-Type") == null || map.get("Content-Type").isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + StringUtils.b("UTF-8"));
        }
        if (executionContext != null && executionContext.b() != null) {
            map.put("User-Agent", c(clientConfiguration, executionContext.b()));
        }
    }

    public HttpRequest b(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        String str;
        URI t11 = request.t();
        boolean z11 = true;
        if (request.m() != null) {
            str = HttpUtils.c(t11.toString(), request.m());
        } else {
            str = HttpUtils.b(t11.toString(), request.l(), true);
        }
        String d11 = HttpUtils.d(request);
        HttpMethodName j11 = request.j();
        boolean z12 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if ((j11 == httpMethodName) && !z12) {
            z11 = false;
        }
        if (d11 != null && z11) {
            str = str + "?" + d11;
        }
        HashMap hashMap = new HashMap();
        a(hashMap, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (j11 == httpMethodName2) {
            hashMap.put("X-HTTP-Method-Override", httpMethodName2.toString());
            j11 = httpMethodName;
        }
        if (j11 == httpMethodName && request.getContent() == null && d11 != null) {
            byte[] bytes = d11.getBytes(StringUtils.f15560a);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            hashMap.put("Content-Length", String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (!clientConfiguration.k() || hashMap.get(HttpHeaders.ACCEPT_ENCODING) != null) {
            hashMap.put(HttpHeaders.ACCEPT_ENCODING, "identity");
        } else {
            hashMap.put(HttpHeaders.ACCEPT_ENCODING, DecompressionHelper.GZIP_ENCODING);
        }
        HttpRequest httpRequest = new HttpRequest(j11.toString(), URI.create(str), hashMap, content);
        httpRequest.g(request.i());
        return httpRequest;
    }

    public final String c(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.h().contains(str)) {
            return clientConfiguration.h();
        }
        return clientConfiguration.h() + " " + str;
    }
}
