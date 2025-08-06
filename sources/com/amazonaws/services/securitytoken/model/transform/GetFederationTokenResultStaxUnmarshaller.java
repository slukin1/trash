package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetFederationTokenResultStaxUnmarshaller implements Unmarshaller<GetFederationTokenResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public GetFederationTokenResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetFederationTokenResult getFederationTokenResult = new GetFederationTokenResult();
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
                    getFederationTokenResult.setCredentials(CredentialsStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("FederatedUser", i11)) {
                    getFederationTokenResult.setFederatedUser(FederatedUserStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("PackedPolicySize", i11)) {
                    getFederationTokenResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return getFederationTokenResult;
    }
}
