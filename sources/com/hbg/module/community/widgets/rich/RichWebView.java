package com.hbg.module.community.widgets.rich;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.business.common.red_packet.RedPacketManager;
import com.business.common.red_packet.RedPacketResult;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.content.R$color;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import i6.d;
import ic.e;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.c;

@SuppressLint({"SetJavaScriptEnabled"})
public final class RichWebView extends WebView {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f17716h = null;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17717b;

    /* renamed from: c  reason: collision with root package name */
    public final AttributeSet f17718c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17719d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17720e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17721f;

    /* renamed from: g  reason: collision with root package name */
    public long f17722g;

    public final class a extends WebViewClient {
        public a() {
        }

        public void onPageFinished(WebView webView, String str) {
            RichWebView richWebView = RichWebView.this;
            richWebView.f17720e = StringsKt__StringsJVMKt.w(str, richWebView.f17719d, true);
            d.c("WebView富文本", "onPageFinished isReady : " + RichWebView.this.f17720e);
            if (RichWebView.this.f17720e) {
                RichWebView.this.setEditorFontSize(16);
                RichWebView richWebView2 = RichWebView.this;
                richWebView2.setEditorFontColor(richWebView2.getResources().getColor(R$color.baseColorPrimaryText));
                RichWebView.this.setPadding(16, 12, 15, 12);
                RichWebView.this.setInputEnabled(false);
                RichWebView richWebView3 = RichWebView.this;
                richWebView3.setBackgroundColor(richWebView3.getResources().getColor(R$color.baseColorContentBackground));
                RichWebView richWebView4 = RichWebView.this;
                richWebView4.h(richWebView4.getContext(), RichWebView.this.f17718c);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String str;
            Uri url;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str = url.toString()) == null) {
                str = "";
            }
            d.c("WebView富文本", "shouldOverrideUrlLoading : " + str);
            RedPacketResult b11 = RedPacketManager.b(str);
            if (b11.isRedPacket()) {
                if (!(RichWebView.this.getMContext() instanceof FragmentActivity)) {
                    return true;
                }
                BaseModuleConfig.a().v((FragmentActivity) RichWebView.this.getMContext(), b11.getCodeWord());
                return true;
            } else if (StringsKt__StringsJVMKt.M(str, "http", false, 2, (Object) null)) {
                b2.a.d().a("/webView/index").withString("url", str).navigation();
                return true;
            } else if (!StringsKt__StringsJVMKt.M(str, "holigeit", false, 2, (Object) null)) {
                return true;
            } else {
                BaseModuleConfig.a().k0(str);
                return true;
            }
        }
    }

    static {
        g();
    }

    public RichWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public static /* synthetic */ void g() {
        c cVar = new c("RichWebView.kt", RichWebView.class);
        f17716h = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.hbg.module.community.widgets.rich.RichWebView", "android.webkit.WebViewClient", "client", "", "void"), 45);
    }

    public static final void k(RichWebView richWebView, String str) {
        richWebView.j(str);
    }

    public final Context getMContext() {
        return this.f17717b;
    }

    @SuppressLint({"RtlHardcoded"})
    public final void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
        int i11 = obtainStyledAttributes.getInt(0, -1);
        if (i11 == 1) {
            j("javascript:RE.setTextAlign(\"center\")");
        } else if (i11 == 3) {
            j("javascript:RE.setTextAlign(\"left\")");
        } else if (i11 == 5) {
            j("javascript:RE.setTextAlign(\"right\")");
        } else if (i11 == 48) {
            j("javascript:RE.setVerticalAlign(\"top\")");
        } else if (i11 == 80) {
            j("javascript:RE.setVerticalAlign(\"bottom\")");
        } else if (i11 == 16) {
            j("javascript:RE.setVerticalAlign(\"middle\")");
        } else if (i11 == 17) {
            j("javascript:RE.setVerticalAlign(\"middle\")");
            j("javascript:RE.setTextAlign(\"center\")");
        }
        obtainStyledAttributes.recycle();
    }

    public final String i(int i11) {
        d0 d0Var = d0.f56774a;
        return String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i11 & FlexItem.MAX_SIZE)}, 1));
    }

    public final void j(String str) {
        try {
            if (this.f17720e) {
                evaluateJavascript(str, (ValueCallback) null);
            } else {
                postDelayed(new ic.c(this, str), 100);
            }
        } catch (Exception e11) {
            d.c("WebView富文本", "exec e : " + e11.getMessage());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f17722g = Calendar.getInstance().getTimeInMillis();
        } else if (valueOf != null && valueOf.intValue() == 1 && Calendar.getInstance().getTimeInMillis() - this.f17722g < ((long) this.f17721f)) {
            super.performClick();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setBackground(String str) {
        j("javascript:RE.setBackgroundImage('url(" + str + ")');");
    }

    public void setBackgroundResource(int i11) {
        e eVar = e.f19136a;
        Bitmap a11 = eVar.a(getContext(), i11);
        if (a11 != null) {
            String b11 = eVar.b(a11);
            a11.recycle();
            j("javascript:RE.setBackgroundImage('url(data:image/png;base64," + b11 + ")');");
        }
    }

    public final void setEditorFontColor(int i11) {
        String i12 = i(i11);
        j("javascript:RE.setBaseTextColor('" + i12 + "');");
    }

    public final void setEditorFontSize(int i11) {
        j("javascript:RE.setBaseFontSize('" + i11 + "px');");
    }

    public final void setHtml(String str) {
        if (str == null) {
            str = "";
        }
        j("javascript:RE.setHtml('" + URLEncoder.encode(str, "UTF-8") + "');");
    }

    public final void setInputEnabled(boolean z11) {
        j("javascript:RE.setInputEnabled(" + z11 + ')');
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        j("javascript:RE.setPadding('" + i11 + "px', '" + i12 + "px', '" + i13 + "px', '" + i14 + "px');");
    }

    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        setPadding(i11, i12, i13, i14);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RichWebView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, attributeSet, (i12 & 4) != 0 ? 16842885 : i11);
    }

    public RichWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17717b = context;
        this.f17718c = attributeSet;
        this.f17719d = "file:///android_asset/editor.html";
        this.f17721f = 200;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setCacheMode(2);
        getSettings().setAllowFileAccess(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setDomStorageEnabled(true);
        a aVar = new a();
        JoinPoint c11 = c.c(f17716h, this, this, aVar);
        WoodPeckerWebViewAspect.h().g(new ic.d(new Object[]{this, this, aVar, c11}).linkClosureAndJoinPoint(4112));
        clearHistory();
        loadUrl("file:///android_asset/editor.html");
        SensorsDataAutoTrackHelper.loadUrl2(this, "file:///android_asset/editor.html");
    }
}
