package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumedRoleUser;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

class AssumedRoleUserStaxUnmarshaller implements Unmarshaller<AssumedRoleUser, StaxUnmarshallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public static AssumedRoleUserStaxUnmarshaller f15503a;

    public static AssumedRoleUserStaxUnmarshaller b() {
        if (f15503a == null) {
            f15503a = new AssumedRoleUserStaxUnmarshaller();
        }
        return f15503a;
    }

    /* renamed from: c */
    public AssumedRoleUser a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumedRoleUser assumedRoleUser = new AssumedRoleUser();
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
                } else if (staxUnmarshallerContext.e("AssumedRoleId", i11)) {
                    assumedRoleUser.setAssumedRoleId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Arn", i11)) {
                    assumedRoleUser.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return assumedRoleUser;
    }
}
