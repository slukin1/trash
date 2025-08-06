package com.sensorsdata.analytics.android.advert.plugin;

import com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager;

public class SAAdvertPluginManager {
    private SAAdvertAppStartPlugin mStartPlugin = new SAAdvertAppStartPlugin();
    private SAAdvertAppViewScreenPlugin mViewScreenPlugin = new SAAdvertAppViewScreenPlugin();

    public void registerPlugin() {
        SensorsDataPropertyPluginManager.getInstance().registerPropertyPlugin(this.mStartPlugin);
        SensorsDataPropertyPluginManager.getInstance().registerPropertyPlugin(this.mViewScreenPlugin);
    }

    public void unregisterPlugin() {
        SensorsDataPropertyPluginManager.getInstance().unregisterPropertyPlugin(this.mStartPlugin);
        SensorsDataPropertyPluginManager.getInstance().unregisterPropertyPlugin(this.mViewScreenPlugin);
    }
}
