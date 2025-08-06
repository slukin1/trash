package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AssumeRoleResultStaxUnmarshaller implements Unmarshaller<AssumeRoleResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public AssumeRoleResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumeRoleResult assumeRoleResult = new AssumeRoleResult();
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
                    assumeRoleResult.setCredentials(CredentialsStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("AssumedRoleUser", i11)) {
                    assumeRoleResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("PackedPolicySize", i11)) {
                    assumeRoleResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SourceIdentity", i11)) {
                    assumeRoleResult.setSourceIdentity(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return assumeRoleResult;
    }
}
