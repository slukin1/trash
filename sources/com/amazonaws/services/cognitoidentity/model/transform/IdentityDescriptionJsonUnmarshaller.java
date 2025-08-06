package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.IdentityDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class IdentityDescriptionJsonUnmarshaller implements Unmarshaller<IdentityDescription, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static IdentityDescriptionJsonUnmarshaller f15088a;

    public static IdentityDescriptionJsonUnmarshaller b() {
        if (f15088a == null) {
            f15088a = new IdentityDescriptionJsonUnmarshaller();
        }
        return f15088a;
    }

    /* renamed from: c */
    public IdentityDescription a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        IdentityDescription identityDescription = new IdentityDescription();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("IdentityId")) {
                identityDescription.setIdentityId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Logins")) {
                identityDescription.setLogins(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b()).a(jsonUnmarshallerContext));
            } else if (e11.equals("CreationDate")) {
                identityDescription.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("LastModifiedDate")) {
                identityDescription.setLastModifiedDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return identityDescription;
    }
}
