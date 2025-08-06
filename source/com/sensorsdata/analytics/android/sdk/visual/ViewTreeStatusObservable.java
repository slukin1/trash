package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ViewTreeStatusObservable {
    private static final String TAG = "SA.ViewTreeStatusObservable";
    public static volatile ViewTreeStatusObservable viewTreeStatusObservable;
    private HashMap<String, ViewNode> mViewNodesHashMap = new HashMap<>();
    private SparseArray<ViewNode> mViewNodesWithHashCode = new SparseArray<>();
    private HashMap<String, ViewNode> mWebViewHashMap = new HashMap<>();

    private String generateKey(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
        }
        return sb2.toString();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getCacheViewPathAndPosition(android.view.View r10, boolean r11) {
        /*
            r9 = this;
            android.util.SparseArray<com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r0 = r9.mViewNodesWithHashCode
            int r1 = r10.hashCode()
            java.lang.Object r0 = r0.get(r1)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r0 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r0
            if (r0 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r0 = 0
            android.view.ViewParent r1 = r10.getParent()
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x001b
            r0 = r1
            android.view.View r0 = (android.view.View) r0
        L_0x001b:
            if (r0 != 0) goto L_0x0023
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r11 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewPathAndPosition(r10, r11)
            goto L_0x00b6
        L_0x0023:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.util.SparseArray<com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r3 = r9.mViewNodesWithHashCode
            int r4 = r0.hashCode()
            java.lang.Object r3 = r3.get(r4)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r3 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r3
            if (r3 != 0) goto L_0x0048
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r3 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewPathAndPosition(r0, r11)
            android.util.SparseArray<com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r4 = r9.mViewNodesWithHashCode
            int r5 = r0.hashCode()
            r4.put(r5, r3)
        L_0x0048:
            java.lang.String r4 = r3.getViewOriginalPath()
            r1.append(r4)
            java.lang.String r4 = r3.getViewPath()
            r2.append(r4)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r0 = r0.indexOfChild(r10)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r11 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewNode(r10, r0, r11)
            java.lang.String r0 = r3.getViewPosition()
            java.lang.String r3 = r11.getViewPath()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0090
            java.lang.String r3 = r11.getViewPath()
            java.lang.String r4 = "-"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0090
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0090
            int r3 = r2.lastIndexOf(r4)
            r4 = -1
            if (r3 == r4) goto L_0x0090
            int r4 = r3 + 1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.replace(r3, r4, r0)
        L_0x0090:
            java.lang.String r0 = r11.getViewOriginalPath()
            r1.append(r0)
            java.lang.String r0 = r11.getViewPath()
            r2.append(r0)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r0 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r5 = r11.getViewPosition()
            java.lang.String r6 = r1.toString()
            java.lang.String r7 = r2.toString()
            java.lang.String r8 = r11.getViewContent()
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r11 = r0
        L_0x00b6:
            android.util.SparseArray<com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r0 = r9.mViewNodesWithHashCode
            int r10 = r10.hashCode()
            r0.put(r10, r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getCacheViewPathAndPosition(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    public static ViewTreeStatusObservable getInstance() {
        if (viewTreeStatusObservable == null) {
            synchronized (ViewTreeStatusObservable.class) {
                if (viewTreeStatusObservable == null) {
                    viewTreeStatusObservable = new ViewTreeStatusObservable();
                }
            }
        }
        return viewTreeStatusObservable;
    }

    private void traverseNode() {
        traverseNode((View) null);
    }

    public void clearWebViewCache() {
        try {
            HashMap<String, ViewNode> hashMap = this.mWebViewHashMap;
            if (hashMap != null) {
                hashMap.clear();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public List<View> getCurrentWebView() {
        try {
            if (this.mWebViewHashMap.size() == 0) {
                traverseNode();
            }
            if (this.mWebViewHashMap.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (ViewNode view : this.mWebViewHashMap.values()) {
                WeakReference<View> view2 = view.getView();
                if (!(view2 == null || view2.get() == null)) {
                    arrayList.add(view2.get());
                }
            }
            return arrayList;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public ViewNode getViewNode(View view) {
        ViewNode viewNode = null;
        try {
            ViewNode viewNode2 = this.mViewNodesWithHashCode.get(view.hashCode());
            if (viewNode2 != null) {
                return viewNode2;
            }
            try {
                viewNode = getViewPathAndPosition(view);
                if (viewNode != null) {
                    this.mViewNodesWithHashCode.put(view.hashCode(), viewNode);
                }
            } catch (Exception e11) {
                e = e11;
                viewNode = viewNode2;
                SALog.printStackTrace(e);
                return viewNode;
            }
            return viewNode;
        } catch (Exception e12) {
            e = e12;
        }
    }

    public ViewNode getViewPathAndPosition(View view) {
        return getCacheViewPathAndPosition(view, false);
    }

    private void traverseNode(View view) {
        try {
            this.mViewNodesHashMap.clear();
            this.mViewNodesWithHashCode.clear();
            this.mWebViewHashMap.clear();
            SparseArray<ViewNode> sparseArray = new SparseArray<>();
            HashMap<String, ViewNode> hashMap = new HashMap<>();
            HashMap<String, ViewNode> hashMap2 = new HashMap<>();
            if (view != null) {
                traverseNode(view, sparseArray, hashMap, hashMap2);
            } else {
                for (View traverseNode : WindowHelper.getSortedWindowViews()) {
                    traverseNode(traverseNode, sparseArray, hashMap, hashMap2);
                }
            }
            this.mViewNodesHashMap = hashMap;
            this.mViewNodesWithHashCode = sparseArray;
            this.mWebViewHashMap = hashMap2;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewNode(java.lang.ref.WeakReference<android.view.View> r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r1 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x005c }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r1     // Catch:{ Exception -> 0x005c }
            if (r1 != 0) goto L_0x0061
            if (r4 == 0) goto L_0x0025
            java.lang.Object r2 = r4.get()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0022 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getRootView()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            r0 = r1
            goto L_0x005d
        L_0x0025:
            if (r0 != 0) goto L_0x0049
            com.sensorsdata.analytics.android.sdk.AppStateManager r4 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ Exception -> 0x0022 }
            android.app.Activity r4 = r4.getForegroundActivity()     // Catch:{ Exception -> 0x0022 }
            if (r4 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            boolean r2 = r2.isActive()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r4 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getDecorView()     // Catch:{ Exception -> 0x0022 }
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r3.traverseNode(r0)     // Catch:{ Exception -> 0x0022 }
        L_0x004e:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r4 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x0022 }
            java.lang.String r5 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0022 }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r4 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r4     // Catch:{ Exception -> 0x0022 }
            r1 = r4
            goto L_0x0061
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
            r1 = r0
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getViewNode(java.lang.ref.WeakReference, java.lang.String, java.lang.String, java.lang.String):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewNode(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r1 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x004f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x004f }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r1     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x001b
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x001b
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x004c }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x004c }
            if (r2 != 0) goto L_0x0054
        L_0x001b:
            com.sensorsdata.analytics.android.sdk.AppStateManager r2 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ Exception -> 0x004c }
            android.app.Activity r2 = r2.getForegroundActivity()     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x003d
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x003d
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            boolean r3 = r3.isActive()     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x003d
            android.view.Window r0 = r2.getWindow()     // Catch:{ Exception -> 0x004c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x004c }
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r4.traverseNode(r0)     // Catch:{ Exception -> 0x004c }
        L_0x0042:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode> r0 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x004c }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x004c }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r5 = (com.sensorsdata.analytics.android.sdk.visual.model.ViewNode) r5     // Catch:{ Exception -> 0x004c }
            r1 = r5
            goto L_0x0054
        L_0x004c:
            r5 = move-exception
            r0 = r1
            goto L_0x0050
        L_0x004f:
            r5 = move-exception
        L_0x0050:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
            r1 = r0
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getViewNode(java.lang.String):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    private void traverseNode(View view, SparseArray<ViewNode> sparseArray, HashMap<String, ViewNode> hashMap, HashMap<String, ViewNode> hashMap2) {
        JSONObject screenNameAndTitle;
        if (view != null) {
            try {
                ViewNode cacheViewPathAndPosition = getCacheViewPathAndPosition(view, true);
                if (cacheViewPathAndPosition != null) {
                    sparseArray.put(view.hashCode(), cacheViewPathAndPosition);
                    if (!TextUtils.isEmpty(cacheViewPathAndPosition.getViewPath()) && (screenNameAndTitle = VisualUtil.getScreenNameAndTitle(view, (SnapInfo) null)) != null) {
                        String optString = screenNameAndTitle.optString(AopConstants.SCREEN_NAME);
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(cacheViewPathAndPosition.getViewContent())) {
                                hashMap.put(generateKey(cacheViewPathAndPosition.getViewPath(), cacheViewPathAndPosition.getViewPosition(), optString), cacheViewPathAndPosition);
                            }
                            if (ViewUtil.instanceOfWebView(view)) {
                                hashMap2.put(cacheViewPathAndPosition.getViewPath() + optString, cacheViewPathAndPosition);
                            }
                        }
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt != null) {
                            traverseNode(childAt, sparseArray, hashMap, hashMap2);
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }
}
