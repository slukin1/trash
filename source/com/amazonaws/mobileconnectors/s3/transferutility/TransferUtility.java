package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.VersionInfoUtils;

public class TransferUtility {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15035a = LogFactory.b(TransferUtility.class);

    /* renamed from: b  reason: collision with root package name */
    public static final Object f15036b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static String f15037c = "";

    public static <X extends AmazonWebServiceRequest> X a(X x11) {
        RequestClientOptions requestClientOptions = x11.getRequestClientOptions();
        requestClientOptions.a("TransferService_multipart/" + c() + VersionInfoUtils.c());
        return x11;
    }

    public static <X extends AmazonWebServiceRequest> X b(X x11) {
        RequestClientOptions requestClientOptions = x11.getRequestClientOptions();
        requestClientOptions.a("TransferService/" + c() + VersionInfoUtils.c());
        return x11;
    }

    public static String c() {
        synchronized (f15036b) {
            String str = f15037c;
            if (str != null) {
                if (!str.trim().isEmpty()) {
                    String str2 = f15037c.trim() + "/";
                    return str2;
                }
            }
            return "";
        }
    }
}
