package com.huobi.domain.data.source.remote.bean.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RemoteFlutterFeatureConfig implements Serializable {
    private static final long serialVersionUID = -5337074144118688892L;
    @SerializedName("min_support_app_version")
    private int minSupportAppVersion;
    @SerializedName("module_switch")
    private boolean moduleSwitch;
    @SerializedName("no_support_device_model")
    private List<String> noSupportDeviceModelList;
    @SerializedName("support_sdk")
    private List<Integer> supportSdkList;

    public int getMinSupportAppVersion() {
        return this.minSupportAppVersion;
    }

    public List<String> getNoSupportDeviceModelList() {
        return this.noSupportDeviceModelList;
    }

    public List<Integer> getSupportSdkList() {
        return this.supportSdkList;
    }

    public boolean isModuleSwitch() {
        return this.moduleSwitch;
    }

    public void setMinSupportAppVersion(int i11) {
        this.minSupportAppVersion = i11;
    }

    public void setModuleSwitch(boolean z11) {
        this.moduleSwitch = z11;
    }

    public void setNoSupportDeviceModelList(List<String> list) {
        this.noSupportDeviceModelList = list;
    }

    public void setSupportSdkList(List<Integer> list) {
        this.supportSdkList = list;
    }

    public String toString() {
        return "RemoteFlutterFeatureConfig{moduleSwitch=" + this.moduleSwitch + ", supportSdkList=" + this.supportSdkList + ", noSupportDeviceModelList=" + this.noSupportDeviceModelList + ", minSupportAppVersion=" + this.minSupportAppVersion + '}';
    }
}
