package com.huobi.domain.data.source.remote.bean.config;

import java.io.Serializable;

public class SmartRemoteDefaultConfig implements Serializable {
    private static final long serialVersionUID = 1530460115322045916L;
    private String contractDefault;
    private String contractH5Default;
    private String dmIndexDefault;
    private String globalMobileDefault;
    private String globalWebDefault;
    private String institutionDefault;
    private String kycWebDefault;
    private String otcDefault;
    private String spotDefault;
    private String swapDefault;
    private String swapH5Default;

    public boolean canEqual(Object obj) {
        return obj instanceof SmartRemoteDefaultConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmartRemoteDefaultConfig)) {
            return false;
        }
        SmartRemoteDefaultConfig smartRemoteDefaultConfig = (SmartRemoteDefaultConfig) obj;
        if (!smartRemoteDefaultConfig.canEqual(this)) {
            return false;
        }
        String spotDefault2 = getSpotDefault();
        String spotDefault3 = smartRemoteDefaultConfig.getSpotDefault();
        if (spotDefault2 != null ? !spotDefault2.equals(spotDefault3) : spotDefault3 != null) {
            return false;
        }
        String otcDefault2 = getOtcDefault();
        String otcDefault3 = smartRemoteDefaultConfig.getOtcDefault();
        if (otcDefault2 != null ? !otcDefault2.equals(otcDefault3) : otcDefault3 != null) {
            return false;
        }
        String contractDefault2 = getContractDefault();
        String contractDefault3 = smartRemoteDefaultConfig.getContractDefault();
        if (contractDefault2 != null ? !contractDefault2.equals(contractDefault3) : contractDefault3 != null) {
            return false;
        }
        String globalWebDefault2 = getGlobalWebDefault();
        String globalWebDefault3 = smartRemoteDefaultConfig.getGlobalWebDefault();
        if (globalWebDefault2 != null ? !globalWebDefault2.equals(globalWebDefault3) : globalWebDefault3 != null) {
            return false;
        }
        String globalMobileDefault2 = getGlobalMobileDefault();
        String globalMobileDefault3 = smartRemoteDefaultConfig.getGlobalMobileDefault();
        if (globalMobileDefault2 != null ? !globalMobileDefault2.equals(globalMobileDefault3) : globalMobileDefault3 != null) {
            return false;
        }
        String swapDefault2 = getSwapDefault();
        String swapDefault3 = smartRemoteDefaultConfig.getSwapDefault();
        if (swapDefault2 != null ? !swapDefault2.equals(swapDefault3) : swapDefault3 != null) {
            return false;
        }
        String dmIndexDefault2 = getDmIndexDefault();
        String dmIndexDefault3 = smartRemoteDefaultConfig.getDmIndexDefault();
        if (dmIndexDefault2 != null ? !dmIndexDefault2.equals(dmIndexDefault3) : dmIndexDefault3 != null) {
            return false;
        }
        String swapH5Default2 = getSwapH5Default();
        String swapH5Default3 = smartRemoteDefaultConfig.getSwapH5Default();
        if (swapH5Default2 != null ? !swapH5Default2.equals(swapH5Default3) : swapH5Default3 != null) {
            return false;
        }
        String contractH5Default2 = getContractH5Default();
        String contractH5Default3 = smartRemoteDefaultConfig.getContractH5Default();
        if (contractH5Default2 != null ? !contractH5Default2.equals(contractH5Default3) : contractH5Default3 != null) {
            return false;
        }
        String institutionDefault2 = getInstitutionDefault();
        String institutionDefault3 = smartRemoteDefaultConfig.getInstitutionDefault();
        if (institutionDefault2 != null ? !institutionDefault2.equals(institutionDefault3) : institutionDefault3 != null) {
            return false;
        }
        String kycWebDefault2 = getKycWebDefault();
        String kycWebDefault3 = smartRemoteDefaultConfig.getKycWebDefault();
        return kycWebDefault2 != null ? kycWebDefault2.equals(kycWebDefault3) : kycWebDefault3 == null;
    }

    public String getContractDefault() {
        return this.contractDefault;
    }

    public String getContractH5Default() {
        return this.contractH5Default;
    }

    public String getDmIndexDefault() {
        return this.dmIndexDefault;
    }

    public String getGlobalMobileDefault() {
        return this.globalMobileDefault;
    }

    public String getGlobalWebDefault() {
        return this.globalWebDefault;
    }

    public String getInstitutionDefault() {
        return this.institutionDefault;
    }

    public String getKycWebDefault() {
        return this.kycWebDefault;
    }

    public String getOtcDefault() {
        return this.otcDefault;
    }

    public String getSpotDefault() {
        return this.spotDefault;
    }

    public String getSwapDefault() {
        return this.swapDefault;
    }

    public String getSwapH5Default() {
        return this.swapH5Default;
    }

    public int hashCode() {
        String spotDefault2 = getSpotDefault();
        int i11 = 43;
        int hashCode = spotDefault2 == null ? 43 : spotDefault2.hashCode();
        String otcDefault2 = getOtcDefault();
        int hashCode2 = ((hashCode + 59) * 59) + (otcDefault2 == null ? 43 : otcDefault2.hashCode());
        String contractDefault2 = getContractDefault();
        int hashCode3 = (hashCode2 * 59) + (contractDefault2 == null ? 43 : contractDefault2.hashCode());
        String globalWebDefault2 = getGlobalWebDefault();
        int hashCode4 = (hashCode3 * 59) + (globalWebDefault2 == null ? 43 : globalWebDefault2.hashCode());
        String globalMobileDefault2 = getGlobalMobileDefault();
        int hashCode5 = (hashCode4 * 59) + (globalMobileDefault2 == null ? 43 : globalMobileDefault2.hashCode());
        String swapDefault2 = getSwapDefault();
        int hashCode6 = (hashCode5 * 59) + (swapDefault2 == null ? 43 : swapDefault2.hashCode());
        String dmIndexDefault2 = getDmIndexDefault();
        int hashCode7 = (hashCode6 * 59) + (dmIndexDefault2 == null ? 43 : dmIndexDefault2.hashCode());
        String swapH5Default2 = getSwapH5Default();
        int hashCode8 = (hashCode7 * 59) + (swapH5Default2 == null ? 43 : swapH5Default2.hashCode());
        String contractH5Default2 = getContractH5Default();
        int hashCode9 = (hashCode8 * 59) + (contractH5Default2 == null ? 43 : contractH5Default2.hashCode());
        String institutionDefault2 = getInstitutionDefault();
        int hashCode10 = (hashCode9 * 59) + (institutionDefault2 == null ? 43 : institutionDefault2.hashCode());
        String kycWebDefault2 = getKycWebDefault();
        int i12 = hashCode10 * 59;
        if (kycWebDefault2 != null) {
            i11 = kycWebDefault2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractDefault(String str) {
        this.contractDefault = str;
    }

    public void setContractH5Default(String str) {
        this.contractH5Default = str;
    }

    public void setDmIndexDefault(String str) {
        this.dmIndexDefault = str;
    }

    public void setGlobalMobileDefault(String str) {
        this.globalMobileDefault = str;
    }

    public void setGlobalWebDefault(String str) {
        this.globalWebDefault = str;
    }

    public void setInstitutionDefault(String str) {
        this.institutionDefault = str;
    }

    public void setKycWebDefault(String str) {
        this.kycWebDefault = str;
    }

    public void setOtcDefault(String str) {
        this.otcDefault = str;
    }

    public void setSpotDefault(String str) {
        this.spotDefault = str;
    }

    public void setSwapDefault(String str) {
        this.swapDefault = str;
    }

    public void setSwapH5Default(String str) {
        this.swapH5Default = str;
    }

    public String toString() {
        return "SmartRemoteDefaultConfig(spotDefault=" + getSpotDefault() + ", otcDefault=" + getOtcDefault() + ", contractDefault=" + getContractDefault() + ", globalWebDefault=" + getGlobalWebDefault() + ", globalMobileDefault=" + getGlobalMobileDefault() + ", swapDefault=" + getSwapDefault() + ", dmIndexDefault=" + getDmIndexDefault() + ", swapH5Default=" + getSwapH5Default() + ", contractH5Default=" + getContractH5Default() + ", institutionDefault=" + getInstitutionDefault() + ", kycWebDefault=" + getKycWebDefault() + ")";
    }
}
