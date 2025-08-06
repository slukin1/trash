package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListTagsForResourceResultJsonUnmarshaller implements Unmarshaller<ListTagsForResourceResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public ListTagsForResourceResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListTagsForResourceResult listTagsForResourceResult = new ListTagsForResourceResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("Tags")) {
                listTagsForResourceResult.setTags(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return listTagsForResourceResult;
    }
}
