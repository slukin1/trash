package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.AdjustInstance;
import java.util.ArrayList;
import java.util.List;

public class AdjustConfig {
    public static final String ENVIRONMENT_PRODUCTION = "production";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    public String appToken;
    public String basePath;
    public ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    public ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    public OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    public Context context;
    public boolean coppaComplianceEnabled;
    public String defaultTracker;
    public String environment;
    public Integer eventDeduplicationIdsMaxSize;
    public String externalDeviceId;
    public String fbAppId;
    public String gdprPath;
    public Boolean isCostDataInAttributionEnabled;
    public boolean isDataResidency;
    public boolean isDeviceIdsReadingOnceEnabled;
    public boolean isPreinstallTrackingEnabled;
    public boolean isSendingInBackgroundEnabled;
    public ILogger logger;
    public OnAttributionChangedListener onAttributionChangedListener;
    public OnDeferredDeeplinkResponseListener onDeferredDeeplinkResponseListener;
    public OnEventTrackingFailedListener onEventTrackingFailedListener;
    public OnEventTrackingSucceededListener onEventTrackingSucceededListener;
    public OnSessionTrackingFailedListener onSessionTrackingFailedListener;
    public OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
    public boolean playStoreKidsComplianceEnabled;
    public AdjustInstance.PreLaunchActions preLaunchActions;
    public String preinstallFilePath;
    public String processName;
    public String purchaseVerificationPath;
    public String pushToken;
    public String sdkPrefix;
    public Boolean startEnabled;
    public boolean startOffline;
    public String subscriptionPath;
    public List<String> urlStrategyDomains;
    public boolean useSubdomains;

    public AdjustConfig(Context context2, String str, String str2) {
        init(context2, str, str2, false);
    }

    private boolean checkAppToken(String str) {
        if (str == null) {
            this.logger.error("Missing App Token", new Object[0]);
            return false;
        } else if (str.length() == 12) {
            return true;
        } else {
            this.logger.error("Malformed App Token '%s'", str);
            return false;
        }
    }

    private boolean checkContext(Context context2) {
        if (context2 == null) {
            this.logger.error("Missing context", new Object[0]);
            return false;
        } else if (Util.checkPermission(context2, "android.permission.INTERNET")) {
            return true;
        } else {
            this.logger.error("Missing permission: INTERNET", new Object[0]);
            return false;
        }
    }

    private boolean checkEnvironment(String str) {
        if (str == null) {
            this.logger.error("Missing environment", new Object[0]);
            return false;
        } else if (str.equals(ENVIRONMENT_SANDBOX)) {
            this.logger.warnInProduction("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        } else if (str.equals("production")) {
            this.logger.warnInProduction("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        } else {
            this.logger.error("Unknown environment '%s'", str);
            return false;
        }
    }

    private void init(Context context2, String str, String str2, boolean z11) {
        this.logger = AdjustFactory.getLogger();
        setLogLevel((!z11 || !"production".equals(str2)) ? LogLevel.INFO : LogLevel.SUPPRESS, str2);
        if (context2 != null) {
            context2 = context2.getApplicationContext();
        }
        this.context = context2;
        this.appToken = str;
        this.environment = str2;
        this.isSendingInBackgroundEnabled = false;
        this.isPreinstallTrackingEnabled = false;
        this.isDeviceIdsReadingOnceEnabled = false;
        this.coppaComplianceEnabled = false;
        this.playStoreKidsComplianceEnabled = false;
    }

    public void enableCoppaCompliance() {
        this.coppaComplianceEnabled = true;
    }

    public void enableCostDataInAttribution() {
        this.isCostDataInAttributionEnabled = Boolean.TRUE;
    }

    public void enableDeviceIdsReadingOnce() {
        this.isDeviceIdsReadingOnceEnabled = true;
    }

    public void enablePlayStoreKidsCompliance() {
        this.playStoreKidsComplianceEnabled = true;
    }

    public void enablePreinstallTracking() {
        this.isPreinstallTrackingEnabled = true;
    }

    public void enableSendingInBackground() {
        this.isSendingInBackgroundEnabled = true;
    }

    public String getAppToken() {
        return this.appToken;
    }

    public Context getContext() {
        return this.context;
    }

    public Boolean getCostDataInAttributionEnabled() {
        return this.isCostDataInAttributionEnabled;
    }

    public String getDefaultTracker() {
        return this.defaultTracker;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Integer getEventDeduplicationIdsMaxSize() {
        return this.eventDeduplicationIdsMaxSize;
    }

    public String getExternalDeviceId() {
        return this.externalDeviceId;
    }

    public String getFbAppId() {
        return this.fbAppId;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public OnAttributionChangedListener getOnAttributionChangedListener() {
        return this.onAttributionChangedListener;
    }

    public OnDeferredDeeplinkResponseListener getOnDeeplinkResponseListener() {
        return this.onDeferredDeeplinkResponseListener;
    }

    public OnEventTrackingFailedListener getOnEventTrackingFailedListener() {
        return this.onEventTrackingFailedListener;
    }

    public OnEventTrackingSucceededListener getOnEventTrackingSucceededListener() {
        return this.onEventTrackingSucceededListener;
    }

    public OnSessionTrackingFailedListener getOnSessionTrackingFailedListener() {
        return this.onSessionTrackingFailedListener;
    }

    public OnSessionTrackingSucceededListener getOnSessionTrackingSucceededListener() {
        return this.onSessionTrackingSucceededListener;
    }

    public String getPreinstallFilePath() {
        return this.preinstallFilePath;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSdkPrefix() {
        return this.sdkPrefix;
    }

    public List<String> getUrlStrategyDomains() {
        return this.urlStrategyDomains;
    }

    public boolean isCoppaComplianceEnabled() {
        return this.coppaComplianceEnabled;
    }

    public boolean isDeviceIdsReadingOnceEnabled() {
        return this.isDeviceIdsReadingOnceEnabled;
    }

    public boolean isPlayStoreKidsComplianceEnabled() {
        return this.playStoreKidsComplianceEnabled;
    }

    public boolean isPreinstallTrackingEnabled() {
        return this.isPreinstallTrackingEnabled;
    }

    public boolean isSendingInBackgroundEnabled() {
        return this.isSendingInBackgroundEnabled;
    }

    public boolean isValid() {
        return checkAppToken(this.appToken) && checkEnvironment(this.environment) && checkContext(this.context);
    }

    public void setDefaultTracker(String str) {
        this.defaultTracker = str;
    }

    public void setEventDeduplicationIdsMaxSize(Integer num) {
        this.eventDeduplicationIdsMaxSize = num;
    }

    public void setExternalDeviceId(String str) {
        this.externalDeviceId = str;
    }

    public void setFbAppId(String str) {
        this.fbAppId = str;
    }

    public void setLogLevel(LogLevel logLevel) {
        setLogLevel(logLevel, this.environment);
    }

    public void setOnAttributionChangedListener(OnAttributionChangedListener onAttributionChangedListener2) {
        this.onAttributionChangedListener = onAttributionChangedListener2;
    }

    public void setOnDeferredDeeplinkResponseListener(OnDeferredDeeplinkResponseListener onDeferredDeeplinkResponseListener2) {
        this.onDeferredDeeplinkResponseListener = onDeferredDeeplinkResponseListener2;
    }

    public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener onEventTrackingFailedListener2) {
        this.onEventTrackingFailedListener = onEventTrackingFailedListener2;
    }

    public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener onEventTrackingSucceededListener2) {
        this.onEventTrackingSucceededListener = onEventTrackingSucceededListener2;
    }

    public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener onSessionTrackingFailedListener2) {
        this.onSessionTrackingFailedListener = onSessionTrackingFailedListener2;
    }

    public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener onSessionTrackingSucceededListener2) {
        this.onSessionTrackingSucceededListener = onSessionTrackingSucceededListener2;
    }

    public void setPreinstallFilePath(String str) {
        this.preinstallFilePath = str;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public void setSdkPrefix(String str) {
        this.sdkPrefix = str;
    }

    public void setUrlStrategy(List<String> list, boolean z11, boolean z12) {
        if (list == null || list.isEmpty()) {
            this.logger.error("Invalid URL strategy domains array", new Object[0]);
            return;
        }
        this.urlStrategyDomains = list;
        this.useSubdomains = z11;
        this.isDataResidency = z12;
    }

    public AdjustConfig(Context context2, String str, String str2, boolean z11) {
        init(context2, str, str2, z11);
    }

    private void setLogLevel(LogLevel logLevel, String str) {
        this.logger.setLogLevel(logLevel, "production".equals(str));
    }
}
