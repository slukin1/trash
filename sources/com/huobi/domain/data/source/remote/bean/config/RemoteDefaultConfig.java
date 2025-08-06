package com.huobi.domain.data.source.remote.bean.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RemoteDefaultConfig implements Serializable {
    private static final long serialVersionUID = 4303346821217154749L;
    @SerializedName("dm_index_cn")
    private String dmIndexCn;
    @SerializedName("dm_index_overseas")
    private String dmIndexOverseas;
    @SerializedName("global_m_cn")
    private String globalMobileCn;
    @SerializedName("global_m_overseas")
    private String globalMobileOverseas;
    @SerializedName("global_web_cn")
    private String globalWebCn;
    @SerializedName("global_web_overseas")
    private String globalWebOverseas;
    @SerializedName("hbdm_cn")
    private String hbdmCn;
    @SerializedName("hbdm_overseas")
    private String hbdmOverseas;
    @SerializedName("otc_cn")
    private String otcCn;
    @SerializedName("otc_overseas")
    private String otcOverseas;
    @SerializedName("pro_cn")
    private String proCn;
    @SerializedName("pro_overseas")
    private String proOverseas;
    @SerializedName("swap_cn")
    private String swapCn;
    @SerializedName("swap_overseas")
    private String swapOverseas;

    public boolean canEqual(Object obj) {
        return obj instanceof RemoteDefaultConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteDefaultConfig)) {
            return false;
        }
        RemoteDefaultConfig remoteDefaultConfig = (RemoteDefaultConfig) obj;
        if (!remoteDefaultConfig.canEqual(this)) {
            return false;
        }
        String proCn2 = getProCn();
        String proCn3 = remoteDefaultConfig.getProCn();
        if (proCn2 != null ? !proCn2.equals(proCn3) : proCn3 != null) {
            return false;
        }
        String proOverseas2 = getProOverseas();
        String proOverseas3 = remoteDefaultConfig.getProOverseas();
        if (proOverseas2 != null ? !proOverseas2.equals(proOverseas3) : proOverseas3 != null) {
            return false;
        }
        String otcCn2 = getOtcCn();
        String otcCn3 = remoteDefaultConfig.getOtcCn();
        if (otcCn2 != null ? !otcCn2.equals(otcCn3) : otcCn3 != null) {
            return false;
        }
        String otcOverseas2 = getOtcOverseas();
        String otcOverseas3 = remoteDefaultConfig.getOtcOverseas();
        if (otcOverseas2 != null ? !otcOverseas2.equals(otcOverseas3) : otcOverseas3 != null) {
            return false;
        }
        String hbdmCn2 = getHbdmCn();
        String hbdmCn3 = remoteDefaultConfig.getHbdmCn();
        if (hbdmCn2 != null ? !hbdmCn2.equals(hbdmCn3) : hbdmCn3 != null) {
            return false;
        }
        String hbdmOverseas2 = getHbdmOverseas();
        String hbdmOverseas3 = remoteDefaultConfig.getHbdmOverseas();
        if (hbdmOverseas2 != null ? !hbdmOverseas2.equals(hbdmOverseas3) : hbdmOverseas3 != null) {
            return false;
        }
        String globalWebCn2 = getGlobalWebCn();
        String globalWebCn3 = remoteDefaultConfig.getGlobalWebCn();
        if (globalWebCn2 != null ? !globalWebCn2.equals(globalWebCn3) : globalWebCn3 != null) {
            return false;
        }
        String globalWebOverseas2 = getGlobalWebOverseas();
        String globalWebOverseas3 = remoteDefaultConfig.getGlobalWebOverseas();
        if (globalWebOverseas2 != null ? !globalWebOverseas2.equals(globalWebOverseas3) : globalWebOverseas3 != null) {
            return false;
        }
        String globalMobileCn2 = getGlobalMobileCn();
        String globalMobileCn3 = remoteDefaultConfig.getGlobalMobileCn();
        if (globalMobileCn2 != null ? !globalMobileCn2.equals(globalMobileCn3) : globalMobileCn3 != null) {
            return false;
        }
        String globalMobileOverseas2 = getGlobalMobileOverseas();
        String globalMobileOverseas3 = remoteDefaultConfig.getGlobalMobileOverseas();
        if (globalMobileOverseas2 != null ? !globalMobileOverseas2.equals(globalMobileOverseas3) : globalMobileOverseas3 != null) {
            return false;
        }
        String swapCn2 = getSwapCn();
        String swapCn3 = remoteDefaultConfig.getSwapCn();
        if (swapCn2 != null ? !swapCn2.equals(swapCn3) : swapCn3 != null) {
            return false;
        }
        String swapOverseas2 = getSwapOverseas();
        String swapOverseas3 = remoteDefaultConfig.getSwapOverseas();
        if (swapOverseas2 != null ? !swapOverseas2.equals(swapOverseas3) : swapOverseas3 != null) {
            return false;
        }
        String dmIndexCn2 = getDmIndexCn();
        String dmIndexCn3 = remoteDefaultConfig.getDmIndexCn();
        if (dmIndexCn2 != null ? !dmIndexCn2.equals(dmIndexCn3) : dmIndexCn3 != null) {
            return false;
        }
        String dmIndexOverseas2 = getDmIndexOverseas();
        String dmIndexOverseas3 = remoteDefaultConfig.getDmIndexOverseas();
        return dmIndexOverseas2 != null ? dmIndexOverseas2.equals(dmIndexOverseas3) : dmIndexOverseas3 == null;
    }

    public String getDmIndexCn() {
        return this.dmIndexCn;
    }

    public String getDmIndexOverseas() {
        return this.dmIndexOverseas;
    }

    public String getGlobalMobileCn() {
        return this.globalMobileCn;
    }

    public String getGlobalMobileOverseas() {
        return this.globalMobileOverseas;
    }

    public String getGlobalWebCn() {
        return this.globalWebCn;
    }

    public String getGlobalWebOverseas() {
        return this.globalWebOverseas;
    }

    public String getHbdmCn() {
        return this.hbdmCn;
    }

    public String getHbdmOverseas() {
        return this.hbdmOverseas;
    }

    public String getOtcCn() {
        return this.otcCn;
    }

    public String getOtcOverseas() {
        return this.otcOverseas;
    }

    public String getProCn() {
        return this.proCn;
    }

    public String getProOverseas() {
        return this.proOverseas;
    }

    public String getSwapCn() {
        return this.swapCn;
    }

    public String getSwapOverseas() {
        return this.swapOverseas;
    }

    public int hashCode() {
        String proCn2 = getProCn();
        int i11 = 43;
        int hashCode = proCn2 == null ? 43 : proCn2.hashCode();
        String proOverseas2 = getProOverseas();
        int hashCode2 = ((hashCode + 59) * 59) + (proOverseas2 == null ? 43 : proOverseas2.hashCode());
        String otcCn2 = getOtcCn();
        int hashCode3 = (hashCode2 * 59) + (otcCn2 == null ? 43 : otcCn2.hashCode());
        String otcOverseas2 = getOtcOverseas();
        int hashCode4 = (hashCode3 * 59) + (otcOverseas2 == null ? 43 : otcOverseas2.hashCode());
        String hbdmCn2 = getHbdmCn();
        int hashCode5 = (hashCode4 * 59) + (hbdmCn2 == null ? 43 : hbdmCn2.hashCode());
        String hbdmOverseas2 = getHbdmOverseas();
        int hashCode6 = (hashCode5 * 59) + (hbdmOverseas2 == null ? 43 : hbdmOverseas2.hashCode());
        String globalWebCn2 = getGlobalWebCn();
        int hashCode7 = (hashCode6 * 59) + (globalWebCn2 == null ? 43 : globalWebCn2.hashCode());
        String globalWebOverseas2 = getGlobalWebOverseas();
        int hashCode8 = (hashCode7 * 59) + (globalWebOverseas2 == null ? 43 : globalWebOverseas2.hashCode());
        String globalMobileCn2 = getGlobalMobileCn();
        int hashCode9 = (hashCode8 * 59) + (globalMobileCn2 == null ? 43 : globalMobileCn2.hashCode());
        String globalMobileOverseas2 = getGlobalMobileOverseas();
        int hashCode10 = (hashCode9 * 59) + (globalMobileOverseas2 == null ? 43 : globalMobileOverseas2.hashCode());
        String swapCn2 = getSwapCn();
        int hashCode11 = (hashCode10 * 59) + (swapCn2 == null ? 43 : swapCn2.hashCode());
        String swapOverseas2 = getSwapOverseas();
        int hashCode12 = (hashCode11 * 59) + (swapOverseas2 == null ? 43 : swapOverseas2.hashCode());
        String dmIndexCn2 = getDmIndexCn();
        int hashCode13 = (hashCode12 * 59) + (dmIndexCn2 == null ? 43 : dmIndexCn2.hashCode());
        String dmIndexOverseas2 = getDmIndexOverseas();
        int i12 = hashCode13 * 59;
        if (dmIndexOverseas2 != null) {
            i11 = dmIndexOverseas2.hashCode();
        }
        return i12 + i11;
    }

    public void setDmIndexCn(String str) {
        this.dmIndexCn = str;
    }

    public void setDmIndexOverseas(String str) {
        this.dmIndexOverseas = str;
    }

    public void setGlobalMobileCn(String str) {
        this.globalMobileCn = str;
    }

    public void setGlobalMobileOverseas(String str) {
        this.globalMobileOverseas = str;
    }

    public void setGlobalWebCn(String str) {
        this.globalWebCn = str;
    }

    public void setGlobalWebOverseas(String str) {
        this.globalWebOverseas = str;
    }

    public void setHbdmCn(String str) {
        this.hbdmCn = str;
    }

    public void setHbdmOverseas(String str) {
        this.hbdmOverseas = str;
    }

    public void setOtcCn(String str) {
        this.otcCn = str;
    }

    public void setOtcOverseas(String str) {
        this.otcOverseas = str;
    }

    public void setProCn(String str) {
        this.proCn = str;
    }

    public void setProOverseas(String str) {
        this.proOverseas = str;
    }

    public void setSwapCn(String str) {
        this.swapCn = str;
    }

    public void setSwapOverseas(String str) {
        this.swapOverseas = str;
    }

    public String toString() {
        return "RemoteDefaultConfig(proCn=" + getProCn() + ", proOverseas=" + getProOverseas() + ", otcCn=" + getOtcCn() + ", otcOverseas=" + getOtcOverseas() + ", hbdmCn=" + getHbdmCn() + ", hbdmOverseas=" + getHbdmOverseas() + ", globalWebCn=" + getGlobalWebCn() + ", globalWebOverseas=" + getGlobalWebOverseas() + ", globalMobileCn=" + getGlobalMobileCn() + ", globalMobileOverseas=" + getGlobalMobileOverseas() + ", swapCn=" + getSwapCn() + ", swapOverseas=" + getSwapOverseas() + ", dmIndexCn=" + getDmIndexCn() + ", dmIndexOverseas=" + getDmIndexOverseas() + ")";
    }
}
