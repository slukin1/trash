package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KycSDKTokenInfo implements Serializable {
    public static final String LIVING_API_HUAWEI = "HUAWEI";
    public static final String LIVING_API_JUMIO = "JUMIO";
    public static final String LIVING_API_SUMSUB = "SUMSUB_API";
    private static final long serialVersionUID = 7220771968640403857L;
    @SerializedName("authItem")
    public String authItem;
    @SerializedName("authItemMark")
    public String authUrl;
    @SerializedName("liveThreshold")
    public String liveThreshold;
    @SerializedName("livingApi")
    public String livingApi;
    @SerializedName("authItemSdk")
    public String sdkToken;
    @SerializedName("ticket")
    public String ticket;

    public boolean canEqual(Object obj) {
        return obj instanceof KycSDKTokenInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KycSDKTokenInfo)) {
            return false;
        }
        KycSDKTokenInfo kycSDKTokenInfo = (KycSDKTokenInfo) obj;
        if (!kycSDKTokenInfo.canEqual(this)) {
            return false;
        }
        String authItem2 = getAuthItem();
        String authItem3 = kycSDKTokenInfo.getAuthItem();
        if (authItem2 != null ? !authItem2.equals(authItem3) : authItem3 != null) {
            return false;
        }
        String authUrl2 = getAuthUrl();
        String authUrl3 = kycSDKTokenInfo.getAuthUrl();
        if (authUrl2 != null ? !authUrl2.equals(authUrl3) : authUrl3 != null) {
            return false;
        }
        String ticket2 = getTicket();
        String ticket3 = kycSDKTokenInfo.getTicket();
        if (ticket2 != null ? !ticket2.equals(ticket3) : ticket3 != null) {
            return false;
        }
        String sdkToken2 = getSdkToken();
        String sdkToken3 = kycSDKTokenInfo.getSdkToken();
        if (sdkToken2 != null ? !sdkToken2.equals(sdkToken3) : sdkToken3 != null) {
            return false;
        }
        String livingApi2 = getLivingApi();
        String livingApi3 = kycSDKTokenInfo.getLivingApi();
        if (livingApi2 != null ? !livingApi2.equals(livingApi3) : livingApi3 != null) {
            return false;
        }
        String liveThreshold2 = getLiveThreshold();
        String liveThreshold3 = kycSDKTokenInfo.getLiveThreshold();
        return liveThreshold2 != null ? liveThreshold2.equals(liveThreshold3) : liveThreshold3 == null;
    }

    public String getAuthItem() {
        return this.authItem;
    }

    public String getAuthUrl() {
        return this.authUrl;
    }

    public String getLiveThreshold() {
        return this.liveThreshold;
    }

    public String getLivingApi() {
        return this.livingApi;
    }

    public String getSdkToken() {
        return this.sdkToken;
    }

    public String getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        String authItem2 = getAuthItem();
        int i11 = 43;
        int hashCode = authItem2 == null ? 43 : authItem2.hashCode();
        String authUrl2 = getAuthUrl();
        int hashCode2 = ((hashCode + 59) * 59) + (authUrl2 == null ? 43 : authUrl2.hashCode());
        String ticket2 = getTicket();
        int hashCode3 = (hashCode2 * 59) + (ticket2 == null ? 43 : ticket2.hashCode());
        String sdkToken2 = getSdkToken();
        int hashCode4 = (hashCode3 * 59) + (sdkToken2 == null ? 43 : sdkToken2.hashCode());
        String livingApi2 = getLivingApi();
        int hashCode5 = (hashCode4 * 59) + (livingApi2 == null ? 43 : livingApi2.hashCode());
        String liveThreshold2 = getLiveThreshold();
        int i12 = hashCode5 * 59;
        if (liveThreshold2 != null) {
            i11 = liveThreshold2.hashCode();
        }
        return i12 + i11;
    }

    public void setAuthItem(String str) {
        this.authItem = str;
    }

    public void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public void setLiveThreshold(String str) {
        this.liveThreshold = str;
    }

    public void setLivingApi(String str) {
        this.livingApi = str;
    }

    public void setSdkToken(String str) {
        this.sdkToken = str;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public String toString() {
        return "KycSDKTokenInfo(authItem=" + getAuthItem() + ", authUrl=" + getAuthUrl() + ", ticket=" + getTicket() + ", sdkToken=" + getSdkToken() + ", livingApi=" + getLivingApi() + ", liveThreshold=" + getLiveThreshold() + ")";
    }
}
