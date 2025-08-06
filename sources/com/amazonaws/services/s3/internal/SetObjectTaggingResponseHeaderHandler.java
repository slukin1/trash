package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;

public class SetObjectTaggingResponseHeaderHandler implements HeaderHandler<SetObjectTaggingResult> {
    /* renamed from: b */
    public void a(SetObjectTaggingResult setObjectTaggingResult, HttpResponse httpResponse) {
        setObjectTaggingResult.a(httpResponse.c().get("x-amz-version-id"));
    }
}
