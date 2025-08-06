package com.sensorsdata.analytics.android.sdk.visual.property;

import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper;
import com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback;
import com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualPropertiesH5Helper implements WebViewJavascriptBridge {
    private JSBridgeHelper mJSBridgeHelper = new JSBridgeHelper();
    private SAEventListener mSAEventListener;
    /* access modifiers changed from: private */
    public SparseArray<JSONArray> mSparseArray = new SparseArray<>();

    private static String Base642string(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    private void addSAEventListener() {
        if (this.mSAEventListener == null) {
            this.mSAEventListener = new SAEventListener() {
                public void identify() {
                }

                public void login() {
                }

                public void logout() {
                }

                public void resetAnonymousId() {
                }

                public void trackEvent(JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    try {
                        if (TextUtils.equals(AopConstants.WEB_CLICK_EVENT_NAME, jSONObject.optString("event")) && (optJSONObject = jSONObject.optJSONObject("properties")) != null) {
                            if (optJSONObject.has("sensorsdata_web_visual_eventName")) {
                                VisualPropertiesH5Helper.this.mSparseArray.put(jSONObject.hashCode(), optJSONObject.optJSONArray("sensorsdata_web_visual_eventName"));
                                optJSONObject.remove("sensorsdata_web_visual_eventName");
                            }
                            String optString = optJSONObject.optString("sensorsdata_app_visual_properties");
                            optJSONObject.remove("sensorsdata_app_visual_properties");
                            if (TextUtils.isEmpty(optString)) {
                                return;
                            }
                            if (AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                                String decodeString = Base64Coder.decodeString(optString);
                                if (!TextUtils.isEmpty(decodeString)) {
                                    try {
                                        JSONArray jSONArray = new JSONArray(decodeString);
                                        if (jSONArray.length() > 0) {
                                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                                                VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                                visualProperty.elementPath = jSONObject2.optString("element_path");
                                                visualProperty.elementPosition = jSONObject2.optString("element_position");
                                                visualProperty.screenName = jSONObject2.optString("screen_name");
                                                visualProperty.name = jSONObject2.optString("name");
                                                visualProperty.regular = jSONObject2.optString("regular");
                                                visualProperty.isH5 = jSONObject2.optBoolean("h5");
                                                visualProperty.type = jSONObject2.optString("type");
                                                visualProperty.webViewElementPath = jSONObject2.optString("webview_element_path");
                                                VisualPropertiesManager.getInstance().mergeAppVisualProperty(visualProperty, (VisualConfig.VisualEvent) null, optJSONObject, (ViewNode) null);
                                            }
                                        }
                                    } catch (JSONException e11) {
                                        SALog.printStackTrace(e11);
                                    }
                                }
                            }
                        }
                    } catch (Exception e12) {
                        SALog.printStackTrace(e12);
                    }
                }
            };
            SensorsDataAPI.sharedInstance().addEventListener(this.mSAEventListener);
        }
    }

    private void getJSVisualProperties(View view, String str, String str2, OnBridgeCallback onBridgeCallback) {
        try {
            JSONArray h5JsonArrayFromCache = VisualPropertiesManager.getInstance().getVisualPropertiesCache().getH5JsonArrayFromCache(str2, str);
            if (h5JsonArrayFromCache != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sensorsdata_js_visual_properties", h5JsonArrayFromCache);
                } catch (JSONException e11) {
                    SALog.printStackTrace(e11);
                }
                sendToWeb(view, "getJSVisualProperties", jSONObject, onBridgeCallback);
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public void clearCache(int i11) {
        try {
            this.mSparseArray.remove(i11);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public JSONArray getEventName(int i11) {
        try {
            return this.mSparseArray.get(i11);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public void mergeJSVisualProperties(final JSONObject jSONObject, HashSet<String> hashSet, String str) {
        View view;
        if (hashSet != null) {
            try {
                if (hashSet.size() != 0) {
                    Iterator<String> it2 = hashSet.iterator();
                    final CountDownLatch countDownLatch = new CountDownLatch(hashSet.size());
                    while (it2.hasNext()) {
                        ViewNode viewNode = ViewTreeStatusObservable.getInstance().getViewNode(it2.next());
                        if (!(viewNode == null || viewNode.getView() == null || (view = (View) viewNode.getView().get()) == null)) {
                            getJSVisualProperties(view, viewNode.getViewPath(), str, new OnBridgeCallback() {
                                public void onCallBack(String str) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(str);
                                        Iterator<String> keys = jSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            String optString = jSONObject.optString(next);
                                            if (!TextUtils.isEmpty(next)) {
                                                jSONObject.put(next, optString);
                                            }
                                        }
                                    } catch (JSONException e11) {
                                        SALog.printStackTrace(e11);
                                    } catch (Throwable th2) {
                                        countDownLatch.countDown();
                                        throw th2;
                                    }
                                    countDownLatch.countDown();
                                }
                            });
                        }
                    }
                    try {
                        countDownLatch.await(500, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            } catch (Exception e12) {
                SALog.printStackTrace(e12);
            }
        }
    }

    public void registerListeners() {
        try {
            this.mJSBridgeHelper.addSAJSListener();
            addSAEventListener();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void sendToWeb(View view, String str, Object obj, OnBridgeCallback onBridgeCallback) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj, onBridgeCallback);
    }

    public void sendToWeb(View view, String str, Object obj) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj);
    }
}
