package com.huobi.flutter;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class PlatformConfig implements Serializable {
    private static final long serialVersionUID = -1963537208783603500L;
    @SerializedName("android_status_bar_height")
    private int androidStatusBarHeight;
    @SerializedName("canary")
    private String canary;
    @SerializedName("contract_base_url")
    private String contractBaseUrl;
    @SerializedName("contract_h5_url")
    private String contractH5Url;
    @SerializedName("currency_character")
    public String currencyCharacter;
    @SerializedName("currency_unit")
    private String currencyUnit;
    @SerializedName("dm_token")
    private String dmToken;
    @SerializedName("dynamic_strings")
    private Map<String, String> dynamicStrings;
    @SerializedName("global_base_url")
    private String globalBaseUrl;
    @SerializedName("global_hb_url")
    private String globalHBUrl;
    @SerializedName("global_inst_url")
    private String globalInstUrl;
    @SerializedName("global_otc_url")
    private String globalOtcUrl;
    @SerializedName("global_web_url")
    private String globalWebUrl;
    @SerializedName("global_zendesk_domain")
    private String globalZendeskDomain;
    @SerializedName("hb_uc_ua")
    private String hbUcUa;
    @SerializedName("inst_token")
    private String instToken;
    @SerializedName("internal_style")
    private String internalStyle;
    @SerializedName("country_id")
    private int ipCountry;
    @SerializedName("is_china_user")
    private boolean isChinaUser;
    @SerializedName("HT_upgrade_state")
    private Boolean isHtUpgradeState;
    @SerializedName("is_in_review")
    private boolean isInReview;
    @SerializedName("is_lite")
    private boolean isLite;
    @SerializedName("is_new_homepage")
    private Boolean isNewHomepage;
    @SerializedName("is_normal_display")
    private boolean isNormalDisplay;
    @SerializedName("is_online_network")
    private boolean isOnlineNetwork;
    @SerializedName("is_red_rise")
    private boolean isRedRise;
    @SerializedName("is_sub_account")
    private boolean isSubAccount;
    @SerializedName("is_switch11_open")
    private boolean isSwitch11Open;
    @SerializedName("is_switch27_open")
    private boolean isSwitch27Open;
    @SerializedName("kyc_token")
    private String kycToken;
    @SerializedName("global_kyc_url")
    private String kycUrl;
    @SerializedName("global_kyc_web_url")
    private String kycWebUrl;
    @SerializedName("language_env")
    private String languageEnv;
    @SerializedName("language_env_header")
    private String languageEnvHeader;
    @SerializedName("option_base_url")
    private String optionBaseUrl;
    @SerializedName("otc_token")
    private String otcToken;
    @SerializedName("php_token")
    private String phpToken;
    @SerializedName("pro_base_url")
    private String proBaseUrl;
    @SerializedName("pro_socket_url")
    private String proSocketUrl;
    @SerializedName("pro_token")
    private String proToken;
    @SerializedName("proxy_host")
    private String proxyHost;
    @SerializedName("risk_base_url")
    private String riskBaseUrl;
    @SerializedName("route_name")
    private String routeName;
    @SerializedName("swap_base_url")
    private String swapBaseUrl;
    @SerializedName("travel_rule_url")
    private String travelRuleUrl;
    @SerializedName("uc_base_url")
    private String ucBaseUrl;
    @SerializedName("uc_token")
    private String ucToken;
    @SerializedName("uid")
    private String uid;
    @SerializedName("user_agent")
    private String userAgent;
    private String uuid;
    @SerializedName("v_token")
    private String vToken;
    @SerializedName("version_code")
    private String versionCode;
    @SerializedName("version_name")
    private String versionName;
    @SerializedName("web_host")
    private String webHost;
    @SerializedName("zendesk_locale_str")
    private String zendeskLocaleStr;

    public boolean canEqual(Object obj) {
        return obj instanceof PlatformConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlatformConfig)) {
            return false;
        }
        PlatformConfig platformConfig = (PlatformConfig) obj;
        if (!platformConfig.canEqual(this)) {
            return false;
        }
        String routeName2 = getRouteName();
        String routeName3 = platformConfig.getRouteName();
        if (routeName2 != null ? !routeName2.equals(routeName3) : routeName3 != null) {
            return false;
        }
        String globalBaseUrl2 = getGlobalBaseUrl();
        String globalBaseUrl3 = platformConfig.getGlobalBaseUrl();
        if (globalBaseUrl2 != null ? !globalBaseUrl2.equals(globalBaseUrl3) : globalBaseUrl3 != null) {
            return false;
        }
        String proBaseUrl2 = getProBaseUrl();
        String proBaseUrl3 = platformConfig.getProBaseUrl();
        if (proBaseUrl2 != null ? !proBaseUrl2.equals(proBaseUrl3) : proBaseUrl3 != null) {
            return false;
        }
        String hbUcUa2 = getHbUcUa();
        String hbUcUa3 = platformConfig.getHbUcUa();
        if (hbUcUa2 != null ? !hbUcUa2.equals(hbUcUa3) : hbUcUa3 != null) {
            return false;
        }
        String ucBaseUrl2 = getUcBaseUrl();
        String ucBaseUrl3 = platformConfig.getUcBaseUrl();
        if (ucBaseUrl2 != null ? !ucBaseUrl2.equals(ucBaseUrl3) : ucBaseUrl3 != null) {
            return false;
        }
        String globalInstUrl2 = getGlobalInstUrl();
        String globalInstUrl3 = platformConfig.getGlobalInstUrl();
        if (globalInstUrl2 != null ? !globalInstUrl2.equals(globalInstUrl3) : globalInstUrl3 != null) {
            return false;
        }
        String contractBaseUrl2 = getContractBaseUrl();
        String contractBaseUrl3 = platformConfig.getContractBaseUrl();
        if (contractBaseUrl2 != null ? !contractBaseUrl2.equals(contractBaseUrl3) : contractBaseUrl3 != null) {
            return false;
        }
        String swapBaseUrl2 = getSwapBaseUrl();
        String swapBaseUrl3 = platformConfig.getSwapBaseUrl();
        if (swapBaseUrl2 != null ? !swapBaseUrl2.equals(swapBaseUrl3) : swapBaseUrl3 != null) {
            return false;
        }
        String optionBaseUrl2 = getOptionBaseUrl();
        String optionBaseUrl3 = platformConfig.getOptionBaseUrl();
        if (optionBaseUrl2 != null ? !optionBaseUrl2.equals(optionBaseUrl3) : optionBaseUrl3 != null) {
            return false;
        }
        String riskBaseUrl2 = getRiskBaseUrl();
        String riskBaseUrl3 = platformConfig.getRiskBaseUrl();
        if (riskBaseUrl2 != null ? !riskBaseUrl2.equals(riskBaseUrl3) : riskBaseUrl3 != null) {
            return false;
        }
        String contractH5Url2 = getContractH5Url();
        String contractH5Url3 = platformConfig.getContractH5Url();
        if (contractH5Url2 != null ? !contractH5Url2.equals(contractH5Url3) : contractH5Url3 != null) {
            return false;
        }
        String proSocketUrl2 = getProSocketUrl();
        String proSocketUrl3 = platformConfig.getProSocketUrl();
        if (proSocketUrl2 != null ? !proSocketUrl2.equals(proSocketUrl3) : proSocketUrl3 != null) {
            return false;
        }
        String travelRuleUrl2 = getTravelRuleUrl();
        String travelRuleUrl3 = platformConfig.getTravelRuleUrl();
        if (travelRuleUrl2 != null ? !travelRuleUrl2.equals(travelRuleUrl3) : travelRuleUrl3 != null) {
            return false;
        }
        String languageEnv2 = getLanguageEnv();
        String languageEnv3 = platformConfig.getLanguageEnv();
        if (languageEnv2 != null ? !languageEnv2.equals(languageEnv3) : languageEnv3 != null) {
            return false;
        }
        String languageEnvHeader2 = getLanguageEnvHeader();
        String languageEnvHeader3 = platformConfig.getLanguageEnvHeader();
        if (languageEnvHeader2 != null ? !languageEnvHeader2.equals(languageEnvHeader3) : languageEnvHeader3 != null) {
            return false;
        }
        String zendeskLocaleStr2 = getZendeskLocaleStr();
        String zendeskLocaleStr3 = platformConfig.getZendeskLocaleStr();
        if (zendeskLocaleStr2 != null ? !zendeskLocaleStr2.equals(zendeskLocaleStr3) : zendeskLocaleStr3 != null) {
            return false;
        }
        Map<String, String> dynamicStrings2 = getDynamicStrings();
        Map<String, String> dynamicStrings3 = platformConfig.getDynamicStrings();
        if (dynamicStrings2 != null ? !dynamicStrings2.equals(dynamicStrings3) : dynamicStrings3 != null) {
            return false;
        }
        String internalStyle2 = getInternalStyle();
        String internalStyle3 = platformConfig.getInternalStyle();
        if (internalStyle2 != null ? !internalStyle2.equals(internalStyle3) : internalStyle3 != null) {
            return false;
        }
        String versionName2 = getVersionName();
        String versionName3 = platformConfig.getVersionName();
        if (versionName2 != null ? !versionName2.equals(versionName3) : versionName3 != null) {
            return false;
        }
        String versionCode2 = getVersionCode();
        String versionCode3 = platformConfig.getVersionCode();
        if (versionCode2 != null ? !versionCode2.equals(versionCode3) : versionCode3 != null) {
            return false;
        }
        if (isOnlineNetwork() != platformConfig.isOnlineNetwork() || getAndroidStatusBarHeight() != platformConfig.getAndroidStatusBarHeight()) {
            return false;
        }
        String userAgent2 = getUserAgent();
        String userAgent3 = platformConfig.getUserAgent();
        if (userAgent2 != null ? !userAgent2.equals(userAgent3) : userAgent3 != null) {
            return false;
        }
        String globalWebUrl2 = getGlobalWebUrl();
        String globalWebUrl3 = platformConfig.getGlobalWebUrl();
        if (globalWebUrl2 != null ? !globalWebUrl2.equals(globalWebUrl3) : globalWebUrl3 != null) {
            return false;
        }
        String kycWebUrl2 = getKycWebUrl();
        String kycWebUrl3 = platformConfig.getKycWebUrl();
        if (kycWebUrl2 != null ? !kycWebUrl2.equals(kycWebUrl3) : kycWebUrl3 != null) {
            return false;
        }
        if (isLite() != platformConfig.isLite() || isNormalDisplay() != platformConfig.isNormalDisplay() || isSwitch11Open() != platformConfig.isSwitch11Open()) {
            return false;
        }
        String webHost2 = getWebHost();
        String webHost3 = platformConfig.getWebHost();
        if (webHost2 != null ? !webHost2.equals(webHost3) : webHost3 != null) {
            return false;
        }
        String proToken2 = getProToken();
        String proToken3 = platformConfig.getProToken();
        if (proToken2 != null ? !proToken2.equals(proToken3) : proToken3 != null) {
            return false;
        }
        String dmToken2 = getDmToken();
        String dmToken3 = platformConfig.getDmToken();
        if (dmToken2 != null ? !dmToken2.equals(dmToken3) : dmToken3 != null) {
            return false;
        }
        String ucToken2 = getUcToken();
        String ucToken3 = platformConfig.getUcToken();
        if (ucToken2 != null ? !ucToken2.equals(ucToken3) : ucToken3 != null) {
            return false;
        }
        String uuid2 = getUuid();
        String uuid3 = platformConfig.getUuid();
        if (uuid2 != null ? !uuid2.equals(uuid3) : uuid3 != null) {
            return false;
        }
        String vToken2 = getVToken();
        String vToken3 = platformConfig.getVToken();
        if (vToken2 != null ? !vToken2.equals(vToken3) : vToken3 != null) {
            return false;
        }
        String proxyHost2 = getProxyHost();
        String proxyHost3 = platformConfig.getProxyHost();
        if (proxyHost2 != null ? !proxyHost2.equals(proxyHost3) : proxyHost3 != null) {
            return false;
        }
        if (isRedRise() != platformConfig.isRedRise() || isChinaUser() != platformConfig.isChinaUser()) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = platformConfig.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String globalZendeskDomain2 = getGlobalZendeskDomain();
        String globalZendeskDomain3 = platformConfig.getGlobalZendeskDomain();
        if (globalZendeskDomain2 != null ? !globalZendeskDomain2.equals(globalZendeskDomain3) : globalZendeskDomain3 != null) {
            return false;
        }
        String currencyUnit2 = getCurrencyUnit();
        String currencyUnit3 = platformConfig.getCurrencyUnit();
        if (currencyUnit2 != null ? !currencyUnit2.equals(currencyUnit3) : currencyUnit3 != null) {
            return false;
        }
        String currencyCharacter2 = getCurrencyCharacter();
        String currencyCharacter3 = platformConfig.getCurrencyCharacter();
        if (currencyCharacter2 != null ? !currencyCharacter2.equals(currencyCharacter3) : currencyCharacter3 != null) {
            return false;
        }
        if (isSwitch27Open() != platformConfig.isSwitch27Open()) {
            return false;
        }
        String globalHBUrl2 = getGlobalHBUrl();
        String globalHBUrl3 = platformConfig.getGlobalHBUrl();
        if (globalHBUrl2 != null ? !globalHBUrl2.equals(globalHBUrl3) : globalHBUrl3 != null) {
            return false;
        }
        String globalOtcUrl2 = getGlobalOtcUrl();
        String globalOtcUrl3 = platformConfig.getGlobalOtcUrl();
        if (globalOtcUrl2 != null ? !globalOtcUrl2.equals(globalOtcUrl3) : globalOtcUrl3 != null) {
            return false;
        }
        String kycUrl2 = getKycUrl();
        String kycUrl3 = platformConfig.getKycUrl();
        if (kycUrl2 != null ? !kycUrl2.equals(kycUrl3) : kycUrl3 != null) {
            return false;
        }
        String otcToken2 = getOtcToken();
        String otcToken3 = platformConfig.getOtcToken();
        if (otcToken2 != null ? !otcToken2.equals(otcToken3) : otcToken3 != null) {
            return false;
        }
        String kycToken2 = getKycToken();
        String kycToken3 = platformConfig.getKycToken();
        if (kycToken2 != null ? !kycToken2.equals(kycToken3) : kycToken3 != null) {
            return false;
        }
        String instToken2 = getInstToken();
        String instToken3 = platformConfig.getInstToken();
        if (instToken2 != null ? !instToken2.equals(instToken3) : instToken3 != null) {
            return false;
        }
        String phpToken2 = getPhpToken();
        String phpToken3 = platformConfig.getPhpToken();
        if (phpToken2 != null ? !phpToken2.equals(phpToken3) : phpToken3 != null) {
            return false;
        }
        if (isInReview() != platformConfig.isInReview() || isSubAccount() != platformConfig.isSubAccount() || getIpCountry() != platformConfig.getIpCountry()) {
            return false;
        }
        String canary2 = getCanary();
        String canary3 = platformConfig.getCanary();
        if (canary2 != null ? !canary2.equals(canary3) : canary3 != null) {
            return false;
        }
        Boolean isNewHomepage2 = getIsNewHomepage();
        Boolean isNewHomepage3 = platformConfig.getIsNewHomepage();
        if (isNewHomepage2 != null ? !isNewHomepage2.equals(isNewHomepage3) : isNewHomepage3 != null) {
            return false;
        }
        Boolean isHtUpgradeState2 = getIsHtUpgradeState();
        Boolean isHtUpgradeState3 = platformConfig.getIsHtUpgradeState();
        return isHtUpgradeState2 != null ? isHtUpgradeState2.equals(isHtUpgradeState3) : isHtUpgradeState3 == null;
    }

    public int getAndroidStatusBarHeight() {
        return this.androidStatusBarHeight;
    }

    public String getCanary() {
        return this.canary;
    }

    public String getContractBaseUrl() {
        return this.contractBaseUrl;
    }

    public String getContractH5Url() {
        return this.contractH5Url;
    }

    public String getCurrencyCharacter() {
        return this.currencyCharacter;
    }

    public String getCurrencyUnit() {
        return this.currencyUnit;
    }

    public String getDmToken() {
        return this.dmToken;
    }

    public Map<String, String> getDynamicStrings() {
        return this.dynamicStrings;
    }

    public String getGlobalBaseUrl() {
        return this.globalBaseUrl;
    }

    public String getGlobalHBUrl() {
        return this.globalHBUrl;
    }

    public String getGlobalInstUrl() {
        return this.globalInstUrl;
    }

    public String getGlobalOtcUrl() {
        return this.globalOtcUrl;
    }

    public String getGlobalWebUrl() {
        return this.globalWebUrl;
    }

    public String getGlobalZendeskDomain() {
        return this.globalZendeskDomain;
    }

    public String getHbUcUa() {
        return this.hbUcUa;
    }

    public String getInstToken() {
        return this.instToken;
    }

    public String getInternalStyle() {
        return this.internalStyle;
    }

    public int getIpCountry() {
        return this.ipCountry;
    }

    public Boolean getIsHtUpgradeState() {
        return this.isHtUpgradeState;
    }

    public Boolean getIsNewHomepage() {
        return this.isNewHomepage;
    }

    public String getKycToken() {
        return this.kycToken;
    }

    public String getKycUrl() {
        return this.kycUrl;
    }

    public String getKycWebUrl() {
        return this.kycWebUrl;
    }

    public String getLanguageEnv() {
        return this.languageEnv;
    }

    public String getLanguageEnvHeader() {
        return this.languageEnvHeader;
    }

    public String getOptionBaseUrl() {
        return this.optionBaseUrl;
    }

    public String getOtcToken() {
        return this.otcToken;
    }

    public String getPhpToken() {
        return this.phpToken;
    }

    public String getProBaseUrl() {
        return this.proBaseUrl;
    }

    public String getProSocketUrl() {
        return this.proSocketUrl;
    }

    public String getProToken() {
        return this.proToken;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public String getRiskBaseUrl() {
        return this.riskBaseUrl;
    }

    public String getRouteName() {
        return this.routeName;
    }

    public String getSwapBaseUrl() {
        return this.swapBaseUrl;
    }

    public String getTravelRuleUrl() {
        return this.travelRuleUrl;
    }

    public String getUcBaseUrl() {
        return this.ucBaseUrl;
    }

    public String getUcToken() {
        return this.ucToken;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVToken() {
        return this.vToken;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getWebHost() {
        return this.webHost;
    }

    public String getZendeskLocaleStr() {
        return this.zendeskLocaleStr;
    }

    public int hashCode() {
        String routeName2 = getRouteName();
        int i11 = 43;
        int hashCode = routeName2 == null ? 43 : routeName2.hashCode();
        String globalBaseUrl2 = getGlobalBaseUrl();
        int hashCode2 = ((hashCode + 59) * 59) + (globalBaseUrl2 == null ? 43 : globalBaseUrl2.hashCode());
        String proBaseUrl2 = getProBaseUrl();
        int hashCode3 = (hashCode2 * 59) + (proBaseUrl2 == null ? 43 : proBaseUrl2.hashCode());
        String hbUcUa2 = getHbUcUa();
        int hashCode4 = (hashCode3 * 59) + (hbUcUa2 == null ? 43 : hbUcUa2.hashCode());
        String ucBaseUrl2 = getUcBaseUrl();
        int hashCode5 = (hashCode4 * 59) + (ucBaseUrl2 == null ? 43 : ucBaseUrl2.hashCode());
        String globalInstUrl2 = getGlobalInstUrl();
        int hashCode6 = (hashCode5 * 59) + (globalInstUrl2 == null ? 43 : globalInstUrl2.hashCode());
        String contractBaseUrl2 = getContractBaseUrl();
        int hashCode7 = (hashCode6 * 59) + (contractBaseUrl2 == null ? 43 : contractBaseUrl2.hashCode());
        String swapBaseUrl2 = getSwapBaseUrl();
        int hashCode8 = (hashCode7 * 59) + (swapBaseUrl2 == null ? 43 : swapBaseUrl2.hashCode());
        String optionBaseUrl2 = getOptionBaseUrl();
        int hashCode9 = (hashCode8 * 59) + (optionBaseUrl2 == null ? 43 : optionBaseUrl2.hashCode());
        String riskBaseUrl2 = getRiskBaseUrl();
        int hashCode10 = (hashCode9 * 59) + (riskBaseUrl2 == null ? 43 : riskBaseUrl2.hashCode());
        String contractH5Url2 = getContractH5Url();
        int hashCode11 = (hashCode10 * 59) + (contractH5Url2 == null ? 43 : contractH5Url2.hashCode());
        String proSocketUrl2 = getProSocketUrl();
        int hashCode12 = (hashCode11 * 59) + (proSocketUrl2 == null ? 43 : proSocketUrl2.hashCode());
        String travelRuleUrl2 = getTravelRuleUrl();
        int hashCode13 = (hashCode12 * 59) + (travelRuleUrl2 == null ? 43 : travelRuleUrl2.hashCode());
        String languageEnv2 = getLanguageEnv();
        int hashCode14 = (hashCode13 * 59) + (languageEnv2 == null ? 43 : languageEnv2.hashCode());
        String languageEnvHeader2 = getLanguageEnvHeader();
        int hashCode15 = (hashCode14 * 59) + (languageEnvHeader2 == null ? 43 : languageEnvHeader2.hashCode());
        String zendeskLocaleStr2 = getZendeskLocaleStr();
        int hashCode16 = (hashCode15 * 59) + (zendeskLocaleStr2 == null ? 43 : zendeskLocaleStr2.hashCode());
        Map<String, String> dynamicStrings2 = getDynamicStrings();
        int hashCode17 = (hashCode16 * 59) + (dynamicStrings2 == null ? 43 : dynamicStrings2.hashCode());
        String internalStyle2 = getInternalStyle();
        int hashCode18 = (hashCode17 * 59) + (internalStyle2 == null ? 43 : internalStyle2.hashCode());
        String versionName2 = getVersionName();
        int hashCode19 = (hashCode18 * 59) + (versionName2 == null ? 43 : versionName2.hashCode());
        String versionCode2 = getVersionCode();
        int i12 = 79;
        int hashCode20 = (((((hashCode19 * 59) + (versionCode2 == null ? 43 : versionCode2.hashCode())) * 59) + (isOnlineNetwork() ? 79 : 97)) * 59) + getAndroidStatusBarHeight();
        String userAgent2 = getUserAgent();
        int hashCode21 = (hashCode20 * 59) + (userAgent2 == null ? 43 : userAgent2.hashCode());
        String globalWebUrl2 = getGlobalWebUrl();
        int hashCode22 = (hashCode21 * 59) + (globalWebUrl2 == null ? 43 : globalWebUrl2.hashCode());
        String kycWebUrl2 = getKycWebUrl();
        int hashCode23 = (((((((hashCode22 * 59) + (kycWebUrl2 == null ? 43 : kycWebUrl2.hashCode())) * 59) + (isLite() ? 79 : 97)) * 59) + (isNormalDisplay() ? 79 : 97)) * 59) + (isSwitch11Open() ? 79 : 97);
        String webHost2 = getWebHost();
        int hashCode24 = (hashCode23 * 59) + (webHost2 == null ? 43 : webHost2.hashCode());
        String proToken2 = getProToken();
        int hashCode25 = (hashCode24 * 59) + (proToken2 == null ? 43 : proToken2.hashCode());
        String dmToken2 = getDmToken();
        int hashCode26 = (hashCode25 * 59) + (dmToken2 == null ? 43 : dmToken2.hashCode());
        String ucToken2 = getUcToken();
        int hashCode27 = (hashCode26 * 59) + (ucToken2 == null ? 43 : ucToken2.hashCode());
        String uuid2 = getUuid();
        int hashCode28 = (hashCode27 * 59) + (uuid2 == null ? 43 : uuid2.hashCode());
        String vToken2 = getVToken();
        int hashCode29 = (hashCode28 * 59) + (vToken2 == null ? 43 : vToken2.hashCode());
        String proxyHost2 = getProxyHost();
        int hashCode30 = (((((hashCode29 * 59) + (proxyHost2 == null ? 43 : proxyHost2.hashCode())) * 59) + (isRedRise() ? 79 : 97)) * 59) + (isChinaUser() ? 79 : 97);
        String uid2 = getUid();
        int hashCode31 = (hashCode30 * 59) + (uid2 == null ? 43 : uid2.hashCode());
        String globalZendeskDomain2 = getGlobalZendeskDomain();
        int hashCode32 = (hashCode31 * 59) + (globalZendeskDomain2 == null ? 43 : globalZendeskDomain2.hashCode());
        String currencyUnit2 = getCurrencyUnit();
        int hashCode33 = (hashCode32 * 59) + (currencyUnit2 == null ? 43 : currencyUnit2.hashCode());
        String currencyCharacter2 = getCurrencyCharacter();
        int hashCode34 = (((hashCode33 * 59) + (currencyCharacter2 == null ? 43 : currencyCharacter2.hashCode())) * 59) + (isSwitch27Open() ? 79 : 97);
        String globalHBUrl2 = getGlobalHBUrl();
        int hashCode35 = (hashCode34 * 59) + (globalHBUrl2 == null ? 43 : globalHBUrl2.hashCode());
        String globalOtcUrl2 = getGlobalOtcUrl();
        int hashCode36 = (hashCode35 * 59) + (globalOtcUrl2 == null ? 43 : globalOtcUrl2.hashCode());
        String kycUrl2 = getKycUrl();
        int hashCode37 = (hashCode36 * 59) + (kycUrl2 == null ? 43 : kycUrl2.hashCode());
        String otcToken2 = getOtcToken();
        int hashCode38 = (hashCode37 * 59) + (otcToken2 == null ? 43 : otcToken2.hashCode());
        String kycToken2 = getKycToken();
        int hashCode39 = (hashCode38 * 59) + (kycToken2 == null ? 43 : kycToken2.hashCode());
        String instToken2 = getInstToken();
        int hashCode40 = (hashCode39 * 59) + (instToken2 == null ? 43 : instToken2.hashCode());
        String phpToken2 = getPhpToken();
        int hashCode41 = ((((hashCode40 * 59) + (phpToken2 == null ? 43 : phpToken2.hashCode())) * 59) + (isInReview() ? 79 : 97)) * 59;
        if (!isSubAccount()) {
            i12 = 97;
        }
        int ipCountry2 = ((hashCode41 + i12) * 59) + getIpCountry();
        String canary2 = getCanary();
        int hashCode42 = (ipCountry2 * 59) + (canary2 == null ? 43 : canary2.hashCode());
        Boolean isNewHomepage2 = getIsNewHomepage();
        int hashCode43 = (hashCode42 * 59) + (isNewHomepage2 == null ? 43 : isNewHomepage2.hashCode());
        Boolean isHtUpgradeState2 = getIsHtUpgradeState();
        int i13 = hashCode43 * 59;
        if (isHtUpgradeState2 != null) {
            i11 = isHtUpgradeState2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isChinaUser() {
        return this.isChinaUser;
    }

    public boolean isInReview() {
        return this.isInReview;
    }

    public boolean isLite() {
        return this.isLite;
    }

    public boolean isNormalDisplay() {
        return this.isNormalDisplay;
    }

    public boolean isOnlineNetwork() {
        return this.isOnlineNetwork;
    }

    public boolean isRedRise() {
        return this.isRedRise;
    }

    public boolean isSubAccount() {
        return this.isSubAccount;
    }

    public boolean isSwitch11Open() {
        return this.isSwitch11Open;
    }

    public boolean isSwitch27Open() {
        return this.isSwitch27Open;
    }

    public void setAndroidStatusBarHeight(int i11) {
        this.androidStatusBarHeight = i11;
    }

    public void setCanary(String str) {
        this.canary = str;
    }

    public void setChinaUser(boolean z11) {
        this.isChinaUser = z11;
    }

    public void setContractBaseUrl(String str) {
        this.contractBaseUrl = str;
    }

    public void setContractH5Url(String str) {
        this.contractH5Url = str;
    }

    public void setCurrencyCharacter(String str) {
        this.currencyCharacter = str;
    }

    public void setCurrencyUnit(String str) {
        this.currencyUnit = str;
    }

    public void setDmToken(String str) {
        this.dmToken = str;
    }

    public void setDynamicStrings(Map<String, String> map) {
        this.dynamicStrings = map;
    }

    public void setGlobalBaseUrl(String str) {
        this.globalBaseUrl = str;
    }

    public void setGlobalHBUrl(String str) {
        this.globalHBUrl = str;
    }

    public void setGlobalInstUrl(String str) {
        this.globalInstUrl = str;
    }

    public void setGlobalOtcUrl(String str) {
        this.globalOtcUrl = str;
    }

    public void setGlobalWebUrl(String str) {
        this.globalWebUrl = str;
    }

    public void setGlobalZendeskDomain(String str) {
        this.globalZendeskDomain = str;
    }

    public void setHbUcUa(String str) {
        this.hbUcUa = str;
    }

    public void setInReview(boolean z11) {
        this.isInReview = z11;
    }

    public void setInstToken(String str) {
        this.instToken = str;
    }

    public void setInternalStyle(String str) {
        this.internalStyle = str;
    }

    public void setIpCountry(int i11) {
        this.ipCountry = i11;
    }

    public void setIsHtUpgradeState(Boolean bool) {
        this.isHtUpgradeState = bool;
    }

    public void setIsNewHomepage(Boolean bool) {
        this.isNewHomepage = bool;
    }

    public void setKycToken(String str) {
        this.kycToken = str;
    }

    public void setKycUrl(String str) {
        this.kycUrl = str;
    }

    public void setKycWebUrl(String str) {
        this.kycWebUrl = str;
    }

    public void setLanguageEnv(String str) {
        this.languageEnv = str;
    }

    public void setLanguageEnvHeader(String str) {
        this.languageEnvHeader = str;
    }

    public void setLite(boolean z11) {
        this.isLite = z11;
    }

    public void setNewHomepage(boolean z11) {
        this.isNewHomepage = Boolean.valueOf(z11);
    }

    public void setNormalDisplay(boolean z11) {
        this.isNormalDisplay = z11;
    }

    public void setOnlineNetwork(boolean z11) {
        this.isOnlineNetwork = z11;
    }

    public void setOptionBaseUrl(String str) {
        this.optionBaseUrl = str;
    }

    public void setOtcToken(String str) {
        this.otcToken = str;
    }

    public void setPhpToken(String str) {
        this.phpToken = str;
    }

    public void setProBaseUrl(String str) {
        this.proBaseUrl = str;
    }

    public void setProSocketUrl(String str) {
        this.proSocketUrl = str;
    }

    public void setProToken(String str) {
        this.proToken = str;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setRedRise(boolean z11) {
        this.isRedRise = z11;
    }

    public void setRiskBaseUrl(String str) {
        this.riskBaseUrl = str;
    }

    public void setRouteName(String str) {
        this.routeName = str;
    }

    public void setSubAccount(boolean z11) {
        this.isSubAccount = z11;
    }

    public void setSwapBaseUrl(String str) {
        this.swapBaseUrl = str;
    }

    public void setSwitch11Open(boolean z11) {
        this.isSwitch11Open = z11;
    }

    public void setSwitch27Open(boolean z11) {
        this.isSwitch27Open = z11;
    }

    public void setTravelRuleUrl(String str) {
        this.travelRuleUrl = str;
    }

    public void setUcBaseUrl(String str) {
        this.ucBaseUrl = str;
    }

    public void setUcToken(String str) {
        this.ucToken = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVToken(String str) {
        this.vToken = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setWebHost(String str) {
        this.webHost = str;
    }

    public void setZendeskLocaleStr(String str) {
        this.zendeskLocaleStr = str;
    }

    public String toString() {
        return "PlatformConfig(routeName=" + getRouteName() + ", globalBaseUrl=" + getGlobalBaseUrl() + ", proBaseUrl=" + getProBaseUrl() + ", hbUcUa=" + getHbUcUa() + ", ucBaseUrl=" + getUcBaseUrl() + ", globalInstUrl=" + getGlobalInstUrl() + ", contractBaseUrl=" + getContractBaseUrl() + ", swapBaseUrl=" + getSwapBaseUrl() + ", optionBaseUrl=" + getOptionBaseUrl() + ", riskBaseUrl=" + getRiskBaseUrl() + ", contractH5Url=" + getContractH5Url() + ", proSocketUrl=" + getProSocketUrl() + ", travelRuleUrl=" + getTravelRuleUrl() + ", languageEnv=" + getLanguageEnv() + ", languageEnvHeader=" + getLanguageEnvHeader() + ", zendeskLocaleStr=" + getZendeskLocaleStr() + ", dynamicStrings=" + getDynamicStrings() + ", internalStyle=" + getInternalStyle() + ", versionName=" + getVersionName() + ", versionCode=" + getVersionCode() + ", isOnlineNetwork=" + isOnlineNetwork() + ", androidStatusBarHeight=" + getAndroidStatusBarHeight() + ", userAgent=" + getUserAgent() + ", globalWebUrl=" + getGlobalWebUrl() + ", kycWebUrl=" + getKycWebUrl() + ", isLite=" + isLite() + ", isNormalDisplay=" + isNormalDisplay() + ", isSwitch11Open=" + isSwitch11Open() + ", webHost=" + getWebHost() + ", proToken=" + getProToken() + ", dmToken=" + getDmToken() + ", ucToken=" + getUcToken() + ", uuid=" + getUuid() + ", vToken=" + getVToken() + ", proxyHost=" + getProxyHost() + ", isRedRise=" + isRedRise() + ", isChinaUser=" + isChinaUser() + ", uid=" + getUid() + ", globalZendeskDomain=" + getGlobalZendeskDomain() + ", currencyUnit=" + getCurrencyUnit() + ", currencyCharacter=" + getCurrencyCharacter() + ", isSwitch27Open=" + isSwitch27Open() + ", globalHBUrl=" + getGlobalHBUrl() + ", globalOtcUrl=" + getGlobalOtcUrl() + ", kycUrl=" + getKycUrl() + ", otcToken=" + getOtcToken() + ", kycToken=" + getKycToken() + ", instToken=" + getInstToken() + ", phpToken=" + getPhpToken() + ", isInReview=" + isInReview() + ", isSubAccount=" + isSubAccount() + ", ipCountry=" + getIpCountry() + ", canary=" + getCanary() + ", isNewHomepage=" + getIsNewHomepage() + ", isHtUpgradeState=" + getIsHtUpgradeState() + ")";
    }
}
