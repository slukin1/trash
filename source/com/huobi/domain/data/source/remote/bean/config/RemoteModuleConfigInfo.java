package com.huobi.domain.data.source.remote.bean.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RemoteModuleConfigInfo implements Serializable {
    private static final long serialVersionUID = 7222012107277957135L;
    @SerializedName("flutter_support")
    private RemoteFlutterFeatureConfig flutterFeatureConfig;

    public RemoteFlutterFeatureConfig getFlutterFeatureConfig() {
        return this.flutterFeatureConfig;
    }

    public void setFlutterFeatureConfig(RemoteFlutterFeatureConfig remoteFlutterFeatureConfig) {
        this.flutterFeatureConfig = remoteFlutterFeatureConfig;
    }

    public String toString() {
        return "RemoteModuleConfigInfo{flutterFeatureConfig=" + this.flutterFeatureConfig + '}';
    }
}
