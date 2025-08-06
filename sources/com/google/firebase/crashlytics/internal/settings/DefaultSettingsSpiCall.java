package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall implements SettingsSpiCall {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String BUILD_VERSION_PARAM = "build_version";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final String DISPLAY_VERSION_PARAM = "display_version";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
    public static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
    public static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
    public static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
    public static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String INSTANCE_PARAM = "instance";
    public static final String SOURCE_PARAM = "source";
    private final Logger logger;
    private final HttpRequestFactory requestFactory;
    private final String url;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.getLogger());
    }

    private HttpGetRequest applyHeadersTo(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpGetRequest, HEADER_GOOGLE_APP_ID, settingsRequest.googleAppId);
        applyNonNullHeader(httpGetRequest, HEADER_CLIENT_TYPE, "android");
        applyNonNullHeader(httpGetRequest, HEADER_CLIENT_VERSION, CrashlyticsCore.getVersion());
        applyNonNullHeader(httpGetRequest, "Accept", "application/json");
        applyNonNullHeader(httpGetRequest, HEADER_DEVICE_MODEL, settingsRequest.deviceModel);
        applyNonNullHeader(httpGetRequest, HEADER_OS_BUILD_VERSION, settingsRequest.osBuildVersion);
        applyNonNullHeader(httpGetRequest, HEADER_OS_DISPLAY_VERSION, settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpGetRequest, HEADER_INSTALLATION_ID, settingsRequest.installIdProvider.getInstallIds().getCrashlyticsInstallId());
        return httpGetRequest;
    }

    private void applyNonNullHeader(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.header(str, str2);
        }
    }

    private JSONObject getJsonObjectFrom(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e11) {
            Logger logger2 = this.logger;
            logger2.w("Failed to parse settings JSON from " + this.url, e11);
            Logger logger3 = this.logger;
            logger3.w("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put(BUILD_VERSION_PARAM, settingsRequest.buildVersion);
        hashMap.put(DISPLAY_VERSION_PARAM, settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        String str = settingsRequest.instanceId;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(INSTANCE_PARAM, str);
        }
        return hashMap;
    }

    public HttpGetRequest createHttpGetRequest(Map<String, String> map) {
        HttpGetRequest buildHttpGetRequest = this.requestFactory.buildHttpGetRequest(this.url, map);
        return buildHttpGetRequest.header("User-Agent", CRASHLYTICS_USER_AGENT + CrashlyticsCore.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public JSONObject handleResponse(HttpResponse httpResponse) {
        int code = httpResponse.code();
        Logger logger2 = this.logger;
        logger2.v("Settings response code was: " + code);
        if (requestWasSuccessful(code)) {
            return getJsonObjectFrom(httpResponse.body());
        }
        Logger logger3 = this.logger;
        logger3.e("Settings request failed; (status: " + code + ") from " + this.url);
        return null;
    }

    public JSONObject invoke(SettingsRequest settingsRequest, boolean z11) {
        if (z11) {
            try {
                Map<String, String> queryParamsFor = getQueryParamsFor(settingsRequest);
                HttpGetRequest applyHeadersTo = applyHeadersTo(createHttpGetRequest(queryParamsFor), settingsRequest);
                Logger logger2 = this.logger;
                logger2.d("Requesting settings from " + this.url);
                Logger logger3 = this.logger;
                logger3.v("Settings query params were: " + queryParamsFor);
                return handleResponse(applyHeadersTo.execute());
            } catch (IOException e11) {
                this.logger.e("Settings request failed.", e11);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    public boolean requestWasSuccessful(int i11) {
        return i11 == 200 || i11 == 201 || i11 == 202 || i11 == 203;
    }

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger2) {
        if (str != null) {
            this.logger = logger2;
            this.requestFactory = httpRequestFactory;
            this.url = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
