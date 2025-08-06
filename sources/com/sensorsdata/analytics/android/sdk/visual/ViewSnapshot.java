package com.sensorsdata.analytics.android.sdk.visual;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.huochat.community.util.FileTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.DeviceUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.Caller;
import com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds;
import com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache;
import com.sensorsdata.analytics.android.sdk.visual.snap.SoftWareCanvas;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViewSnapshot {
    private static final int JS_NOT_INTEGRATED_ALERT_TIME_OUT = 5000;
    private static final int MAX_CLASS_NAME_CACHE_SIZE = 255;
    private static final String TAG = "SA.ViewSnapshot";
    private AlertRunnable mAlertRunnable;
    private final ClassNameCache mClassnameCache;
    private final Handler mMainThreadHandler;
    private final List<PropertyDescription> mProperties;
    private final ResourceIds mResourceIds;
    private final RootViewFinder mRootViewFinder;
    /* access modifiers changed from: private */
    public SnapInfo mSnapInfo = new SnapInfo();

    public static class AlertRunnable implements Runnable {
        private String url;

        public AlertRunnable(String str) {
            this.url = str;
        }

        public void run() {
            if (WebNodesManager.getInstance().getWebNodes(this.url) == null) {
                SALog.i(ViewSnapshot.TAG, "H5 页面未集成 Web JS SDK");
                WebNodesManager.getInstance().handlerFailure(this.url, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"当前页面无法进行可视化全埋点\",\"message\":\"此页面未集成 Web JS SDK 或者 Web JS SDK 版本过低，请集成最新版 Web JS SDK\",\"link_text\":\"配置文档\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/tech_sdk_client_web_use-7545346.html\"}]}");
            }
        }
    }

    public static class CachedBitmap {
        private Bitmap mCached = null;
        private String mImageHash = "";
        private final Paint mPaint = new Paint(2);

        private static byte[] concat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        /* access modifiers changed from: private */
        public String getImageHash() {
            return this.mImageHash;
        }

        private String toHex(byte[] bArr) {
            String str = "";
            for (int i11 = 0; i11 < bArr.length; i11++) {
                str = (str + "0123456789ABCDEF".charAt((bArr[i11] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i11] & 15);
            }
            return str;
        }

        public synchronized void recreate(int i11, int i12, int i13, Bitmap bitmap) {
            byte[] bytes;
            byte[] bytes2;
            Bitmap bitmap2 = this.mCached;
            if (!(bitmap2 != null && bitmap2.getWidth() == i11 && this.mCached.getHeight() == i12)) {
                try {
                    this.mCached = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
                } catch (Throwable unused) {
                    this.mCached = null;
                }
                Bitmap bitmap3 = this.mCached;
                if (bitmap3 != null) {
                    bitmap3.setDensity(i13);
                }
            }
            if (this.mCached != null) {
                new Canvas(this.mCached).drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.mCached.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String lastWebNodeMsg = WebNodesManager.getInstance().getLastWebNodeMsg();
                    if (!TextUtils.isEmpty(lastWebNodeMsg) && (bytes2 = lastWebNodeMsg.getBytes()) != null && bytes2.length > 0) {
                        byteArray = concat(byteArray, bytes2);
                    }
                    String lastDebugInfo = VisualizedAutoTrackService.getInstance().getLastDebugInfo();
                    if (!TextUtils.isEmpty(lastDebugInfo) && (bytes = lastDebugInfo.getBytes()) != null && bytes.length > 0) {
                        byteArray = concat(byteArray, bytes);
                    }
                    this.mImageHash = toHex(MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(byteArray));
                } catch (Exception e11) {
                    SALog.i(ViewSnapshot.TAG, "CachedBitmap.recreate;Create image_hash error=" + e11);
                }
            }
            return;
        }

        public synchronized void writeBitmapJSON(Bitmap.CompressFormat compressFormat, int i11, OutputStream outputStream) throws IOException {
            Bitmap bitmap = this.mCached;
            if (!(bitmap == null || bitmap.getWidth() == 0)) {
                if (this.mCached.getHeight() != 0) {
                    outputStream.write(34);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.mCached.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    outputStream.write(new String(Base64Coder.encode(byteArrayOutputStream.toByteArray())).getBytes());
                    outputStream.write(34);
                }
            }
            outputStream.write(OptionsBridge.NULL_VALUE.getBytes());
        }
    }

    @SuppressLint({"NewApi"})
    public static class ClassNameCache extends LruCache<Class<?>, String> {
        public ClassNameCache(int i11) {
            super(i11);
        }

        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    public static class RootViewFinder implements Callable<List<RootViewInfo>> {
        private final CachedBitmap mCachedBitmap = new CachedBitmap();
        private final int mClientDensity = 160;
        private final List<RootViewInfo> mRootViews = new ArrayList();

        private void scaleBitmap(RootViewInfo rootViewInfo, Bitmap bitmap) {
            float f11 = 1.0f;
            if (bitmap != null) {
                int density = bitmap.getDensity();
                if (density != 0) {
                    f11 = 160.0f / ((float) density);
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (int) (((double) (((float) bitmap.getWidth()) * f11)) + 0.5d);
                int height2 = (int) (((double) (((float) bitmap.getHeight()) * f11)) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.mCachedBitmap.recreate(width2, height2, 160, bitmap);
                }
            }
            rootViewInfo.scale = f11;
            rootViewInfo.screenshot = this.mCachedBitmap;
        }

        public Bitmap mergeViewLayers(View[] viewArr, RootViewInfo rootViewInfo) {
            View[] viewArr2 = viewArr;
            RootViewInfo rootViewInfo2 = rootViewInfo;
            int width = rootViewInfo2.rootView.getWidth();
            int height = rootViewInfo2.rootView.getHeight();
            if (width == 0 || height == 0) {
                int[] deviceSize = DeviceUtils.getDeviceSize(SensorsDataAPI.sharedInstance().getContext());
                width = deviceSize[0];
                height = deviceSize[1];
                if (width == 0 || height == 0) {
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            SoftWareCanvas softWareCanvas = new SoftWareCanvas(createBitmap);
            int[] iArr = new int[2];
            boolean z11 = ViewUtil.getMainWindowCount(viewArr) > 1;
            WindowHelper.init();
            ViewUtil.invalidateLayerTypeView(viewArr);
            boolean z12 = false;
            for (View view : viewArr2) {
                if (view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && ViewUtil.isWindowNeedTraverse(view, WindowHelper.getWindowPrefix(view), z11)) {
                    softWareCanvas.save();
                    if (!WindowHelper.isMainWindow(view)) {
                        view.getLocationOnScreen(iArr);
                        softWareCanvas.translate((float) iArr[0], (float) iArr[1]);
                        if (WindowHelper.isDialogOrPopupWindow(view) && !z12) {
                            Paint paint = new Paint();
                            paint.setColor(-1610612736);
                            softWareCanvas.drawRect(-((float) iArr[0]), -((float) iArr[1]), (float) softWareCanvas.getWidth(), (float) softWareCanvas.getHeight(), paint);
                            z12 = true;
                        }
                    }
                    view.draw(softWareCanvas);
                    softWareCanvas.restoreToCount(1);
                }
            }
            softWareCanvas.destroy();
            return createBitmap;
        }

        public List<RootViewInfo> call() throws Exception {
            this.mRootViews.clear();
            try {
                Activity foregroundActivity = AppStateManager.getInstance().getForegroundActivity();
                if (foregroundActivity != null) {
                    JSONObject buildTitleAndScreenName = AopUtil.buildTitleAndScreenName(foregroundActivity);
                    VisualUtil.mergeRnScreenNameAndTitle(buildTitleAndScreenName);
                    String optString = buildTitleAndScreenName.optString(AopConstants.SCREEN_NAME);
                    String optString2 = buildTitleAndScreenName.optString(AopConstants.TITLE);
                    Window window = foregroundActivity.getWindow();
                    Bitmap bitmap = null;
                    View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
                    if (rootView == null) {
                        return this.mRootViews;
                    }
                    RootViewInfo rootViewInfo = new RootViewInfo(optString, optString2, rootView);
                    View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
                    if (sortedWindowViews != null && sortedWindowViews.length > 0) {
                        bitmap = mergeViewLayers(sortedWindowViews, rootViewInfo);
                        for (View view : sortedWindowViews) {
                            if (view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0) {
                                if (!TextUtils.equals(WindowHelper.getWindowPrefix(view), WindowHelper.getMainWindowPrefix())) {
                                    if (!WindowHelper.isCustomWindow(view)) {
                                        RootViewInfo rootViewInfo2 = new RootViewInfo(optString, optString2, view.getRootView());
                                        scaleBitmap(rootViewInfo2, bitmap);
                                        this.mRootViews.add(rootViewInfo2);
                                    }
                                }
                            }
                        }
                    }
                    if (this.mRootViews.size() == 0) {
                        scaleBitmap(rootViewInfo, bitmap);
                        this.mRootViews.add(rootViewInfo);
                    }
                }
            } catch (Throwable th2) {
                SALog.d(ViewSnapshot.TAG, "" + th2);
            }
            return this.mRootViews;
        }
    }

    public static class RootViewInfo {
        public final String activityTitle;
        public final View rootView;
        public float scale = 1.0f;
        public final String screenName;
        public CachedBitmap screenshot = null;

        public RootViewInfo(String str, String str2, View view) {
            this.screenName = str;
            this.activityTitle = str2;
            this.rootView = view;
        }
    }

    public ViewSnapshot(List<PropertyDescription> list, ResourceIds resourceIds, Handler handler) {
        this.mProperties = list;
        this.mResourceIds = resourceIds;
        this.mMainThreadHandler = handler;
        this.mRootViewFinder = new RootViewFinder();
        this.mClassnameCache = new ClassNameCache(255);
    }

    private void addProperties(JSONObject jSONObject, View view) throws Exception {
        Caller caller;
        Object applyMethod;
        jSONObject.put("importantForAccessibility", true);
        Class<?> cls = view.getClass();
        for (PropertyDescription next : this.mProperties) {
            if (!(!next.targetClass.isAssignableFrom(cls) || (caller = next.accessor) == null || (applyMethod = caller.applyMethod(view)) == null)) {
                if (applyMethod instanceof Number) {
                    jSONObject.put(next.name, (Number) applyMethod);
                } else if (applyMethod instanceof Boolean) {
                    boolean booleanValue = ((Boolean) applyMethod).booleanValue();
                    if ("clickable".equals(next.name)) {
                        if (VisualUtil.isSupportClick(view)) {
                            booleanValue = true;
                        } else if (VisualUtil.isForbiddenClick(view)) {
                            booleanValue = false;
                        }
                    }
                    jSONObject.put(next.name, booleanValue);
                } else if (applyMethod instanceof ColorStateList) {
                    jSONObject.put(next.name, Integer.valueOf(((ColorStateList) applyMethod).getDefaultColor()));
                } else if (applyMethod instanceof Drawable) {
                    Drawable drawable = (Drawable) applyMethod;
                    Rect bounds = drawable.getBounds();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Class cls2 = drawable.getClass();
                    while (cls2 != Object.class && cls2 != null) {
                        jSONArray.put(SnapCache.getInstance().getCanonicalName(cls2));
                        cls2 = cls2.getSuperclass();
                    }
                    jSONObject2.put("classes", jSONArray);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("left", bounds.left);
                    jSONObject3.put(TtmlNode.RIGHT, bounds.right);
                    jSONObject3.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, bounds.top);
                    jSONObject3.put("bottom", bounds.bottom);
                    jSONObject2.put("dimensions", jSONObject3);
                    if (drawable instanceof ColorDrawable) {
                        ColorDrawable colorDrawable = (ColorDrawable) drawable;
                        if (Build.VERSION.SDK_INT >= 11) {
                            jSONObject2.put("color", colorDrawable.getColor());
                        }
                    }
                    jSONObject.put(next.name, jSONObject2);
                } else {
                    jSONObject.put(next.name, applyMethod.toString());
                }
            }
        }
    }

    private String getResName(View view) {
        int id2 = view.getId();
        if (-1 == id2) {
            return null;
        }
        return this.mResourceIds.nameForId(id2);
    }

    private void getVisibleRect(View view, Rect rect, boolean z11) {
        if (z11) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        SnapCache.getInstance().setLocalVisibleRect(view, Boolean.valueOf(view.getLocalVisibleRect(rect)));
        rect.offset(iArr[0], iArr[1]);
    }

    private boolean isSnapShotUpdated(String str, StringBuilder sb2) {
        boolean z11 = !((str == null || sb2 == null) ? false : str.equals(sb2.toString())) || WebNodesManager.getInstance().hasH5AlertInfo();
        if (sb2 != null) {
            sb2.delete(0, sb2.length()).append(str);
        }
        return z11;
    }

    private void mergeWebViewNodes(JSONArray jSONArray, WebNode webNode, View view, float f11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hashCode", webNode.getId() + view.hashCode());
            int i11 = 0;
            jSONObject.put("index", 0);
            if (!TextUtils.isEmpty(webNode.get$element_selector())) {
                jSONObject.put("element_selector", webNode.get$element_selector());
            }
            if (!TextUtils.isEmpty(webNode.get$element_content())) {
                jSONObject.put("element_content", webNode.get$element_content());
            }
            SnapInfo snapInfo = this.mSnapInfo;
            int i12 = snapInfo.elementLevel + 1;
            snapInfo.elementLevel = i12;
            jSONObject.put("element_level", i12);
            jSONObject.put("h5_title", webNode.get$title());
            if (f11 == 0.0f) {
                f11 = webNode.getScale();
            }
            jSONObject.put("left", (double) (webNode.getLeft() * f11));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, (double) (webNode.getTop() * f11));
            jSONObject.put("width", (int) (webNode.getWidth() * f11));
            jSONObject.put("height", (int) (webNode.getHeight() * f11));
            jSONObject.put("scrollX", 0);
            jSONObject.put("scrollY", 0);
            boolean z11 = webNode.getOriginTop() * f11 <= ((float) view.getHeight()) && webNode.getOriginLeft() * f11 <= ((float) view.getWidth());
            if (!webNode.isVisibility() || !z11) {
                i11 = 8;
            }
            jSONObject.put("visibility", i11);
            jSONObject.put("url", webNode.get$url());
            jSONObject.put("clickable", webNode.isEnable_click());
            jSONObject.put("importantForAccessibility", true);
            jSONObject.put("is_h5", true);
            jSONObject.put("is_list_view", webNode.isIs_list_view());
            jSONObject.put("element_path", webNode.get$element_path());
            jSONObject.put("tag_name", webNode.getTagName());
            if (!TextUtils.isEmpty(webNode.get$element_position())) {
                jSONObject.put("element_position", webNode.get$element_position());
            }
            this.mSnapInfo.webLibVersion = webNode.getLib_version();
            jSONObject.put("list_selector", webNode.getList_selector());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(webNode.getTagName());
            Class cls = view.getClass();
            do {
                jSONArray2.put(SnapCache.getInstance().getCanonicalName(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            List<String> subelements = webNode.getSubelements();
            JSONArray jSONArray3 = new JSONArray();
            if (subelements != null && subelements.size() > 0) {
                for (String str : subelements) {
                    jSONArray3.put(str + view.hashCode());
                }
            }
            jSONObject.put("subviews", jSONArray3);
            jSONArray.put(jSONObject);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void reset() {
        this.mSnapInfo = new SnapInfo();
    }

    private void snapshotView(JSONArray jSONArray, final View view, int i11) throws Exception {
        float f11;
        if (ViewUtil.isViewSelfVisible(view)) {
            ArrayList<String> arrayList = null;
            int i12 = this.mSnapInfo.elementLevel;
            if (ViewUtil.instanceOfWebView(view)) {
                this.mSnapInfo.isWebView = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    view.post(new Runnable() {
                        public void run() {
                            String str = (String) ReflectUtil.callMethod(view, "getUrl", new Object[0]);
                            if (!TextUtils.isEmpty(str)) {
                                ViewSnapshot.this.mSnapInfo.webViewUrl = str;
                                Float f11 = (Float) ReflectUtil.callMethod(view, "getScale", new Object[0]);
                                if (f11 != null) {
                                    ViewSnapshot.this.mSnapInfo.webViewScale = f11.floatValue();
                                }
                                countDownLatch.countDown();
                                SensorsDataAutoTrackHelper.loadUrl(view, "javascript:window.sensorsdata_app_call_js('visualized')");
                                return;
                            }
                            countDownLatch.countDown();
                        }
                    });
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
                try {
                    countDownLatch.await(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e12) {
                    SALog.printStackTrace(e12);
                }
                SALog.i(TAG, "WebView url: " + this.mSnapInfo.webViewUrl);
                if (!TextUtils.isEmpty(this.mSnapInfo.webViewUrl)) {
                    WebNodeInfo webNodes = WebNodesManager.getInstance().getWebNodes(this.mSnapInfo.webViewUrl);
                    if (webNodes == null) {
                        if (this.mAlertRunnable == null) {
                            this.mAlertRunnable = new AlertRunnable(this.mSnapInfo.webViewUrl);
                        }
                        Dispatcher.getInstance().postDelayed(this.mAlertRunnable, 5000);
                    } else if (webNodes.getStatus() == WebNodeInfo.Status.SUCCESS) {
                        List<WebNode> webNodes2 = webNodes.getWebNodes();
                        if (webNodes2 != null && webNodes2.size() > 0) {
                            arrayList = new ArrayList<>();
                            for (WebNode next : webNodes2) {
                                mergeWebViewNodes(jSONArray, next, view, this.mSnapInfo.webViewScale);
                                if (next.isRootView()) {
                                    arrayList.add(next.getId() + view.hashCode());
                                }
                            }
                        }
                    } else if (webNodes.getStatus() == WebNodeInfo.Status.FAILURE) {
                        this.mSnapInfo.alertInfos = webNodes.getAlertInfos();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hashCode", view.hashCode());
            jSONObject.put("id", view.getId());
            jSONObject.put("index", VisualUtil.getChildIndex(view.getParent(), view));
            if (ViewUtil.instanceOfWebView(view)) {
                jSONObject.put("element_level", i12);
            } else {
                SnapInfo snapInfo = this.mSnapInfo;
                int i13 = snapInfo.elementLevel + 1;
                snapInfo.elementLevel = i13;
                jSONObject.put("element_level", i13);
            }
            jSONObject.put("element_selector", ViewUtil.getElementSelector(view));
            JSONObject screenNameAndTitle = VisualUtil.getScreenNameAndTitle(view, this.mSnapInfo);
            if (screenNameAndTitle != null) {
                String optString = screenNameAndTitle.optString(AopConstants.SCREEN_NAME);
                String optString2 = screenNameAndTitle.optString(AopConstants.TITLE);
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject.put("screen_name", optString);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    jSONObject.put("title", optString2);
                }
            }
            ViewNode viewNode = ViewUtil.getViewNode(view, i11, true);
            if (viewNode != null) {
                if (!TextUtils.isEmpty(viewNode.getViewPath())) {
                    jSONObject.put("element_path", viewNode.getViewPath());
                }
                if (!TextUtils.isEmpty(viewNode.getViewPosition())) {
                    jSONObject.put("element_position", viewNode.getViewPosition());
                }
                if (!TextUtils.isEmpty(viewNode.getViewContent()) && VisualUtil.isSupportElementContent(view)) {
                    jSONObject.put("element_content", viewNode.getViewContent());
                }
                jSONObject.put("is_list_view", viewNode.isListView());
            }
            jSONObject.put("sa_id_name", getResName(view));
            try {
                String str = (String) view.getTag(R.id.sensors_analytics_tag_view_id);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("sa_id_name", str);
                }
            } catch (Exception e13) {
                SALog.printStackTrace(e13);
            }
            if (WindowHelper.isMainWindow(view.getRootView())) {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
            } else if (WindowHelper.isDecorView(view.getClass())) {
                DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
                int i14 = displayMetrics.widthPixels;
                int i15 = displayMetrics.heightPixels;
                jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put("width", i14);
                jSONObject.put("height", i15);
            } else {
                ViewParent parent = view.getParent();
                if (parent == null || !WindowHelper.isDecorView(parent.getClass())) {
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                    jSONObject.put("left", view.getLeft());
                    jSONObject.put("width", view.getWidth());
                    jSONObject.put("height", view.getHeight());
                } else {
                    Rect rect = new Rect();
                    getVisibleRect(view, rect, false);
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect.top);
                    jSONObject.put("left", rect.left);
                    jSONObject.put("width", rect.width());
                    jSONObject.put("height", rect.height());
                }
            }
            int scrollX = view.getScrollX();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (Build.VERSION.SDK_INT >= 16 && textView.getMaxLines() == 1) {
                    scrollX = 0;
                }
            }
            if (ViewUtil.instanceOfX5WebView(view)) {
                try {
                    jSONObject.put("scrollX", (Integer) ReflectUtil.callMethod(view, "getWebScrollX", new Object[0]));
                    jSONObject.put("scrollY", (Integer) ReflectUtil.callMethod(view, "getWebScrollY", new Object[0]));
                } catch (Exception e14) {
                    SALog.printStackTrace(e14);
                }
            } else {
                jSONObject.put("scrollX", scrollX);
                jSONObject.put("scrollY", view.getScrollY());
            }
            jSONObject.put("visibility", VisualUtil.getVisibility(view));
            float f12 = 0.0f;
            if (Build.VERSION.SDK_INT >= 11) {
                f12 = view.getTranslationX();
                f11 = view.getTranslationY();
            } else {
                f11 = 0.0f;
            }
            jSONObject.put("translationX", (double) f12);
            jSONObject.put("translationY", (double) f11);
            JSONArray jSONArray2 = new JSONArray();
            Class cls = view.getClass();
            do {
                if (Build.VERSION.SDK_INT >= 12) {
                    jSONArray2.put(this.mClassnameCache.get(cls));
                }
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            addProperties(jSONObject, view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                JSONArray jSONArray3 = new JSONArray();
                for (int put : rules) {
                    jSONArray3.put(put);
                }
                jSONObject.put("layoutRules", jSONArray3);
            }
            JSONArray jSONArray4 = new JSONArray();
            if (arrayList != null && arrayList.size() > 0) {
                for (String put2 : arrayList) {
                    jSONArray4.put(put2);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = viewGroup.getChildAt(i16);
                    if (childAt != null) {
                        jSONArray4.put(childAt.hashCode());
                    }
                }
            }
            jSONObject.put("subviews", jSONArray4);
            jSONArray.put(jSONObject);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i17 = 0; i17 < childCount2; i17++) {
                View childAt2 = viewGroup2.getChildAt(i17);
                if (childAt2 != null) {
                    snapshotView(jSONArray, childAt2, i17);
                }
            }
        }
    }

    private void snapshotViewHierarchy(JSONArray jSONArray, View view) throws Exception {
        if (Build.VERSION.SDK_INT >= 11) {
            reset();
            snapshotView(jSONArray, view, 0);
            WebNodesManager.getInstance().setHasWebView(this.mSnapInfo.isWebView);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapshots(java.io.OutputStream r21, java.lang.StringBuilder r22) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "SA.ViewSnapshot"
            long r4 = java.lang.System.currentTimeMillis()
            java.util.concurrent.FutureTask r6 = new java.util.concurrent.FutureTask
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$RootViewFinder r0 = r1.mRootViewFinder
            r6.<init>(r0)
            android.os.Handler r0 = r1.mMainThreadHandler
            r0.post(r6)
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream
            r7.<init>(r2)
            java.util.List r8 = java.util.Collections.emptyList()
            java.lang.String r0 = "["
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            r9 = 2
            r11 = 1
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0052, TimeoutException -> 0x004b, ExecutionException -> 0x0044, all -> 0x003d }
            java.lang.Object r0 = r6.get(r9, r0)     // Catch:{ InterruptedException -> 0x0052, TimeoutException -> 0x004b, ExecutionException -> 0x0044, all -> 0x003d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ InterruptedException -> 0x0052, TimeoutException -> 0x004b, ExecutionException -> 0x0044, all -> 0x003d }
            r6.cancel(r11)
            android.os.Handler r8 = r1.mMainThreadHandler
            r8.removeCallbacks(r6)
            r8 = r0
            goto L_0x0060
        L_0x003d:
            r0 = move-exception
            java.lang.String r9 = "Throwable thrown during screenshot attempt"
            com.sensorsdata.analytics.android.sdk.SALog.i(r3, r9, r0)     // Catch:{ all -> 0x01ce }
            goto L_0x0058
        L_0x0044:
            r0 = move-exception
            java.lang.String r9 = "Exception thrown during screenshot attempt"
            com.sensorsdata.analytics.android.sdk.SALog.i(r3, r9, r0)     // Catch:{ all -> 0x01ce }
            goto L_0x0058
        L_0x004b:
            r0 = move-exception
            java.lang.String r9 = "Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent."
            com.sensorsdata.analytics.android.sdk.SALog.i(r3, r9, r0)     // Catch:{ all -> 0x01ce }
            goto L_0x0058
        L_0x0052:
            r0 = move-exception
            java.lang.String r9 = "Screenshot interrupted, no screenshot will be sent."
            com.sensorsdata.analytics.android.sdk.SALog.i(r3, r9, r0)     // Catch:{ all -> 0x01ce }
        L_0x0058:
            r6.cancel(r11)
            android.os.Handler r0 = r1.mMainThreadHandler
            r0.removeCallbacks(r6)
        L_0x0060:
            int r6 = r8.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "infoCount:"
            r0.append(r9)
            r0.append(r6)
            java.lang.String r9 = ",time:"
            r0.append(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r4
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r3, (java.lang.String) r0)
            r0 = 0
            r10 = r0
            r12 = 0
        L_0x0088:
            if (r12 >= r6) goto L_0x01bb
            java.lang.Object r13 = r8.get(r12)
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$RootViewInfo r13 = (com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo) r13
            java.lang.String r14 = ","
            if (r12 <= 0) goto L_0x009b
            byte[] r15 = r14.getBytes()
            r7.write(r15)
        L_0x009b:
            if (r13 == 0) goto L_0x01a5
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r15 = r13.screenshot
            if (r15 == 0) goto L_0x01a5
            java.lang.String r15 = r15.getImageHash()
            r9 = r22
            boolean r15 = r1.isSnapShotUpdated(r15, r9)
            if (r15 != 0) goto L_0x00af
            if (r12 <= 0) goto L_0x01a5
        L_0x00af:
            java.lang.String r0 = "{"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            java.lang.String r0 = "\"activity\":"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            java.lang.String r10 = r13.screenName
            java.lang.String r15 = r13.activityTitle
            java.lang.String r0 = org.json.JSONObject.quote(r10)
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            byte[] r0 = r14.getBytes()
            r7.write(r0)
            java.lang.String r0 = "\"scale\":"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            java.lang.Object[] r0 = new java.lang.Object[r11]
            float r11 = r13.scale
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r16 = 0
            r0[r16] = r11
            java.lang.String r11 = "%s"
            java.lang.String r0 = java.lang.String.format(r11, r0)
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            byte[] r0 = r14.getBytes()
            r7.write(r0)
            java.lang.String r0 = "\"serialized_objects\":"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0155 }
            r0.<init>()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r11 = "rootObject"
            r17 = r6
            android.view.View r6 = r13.rootView     // Catch:{ Exception -> 0x0153 }
            int r6 = r6.hashCode()     // Catch:{ Exception -> 0x0153 }
            r0.put(r11, r6)     // Catch:{ Exception -> 0x0153 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x0153 }
            r6.<init>()     // Catch:{ Exception -> 0x0153 }
            android.view.View r11 = r13.rootView     // Catch:{ Exception -> 0x0153 }
            r1.snapshotViewHierarchy(r6, r11)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r11 = "objects"
            r0.put(r11, r6)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0153 }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0153 }
            r7.write(r0)     // Catch:{ Exception -> 0x0153 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0153 }
            r0.<init>()     // Catch:{ Exception -> 0x0153 }
            java.lang.String r6 = "snapshotViewHierarchy:"
            r0.append(r6)     // Catch:{ Exception -> 0x0153 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0153 }
            r6 = r8
            long r8 = r18 - r4
            r0.append(r8)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0151 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x0151 }
            goto L_0x015c
        L_0x0151:
            r0 = move-exception
            goto L_0x0159
        L_0x0153:
            r0 = move-exception
            goto L_0x0158
        L_0x0155:
            r0 = move-exception
            r17 = r6
        L_0x0158:
            r6 = r8
        L_0x0159:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x015c:
            byte[] r0 = r14.getBytes()
            r7.write(r0)
            java.lang.String r0 = "\"image_hash\":"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r0 = r13.screenshot
            java.lang.String r0 = r0.getImageHash()
            java.lang.String r0 = org.json.JSONObject.quote(r0)
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            byte[] r0 = r14.getBytes()
            r7.write(r0)
            java.lang.String r0 = "\"screenshot\":"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            r7.flush()
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r0 = r13.screenshot
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.PNG
            r9 = 70
            r0.writeBitmapJSON(r8, r9, r2)
            java.lang.String r0 = "}"
            byte[] r0 = r0.getBytes()
            r7.write(r0)
            r0 = r10
            r10 = r15
            goto L_0x01b3
        L_0x01a5:
            r17 = r6
            r6 = r8
            r16 = 0
            java.lang.String r8 = "{}"
            byte[] r8 = r8.getBytes()
            r7.write(r8)
        L_0x01b3:
            int r12 = r12 + 1
            r8 = r6
            r6 = r17
            r11 = 1
            goto L_0x0088
        L_0x01bb:
            java.lang.String r2 = "]"
            byte[] r2 = r2.getBytes()
            r7.write(r2)
            r7.flush()
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r1.mSnapInfo
            r2.screenName = r0
            r2.activityTitle = r10
            return r2
        L_0x01ce:
            r0 = move-exception
            r2 = r11
            r6.cancel(r2)
            android.os.Handler r2 = r1.mMainThreadHandler
            r2.removeCallbacks(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.snapshots(java.io.OutputStream, java.lang.StringBuilder):com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo");
    }
}
