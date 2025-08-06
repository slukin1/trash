package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.ResizeLayout;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import cn.sharesdk.framework.utils.n;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;

public class WebAuthorizeActivity extends AbstractAuthorizeActivity implements Handler.Callback, ResizeLayout.OnResizeListener {
    public static final int MSG_AUTH_URL_GOT = 2;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private AuthorizeAdapter adapter;
    public AuthorizeListener listener;

    /* renamed from: rv  reason: collision with root package name */
    private RegisterView f13408rv;
    private WebView webView;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
            return null;
        }
    }

    public static class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        private float[] f13413a;

        private a() {
            this.f13413a = new float[]{0.0f, 0.02692683f, 0.053847015f, 0.080753915f, 0.10764089f, 0.13450131f, 0.16132854f, 0.18811597f, 0.21485697f, 0.24154496f, 0.26817337f, 0.2947356f, 0.3212251f, 0.34763536f, 0.37395984f, 0.40019205f, 0.42632553f, 0.4523538f, 0.47827047f, 0.50406915f, 0.52974343f, 0.555287f, 0.5806936f, 0.60595685f, 0.6310707f, 0.65602875f, 0.68082494f, 0.70545316f, 0.72990733f, 0.75418144f, 0.7782694f, 0.8021654f, 0.8258634f, 0.8493577f, 0.8726424f, 0.89571184f, 0.9185602f, 0.94118196f, 0.9635715f, 0.9857233f, 1.0076319f, 1.0292919f, 1.0506978f, 1.0718446f, 1.0927268f, 1.1133395f, 1.1336775f, 1.1537358f, 1.1735094f, 1.1929934f, 1.1893399f, 1.1728106f, 1.1565471f, 1.1405534f, 1.1248333f, 1.1093911f, 1.0942302f, 1.0793544f, 1.0647675f, 1.050473f, 1.0364745f, 1.0227754f, 1.0093791f, 0.99628896f, 0.9835081f, 0.9710398f, 0.958887f, 0.9470527f, 0.93553996f, 0.9243516f, 0.91349024f, 0.90295863f, 0.90482706f, 0.9114033f, 0.91775465f, 0.9238795f, 0.9297765f, 0.93544406f, 0.9408808f, 0.94608533f, 0.95105654f, 0.955793f, 0.9602937f, 0.9645574f, 0.96858317f, 0.9723699f, 0.97591674f, 0.97922283f, 0.9822872f, 0.9851093f, 0.98768836f, 0.9900237f, 0.9921147f, 0.993961f, 0.99556196f, 0.9969173f, 0.9980267f, 0.99888986f, 0.99950653f, 0.9998766f, 1.0f};
        }

        public float getInterpolation(float f11) {
            int i11 = (int) (f11 * 100.0f);
            if (i11 < 0) {
                i11 = 0;
            }
            if (i11 > 100) {
                i11 = 100;
            }
            return this.f13413a[i11];
        }
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("WebAuthorizeActivity.java", WebAuthorizeActivity.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 191);
    }

    private AuthorizeAdapter getAdapter() {
        try {
            ActivityInfo activityInfo = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 128);
            Bundle bundle = activityInfo.metaData;
            if (bundle != null) {
                if (!bundle.isEmpty()) {
                    String string = activityInfo.metaData.getString("AuthorizeAdapter");
                    if (string == null || string.length() <= 0) {
                        string = activityInfo.metaData.getString("Adapter");
                        if (string != null) {
                            if (string.length() <= 0) {
                            }
                        }
                    }
                    Object newInstance = Class.forName(string).newInstance();
                    if (!(newInstance instanceof AuthorizeAdapter)) {
                        return null;
                    }
                    return (AuthorizeAdapter) newInstance;
                }
            }
            return null;
        } catch (Throwable th2) {
            SSDKLog.b().b(th2);
            return null;
        }
    }

    public void OnResize(int i11, int i12, int i13, int i14) {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResize(i11, i12, i13, i14);
        }
    }

    public RegisterView getBodyView() {
        RegisterView registerView = new RegisterView(this.activity);
        registerView.a().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                new Thread() {
                    public void run() {
                        try {
                            new Instrumentation().sendKeyDownUpSync(4);
                        } catch (Throwable th2) {
                            SSDKLog.b().b(th2);
                            AuthorizeListener authorizeListener = WebAuthorizeActivity.this.helper.getAuthorizeListener();
                            if (authorizeListener != null) {
                                authorizeListener.onCancel();
                            }
                            WebAuthorizeActivity.this.finish();
                        }
                    }
                }.start();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        WebView b11 = registerView.b();
        this.webView = b11;
        WebSettings settings = b11.getSettings();
        settings.setBuiltInZoomControls(true);
        n.a(settings, true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setSavePassword(false);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        b authorizeWebviewClient = this.helper.getAuthorizeWebviewClient(this);
        String simpleName = authorizeWebviewClient != null ? authorizeWebviewClient.getClass().getSimpleName() : "";
        if ((!TextUtils.isEmpty(simpleName) && simpleName.equals("GooglePlusAuthorizeWebviewClient")) || ((!TextUtils.isEmpty(simpleName) && simpleName.contains("GooglePlus")) || simpleName.equals("YoutubeAuthorizeWebviewClient"))) {
            this.webView.getSettings().setUserAgentString(((("Mozilla/5.0 (Linux; Android 5.1; m2 note Build/LMY47D) " + "AppleWebKit/537.36 (KHTML, like Gecko) ") + "Version/4.0 ") + "Chrome/40.0.2214.127 ") + "Mobile Safari/537.36");
        }
        WebView webView2 = this.webView;
        WoodPeckerWebViewAspect.h().g(new AjcClosure1(new Object[]{this, webView2, authorizeWebviewClient, c.c(ajc$tjp_0, this, webView2, authorizeWebviewClient)}).linkClosureAndJoinPoint(4112));
        new Thread() {
            public void run() {
                try {
                    DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) {
                            String detailNetworkTypeForStatic = dHResponse.getDetailNetworkTypeForStatic();
                            Message message = new Message();
                            message.what = 2;
                            if ("none".equals(detailNetworkTypeForStatic)) {
                                message.arg1 = 1;
                                UIHandler.sendMessage(message, WebAuthorizeActivity.this);
                                return;
                            }
                            if (ShareSDK.isRemoveCookieOnAuthorize()) {
                                CookieSyncManager.createInstance(WebAuthorizeActivity.this.activity);
                                CookieManager.getInstance().removeAllCookie();
                            }
                            message.obj = WebAuthorizeActivity.this.helper.getAuthorizeUrl();
                            UIHandler.sendMessage(message, WebAuthorizeActivity.this);
                        }
                    });
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                }
            }
        }.start();
        return registerView;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        if (message.arg1 == 1) {
            AuthorizeListener authorizeListener = this.helper.getAuthorizeListener();
            if (authorizeListener == null) {
                return false;
            }
            authorizeListener.onError(new Throwable("Network error (platform: " + this.helper.getPlatform().getName() + ")"));
            return false;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            finish();
            AuthorizeListener authorizeListener2 = this.helper.getAuthorizeListener();
            if (authorizeListener2 == null) {
                return false;
            }
            authorizeListener2.onError(new Throwable("Authorize URL is empty (platform: " + this.helper.getPlatform().getName() + ")"));
            return false;
        }
        WebView webView2 = this.webView;
        webView2.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView2, str);
        return false;
    }

    public void onCreate() {
        if (this.f13408rv == null) {
            RegisterView bodyView = getBodyView();
            this.f13408rv = bodyView;
            bodyView.a(this);
            this.f13408rv.a(this.adapter.isNotitle());
            this.adapter.setBodyView(this.f13408rv.d());
            this.adapter.setWebView(this.f13408rv.b());
            TitleLayout c11 = this.f13408rv.c();
            this.adapter.setTitleView(c11);
            String name = this.helper.getPlatform().getName();
            this.adapter.setPlatformName(this.helper.getPlatform().getName());
            try {
                Context context = getContext();
                c11.getTvTitle().setText(ResHelper.getStringRes(context, "ssdk_" + name.toLowerCase()));
            } catch (Throwable unused) {
                SSDKLog.b().b(th);
            }
        }
        this.adapter.onCreate();
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null && !authorizeAdapter.isPopUpAnimationDisable()) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(550);
            scaleAnimation.setInterpolator(new a());
            this.f13408rv.setAnimation(scaleAnimation);
        }
        disableScreenCapture();
        i.a((View) this.f13408rv);
        this.activity.setContentView(this.f13408rv);
    }

    public void onDestroy() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onDestroy();
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setFocusable(false);
        }
    }

    public boolean onFinish() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            return authorizeAdapter.onFinish();
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.destroy();
            this.webView.removeAllViews();
        }
        Activity activity = this.activity;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeAllViews();
        }
        return super.onFinish();
    }

    public boolean onKeyEvent(int i11, KeyEvent keyEvent) {
        AuthorizeListener authorizeListener;
        AuthorizeAdapter authorizeAdapter = this.adapter;
        boolean onKeyEvent = authorizeAdapter != null ? authorizeAdapter.onKeyEvent(i11, keyEvent) : false;
        if (!onKeyEvent && i11 == 4 && keyEvent.getAction() == 0 && (authorizeListener = this.helper.getAuthorizeListener()) != null) {
            authorizeListener.onCancel();
        }
        if (onKeyEvent) {
            return true;
        }
        return super.onKeyEvent(i11, keyEvent);
    }

    public void onPause() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onPause();
        }
    }

    public void onRestart() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onRestart();
        }
    }

    public void onResume() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onResume();
        }
    }

    public void onStart() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStart();
        }
    }

    public void onStop() {
        AuthorizeAdapter authorizeAdapter = this.adapter;
        if (authorizeAdapter != null) {
            authorizeAdapter.onStop();
        }
    }

    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (this.adapter == null) {
            AuthorizeAdapter adapter2 = getAdapter();
            this.adapter = adapter2;
            if (adapter2 == null) {
                this.adapter = new AuthorizeAdapter();
            }
        }
        this.adapter.setActivity(activity);
    }

    public void setAuthorizeListener(AuthorizeListener authorizeListener) {
        this.listener = authorizeListener;
    }
}
