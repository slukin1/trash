package com.hbg.module.community.widgets.rich;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import ic.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.text.Regex;
import org.aspectj.lang.JoinPoint;

@SuppressLint({"SetJavaScriptEnabled"})
public final class RichEditor extends WebView {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f17703m = null;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17704b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17705c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17706d;

    /* renamed from: e  reason: collision with root package name */
    public final String f17707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17708f;

    /* renamed from: g  reason: collision with root package name */
    public String f17709g;

    /* renamed from: h  reason: collision with root package name */
    public d f17710h;

    /* renamed from: i  reason: collision with root package name */
    public c f17711i;

    /* renamed from: j  reason: collision with root package name */
    public a f17712j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17713k;

    /* renamed from: l  reason: collision with root package name */
    public long f17714l;

    public enum Type {
        BOLD,
        ITALIC,
        SUBSCRIPT,
        SUPERSCRIPT,
        STRIKETHROUGH,
        UNDERLINE,
        H1,
        H2,
        H3,
        H4,
        H5,
        H6,
        ORDEREDLIST,
        UNORDEREDLIST,
        JUSTIFYCENTER,
        JUSTIFYFULL,
        JUSTIFYLEFT,
        JUSTIFYRIGHT
    }

    public interface a {
        void a(boolean z11);
    }

    public interface c {
        void a(String str, List<? extends Type> list);
    }

    public interface d {
        void onTextChange(String str);
    }

    static {
        j();
    }

    public RichEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public static /* synthetic */ void j() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("RichEditor.kt", RichEditor.class);
        f17703m = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.hbg.module.community.widgets.rich.RichEditor", "android.webkit.WebViewClient", "client", "", "void"), 47);
    }

    public static final void o(RichEditor richEditor, String str) {
        richEditor.n(str);
    }

    public final String getHtml() {
        return this.f17709g;
    }

    public final Context getMContext() {
        return this.f17704b;
    }

    public final void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
        int i11 = obtainStyledAttributes.getInt(0, -1);
        if (i11 == 1) {
            n("javascript:RE.setTextAlign(\"center\")");
        } else if (i11 == 3) {
            n("javascript:RE.setTextAlign(\"left\")");
        } else if (i11 == 5) {
            n("javascript:RE.setTextAlign(\"right\")");
        } else if (i11 == 48) {
            n("javascript:RE.setVerticalAlign(\"top\")");
        } else if (i11 == 80) {
            n("javascript:RE.setVerticalAlign(\"bottom\")");
        } else if (i11 == 16) {
            n("javascript:RE.setVerticalAlign(\"middle\")");
        } else if (i11 == 17) {
            n("javascript:RE.setVerticalAlign(\"middle\")");
            n("javascript:RE.setTextAlign(\"center\")");
        }
        obtainStyledAttributes.recycle();
    }

    public final void l(String str) {
        String replaceFirst = new Regex(this.f17706d).replaceFirst(str, "");
        this.f17709g = replaceFirst;
        d dVar = this.f17710h;
        if (dVar != null) {
            dVar.onTextChange(replaceFirst);
        }
    }

    public final String m(int i11) {
        d0 d0Var = d0.f56774a;
        return String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i11 & FlexItem.MAX_SIZE)}, 1));
    }

    public final void n(String str) {
        if (this.f17708f) {
            r(str);
        } else {
            postDelayed(new ic.a(this, str), 100);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f17714l = Calendar.getInstance().getTimeInMillis();
        } else if (valueOf != null && valueOf.intValue() == 1 && Calendar.getInstance().getTimeInMillis() - this.f17714l < ((long) this.f17713k)) {
            super.performClick();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        requestFocus();
        n("javascript:RE.focus();");
    }

    public final void q(String str, String str2) {
        n("javascript:RE.prepareInsert();");
        n("javascript:RE.insertImage('" + str + "', '" + str2 + "');");
    }

    public final void r(String str) {
        evaluateJavascript(str, (ValueCallback) null);
    }

    public final void s(String str, String str2) {
        n("javascript:RE.setPlaceholder('" + str + "', '" + str2 + "');");
    }

    public final void setBackground(String str) {
        n("javascript:RE.setBackgroundImage('url(" + str + ")');");
    }

    public void setBackgroundColor(int i11) {
        super.setBackgroundColor(i11);
    }

    public void setBackgroundResource(int i11) {
        e eVar = e.f19136a;
        Bitmap a11 = eVar.a(getContext(), i11);
        if (a11 != null) {
            String b11 = eVar.b(a11);
            a11.recycle();
            n("javascript:RE.setBackgroundImage('url(data:image/png;base64," + b11 + ")');");
        }
    }

    public final void setEditorBackgroundColor(int i11) {
        setBackgroundColor(i11);
    }

    public final void setEditorFontColor(int i11) {
        String m11 = m(i11);
        n("javascript:RE.setBaseTextColor('" + m11 + "');");
    }

    public final void setEditorFontSize(int i11) {
        n("javascript:RE.setBaseFontSize('" + i11 + "px');");
    }

    public final void setEditorHeight(int i11) {
        n("javascript:RE.setHeight('" + i11 + "px');");
    }

    public final void setEditorWidth(int i11) {
        n("javascript:RE.setWidth('" + i11 + "px');");
    }

    public final void setFontSize(int i11) {
        if (i11 > 7 || i11 < 1) {
            Log.e("RichEditor", "Font size should have a value between 1-7");
        }
        n("javascript:RE.setFontSize('" + i11 + "');");
    }

    public final void setHeading(int i11) {
        n("javascript:RE.setHeading('" + i11 + "');");
    }

    public final void setHtml(String str) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            str = "";
        }
        try {
            n("javascript:RE.setHtml('" + URLEncoder.encode(str, "UTF-8") + "');");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        this.f17709g = str;
    }

    public final void setInputEnabled(boolean z11) {
        n("javascript:RE.setInputEnabled(" + z11 + ')');
    }

    public final void setOnDecorationChangeListener(c cVar) {
        this.f17711i = cVar;
    }

    public final void setOnInitialLoadListener(a aVar) {
        this.f17712j = aVar;
    }

    public final void setOnTextChangeListener(d dVar) {
        this.f17710h = dVar;
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        n("javascript:RE.setPadding('" + i11 + "px', '" + i12 + "px', '" + i13 + "px', '" + i14 + "px');");
    }

    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
        setPadding(i11, i12, i13, i14);
    }

    public final void setTextBackgroundColor(int i11) {
        n("javascript:RE.prepareInsert();");
        String m11 = m(i11);
        n("javascript:RE.setTextBackgroundColor('" + m11 + "');");
    }

    public final void setTextColor(int i11) {
        n("javascript:RE.prepareInsert();");
        String m11 = m(i11);
        n("javascript:RE.setTextColor('" + m11 + "');");
    }

    public final void u(String str) {
        String upperCase = new Regex(this.f17707e).replaceFirst(str, "").toUpperCase(Locale.ENGLISH);
        ArrayList arrayList = new ArrayList();
        for (Type type : Type.values()) {
            if (TextUtils.indexOf(upperCase, type.name()) != -1) {
                arrayList.add(type);
            }
        }
        c cVar = this.f17711i;
        if (cVar != null) {
            cVar.a(upperCase, arrayList);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RichEditor(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, attributeSet, (i12 & 4) != 0 ? 16842885 : i11);
    }

    public RichEditor(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17704b = context;
        this.f17705c = "file:///android_asset/editor.html";
        this.f17706d = "re-callback://";
        this.f17707e = "re-state://";
        this.f17713k = 200;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
        b bVar = new b();
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f17703m, this, this, bVar);
        WoodPeckerWebViewAspect.h().g(new ic.b(new Object[]{this, this, bVar, c11}).linkClosureAndJoinPoint(4112));
        loadUrl("file:///android_asset/editor.html");
        SensorsDataAutoTrackHelper.loadUrl2(this, "file:///android_asset/editor.html");
        k(getContext(), attributeSet);
    }

    public final class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            RichEditor richEditor = RichEditor.this;
            richEditor.f17708f = StringsKt__StringsJVMKt.w(str, richEditor.f17705c, true);
            a d11 = RichEditor.this.f17712j;
            if (d11 != null) {
                d11.a(RichEditor.this.f17708f);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String decode = Uri.decode(str);
            if (TextUtils.indexOf(str, RichEditor.this.f17706d) == 0) {
                RichEditor.this.l(decode);
                return true;
            } else if (TextUtils.indexOf(str, RichEditor.this.f17707e) != 0) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                RichEditor.this.u(decode);
                return true;
            }
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            String decode = Uri.decode(uri);
            if (TextUtils.indexOf(uri, RichEditor.this.f17706d) == 0) {
                RichEditor.this.l(decode);
                return true;
            } else if (TextUtils.indexOf(uri, RichEditor.this.f17707e) != 0) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            } else {
                RichEditor.this.u(decode);
                return true;
            }
        }
    }
}
