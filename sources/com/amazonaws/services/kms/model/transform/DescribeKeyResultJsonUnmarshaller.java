package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DescribeKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeKeyResultJsonUnmarshaller implements Unmarshaller<DescribeKeyResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public DescribeKeyResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeKeyResult describeKeyResult = new DescribeKeyResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("KeyMetadata")) {
                describeKeyResult.setKeyMetadata(KeyMetadataJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return describeKeyResult;
    }
}
