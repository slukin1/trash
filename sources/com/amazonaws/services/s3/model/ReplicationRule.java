package com.amazonaws.services.s3.model;

public class ReplicationRule {

    /* renamed from: a  reason: collision with root package name */
    public String f15314a;

    /* renamed from: b  reason: collision with root package name */
    public String f15315b;

    /* renamed from: c  reason: collision with root package name */
    public ReplicationDestinationConfig f15316c;

    public void a(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig != null) {
            this.f15316c = replicationDestinationConfig;
            return;
        }
        throw new IllegalArgumentException("Destination cannot be null in the replication rule");
    }

    public void b(String str) {
        if (str != null) {
            this.f15314a = str;
            return;
        }
        throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
    }

    public void c(String str) {
        this.f15315b = str;
    }
}
