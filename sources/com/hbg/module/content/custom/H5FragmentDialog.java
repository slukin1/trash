package com.hbg.module.content.custom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$style;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lc.e0;
import org.aspectj.lang.JoinPoint;
import rd.s;
import rx.subjects.BehaviorSubject;
import v6.t;
import v6.u;
import v6.w;

public final class H5FragmentDialog extends DialogFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f18006e = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f18007f = null;

    /* renamed from: b  reason: collision with root package name */
    public e0 f18008b;

    /* renamed from: c  reason: collision with root package name */
    public String f18009c;

    /* renamed from: d  reason: collision with root package name */
    public u f18010d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final H5FragmentDialog a(FragmentManager fragmentManager, String str) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("H5FragmentDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                H5FragmentDialog h5FragmentDialog = new H5FragmentDialog();
                Bundle bundle = new Bundle();
                bundle.putString("url", str);
                h5FragmentDialog.setArguments(bundle);
                q11.e(h5FragmentDialog, "H5FragmentDialog");
                q11.k();
                return h5FragmentDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ H5FragmentDialog f18011b;

        public b(H5FragmentDialog h5FragmentDialog) {
            this.f18011b = h5FragmentDialog;
        }

        public void clearNeedLoginAction() {
        }

        public void dismissProgressDialog() {
        }

        public Activity getActivity() {
            return this.f18011b.getActivity();
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
            return this.f18011b.f18008b.B;
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
        public final /* synthetic */ H5FragmentDialog f18012a;

        public c(H5FragmentDialog h5FragmentDialog) {
            this.f18012a = h5FragmentDialog;
        }

        public void onPageFinished(WebView webView, String str) {
            e0 rh2;
            HBWebView hBWebView;
            super.onPageFinished(webView, str);
            i6.d.b("H5FragmentDialog---->onPageFinished = ");
            if (x.b(this.f18012a.f18009c, str) && (rh2 = this.f18012a.f18008b) != null && (hBWebView = rh2.B) != null) {
                hBWebView.clearHistory();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            e0 rh2 = this.f18012a.f18008b;
            LoadingLayout loadingLayout = rh2 != null ? rh2.E : null;
            if (loadingLayout != null) {
                loadingLayout.setVisibility(8);
            }
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            LoadingLayout loadingLayout;
            super.onReceivedError(webView, i11, str, str2);
            boolean z11 = true;
            LoadingLayout loadingLayout2 = null;
            if (str2 == null || !StringsKt__StringsJVMKt.M(str2, "huobiapp://", false, 2, (Object) null)) {
                z11 = false;
            }
            if (!z11) {
                e0 rh2 = this.f18012a.f18008b;
                if (rh2 != null) {
                    loadingLayout2 = rh2.E;
                }
                if (loadingLayout2 != null) {
                    loadingLayout2.setVisibility(0);
                }
                e0 rh3 = this.f18012a.f18008b;
                if (rh3 != null && (loadingLayout = rh3.E) != null) {
                    loadingLayout.k();
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!HbgRouter.f(str)) {
                return false;
            }
            w.e().g(this.f18012a.getActivity(), str);
            return true;
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18013b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18014c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ H5FragmentDialog f18015d;

        public d(View view, long j11, H5FragmentDialog h5FragmentDialog) {
            this.f18013b = view;
            this.f18014c = j11;
            this.f18015d = h5FragmentDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18013b) > this.f18014c || (this.f18013b instanceof Checkable)) {
                sVar.e(this.f18013b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18013b;
                this.f18015d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    static {
        th();
    }

    public static /* synthetic */ void th() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("H5FragmentDialog.kt", H5FragmentDialog.class);
        f18007f = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.hbg.lib.core.webview.HBWebView", "android.webkit.WebViewClient", "client", "", "void"), 114);
    }

    @SensorsDataInstrumented
    public static final void yh(H5FragmentDialog h5FragmentDialog, View view) {
        e0 e0Var = h5FragmentDialog.f18008b;
        LoadingLayout loadingLayout = e0Var != null ? e0Var.E : null;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(8);
        }
        h5FragmentDialog.Bh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r3 = r3.B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zh(com.hbg.module.content.custom.H5FragmentDialog r1, android.view.View r2, int r3, android.view.KeyEvent r4) {
        /*
            r2 = 1
            r4 = 0
            r0 = 4
            if (r3 != r0) goto L_0x0024
            lc.e0 r3 = r1.f18008b
            if (r3 == 0) goto L_0x0015
            com.hbg.lib.core.webview.HBWebView r3 = r3.B
            if (r3 == 0) goto L_0x0015
            boolean r3 = r3.canGoBack()
            if (r3 != r2) goto L_0x0015
            r3 = r2
            goto L_0x0016
        L_0x0015:
            r3 = r4
        L_0x0016:
            if (r3 == 0) goto L_0x0024
            lc.e0 r1 = r1.f18008b
            if (r1 == 0) goto L_0x0025
            com.hbg.lib.core.webview.HBWebView r1 = r1.B
            if (r1 == 0) goto L_0x0025
            r1.goBack()
            goto L_0x0025
        L_0x0024:
            r2 = r4
        L_0x0025:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.H5FragmentDialog.zh(com.hbg.module.content.custom.H5FragmentDialog, android.view.View, int, android.view.KeyEvent):boolean");
    }

    public final void Ah() {
        e0 e0Var = this.f18008b;
        HBWebView hBWebView = null;
        HBWebView hBWebView2 = e0Var != null ? e0Var.B : null;
        if (hBWebView2 != null) {
            c cVar = new c(this);
            WoodPeckerWebViewAspect.h().g(new f(new Object[]{this, hBWebView2, cVar, org.aspectj.runtime.reflect.c.c(f18007f, this, hBWebView2, cVar)}).linkClosureAndJoinPoint(4112));
        }
        e0 e0Var2 = this.f18008b;
        if (e0Var2 != null) {
            hBWebView = e0Var2.B;
        }
        if (hBWebView != null) {
            hBWebView.setWebChromeClient(new w6.b(this.f18010d));
        }
    }

    public final void Bh() {
        e0 e0Var;
        HBWebView hBWebView;
        HBWebView hBWebView2;
        e0 e0Var2 = this.f18008b;
        if (!(e0Var2 == null || (hBWebView2 = e0Var2.B) == null)) {
            hBWebView2.clearHistory();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        String str = this.f18009c;
        if (str != null && (e0Var = this.f18008b) != null && (hBWebView = e0Var.B) != null) {
            hBWebView.loadUrl(str, hashMap);
            SensorsDataAutoTrackHelper.loadUrl2(hBWebView, str, hashMap);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = (r1 = r1.B).getSettings();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Dh() {
        /*
            r3 = this;
            v6.w r0 = v6.w.e()
            lc.e0 r1 = r3.f18008b
            r2 = 0
            if (r1 == 0) goto L_0x0018
            com.hbg.lib.core.webview.HBWebView r1 = r1.B
            if (r1 == 0) goto L_0x0018
            android.webkit.WebSettings r1 = r1.getSettings()
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r1.getUserAgentString()
            goto L_0x0019
        L_0x0018:
            r1 = r2
        L_0x0019:
            java.lang.String r0 = r0.f(r1)
            lc.e0 r1 = r3.f18008b
            if (r1 == 0) goto L_0x0029
            com.hbg.lib.core.webview.HBWebView r1 = r1.B
            if (r1 == 0) goto L_0x0029
            android.webkit.WebSettings r2 = r1.getSettings()
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r2.setUserAgentString(r0)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.H5FragmentDialog.Dh():void");
    }

    public final void initView() {
        HBWebView hBWebView;
        LoadingLayout loadingLayout;
        w.e().b();
        AppLanguageHelper.getInstance().changeAppLanguage(getActivity(), AppLanguageHelper.getInstance().getCurAppLocale());
        e0 e0Var = this.f18008b;
        LoadingLayout loadingLayout2 = e0Var != null ? e0Var.E : null;
        if (loadingLayout2 != null) {
            loadingLayout2.setVisibility(8);
        }
        e0 e0Var2 = this.f18008b;
        if (!(e0Var2 == null || (loadingLayout = e0Var2.E) == null)) {
            loadingLayout.setOnRetryClickListener(new d(this));
        }
        wh();
        xh();
        Dh();
        Ah();
        Bh();
        e0 e0Var3 = this.f18008b;
        if (e0Var3 != null && (hBWebView = e0Var3.B) != null) {
            hBWebView.setOnKeyListener(new e(this));
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        ImageView imageView;
        View decorView;
        this.f18008b = e0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(this.f18008b.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = -1;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        e0 e0Var = this.f18008b;
        if (!(e0Var == null || (imageView = e0Var.C) == null)) {
            s sVar = s.f23381a;
            imageView.setOnClickListener(new d(imageView, 800, this));
        }
        initView();
        return dialog;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setArguments(Bundle bundle) {
        String string;
        super.setArguments(bundle);
        if (bundle != null && (string = bundle.getString("url")) != null) {
            this.f18009c = uh(string);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final String uh(String str) {
        boolean g11 = NightHelper.e().g();
        d0 d0Var = d0.f56774a;
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", Arrays.copyOf(new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(g11 ? 1 : 0))}, 6));
        if (StringsKt__StringsKt.R(str, "?", false, 2, (Object) null)) {
            return str + '&' + format;
        }
        return str + '?' + format;
    }

    public final x6.c vh() {
        return new x6.c(this.f18010d);
    }

    public final void wh() {
        this.f18010d = new b(this);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void xh() {
        HBWebView hBWebView;
        e0 e0Var = this.f18008b;
        if (e0Var != null && (hBWebView = e0Var.B) != null) {
            hBWebView.addJavascriptInterface(vh(), "huobiNative");
        }
    }
}
