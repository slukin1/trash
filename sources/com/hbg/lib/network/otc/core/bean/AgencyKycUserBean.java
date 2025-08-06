package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class AgencyKycUserBean implements Serializable {
    private String agencyKycUrl;
    private int orgLevel;
    private int ubaState;

    public boolean canEqual(Object obj) {
        return obj instanceof AgencyKycUserBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AgencyKycUserBean)) {
            return false;
        }
        AgencyKycUserBean agencyKycUserBean = (AgencyKycUserBean) obj;
        if (!agencyKycUserBean.canEqual(this) || getOrgLevel() != agencyKycUserBean.getOrgLevel() || getUbaState() != agencyKycUserBean.getUbaState()) {
            return false;
        }
        String agencyKycUrl2 = getAgencyKycUrl();
        String agencyKycUrl3 = agencyKycUserBean.getAgencyKycUrl();
        return agencyKycUrl2 != null ? agencyKycUrl2.equals(agencyKycUrl3) : agencyKycUrl3 == null;
    }

    public String getAgencyKycUrl() {
        return this.agencyKycUrl;
    }

    public int getOrgLevel() {
        return this.orgLevel;
    }

    public int getUbaState() {
        return this.ubaState;
    }

    public int hashCode() {
        int orgLevel2 = ((getOrgLevel() + 59) * 59) + getUbaState();
        String agencyKycUrl2 = getAgencyKycUrl();
        return (orgLevel2 * 59) + (agencyKycUrl2 == null ? 43 : agencyKycUrl2.hashCode());
    }

    public boolean isLevelEnough() {
        return this.orgLevel == 2 && this.ubaState == 2;
    }

    public void setAgencyKycUrl(String str) {
        this.agencyKycUrl = str;
    }

    public void setOrgLevel(int i11) {
        this.orgLevel = i11;
    }

    public void setUbaState(int i11) {
        this.ubaState = i11;
    }

    public String toString() {
        return "AgencyKycUserBean(orgLevel=" + getOrgLevel() + ", ubaState=" + getUbaState() + ", agencyKycUrl=" + getAgencyKycUrl() + ")";
    }
}
