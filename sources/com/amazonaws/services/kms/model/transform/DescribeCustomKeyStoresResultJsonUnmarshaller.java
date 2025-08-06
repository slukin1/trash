package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeCustomKeyStoresResultJsonUnmarshaller implements Unmarshaller<DescribeCustomKeyStoresResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public DescribeCustomKeyStoresResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = new DescribeCustomKeyStoresResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("CustomKeyStores")) {
                describeCustomKeyStoresResult.setCustomKeyStores(new ListUnmarshaller(CustomKeyStoresListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                describeCustomKeyStoresResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                describeCustomKeyStoresResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return describeCustomKeyStoresResult;
    }
}
