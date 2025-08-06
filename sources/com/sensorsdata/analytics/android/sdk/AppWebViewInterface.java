package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.sumsub.sns.internal.core.common.n0;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class AppWebViewInterface {
    private static final String TAG = "SA.AppWebViewInterface";
    private final boolean enableVerify;
    private final Context mContext;
    private WeakReference<View> mWebView;
    private JSONObject properties;

    public AppWebViewInterface(Context context, JSONObject jSONObject, boolean z11) {
        this(context, jSONObject, z11, (View) null);
    }

    @JavascriptInterface
    public boolean sensorsdata_abtest_module() {
        try {
            if (ReflectUtil.callStaticMethod(ReflectUtil.getCurrentClass(new String[]{"com.sensorsdata.abtest.SensorsABTest"}), "shareInstance", new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    @JavascriptInterface
    public String sensorsdata_call_app() {
        try {
            if (this.properties == null) {
                this.properties = new JSONObject();
            }
            this.properties.put("type", n0.f32119g);
            String loginId = SensorsDataAPI.sharedInstance(this.mContext).getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                this.properties.put("distinct_id", loginId);
                this.properties.put("is_login", true);
            } else {
                this.properties.put("distinct_id", SensorsDataAPI.sharedInstance(this.mContext).getAnonymousId());
                this.properties.put("is_login", false);
            }
            return this.properties.toString();
        } catch (JSONException e11) {
            SALog.i(TAG, e11.getMessage());
            return null;
        }
    }

    @JavascriptInterface
    public String sensorsdata_get_app_visual_config() {
        try {
            if (!AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                return null;
            }
            VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().registerListeners();
            String visualCache = VisualPropertiesManager.getInstance().getVisualPropertiesCache().getVisualCache();
            if (!TextUtils.isEmpty(visualCache)) {
                return Base64.encodeToString(visualCache.getBytes(), 0);
            }
            return null;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    @JavascriptInterface
    public String sensorsdata_get_server_url() {
        SensorsDataAPI.sharedInstance();
        return AbstractSensorsDataAPI.getConfigOptions().isAutoTrackWebView ? SensorsDataAPI.sharedInstance().getServerUrl() : "";
    }

    @JavascriptInterface
    public void sensorsdata_js_call_app(String str) {
        try {
            if (this.mWebView != null) {
                SensorsDataAPI.sharedInstance().handleJsMessage(this.mWebView, str);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    @JavascriptInterface
    public void sensorsdata_track(String str) {
        try {
            SALog.i(TAG, "sensorsdata_track event = " + str);
            SensorsDataAPI.sharedInstance(this.mContext).trackEventFromH5(str, this.enableVerify);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    @JavascriptInterface
    public boolean sensorsdata_verify(String str) {
        try {
            SALog.i(TAG, "sensorsdata_verify event = " + str);
            if (this.enableVerify) {
                return SensorsDataAPI.sharedInstance(this.mContext)._trackEventFromH5(str);
            }
            sensorsdata_track(str);
            return true;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    @JavascriptInterface
    public boolean sensorsdata_visual_verify(String str) {
        try {
            SALog.i(TAG, "sensorsdata_visual_verify event = " + str);
            if (!this.enableVerify) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String optString = new JSONObject(str).optString("server_url");
            if (!TextUtils.isEmpty(optString)) {
                return new ServerUrl(optString).check(new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()));
            }
            return false;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public AppWebViewInterface(Context context, JSONObject jSONObject, boolean z11, View view) {
        this.mContext = context;
        this.properties = jSONObject;
        this.enableVerify = z11;
        if (view != null) {
            this.mWebView = new WeakReference<>(view);
        }
    }
}
