package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public interface Request<T> {
    void a(String str, String str2);

    void b(InputStream inputStream);

    AWSRequestMetrics c();

    @Deprecated
    void d(String str);

    long e();

    void f(AWSRequestMetrics aWSRequestMetrics);

    void g(Map<String, String> map);

    InputStream getContent();

    Map<String, String> getHeaders();

    Map<String, String> getParameters();

    String h();

    boolean i();

    HttpMethodName j();

    void k(HttpMethodName httpMethodName);

    @Deprecated
    String l();

    String m();

    String n();

    void o(long j11);

    void p(String str, String str2);

    AmazonWebServiceRequest q();

    void r(boolean z11);

    void s(Map<String, String> map);

    URI t();

    void u(URI uri);
}
