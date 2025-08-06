package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.bv;
import com.appsflyer.internal.k;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LinkGenerator {
    public String AFInAppEventParameterName;
    private String AFInAppEventType;
    private String AFKeystoreWrapper;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private String getLevel;
    private String init;
    private Map<String, String> onAppOpenAttributionNative = new HashMap();
    private Map<String, String> onDeepLinkingNative = new HashMap();
    private String onInstallConversionDataLoadedNative;
    private String onInstallConversionFailureNative;
    public String valueOf;
    private String values;

    public LinkGenerator(String str) {
        this.AFInAppEventType = str;
    }

    private StringBuilder AFKeystoreWrapper() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.AFInAppEventParameterName;
        if (str == null || !str.startsWith("http")) {
            sb2.append(String.format(bv.AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}));
        } else {
            sb2.append(this.AFInAppEventParameterName);
        }
        if (this.valueOf != null) {
            sb2.append('/');
            sb2.append(this.valueOf);
        }
        this.onDeepLinkingNative.put("pid", this.AFInAppEventType);
        sb2.append('?');
        sb2.append("pid=");
        sb2.append(values(this.AFInAppEventType, "media source"));
        String str2 = this.init;
        if (str2 != null) {
            this.onDeepLinkingNative.put("af_referrer_uid", str2);
            sb2.append('&');
            sb2.append("af_referrer_uid=");
            sb2.append(values(this.init, "referrerUID"));
        }
        String str3 = this.AFKeystoreWrapper;
        if (str3 != null) {
            this.onDeepLinkingNative.put(AFInAppEventParameterName.AF_CHANNEL, str3);
            sb2.append('&');
            sb2.append("af_channel=");
            sb2.append(values(this.AFKeystoreWrapper, AppsFlyerProperties.CHANNEL));
        }
        String str4 = this.getLevel;
        if (str4 != null) {
            this.onDeepLinkingNative.put("af_referrer_customer_id", str4);
            sb2.append('&');
            sb2.append("af_referrer_customer_id=");
            sb2.append(values(this.getLevel, "referrerCustomerId"));
        }
        String str5 = this.values;
        if (str5 != null) {
            this.onDeepLinkingNative.put("c", str5);
            sb2.append('&');
            sb2.append("c=");
            sb2.append(values(this.values, "campaign"));
        }
        String str6 = this.AppsFlyer2dXConversionCallback;
        if (str6 != null) {
            this.onDeepLinkingNative.put("af_referrer_name", str6);
            sb2.append('&');
            sb2.append("af_referrer_name=");
            sb2.append(values(this.AppsFlyer2dXConversionCallback, "referrerName"));
        }
        String str7 = this.AFVersionDeclaration;
        if (str7 != null) {
            this.onDeepLinkingNative.put("af_referrer_image_url", str7);
            sb2.append('&');
            sb2.append("af_referrer_image_url=");
            sb2.append(values(this.AFVersionDeclaration, "referrerImageURL"));
        }
        if (this.onInstallConversionDataLoadedNative != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.onInstallConversionDataLoadedNative);
            String str8 = "";
            sb3.append(this.onInstallConversionDataLoadedNative.endsWith("/") ? str8 : "/");
            String str9 = this.AFLogger$LogLevel;
            if (str9 != null) {
                sb3.append(str9);
            }
            this.onDeepLinkingNative.put("af_dp", sb3.toString());
            sb2.append('&');
            sb2.append("af_dp=");
            sb2.append(values(this.onInstallConversionDataLoadedNative, "baseDeeplink"));
            if (this.AFLogger$LogLevel != null) {
                if (!this.onInstallConversionDataLoadedNative.endsWith("/")) {
                    str8 = "%2F";
                }
                sb2.append(str8);
                sb2.append(values(this.AFLogger$LogLevel, "deeplinkPath"));
            }
        }
        for (String next : this.onAppOpenAttributionNative.keySet()) {
            String obj = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(next);
            sb4.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb4.append(values(this.onAppOpenAttributionNative.get(next), next));
            if (!obj.contains(sb4.toString())) {
                sb2.append('&');
                sb2.append(next);
                sb2.append('=');
                sb2.append(values(this.onAppOpenAttributionNative.get(next), next));
            }
        }
        return sb2;
    }

    private static String values(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException e11) {
            StringBuilder sb2 = new StringBuilder("Illegal ");
            sb2.append(str2);
            sb2.append(l.f34627b);
            sb2.append(str);
            AFLogger.AFInAppEventType(sb2.toString(), (Throwable) e11);
            return "";
        } catch (Throwable th2) {
            AFLogger.values(th2);
            return "";
        }
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.onAppOpenAttributionNative.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.onAppOpenAttributionNative.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        return AFKeystoreWrapper().toString();
    }

    public String getBrandDomain() {
        return this.onInstallConversionFailureNative;
    }

    public String getCampaign() {
        return this.values;
    }

    public String getChannel() {
        return this.AFKeystoreWrapper;
    }

    public String getMediaSource() {
        return this.AFInAppEventType;
    }

    public Map<String, String> getParameters() {
        return this.onAppOpenAttributionNative;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.onInstallConversionDataLoadedNative = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFInAppEventParameterName = String.format("https://%s/%s", new Object[]{String.format("%sapp.%s", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.AFInAppEventParameterName = String.format("https://%s/%s", new Object[]{str2, str});
        }
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.onInstallConversionFailureNative = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.values = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.AFKeystoreWrapper = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.AFLogger$LogLevel = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.getLevel = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.AFVersionDeclaration = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.AppsFlyer2dXConversionCallback = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.init = str;
        return this;
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.onAppOpenAttributionNative.isEmpty()) {
            for (Map.Entry next : this.onAppOpenAttributionNative.entrySet()) {
                this.onDeepLinkingNative.put(next.getKey(), next.getValue());
            }
        }
        AFKeystoreWrapper();
        String str = this.onInstallConversionFailureNative;
        Map<String, String> map = this.onDeepLinkingNative;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.AFInAppEventType("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, ae.values(), context);
        createOneLinkHttpTask.values = responseListener;
        createOneLinkHttpTask.valueOf = str;
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        k.valueOf.valueOf().execute(createOneLinkHttpTask);
    }
}
