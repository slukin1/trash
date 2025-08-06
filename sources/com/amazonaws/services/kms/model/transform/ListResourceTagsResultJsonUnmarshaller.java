package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListResourceTagsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListResourceTagsResultJsonUnmarshaller implements Unmarshaller<ListResourceTagsResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListResourceTagsResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListResourceTagsResult listResourceTagsResult = new ListResourceTagsResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("Tags")) {
                listResourceTagsResult.setTags(new ListUnmarshaller(TagJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("NextMarker")) {
                listResourceTagsResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Truncated")) {
                listResourceTagsResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listResourceTagsResult;
    }
}
