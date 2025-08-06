package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.FederatedUser;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

class FederatedUserStaxUnmarshaller implements Unmarshaller<FederatedUser, StaxUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static FederatedUserStaxUnmarshaller f15505a;

    public static FederatedUserStaxUnmarshaller b() {
        if (f15505a == null) {
            f15505a = new FederatedUserStaxUnmarshaller();
        }
        return f15505a;
    }

    /* renamed from: c */
    public FederatedUser a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        FederatedUser federatedUser = new FederatedUser();
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
                } else if (staxUnmarshallerContext.e("FederatedUserId", i11)) {
                    federatedUser.setFederatedUserId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Arn", i11)) {
                    federatedUser.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return federatedUser;
    }
}
