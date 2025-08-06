package com.hbg.module.content.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.router.HbgRouter;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lc.m1;
import org.aspectj.lang.JoinPoint;
import rx.subjects.BehaviorSubject;
import v6.t;
import v6.u;
import v6.w;

public final class H5Fragment extends BaseFragment<m1> {

    /* renamed from: s  reason: collision with root package name */
    public static final a f18742s = new a((r) null);

    /* renamed from: t  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f18743t = null;

    /* renamed from: p  reason: collision with root package name */
    public boolean f18744p;

    /* renamed from: q  reason: collision with root package name */
    public String f18745q;

    /* renamed from: r  reason: collision with root package name */
    public u f18746r;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ H5Fragment b(a aVar, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return aVar.a(str, z11);
        }

        public final H5Fragment a(String str, boolean z11) {
            H5Fragment h5Fragment = new H5Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("showAction", z11);
            h5Fragment.setArguments(bundle);
            return h5Fragment;
        }
    }

    public static final class b implements u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ H5Fragment f18747b;

        public b(H5Fragment h5Fragment) {
            this.f18747b = h5Fragment;
        }

        public void clearNeedLoginAction() {
        }

        public void dismissProgressDialog() {
        }

        public Activity getActivity() {
            return this.f18747b.getActivity();
        }

        public String getAvailableLocationY() {
            return "";
        }

        public String getDisplayHeight() {
            return "";
        }

        public String getDisplayWidth() {
            return "";
        }

        public String getNavigatorHeight() {
            return "";
        }

        public String getTopHeight() {
            return "";
        }

        public BehaviorSubject<Integer> getUIChangeSubject() {
            return BehaviorSubject.create();
        }

        public WebView getWebView() {
            return H5Fragment.Th(this.f18747b).B;
        }

        public boolean isAlive() {
            return true;
        }

        public boolean isCanBeSeen() {
            return true;
        }

        public boolean isSupportBlankLabel() {
            return true;
        }

        public void setAlertDialogInfo(AlertInfo alertInfo) {
        }

        public void setHBWebViewLifecycleCallback(t tVar) {
        }

        public void setNeedLoginAction(boolean z11, boolean z12, JsMessage<?> jsMessage) {
        }

        public void setProcess(int i11) {
        }

        public void setTitleText(CharSequence charSequence) {
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
    }

    public static final class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ H5Fragment f18748a;

        public c(H5Fragment h5Fragment) {
            this.f18748a = h5Fragment;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.b("HBBaseWebViewActivity---->onPageFinished = ");
            if (x.b(this.f18748a.f18745q, str)) {
                H5Fragment.Th(this.f18748a).B.clearHistory();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            H5Fragment.Th(this.f18748a).C.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            boolean z11 = true;
            if (str2 == null || !StringsKt__StringsJVMKt.M(str2, "huobiapp://", false, 2, (Object) null)) {
                z11 = false;
            }
            if (!z11) {
                H5Fragment.Th(this.f18748a).C.setVisibility(0);
                H5Fragment.Th(this.f18748a).C.k();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!HbgRouter.f(str)) {
                return false;
            }
            w.e().g(this.f18748a.getActivity(), str);
            return true;
        }
    }

    static {
        Vh();
    }

    public static final /* synthetic */ m1 Th(H5Fragment h5Fragment) {
        return (m1) h5Fragment.uh();
    }

    public static /* synthetic */ void Vh() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("H5Fragment.kt", H5Fragment.class);
        f18743t = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.hbg.lib.core.webview.HBWebView", "android.webkit.WebViewClient", "client", "", "void"), 102);
    }

    public static final H5Fragment Xh(String str, boolean z11) {
        return f18742s.a(str, z11);
    }

    @SensorsDataInstrumented
    public static final void ci(H5Fragment h5Fragment, View view) {
        ((m1) h5Fragment.uh()).C.setVisibility(8);
        h5Fragment.fi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final boolean di(H5Fragment h5Fragment, View view, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !((m1) h5Fragment.uh()).B.canGoBack()) {
            return false;
        }
        ((m1) h5Fragment.uh()).B.goBack();
        return true;
    }

    public void Ah() {
        String string;
        super.Ah();
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString("url")) == null)) {
            this.f18745q = StringUtils.w(Wh(string));
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.f18744p = arguments2.getBoolean("showAction");
        }
    }

    public final String Wh(String str) {
        boolean g11 = NightHelper.e().g();
        d0 d0Var = d0.f56774a;
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", Arrays.copyOf(new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(g11 ? 1 : 0))}, 6));
        if (StringsKt__StringsKt.R(str, "?", false, 2, (Object) null)) {
            return str + '&' + format;
        }
        return str + '?' + format;
    }

    public final x6.c Yh() {
        return new x6.c(this.f18746r);
    }

    /* renamed from: Zh */
    public m1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return m1.K(layoutInflater, viewGroup, false);
    }

    public final void ai() {
        this.f18746r = new b(this);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void bi() {
        ((m1) uh()).B.addJavascriptInterface(Yh(), "huobiNative");
    }

    public final void ei() {
        HBWebView hBWebView = ((m1) uh()).B;
        c cVar = new c(this);
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f18743t, this, hBWebView, cVar);
        WoodPeckerWebViewAspect.h().g(new d(new Object[]{this, hBWebView, cVar, c11}).linkClosureAndJoinPoint(4112));
        ((m1) uh()).B.setWebChromeClient(new w6.b(this.f18746r));
    }

    public final void fi() {
        ((m1) uh()).B.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        String str = this.f18745q;
        if (str != null) {
            HBWebView hBWebView = ((m1) uh()).B;
            hBWebView.loadUrl(str, hashMap);
            SensorsDataAutoTrackHelper.loadUrl2(hBWebView, str, hashMap);
        }
    }

    public final void gi(String str) {
        ((m1) uh()).B.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        HBWebView hBWebView = ((m1) uh()).B;
        String w11 = StringUtils.w(str);
        hBWebView.loadUrl(w11, hashMap);
        SensorsDataAutoTrackHelper.loadUrl2(hBWebView, w11, hashMap);
    }

    public final void hi() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void initView() {
        if (this.f18744p) {
            ((m1) uh()).D.setVisibility(0);
            ((m1) uh()).M(this);
        }
        w.e().b();
        AppLanguageHelper.getInstance().changeAppLanguage(getActivity(), AppLanguageHelper.getInstance().getCurAppLocale());
        ((m1) uh()).C.setVisibility(8);
        ((m1) uh()).C.setOnRetryClickListener(new b(this));
        ai();
        bi();
        ji();
        ei();
        fi();
        ((m1) uh()).B.setOnKeyListener(new c(this));
    }

    public final void ji() {
        ((m1) uh()).B.getSettings().setUserAgentString(w.e().f(((m1) uh()).B.getSettings().getUserAgentString()));
    }
}
