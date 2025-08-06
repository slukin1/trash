package com.huobi.otc.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.BehaviorSubject;
import v6.t;
import v6.u;

public class OtcActiveView extends FrameLayout implements u {

    /* renamed from: h  reason: collision with root package name */
    public static final String f79914h = (OtcActiveView.class.getSimpleName() + " hbactive");

    /* renamed from: i  reason: collision with root package name */
    public static Canvas f79915i;

    /* renamed from: j  reason: collision with root package name */
    public static Bitmap f79916j;

    /* renamed from: b  reason: collision with root package name */
    public HBWebView f79917b;

    /* renamed from: c  reason: collision with root package name */
    public String f79918c;

    /* renamed from: d  reason: collision with root package name */
    public c f79919d;

    /* renamed from: e  reason: collision with root package name */
    public BehaviorSubject<Integer> f79920e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79921f;

    /* renamed from: g  reason: collision with root package name */
    public HBWebView.d f79922g;

    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f79923b;

        public a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i11;
            if (OtcActiveView.this.getContext() != null) {
                int i12 = 255;
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            try {
                                i11 = this.f79923b.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                                try {
                                    i12 = Color.alpha(i11);
                                } catch (Exception e11) {
                                    e = e11;
                                    e.printStackTrace();
                                    d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                                    return false;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                i11 = 0;
                                e.printStackTrace();
                                d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                                return false;
                            }
                        } else if (action != 3) {
                            i11 = 0;
                        }
                    }
                    try {
                        i11 = this.f79923b.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                        try {
                            i12 = Color.alpha(i11);
                        } catch (Exception e13) {
                            e = e13;
                            e.printStackTrace();
                            d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                            return false;
                        }
                    } catch (Exception e14) {
                        e = e14;
                        i11 = 0;
                        e.printStackTrace();
                        d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                        return false;
                    }
                } else {
                    try {
                        Bitmap s11 = OtcActiveView.s(OtcActiveView.this.f79917b);
                        this.f79923b = s11;
                        i11 = s11.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                        try {
                            i12 = Color.alpha(i11);
                        } catch (Exception e15) {
                            e = e15;
                            e.printStackTrace();
                            d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                            return false;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        i11 = 0;
                        e.printStackTrace();
                        d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                        return false;
                    }
                }
                d.c("HBgDialog", "ImSdkManager--> pixel:" + i11 + " event.getAction():" + motionEvent.getAction() + " mWebView.getAlpha():" + OtcActiveView.this.f79917b.getAlpha() + " alpha:" + i12 + "server alpha:");
                if (OtcActiveView.this.f79917b.getAlpha() > 0.0f && i12 > 0) {
                    return false;
                }
            }
            ViewGroup viewGroup = (ViewGroup) OtcActiveView.this.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = viewGroup.getChildAt(i13);
                if (childAt != OtcActiveView.this && childAt.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    public class b implements HBWebView.d {
        public b() {
        }

        public void onError(int i11, String str) {
            if (OtcActiveView.this.f79922g != null) {
                OtcActiveView.this.f79922g.onError(i11, str);
            }
        }
    }

    public interface c {
        void onClose(String str);
    }

    public OtcActiveView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap s(View view) {
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (f79916j == null) {
            f79916j = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        }
        if (f79915i == null) {
            f79915i = new Canvas(f79916j);
        }
        f79915i.drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return f79916j;
    }

    public void D() {
        this.f79917b.addJavascriptInterface(new up.c(this, this.f79919d), "huobiNative");
        this.f79917b.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        HBWebView hBWebView = this.f79917b;
        String str = this.f79918c;
        hBWebView.loadUrl(str, hashMap);
        SensorsDataAutoTrackHelper.loadUrl2(hBWebView, str, hashMap);
    }

    public void clearNeedLoginAction() {
    }

    public void dismissProgressDialog() {
    }

    public Activity getActivity() {
        return (Activity) getContext();
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
        return this.f79920e;
    }

    public WebView getWebView() {
        return this.f79917b;
    }

    public boolean isAlive() {
        return this.f79921f;
    }

    public boolean isCanBeSeen() {
        return false;
    }

    public boolean isSupportBlankLabel() {
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void j(Context context) {
        HBWebView hBWebView = (HBWebView) LayoutInflater.from(context).inflate(R$layout.acticity_otc_web_layout, this).findViewById(R$id.otc_active);
        this.f79917b = hBWebView;
        hBWebView.setBackgroundColor(0);
        this.f79917b.getBackground().setAlpha(0);
        WebView.setWebContentsDebuggingEnabled(true);
        this.f79917b.setOnTouchListener(new a());
        this.f79917b.setLoadErrorListener(new b());
        this.f79917b.t(context);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f79920e.onNext(2);
        this.f79921f = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f79920e.onNext(5);
        this.f79921f = false;
    }

    public void setAlertDialogInfo(AlertInfo alertInfo) {
    }

    public void setCallback(c cVar) {
        this.f79919d = cVar;
    }

    public void setHBWebViewLifecycleCallback(t tVar) {
    }

    public void setLoadErrorListener(HBWebView.d dVar) {
        this.f79922g = dVar;
    }

    public void setNeedLoginAction(boolean z11, boolean z12, JsMessage jsMessage) {
    }

    public void setProcess(int i11) {
    }

    public void setTitleText(CharSequence charSequence) {
    }

    public void setUrl(String str) {
        this.f79918c = StringUtils.w(str);
    }

    public void setWebViewRefreshType(String str) {
    }

    public void showActionBarShare(boolean z11) {
    }

    public void showProgressDialog() {
    }

    public void showProgressDialog(boolean z11) {
    }

    public void showTopIcon(List<Map<String, String>> list) {
    }

    public OtcActiveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OtcActiveView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79920e = BehaviorSubject.create();
        j(context);
    }
}
