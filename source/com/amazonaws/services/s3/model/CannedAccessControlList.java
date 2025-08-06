package com.amazonaws.services.s3.model;

public enum CannedAccessControlList {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    AuthenticatedRead("authenticated-read"),
    LogDeliveryWrite("log-delivery-write"),
    BucketOwnerRead("bucket-owner-read"),
    BucketOwnerFullControl("bucket-owner-full-control"),
    AwsExecRead("aws-exec-read");
    
    private final String cannedAclHeader;

    private CannedAccessControlList(String str) {
        this.cannedAclHeader = str;
    }

    public String toString() {
        return this.cannedAclHeader;
    }
}
