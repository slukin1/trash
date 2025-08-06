package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListGrantsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListGrantsResultJsonUnmarshaller implements Unmarshaller<ListGrantsResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListGrantsResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListGrantsResult listGrantsResult = new ListGrantsResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Grants")) {
                listGrantsResult.setGrants(new ListUnmarshaller(GrantListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listGrantsResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listGrantsResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listGrantsResult;
    }
}
