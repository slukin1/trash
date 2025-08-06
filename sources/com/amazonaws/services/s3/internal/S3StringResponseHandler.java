package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;

public class S3StringResponseHandler extends AbstractS3ResponseHandler<String> {
    /* renamed from: e */
    public AmazonWebServiceResponse<String> b(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<String> c11 = c(httpResponse);
        byte[] bArr = new byte[1024];
        StringBuilder sb2 = new StringBuilder();
        InputStream b11 = httpResponse.b();
        while (true) {
            int read = b11.read(bArr);
            if (read > 0) {
                sb2.append(new String(bArr, 0, read, StringUtils.f15560a));
            } else {
                c11.d(sb2.toString());
                return c11;
            }
        }
    }
}
