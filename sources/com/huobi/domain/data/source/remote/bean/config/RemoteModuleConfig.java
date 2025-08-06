package com.huobi.domain.data.source.remote.bean.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RemoteModuleConfig implements Serializable {
    private static final long serialVersionUID = -5337074144118688892L;
    @SerializedName("h5_jump_url")
    private List<String> h5JumpUrl;
    @SerializedName("hbg_analytics_url")
    private String hbgAnalyticsUrl;
    @SerializedName("invite")
    private RemoteModuleConfigInfo inviteConfig;
    @SerializedName("market_reminder")
    private List<RemindAppInfo> marketReminderConfig;
    @SerializedName("otc_auth_host")
    private String otcAuthHost;
    @SerializedName("p")
    private RemoteModuleConfigInfo primeConfig;
    @SerializedName("sa_data_report_url")
    private String saDataReportUrl;
    @SerializedName("vulcan")
    private RemoteModuleConfigInfo vulcanConfig;
    @SerializedName("woodpecker_host")
    private String woodPeckerHost;

    public boolean canEqual(Object obj) {
        return obj instanceof RemoteModuleConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModuleConfig)) {
            return false;
        }
        RemoteModuleConfig remoteModuleConfig = (RemoteModuleConfig) obj;
        if (!remoteModuleConfig.canEqual(this)) {
            return false;
        }
        RemoteModuleConfigInfo inviteConfig2 = getInviteConfig();
        RemoteModuleConfigInfo inviteConfig3 = remoteModuleConfig.getInviteConfig();
        if (inviteConfig2 != null ? !inviteConfig2.equals(inviteConfig3) : inviteConfig3 != null) {
            return false;
        }
        RemoteModuleConfigInfo primeConfig2 = getPrimeConfig();
        RemoteModuleConfigInfo primeConfig3 = remoteModuleConfig.getPrimeConfig();
        if (primeConfig2 != null ? !primeConfig2.equals(primeConfig3) : primeConfig3 != null) {
            return false;
        }
        RemoteModuleConfigInfo vulcanConfig2 = getVulcanConfig();
        RemoteModuleConfigInfo vulcanConfig3 = remoteModuleConfig.getVulcanConfig();
        if (vulcanConfig2 != null ? !vulcanConfig2.equals(vulcanConfig3) : vulcanConfig3 != null) {
            return false;
        }
        List<RemindAppInfo> marketReminderConfig2 = getMarketReminderConfig();
        List<RemindAppInfo> marketReminderConfig3 = remoteModuleConfig.getMarketReminderConfig();
        if (marketReminderConfig2 != null ? !marketReminderConfig2.equals(marketReminderConfig3) : marketReminderConfig3 != null) {
            return false;
        }
        String otcAuthHost2 = getOtcAuthHost();
        String otcAuthHost3 = remoteModuleConfig.getOtcAuthHost();
        if (otcAuthHost2 != null ? !otcAuthHost2.equals(otcAuthHost3) : otcAuthHost3 != null) {
            return false;
        }
        String saDataReportUrl2 = getSaDataReportUrl();
        String saDataReportUrl3 = remoteModuleConfig.getSaDataReportUrl();
        if (saDataReportUrl2 != null ? !saDataReportUrl2.equals(saDataReportUrl3) : saDataReportUrl3 != null) {
            return false;
        }
        String hbgAnalyticsUrl2 = getHbgAnalyticsUrl();
        String hbgAnalyticsUrl3 = remoteModuleConfig.getHbgAnalyticsUrl();
        if (hbgAnalyticsUrl2 != null ? !hbgAnalyticsUrl2.equals(hbgAnalyticsUrl3) : hbgAnalyticsUrl3 != null) {
            return false;
        }
        String woodPeckerHost2 = getWoodPeckerHost();
        String woodPeckerHost3 = remoteModuleConfig.getWoodPeckerHost();
        if (woodPeckerHost2 != null ? !woodPeckerHost2.equals(woodPeckerHost3) : woodPeckerHost3 != null) {
            return false;
        }
        List<String> h5JumpUrl2 = getH5JumpUrl();
        List<String> h5JumpUrl3 = remoteModuleConfig.getH5JumpUrl();
        return h5JumpUrl2 != null ? h5JumpUrl2.equals(h5JumpUrl3) : h5JumpUrl3 == null;
    }

    public List<String> getH5JumpUrl() {
        return this.h5JumpUrl;
    }

    public String getHbgAnalyticsUrl() {
        return this.hbgAnalyticsUrl;
    }

    public RemoteModuleConfigInfo getInviteConfig() {
        return this.inviteConfig;
    }

    public List<RemindAppInfo> getMarketReminderConfig() {
        return this.marketReminderConfig;
    }

    public String getOtcAuthHost() {
        return this.otcAuthHost;
    }

    public RemoteModuleConfigInfo getPrimeConfig() {
        return this.primeConfig;
    }

    public String getSaDataReportUrl() {
        return this.saDataReportUrl;
    }

    public RemoteModuleConfigInfo getVulcanConfig() {
        return this.vulcanConfig;
    }

    public String getWoodPeckerHost() {
        return this.woodPeckerHost;
    }

    public int hashCode() {
        RemoteModuleConfigInfo inviteConfig2 = getInviteConfig();
        int i11 = 43;
        int hashCode = inviteConfig2 == null ? 43 : inviteConfig2.hashCode();
        RemoteModuleConfigInfo primeConfig2 = getPrimeConfig();
        int hashCode2 = ((hashCode + 59) * 59) + (primeConfig2 == null ? 43 : primeConfig2.hashCode());
        RemoteModuleConfigInfo vulcanConfig2 = getVulcanConfig();
        int hashCode3 = (hashCode2 * 59) + (vulcanConfig2 == null ? 43 : vulcanConfig2.hashCode());
        List<RemindAppInfo> marketReminderConfig2 = getMarketReminderConfig();
        int hashCode4 = (hashCode3 * 59) + (marketReminderConfig2 == null ? 43 : marketReminderConfig2.hashCode());
        String otcAuthHost2 = getOtcAuthHost();
        int hashCode5 = (hashCode4 * 59) + (otcAuthHost2 == null ? 43 : otcAuthHost2.hashCode());
        String saDataReportUrl2 = getSaDataReportUrl();
        int hashCode6 = (hashCode5 * 59) + (saDataReportUrl2 == null ? 43 : saDataReportUrl2.hashCode());
        String hbgAnalyticsUrl2 = getHbgAnalyticsUrl();
        int hashCode7 = (hashCode6 * 59) + (hbgAnalyticsUrl2 == null ? 43 : hbgAnalyticsUrl2.hashCode());
        String woodPeckerHost2 = getWoodPeckerHost();
        int hashCode8 = (hashCode7 * 59) + (woodPeckerHost2 == null ? 43 : woodPeckerHost2.hashCode());
        List<String> h5JumpUrl2 = getH5JumpUrl();
        int i12 = hashCode8 * 59;
        if (h5JumpUrl2 != null) {
            i11 = h5JumpUrl2.hashCode();
        }
        return i12 + i11;
    }

    public void setH5JumpUrl(List<String> list) {
        this.h5JumpUrl = list;
    }

    public void setHbgAnalyticsUrl(String str) {
        this.hbgAnalyticsUrl = str;
    }

    public void setInviteConfig(RemoteModuleConfigInfo remoteModuleConfigInfo) {
        this.inviteConfig = remoteModuleConfigInfo;
    }

    public void setMarketReminderConfig(List<RemindAppInfo> list) {
        this.marketReminderConfig = list;
    }

    public void setOtcAuthHost(String str) {
        this.otcAuthHost = str;
    }

    public void setPrimeConfig(RemoteModuleConfigInfo remoteModuleConfigInfo) {
        this.primeConfig = remoteModuleConfigInfo;
    }

    public void setSaDataReportUrl(String str) {
        this.saDataReportUrl = str;
    }

    public void setVulcanConfig(RemoteModuleConfigInfo remoteModuleConfigInfo) {
        this.vulcanConfig = remoteModuleConfigInfo;
    }

    public void setWoodPeckerHost(String str) {
        this.woodPeckerHost = str;
    }

    public String toString() {
        return "RemoteModuleConfig{inviteConfig=" + this.inviteConfig + ", primeConfig=" + this.primeConfig + ", vulcanConfig=" + this.vulcanConfig + ", marketReminderConfig=" + this.marketReminderConfig + ", hbgAnalyticsUrl=" + this.hbgAnalyticsUrl + '}';
    }
}
