package com.huobi.domain.data.source.remote.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.core.config.AliyunConfig;
import com.hbg.lib.core.config.OtherConfig;
import com.huobi.domain.data.source.remote.bean.config.RemoteDefaultConfig;
import com.huobi.domain.data.source.remote.bean.config.RemoteModuleConfig;
import java.io.Serializable;

public class RemoteDomain implements Serializable {
    private static final long serialVersionUID = 6466872594858669717L;
    @SerializedName("aliyun")
    private AliyunConfig aliyunConfig;
    @SerializedName("default_domain")
    private RemoteDefaultConfig defaultDomain;
    @SerializedName("dm_index")
    private RemoteDomainInfo dmIndex;
    @SerializedName("domain_version")
    private int domainVersion;
    @SerializedName("global_m_fast")
    private RemoteDomainInfo globalM;
    @SerializedName("global_web_fast")
    private RemoteDomainInfo globalWeb;
    @SerializedName("global_ws")
    private RemoteDomainInfo globalWs;
    @SerializedName("hadax_web")
    private RemoteDomainInfo hadaxWeb;
    @SerializedName("hadax_api")
    private RemoteDomainInfo hadexApi;
    @SerializedName("hb_info")
    private RemoteDomainInfo hbInfo;
    @SerializedName("hbdm")
    private RemoteDomainInfo hbdm;
    @SerializedName("hbdm_h5")
    private RemoteDomainInfo hbdmh5;
    @SerializedName("invite")
    private ShareUrlInfo inviteInfo;
    @SerializedName("mobile_web")
    private RemoteDomainInfo mobileWeb;
    @SerializedName("module_config")
    private RemoteModuleConfig moduleConfig;
    @SerializedName("otc_api")
    private RemoteDomainInfo otcApi;
    @SerializedName("otc_web")
    private RemoteDomainInfo otcWeb;
    @SerializedName("other_config")
    private OtherConfig otherConfig;
    @SerializedName("php_api")
    private RemoteDomainInfo phpApi;
    @SerializedName("pro_api")
    private RemoteDomainInfo proApi;
    @SerializedName("pro_web")
    private RemoteDomainInfo proWeb;
    @SerializedName("share")
    private ShareUrlInfo shareUrlInfo;
    @SerializedName("smart_domain")
    private SmartDomain smartDomain;
    @SerializedName("swap")
    private RemoteDomainInfo swap;
    @SerializedName("swap_h5")
    private RemoteDomainInfo swapH5;
    @SerializedName("uc_api")
    private RemoteDomainInfo ucApi;
    @SerializedName("v2_domain")
    private RemoteDomainInfo v2DomainInfo;

    public AliyunConfig getAliyunConfig() {
        return this.aliyunConfig;
    }

    public RemoteDefaultConfig getDefaultDomain() {
        return this.defaultDomain;
    }

    public RemoteDomainInfo getDmIndex() {
        return this.dmIndex;
    }

    public int getDomainVersion() {
        return this.domainVersion;
    }

    public RemoteDomainInfo getGlobalM() {
        return this.globalM;
    }

    public RemoteDomainInfo getGlobalWeb() {
        return this.globalWeb;
    }

    public RemoteDomainInfo getGlobalWs() {
        return this.globalWs;
    }

    public RemoteDomainInfo getHadaxWeb() {
        return this.hadaxWeb;
    }

    public RemoteDomainInfo getHadexApi() {
        return this.hadexApi;
    }

    public RemoteDomainInfo getHbInfo() {
        return this.hbInfo;
    }

    public RemoteDomainInfo getHbdm() {
        return this.hbdm;
    }

    public RemoteDomainInfo getHbdmh5() {
        return this.hbdmh5;
    }

    public ShareUrlInfo getInviteInfo() {
        return this.inviteInfo;
    }

    public RemoteDomainInfo getMobileWeb() {
        return this.mobileWeb;
    }

    public RemoteModuleConfig getModuleConfig() {
        return this.moduleConfig;
    }

    public RemoteDomainInfo getOtcApi() {
        return this.otcApi;
    }

    public RemoteDomainInfo getOtcWeb() {
        return this.otcWeb;
    }

    public OtherConfig getOtherConfig() {
        return this.otherConfig;
    }

    public RemoteDomainInfo getPhpApi() {
        return this.phpApi;
    }

    public RemoteDomainInfo getProApi() {
        return this.proApi;
    }

    public RemoteDomainInfo getProWeb() {
        return this.proWeb;
    }

    public ShareUrlInfo getShareUrlInfo() {
        return this.shareUrlInfo;
    }

    public SmartDomain getSmartDomain() {
        return this.smartDomain;
    }

    public RemoteDomainInfo getSwap() {
        return this.swap;
    }

    public RemoteDomainInfo getSwapH5() {
        return this.swapH5;
    }

    public RemoteDomainInfo getUcApi() {
        return this.ucApi;
    }

    public RemoteDomainInfo getV2DomainInfo() {
        return this.v2DomainInfo;
    }

    public void setAliyunConfig(AliyunConfig aliyunConfig2) {
        this.aliyunConfig = aliyunConfig2;
    }

    public void setDefaultDomain(RemoteDefaultConfig remoteDefaultConfig) {
        this.defaultDomain = remoteDefaultConfig;
    }

    public void setDmIndex(RemoteDomainInfo remoteDomainInfo) {
        this.dmIndex = remoteDomainInfo;
    }

    public void setDomainVersion(int i11) {
        this.domainVersion = i11;
    }

    public void setGlobalM(RemoteDomainInfo remoteDomainInfo) {
        this.globalM = remoteDomainInfo;
    }

    public void setGlobalWeb(RemoteDomainInfo remoteDomainInfo) {
        this.globalWeb = remoteDomainInfo;
    }

    public void setGlobalWs(RemoteDomainInfo remoteDomainInfo) {
        this.globalWs = remoteDomainInfo;
    }

    public void setHadaxWeb(RemoteDomainInfo remoteDomainInfo) {
        this.hadaxWeb = remoteDomainInfo;
    }

    public void setHadexApi(RemoteDomainInfo remoteDomainInfo) {
        this.hadexApi = remoteDomainInfo;
    }

    public void setHbInfo(RemoteDomainInfo remoteDomainInfo) {
        this.hbInfo = remoteDomainInfo;
    }

    public void setHbdm(RemoteDomainInfo remoteDomainInfo) {
        this.hbdm = remoteDomainInfo;
    }

    public void setHbdmh5(RemoteDomainInfo remoteDomainInfo) {
        this.hbdmh5 = remoteDomainInfo;
    }

    public void setInviteInfo(ShareUrlInfo shareUrlInfo2) {
        this.inviteInfo = shareUrlInfo2;
    }

    public void setMobileWeb(RemoteDomainInfo remoteDomainInfo) {
        this.mobileWeb = remoteDomainInfo;
    }

    public void setModuleConfig(RemoteModuleConfig remoteModuleConfig) {
        this.moduleConfig = remoteModuleConfig;
    }

    public void setOtcApi(RemoteDomainInfo remoteDomainInfo) {
        this.otcApi = remoteDomainInfo;
    }

    public void setOtcWeb(RemoteDomainInfo remoteDomainInfo) {
        this.otcWeb = remoteDomainInfo;
    }

    public void setOtherConfig(OtherConfig otherConfig2) {
        this.otherConfig = otherConfig2;
    }

    public void setPhpApi(RemoteDomainInfo remoteDomainInfo) {
        this.phpApi = remoteDomainInfo;
    }

    public void setProApi(RemoteDomainInfo remoteDomainInfo) {
        this.proApi = remoteDomainInfo;
    }

    public void setProWeb(RemoteDomainInfo remoteDomainInfo) {
        this.proWeb = remoteDomainInfo;
    }

    public void setShareUrlInfo(ShareUrlInfo shareUrlInfo2) {
        this.shareUrlInfo = shareUrlInfo2;
    }

    public void setSmartDomain(SmartDomain smartDomain2) {
        this.smartDomain = smartDomain2;
    }

    public void setSwap(RemoteDomainInfo remoteDomainInfo) {
        this.swap = remoteDomainInfo;
    }

    public void setSwapH5(RemoteDomainInfo remoteDomainInfo) {
        this.swapH5 = remoteDomainInfo;
    }

    public void setUcApi(RemoteDomainInfo remoteDomainInfo) {
        this.ucApi = remoteDomainInfo;
    }

    public void setV2DomainInfo(RemoteDomainInfo remoteDomainInfo) {
        this.v2DomainInfo = remoteDomainInfo;
    }
}
