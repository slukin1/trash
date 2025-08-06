package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AssumeRoleWithSAMLResultStaxUnmarshaller implements Unmarshaller<AssumeRoleWithSAMLResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public AssumeRoleWithSAMLResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = new AssumeRoleWithSAMLResult();
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
                    assumeRoleWithSAMLResult.setCredentials(CredentialsStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("AssumedRoleUser", i11)) {
                    assumeRoleWithSAMLResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("PackedPolicySize", i11)) {
                    assumeRoleWithSAMLResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Subject", i11)) {
                    assumeRoleWithSAMLResult.setSubject(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SubjectType", i11)) {
                    assumeRoleWithSAMLResult.setSubjectType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Issuer", i11)) {
                    assumeRoleWithSAMLResult.setIssuer(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("Audience", i11)) {
                    assumeRoleWithSAMLResult.setAudience(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("NameQualifier", i11)) {
                    assumeRoleWithSAMLResult.setNameQualifier(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.e("SourceIdentity", i11)) {
                    assumeRoleWithSAMLResult.setSourceIdentity(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return assumeRoleWithSAMLResult;
    }
}
