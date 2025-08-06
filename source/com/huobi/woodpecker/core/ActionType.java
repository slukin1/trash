package com.huobi.woodpecker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.woodpecker.utils.ContextUtil;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashSet;
import java.util.Set;
import kv.b;
import kv.e;
import org.json.JSONException;
import org.json.JSONObject;

public enum ActionType {
    APP_CRASH("app_crash", 10, true),
    API("api", 20, false),
    APP_SOCKET("app_socket", 30, false),
    APP_SOCKET_TIMEOUT("ws_timeout", 31, false),
    APP_START("app_start", 40, false),
    APP_WEBVIEW("app_webview_perf", 50, false),
    APP_USER_BEHAVIOUR("app_user_behaviour", 60, false),
    APP_ACTION_PERF("app_action_perf", 70, false),
    APP_PAGE_PERF("app_page_perf", 80, false),
    APP_PAGE_VIEW("pv", 81, false),
    APP_NEW_USER("app_new_user", 82, false),
    APP_PAGE_TIME(CrashHianalyticsData.TIME, 83, false),
    APP_CUSTOM_EVENT("event", 91, true),
    APP_CUSTOM_GAUGE("gauge", 92, true),
    APP_CUSTOM_COUNTER("counter", 93, true),
    APP_CUSTOM_ERROR("uerror", 94, true),
    APP_CUSTOM_WARN("uwarn", 95, true),
    APP_CUSTOM_INFO("uinfo", 96, true),
    APP_COMMON("app_common", 97, true),
    APP_WEBVIEW_LIFE_CYCLE("app_webview_lifecycle", 97, true),
    DEFAULT("default", 900, false);
    
    private static final int DEFAULT_PRIORITY = 0;
    private static final String LOCAL_STORAGE_KEY = "switch_storage_key";
    private static final String TAG = "ActionType";
    private static boolean enableAll;
    public String action;
    private boolean isEnable;
    private Set<a> listenerSet;
    private int priority;

    public interface a {
        void a(boolean z11);
    }

    /* access modifiers changed from: public */
    static {
        ActionType actionType;
        DEFAULT_PRIORITY = actionType.priority;
        enableAll = false;
    }

    private ActionType(String str, int i11, boolean z11) {
        this.listenerSet = new HashSet();
        this.action = str;
        this.priority = i11;
        this.isEnable = z11;
    }

    public static void init(Context context) {
        String a11 = b.a(context, LOCAL_STORAGE_KEY, "");
        if (!TextUtils.isEmpty(a11)) {
            try {
                Log.d(TAG, "HBWP::: ActionType init cache=" + a11);
                update(context, new JSONObject(a11), true);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    private void notifyEnableChange() {
        if (!this.listenerSet.isEmpty()) {
            for (a a11 : this.listenerSet) {
                a11.a(this.isEnable);
            }
        }
    }

    private static JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ENABLED, enableAll);
            for (ActionType actionType : values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("enable", actionType.isEnable);
                jSONObject2.put("priority", actionType.priority);
                jSONObject.put(actionType.action, jSONObject2);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public static void update(JSONObject jSONObject) {
        e.c(TAG, "HBWP::: ActionType update json=" + jSONObject);
        update(ContextUtil.g(), jSONObject, false);
    }

    public static ActionType valueOF(String str) {
        for (ActionType actionType : values()) {
            if (actionType.action.equalsIgnoreCase(str)) {
                return actionType;
            }
        }
        return null;
    }

    public String getAction() {
        return this.action;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isAllEnable() {
        return enableAll;
    }

    public boolean isDisable() {
        return !isEnable();
    }

    public boolean isEnable() {
        return enableAll && this.isEnable;
    }

    public void register(a aVar) {
        register(aVar, true);
    }

    public String toString() {
        return this.action;
    }

    public void unRegister(a aVar) {
        this.listenerSet.remove(aVar);
    }

    public void unRegisterAll() {
        this.listenerSet.clear();
    }

    public static int getPriority(String str) {
        ActionType valueOF = valueOF(str);
        if (valueOF != null) {
            return valueOF.priority;
        }
        return DEFAULT_PRIORITY;
    }

    public static boolean isEnable(String str) {
        ActionType valueOF = valueOF(str);
        if (valueOF != null) {
            return valueOF.isEnable();
        }
        return false;
    }

    public void register(a aVar, boolean z11) {
        if (aVar != null) {
            this.listenerSet.add(aVar);
            if (z11 && enableAll && this.isEnable) {
                aVar.a(true);
            }
        }
    }

    private static void update(Context context, JSONObject jSONObject, boolean z11) {
        if (jSONObject != null) {
            enableAll = jSONObject.optBoolean(Constants.ENABLED, enableAll);
            for (ActionType actionType : values()) {
                JSONObject optJSONObject = jSONObject.optJSONObject(actionType.action);
                if (optJSONObject != null) {
                    boolean isEnable2 = actionType.isEnable();
                    if (optJSONObject.has("enable")) {
                        actionType.isEnable = optJSONObject.optBoolean("enable", actionType.isEnable);
                    } else if (optJSONObject.has(Constants.ENABLED)) {
                        actionType.isEnable = optJSONObject.optBoolean(Constants.ENABLED, actionType.isEnable);
                    }
                    actionType.priority = optJSONObject.optInt("priority", actionType.priority);
                    if (!z11 && isEnable2 != actionType.isEnable()) {
                        e.k(TAG, "type:" + actionType.action + "> The enable config was change " + isEnable2 + " to " + actionType.isEnable());
                        actionType.notifyEnableChange();
                    }
                }
            }
            b.d(context, LOCAL_STORAGE_KEY, toJson().toString());
        }
    }
}
