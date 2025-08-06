package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeleteIdentitiesResultJsonUnmarshaller implements Unmarshaller<DeleteIdentitiesResult, JsonUnmarshallerContext> {
    /* renamed from: b */
    public DeleteIdentitiesResult a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteIdentitiesResult deleteIdentitiesResult = new DeleteIdentitiesResult();
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        a11.f();
        while (a11.hasNext()) {
            if (a11.e().equals("UnprocessedIdentityIds")) {
                deleteIdentitiesResult.setUnprocessedIdentityIds(new ListUnmarshaller(UnprocessedIdentityIdJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return deleteIdentitiesResult;
    }
}
