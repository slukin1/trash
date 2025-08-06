package com.hbg.module.huobi.im.group.ui.active;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.ui.active.ActiveWebView;
import com.hbg.module.huobi.im.manager.ActiveViewManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rd.a;
import rx.subjects.BehaviorSubject;
import v6.t;
import v6.u;
import v6.w;

public class ActiveView extends FrameLayout implements u {
    public static final String INTERFACE_NAME = "huobiNative";
    public static final String TAG = (ActiveView.class.getSimpleName() + " hbactive");
    public int activeType;
    /* access modifiers changed from: private */
    public int alpha;
    private DialogDispatchCallback dialogDispatchCallback;
    private boolean isAlive;
    private ActiveEventCallback mCallback;
    private String mUrl;
    /* access modifiers changed from: private */
    public ActiveWebView mWebView;
    private BehaviorSubject<Integer> uiBehavior;

    public interface ActiveEventCallback {
        void onClose(String str);
    }

    public interface ActiveViewDispatchTouchCallback {
        boolean viewDispatchTouch(MotionEvent motionEvent);
    }

    public interface DialogDispatchCallback {
        boolean onDialogDispatch(MotionEvent motionEvent);
    }

    public ActiveView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public boolean dispatchDialogTouchEvent(MotionEvent motionEvent, View view, MotionEvent motionEvent2) {
        try {
            int indexOf = ActiveViewManager.e().f20523d.indexOf(this);
            if (indexOf > 0) {
                return ActiveViewManager.e().f20523d.get(indexOf - 1).dispatchTouchEvent(motionEvent);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Activity l11 = a.m().l();
        if (l11 == null || !(l11 instanceof FragmentActivity)) {
            return false;
        }
        MotionEvent.obtain(motionEvent2);
        return ((FragmentActivity) l11).dispatchTouchEvent(motionEvent2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(Context context) {
        ActiveWebView activeWebView = (ActiveWebView) LayoutInflater.from(context).inflate(R$layout.layout_active_view, this).findViewById(R$id.wv_active);
        this.mWebView = activeWebView;
        activeWebView.setBackgroundColor(0);
        this.mWebView.getBackground().setAlpha(0);
        WebView.setWebContentsDebuggingEnabled(true);
        this.mWebView.setLoadErrorListener(new ActiveWebView.OnLoadErrorListener() {
            public void onError(int i11, String str) {
                ActiveViewManager.e().m(ActiveView.this.activeType);
            }
        });
        this.mWebView.setOnTouchListener(new View.OnTouchListener() {
            private Bitmap bitmap;

            /* JADX WARNING: Removed duplicated region for block: B:49:0x0115 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x0116  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
                /*
                    r7 = this;
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r0 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    android.content.Context r0 = r0.getContext()
                    r1 = 1
                    if (r0 == 0) goto L_0x011d
                    android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r9)
                    float r2 = r9.getRawX()
                    float r3 = r9.getRawY()
                    r0.setLocation(r2, r3)
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r2 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    com.hbg.module.huobi.im.group.ui.active.ActiveWebView r2 = r2.mWebView
                    float r2 = r2.getAlpha()
                    r3 = 0
                    int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                    if (r2 != 0) goto L_0x002e
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    boolean r8 = r1.dispatchDialogTouchEvent(r9, r8, r0)
                    return r8
                L_0x002e:
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r2 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    int r2 = r2.alpha
                    r4 = 0
                    if (r2 >= 0) goto L_0x0038
                    return r4
                L_0x0038:
                    r2 = 255(0xff, float:3.57E-43)
                    int r5 = r9.getAction()
                    if (r5 == 0) goto L_0x008f
                    if (r5 == r1) goto L_0x0068
                    r1 = 2
                    if (r5 == r1) goto L_0x004b
                    r1 = 3
                    if (r5 == r1) goto L_0x0068
                    r1 = r4
                    goto L_0x00b5
                L_0x004b:
                    android.graphics.Bitmap r1 = r7.bitmap     // Catch:{ Exception -> 0x0062 }
                    float r5 = r9.getX()     // Catch:{ Exception -> 0x0062 }
                    int r5 = (int) r5     // Catch:{ Exception -> 0x0062 }
                    float r6 = r9.getY()     // Catch:{ Exception -> 0x0062 }
                    int r6 = (int) r6     // Catch:{ Exception -> 0x0062 }
                    int r1 = r1.getPixel(r5, r6)     // Catch:{ Exception -> 0x0062 }
                    int r2 = android.graphics.Color.alpha(r1)     // Catch:{ Exception -> 0x0060 }
                    goto L_0x00b5
                L_0x0060:
                    r5 = move-exception
                    goto L_0x0064
                L_0x0062:
                    r5 = move-exception
                    r1 = r4
                L_0x0064:
                    r5.printStackTrace()
                    goto L_0x00b5
                L_0x0068:
                    android.graphics.Bitmap r1 = r7.bitmap     // Catch:{ Exception -> 0x007f }
                    float r5 = r9.getX()     // Catch:{ Exception -> 0x007f }
                    int r5 = (int) r5     // Catch:{ Exception -> 0x007f }
                    float r6 = r9.getY()     // Catch:{ Exception -> 0x007f }
                    int r6 = (int) r6     // Catch:{ Exception -> 0x007f }
                    int r1 = r1.getPixel(r5, r6)     // Catch:{ Exception -> 0x007f }
                    int r2 = android.graphics.Color.alpha(r1)     // Catch:{ Exception -> 0x007d }
                    goto L_0x0084
                L_0x007d:
                    r5 = move-exception
                    goto L_0x0081
                L_0x007f:
                    r5 = move-exception
                    r1 = r4
                L_0x0081:
                    r5.printStackTrace()
                L_0x0084:
                    android.graphics.Bitmap r5 = r7.bitmap     // Catch:{ Exception -> 0x008a }
                    r5.recycle()     // Catch:{ Exception -> 0x008a }
                    goto L_0x00b5
                L_0x008a:
                    r5 = move-exception
                    r5.printStackTrace()
                    goto L_0x00b5
                L_0x008f:
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this     // Catch:{ Exception -> 0x00b0 }
                    com.hbg.module.huobi.im.group.ui.active.ActiveWebView r1 = r1.mWebView     // Catch:{ Exception -> 0x00b0 }
                    android.graphics.Bitmap r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.obtainCaptureBitmap(r1)     // Catch:{ Exception -> 0x00b0 }
                    r7.bitmap = r1     // Catch:{ Exception -> 0x00b0 }
                    float r5 = r9.getX()     // Catch:{ Exception -> 0x00b0 }
                    int r5 = (int) r5     // Catch:{ Exception -> 0x00b0 }
                    float r6 = r9.getY()     // Catch:{ Exception -> 0x00b0 }
                    int r6 = (int) r6     // Catch:{ Exception -> 0x00b0 }
                    int r1 = r1.getPixel(r5, r6)     // Catch:{ Exception -> 0x00b0 }
                    int r2 = android.graphics.Color.alpha(r1)     // Catch:{ Exception -> 0x00ae }
                    goto L_0x00b5
                L_0x00ae:
                    r5 = move-exception
                    goto L_0x00b2
                L_0x00b0:
                    r5 = move-exception
                    r1 = r4
                L_0x00b2:
                    r5.printStackTrace()
                L_0x00b5:
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "ImSdkManager--> pixel:"
                    r5.append(r6)
                    r5.append(r1)
                    java.lang.String r1 = " event.getAction():"
                    r5.append(r1)
                    int r1 = r9.getAction()
                    r5.append(r1)
                    java.lang.String r1 = " mWebView.getAlpha():"
                    r5.append(r1)
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    com.hbg.module.huobi.im.group.ui.active.ActiveWebView r1 = r1.mWebView
                    float r1 = r1.getAlpha()
                    r5.append(r1)
                    java.lang.String r1 = " alpha:"
                    r5.append(r1)
                    r5.append(r2)
                    java.lang.String r1 = "server alpha:"
                    r5.append(r1)
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    int r1 = r1.alpha
                    r5.append(r1)
                    java.lang.String r1 = r5.toString()
                    java.lang.String r5 = "HBgDialog"
                    i6.d.c(r5, r1)
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    com.hbg.module.huobi.im.group.ui.active.ActiveWebView r1 = r1.mWebView
                    float r1 = r1.getAlpha()
                    int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r1 <= 0) goto L_0x0116
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    int r1 = r1.alpha
                    if (r2 <= r1) goto L_0x0116
                    return r4
                L_0x0116:
                    com.hbg.module.huobi.im.group.ui.active.ActiveView r1 = com.hbg.module.huobi.im.group.ui.active.ActiveView.this
                    boolean r8 = r1.dispatchDialogTouchEvent(r9, r8, r0)
                    return r8
                L_0x011d:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.active.ActiveView.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.mWebView.initWebView(context);
    }

    public static Bitmap obtainCaptureBitmap(View view) {
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        new Canvas(createBitmap).drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public void clearNeedLoginAction() {
    }

    public void dismissProgressDialog() {
    }

    public Activity getActivity() {
        return a.m().l();
    }

    public String getAvailableLocationY() {
        return null;
    }

    public String getDisplayHeight() {
        return null;
    }

    public String getDisplayWidth() {
        return null;
    }

    public String getNavigatorHeight() {
        return null;
    }

    public String getTopHeight() {
        return null;
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.uiBehavior;
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isCanBeSeen() {
        return false;
    }

    public boolean isSupportBlankLabel() {
        return false;
    }

    public void loadJs(String str) {
        ActiveWebView activeWebView = this.mWebView;
        activeWebView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(activeWebView, str);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.uiBehavior.onNext(2);
        this.isAlive = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.uiBehavior.onNext(5);
        this.isAlive = false;
    }

    public void setAlertDialogInfo(AlertInfo alertInfo) {
    }

    public void setAlpha(int i11) {
        this.alpha = i11;
        this.mWebView.setAlpha((float) i11);
    }

    public void setCallback(ActiveEventCallback activeEventCallback) {
        this.mCallback = activeEventCallback;
    }

    public void setDialogDispatchCallback(DialogDispatchCallback dialogDispatchCallback2) {
        this.dialogDispatchCallback = dialogDispatchCallback2;
    }

    public void setHBWebViewLifecycleCallback(t tVar) {
    }

    public void setNeedLoginAction(boolean z11, boolean z12, JsMessage jsMessage) {
    }

    public void setProcess(int i11) {
    }

    public void setTitleText(CharSequence charSequence) {
    }

    public void setUrl(String str) {
        this.mUrl = StringUtils.w(str);
    }

    public void setWebViewRefreshType(String str) {
    }

    public void setWebViewUserAgent() {
        this.mWebView.getSettings().setUserAgentString(w.e().f(this.mWebView.getSettings().getUserAgentString()));
    }

    public void showActionBarShare(boolean z11) {
    }

    public void showOldProgressDialog(String str) {
    }

    public void showProgressDialog() {
    }

    public void showProgressDialog(String str) {
    }

    public void showProgressDialog(String str, boolean z11) {
    }

    public void showProgressDialog(boolean z11) {
    }

    public void showTopIcon(List<Map<String, String>> list) {
    }

    public void update() {
        this.mWebView.addJavascriptInterface(new ActiveInterface(this, this.mCallback, this.activeType), "huobiNative");
        this.mWebView.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        ActiveWebView activeWebView = this.mWebView;
        String str = this.mUrl;
        activeWebView.loadUrl(str, hashMap);
        SensorsDataAutoTrackHelper.loadUrl2(activeWebView, str, hashMap);
    }

    public ActiveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActiveView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.alpha = -1;
        this.uiBehavior = BehaviorSubject.create();
        this.activeType = 1;
        init(context);
    }

    public ActiveView(int i11, Context context) {
        super(context, (AttributeSet) null, 0);
        this.alpha = -1;
        this.uiBehavior = BehaviorSubject.create();
        this.activeType = 1;
        this.activeType = i11;
        init(context);
    }
}
