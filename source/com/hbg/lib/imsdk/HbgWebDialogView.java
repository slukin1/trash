package com.hbg.lib.imsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.r;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.module.huobi.im.imsignal.ImSdkModuleConfig;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import e7.e;
import e7.i;
import e7.y;
import h7.b;
import i6.k;
import java.util.List;
import org.aspectj.lang.JoinPoint;

public class HbgWebDialogView extends FrameLayout {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f69168k = null;

    /* renamed from: b  reason: collision with root package name */
    public HbgDialogWebView f69169b;

    /* renamed from: c  reason: collision with root package name */
    public String f69170c;

    /* renamed from: d  reason: collision with root package name */
    public int f69171d;

    /* renamed from: e  reason: collision with root package name */
    public e f69172e;

    /* renamed from: f  reason: collision with root package name */
    public f7.a f69173f;

    /* renamed from: g  reason: collision with root package name */
    public d f69174g;

    /* renamed from: h  reason: collision with root package name */
    public HbgDialogConfigInfo f69175h;

    /* renamed from: i  reason: collision with root package name */
    public long f69176i;

    /* renamed from: j  reason: collision with root package name */
    public String f69177j;

    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f69178b;

        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0138 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0139  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                com.hbg.lib.imsdk.HbgWebDialogView r0 = com.hbg.lib.imsdk.HbgWebDialogView.this
                android.content.Context r0 = r0.getContext()
                r1 = 0
                if (r0 == 0) goto L_0x0140
                com.hbg.lib.imsdk.HbgWebDialogView r0 = com.hbg.lib.imsdk.HbgWebDialogView.this
                boolean r0 = r0.isShown()
                if (r0 == 0) goto L_0x0140
                com.hbg.lib.imsdk.HbgWebDialogView r0 = com.hbg.lib.imsdk.HbgWebDialogView.this
                com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo r0 = r0.f69175h
                int r0 = r0.positionType
                r2 = 1
                if (r0 != r2) goto L_0x001d
                return r1
            L_0x001d:
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r9)
                float r3 = r9.getRawX()
                float r4 = r9.getRawY()
                r0.setLocation(r3, r4)
                com.hbg.lib.imsdk.HbgWebDialogView r3 = com.hbg.lib.imsdk.HbgWebDialogView.this
                com.hbg.lib.imsdk.HbgDialogWebView r3 = r3.f69169b
                float r3 = r3.getAlpha()
                r4 = 0
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x0042
                com.hbg.lib.imsdk.HbgWebDialogView r1 = com.hbg.lib.imsdk.HbgWebDialogView.this
                boolean r8 = r1.h(r9, r8, r0)
                return r8
            L_0x0042:
                com.hbg.lib.imsdk.HbgWebDialogView r3 = com.hbg.lib.imsdk.HbgWebDialogView.this
                int r3 = r3.f69171d
                if (r3 >= 0) goto L_0x004b
                return r1
            L_0x004b:
                r3 = 255(0xff, float:3.57E-43)
                int r5 = r9.getAction()
                if (r5 == 0) goto L_0x00a2
                if (r5 == r2) goto L_0x007b
                r2 = 2
                if (r5 == r2) goto L_0x005e
                r2 = 3
                if (r5 == r2) goto L_0x007b
                r2 = r1
                goto L_0x00c8
            L_0x005e:
                android.graphics.Bitmap r2 = r7.f69178b     // Catch:{ Exception -> 0x0075 }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x0075 }
                int r5 = (int) r5     // Catch:{ Exception -> 0x0075 }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x0075 }
                int r6 = (int) r6     // Catch:{ Exception -> 0x0075 }
                int r2 = r2.getPixel(r5, r6)     // Catch:{ Exception -> 0x0075 }
                int r3 = android.graphics.Color.alpha(r2)     // Catch:{ Exception -> 0x0073 }
                goto L_0x00c8
            L_0x0073:
                r5 = move-exception
                goto L_0x0077
            L_0x0075:
                r5 = move-exception
                r2 = r1
            L_0x0077:
                r5.printStackTrace()
                goto L_0x00c8
            L_0x007b:
                android.graphics.Bitmap r2 = r7.f69178b     // Catch:{ Exception -> 0x0092 }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x0092 }
                int r5 = (int) r5     // Catch:{ Exception -> 0x0092 }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x0092 }
                int r6 = (int) r6     // Catch:{ Exception -> 0x0092 }
                int r2 = r2.getPixel(r5, r6)     // Catch:{ Exception -> 0x0092 }
                int r3 = android.graphics.Color.alpha(r2)     // Catch:{ Exception -> 0x0090 }
                goto L_0x0097
            L_0x0090:
                r5 = move-exception
                goto L_0x0094
            L_0x0092:
                r5 = move-exception
                r2 = r1
            L_0x0094:
                r5.printStackTrace()
            L_0x0097:
                android.graphics.Bitmap r5 = r7.f69178b     // Catch:{ Exception -> 0x009d }
                r5.recycle()     // Catch:{ Exception -> 0x009d }
                goto L_0x00c8
            L_0x009d:
                r5 = move-exception
                r5.printStackTrace()
                goto L_0x00c8
            L_0x00a2:
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this     // Catch:{ Exception -> 0x00c3 }
                com.hbg.lib.imsdk.HbgDialogWebView r2 = r2.f69169b     // Catch:{ Exception -> 0x00c3 }
                android.graphics.Bitmap r2 = com.hbg.lib.imsdk.HbgWebDialogView.j(r2)     // Catch:{ Exception -> 0x00c3 }
                r7.f69178b = r2     // Catch:{ Exception -> 0x00c3 }
                float r5 = r9.getX()     // Catch:{ Exception -> 0x00c3 }
                int r5 = (int) r5     // Catch:{ Exception -> 0x00c3 }
                float r6 = r9.getY()     // Catch:{ Exception -> 0x00c3 }
                int r6 = (int) r6     // Catch:{ Exception -> 0x00c3 }
                int r2 = r2.getPixel(r5, r6)     // Catch:{ Exception -> 0x00c3 }
                int r3 = android.graphics.Color.alpha(r2)     // Catch:{ Exception -> 0x00c1 }
                goto L_0x00c8
            L_0x00c1:
                r5 = move-exception
                goto L_0x00c5
            L_0x00c3:
                r5 = move-exception
                r2 = r1
            L_0x00c5:
                r5.printStackTrace()
            L_0x00c8:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "ImSdkManager--> pixel:"
                r5.append(r6)
                r5.append(r2)
                java.lang.String r2 = " event.getAction():"
                r5.append(r2)
                int r2 = r9.getAction()
                r5.append(r2)
                java.lang.String r2 = " mWebView.getAlpha():"
                r5.append(r2)
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this
                com.hbg.lib.imsdk.HbgDialogWebView r2 = r2.f69169b
                float r2 = r2.getAlpha()
                r5.append(r2)
                java.lang.String r2 = " tempAlpha:"
                r5.append(r2)
                r5.append(r3)
                java.lang.String r2 = " positionType:"
                r5.append(r2)
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this
                com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo r2 = r2.f69175h
                int r2 = r2.positionType
                r5.append(r2)
                java.lang.String r2 = "server alpha:"
                r5.append(r2)
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this
                int r2 = r2.f69171d
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                java.lang.String r5 = "HBgDialog"
                i6.d.c(r5, r2)
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this
                com.hbg.lib.imsdk.HbgDialogWebView r2 = r2.f69169b
                float r2 = r2.getAlpha()
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0139
                com.hbg.lib.imsdk.HbgWebDialogView r2 = com.hbg.lib.imsdk.HbgWebDialogView.this
                int r2 = r2.f69171d
                if (r3 <= r2) goto L_0x0139
                return r1
            L_0x0139:
                com.hbg.lib.imsdk.HbgWebDialogView r1 = com.hbg.lib.imsdk.HbgWebDialogView.this
                boolean r8 = r1.h(r9, r8, r0)
                return r8
            L_0x0140:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.imsdk.HbgWebDialogView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            k.o("HbgDialog", "H5加载失败：url：" + str2 + "，description：" + str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (Build.VERSION.SDK_INT >= 14) {
                k.o("HbgDialog", "H5加载失败：url：" + sslError.getUrl() + "，description：证书校验失败");
            }
        }
    }

    public class c implements b.a {
        public c() {
        }

        public void a(String str, int i11) {
            if (HbgWebDialogView.this.f69172e != null) {
                HbgWebDialogView.this.f69172e.a(str, HbgWebDialogView.this.f69176i, i11);
            }
        }

        public void onShow() {
            if (HbgWebDialogView.this.f69172e != null) {
                HbgWebDialogView.this.f69172e.onShow();
            }
        }
    }

    public interface d {
    }

    static {
        g();
    }

    public HbgWebDialogView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void g() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("HbgWebDialogView.java", HbgWebDialogView.class);
        f69168k = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.hbg.lib.imsdk.HbgDialogWebView", "android.webkit.WebViewClient", "client", "", "void"), 163);
    }

    public static Bitmap j(View view) {
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

    public final boolean h(MotionEvent motionEvent, View view, MotionEvent motionEvent2) {
        Activity f11 = i.h().f();
        if (!(f11 instanceof FragmentActivity)) {
            return false;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) f11;
        MotionEvent obtain = MotionEvent.obtain(motionEvent2);
        List<Fragment> B0 = fragmentActivity.getSupportFragmentManager().B0();
        if (!B0.isEmpty()) {
            int size = B0.size() - 1;
            while (size >= 0) {
                Fragment fragment = B0.get(size);
                if (!fragment.isVisible() || !(fragment instanceof DialogFragment) || (fragment instanceof HbImDialogFragment) || fragment.getView() == null) {
                    size--;
                } else {
                    int[] iArr = new int[2];
                    fragment.getView().getLocationOnScreen(iArr);
                    obtain.setLocation(obtain.getX() - ((float) iArr[0]), obtain.getY() - ((float) iArr[1]));
                    i6.d.b("ImSdkManager:" + fragment + "=======" + this.f69177j);
                    return fragment.getView().dispatchTouchEvent(obtain);
                }
            }
        }
        Dialog h11 = r.h();
        if (!(h11 == null || h11.getWindow() == null)) {
            int[] iArr2 = new int[2];
            h11.getWindow().getDecorView().getLocationOnScreen(iArr2);
            obtain.setLocation(obtain.getX() - ((float) iArr2[0]), obtain.getY() - ((float) iArr2[1]));
            if (h11.dispatchTouchEvent(obtain)) {
                return true;
            }
        }
        return fragmentActivity.dispatchTouchEvent(motionEvent2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void i(Context context) {
        HbgDialogWebView hbgDialogWebView = (HbgDialogWebView) LayoutInflater.from(context).inflate(R$layout.hb_im_dialog, this).findViewById(R$id.hb_im_dialog_webView);
        this.f69169b = hbgDialogWebView;
        hbgDialogWebView.setBackgroundColor(0);
        this.f69169b.setAlpha(0.0f);
        this.f69169b.setOnTouchListener(new a());
        this.f69169b.c(context);
        HbgDialogWebView hbgDialogWebView2 = this.f69169b;
        b bVar = new b();
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f69168k, this, hbgDialogWebView2, bVar);
        WoodPeckerWebViewAspect.h().g(new y(new Object[]{this, hbgDialogWebView2, bVar, c11}).linkClosureAndJoinPoint(4112));
    }

    public void l() {
        ImSdkModuleConfig.a().b(this.f69169b);
        HbgDialogWebView hbgDialogWebView = this.f69169b;
        hbgDialogWebView.addJavascriptInterface(new h7.b(hbgDialogWebView, new c()), "hbWallet");
        HbgDialogWebView hbgDialogWebView2 = this.f69169b;
        String str = this.f69170c;
        hbgDialogWebView2.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(hbgDialogWebView2, str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
        return h(motionEvent, this, obtain);
    }

    public void setAlpha(int i11) {
        this.f69171d = i11;
    }

    public void setCallback(e eVar) {
        this.f69172e = eVar;
    }

    public void setDialogDispatchCallback(d dVar) {
        this.f69174g = dVar;
    }

    public void setDialogId(HbgDialogConfigInfo hbgDialogConfigInfo) {
        this.f69175h = hbgDialogConfigInfo;
        this.f69176i = hbgDialogConfigInfo.dialogId;
    }

    public void setDialogTag(String str) {
        this.f69177j = str;
    }

    public void setUrl(String str) {
        this.f69170c = StringUtils.w(str);
    }

    public void setViewDispatchTouchCallback(f7.a aVar) {
        this.f69173f = aVar;
    }

    public void setWebViewHeight(int i11) {
        this.f69169b.getLayoutParams().height = i11;
    }

    public HbgWebDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HbgWebDialogView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f69171d = -1;
        i(context);
    }
}
