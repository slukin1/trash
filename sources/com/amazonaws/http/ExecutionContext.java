package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

public class ExecutionContext {

    /* renamed from: a  reason: collision with root package name */
    public final AWSRequestMetrics f14879a;

    /* renamed from: b  reason: collision with root package name */
    public final List<RequestHandler2> f14880b;

    /* renamed from: c  reason: collision with root package name */
    public String f14881c;

    /* renamed from: d  reason: collision with root package name */
    public final AmazonWebServiceClient f14882d;

    /* renamed from: e  reason: collision with root package name */
    public AWSCredentials f14883e;

    public ExecutionContext() {
        this((List<RequestHandler2>) null, false, (AmazonWebServiceClient) null);
    }

    @Deprecated
    public AWSRequestMetrics a() {
        return this.f14879a;
    }

    public String b() {
        return this.f14881c;
    }

    public AWSCredentials c() {
        return this.f14883e;
    }

    public List<RequestHandler2> d() {
        return this.f14880b;
    }

    public Signer e(URI uri) {
        AmazonWebServiceClient amazonWebServiceClient = this.f14882d;
        if (amazonWebServiceClient == null) {
            return null;
        }
        return amazonWebServiceClient.q(uri);
    }

    public void f(AWSCredentials aWSCredentials) {
        this.f14883e = aWSCredentials;
    }

    public void g(Signer signer) {
    }

    public ExecutionContext(List<RequestHandler2> list, boolean z11, AmazonWebServiceClient amazonWebServiceClient) {
        this.f14880b = list;
        this.f14879a = z11 ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.f14882d = amazonWebServiceClient;
    }
}
