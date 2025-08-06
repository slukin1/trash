package com.sensorsdata.analytics.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public interface SensorsExpandableListViewItemTrackProperties {
    JSONObject getSensorsChildItemTrackProperties(int i11, int i12) throws JSONException;

    JSONObject getSensorsGroupItemTrackProperties(int i11) throws JSONException;
}
