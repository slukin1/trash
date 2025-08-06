package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ProvidedContext implements Serializable {
    private String contextAssertion;
    private String providerArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProvidedContext)) {
            return false;
        }
        ProvidedContext providedContext = (ProvidedContext) obj;
        if ((providedContext.getProviderArn() == null) ^ (getProviderArn() == null)) {
            return false;
        }
        if (providedContext.getProviderArn() != null && !providedContext.getProviderArn().equals(getProviderArn())) {
            return false;
        }
        if ((providedContext.getContextAssertion() == null) ^ (getContextAssertion() == null)) {
            return false;
        }
        return providedContext.getContextAssertion() == null || providedContext.getContextAssertion().equals(getContextAssertion());
    }

    public String getContextAssertion() {
        return this.contextAssertion;
    }

    public String getProviderArn() {
        return this.providerArn;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getProviderArn() == null ? 0 : getProviderArn().hashCode()) + 31) * 31;
        if (getContextAssertion() != null) {
            i11 = getContextAssertion().hashCode();
        }
        return hashCode + i11;
    }

    public void setContextAssertion(String str) {
        this.contextAssertion = str;
    }

    public void setProviderArn(String str) {
        this.providerArn = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getProviderArn() != null) {
            sb2.append("ProviderArn: " + getProviderArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getContextAssertion() != null) {
            sb2.append("ContextAssertion: " + getContextAssertion());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ProvidedContext withContextAssertion(String str) {
        this.contextAssertion = str;
        return this;
    }

    public ProvidedContext withProviderArn(String str) {
        this.providerArn = str;
        return this;
    }
}
