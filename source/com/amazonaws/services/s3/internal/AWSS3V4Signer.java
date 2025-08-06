package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AwsChunkedEncodingInputStream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.BinaryUtils;
import java.io.IOException;
import java.io.InputStream;

public class AWSS3V4Signer extends AWS4Signer {
    public AWSS3V4Signer() {
        super(false);
    }

    public static long a(Request<?> request) throws IOException {
        InputStream content = request.getContent();
        if (content.markSupported()) {
            long j11 = 0;
            byte[] bArr = new byte[4096];
            content.mark(-1);
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    j11 += (long) read;
                } else {
                    content.reset();
                    return j11;
                }
            }
        } else {
            throw new AmazonClientException("Failed to get content length");
        }
    }

    public static boolean b(Request<?> request) {
        return (request.q() instanceof PutObjectRequest) || (request.q() instanceof UploadPartRequest);
    }

    public String calculateContentHash(Request<?> request) {
        long j11;
        request.a("x-amz-content-sha256", "required");
        if (!b(request)) {
            return super.calculateContentHash(request);
        }
        String str = request.getHeaders().get("Content-Length");
        if (str != null) {
            j11 = Long.parseLong(str);
        } else {
            try {
                j11 = a(request);
            } catch (IOException e11) {
                throw new AmazonClientException("Cannot get the content-lenght of the request content.", e11);
            }
        }
        request.a("x-amz-decoded-content-length", Long.toString(j11));
        request.a("Content-Length", Long.toString(AwsChunkedEncodingInputStream.j(j11)));
        return "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
    }

    public String calculateContentHashPresign(Request<?> request) {
        return "UNSIGNED-PAYLOAD";
    }

    public void processRequestPayload(Request<?> request, AWS4Signer.HeaderSigningResult headerSigningResult) {
        if (b(request)) {
            request.b(new AwsChunkedEncodingInputStream(request.getContent(), headerSigningResult.b(), headerSigningResult.a(), headerSigningResult.c(), BinaryUtils.a(headerSigningResult.d()), this));
        }
    }
}
