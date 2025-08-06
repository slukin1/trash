package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.S3VersionResult;

public class S3VersionHeaderHandler<T extends S3VersionResult> implements HeaderHandler<T> {
    /* renamed from: b */
    public void a(T t11, HttpResponse httpResponse) {
        t11.setVersionId(httpResponse.c().get("x-amz-version-id"));
    }
}
