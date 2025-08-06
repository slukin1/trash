package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.webkit.WebView;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.jumio.core.cdn.CDNDownload;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class SensorsDataAPIEmptyImplementation extends SensorsDataAPI {
    public void addHeatMapActivities(List<Class<?>> list) {
    }

    public void addHeatMapActivity(Class<?> cls) {
    }

    public void addSAJSListener(SAJSListener sAJSListener) {
    }

    public void addVisualizedAutoTrackActivities(List<Class<?>> list) {
    }

    public void addVisualizedAutoTrackActivity(Class<?> cls) {
    }

    public void appBecomeActive() {
    }

    public void appEnterBackground() {
    }

    public void clearGPSLocation() {
    }

    public void clearLastScreenUrl() {
    }

    public void clearReferrerWhenAppEnd() {
    }

    public void clearSuperProperties() {
    }

    public void clearTrackTimer() {
    }

    public void deleteAll() {
    }

    public void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
    }

    public void disableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
    }

    public void enableAutoTrack(int i11) {
    }

    public void enableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
    }

    public void enableAutoTrackFragment(Class<?> cls) {
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
    }

    public void enableDataCollect() {
    }

    public void enableDeepLinkInstallSource(boolean z11) {
    }

    public void enableLog(boolean z11) {
    }

    public void enableNetworkRequest(boolean z11) {
    }

    public void enableTrackScreenOrientation(boolean z11) {
    }

    public void flush() {
    }

    public void flushScheduled() {
    }

    public void flushSync() {
    }

    public String getAnonymousId() {
        return null;
    }

    public String getCookie(boolean z11) {
        return null;
    }

    public String getDistinctId() {
        return null;
    }

    public int getFlushBulkSize() {
        return 100;
    }

    public int getFlushInterval() {
        return DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
    }

    public int getFlushNetworkPolicy() {
        return 0;
    }

    public JSONObject getIdentities() {
        return new JSONObject();
    }

    public List<Class> getIgnoredViewTypeList() {
        return new ArrayList();
    }

    public JSONObject getLastScreenTrackProperties() {
        return new JSONObject();
    }

    public String getLastScreenUrl() {
        return null;
    }

    public String getLoginId() {
        return null;
    }

    public long getMaxCacheSize() {
        return 33554432;
    }

    public JSONObject getPresetProperties() {
        return new JSONObject();
    }

    public String getScreenOrientation() {
        return "";
    }

    public String getServerUrl() {
        return null;
    }

    public int getSessionIntervalTime() {
        return CDNDownload.DEFAULT_TIMEOUT;
    }

    public JSONObject getSuperProperties() {
        return new JSONObject();
    }

    public void identify(String str) {
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
    }

    public void ignoreView(View view) {
    }

    public void ignoreView(View view, boolean z11) {
    }

    public void ignoreViewType(Class cls) {
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        return true;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        return true;
    }

    public boolean isAutoTrackEnabled() {
        return false;
    }

    public boolean isAutoTrackEventTypeIgnored(int i11) {
        return true;
    }

    public boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        return true;
    }

    public boolean isDebugMode() {
        return false;
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        return false;
    }

    public boolean isHeatMapActivity(Class<?> cls) {
        return false;
    }

    public boolean isHeatMapEnabled() {
        return false;
    }

    public boolean isNetworkRequestEnable() {
        return false;
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return false;
    }

    public boolean isVisualizedAutoTrackActivity(Class<?> cls) {
        return false;
    }

    public boolean isVisualizedAutoTrackEnabled() {
        return false;
    }

    public void itemDelete(String str, String str2) {
    }

    public void itemSet(String str, String str2, JSONObject jSONObject) {
    }

    public void login(String str) {
    }

    public void login(String str, JSONObject jSONObject) {
    }

    public void loginWithKey(String str, String str2) {
    }

    public void loginWithKey(String str, String str2, JSONObject jSONObject) {
    }

    public void logout() {
    }

    public void profileAppend(String str, String str2) {
    }

    public void profileAppend(String str, Set<String> set) {
    }

    public void profileDelete() {
    }

    public void profileIncrement(String str, Number number) {
    }

    public void profileIncrement(Map<String, ? extends Number> map) {
    }

    public void profilePushId(String str, String str2) {
    }

    public void profileSet(String str, Object obj) {
    }

    public void profileSet(JSONObject jSONObject) {
    }

    public void profileSetOnce(String str, Object obj) {
    }

    public void profileSetOnce(JSONObject jSONObject) {
    }

    public void profileUnset(String str) {
    }

    public void profileUnsetPushId(String str) {
    }

    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
    }

    public void registerSuperProperties(JSONObject jSONObject) {
    }

    public void removeTimer(String str) {
    }

    public void requestDeferredDeepLink(JSONObject jSONObject) {
    }

    public void resetAnonymousId() {
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
    }

    public void resumeTrackScreenOrientation() {
    }

    public void setCookie(String str, boolean z11) {
    }

    public void setDebugMode(SensorsDataAPI.DebugMode debugMode) {
    }

    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
    }

    public void setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
    }

    public void setFlushBulkSize(int i11) {
    }

    public void setFlushInterval(int i11) {
    }

    public void setFlushNetworkPolicy(int i11) {
    }

    public void setGPSLocation(double d11, double d12) {
    }

    public void setGPSLocation(double d11, double d12, String str) {
    }

    public void setMaxCacheSize(long j11) {
    }

    public void setServerUrl(String str) {
    }

    public void setServerUrl(String str, boolean z11) {
    }

    public void setSessionIntervalTime(int i11) {
    }

    public void setTrackEventCallBack(SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
    }

    public void setViewActivity(View view, Activity activity) {
    }

    public void setViewFragmentName(View view, String str) {
    }

    public void setViewID(Dialog dialog, String str) {
    }

    public void setViewID(View view, String str) {
    }

    public void setViewID(Object obj, String str) {
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
    }

    @Deprecated
    public void showUpWebView(WebView webView, JSONObject jSONObject, boolean z11, boolean z12) {
    }

    public void showUpWebView(WebView webView, boolean z11) {
    }

    @Deprecated
    public void showUpWebView(WebView webView, boolean z11, JSONObject jSONObject) {
    }

    public void showUpWebView(WebView webView, boolean z11, boolean z12) {
    }

    public void showUpX5WebView(Object obj) {
    }

    @Deprecated
    public void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z11, boolean z12) {
    }

    public void showUpX5WebView(Object obj, boolean z11) {
    }

    public void startTrackThread() {
    }

    public void stopTrackScreenOrientation() {
    }

    public void stopTrackThread() {
    }

    public void track(String str) {
    }

    public void track(String str, JSONObject jSONObject) {
    }

    public void trackAppInstall() {
    }

    public void trackAppInstall(JSONObject jSONObject) {
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z11) {
    }

    public void trackChannelEvent(String str) {
    }

    public void trackChannelEvent(String str, JSONObject jSONObject) {
    }

    public void trackDeepLinkLaunch(String str) {
    }

    public void trackDeepLinkLaunch(String str, String str2) {
    }

    public void trackEvent(EventType eventType, String str, JSONObject jSONObject, String str2) {
    }

    public void trackEventFromH5(String str) {
    }

    public void trackEventFromH5(String str, boolean z11) {
    }

    public void trackFragmentAppViewScreen() {
    }

    public void trackInstallation(String str) {
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z11) {
    }

    public void trackInternal(String str, JSONObject jSONObject) {
    }

    @Deprecated
    public void trackTimer(String str, TimeUnit timeUnit) {
    }

    public void trackTimerEnd(String str) {
    }

    public void trackTimerEnd(String str, JSONObject jSONObject) {
    }

    public void trackTimerPause(String str) {
    }

    public void trackTimerResume(String str) {
    }

    public String trackTimerStart(String str) {
        return "";
    }

    public void trackViewAppClick(View view) {
    }

    public void trackViewAppClick(View view, JSONObject jSONObject) {
    }

    public void trackViewScreen(Activity activity) {
    }

    public void trackViewScreen(Object obj) {
    }

    public void trackViewScreen(String str, JSONObject jSONObject) {
    }

    public void unregisterSuperProperty(String str) {
    }
}
