package com.amazonaws.services.s3.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.DateUtils;
import java.util.Date;
import java.util.List;

public class ServiceUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15190a = LogFactory.b(ServiceUtils.class);
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final DateUtils f15191b = new DateUtils();

    public static String a(Date date) {
        return DateUtils.d(date);
    }

    public static String b(List<String> list) {
        String str = "";
        boolean z11 = true;
        for (String next : list) {
            if (!z11) {
                str = str + ", ";
            }
            str = str + next;
            z11 = false;
        }
        return str;
    }

    public static Date c(String str) {
        return DateUtils.h(str);
    }

    public static Date d(String str) {
        return DateUtils.i(str);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(com.amazonaws.AmazonWebServiceRequest r2, com.amazonaws.services.s3.S3ClientOptions r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L_0x000a
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r3 = "com.amazonaws.services.s3.disableGetObjectMD5Validation"
            java.lang.String r3 = java.lang.System.getProperty(r3)
            if (r3 == 0) goto L_0x0013
            return r0
        L_0x0013:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.GetObjectRequest
            r1 = 0
            if (r3 == 0) goto L_0x0028
            com.amazonaws.services.s3.model.GetObjectRequest r2 = (com.amazonaws.services.s3.model.GetObjectRequest) r2
            long[] r3 = r2.getRange()
            if (r3 == 0) goto L_0x0021
            return r0
        L_0x0021:
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r2.getSSECustomerKey()
            if (r2 == 0) goto L_0x006c
            return r0
        L_0x0028:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.PutObjectRequest
            if (r3 == 0) goto L_0x005d
            com.amazonaws.services.s3.model.PutObjectRequest r2 = (com.amazonaws.services.s3.model.PutObjectRequest) r2
            com.amazonaws.services.s3.model.ObjectMetadata r3 = r2.getMetadata()
            if (r3 == 0) goto L_0x003b
            java.lang.String r3 = r3.getSSEAlgorithm()
            if (r3 == 0) goto L_0x003b
            return r0
        L_0x003b:
            com.amazonaws.services.s3.model.SSECustomerKey r3 = r2.getSSECustomerKey()
            if (r3 == 0) goto L_0x0042
            return r0
        L_0x0042:
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r3 = r2.getSSEAwsKeyManagementParams()
            if (r3 == 0) goto L_0x006c
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r3 = r2.getSSEAwsKeyManagementParams()
            java.lang.String r3 = r3.getEncryption()
            if (r3 != 0) goto L_0x005c
            com.amazonaws.services.s3.model.SSEAwsKeyManagementParams r2 = r2.getSSEAwsKeyManagementParams()
            java.lang.String r2 = r2.getAwsKmsKeyId()
            if (r2 == 0) goto L_0x006c
        L_0x005c:
            return r0
        L_0x005d:
            boolean r3 = r2 instanceof com.amazonaws.services.s3.model.UploadPartRequest
            if (r3 == 0) goto L_0x006c
            com.amazonaws.services.s3.model.UploadPartRequest r2 = (com.amazonaws.services.s3.model.UploadPartRequest) r2
            com.amazonaws.services.s3.model.SSECustomerKey r2 = r2.getSSECustomerKey()
            if (r2 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r0 = r1
        L_0x006b:
            return r0
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.ServiceUtils.f(com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.s3.S3ClientOptions):boolean");
    }
}
