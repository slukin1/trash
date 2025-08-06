package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

public final class RetryPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final RetryCondition f15078a;

    /* renamed from: b  reason: collision with root package name */
    public final BackoffStrategy f15079b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15080c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f15081d;

    public interface BackoffStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final BackoffStrategy f15082a = new BackoffStrategy() {
            public long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return 0;
            }
        };

        long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    public interface RetryCondition {

        /* renamed from: a  reason: collision with root package name */
        public static final RetryCondition f15083a = new RetryCondition() {
            public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return false;
            }
        };

        boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int i11, boolean z11) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.f15073d : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.f15074e : backoffStrategy;
        if (i11 >= 0) {
            this.f15078a = retryCondition;
            this.f15079b = backoffStrategy;
            this.f15080c = i11;
            this.f15081d = z11;
            return;
        }
        throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
    }

    public BackoffStrategy a() {
        return this.f15079b;
    }

    public int b() {
        return this.f15080c;
    }

    public RetryCondition c() {
        return this.f15078a;
    }

    public boolean d() {
        return this.f15081d;
    }
}
