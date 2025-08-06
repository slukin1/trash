package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SmartDomainData implements Serializable {
    public static final long serialVersionUID = 6317556340187588603L;
    public List<SmartDomainUrl> contract;
    public List<SmartDomainUrl> dmH5;
    public List<SmartDomainUrl> globalMobile;
    public List<SmartDomainUrl> globalWeb;
    public List<SmartDomainUrl> index;
    public List<SmartDomainUrl> institution;
    public List<SmartDomainUrl> kycWeb;
    public List<SmartDomainUrl> otc;
    public List<SmartDomainUrl> spot;
    public List<SmartDomainUrl> spotWebsocket;

    public boolean canEqual(Object obj) {
        return obj instanceof SmartDomainData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmartDomainData)) {
            return false;
        }
        SmartDomainData smartDomainData = (SmartDomainData) obj;
        if (!smartDomainData.canEqual(this)) {
            return false;
        }
        List<SmartDomainUrl> spot2 = getSpot();
        List<SmartDomainUrl> spot3 = smartDomainData.getSpot();
        if (spot2 != null ? !spot2.equals(spot3) : spot3 != null) {
            return false;
        }
        List<SmartDomainUrl> spotWebsocket2 = getSpotWebsocket();
        List<SmartDomainUrl> spotWebsocket3 = smartDomainData.getSpotWebsocket();
        if (spotWebsocket2 != null ? !spotWebsocket2.equals(spotWebsocket3) : spotWebsocket3 != null) {
            return false;
        }
        List<SmartDomainUrl> contract2 = getContract();
        List<SmartDomainUrl> contract3 = smartDomainData.getContract();
        if (contract2 != null ? !contract2.equals(contract3) : contract3 != null) {
            return false;
        }
        List<SmartDomainUrl> index2 = getIndex();
        List<SmartDomainUrl> index3 = smartDomainData.getIndex();
        if (index2 != null ? !index2.equals(index3) : index3 != null) {
            return false;
        }
        List<SmartDomainUrl> otc2 = getOtc();
        List<SmartDomainUrl> otc3 = smartDomainData.getOtc();
        if (otc2 != null ? !otc2.equals(otc3) : otc3 != null) {
            return false;
        }
        List<SmartDomainUrl> globalMobile2 = getGlobalMobile();
        List<SmartDomainUrl> globalMobile3 = smartDomainData.getGlobalMobile();
        if (globalMobile2 != null ? !globalMobile2.equals(globalMobile3) : globalMobile3 != null) {
            return false;
        }
        List<SmartDomainUrl> globalWeb2 = getGlobalWeb();
        List<SmartDomainUrl> globalWeb3 = smartDomainData.getGlobalWeb();
        if (globalWeb2 != null ? !globalWeb2.equals(globalWeb3) : globalWeb3 != null) {
            return false;
        }
        List<SmartDomainUrl> dmH52 = getDmH5();
        List<SmartDomainUrl> dmH53 = smartDomainData.getDmH5();
        if (dmH52 != null ? !dmH52.equals(dmH53) : dmH53 != null) {
            return false;
        }
        List<SmartDomainUrl> institution2 = getInstitution();
        List<SmartDomainUrl> institution3 = smartDomainData.getInstitution();
        if (institution2 != null ? !institution2.equals(institution3) : institution3 != null) {
            return false;
        }
        List<SmartDomainUrl> kycWeb2 = getKycWeb();
        List<SmartDomainUrl> kycWeb3 = smartDomainData.getKycWeb();
        return kycWeb2 != null ? kycWeb2.equals(kycWeb3) : kycWeb3 == null;
    }

    public List<SmartDomainUrl> getContract() {
        return this.contract;
    }

    public List<SmartDomainUrl> getDmH5() {
        return this.dmH5;
    }

    public List<SmartDomainUrl> getGlobalMobile() {
        return this.globalMobile;
    }

    public List<SmartDomainUrl> getGlobalWeb() {
        return this.globalWeb;
    }

    public List<SmartDomainUrl> getIndex() {
        return this.index;
    }

    public List<SmartDomainUrl> getInstitution() {
        return this.institution;
    }

    public List<SmartDomainUrl> getKycWeb() {
        return this.kycWeb;
    }

    public List<SmartDomainUrl> getOtc() {
        return this.otc;
    }

    public List<SmartDomainUrl> getSpot() {
        return this.spot;
    }

    public List<SmartDomainUrl> getSpotWebsocket() {
        return this.spotWebsocket;
    }

    public List<String> getUrlList(List<SmartDomainUrl> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartDomainUrl url : list) {
                arrayList.add(url.getUrl());
            }
        }
        return arrayList;
    }

    public int hashCode() {
        List<SmartDomainUrl> spot2 = getSpot();
        int i11 = 43;
        int hashCode = spot2 == null ? 43 : spot2.hashCode();
        List<SmartDomainUrl> spotWebsocket2 = getSpotWebsocket();
        int hashCode2 = ((hashCode + 59) * 59) + (spotWebsocket2 == null ? 43 : spotWebsocket2.hashCode());
        List<SmartDomainUrl> contract2 = getContract();
        int hashCode3 = (hashCode2 * 59) + (contract2 == null ? 43 : contract2.hashCode());
        List<SmartDomainUrl> index2 = getIndex();
        int hashCode4 = (hashCode3 * 59) + (index2 == null ? 43 : index2.hashCode());
        List<SmartDomainUrl> otc2 = getOtc();
        int hashCode5 = (hashCode4 * 59) + (otc2 == null ? 43 : otc2.hashCode());
        List<SmartDomainUrl> globalMobile2 = getGlobalMobile();
        int hashCode6 = (hashCode5 * 59) + (globalMobile2 == null ? 43 : globalMobile2.hashCode());
        List<SmartDomainUrl> globalWeb2 = getGlobalWeb();
        int hashCode7 = (hashCode6 * 59) + (globalWeb2 == null ? 43 : globalWeb2.hashCode());
        List<SmartDomainUrl> dmH52 = getDmH5();
        int hashCode8 = (hashCode7 * 59) + (dmH52 == null ? 43 : dmH52.hashCode());
        List<SmartDomainUrl> institution2 = getInstitution();
        int hashCode9 = (hashCode8 * 59) + (institution2 == null ? 43 : institution2.hashCode());
        List<SmartDomainUrl> kycWeb2 = getKycWeb();
        int i12 = hashCode9 * 59;
        if (kycWeb2 != null) {
            i11 = kycWeb2.hashCode();
        }
        return i12 + i11;
    }

    public void setContract(List<SmartDomainUrl> list) {
        this.contract = list;
    }

    public void setDmH5(List<SmartDomainUrl> list) {
        this.dmH5 = list;
    }

    public void setGlobalMobile(List<SmartDomainUrl> list) {
        this.globalMobile = list;
    }

    public void setGlobalWeb(List<SmartDomainUrl> list) {
        this.globalWeb = list;
    }

    public void setIndex(List<SmartDomainUrl> list) {
        this.index = list;
    }

    public void setInstitution(List<SmartDomainUrl> list) {
        this.institution = list;
    }

    public void setKycWeb(List<SmartDomainUrl> list) {
        this.kycWeb = list;
    }

    public void setOtc(List<SmartDomainUrl> list) {
        this.otc = list;
    }

    public void setSpot(List<SmartDomainUrl> list) {
        this.spot = list;
    }

    public void setSpotWebsocket(List<SmartDomainUrl> list) {
        this.spotWebsocket = list;
    }

    public String toString() {
        return "SmartDomainData(spot=" + getSpot() + ", spotWebsocket=" + getSpotWebsocket() + ", contract=" + getContract() + ", index=" + getIndex() + ", otc=" + getOtc() + ", globalMobile=" + getGlobalMobile() + ", globalWeb=" + getGlobalWeb() + ", dmH5=" + getDmH5() + ", institution=" + getInstitution() + ", kycWeb=" + getKycWeb() + ")";
    }
}
