package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListNextBatchOfVersionsRequest extends AmazonWebServiceRequest implements Serializable {
    private VersionListing previousVersionListing;

    public ListNextBatchOfVersionsRequest(VersionListing versionListing) {
        setPreviousVersionListing(versionListing);
    }

    public VersionListing getPreviousVersionListing() {
        return this.previousVersionListing;
    }

    public void setPreviousVersionListing(VersionListing versionListing) {
        if (versionListing != null) {
            this.previousVersionListing = versionListing;
            return;
        }
        throw new IllegalArgumentException("The parameter previousVersionListing must be specified.");
    }

    public ListVersionsRequest toListVersionsRequest() {
        return new ListVersionsRequest(this.previousVersionListing.a(), this.previousVersionListing.h(), this.previousVersionListing.f(), this.previousVersionListing.g(), this.previousVersionListing.c(), Integer.valueOf(this.previousVersionListing.e())).g(this.previousVersionListing.d());
    }

    public ListNextBatchOfVersionsRequest withPreviousVersionListing(VersionListing versionListing) {
        setPreviousVersionListing(versionListing);
        return this;
    }
}
