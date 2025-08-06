package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetSessionTokenResultStaxUnmarshaller implements Unmarshaller<GetSessionTokenResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public GetSessionTokenResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetSessionTokenResult getSessionTokenResult = new GetSessionTokenResult();
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
                } else if (staxUnmarshallerContext.e("Credentials", i11)) {
                    getSessionTokenResult.setCredentials(CredentialsStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return getSessionTokenResult;
    }
}
