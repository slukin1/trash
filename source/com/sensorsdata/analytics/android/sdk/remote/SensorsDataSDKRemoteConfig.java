package com.sensorsdata.analytics.android.sdk.remote;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import org.json.JSONArray;
import org.json.JSONObject;

public class SensorsDataSDKRemoteConfig {
    public static final int REMOTE_EVENT_TYPE_NO_USE = -1;
    private int autoTrackMode = -1;
    private boolean disableDebugMode = false;
    private boolean disableSDK = false;
    private int effectMode;
    private JSONArray eventBlacklist;
    private int mAutoTrackEventType;
    private SecreteKey mSecretKey;
    private String newVersion;
    private String oldVersion;

    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    public int getAutoTrackMode() {
        return this.autoTrackMode;
    }

    public int getEffectMode() {
        return this.effectMode;
    }

    public JSONArray getEventBlacklist() {
        return this.eventBlacklist;
    }

    public String getNewVersion() {
        return this.newVersion;
    }

    public String getOldVersion() {
        return this.oldVersion;
    }

    public SecreteKey getSecretKey() {
        return this.mSecretKey;
    }

    public boolean isAutoTrackEventTypeIgnored(int i11) {
        int i12 = this.autoTrackMode;
        if (i12 == -1) {
            return false;
        }
        if (i12 == 0) {
            return true;
        }
        int i13 = this.mAutoTrackEventType;
        if ((i11 | i13) != i13) {
            return true;
        }
        return false;
    }

    public boolean isDisableDebugMode() {
        return this.disableDebugMode;
    }

    public boolean isDisableSDK() {
        return this.disableSDK;
    }

    public void setAutoTrackMode(int i11) {
        this.autoTrackMode = i11;
        if (i11 == -1 || i11 == 0) {
            this.mAutoTrackEventType = 0;
            return;
        }
        if ((i11 & 1) == 1) {
            this.mAutoTrackEventType |= 1;
        }
        if ((i11 & 2) == 2) {
            this.mAutoTrackEventType |= 2;
        }
        if ((i11 & 4) == 4) {
            this.mAutoTrackEventType |= 4;
        }
        if ((i11 & 8) == 8) {
            this.mAutoTrackEventType |= 8;
        }
    }

    public void setDisableDebugMode(boolean z11) {
        this.disableDebugMode = z11;
    }

    public void setDisableSDK(boolean z11) {
        this.disableSDK = z11;
    }

    public void setEffectMode(int i11) {
        this.effectMode = i11;
    }

    public void setEventBlacklist(JSONArray jSONArray) {
        this.eventBlacklist = jSONArray;
    }

    public void setNewVersion(String str) {
        this.newVersion = str;
    }

    public void setOldVersion(String str) {
        this.oldVersion = str;
    }

    public void setSecretKey(SecreteKey secreteKey) {
        this.mSecretKey = secreteKey;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f.f34662a, this.oldVersion);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disableDebugMode", this.disableDebugMode);
            jSONObject2.put("autoTrackMode", this.autoTrackMode);
            jSONObject2.put("disableSDK", this.disableSDK);
            jSONObject2.put("event_blacklist", this.eventBlacklist);
            jSONObject2.put("nv", this.newVersion);
            jSONObject2.put("effect_mode", this.effectMode);
            jSONObject.put("configs", jSONObject2);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return jSONObject;
    }

    public String toString() {
        return "{ v=" + this.oldVersion + ", disableDebugMode=" + this.disableDebugMode + ", disableSDK=" + this.disableSDK + ", autoTrackMode=" + this.autoTrackMode + ", event_blacklist=" + this.eventBlacklist + ", nv=" + this.newVersion + ", effect_mode=" + this.effectMode + "}";
    }
}
