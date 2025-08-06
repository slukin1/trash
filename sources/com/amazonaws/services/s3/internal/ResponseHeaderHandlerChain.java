package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ResponseHeaderHandlerChain<T> extends S3XmlResponseHandler<T> {

    /* renamed from: f  reason: collision with root package name */
    public final List<HeaderHandler<T>> f15178f;

    public ResponseHeaderHandlerChain(Unmarshaller<T, InputStream> unmarshaller, HeaderHandler<T>... headerHandlerArr) {
        super(unmarshaller);
        this.f15178f = Arrays.asList(headerHandlerArr);
    }

    /* renamed from: e */
    public AmazonWebServiceResponse<T> b(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> e11 = super.b(httpResponse);
        T b11 = e11.b();
        if (b11 != null) {
            for (HeaderHandler<T> a11 : this.f15178f) {
                a11.a(b11, httpResponse);
            }
        }
        return e11;
    }
}
