package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AssumeRoleWithWebIdentityResultStaxUnmarshaller implements Unmarshaller<AssumeRoleWithWebIdentityResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public AssumeRoleWithWebIdentityResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentityResult = new AssumeRoleWithWebIdentityResult();
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
                    assumeRoleWithWebIdentityResult.setCredentials(CredentialsStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SubjectFromWebIdentityToken", i11)) {
                    assumeRoleWithWebIdentityResult.setSubjectFromWebIdentityToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("AssumedRoleUser", i11)) {
                    assumeRoleWithWebIdentityResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("PackedPolicySize", i11)) {
                    assumeRoleWithWebIdentityResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Provider", i11)) {
                    assumeRoleWithWebIdentityResult.setProvider(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Audience", i11)) {
                    assumeRoleWithWebIdentityResult.setAudience(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SourceIdentity", i11)) {
                    assumeRoleWithWebIdentityResult.setSourceIdentity(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return assumeRoleWithWebIdentityResult;
    }
}
