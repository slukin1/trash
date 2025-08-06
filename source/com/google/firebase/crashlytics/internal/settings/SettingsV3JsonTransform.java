package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONException;
import org.json.JSONObject;

class SettingsV3JsonTransform implements SettingsJsonTransform {
    private static Settings.FeatureFlagData buildFeatureFlagDataFrom(JSONObject jSONObject) {
        return new Settings.FeatureFlagData(jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, true), jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_ANRS_KEY, false), jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_BUILD_IDS_KEY, false));
    }

    private static Settings.SessionData buildSessionDataFrom(JSONObject jSONObject) {
        return new Settings.SessionData(jSONObject.optInt(SettingsJsonConstants.SETTINGS_MAX_CUSTOM_EXCEPTION_EVENTS_KEY, 8), 4);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j11, JSONObject jSONObject) {
        if (jSONObject.has(SettingsJsonConstants.EXPIRES_AT_KEY)) {
            return jSONObject.optLong(SettingsJsonConstants.EXPIRES_AT_KEY);
        }
        return currentTimeProvider.getCurrentTimeMillis() + (j11 * 1000);
    }

    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        Settings.SessionData sessionData;
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt(SettingsJsonConstants.SETTINGS_VERSION, 0);
        int optInt2 = jSONObject2.optInt(SettingsJsonConstants.CACHE_DURATION_KEY, 3600);
        double optDouble = jSONObject2.optDouble(SettingsJsonConstants.ON_DEMAND_UPLOAD_RATE_PER_MINUTE_KEY, 10.0d);
        double optDouble2 = jSONObject2.optDouble(SettingsJsonConstants.ON_DEMAND_BACKOFF_BASE_KEY, 1.2d);
        int optInt3 = jSONObject2.optInt(SettingsJsonConstants.ON_DEMAND_BACKOFF_STEP_DURATION_SECONDS_KEY, 60);
        if (jSONObject2.has(SettingsJsonConstants.SESSION_KEY)) {
            sessionData = buildSessionDataFrom(jSONObject2.getJSONObject(SettingsJsonConstants.SESSION_KEY));
        } else {
            sessionData = buildSessionDataFrom(new JSONObject());
        }
        return new Settings(getExpiresAtFrom(currentTimeProvider, (long) optInt2, jSONObject2), sessionData, buildFeatureFlagDataFrom(jSONObject2.getJSONObject(SettingsJsonConstants.FEATURES_KEY)), optInt, optInt2, optDouble, optDouble2, optInt3);
    }
}
