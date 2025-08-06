package com.adjust.sdk;

import android.text.TextUtils;
import com.adjust.sdk.ActivityHandler;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.vulcan.model.VulcanInfo;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private a activityStateCopy;
    private AdjustConfig adjustConfig;
    public AdjustAttribution attribution;
    public long clickTimeInMilliseconds = -1;
    public long clickTimeInSeconds = -1;
    public long clickTimeServerInSeconds = -1;
    private long createdAt;
    public String deeplink;
    private DeviceInfo deviceInfo;
    public Map<String, String> extraParameters;
    private GlobalParameters globalParameters;
    public Boolean googlePlayInstant;
    public long installBeginTimeInSeconds = -1;
    public long installBeginTimeServerInSeconds = -1;
    public String installVersion;
    public ActivityHandler.InternalState internalState;
    public Boolean isClick;
    public String preinstallLocation;
    public String preinstallPayload;
    public String rawReferrer;
    public String referrer;
    public String referrerApi;
    public String reftag;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f13914a = -1;

        /* renamed from: b  reason: collision with root package name */
        public final int f13915b = -1;

        /* renamed from: c  reason: collision with root package name */
        public final int f13916c = -1;

        /* renamed from: d  reason: collision with root package name */
        public final long f13917d = -1;

        /* renamed from: e  reason: collision with root package name */
        public final long f13918e = -1;

        /* renamed from: f  reason: collision with root package name */
        public final String f13919f = null;

        /* renamed from: g  reason: collision with root package name */
        public final String f13920g = null;

        public a(ActivityState activityState) {
            if (activityState != null) {
                this.f13914a = activityState.eventCount;
                this.f13915b = activityState.sessionCount;
                this.f13916c = activityState.subsessionCount;
                this.f13917d = activityState.timeSpent;
                this.f13918e = activityState.sessionLength;
                this.f13919f = activityState.uuid;
                this.f13920g = activityState.pushToken;
            }
        }
    }

    public PackageBuilder(AdjustConfig adjustConfig2, DeviceInfo deviceInfo2, ActivityState activityState, GlobalParameters globalParameters2, long j11) {
        this.createdAt = j11;
        this.deviceInfo = deviceInfo2;
        this.adjustConfig = adjustConfig2;
        this.activityStateCopy = new a(activityState);
        this.globalParameters = globalParameters2;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (bool != null) {
            addLong(map, str, bool.booleanValue() ? 1 : 0);
        }
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (date != null) {
            addString(map, str, Util.dateFormatter.format(date));
        }
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j11) {
        if (j11 > 0) {
            addDate(map, str, new Date(j11));
        }
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j11) {
        if (j11 > 0) {
            addDate(map, str, new Date(j11 * 1000));
        }
    }

    public static void addDouble(Map<String, String> map, String str, double d11) {
        if (d11 >= 0.0d) {
            addString(map, str, Double.toString(d11));
        }
    }

    private static void addDoubleWithoutRounding(Map<String, String> map, String str, Double d11) {
        if (d11 != null) {
            addString(map, str, Double.toString(d11.doubleValue()));
        }
    }

    private static void addDuration(Map<String, String> map, String str, long j11) {
        if (j11 >= 0) {
            addLong(map, str, (j11 + 500) / 1000);
        }
    }

    private static void addInteger(Map<String, String> map, String str, Integer num) {
        if (num != null) {
            addString(map, str, Integer.toString(num.intValue()));
        }
    }

    public static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            addString(map, str, jSONObject.toString());
        }
    }

    public static void addLong(Map<String, String> map, String str, long j11) {
        if (j11 >= 0) {
            addString(map, str, Long.toString(j11));
        }
    }

    public static void addMapJson(Map<String, String> map, String str, Map map2) {
        if (map2 != null && map2.size() != 0) {
            addString(map, str, new JSONObject(map2).toString());
        }
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map != null && !map.containsKey("android_id") && !map.containsKey("gps_adid") && !map.containsKey("fire_adid") && !map.containsKey("oaid") && !map.containsKey(VulcanInfo.IMEI) && !map.containsKey("meid") && !map.containsKey("device_id") && !map.containsKey("imeis") && !map.containsKey("meids") && !map.containsKey("device_ids")) {
            AdjustConfig adjustConfig2 = this.adjustConfig;
            if (adjustConfig2.coppaComplianceEnabled) {
                logger.info("Missing Device IDs. COPPA enabled.", new Object[0]);
            } else if (adjustConfig2.playStoreKidsComplianceEnabled) {
                logger.info("Missing Device IDs. Play store kids compliance enabled.", new Object[0]);
            } else {
                logger.error("Missing Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
            }
        }
    }

    private boolean containsFireIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("fire_adid");
    }

    private boolean containsPlayIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(AdjustAdRevenue adjustAdRevenue) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustAdRevenue.callbackParameters, "Callback"));
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustAdRevenue.partnerParameters, "Partner"));
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "source", adjustAdRevenue.source);
        addDoubleWithoutRounding(hashMap, "revenue", adjustAdRevenue.revenue);
        addString(hashMap, FirebaseAnalytics.Param.CURRENCY, adjustAdRevenue.currency);
        addInteger(hashMap, "ad_impressions_count", adjustAdRevenue.adImpressionsCount);
        addString(hashMap, "ad_revenue_network", adjustAdRevenue.adRevenueNetwork);
        addString(hashMap, "ad_revenue_unit", adjustAdRevenue.adRevenueUnit);
        addString(hashMap, "ad_revenue_placement", adjustAdRevenue.adRevenuePlacement);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getAttributionParameters(String str) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "initiated_by", str);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getClickParameters(String str) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(hashMap, "tracker", adjustAttribution.trackerName);
            addString(hashMap, "campaign", this.attribution.campaign);
            addString(hashMap, "adgroup", this.attribution.adgroup);
            addString(hashMap, "creative", this.attribution.creative);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.globalParameters.callbackParameters);
        addDateInMilliseconds(hashMap, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(hashMap, "click_time", this.clickTimeInSeconds);
        addDateInSeconds(hashMap, "click_time_server", this.clickTimeServerInSeconds);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, Constants.DEEPLINK, this.deeplink);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addBoolean(hashMap, "google_play_instant", this.googlePlayInstant);
        addBoolean(hashMap, "is_click", this.isClick);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addDateInSeconds(hashMap, "install_begin_time", this.installBeginTimeInSeconds);
        addDateInSeconds(hashMap, "install_begin_time_server", this.installBeginTimeServerInSeconds);
        addString(hashMap, "install_version", this.installVersion);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addMapJson(hashMap, "params", this.extraParameters);
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.globalParameters.partnerParameters);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "raw_referrer", this.rawReferrer);
        addString(hashMap, Constants.REFERRER, this.referrer);
        addString(hashMap, "referrer_api", this.referrerApi);
        addString(hashMap, Constants.REFTAG, this.reftag);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addString(hashMap, "source", str);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, "payload", this.preinstallPayload);
        addString(hashMap, "found_location", this.preinstallLocation);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        Double d11 = adjustEvent.revenue;
        if (d11 == null) {
            return Util.formatString("'%s'", adjustEvent.eventToken);
        }
        return Util.formatString("(%.5f %s, '%s')", d11, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getInfoParameters(String str) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "source", str);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getMeasurementConsentParameters(boolean z11) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        addString(hashMap, "measurement", z11 ? "enable" : "disable");
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSessionParameters() {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.globalParameters.callbackParameters);
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.globalParameters.partnerParameters);
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, FirebaseAnalytics.Param.CURRENCY, adjustPlayStoreSubscription.getCurrency());
        addString(hashMap, "product_id", adjustPlayStoreSubscription.getSku());
        addString(hashMap, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(hashMap, "receipt", adjustPlayStoreSubscription.getSignature());
        addLong(hashMap, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(hashMap, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(hashMap, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getThirdPartySharingParameters(AdjustThirdPartySharing adjustThirdPartySharing) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Boolean bool = adjustThirdPartySharing.isEnabled;
        if (bool != null) {
            addString(hashMap, "sharing", bool.booleanValue() ? "enable" : "disable");
        }
        addMapJson(hashMap, "granular_third_party_sharing_options", adjustThirdPartySharing.granularOptions);
        addMapJson(hashMap, "partner_sharing_settings", adjustThirdPartySharing.partnerSharingSettings);
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool2 = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool2);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool2);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool2 = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool2);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getVerificationParameters(AdjustEvent adjustEvent) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, "product_id", adjustEvent.getProductId());
        addString(hashMap, "purchase_token", adjustEvent.getPurchaseToken());
        addString(hashMap, "event_token", adjustEvent.getEventToken());
        addString(hashMap, FirebaseAnalytics.Param.CURRENCY, adjustEvent.getCurrency());
        addDouble((Map<String, String>) hashMap, "revenue", adjustEvent.getRevenue());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private void injectFeatureFlagsWithParameters(Map<String, String> map) {
        String str;
        Boolean bool;
        if (this.adjustConfig.coppaComplianceEnabled) {
            addLong(map, "ff_coppa", 1);
        }
        ActivityHandler.InternalState internalState2 = this.internalState;
        if (internalState2 != null) {
            addBoolean(map, "offline_mode_enabled", Boolean.valueOf(internalState2.offline));
            if (this.internalState.isInForeground()) {
                bool = Boolean.TRUE;
                str = DownloadService.KEY_FOREGROUND;
            } else {
                bool = Boolean.TRUE;
                str = "background";
            }
            addBoolean(map, str, bool);
        }
        if (this.adjustConfig.playStoreKidsComplianceEnabled) {
            addLong(map, "ff_play_store_kids_app", 1);
        }
    }

    public ActivityPackage buildAdRevenuePackage(AdjustAdRevenue adjustAdRevenue) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(adjustAdRevenue);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.AD_REVENUE);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(adRevenueParameters);
        defaultActivityPackage.setCallbackParameters(adjustAdRevenue.callbackParameters);
        defaultActivityPackage.setPartnerParameters(adjustAdRevenue.partnerParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.ATTRIBUTION);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.CLICK);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        defaultActivityPackage.setClickTimeServerInSeconds(this.clickTimeServerInSeconds);
        defaultActivityPackage.setInstallBeginTimeServerInSeconds(this.installBeginTimeServerInSeconds);
        defaultActivityPackage.setInstallVersion(this.installVersion);
        defaultActivityPackage.setGooglePlayInstant(this.googlePlayInstant);
        defaultActivityPackage.setIsClick(this.isClick);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildEventPackage(AdjustEvent adjustEvent) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.EVENT);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        defaultActivityPackage.setParameters(eventParameters);
        defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
        defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.GDPR);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.INFO);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildMeasurementConsentPackage(boolean z11) {
        Map<String, String> measurementConsentParameters = getMeasurementConsentParameters(z11);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.MEASUREMENT_CONSENT);
        defaultActivityPackage.setPath("/measurement_consent");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(measurementConsentParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSessionPackage() {
        Map<String, String> sessionParameters = getSessionParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SESSION);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(sessionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SUBSCRIPTION);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildThirdPartySharingPackage(AdjustThirdPartySharing adjustThirdPartySharing) {
        Map<String, String> thirdPartySharingParameters = getThirdPartySharingParameters(adjustThirdPartySharing);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.THIRD_PARTY_SHARING);
        defaultActivityPackage.setPath("/third_party_sharing");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(thirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildVerificationPackage(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        Map<String, String> verificationParameters = getVerificationParameters(adjustEvent);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.PURCHASE_VERIFICATION);
        defaultActivityPackage.setPath("/verify");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setPurchaseVerificationCallback(onPurchaseVerificationFinishedListener);
        defaultActivityPackage.setParameters(verificationParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(hashMap, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, FirebaseAnalytics.Param.CURRENCY, adjustEvent.currency);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "event_callback_id", adjustEvent.callbackId);
        addLong(hashMap, "event_count", (long) this.activityStateCopy.f13914a);
        addString(hashMap, "event_token", adjustEvent.eventToken);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "product_id", adjustEvent.productId);
        addString(hashMap, "purchase_token", adjustEvent.purchaseToken);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addDouble((Map<String, String>) hashMap, "revenue", adjustEvent.revenue);
        addString(hashMap, "order_id", adjustEvent.orderId);
        addString(hashMap, "deduplication_id", adjustEvent.deduplicationId);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private static void addDouble(Map<String, String> map, String str, Double d11) {
        if (d11 != null) {
            addString(map, str, Util.formatString("%.5f", d11));
        }
    }

    private Map<String, String> getVerificationParameters(AdjustPlayStorePurchase adjustPlayStorePurchase) {
        HashMap hashMap = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map = this.deviceInfo.imeiParameters;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.deviceInfo.oaidParameters;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f13919f);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(hashMap, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, Constants.EXTRA_KEY_APP_VERSION, this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) this.deviceInfo.connectivityType);
        addString(hashMap, UserDataStore.COUNTRY, this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, DbParams.KEY_CREATED_AT, this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.uiMode);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", this.deviceInfo.mcc);
        addString(hashMap, "mnc", this.deviceInfo.mnc);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, TPDownloadProxyEnum.USER_OS_VERSION, this.deviceInfo.osVersion);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.f13920g);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addLong(hashMap, "session_count", (long) this.activityStateCopy.f13915b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f13918e);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f13916c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f13917d);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, "product_id", adjustPlayStorePurchase.getProductId());
        addString(hashMap, "purchase_token", adjustPlayStorePurchase.getPurchaseToken());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(hashMap, "gpg_pc_enabled", bool);
        addJsonObject(hashMap, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    public ActivityPackage buildVerificationPackage(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        Map<String, String> verificationParameters = getVerificationParameters(adjustPlayStorePurchase);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.PURCHASE_VERIFICATION);
        defaultActivityPackage.setPath("/verify");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setPurchaseVerificationCallback(onPurchaseVerificationFinishedListener);
        defaultActivityPackage.setParameters(verificationParameters);
        return defaultActivityPackage;
    }
}
