package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListRetirableGrantsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListRetirableGrantsResultJsonUnmarshaller implements Unmarshaller<ListRetirableGrantsResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListRetirableGrantsResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListRetirableGrantsResult listRetirableGrantsResult = new ListRetirableGrantsResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Grants")) {
                listRetirableGrantsResult.setGrants(new ListUnmarshaller(GrantListEntryJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listRetirableGrantsResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listRetirableGrantsResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listRetirableGrantsResult;
    }
}
