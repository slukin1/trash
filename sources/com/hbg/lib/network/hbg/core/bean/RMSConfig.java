package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RMSConfig implements Serializable {
    @SerializedName("appResources")
    public List<AppResConfigBean> appResources;
    @SerializedName("edgeEngine")
    public List<AppResConfigBean> edgeEngineResource;
    @SerializedName("h5")
    public List<AppResConfigBean> h5Resource;
    @SerializedName("skin")
    public List<AppResConfigBean> skinResource;
    @SerializedName("ts")
    public String timeStamp;
}
