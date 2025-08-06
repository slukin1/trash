package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

class CredentialsStaxUnmarshaller implements Unmarshaller<Credentials, StaxUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static CredentialsStaxUnmarshaller f15504a;

    public static CredentialsStaxUnmarshaller b() {
        if (f15504a == null) {
            f15504a = new CredentialsStaxUnmarshaller();
        }
        return f15504a;
    }

    /* renamed from: c */
    public Credentials a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Credentials credentials = new Credentials();
        int a11 = staxUnmarshallerContext.a();
        int i11 = a11 + 1;
        if (staxUnmarshallerContext.b()) {
            i11 += 2;
        }
        while (true) {
            int c11 = staxUnmarshallerContext.c();
            if (c11 != 1) {
                if (c11 != 2) {
                    if (c11 == 3 && staxUnmarshallerContext.a() < a11) {
                        break;
                    }
                } else if (staxUnmarshallerContext.e("AccessKeyId", i11)) {
                    credentials.setAccessKeyId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SecretAccessKey", i11)) {
                    credentials.setSecretAccessKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SessionToken", i11)) {
                    credentials.setSessionToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Expiration", i11)) {
                    credentials.setExpiration(SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return credentials;
    }
}
