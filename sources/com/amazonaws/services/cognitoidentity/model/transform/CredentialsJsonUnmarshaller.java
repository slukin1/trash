package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.Credentials;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class CredentialsJsonUnmarshaller implements Unmarshaller<Credentials, JsonUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static CredentialsJsonUnmarshaller f15087a;

    public static CredentialsJsonUnmarshaller b() {
        if (f15087a == null) {
            f15087a = new CredentialsJsonUnmarshaller();
        }
        return f15087a;
    }

    /* renamed from: c */
    public Credentials a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader a11 = jsonUnmarshallerContext.a();
        if (!a11.a()) {
            a11.d();
            return null;
        }
        Credentials credentials = new Credentials();
        a11.f();
        while (a11.hasNext()) {
            String e11 = a11.e();
            if (e11.equals("AccessKeyId")) {
                credentials.setAccessKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("SecretKey")) {
                credentials.setSecretKey(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("SessionToken")) {
                credentials.setSessionToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else if (e11.equals("Expiration")) {
                credentials.setExpiration(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.b().a(jsonUnmarshallerContext));
            } else {
                a11.d();
            }
        }
        a11.h();
        return credentials;
    }
}
