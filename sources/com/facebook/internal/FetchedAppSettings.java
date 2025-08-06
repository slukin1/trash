package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FetchedAppSettings {
    private boolean IAPAutomaticLoggingEnabled;
    private boolean automaticLoggingEnabled;
    private boolean codelessEventsEnabled;
    private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
    private FacebookRequestErrorClassification errorClassification;
    private JSONArray eventBindings;
    private String nuxContent;
    private boolean nuxEnabled;
    private String rawAamRules;
    private String restrictiveDataSetting;
    private String sdkUpdateMessage;
    private int sessionTimeoutInSeconds;
    private String smartLoginBookmarkIconURL;
    private String smartLoginMenuIconURL;
    private EnumSet<SmartLoginOption> smartLoginOptions;
    private String suggestedEventsSetting;
    private boolean supportsImplicitLogging;
    private boolean trackUninstallEnabled;

    public static class DialogFeatureConfig {
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private String dialogName;
        private Uri fallbackUrl;
        private String featureName;
        private int[] featureVersionSpec;

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.featureVersionSpec = iArr;
        }

        public static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            Uri uri = null;
            if (Utility.isNullOrEmpty(optString)) {
                return null;
            }
            String[] split = optString.split(DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                return null;
            }
            String optString2 = jSONObject.optString("url");
            if (!Utility.isNullOrEmpty(optString2)) {
                uri = Uri.parse(optString2);
            }
            return new DialogFeatureConfig(str, str2, uri, parseVersionSpec(jSONObject.optJSONArray(DIALOG_CONFIG_VERSIONS_KEY)));
        }

        private static int[] parseVersionSpec(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = -1;
                int optInt = jSONArray.optInt(i11, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i11);
                    if (!Utility.isNullOrEmpty(optString)) {
                        try {
                            i12 = Integer.parseInt(optString);
                        } catch (NumberFormatException e11) {
                            Utility.logd(Utility.LOG_TAG, (Exception) e11);
                        }
                        iArr[i11] = i12;
                    }
                }
                i12 = optInt;
                iArr[i11] = i12;
            }
            return iArr;
        }

        public String getDialogName() {
            return this.dialogName;
        }

        public Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public String getFeatureName() {
            return this.featureName;
        }

        public int[] getVersionSpec() {
            return this.featureVersionSpec;
        }
    }

    public FetchedAppSettings(boolean z11, String str, boolean z12, int i11, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, DialogFeatureConfig>> map, boolean z13, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z14, boolean z15, JSONArray jSONArray, String str4, boolean z16, String str5, String str6, String str7) {
        this.supportsImplicitLogging = z11;
        this.nuxContent = str;
        this.nuxEnabled = z12;
        this.dialogConfigMap = map;
        this.errorClassification = facebookRequestErrorClassification;
        this.sessionTimeoutInSeconds = i11;
        this.automaticLoggingEnabled = z13;
        this.smartLoginOptions = enumSet;
        this.smartLoginBookmarkIconURL = str2;
        this.smartLoginMenuIconURL = str3;
        this.IAPAutomaticLoggingEnabled = z14;
        this.codelessEventsEnabled = z15;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str4;
        this.trackUninstallEnabled = z16;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        FetchedAppSettings appSettingsWithoutQuery;
        Map map;
        if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str3) || (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str)) == null || (map = appSettingsWithoutQuery.getDialogConfigurations().get(str2)) == null) {
            return null;
        }
        return (DialogFeatureConfig) map.get(str3);
    }

    public boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigMap;
    }

    public FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public boolean getIAPAutomaticLoggingEnabled() {
        return this.IAPAutomaticLoggingEnabled;
    }

    public String getNuxContent() {
        return this.nuxContent;
    }

    public boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public String getRawAamRules() {
        return this.rawAamRules;
    }

    public String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
