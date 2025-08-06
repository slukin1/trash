package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class AppUrlInfo implements Serializable {
    private HashMap<String, String> baymaxchat;
    private HashMap<String, List<String>> cloudWallet;
    private HashMap<String, List<String>> huobichat;
    private HashMap<String, List<String>> huobichatWeb;
    private HashMap<String, String> kyc;
    private AppOtherContentConfig other;
    private HashMap<String, String> pledgeloanBorrow;
    private HashMap<String, String> pledgeloanOrder;
    private HashMap<String, List<String>> pool;
    private AppContentConfig share;

    /* renamed from: zendesk  reason: collision with root package name */
    private ZendeskInfo f70222zendesk;

    public static class ZendeskInfo implements Serializable {
        private List<String> appCn;
        private List<String> appOversea;
        private List<String> globalCn;
        private List<String> globalOversea;

        public boolean canEqual(Object obj) {
            return obj instanceof ZendeskInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ZendeskInfo)) {
                return false;
            }
            ZendeskInfo zendeskInfo = (ZendeskInfo) obj;
            if (!zendeskInfo.canEqual(this)) {
                return false;
            }
            List<String> globalOversea2 = getGlobalOversea();
            List<String> globalOversea3 = zendeskInfo.getGlobalOversea();
            if (globalOversea2 != null ? !globalOversea2.equals(globalOversea3) : globalOversea3 != null) {
                return false;
            }
            List<String> globalCn2 = getGlobalCn();
            List<String> globalCn3 = zendeskInfo.getGlobalCn();
            if (globalCn2 != null ? !globalCn2.equals(globalCn3) : globalCn3 != null) {
                return false;
            }
            List<String> appOversea2 = getAppOversea();
            List<String> appOversea3 = zendeskInfo.getAppOversea();
            if (appOversea2 != null ? !appOversea2.equals(appOversea3) : appOversea3 != null) {
                return false;
            }
            List<String> appCn2 = getAppCn();
            List<String> appCn3 = zendeskInfo.getAppCn();
            return appCn2 != null ? appCn2.equals(appCn3) : appCn3 == null;
        }

        public List<String> getAppCn() {
            return this.appCn;
        }

        public List<String> getAppOversea() {
            return this.appOversea;
        }

        public List<String> getGlobalCn() {
            return this.globalCn;
        }

        public List<String> getGlobalOversea() {
            return this.globalOversea;
        }

        public int hashCode() {
            List<String> globalOversea2 = getGlobalOversea();
            int i11 = 43;
            int hashCode = globalOversea2 == null ? 43 : globalOversea2.hashCode();
            List<String> globalCn2 = getGlobalCn();
            int hashCode2 = ((hashCode + 59) * 59) + (globalCn2 == null ? 43 : globalCn2.hashCode());
            List<String> appOversea2 = getAppOversea();
            int hashCode3 = (hashCode2 * 59) + (appOversea2 == null ? 43 : appOversea2.hashCode());
            List<String> appCn2 = getAppCn();
            int i12 = hashCode3 * 59;
            if (appCn2 != null) {
                i11 = appCn2.hashCode();
            }
            return i12 + i11;
        }

        public void setAppCn(List<String> list) {
            this.appCn = list;
        }

        public void setAppOversea(List<String> list) {
            this.appOversea = list;
        }

        public void setGlobalCn(List<String> list) {
            this.globalCn = list;
        }

        public void setGlobalOversea(List<String> list) {
            this.globalOversea = list;
        }

        public String toString() {
            return "AppUrlInfo.ZendeskInfo(globalOversea=" + getGlobalOversea() + ", globalCn=" + getGlobalCn() + ", appOversea=" + getAppOversea() + ", appCn=" + getAppCn() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AppUrlInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppUrlInfo)) {
            return false;
        }
        AppUrlInfo appUrlInfo = (AppUrlInfo) obj;
        if (!appUrlInfo.canEqual(this)) {
            return false;
        }
        HashMap<String, List<String>> pool2 = getPool();
        HashMap<String, List<String>> pool3 = appUrlInfo.getPool();
        if (pool2 != null ? !pool2.equals(pool3) : pool3 != null) {
            return false;
        }
        ZendeskInfo zendesk2 = getZendesk();
        ZendeskInfo zendesk3 = appUrlInfo.getZendesk();
        if (zendesk2 != null ? !zendesk2.equals(zendesk3) : zendesk3 != null) {
            return false;
        }
        AppContentConfig share2 = getShare();
        AppContentConfig share3 = appUrlInfo.getShare();
        if (share2 != null ? !share2.equals(share3) : share3 != null) {
            return false;
        }
        AppOtherContentConfig other2 = getOther();
        AppOtherContentConfig other3 = appUrlInfo.getOther();
        if (other2 != null ? !other2.equals(other3) : other3 != null) {
            return false;
        }
        HashMap<String, List<String>> huobichat2 = getHuobichat();
        HashMap<String, List<String>> huobichat3 = appUrlInfo.getHuobichat();
        if (huobichat2 != null ? !huobichat2.equals(huobichat3) : huobichat3 != null) {
            return false;
        }
        HashMap<String, List<String>> huobichatWeb2 = getHuobichatWeb();
        HashMap<String, List<String>> huobichatWeb3 = appUrlInfo.getHuobichatWeb();
        if (huobichatWeb2 != null ? !huobichatWeb2.equals(huobichatWeb3) : huobichatWeb3 != null) {
            return false;
        }
        HashMap<String, String> baymaxchat2 = getBaymaxchat();
        HashMap<String, String> baymaxchat3 = appUrlInfo.getBaymaxchat();
        if (baymaxchat2 != null ? !baymaxchat2.equals(baymaxchat3) : baymaxchat3 != null) {
            return false;
        }
        HashMap<String, String> kyc2 = getKyc();
        HashMap<String, String> kyc3 = appUrlInfo.getKyc();
        if (kyc2 != null ? !kyc2.equals(kyc3) : kyc3 != null) {
            return false;
        }
        HashMap<String, String> pledgeloanOrder2 = getPledgeloanOrder();
        HashMap<String, String> pledgeloanOrder3 = appUrlInfo.getPledgeloanOrder();
        if (pledgeloanOrder2 != null ? !pledgeloanOrder2.equals(pledgeloanOrder3) : pledgeloanOrder3 != null) {
            return false;
        }
        HashMap<String, String> pledgeloanBorrow2 = getPledgeloanBorrow();
        HashMap<String, String> pledgeloanBorrow3 = appUrlInfo.getPledgeloanBorrow();
        if (pledgeloanBorrow2 != null ? !pledgeloanBorrow2.equals(pledgeloanBorrow3) : pledgeloanBorrow3 != null) {
            return false;
        }
        HashMap<String, List<String>> cloudWallet2 = getCloudWallet();
        HashMap<String, List<String>> cloudWallet3 = appUrlInfo.getCloudWallet();
        return cloudWallet2 != null ? cloudWallet2.equals(cloudWallet3) : cloudWallet3 == null;
    }

    public HashMap<String, String> getBaymaxchat() {
        return this.baymaxchat;
    }

    public HashMap<String, List<String>> getCloudWallet() {
        return this.cloudWallet;
    }

    public HashMap<String, List<String>> getHuobichat() {
        return this.huobichat;
    }

    public HashMap<String, List<String>> getHuobichatWeb() {
        return this.huobichatWeb;
    }

    public HashMap<String, String> getKyc() {
        return this.kyc;
    }

    public AppOtherContentConfig getOther() {
        return this.other;
    }

    public HashMap<String, String> getPledgeloanBorrow() {
        return this.pledgeloanBorrow;
    }

    public HashMap<String, String> getPledgeloanOrder() {
        return this.pledgeloanOrder;
    }

    public HashMap<String, List<String>> getPool() {
        return this.pool;
    }

    public AppContentConfig getShare() {
        return this.share;
    }

    public ZendeskInfo getZendesk() {
        return this.f70222zendesk;
    }

    public int hashCode() {
        HashMap<String, List<String>> pool2 = getPool();
        int i11 = 43;
        int hashCode = pool2 == null ? 43 : pool2.hashCode();
        ZendeskInfo zendesk2 = getZendesk();
        int hashCode2 = ((hashCode + 59) * 59) + (zendesk2 == null ? 43 : zendesk2.hashCode());
        AppContentConfig share2 = getShare();
        int hashCode3 = (hashCode2 * 59) + (share2 == null ? 43 : share2.hashCode());
        AppOtherContentConfig other2 = getOther();
        int hashCode4 = (hashCode3 * 59) + (other2 == null ? 43 : other2.hashCode());
        HashMap<String, List<String>> huobichat2 = getHuobichat();
        int hashCode5 = (hashCode4 * 59) + (huobichat2 == null ? 43 : huobichat2.hashCode());
        HashMap<String, List<String>> huobichatWeb2 = getHuobichatWeb();
        int hashCode6 = (hashCode5 * 59) + (huobichatWeb2 == null ? 43 : huobichatWeb2.hashCode());
        HashMap<String, String> baymaxchat2 = getBaymaxchat();
        int hashCode7 = (hashCode6 * 59) + (baymaxchat2 == null ? 43 : baymaxchat2.hashCode());
        HashMap<String, String> kyc2 = getKyc();
        int hashCode8 = (hashCode7 * 59) + (kyc2 == null ? 43 : kyc2.hashCode());
        HashMap<String, String> pledgeloanOrder2 = getPledgeloanOrder();
        int hashCode9 = (hashCode8 * 59) + (pledgeloanOrder2 == null ? 43 : pledgeloanOrder2.hashCode());
        HashMap<String, String> pledgeloanBorrow2 = getPledgeloanBorrow();
        int hashCode10 = (hashCode9 * 59) + (pledgeloanBorrow2 == null ? 43 : pledgeloanBorrow2.hashCode());
        HashMap<String, List<String>> cloudWallet2 = getCloudWallet();
        int i12 = hashCode10 * 59;
        if (cloudWallet2 != null) {
            i11 = cloudWallet2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaymaxchat(HashMap<String, String> hashMap) {
        this.baymaxchat = hashMap;
    }

    public void setCloudWallet(HashMap<String, List<String>> hashMap) {
        this.cloudWallet = hashMap;
    }

    public void setHuobichat(HashMap<String, List<String>> hashMap) {
        this.huobichat = hashMap;
    }

    public void setHuobichatWeb(HashMap<String, List<String>> hashMap) {
        this.huobichatWeb = hashMap;
    }

    public void setKyc(HashMap<String, String> hashMap) {
        this.kyc = hashMap;
    }

    public void setOther(AppOtherContentConfig appOtherContentConfig) {
        this.other = appOtherContentConfig;
    }

    public void setPledgeloanBorrow(HashMap<String, String> hashMap) {
        this.pledgeloanBorrow = hashMap;
    }

    public void setPledgeloanOrder(HashMap<String, String> hashMap) {
        this.pledgeloanOrder = hashMap;
    }

    public void setPool(HashMap<String, List<String>> hashMap) {
        this.pool = hashMap;
    }

    public void setShare(AppContentConfig appContentConfig) {
        this.share = appContentConfig;
    }

    public void setZendesk(ZendeskInfo zendeskInfo) {
        this.f70222zendesk = zendeskInfo;
    }

    public String toString() {
        return "AppUrlInfo(pool=" + getPool() + ", zendesk=" + getZendesk() + ", share=" + getShare() + ", other=" + getOther() + ", huobichat=" + getHuobichat() + ", huobichatWeb=" + getHuobichatWeb() + ", baymaxchat=" + getBaymaxchat() + ", kyc=" + getKyc() + ", pledgeloanOrder=" + getPledgeloanOrder() + ", pledgeloanBorrow=" + getPledgeloanBorrow() + ", cloudWallet=" + getCloudWallet() + ")";
    }
}
