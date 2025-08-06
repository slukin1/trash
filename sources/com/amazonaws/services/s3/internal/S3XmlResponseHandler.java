package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;

public class S3XmlResponseHandler<T> extends AbstractS3ResponseHandler<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final Log f15187e = LogFactory.c("com.amazonaws.request");

    /* renamed from: c  reason: collision with root package name */
    public Unmarshaller<T, InputStream> f15188c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f15189d;

    public S3XmlResponseHandler(Unmarshaller<T, InputStream> unmarshaller) {
        this.f15188c = unmarshaller;
    }

    /* renamed from: e */
    public AmazonWebServiceResponse<T> b(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> c11 = c(httpResponse);
        this.f15189d = httpResponse.c();
        if (this.f15188c != null) {
            Log log = f15187e;
            log.k("Beginning to parse service response XML");
            T a11 = this.f15188c.a(httpResponse.b());
            log.k("Done parsing service response XML");
            c11.d(a11);
        }
        return c11;
    }
}
