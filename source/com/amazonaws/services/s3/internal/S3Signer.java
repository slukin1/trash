package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.HttpUtils;
import com.google.common.net.HttpHeaders;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class S3Signer extends AbstractAWSSigner {

    /* renamed from: d  reason: collision with root package name */
    public static final Log f15183d = LogFactory.b(S3Signer.class);

    /* renamed from: a  reason: collision with root package name */
    public final String f15184a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15185b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f15186c;

    public S3Signer() {
        this.f15184a = null;
        this.f15185b = null;
        this.f15186c = null;
    }

    public void a(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        if (this.f15185b == null) {
            throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
        } else if (aWSCredentials == null || aWSCredentials.b() == null) {
            f15183d.h("Canonical string will not be signed, as no AWS Secret Key was provided");
        } else {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            String b11 = HttpUtils.b(request.t().getPath(), this.f15185b, true);
            Date signatureDate = getSignatureDate(getTimeOffset(request));
            if (date == null) {
                date = signatureDate;
            }
            request.a(HttpHeaders.DATE, ServiceUtils.a(date));
            String a11 = RestUtils.a(this.f15184a, b11, request, (String) null, this.f15186c);
            Log log = f15183d;
            log.h("Calculated string to sign:\n\"" + a11 + "\"");
            String signAndBase64Encode = super.signAndBase64Encode(a11, sanitizeCredentials.b(), SigningAlgorithm.HmacSHA1);
            request.a("Authorization", "AWS " + sanitizeCredentials.a() + ":" + signAndBase64Encode);
        }
    }

    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.a("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        a(request, aWSCredentials, (Date) null);
    }

    public S3Signer(String str, String str2) {
        this(str, str2, (Collection<String>) null);
    }

    public S3Signer(String str, String str2, Collection<String> collection) {
        Set<String> set;
        if (str2 != null) {
            this.f15184a = str;
            this.f15185b = str2;
            if (collection == null) {
                set = null;
            } else {
                set = Collections.unmodifiableSet(new HashSet(collection));
            }
            this.f15186c = set;
            return;
        }
        throw new IllegalArgumentException("Parameter resourcePath is empty");
    }
}
