package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider2) {
        this.currentTimeProvider = currentTimeProvider2;
    }

    private static SettingsJsonTransform getJsonTransformForVersion(int i11) {
        if (i11 == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger logger = Logger.getLogger();
        logger.e("Could not determine SettingsJsonTransform for settings version " + i11 + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }

    public Settings parseSettingsJson(JSONObject jSONObject) throws JSONException {
        return getJsonTransformForVersion(jSONObject.getInt(SettingsJsonConstants.SETTINGS_VERSION)).buildFromJson(this.currentTimeProvider, jSONObject);
    }
}
