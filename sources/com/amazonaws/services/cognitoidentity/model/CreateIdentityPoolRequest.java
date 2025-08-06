package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateIdentityPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean allowClassicFlow;
    private Boolean allowUnauthenticatedIdentities;
    private List<CognitoIdentityProvider> cognitoIdentityProviders;
    private String developerProviderName;
    private String identityPoolName;
    private Map<String, String> identityPoolTags;
    private List<String> openIdConnectProviderARNs;
    private List<String> samlProviderARNs;
    private Map<String, String> supportedLoginProviders;

    public CreateIdentityPoolRequest addIdentityPoolTagsEntry(String str, String str2) {
        if (this.identityPoolTags == null) {
            this.identityPoolTags = new HashMap();
        }
        if (!this.identityPoolTags.containsKey(str)) {
            this.identityPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityPoolRequest addSupportedLoginProvidersEntry(String str, String str2) {
        if (this.supportedLoginProviders == null) {
            this.supportedLoginProviders = new HashMap();
        }
        if (!this.supportedLoginProviders.containsKey(str)) {
            this.supportedLoginProviders.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityPoolRequest clearIdentityPoolTagsEntries() {
        this.identityPoolTags = null;
        return this;
    }

    public CreateIdentityPoolRequest clearSupportedLoginProvidersEntries() {
        this.supportedLoginProviders = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateIdentityPoolRequest)) {
            return false;
        }
        CreateIdentityPoolRequest createIdentityPoolRequest = (CreateIdentityPoolRequest) obj;
        if ((createIdentityPoolRequest.getIdentityPoolName() == null) ^ (getIdentityPoolName() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getIdentityPoolName() != null && !createIdentityPoolRequest.getIdentityPoolName().equals(getIdentityPoolName())) {
            return false;
        }
        if ((createIdentityPoolRequest.getAllowUnauthenticatedIdentities() == null) ^ (getAllowUnauthenticatedIdentities() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowUnauthenticatedIdentities() != null && !createIdentityPoolRequest.getAllowUnauthenticatedIdentities().equals(getAllowUnauthenticatedIdentities())) {
            return false;
        }
        if ((createIdentityPoolRequest.getAllowClassicFlow() == null) ^ (getAllowClassicFlow() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getAllowClassicFlow() != null && !createIdentityPoolRequest.getAllowClassicFlow().equals(getAllowClassicFlow())) {
            return false;
        }
        if ((createIdentityPoolRequest.getSupportedLoginProviders() == null) ^ (getSupportedLoginProviders() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getSupportedLoginProviders() != null && !createIdentityPoolRequest.getSupportedLoginProviders().equals(getSupportedLoginProviders())) {
            return false;
        }
        if ((createIdentityPoolRequest.getDeveloperProviderName() == null) ^ (getDeveloperProviderName() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getDeveloperProviderName() != null && !createIdentityPoolRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if ((createIdentityPoolRequest.getOpenIdConnectProviderARNs() == null) ^ (getOpenIdConnectProviderARNs() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getOpenIdConnectProviderARNs() != null && !createIdentityPoolRequest.getOpenIdConnectProviderARNs().equals(getOpenIdConnectProviderARNs())) {
            return false;
        }
        if ((createIdentityPoolRequest.getCognitoIdentityProviders() == null) ^ (getCognitoIdentityProviders() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getCognitoIdentityProviders() != null && !createIdentityPoolRequest.getCognitoIdentityProviders().equals(getCognitoIdentityProviders())) {
            return false;
        }
        if ((createIdentityPoolRequest.getSamlProviderARNs() == null) ^ (getSamlProviderARNs() == null)) {
            return false;
        }
        if (createIdentityPoolRequest.getSamlProviderARNs() != null && !createIdentityPoolRequest.getSamlProviderARNs().equals(getSamlProviderARNs())) {
            return false;
        }
        if ((createIdentityPoolRequest.getIdentityPoolTags() == null) ^ (getIdentityPoolTags() == null)) {
            return false;
        }
        return createIdentityPoolRequest.getIdentityPoolTags() == null || createIdentityPoolRequest.getIdentityPoolTags().equals(getIdentityPoolTags());
    }

    public Boolean getAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public Boolean getAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public List<CognitoIdentityProvider> getCognitoIdentityProviders() {
        return this.cognitoIdentityProviders;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public String getIdentityPoolName() {
        return this.identityPoolName;
    }

    public Map<String, String> getIdentityPoolTags() {
        return this.identityPoolTags;
    }

    public List<String> getOpenIdConnectProviderARNs() {
        return this.openIdConnectProviderARNs;
    }

    public List<String> getSamlProviderARNs() {
        return this.samlProviderARNs;
    }

    public Map<String, String> getSupportedLoginProviders() {
        return this.supportedLoginProviders;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int hashCode = ((getIdentityPoolName() == null ? 0 : getIdentityPoolName().hashCode()) + 31) * 31;
        if (getAllowUnauthenticatedIdentities() == null) {
            i11 = 0;
        } else {
            i11 = getAllowUnauthenticatedIdentities().hashCode();
        }
        int hashCode2 = (((hashCode + i11) * 31) + (getAllowClassicFlow() == null ? 0 : getAllowClassicFlow().hashCode())) * 31;
        if (getSupportedLoginProviders() == null) {
            i12 = 0;
        } else {
            i12 = getSupportedLoginProviders().hashCode();
        }
        int hashCode3 = (((hashCode2 + i12) * 31) + (getDeveloperProviderName() == null ? 0 : getDeveloperProviderName().hashCode())) * 31;
        if (getOpenIdConnectProviderARNs() == null) {
            i13 = 0;
        } else {
            i13 = getOpenIdConnectProviderARNs().hashCode();
        }
        int i16 = (hashCode3 + i13) * 31;
        if (getCognitoIdentityProviders() == null) {
            i14 = 0;
        } else {
            i14 = getCognitoIdentityProviders().hashCode();
        }
        int hashCode4 = (((i16 + i14) * 31) + (getSamlProviderARNs() == null ? 0 : getSamlProviderARNs().hashCode())) * 31;
        if (getIdentityPoolTags() != null) {
            i15 = getIdentityPoolTags().hashCode();
        }
        return hashCode4 + i15;
    }

    public Boolean isAllowClassicFlow() {
        return this.allowClassicFlow;
    }

    public Boolean isAllowUnauthenticatedIdentities() {
        return this.allowUnauthenticatedIdentities;
    }

    public void setAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
    }

    public void setAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
    }

    public void setCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        if (collection == null) {
            this.cognitoIdentityProviders = null;
        } else {
            this.cognitoIdentityProviders = new ArrayList(collection);
        }
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public void setIdentityPoolName(String str) {
        this.identityPoolName = str;
    }

    public void setIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
    }

    public void setOpenIdConnectProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.openIdConnectProviderARNs = null;
        } else {
            this.openIdConnectProviderARNs = new ArrayList(collection);
        }
    }

    public void setSamlProviderARNs(Collection<String> collection) {
        if (collection == null) {
            this.samlProviderARNs = null;
        } else {
            this.samlProviderARNs = new ArrayList(collection);
        }
    }

    public void setSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolName() != null) {
            sb2.append("IdentityPoolName: " + getIdentityPoolName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAllowUnauthenticatedIdentities() != null) {
            sb2.append("AllowUnauthenticatedIdentities: " + getAllowUnauthenticatedIdentities() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAllowClassicFlow() != null) {
            sb2.append("AllowClassicFlow: " + getAllowClassicFlow() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSupportedLoginProviders() != null) {
            sb2.append("SupportedLoginProviders: " + getSupportedLoginProviders() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeveloperProviderName() != null) {
            sb2.append("DeveloperProviderName: " + getDeveloperProviderName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOpenIdConnectProviderARNs() != null) {
            sb2.append("OpenIdConnectProviderARNs: " + getOpenIdConnectProviderARNs() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCognitoIdentityProviders() != null) {
            sb2.append("CognitoIdentityProviders: " + getCognitoIdentityProviders() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSamlProviderARNs() != null) {
            sb2.append("SamlProviderARNs: " + getSamlProviderARNs() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityPoolTags() != null) {
            sb2.append("IdentityPoolTags: " + getIdentityPoolTags());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CreateIdentityPoolRequest withAllowClassicFlow(Boolean bool) {
        this.allowClassicFlow = bool;
        return this;
    }

    public CreateIdentityPoolRequest withAllowUnauthenticatedIdentities(Boolean bool) {
        this.allowUnauthenticatedIdentities = bool;
        return this;
    }

    public CreateIdentityPoolRequest withCognitoIdentityProviders(CognitoIdentityProvider... cognitoIdentityProviderArr) {
        if (getCognitoIdentityProviders() == null) {
            this.cognitoIdentityProviders = new ArrayList(cognitoIdentityProviderArr.length);
        }
        for (CognitoIdentityProvider add : cognitoIdentityProviderArr) {
            this.cognitoIdentityProviders.add(add);
        }
        return this;
    }

    public CreateIdentityPoolRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public CreateIdentityPoolRequest withIdentityPoolName(String str) {
        this.identityPoolName = str;
        return this;
    }

    public CreateIdentityPoolRequest withIdentityPoolTags(Map<String, String> map) {
        this.identityPoolTags = map;
        return this;
    }

    public CreateIdentityPoolRequest withOpenIdConnectProviderARNs(String... strArr) {
        if (getOpenIdConnectProviderARNs() == null) {
            this.openIdConnectProviderARNs = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.openIdConnectProviderARNs.add(add);
        }
        return this;
    }

    public CreateIdentityPoolRequest withSamlProviderARNs(String... strArr) {
        if (getSamlProviderARNs() == null) {
            this.samlProviderARNs = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.samlProviderARNs.add(add);
        }
        return this;
    }

    public CreateIdentityPoolRequest withSupportedLoginProviders(Map<String, String> map) {
        this.supportedLoginProviders = map;
        return this;
    }

    public CreateIdentityPoolRequest withCognitoIdentityProviders(Collection<CognitoIdentityProvider> collection) {
        setCognitoIdentityProviders(collection);
        return this;
    }

    public CreateIdentityPoolRequest withOpenIdConnectProviderARNs(Collection<String> collection) {
        setOpenIdConnectProviderARNs(collection);
        return this;
    }

    public CreateIdentityPoolRequest withSamlProviderARNs(Collection<String> collection) {
        setSamlProviderARNs(collection);
        return this;
    }
}
