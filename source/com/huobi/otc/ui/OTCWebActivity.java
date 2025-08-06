package com.huobi.otc.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.otc.callback.OTCJavascriptCallBack;
import com.huobi.otc.helper.OtcLoginHelper;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.l;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import sp.t;
import sp.u;
import sp.v;
import sp.w;

public class OTCWebActivity extends EmptyMVPActivity {

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f79256l = null;

    /* renamed from: b  reason: collision with root package name */
    public WebView f79257b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f79258c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79259d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79260e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79261f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f79262g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f79263h;

    /* renamed from: i  reason: collision with root package name */
    public String f79264i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79265j;

    /* renamed from: k  reason: collision with root package name */
    public e f79266k;

    public class a extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f79268c;

        public a(String str, Map map) {
            this.f79267b = str;
            this.f79268c = map;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            OtcModuleConfig.a().e(str);
            WebView fg2 = OTCWebActivity.this.f79257b;
            String str2 = this.f79267b;
            Map map = this.f79268c;
            fg2.loadUrl(str2, map);
            SensorsDataAutoTrackHelper.loadUrl2(fg2, str2, map);
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OTCWebActivity.this.f79258c.setVisibility(8);
            if (OTCWebActivity.this.f79265j) {
                return;
            }
            if (OTCWebActivity.this.f79257b.canGoBack()) {
                OTCWebActivity.this.f79260e.setVisibility(0);
            } else {
                OTCWebActivity.this.f79260e.setVisibility(8);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OTCWebActivity.this.f79258c.setVisibility(0);
        }
    }

    public class c extends WebChromeClient {

        public class a implements ValueCallback<Uri> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ValueCallback f79272a;

            public a(ValueCallback valueCallback) {
                this.f79272a = valueCallback;
            }

            /* renamed from: a */
            public void onReceiveValue(Uri uri) {
                this.f79272a.onReceiveValue(uri != null ? new Uri[]{uri} : null);
            }
        }

        public c() {
        }

        public void a(ValueCallback<Uri> valueCallback, String str, String str2) {
            OTCWebActivity oTCWebActivity = OTCWebActivity.this;
            e unused = oTCWebActivity.f79266k = new e(new d());
            OTCWebActivity.this.f79266k.h(valueCallback, str, str2);
        }

        public void onProgressChanged(WebView webView, int i11) {
            super.onProgressChanged(webView, i11);
            OTCWebActivity.this.f79258c.setProgress(i11);
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(OTCWebActivity.this.f79264i)) {
                OTCWebActivity oTCWebActivity = OTCWebActivity.this;
                oTCWebActivity.f79261f.setText(oTCWebActivity.f79264i);
                return;
            }
            OTCWebActivity.this.f79261f.setText(webView.getTitle());
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            String str = "";
            for (int i11 = 0; i11 < acceptTypes.length; i11++) {
                if (!(acceptTypes[i11] == null || acceptTypes[i11].length() == 0)) {
                    str = str + acceptTypes[i11] + ";";
                }
            }
            if (str.length() == 0) {
                str = "*/*";
            }
            a(new a(valueCallback), str, "filesystem");
            return true;
        }
    }

    public class d {
        public d() {
        }

        public Activity a() {
            return OTCWebActivity.this;
        }
    }

    public class e {

        /* renamed from: a  reason: collision with root package name */
        public ValueCallback<Uri> f79275a;

        /* renamed from: b  reason: collision with root package name */
        public String f79276b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f79277c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f79278d;

        /* renamed from: e  reason: collision with root package name */
        public d f79279e;

        public e(d dVar) {
            this.f79279e = dVar;
        }

        public final Intent a() {
            return new Intent("android.media.action.VIDEO_CAPTURE");
        }

        public final Intent b() {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalStoragePublicDirectory.getAbsolutePath());
            String str = File.separator;
            sb2.append(str);
            sb2.append("browser-photos");
            File file = new File(sb2.toString());
            file.mkdirs();
            this.f79276b = file.getAbsolutePath() + str + System.currentTimeMillis() + PictureMimeType.JPG;
            intent.putExtra("output", Uri.fromFile(new File(this.f79276b)));
            return intent;
        }

        public final Intent c(Intent... intentArr) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", "Choose file for upload");
            return intent;
        }

        public final Intent d() {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent c11 = c(b(), a(), f());
            c11.putExtra("android.intent.extra.INTENT", intent);
            return c11;
        }

        public final Intent e(String str) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            return intent;
        }

        public final Intent f() {
            return new Intent("android.provider.MediaStore.RECORD_SOUND");
        }

        public void g(int i11, Intent intent) {
            if (i11 != 0 || !this.f79278d) {
                Uri data = (intent == null || i11 != -1) ? null : intent.getData();
                if (data == null && intent == null && i11 == -1) {
                    File file = new File(this.f79276b);
                    if (file.exists()) {
                        data = Uri.fromFile(file);
                        this.f79279e.a().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", data));
                    }
                }
                this.f79275a.onReceiveValue(data);
                this.f79277c = true;
                this.f79278d = false;
                return;
            }
            this.f79278d = false;
        }

        public void h(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (this.f79275a == null) {
                this.f79275a = valueCallback;
                String[] split = str.split(";");
                String str3 = split[0];
                String str4 = str2.length() > 0 ? str2 : "filesystem";
                if (str2.equals("filesystem")) {
                    for (String split2 : split) {
                        String[] split3 = split2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split3.length == 2 && OptionsBridge.CAPTURE_KEY.equals(split3[0])) {
                            str4 = split3[1];
                        }
                    }
                }
                this.f79276b = null;
                if (str3.equals(SelectMimeType.SYSTEM_IMAGE)) {
                    if (str4.equals(OptionsBridge.CAMERA_KEY)) {
                        i(b());
                        return;
                    }
                    Intent c11 = c(b());
                    c11.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_IMAGE));
                    i(c11);
                } else if (str3.equals(SelectMimeType.SYSTEM_VIDEO)) {
                    if (str4.equals("camcorder")) {
                        i(a());
                        return;
                    }
                    Intent c12 = c(a());
                    c12.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_VIDEO));
                    i(c12);
                } else if (!str3.equals(SelectMimeType.SYSTEM_AUDIO)) {
                    i(d());
                } else if (str4.equals("microphone")) {
                    i(f());
                } else {
                    Intent c13 = c(f());
                    c13.putExtra("android.intent.extra.INTENT", e(SelectMimeType.SYSTEM_AUDIO));
                    i(c13);
                }
            }
        }

        public final void i(Intent intent) {
            try {
                this.f79279e.a().startActivityForResult(intent, 4);
            } catch (ActivityNotFoundException unused) {
                try {
                    this.f79278d = true;
                    this.f79279e.a().startActivityForResult(d(), 4);
                } catch (ActivityNotFoundException unused2) {
                }
            }
        }
    }

    static {
        ajc$preClinit();
    }

    public static /* synthetic */ void ajc$preClinit() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("OTCWebActivity.java", OTCWebActivity.class);
        f79256l = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 205);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        if (this.f79257b.canGoBack()) {
            this.f79257b.goBack();
        } else {
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void th(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ String uh(Throwable th2) {
        return null;
    }

    public int getContentView() {
        return R$layout.acticity_otc_web;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        e eVar;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 4 && (eVar = this.f79266k) != null) {
            eVar.g(i12, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @SuppressLint({"SetJavaScriptEnabled", "WrongViewCast"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i11 = Build.VERSION.SDK_INT;
        if ((i11 >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) || ContextCompat.checkSelfPermission(this, PermissionConfig.READ_MEDIA_VIDEO) != 0 || ContextCompat.checkSelfPermission(this, PermissionConfig.READ_MEDIA_AUDIO) != 0 || ContextCompat.checkSelfPermission(this, PermissionConfig.READ_MEDIA_IMAGES) != 0) {
            ActivityCompat.requestPermissions(this, new String[]{PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_AUDIO, PermissionConfig.READ_MEDIA_IMAGES}, 1);
        } else if (i11 >= 23 && !(ContextCompat.checkSelfPermission(this, PermissionConfig.WRITE_EXTERNAL_STORAGE) == 0 && ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0)) {
            ActivityCompat.requestPermissions(this, new String[]{PermissionConfig.WRITE_EXTERNAL_STORAGE, "android.permission.CAMERA"}, 1);
        }
        this.f79265j = getIntent().getBooleanExtra("closeVisiablity", false);
        this.f79257b = (WebView) findViewById(R$id.wv_otc);
        this.f79258c = (ProgressBar) findViewById(R$id.pb_web_progress);
        ph();
        rh();
        qh();
        this.f79257b.removeJavascriptInterface("huobiNative");
        this.f79257b.addJavascriptInterface(new OTCJavascriptCallBack(), "huobiNative");
        if (getIntent().getBooleanExtra("newUserAgent", true)) {
            this.f79257b.getSettings().setUserAgentString(l.f());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        String stringExtra = getIntent().getStringExtra("url");
        this.f79264i = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "https://l10n-otc-www.huobi.cn";
        }
        String w11 = StringUtils.w(stringExtra);
        if (TextUtils.isEmpty(OtcModuleConfig.a().c())) {
            OtcLoginHelper.g().onErrorReturn(v.f26099b).compose(RxJavaHelper.t(getUI())).subscribe(new a(w11, hashMap));
            return;
        }
        WebView webView = this.f79257b;
        webView.loadUrl(w11, hashMap);
        SensorsDataAutoTrackHelper.loadUrl2(webView, w11, hashMap);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.f79257b.canGoBack()) {
            this.f79257b.goBack();
            return true;
        }
        finish();
        return true;
    }

    public void ph() {
        this.f79262g = (LinearLayout) this.viewFinder.b(R$id.head_left_layout);
        this.f79259d = (TextView) this.viewFinder.b(R$id.head_left_tv);
        TextView textView = (TextView) this.viewFinder.b(R$id.head_close_tv);
        this.f79260e = textView;
        if (this.f79265j) {
            textView.setVisibility(0);
            this.f79259d.setVisibility(8);
        } else {
            textView.setVisibility(8);
            this.f79259d.setVisibility(0);
        }
        this.f79261f = (TextView) this.viewFinder.b(R$id.head_title_mid);
        this.f79263h = (LinearLayout) this.viewFinder.b(R$id.otc_web_ll);
        this.f79262g.setOnClickListener(new t(this));
        this.f79260e.setOnClickListener(new u(this));
    }

    public final void qh() {
        WebView webView = this.f79257b;
        b bVar = new b();
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(f79256l, this, webView, bVar);
        WoodPeckerWebViewAspect.h().g(new w(new Object[]{this, webView, bVar, c11}).linkClosureAndJoinPoint(4112));
        this.f79257b.setWebChromeClient(new c());
    }

    public final void rh() {
        WebSettings settings = this.f79257b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSaveFormData(false);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setDomStorageEnabled(true);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (i11 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i11 >= 21) {
            settings.setMixedContentMode(0);
            this.f79257b.setLayerType(2, (Paint) null);
        } else if (i11 >= 19) {
            this.f79257b.setLayerType(2, (Paint) null);
        } else if (i11 < 19) {
            this.f79257b.setLayerType(1, (Paint) null);
        }
    }
}
