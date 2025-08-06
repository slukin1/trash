package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class S3TokenBean implements Serializable {
    private String bucketName;
    private S3Credentials credentials;
    private String domain;
    private int maxUploadFileSize;
    private String path;
    private String regionName;
    private int uploadChannel;

    public String getBucketName() {
        return this.bucketName;
    }

    public S3Credentials getCredentials() {
        return this.credentials;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getMaxUploadFileSize() {
        return this.maxUploadFileSize;
    }

    public String getPath() {
        return this.path;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public int getUploadChannel() {
        return this.uploadChannel;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCredentials(S3Credentials s3Credentials) {
        this.credentials = s3Credentials;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setMaxUploadFileSize(int i11) {
        this.maxUploadFileSize = i11;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setUploadChannel(int i11) {
        this.uploadChannel = i11;
    }
}
