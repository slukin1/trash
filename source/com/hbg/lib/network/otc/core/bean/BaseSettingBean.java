package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class BaseSettingBean implements Serializable {
    private String acceptGuideLimit;
    private String balanceTradeConfig;
    private OtcBalanceConfigInfo balanceTradeConfigObj;
    private String banxaAgreementUrl;
    private String banxaSupportUrl;
    private String blueshieldIntroUrl = "";
    public String chatWsSwitch;
    public String countryLocalName;
    public List<CountryNameBean> countryNameData;
    public Boolean downgradeFundPassword;
    private String goWebDeposit;
    private String goWebVerification;
    private long hbgSlowRequestTime = 1000;
    private String krabitiSupportUrl;
    private String krabitiTerms;
    private String mercuryoAgreementUrl;
    private String mercuryoTerms;
    private String neofiAgreementUrl;
    private String newCustomServiceUrl = "https://www.baymaxchat.com/#/h5/?sceneCode=2";
    @SerializedName("orderNotSupportedTips_i18n")
    private String orderNotSupportedTips = "";
    private String simplexRequestNew;
    private String simplexTerms;
    public String vndBuyNftVisible;
    private String wsBaseUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseSettingBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseSettingBean)) {
            return false;
        }
        BaseSettingBean baseSettingBean = (BaseSettingBean) obj;
        if (!baseSettingBean.canEqual(this)) {
            return false;
        }
        String blueshieldIntroUrl2 = getBlueshieldIntroUrl();
        String blueshieldIntroUrl3 = baseSettingBean.getBlueshieldIntroUrl();
        if (blueshieldIntroUrl2 != null ? !blueshieldIntroUrl2.equals(blueshieldIntroUrl3) : blueshieldIntroUrl3 != null) {
            return false;
        }
        if (getHbgSlowRequestTime() != baseSettingBean.getHbgSlowRequestTime()) {
            return false;
        }
        String orderNotSupportedTips2 = getOrderNotSupportedTips();
        String orderNotSupportedTips3 = baseSettingBean.getOrderNotSupportedTips();
        if (orderNotSupportedTips2 != null ? !orderNotSupportedTips2.equals(orderNotSupportedTips3) : orderNotSupportedTips3 != null) {
            return false;
        }
        String wsBaseUrl2 = getWsBaseUrl();
        String wsBaseUrl3 = baseSettingBean.getWsBaseUrl();
        if (wsBaseUrl2 != null ? !wsBaseUrl2.equals(wsBaseUrl3) : wsBaseUrl3 != null) {
            return false;
        }
        String acceptGuideLimit2 = getAcceptGuideLimit();
        String acceptGuideLimit3 = baseSettingBean.getAcceptGuideLimit();
        if (acceptGuideLimit2 != null ? !acceptGuideLimit2.equals(acceptGuideLimit3) : acceptGuideLimit3 != null) {
            return false;
        }
        String goWebVerification2 = getGoWebVerification();
        String goWebVerification3 = baseSettingBean.getGoWebVerification();
        if (goWebVerification2 != null ? !goWebVerification2.equals(goWebVerification3) : goWebVerification3 != null) {
            return false;
        }
        String goWebDeposit2 = getGoWebDeposit();
        String goWebDeposit3 = baseSettingBean.getGoWebDeposit();
        if (goWebDeposit2 != null ? !goWebDeposit2.equals(goWebDeposit3) : goWebDeposit3 != null) {
            return false;
        }
        String balanceTradeConfig2 = getBalanceTradeConfig();
        String balanceTradeConfig3 = baseSettingBean.getBalanceTradeConfig();
        if (balanceTradeConfig2 != null ? !balanceTradeConfig2.equals(balanceTradeConfig3) : balanceTradeConfig3 != null) {
            return false;
        }
        OtcBalanceConfigInfo balanceTradeConfigObj2 = getBalanceTradeConfigObj();
        OtcBalanceConfigInfo balanceTradeConfigObj3 = baseSettingBean.getBalanceTradeConfigObj();
        if (balanceTradeConfigObj2 != null ? !balanceTradeConfigObj2.equals(balanceTradeConfigObj3) : balanceTradeConfigObj3 != null) {
            return false;
        }
        String newCustomServiceUrl2 = getNewCustomServiceUrl();
        String newCustomServiceUrl3 = baseSettingBean.getNewCustomServiceUrl();
        if (newCustomServiceUrl2 != null ? !newCustomServiceUrl2.equals(newCustomServiceUrl3) : newCustomServiceUrl3 != null) {
            return false;
        }
        String neofiAgreementUrl2 = getNeofiAgreementUrl();
        String neofiAgreementUrl3 = baseSettingBean.getNeofiAgreementUrl();
        if (neofiAgreementUrl2 != null ? !neofiAgreementUrl2.equals(neofiAgreementUrl3) : neofiAgreementUrl3 != null) {
            return false;
        }
        String mercuryoAgreementUrl2 = getMercuryoAgreementUrl();
        String mercuryoAgreementUrl3 = baseSettingBean.getMercuryoAgreementUrl();
        if (mercuryoAgreementUrl2 != null ? !mercuryoAgreementUrl2.equals(mercuryoAgreementUrl3) : mercuryoAgreementUrl3 != null) {
            return false;
        }
        String mercuryoTerms2 = getMercuryoTerms();
        String mercuryoTerms3 = baseSettingBean.getMercuryoTerms();
        if (mercuryoTerms2 != null ? !mercuryoTerms2.equals(mercuryoTerms3) : mercuryoTerms3 != null) {
            return false;
        }
        String banxaAgreementUrl2 = getBanxaAgreementUrl();
        String banxaAgreementUrl3 = baseSettingBean.getBanxaAgreementUrl();
        if (banxaAgreementUrl2 != null ? !banxaAgreementUrl2.equals(banxaAgreementUrl3) : banxaAgreementUrl3 != null) {
            return false;
        }
        String simplexRequestNew2 = getSimplexRequestNew();
        String simplexRequestNew3 = baseSettingBean.getSimplexRequestNew();
        if (simplexRequestNew2 != null ? !simplexRequestNew2.equals(simplexRequestNew3) : simplexRequestNew3 != null) {
            return false;
        }
        String banxaSupportUrl2 = getBanxaSupportUrl();
        String banxaSupportUrl3 = baseSettingBean.getBanxaSupportUrl();
        if (banxaSupportUrl2 != null ? !banxaSupportUrl2.equals(banxaSupportUrl3) : banxaSupportUrl3 != null) {
            return false;
        }
        String simplexTerms2 = getSimplexTerms();
        String simplexTerms3 = baseSettingBean.getSimplexTerms();
        if (simplexTerms2 != null ? !simplexTerms2.equals(simplexTerms3) : simplexTerms3 != null) {
            return false;
        }
        String krabitiTerms2 = getKrabitiTerms();
        String krabitiTerms3 = baseSettingBean.getKrabitiTerms();
        if (krabitiTerms2 != null ? !krabitiTerms2.equals(krabitiTerms3) : krabitiTerms3 != null) {
            return false;
        }
        String krabitiSupportUrl2 = getKrabitiSupportUrl();
        String krabitiSupportUrl3 = baseSettingBean.getKrabitiSupportUrl();
        if (krabitiSupportUrl2 != null ? !krabitiSupportUrl2.equals(krabitiSupportUrl3) : krabitiSupportUrl3 != null) {
            return false;
        }
        String chatWsSwitch2 = getChatWsSwitch();
        String chatWsSwitch3 = baseSettingBean.getChatWsSwitch();
        if (chatWsSwitch2 != null ? !chatWsSwitch2.equals(chatWsSwitch3) : chatWsSwitch3 != null) {
            return false;
        }
        List<CountryNameBean> countryNameData2 = getCountryNameData();
        List<CountryNameBean> countryNameData3 = baseSettingBean.getCountryNameData();
        if (countryNameData2 != null ? !countryNameData2.equals(countryNameData3) : countryNameData3 != null) {
            return false;
        }
        String countryLocalName2 = getCountryLocalName();
        String countryLocalName3 = baseSettingBean.getCountryLocalName();
        if (countryLocalName2 != null ? !countryLocalName2.equals(countryLocalName3) : countryLocalName3 != null) {
            return false;
        }
        String vndBuyNftVisible2 = getVndBuyNftVisible();
        String vndBuyNftVisible3 = baseSettingBean.getVndBuyNftVisible();
        if (vndBuyNftVisible2 != null ? !vndBuyNftVisible2.equals(vndBuyNftVisible3) : vndBuyNftVisible3 != null) {
            return false;
        }
        Boolean downgradeFundPassword2 = getDowngradeFundPassword();
        Boolean downgradeFundPassword3 = baseSettingBean.getDowngradeFundPassword();
        return downgradeFundPassword2 != null ? downgradeFundPassword2.equals(downgradeFundPassword3) : downgradeFundPassword3 == null;
    }

    public String getAcceptGuideLimit() {
        return this.acceptGuideLimit;
    }

    public String getBalanceTradeConfig() {
        return this.balanceTradeConfig;
    }

    public OtcBalanceConfigInfo getBalanceTradeConfigObj() {
        return this.balanceTradeConfigObj;
    }

    public String getBanxaAgreementUrl() {
        return this.banxaAgreementUrl;
    }

    public String getBanxaSupportUrl() {
        return this.banxaSupportUrl;
    }

    public String getBlueshieldIntroUrl() {
        return this.blueshieldIntroUrl;
    }

    public String getChatWsSwitch() {
        return this.chatWsSwitch;
    }

    public String getCountryLocalName() {
        return this.countryLocalName;
    }

    public List<CountryNameBean> getCountryNameData() {
        return this.countryNameData;
    }

    public Boolean getDowngradeFundPassword() {
        return this.downgradeFundPassword;
    }

    public String getGoWebDeposit() {
        return this.goWebDeposit;
    }

    public String getGoWebVerification() {
        return this.goWebVerification;
    }

    public long getHbgSlowRequestTime() {
        return this.hbgSlowRequestTime;
    }

    public String getKrabitiSupportUrl() {
        return this.krabitiSupportUrl;
    }

    public String getKrabitiTerms() {
        return this.krabitiTerms;
    }

    public String getMercuryoAgreementUrl() {
        return this.mercuryoAgreementUrl;
    }

    public String getMercuryoTerms() {
        return this.mercuryoTerms;
    }

    public String getNeofiAgreementUrl() {
        return this.neofiAgreementUrl;
    }

    public String getNewCustomServiceUrl() {
        return this.newCustomServiceUrl;
    }

    public String getOrderNotSupportedTips() {
        return this.orderNotSupportedTips;
    }

    public String getSimplexRequestNew() {
        return this.simplexRequestNew;
    }

    public String getSimplexTerms() {
        return this.simplexTerms;
    }

    public String getVndBuyNftVisible() {
        return this.vndBuyNftVisible;
    }

    public String getWsBaseUrl() {
        return this.wsBaseUrl;
    }

    public int hashCode() {
        String blueshieldIntroUrl2 = getBlueshieldIntroUrl();
        int i11 = 43;
        int hashCode = blueshieldIntroUrl2 == null ? 43 : blueshieldIntroUrl2.hashCode();
        long hbgSlowRequestTime2 = getHbgSlowRequestTime();
        int i12 = ((hashCode + 59) * 59) + ((int) (hbgSlowRequestTime2 ^ (hbgSlowRequestTime2 >>> 32)));
        String orderNotSupportedTips2 = getOrderNotSupportedTips();
        int hashCode2 = (i12 * 59) + (orderNotSupportedTips2 == null ? 43 : orderNotSupportedTips2.hashCode());
        String wsBaseUrl2 = getWsBaseUrl();
        int hashCode3 = (hashCode2 * 59) + (wsBaseUrl2 == null ? 43 : wsBaseUrl2.hashCode());
        String acceptGuideLimit2 = getAcceptGuideLimit();
        int hashCode4 = (hashCode3 * 59) + (acceptGuideLimit2 == null ? 43 : acceptGuideLimit2.hashCode());
        String goWebVerification2 = getGoWebVerification();
        int hashCode5 = (hashCode4 * 59) + (goWebVerification2 == null ? 43 : goWebVerification2.hashCode());
        String goWebDeposit2 = getGoWebDeposit();
        int hashCode6 = (hashCode5 * 59) + (goWebDeposit2 == null ? 43 : goWebDeposit2.hashCode());
        String balanceTradeConfig2 = getBalanceTradeConfig();
        int hashCode7 = (hashCode6 * 59) + (balanceTradeConfig2 == null ? 43 : balanceTradeConfig2.hashCode());
        OtcBalanceConfigInfo balanceTradeConfigObj2 = getBalanceTradeConfigObj();
        int hashCode8 = (hashCode7 * 59) + (balanceTradeConfigObj2 == null ? 43 : balanceTradeConfigObj2.hashCode());
        String newCustomServiceUrl2 = getNewCustomServiceUrl();
        int hashCode9 = (hashCode8 * 59) + (newCustomServiceUrl2 == null ? 43 : newCustomServiceUrl2.hashCode());
        String neofiAgreementUrl2 = getNeofiAgreementUrl();
        int hashCode10 = (hashCode9 * 59) + (neofiAgreementUrl2 == null ? 43 : neofiAgreementUrl2.hashCode());
        String mercuryoAgreementUrl2 = getMercuryoAgreementUrl();
        int hashCode11 = (hashCode10 * 59) + (mercuryoAgreementUrl2 == null ? 43 : mercuryoAgreementUrl2.hashCode());
        String mercuryoTerms2 = getMercuryoTerms();
        int hashCode12 = (hashCode11 * 59) + (mercuryoTerms2 == null ? 43 : mercuryoTerms2.hashCode());
        String banxaAgreementUrl2 = getBanxaAgreementUrl();
        int hashCode13 = (hashCode12 * 59) + (banxaAgreementUrl2 == null ? 43 : banxaAgreementUrl2.hashCode());
        String simplexRequestNew2 = getSimplexRequestNew();
        int hashCode14 = (hashCode13 * 59) + (simplexRequestNew2 == null ? 43 : simplexRequestNew2.hashCode());
        String banxaSupportUrl2 = getBanxaSupportUrl();
        int hashCode15 = (hashCode14 * 59) + (banxaSupportUrl2 == null ? 43 : banxaSupportUrl2.hashCode());
        String simplexTerms2 = getSimplexTerms();
        int hashCode16 = (hashCode15 * 59) + (simplexTerms2 == null ? 43 : simplexTerms2.hashCode());
        String krabitiTerms2 = getKrabitiTerms();
        int hashCode17 = (hashCode16 * 59) + (krabitiTerms2 == null ? 43 : krabitiTerms2.hashCode());
        String krabitiSupportUrl2 = getKrabitiSupportUrl();
        int hashCode18 = (hashCode17 * 59) + (krabitiSupportUrl2 == null ? 43 : krabitiSupportUrl2.hashCode());
        String chatWsSwitch2 = getChatWsSwitch();
        int hashCode19 = (hashCode18 * 59) + (chatWsSwitch2 == null ? 43 : chatWsSwitch2.hashCode());
        List<CountryNameBean> countryNameData2 = getCountryNameData();
        int hashCode20 = (hashCode19 * 59) + (countryNameData2 == null ? 43 : countryNameData2.hashCode());
        String countryLocalName2 = getCountryLocalName();
        int hashCode21 = (hashCode20 * 59) + (countryLocalName2 == null ? 43 : countryLocalName2.hashCode());
        String vndBuyNftVisible2 = getVndBuyNftVisible();
        int hashCode22 = (hashCode21 * 59) + (vndBuyNftVisible2 == null ? 43 : vndBuyNftVisible2.hashCode());
        Boolean downgradeFundPassword2 = getDowngradeFundPassword();
        int i13 = hashCode22 * 59;
        if (downgradeFundPassword2 != null) {
            i11 = downgradeFundPassword2.hashCode();
        }
        return i13 + i11;
    }

    public void setAcceptGuideLimit(String str) {
        this.acceptGuideLimit = str;
    }

    public void setBalanceTradeConfig(String str) {
        this.balanceTradeConfig = str;
    }

    public void setBalanceTradeConfigObj(OtcBalanceConfigInfo otcBalanceConfigInfo) {
        this.balanceTradeConfigObj = otcBalanceConfigInfo;
    }

    public void setBanxaAgreementUrl(String str) {
        this.banxaAgreementUrl = str;
    }

    public void setBanxaSupportUrl(String str) {
        this.banxaSupportUrl = str;
    }

    public void setBlueshieldIntroUrl(String str) {
        this.blueshieldIntroUrl = str;
    }

    public void setChatWsSwitch(String str) {
        this.chatWsSwitch = str;
    }

    public void setCountryLocalName(String str) {
        this.countryLocalName = str;
    }

    public void setCountryNameData(List<CountryNameBean> list) {
        this.countryNameData = list;
    }

    public void setDowngradeFundPassword(Boolean bool) {
        this.downgradeFundPassword = bool;
    }

    public void setGoWebDeposit(String str) {
        this.goWebDeposit = str;
    }

    public void setGoWebVerification(String str) {
        this.goWebVerification = str;
    }

    public void setHbgSlowRequestTime(long j11) {
        this.hbgSlowRequestTime = j11;
    }

    public void setKrabitiSupportUrl(String str) {
        this.krabitiSupportUrl = str;
    }

    public void setKrabitiTerms(String str) {
        this.krabitiTerms = str;
    }

    public void setMercuryoAgreementUrl(String str) {
        this.mercuryoAgreementUrl = str;
    }

    public void setMercuryoTerms(String str) {
        this.mercuryoTerms = str;
    }

    public void setNeofiAgreementUrl(String str) {
        this.neofiAgreementUrl = str;
    }

    public void setNewCustomServiceUrl(String str) {
        this.newCustomServiceUrl = str;
    }

    public void setOrderNotSupportedTips(String str) {
        this.orderNotSupportedTips = str;
    }

    public void setSimplexRequestNew(String str) {
        this.simplexRequestNew = str;
    }

    public void setSimplexTerms(String str) {
        this.simplexTerms = str;
    }

    public void setVndBuyNftVisible(String str) {
        this.vndBuyNftVisible = str;
    }

    public void setWsBaseUrl(String str) {
        this.wsBaseUrl = str;
    }

    public String toString() {
        return "BaseSettingBean(blueshieldIntroUrl=" + getBlueshieldIntroUrl() + ", hbgSlowRequestTime=" + getHbgSlowRequestTime() + ", orderNotSupportedTips=" + getOrderNotSupportedTips() + ", wsBaseUrl=" + getWsBaseUrl() + ", acceptGuideLimit=" + getAcceptGuideLimit() + ", goWebVerification=" + getGoWebVerification() + ", goWebDeposit=" + getGoWebDeposit() + ", balanceTradeConfig=" + getBalanceTradeConfig() + ", balanceTradeConfigObj=" + getBalanceTradeConfigObj() + ", newCustomServiceUrl=" + getNewCustomServiceUrl() + ", neofiAgreementUrl=" + getNeofiAgreementUrl() + ", mercuryoAgreementUrl=" + getMercuryoAgreementUrl() + ", mercuryoTerms=" + getMercuryoTerms() + ", banxaAgreementUrl=" + getBanxaAgreementUrl() + ", simplexRequestNew=" + getSimplexRequestNew() + ", banxaSupportUrl=" + getBanxaSupportUrl() + ", simplexTerms=" + getSimplexTerms() + ", krabitiTerms=" + getKrabitiTerms() + ", krabitiSupportUrl=" + getKrabitiSupportUrl() + ", chatWsSwitch=" + getChatWsSwitch() + ", countryNameData=" + getCountryNameData() + ", countryLocalName=" + getCountryLocalName() + ", vndBuyNftVisible=" + getVndBuyNftVisible() + ", downgradeFundPassword=" + getDowngradeFundPassword() + ")";
    }
}
