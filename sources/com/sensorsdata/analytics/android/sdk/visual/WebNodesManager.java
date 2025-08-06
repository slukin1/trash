package com.sensorsdata.analytics.android.sdk.visual;

import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebNodesManager {
    private static final String CALL_TYPE_PAGE_INFO = "page_info";
    private static final String CALL_TYPE_VISUALIZED_TRACK = "visualized_track";
    private static final int LRU_CACHE_MAX_SIZE = 10;
    private static final String TAG = "SA.Visual.WebNodesManager";
    private static volatile WebNodesManager mSingleton;
    private static LruCache<String, WebNodeInfo> sPageInfoCache;
    private static LruCache<String, WebNodeInfo> sWebNodesCache;
    private boolean mHasH5AlertInfo;
    private boolean mHasWebView;
    private String mLastWebNodeMsg = null;
    private String mWebViewUrl;

    public static class WebNodeRect {
        public float left;
        public float top;

        public WebNodeRect(float f11, float f12) {
            this.top = f11;
            this.left = f12;
        }
    }

    private WebNodesManager() {
    }

    private void findWebNodes(JSONArray jSONArray, List<WebNode> list, Map<String, WebNodeRect> map) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                        WebNode webNode = new WebNode();
                        webNode.setId(optJSONObject.optString("id"));
                        webNode.set$element_content(optJSONObject.optString(AopConstants.ELEMENT_CONTENT));
                        webNode.set$element_selector(optJSONObject.optString(AopConstants.ELEMENT_SELECTOR));
                        webNode.setTagName(optJSONObject.optString(Constants.FLAG_TAG_NAME));
                        webNode.setTop((float) optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_TOP_KEY));
                        webNode.setLeft((float) optJSONObject.optDouble("left"));
                        webNode.setScrollX((float) optJSONObject.optDouble("scrollX"));
                        webNode.setScrollY((float) optJSONObject.optDouble("scrollY"));
                        webNode.setWidth((float) optJSONObject.optDouble("width"));
                        webNode.setHeight((float) optJSONObject.optDouble("height"));
                        webNode.setScale((float) optJSONObject.optDouble("scale"));
                        webNode.setVisibility(optJSONObject.optBoolean("visibility"));
                        webNode.set$url(optJSONObject.optString("$url"));
                        webNode.setzIndex(optJSONObject.optInt("zIndex"));
                        webNode.set$title(optJSONObject.optString(AopConstants.TITLE));
                        webNode.setLevel(optJSONObject.optInt(FirebaseAnalytics.Param.LEVEL));
                        webNode.set$element_path(optJSONObject.optString(AopConstants.ELEMENT_PATH));
                        webNode.set$element_position(optJSONObject.optString(AopConstants.ELEMENT_POSITION));
                        webNode.setList_selector(optJSONObject.optString("list_selector"));
                        webNode.setLib_version(optJSONObject.optString("lib_version"));
                        webNode.setEnable_click(optJSONObject.optBoolean("enable_click", true));
                        webNode.setIs_list_view(optJSONObject.optBoolean("is_list_view"));
                        JSONArray optJSONArray = optJSONObject.optJSONArray("subelements");
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i12 = 0; i12 < optJSONArray.length(); i12++) {
                                String optString = optJSONArray.optString(i12);
                                if (!TextUtils.isEmpty(optString)) {
                                    arrayList.add(optString);
                                    if (!map.containsKey(optString)) {
                                        map.put(optString, new WebNodeRect(webNode.getTop(), webNode.getLeft()));
                                    }
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            webNode.setSubelements(arrayList);
                        }
                        list.add(webNode);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static WebNodesManager getInstance() {
        if (mSingleton == null) {
            synchronized (WebNodesManager.class) {
                if (mSingleton == null) {
                    mSingleton = new WebNodesManager();
                }
            }
        }
        return mSingleton;
    }

    private void modifyWebNodes(List<WebNode> list, Map<String, WebNodeRect> map) {
        if (list != null && list.size() != 0) {
            synchronized (this) {
                for (WebNode next : list) {
                    next.setOriginLeft(next.getLeft());
                    next.setOriginTop(next.getTop());
                    if (!map.containsKey(next.getId())) {
                        next.setRootView(true);
                        next.setTop(next.getTop() + next.getScrollY());
                        next.setLeft(next.getLeft() + next.getScrollX());
                    } else {
                        WebNodeRect webNodeRect = map.get(next.getId());
                        if (webNodeRect != null) {
                            next.setTop(next.getTop() - webNodeRect.top);
                            next.setLeft(next.getLeft() - webNodeRect.left);
                        }
                    }
                }
            }
        }
    }

    private List<WebNodeInfo.AlertInfo> parseAlertResult(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            int i11 = 0;
            while (i11 < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    if (jSONObject != null) {
                        arrayList2.add(new WebNodeInfo.AlertInfo(jSONObject.optString("title"), jSONObject.optString("message"), jSONObject.optString("link_text"), jSONObject.optString("link_url")));
                    }
                    i11++;
                } catch (JSONException e11) {
                    e = e11;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                } catch (Exception e12) {
                    e = e12;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e13) {
            e = e13;
            SALog.printStackTrace(e);
            return arrayList;
        } catch (Exception e14) {
            e = e14;
            SALog.printStackTrace(e);
            return arrayList;
        }
    }

    private WebNodeInfo parsePageInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            return WebNodeInfo.createPageInfo(jSONObject.optString(AopConstants.TITLE), jSONObject.optString("$url"));
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private List<WebNode> parseResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extra_elements");
            if (optJSONArray != null) {
                findWebNodes(optJSONArray, arrayList, hashMap);
            }
            if (optJSONArray2 != null) {
                findWebNodes(optJSONArray2, arrayList, hashMap);
            }
            if (!hashMap.isEmpty()) {
                modifyWebNodes(arrayList, hashMap);
            }
            try {
                Collections.sort(arrayList, new Comparator<WebNode>() {
                    public int compare(WebNode webNode, WebNode webNode2) {
                        return webNode.getLevel() - webNode2.getLevel();
                    }
                });
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        } catch (JSONException e12) {
            SALog.printStackTrace(e12);
        } catch (Exception e13) {
            SALog.printStackTrace(e13);
        }
        return arrayList;
    }

    public void clear() {
        this.mLastWebNodeMsg = null;
        this.mHasH5AlertInfo = false;
    }

    public String getLastWebNodeMsg() {
        return this.mLastWebNodeMsg;
    }

    public WebNodeInfo getWebNodes(String str) {
        if ((!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) || Build.VERSION.SDK_INT < 12) {
            return null;
        }
        if (sWebNodesCache == null) {
            sWebNodesCache = new LruCache<>(10);
        }
        return sWebNodesCache.get(str);
    }

    public WebNodeInfo getWebPageInfo(String str) {
        if ((!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) || Build.VERSION.SDK_INT < 12) {
            return null;
        }
        if (sPageInfoCache == null) {
            sPageInfoCache = new LruCache<>(10);
        }
        return sPageInfoCache.get(str);
    }

    public void handlerFailure(String str, String str2) {
        try {
            Dispatcher.getInstance().removeCallbacksAndMessages();
            if ((VisualizedAutoTrackService.getInstance().isServiceRunning() || HeatMapService.getInstance().isServiceRunning()) && !TextUtils.isEmpty(str2)) {
                SALog.i(TAG, "handlerFailure url " + str + ",msg: " + str2);
                this.mHasH5AlertInfo = true;
                this.mLastWebNodeMsg = String.valueOf(System.currentTimeMillis());
                List<WebNodeInfo.AlertInfo> parseAlertResult = parseAlertResult(str2);
                if (parseAlertResult != null && parseAlertResult.size() > 0 && Build.VERSION.SDK_INT >= 12) {
                    if (sWebNodesCache == null) {
                        sWebNodesCache = new LruCache<>(10);
                    }
                    sWebNodesCache.put(str, WebNodeInfo.createWebAlertInfo(parseAlertResult));
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A[Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handlerMessage(java.lang.String r7) {
        /*
            r6 = this;
            com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher r0 = com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher.getInstance()
            r0.removeCallbacksAndMessages()
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r0 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r0 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6.mLastWebNodeMsg = r0
            r0 = 0
            r6.mHasH5AlertInfo = r0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            java.lang.String r2 = "callType"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r4 = 817885468(0x30bff11c, float:1.3965606E-9)
            r5 = 1
            if (r3 == r4) goto L_0x0056
            r0 = 883555422(0x34a9fc5e, float:3.1662324E-7)
            if (r3 == r0) goto L_0x004c
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "page_info"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 == 0) goto L_0x005f
            r0 = r5
            goto L_0x0060
        L_0x0056:
            java.lang.String r3 = "visualized_track"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r1 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            r1 = 10
            r2 = 12
            if (r0 == 0) goto L_0x008e
            if (r0 == r5) goto L_0x0069
            goto L_0x00c6
        L_0x0069:
            com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r7 = r6.parsePageInfo(r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r7 == 0) goto L_0x00c6
            java.lang.String r0 = r7.getUrl()     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r6.mWebViewUrl = r0     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 < r2) goto L_0x00c6
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sPageInfoCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 != 0) goto L_0x0084
            android.util.LruCache r0 = new android.util.LruCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            sPageInfoCache = r0     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
        L_0x0084:
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sPageInfoCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            java.lang.String r1 = r7.getUrl()     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            goto L_0x00c6
        L_0x008e:
            java.util.List r7 = r6.parseResult(r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r7 == 0) goto L_0x00c6
            int r0 = r7.size()     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 <= 0) goto L_0x00c6
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 < r2) goto L_0x00c6
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sWebNodesCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 != 0) goto L_0x00a9
            android.util.LruCache r0 = new android.util.LruCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            sWebNodesCache = r0     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
        L_0x00a9:
            java.lang.String r0 = r6.mWebViewUrl     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            if (r0 != 0) goto L_0x00c6
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo> r0 = sWebNodesCache     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            java.lang.String r1 = r6.mWebViewUrl     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r7 = com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.createWebNodesInfo(r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x00c2, Exception -> 0x00bd }
            goto L_0x00c6
        L_0x00bd:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
            goto L_0x00c6
        L_0x00c2:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.handlerMessage(java.lang.String):void");
    }

    public boolean hasH5AlertInfo() {
        return this.mHasH5AlertInfo;
    }

    public boolean hasWebView() {
        return this.mHasWebView;
    }

    public void setHasWebView(boolean z11) {
        this.mHasWebView = z11;
    }
}
