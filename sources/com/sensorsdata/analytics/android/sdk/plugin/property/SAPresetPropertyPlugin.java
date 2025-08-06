package com.sensorsdata.analytics.android.sdk.plugin.property;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.DeviceUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sumsub.sns.internal.core.common.n0;
import java.util.Map;
import java.util.Set;

public final class SAPresetPropertyPlugin extends SAPropertyPlugin {
    private final Context mContext;
    private final boolean mDisableAndroidId;
    private final boolean mDisableTrackDeviceId;

    public SAPresetPropertyPlugin(Context context, boolean z11, boolean z12) {
        this.mContext = context;
        this.mDisableTrackDeviceId = z11;
        this.mDisableAndroidId = z12;
    }

    public void appendDynamicProperties(Map<String, Object> map) {
    }

    public void appendProperties(Map<String, Object> map) {
        if (AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
            String harmonyOSVersion = DeviceUtils.getHarmonyOSVersion();
            if (!TextUtils.isEmpty(harmonyOSVersion)) {
                map.put("$os", "HarmonyOS");
                map.put("$os_version", harmonyOSVersion);
            } else {
                map.put("$os", n0.f32119g);
                map.put("$os_version", DeviceUtils.getOS());
            }
            map.put("$lib", n0.f32119g);
            map.put("$lib_version", SensorsDataAPI.sharedInstance().getSDKVersion());
            map.put("$manufacturer", DeviceUtils.getManufacturer());
            map.put("$model", DeviceUtils.getModel());
            map.put("$brand", DeviceUtils.getBrand());
            map.put("$app_version", AppInfoUtils.getAppVersionName(this.mContext));
            int[] deviceSize = DeviceUtils.getDeviceSize(this.mContext);
            map.put("$screen_width", Integer.valueOf(deviceSize[0]));
            map.put("$screen_height", Integer.valueOf(deviceSize[1]));
            String carrier = SensorsDataUtils.getCarrier(this.mContext);
            if (!TextUtils.isEmpty(carrier)) {
                map.put("$carrier", carrier);
            }
            Integer zoneOffset = TimeUtils.getZoneOffset();
            if (zoneOffset != null) {
                map.put("$timezone_offset", zoneOffset);
            }
            map.put("$app_id", AppInfoUtils.getProcessName(this.mContext));
            map.put("$app_name", AppInfoUtils.getAppName(this.mContext));
            String androidID = SensorsDataUtils.getAndroidID(this.mContext);
            if (!this.mDisableTrackDeviceId && !TextUtils.isEmpty(androidID)) {
                if (this.mDisableAndroidId) {
                    map.put("$anonymization_id", Base64Coder.encodeString(androidID));
                } else {
                    map.put("$device_id", androidID);
                }
            }
        }
    }

    public void eventNameFilter(Set<String> set) {
    }

    public void eventTypeFilter(Set<EventType> set) {
        set.add(EventType.TRACK);
        set.add(EventType.TRACK_SIGNUP);
        set.add(EventType.TRACK_ID_BIND);
        set.add(EventType.TRACK_ID_UNBIND);
    }

    public SAPropertyPluginPriority priority() {
        return SAPropertyPluginPriority.LOW;
    }

    public void propertyKeyFilter(Set<String> set) {
    }
}
