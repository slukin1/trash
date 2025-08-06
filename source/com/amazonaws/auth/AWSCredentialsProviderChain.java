package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.LinkedList;
import java.util.List;

public class AWSCredentialsProviderChain implements AWSCredentialsProvider {

    /* renamed from: d  reason: collision with root package name */
    public static final Log f14818d = LogFactory.b(AWSCredentialsProviderChain.class);

    /* renamed from: a  reason: collision with root package name */
    public List<AWSCredentialsProvider> f14819a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f14820b = true;

    /* renamed from: c  reason: collision with root package name */
    public AWSCredentialsProvider f14821c;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider add : aWSCredentialsProviderArr) {
            this.f14819a.add(add);
        }
    }

    public AWSCredentials a() {
        AWSCredentialsProvider aWSCredentialsProvider;
        if (this.f14820b && (aWSCredentialsProvider = this.f14821c) != null) {
            return aWSCredentialsProvider.a();
        }
        for (AWSCredentialsProvider next : this.f14819a) {
            try {
                AWSCredentials a11 = next.a();
                if (!(a11.a() == null || a11.b() == null)) {
                    Log log = f14818d;
                    log.h("Loading credentials from " + next.toString());
                    this.f14821c = next;
                    return a11;
                }
            } catch (Exception e11) {
                Log log2 = f14818d;
                log2.h("Unable to load credentials from " + next.toString() + l.f34627b + e11.getMessage());
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }
}
