package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KycTicketInfo implements Serializable {
    @SerializedName("channel")
    public String channel;
    @SerializedName("liveThreshold")
    public String liveThreshold;
    @SerializedName("sdkToken")
    public String sdkToken;
    @SerializedName("sdkUrl")
    public String sdkUrl;
    @SerializedName("ticket")
    public String ticket;

    public boolean canEqual(Object obj) {
        return obj instanceof KycTicketInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KycTicketInfo)) {
            return false;
        }
        KycTicketInfo kycTicketInfo = (KycTicketInfo) obj;
        if (!kycTicketInfo.canEqual(this)) {
            return false;
        }
        String ticket2 = getTicket();
        String ticket3 = kycTicketInfo.getTicket();
        if (ticket2 != null ? !ticket2.equals(ticket3) : ticket3 != null) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = kycTicketInfo.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        String sdkToken2 = getSdkToken();
        String sdkToken3 = kycTicketInfo.getSdkToken();
        if (sdkToken2 != null ? !sdkToken2.equals(sdkToken3) : sdkToken3 != null) {
            return false;
        }
        String sdkUrl2 = getSdkUrl();
        String sdkUrl3 = kycTicketInfo.getSdkUrl();
        if (sdkUrl2 != null ? !sdkUrl2.equals(sdkUrl3) : sdkUrl3 != null) {
            return false;
        }
        String liveThreshold2 = getLiveThreshold();
        String liveThreshold3 = kycTicketInfo.getLiveThreshold();
        return liveThreshold2 != null ? liveThreshold2.equals(liveThreshold3) : liveThreshold3 == null;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getLiveThreshold() {
        return this.liveThreshold;
    }

    public String getSdkToken() {
        return this.sdkToken;
    }

    public String getSdkUrl() {
        return this.sdkUrl;
    }

    public String getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        String ticket2 = getTicket();
        int i11 = 43;
        int hashCode = ticket2 == null ? 43 : ticket2.hashCode();
        String channel2 = getChannel();
        int hashCode2 = ((hashCode + 59) * 59) + (channel2 == null ? 43 : channel2.hashCode());
        String sdkToken2 = getSdkToken();
        int hashCode3 = (hashCode2 * 59) + (sdkToken2 == null ? 43 : sdkToken2.hashCode());
        String sdkUrl2 = getSdkUrl();
        int hashCode4 = (hashCode3 * 59) + (sdkUrl2 == null ? 43 : sdkUrl2.hashCode());
        String liveThreshold2 = getLiveThreshold();
        int i12 = hashCode4 * 59;
        if (liveThreshold2 != null) {
            i11 = liveThreshold2.hashCode();
        }
        return i12 + i11;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setLiveThreshold(String str) {
        this.liveThreshold = str;
    }

    public void setSdkToken(String str) {
        this.sdkToken = str;
    }

    public void setSdkUrl(String str) {
        this.sdkUrl = str;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public String toString() {
        return "KycTicketInfo(ticket=" + getTicket() + ", channel=" + getChannel() + ", sdkToken=" + getSdkToken() + ", sdkUrl=" + getSdkUrl() + ", liveThreshold=" + getLiveThreshold() + ")";
    }
}
