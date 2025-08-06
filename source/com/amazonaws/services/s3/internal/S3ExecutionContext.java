package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.ExecutionContext;
import java.net.URI;
import java.util.List;

public class S3ExecutionContext extends ExecutionContext {

    /* renamed from: f  reason: collision with root package name */
    public Signer f15181f;

    public S3ExecutionContext(List<RequestHandler2> list, boolean z11, AmazonWebServiceClient amazonWebServiceClient) {
        super(list, z11, amazonWebServiceClient);
    }

    public Signer e(URI uri) {
        return this.f15181f;
    }

    public void g(Signer signer) {
        this.f15181f = signer;
    }
}
