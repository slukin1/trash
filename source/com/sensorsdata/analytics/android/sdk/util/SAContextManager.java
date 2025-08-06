package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPresetPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager;
import com.sumsub.sns.internal.core.common.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class SAContextManager {
    private boolean isAppStartSuccess;
    private String mAndroidId;
    private final Context mContext;
    private Map<String, Object> mDeviceInfo;
    private List<SAEventListener> mEventListenerList;

    public SAContextManager(Context context) {
        this.mContext = context;
    }

    private void setupDeviceInfo() {
        Map<String, Object> map = this.mDeviceInfo;
        if (map == null || map.isEmpty()) {
            this.mDeviceInfo = Collections.unmodifiableMap(SensorsDataPropertyPluginManager.getInstance().getPropertiesByPlugin(SAPresetPropertyPlugin.class));
        }
    }

    public void addEventListener(SAEventListener sAEventListener) {
        try {
            if (this.mEventListenerList == null) {
                this.mEventListenerList = new ArrayList();
            }
            this.mEventListenerList.add(sAEventListener);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void addKeyIfExist(JSONObject jSONObject, String str) {
        try {
            setupDeviceInfo();
            Map<String, Object> map = this.mDeviceInfo;
            if (map != null && map.containsKey(str)) {
                jSONObject.put(str, this.mDeviceInfo.get(str));
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public String getAndroidId() {
        if (TextUtils.isEmpty(this.mAndroidId) && AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
            this.mAndroidId = SensorsDataUtils.getAndroidID(this.mContext);
        }
        return this.mAndroidId;
    }

    public List<SAEventListener> getEventListenerList() {
        return this.mEventListenerList;
    }

    public JSONObject getPresetProperties() {
        String str = "$device_id";
        JSONObject jSONObject = new JSONObject();
        try {
            setupDeviceInfo();
            String str2 = "$app_name";
            jSONObject.put("$app_version", this.mDeviceInfo.get("$app_version"));
            jSONObject.put("$lib", n0.f32119g);
            jSONObject.put("$lib_version", this.mDeviceInfo.get("$lib_version"));
            jSONObject.put("$manufacturer", this.mDeviceInfo.get("$manufacturer"));
            jSONObject.put("$model", this.mDeviceInfo.get("$model"));
            jSONObject.put("$brand", this.mDeviceInfo.get("$brand"));
            jSONObject.put("$os", this.mDeviceInfo.get("$os"));
            jSONObject.put("$os_version", this.mDeviceInfo.get("$os_version"));
            jSONObject.put("$screen_height", this.mDeviceInfo.get("$screen_height"));
            jSONObject.put("$screen_width", this.mDeviceInfo.get("$screen_width"));
            String networkType = NetworkUtils.networkType(this.mContext);
            jSONObject.put("$wifi", "WIFI".equals(networkType));
            jSONObject.put("$network_type", networkType);
            jSONObject.put("$carrier", this.mDeviceInfo.get("$carrier"));
            jSONObject.put("$app_id", this.mDeviceInfo.get("$app_id"));
            jSONObject.put("$timezone_offset", this.mDeviceInfo.get("$timezone_offset"));
            if (this.mDeviceInfo.containsKey("$anonymization_id")) {
                jSONObject.put("$anonymization_id", this.mDeviceInfo.get("$anonymization_id"));
            }
            String str3 = str;
            if (this.mDeviceInfo.containsKey(str3)) {
                jSONObject.put(str3, this.mDeviceInfo.get(str3));
            }
            String str4 = str2;
            jSONObject.put(str4, this.mDeviceInfo.get(str4));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return jSONObject;
    }

    public boolean isAppStartSuccess() {
        return this.isAppStartSuccess;
    }

    public void removeEventListener(SAEventListener sAEventListener) {
        try {
            List<SAEventListener> list = this.mEventListenerList;
            if (list != null && list.contains(sAEventListener)) {
                this.mEventListenerList.remove(sAEventListener);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void setAppStartSuccess(boolean z11) {
        this.isAppStartSuccess = z11;
    }
}
