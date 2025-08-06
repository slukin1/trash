package com.sensorsdata.analytics.android.sdk.visual.property;

import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentVisualConfig;
import com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import com.sumsub.sentry.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualPropertiesCache {
    private static final String TAG = "SA.VP.VisualPropertiesCache";
    private PersistentVisualConfig mPersistentVisualConfig = ((PersistentVisualConfig) PersistentLoader.loadPersistent(DbParams.PersistentName.VISUAL_PROPERTIES));

    private void doOnSaveCache(String str) {
        try {
            List<View> currentWebView = ViewTreeStatusObservable.getInstance().getCurrentWebView();
            if (currentWebView == null) {
                return;
            }
            if (currentWebView.size() != 0) {
                for (View sendToWeb : currentWebView) {
                    VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().sendToWeb(sendToWeb, "updateH5VisualConfig", str);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public JSONArray getH5JsonArrayFromCache(String str, String str2) {
        String str3 = (String) this.mPersistentVisualConfig.get();
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray = jSONObject.optJSONArray(DbParams.TABLE_EVENTS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new VisualConfig.VisualPropertiesConfig();
                        String optString = optJSONObject.optString("event_name");
                        visualPropertiesConfig.eventName = optString;
                        if (TextUtils.equals(optString, str)) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("properties");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i12);
                                    VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                    String optString2 = optJSONObject2.optString("webview_element_path");
                                    visualProperty.webViewElementPath = optString2;
                                    if (TextUtils.equals(optString2, str2)) {
                                        jSONArray.put(optJSONObject2);
                                    }
                                }
                            }
                        }
                    }
                }
                return jSONArray;
            }
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
        return null;
    }

    public String getVisualCache() {
        return (String) this.mPersistentVisualConfig.get();
    }

    public VisualConfig getVisualConfig() {
        String str = (String) this.mPersistentVisualConfig.get();
        SALog.i(TAG, "local visual config is :" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            VisualConfig visualConfig = new VisualConfig();
            JSONObject jSONObject = new JSONObject(str);
            visualConfig.appId = jSONObject.optString("app_id");
            visualConfig.f29943os = jSONObject.optString(q.f30469g);
            visualConfig.project = jSONObject.optString("project");
            visualConfig.version = jSONObject.optString("version");
            JSONArray optJSONArray = jSONObject.optJSONArray(DbParams.TABLE_EVENTS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new VisualConfig.VisualPropertiesConfig();
                        visualPropertiesConfig.eventName = optJSONObject.optString("event_name");
                        visualPropertiesConfig.eventType = optJSONObject.optString("event_type");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("event");
                        if (optJSONObject2 != null) {
                            VisualConfig.VisualEvent visualEvent = new VisualConfig.VisualEvent();
                            visualEvent.elementPath = optJSONObject2.optString("element_path");
                            visualEvent.elementPosition = optJSONObject2.optString("element_position");
                            visualEvent.elementContent = optJSONObject2.optString("element_content");
                            visualEvent.screenName = optJSONObject2.optString("screen_name");
                            visualEvent.limitElementPosition = optJSONObject2.optBoolean("limit_element_position");
                            visualEvent.limitElementContent = optJSONObject2.optBoolean("limit_element_content");
                            visualEvent.isH5 = optJSONObject2.optBoolean("h5");
                            visualPropertiesConfig.event = visualEvent;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("properties");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i12);
                                VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                visualProperty.elementPath = optJSONObject3.optString("element_path");
                                visualProperty.elementPosition = optJSONObject3.optString("element_position");
                                visualProperty.screenName = optJSONObject3.optString("screen_name");
                                visualProperty.name = optJSONObject3.optString("name");
                                visualProperty.regular = optJSONObject3.optString("regular");
                                visualProperty.isH5 = optJSONObject3.optBoolean("h5");
                                visualProperty.type = optJSONObject3.optString("type");
                                visualProperty.webViewElementPath = optJSONObject3.optString("webview_element_path");
                                arrayList2.add(visualProperty);
                            }
                            visualPropertiesConfig.properties = arrayList2;
                        }
                        arrayList.add(visualPropertiesConfig);
                    }
                }
                visualConfig.events = arrayList;
            }
            return visualConfig;
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public void save2Cache(String str) {
        SALog.i(TAG, "save2Cache config is:" + str);
        this.mPersistentVisualConfig.commit(str);
        doOnSaveCache(str);
    }
}
