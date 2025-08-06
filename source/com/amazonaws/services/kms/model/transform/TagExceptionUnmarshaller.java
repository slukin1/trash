package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.TagException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TagExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TagExceptionUnmarshaller() {
        super(TagException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        TagException tagException = (TagException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        tagException.setErrorCode("TagException");
        return tagException;
    }
}
