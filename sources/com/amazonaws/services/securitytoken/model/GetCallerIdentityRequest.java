package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetCallerIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCallerIdentityRequest)) {
            return false;
        }
        GetCallerIdentityRequest getCallerIdentityRequest = (GetCallerIdentityRequest) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "{" + "}";
    }
}
