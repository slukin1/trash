package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

public class PredefinedRetryPolicies {

    /* renamed from: a  reason: collision with root package name */
    public static final RetryPolicy f15070a = new RetryPolicy(RetryPolicy.RetryCondition.f15083a, RetryPolicy.BackoffStrategy.f15082a, 0, false);

    /* renamed from: b  reason: collision with root package name */
    public static final RetryPolicy f15071b = a();

    /* renamed from: c  reason: collision with root package name */
    public static final RetryPolicy f15072c = b();

    /* renamed from: d  reason: collision with root package name */
    public static final RetryPolicy.RetryCondition f15073d = new SDKDefaultRetryCondition();

    /* renamed from: e  reason: collision with root package name */
    public static final RetryPolicy.BackoffStrategy f15074e = new SDKDefaultBackoffStrategy(100, 20000);

    public static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {

        /* renamed from: b  reason: collision with root package name */
        public final Random f15075b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15076c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15077d;

        public final long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if (i11 <= 0) {
                return 0;
            }
            return (long) this.f15075b.nextInt(Math.min(this.f15077d, (1 << i11) * this.f15076c));
        }

        public SDKDefaultBackoffStrategy(int i11, int i12) {
            this.f15075b = new Random();
            this.f15076c = i11;
            this.f15077d = i12;
        }
    }

    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (!(amazonClientException instanceof AmazonServiceException)) {
                return false;
            }
            AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
            int statusCode = amazonServiceException.getStatusCode();
            if (statusCode == 500 || statusCode == 503 || statusCode == 502 || statusCode == 504 || RetryUtils.c(amazonServiceException) || RetryUtils.a(amazonServiceException)) {
                return true;
            }
            return false;
        }
    }

    public static RetryPolicy a() {
        return new RetryPolicy(f15073d, f15074e, 3, true);
    }

    public static RetryPolicy b() {
        return new RetryPolicy(f15073d, f15074e, 10, true);
    }
}
