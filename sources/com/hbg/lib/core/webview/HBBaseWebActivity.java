package com.hbg.lib.core.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.annotation.Keep;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SensorUtil;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$drawable;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.DokitJsActionHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.HBWebViewOfflineEvent;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.core.webview.bean.WebViewLoadFailedEvent;
import com.hbg.lib.core.webview.trace.StepType;
import com.hbg.lib.core.webview.trace.WebviewTracer;
import com.hbg.lib.core.webview.util.MetaUtils;
import com.hbg.lib.iplayer.common.mediaplayer.PlayStatus;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.retrofit.H5Retrofit;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.store.AppConfigManager;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.webcache.WebCacheInterecptRequest;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.aspectj.lang.JoinPoint;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import v6.r;
import v6.s;
import v6.t;
import v6.u;
import v6.v;
import v6.w;

@Route(path = "/webView/index")
public class HBBaseWebActivity extends EmptyMVPActivity implements u, View.OnClickListener, EasyPermissions.PermissionCallbacks, HBWebView.e {
    private static String ACTIONBAR_SHARE_JS_STR = "javascript:window.execAction( { \"action\": \"actionbarShare\" } )";
    public static final String ACTION_NATIVE_LOGIN_CHECK = "native_20010013";
    public static final String ACTION_NOTIFY_INTERCEPTED = "20010101callback";
    public static final String APP_BAR_THEME = "X-APP-Bar-Theme";
    public static final String APP_BAR_THEME_0 = "0";
    public static final String APP_BAR_THEME_1 = "1";
    public static final String APP_BAR_THEME_2 = "2";
    public static final String APP_BAR_THEME_3 = "3";
    public static final String APP_BAR_THEME_4 = "4";
    public static final String ASK_URL_KEY = "ask_url";
    private static final int CODE_OK = 200;
    public static final String HIDEBACKBTN_TAG = "hideBackBtn";
    public static final String HIDECLOSE_TAG = "hideMainBtn";
    public static final String HIDENAV_TAG = "hideNav";
    public static final String HIDETOPBAR_TAG = "hideTopBar";
    private static final int INIT_LOADING_TIMEOUT = 25000;
    public static final String JS_CALLBACK_NAME = "huobiNative";
    public static final int JS_CLOSE_WEB_VIEW = 1001;
    private static final String PAGE_SHOW = "javascript:window.execAction( { \"action\": \"pageShow\" } )";
    private static final String PULL_TO_REFRESH_TYPE_JS = "1";
    private static final String PULL_TO_REFRESH_TYPE_NATIVE = "2";
    private static final String PULL_TO_REFRESH_TYPE_NONE = "0";
    public static final String REFRESH_COLOR_TAG = "color";
    private static final String REFRESH_DATA_JS_STR = "javascript:window.execAction( { \"action\": \"refreshData\" } )";
    private static final String REFRESH_JS_STR = "javascript:window.execAction( { \"action\": \"refresh\" } )";
    public static final String REFRESH_TAG = "refresh";
    public static final String SHARE_CALLBACK_KEY = "share_callback";
    public static final String SHARE_TAG = "showShareBtn";
    public static final String SHOWBACKBTN_TAG = "showBackBtn";
    public static final String SHOWCLOSE_TAG = "showMainBtn";
    public static final String SHOWTOPBAR_TAG = "showTopBar";
    public static final String TAG = "HBBaseWebActivity, HBWebViewPool";
    private static final int TOP_BAR_SCROLL_HEIGHT = PixelUtils.a(30.0f);
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    /* access modifiers changed from: private */
    public AlertInfo alertInfo;
    private String askUrl;
    private int backgroundColor;
    private boolean canShare = false;
    /* access modifiers changed from: private */
    public String currentPath;
    public View divider;
    /* access modifiers changed from: private */
    public FrameLayout flVideo;
    public ImageView fontIconTextViewRightOne;
    public ImageView fontIconTextViewRightOneScroll;
    public ImageView fontIconTextViewRightTwo;
    public ImageView fontIconTextViewRightTwoScroll;
    private boolean forceLoginSuccess;
    private int fromCode = -1;
    /* access modifiers changed from: private */
    public boolean hasError = false;
    /* access modifiers changed from: private */
    public boolean htmlLoadFinish = false;
    private String interceptCallback = ACTION_NOTIFY_INTERCEPTED;
    private int interceptSecond = 10;
    private boolean isBackRefresh;
    private boolean isHideBackBtn = false;
    private boolean isHideCloseBtn = false;
    private boolean isHideNav = false;
    private boolean isHideTopBar = false;
    public boolean isInitLoading;
    private boolean isLift = false;
    private boolean isRefreshDataActionSended = false;
    private boolean isUploadPageShow = false;
    private boolean isUserPaused;
    public ImageView ivQuestion;
    public ImageView ivQuestionScroll;
    /* access modifiers changed from: private */
    public v jumioLauncherResultListener;
    private float lastTopBarAlpha;
    private int lineColor;
    /* access modifiers changed from: private */
    public ng.b localService;
    public ImageView mActionBarShare;
    public ImageView mActionBarShareScroll;
    private k7.c mAudioPlayController;
    public ImageView mBackBtn;
    public ImageView mBackBtnScroll;
    public w6.b mChromeClient;
    public ImageView mCloseBtn;
    public ImageView mCloseBtnScroll;
    private int mCurrentVolume;
    public boolean mIsAuth = false;
    public boolean mIsHomeFunction = false;
    public boolean mIsReCreate = false;
    private x6.d mJumioHelpCallback;
    /* access modifiers changed from: private */
    public RelativeLayout mLlRootLayout;
    public LoadingLayout mLoadingLayout;
    /* access modifiers changed from: private */
    public String mOriginUrl;
    private x6.f mPermissionHelpCallback;
    private ProgressBar mProcessBar;
    private SmartRefreshHeader mRefreshHeader;
    private String mSaveImgBase64String;
    public String mTitleBack;
    public String mTitleText;
    public TextView mTitleTv;
    public TextView mTitleTvScroll;
    /* access modifiers changed from: private */
    public WebviewTracer mTracer;
    public String mUrl;
    public HBWebView mWebView;
    /* access modifiers changed from: private */
    public boolean needIntercept = false;
    private boolean needLogin;
    private JsMessage needLoginJsMessage;
    /* access modifiers changed from: private */
    public String pathMD5;
    public View promptCloseBtn;
    public LinearLayout promptLayout;
    private TextView promptText;
    /* access modifiers changed from: private */
    public String pullToRefreshType = "0";
    private int refreshBgColor;
    private String refreshBgColorString;
    public SmartRefreshLayout refreshLayout;
    private Runnable reloadMeta = new j();
    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new h());
    private Runnable runnable = new f();
    private String shareCallbackKey;
    private Runnable timeoutLoadingCallback = new i();
    private int titleColor;
    public View topBar;
    private boolean topBarForceShow = false;
    public View topBarScroll;
    @Keep
    private String topbarTheme = "0";
    private t viewLifecycleCallback;
    /* access modifiers changed from: private */
    public View xCustomView = null;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback xCustomViewCallback = null;

    public static class NotifyWebInterceptBean implements Serializable {
        private static final long serialVersionUID = -676069497261640983L;
        public int operateType = -1;

        public NotifyWebInterceptBean(int i11) {
            this.operateType = i11;
        }
    }

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68778b;

        public a(String str) {
            this.f68778b = str;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            WebView webView = HBBaseWebActivity.this.getWebView();
            String str = this.f68778b;
            webView.loadUrl(str);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements DialogUtils.b.f {
        public b() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
        }
    }

    public class c implements DialogUtils.b.f {
        public c() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            HBBaseWebActivity.super.finish();
        }
    }

    public class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68782a;

        public d(String str) {
            this.f68782a = str;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            HBBaseWebActivity.this.saveImg(this.f68782a);
            return true;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            HBBaseWebActivity.this.tryShowShareIcon();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
            hBBaseWebActivity.refreshLayout.removeView(hBBaseWebActivity.mWebView);
            boolean unused = HBBaseWebActivity.this.needIntercept = false;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            HBBaseWebActivity.this.doNotifyFinish();
        }
    }

    public class h implements ActivityResultCallback<ActivityResult> {
        public h() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            if (HBBaseWebActivity.this.jumioLauncherResultListener != null) {
                HBBaseWebActivity.this.jumioLauncherResultListener.launcherResult(activityResult);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
            if (hBBaseWebActivity.isInitLoading) {
                hBBaseWebActivity.mLoadingLayout.k();
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            HBBaseWebActivity.this.readTopBarThemeConfig();
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.this.promptLayout.setVisibility(8);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class l implements ny.c {
        public l() {
        }

        public void bf(ky.j jVar) {
            if ("1".equals(HBBaseWebActivity.this.pullToRefreshType)) {
                WebView webView = HBBaseWebActivity.this.getWebView();
                webView.loadUrl(HBBaseWebActivity.REFRESH_JS_STR);
                SensorsDataAutoTrackHelper.loadUrl2(webView, HBBaseWebActivity.REFRESH_JS_STR);
            } else if ("2".equals(HBBaseWebActivity.this.pullToRefreshType)) {
                HBBaseWebActivity.this.getWebView().clearCache(true);
                HBBaseWebActivity.this.getWebView().reload();
            }
        }
    }

    public class m extends SimpleMultiPurposeListener {
        public m() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            HBBaseWebActivity.this.topBar.setAlpha(1.0f);
        }

        public void A7(ky.g gVar, float f11, int i11, int i12, int i13) {
            if (HBBaseWebActivity.this.isCustomTopBarTheme()) {
                HBBaseWebActivity.this.topBar.setAlpha(0.0f);
            }
        }

        public void T9(ky.g gVar, int i11, int i12) {
            i6.d.b("refreshLayout onHeaderReleased = " + HBBaseWebActivity.this.refreshLayout.getState());
            if (HBBaseWebActivity.this.isCustomTopBarTheme() && HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.None) {
                HBBaseWebActivity.this.topBar.setAlpha(1.0f);
            }
        }

        public void U5(ky.g gVar, float f11, int i11, int i12, int i13) {
            i6.d.b("refreshLayout onHeaderReleasing = " + HBBaseWebActivity.this.refreshLayout.getState());
            if (!HBBaseWebActivity.this.isCustomTopBarTheme()) {
                return;
            }
            if (HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.PullDownCanceled || HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.None || HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.PullDownToRefresh || HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.ReleaseToRefresh || HBBaseWebActivity.this.refreshLayout.getState() == RefreshState.ReleaseToTwoLevel) {
                HBBaseWebActivity.this.topBar.setAlpha(1.0f);
            }
        }

        public void ba(ky.g gVar, boolean z11) {
            if (HBBaseWebActivity.this.isCustomTopBarTheme()) {
                HBBaseWebActivity.this.topBar.postDelayed(new r(this), 500);
            }
        }
    }

    public class n implements ng.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68793a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Uri f68794b;

        public n(String str, Uri uri) {
            this.f68793a = str;
            this.f68794b = uri;
        }

        public InputStream a(String str) {
            e6.j.s().j();
            String q11 = e6.j.s().q();
            if (!TextUtils.isEmpty(q11)) {
                try {
                    return new FileInputStream(q11 + File.separator + HBBaseWebActivity.this.pathMD5 + str);
                } catch (FileNotFoundException e11) {
                    e11.printStackTrace();
                }
            }
            try {
                AssetManager assets = HBBaseWebActivity.this.getBaseContext().getAssets();
                return assets.open(this.f68793a + str);
            } catch (IOException e12) {
                e12.printStackTrace();
                return null;
            }
        }

        public NanoHTTPD.Response b(NanoHTTPD.j jVar) {
            Request.Builder builder;
            RequestBody requestBody;
            try {
                OkHttpClient okHttpClient = HbgRetrofit.d().getOkHttpClient();
                NanoHTTPD.Method a11 = jVar.a();
                String uri = jVar.getUri();
                if (TextUtils.isEmpty(uri)) {
                    return null;
                }
                Map<String, String> headers = jVar.getHeaders();
                Uri.Builder buildUpon = Uri.parse(HbgRetrofit.d().getHost()).buildUpon();
                buildUpon.path(uri).encodedQuery(jVar.d());
                Uri build = buildUpon.build();
                if (a11 == NanoHTTPD.Method.GET) {
                    builder = new Request.Builder().url(build.toString());
                    builder.get().build();
                } else if (a11 == NanoHTTPD.Method.POST) {
                    Request.Builder url = new Request.Builder().url(build.toString());
                    HashMap hashMap = new HashMap();
                    jVar.c(hashMap);
                    String str = headers.get("content-type");
                    if (str == null) {
                        str = "";
                    }
                    if (hashMap.isEmpty()) {
                        requestBody = RequestBody.create(MediaType.parse(str), "");
                    } else if ("multipart/form-data".equalsIgnoreCase(str)) {
                        requestBody = RequestBody.create(MediaType.parse(str), hashMap.toString());
                    } else if ("application/x-www-form-urlencoded".equalsIgnoreCase(str)) {
                        requestBody = RequestBody.create(MediaType.parse(str), (String) hashMap.keySet().toArray()[0]);
                    } else {
                        requestBody = RequestBody.create(MediaType.parse(str), (String) hashMap.values().toArray()[0]);
                    }
                    url.post(requestBody);
                    builder = url;
                } else {
                    builder = null;
                }
                if (headers != null) {
                    headers.remove("http-client-ip");
                    headers.remove("remote-addr");
                    headers.remove(VulcanInfo.HOST);
                    headers.put("origin", this.f68794b.buildUpon().path("").clearQuery().build().toString());
                    builder.headers(Headers.of(headers));
                }
                Response execute = okHttpClient.newCall(builder.build()).execute();
                return NanoHTTPD.r(NanoHTTPD.Response.Status.lookup(execute.code()), execute.header(""), execute.body().byteStream(), execute.body().contentLength());
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }

        public String c() {
            return HBBaseWebActivity.this.currentPath;
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (HBBaseWebActivity.this.needIntercept) {
                HBBaseWebActivity.this.notifyWebUserFinish(1);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            w.e().g(HBBaseWebActivity.this, "holigeit://open/v1?url=ihuobiglobal://m.hbg.com/home/index");
            HBBaseWebActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class q extends w6.b {
        public q(u uVar) {
            super(uVar);
        }

        public void onHideCustomView() {
            if (HBBaseWebActivity.this.xCustomView != null) {
                HBBaseWebActivity.this.xCustomView.setVisibility(8);
                HBBaseWebActivity.this.flVideo.removeView(HBBaseWebActivity.this.xCustomView);
                View unused = HBBaseWebActivity.this.xCustomView = null;
                HBBaseWebActivity.this.flVideo.setVisibility(8);
                if (HBBaseWebActivity.this.xCustomViewCallback != null) {
                    HBBaseWebActivity.this.xCustomViewCallback.onCustomViewHidden();
                }
                HBBaseWebActivity.this.mLlRootLayout.setVisibility(0);
                super.onHideCustomView();
                HBBaseWebActivity.this.onFullscreenEventChanged(false);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            HBBaseWebActivity.this.mLlRootLayout.setVisibility(4);
            if (HBBaseWebActivity.this.xCustomView != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            HBBaseWebActivity.this.flVideo.addView(view);
            View unused = HBBaseWebActivity.this.xCustomView = view;
            WebChromeClient.CustomViewCallback unused2 = HBBaseWebActivity.this.xCustomViewCallback = customViewCallback;
            HBBaseWebActivity.this.flVideo.setVisibility(0);
            HBBaseWebActivity.this.onFullscreenEventChanged(true);
        }
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("HBBaseWebActivity.java", HBBaseWebActivity.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 1338);
    }

    private void changeToTheme1() {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "changeToTheme1() called");
        }
        setTopBarTransparent();
        this.mTitleTv.setVisibility(0);
        this.mTitleTv.setTextColor(getResources().getColor(R$color.webview_title_color_new));
        this.mBackBtn.setImageResource(R$drawable.icon_back_product_black_new);
        this.ivQuestion.setImageResource(R$drawable.icon_rule_product_black_normal);
        this.mActionBarShare.setImageResource(R$drawable.icon_share_product_black_new);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_product_black_new);
        SmartRefreshHeader smartRefreshHeader = this.mRefreshHeader;
        if (smartRefreshHeader != null) {
            smartRefreshHeader.setBackgroundColor(getResources().getColor(R$color.color_F7F7FB));
        }
        tryShowAskIcon();
        tryShowShareIcon();
        this.topBar.setAlpha(1.0f);
        this.topBarScroll.setAlpha(0.0f);
    }

    private void changeToTheme2() {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "changeToTheme2() called");
        }
        setTopBarTransparent();
        this.mTitleTv.setVisibility(8);
        this.mTitleTv.setTextColor(getResources().getColor(R$color.webview_title_color_new));
        this.mBackBtn.setImageResource(R$drawable.icon_back_activity_white_normal);
        this.ivQuestion.setImageResource(R$drawable.icon_rule_activity_white_normal);
        this.mActionBarShare.setImageResource(R$drawable.icon_share_activity_white_normal);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_activity_white_normal);
        if (this.mRefreshHeader != null && TextUtils.isEmpty(this.refreshBgColorString)) {
            this.mRefreshHeader.setBackgroundColor(getResources().getColor(R$color.color_FFFFFF));
        }
        tryShowAskIcon();
        tryShowShareIcon();
        this.topBar.setAlpha(1.0f);
        this.topBarScroll.setAlpha(0.0f);
    }

    private void changeToTheme3() {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "changeToTheme3() called");
        }
        int color = getResources().getColor(R$color.color_14181F);
        this.mTitleTv.setTextColor(color);
        this.mBackBtn.setImageResource(R$drawable.icon_back_product_black_normal);
        this.mBackBtn.setColorFilter(color);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_product_black_normal);
        this.mCloseBtn.setColorFilter(color);
        this.ivQuestion.setImageResource(R$drawable.icon_rule_product_black_normal);
        this.ivQuestion.setColorFilter(color);
        this.mActionBarShare.setImageResource(R$drawable.icon_share_product_black_normal);
        this.mActionBarShare.setColorFilter(color);
        ViewUtil.m(this.ivQuestion, false);
        ViewUtil.m(this.divider, false);
        this.divider.setBackgroundColor(getResources().getColor(R$color.color_E7EBEE));
        View view = this.topBar;
        Resources resources = getResources();
        int i11 = R$color.color_FFFFFF;
        view.setBackgroundColor(resources.getColor(i11));
        if (this.mRefreshHeader != null && TextUtils.isEmpty(this.refreshBgColorString)) {
            this.mRefreshHeader.setBackgroundColor(getResources().getColor(i11));
        }
        tryShowAskIcon();
        tryShowShareIcon();
    }

    private void changeToTheme4() {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "changeToTheme4() called");
        }
        int color = getResources().getColor(R$color.color_14181F);
        int color2 = getResources().getColor(R$color.color_CFD3E9);
        setTopBarTransparent();
        this.mTitleTv.setVisibility(8);
        this.mTitleTv.setTextColor(getResources().getColor(R$color.webview_title_color_new));
        this.mBackBtn.setImageResource(R$drawable.icon_back_product_black_normal);
        this.ivQuestion.setImageResource(R$drawable.icon_rule_product_black_normal);
        this.mActionBarShare.setImageResource(R$drawable.icon_share_product_black_normal);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_product_black_normal);
        if (this.mRefreshHeader != null && TextUtils.isEmpty(this.refreshBgColorString)) {
            this.mRefreshHeader.setBackgroundColor(getResources().getColor(R$color.color_FFFFFF));
        }
        this.mTitleTv.setTextColor(color2);
        this.mTitleTvScroll.setTextColor(color);
        this.mBackBtn.setColorFilter(color2);
        this.mBackBtnScroll.setColorFilter(color);
        this.ivQuestion.setColorFilter(color2);
        this.ivQuestionScroll.setColorFilter(color);
        this.mActionBarShare.setColorFilter(color2);
        this.mActionBarShareScroll.setColorFilter(color);
        this.mCloseBtn.setColorFilter(color2);
        this.mCloseBtnScroll.setColorFilter(color);
        this.fontIconTextViewRightOne.setColorFilter(color2);
        this.fontIconTextViewRightOneScroll.setColorFilter(color);
        this.fontIconTextViewRightTwo.setColorFilter(color2);
        this.fontIconTextViewRightTwoScroll.setColorFilter(color);
        this.topBarScroll.setBackgroundResource(R$color.color_FFFFFF);
        tryShowAskIcon();
        tryShowShareIcon();
    }

    private void changeToThemeDefault() {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "changeToThemeDefault() called");
        }
        this.topBarScroll.setAlpha(0.0f);
        this.mTitleTv.setVisibility(0);
        int i11 = this.backgroundColor;
        if (i11 > 0) {
            this.topBar.setBackgroundColor(i11);
            this.mTitleTv.setTextColor(this.backgroundColor);
        } else {
            this.topBar.setBackgroundResource(R$color.baseColorContentBackground);
            this.mTitleTv.setTextColor(getResources().getColor(R$color.webview_title_color));
        }
        this.mBackBtn.setImageResource(R$drawable.icon_back_product_black_normal);
        this.ivQuestion.setImageResource(R$drawable.pro_icon_question);
        this.mActionBarShare.setImageResource(R$drawable.icon_share_product_black_normal);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_product_black_normal);
        SmartRefreshHeader smartRefreshHeader = this.mRefreshHeader;
        if (smartRefreshHeader != null) {
            smartRefreshHeader.setBackgroundColor(getResources().getColor(R$color.color_F7F7FB));
        }
        tryShowAskIcon();
        tryShowShareIcon();
    }

    public static Intent createIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, HBBaseWebActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        return intent;
    }

    /* access modifiers changed from: private */
    public void doNotifyFinish() {
        if (this.fromCode != 1) {
            onBackPressed();
            return;
        }
        w.e().g(this, "holigeit://open/v1?url=ihuobiglobal://m.hbg.com/home/index");
        finish();
    }

    private void doShare() {
        onShareClick();
        if (!TextUtils.isEmpty(this.shareCallbackKey)) {
            JsMessage jsMessage = new JsMessage();
            jsMessage.setCode(200);
            jsMessage.setData(null);
            jsMessage.setAction(this.shareCallbackKey);
            x6.b.d(jsMessage, this);
            return;
        }
        HBWebView hBWebView = this.mWebView;
        String str = ACTIONBAR_SHARE_JS_STR;
        hBWebView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(hBWebView, str);
    }

    public static Intent getDAppWebViewIntent(Context context, String str, String str2, String str3, boolean z11) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return null;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return null;
        }
        Intent intent = new Intent(context, HBBaseWebActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("isauth", z11);
        intent.putExtra("chainType", str3);
        intent.putExtra("isdapp", true);
        return intent;
    }

    public static Intent getWebViewIntent(Context context, String str, String str2, String str3, boolean z11) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return null;
        }
        if (NetworkStatus.c(context)) {
            return getWebViewIntentNoClear(context, str, str2, str3, z11);
        }
        HuobiToastUtil.k(context, R$string.string_network_disconnect);
        return null;
    }

    public static Intent getWebViewIntentNoClear(Context context, String str, String str2, String str3, boolean z11) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return null;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return null;
        }
        Intent intent = new Intent(context, HBBaseWebActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("title_back", str3);
        intent.putExtra("isauth", z11);
        return intent;
    }

    private String handleLocalService(String str) {
        if (TextUtils.isEmpty(str) || !BaseModuleConfig.a().e0()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        this.currentPath = path;
        String replaceFirst = path.replaceFirst(m6.a.h(), "/");
        Pair<Boolean, String> X = BaseModuleConfig.a().X(replaceFirst);
        if (!((Boolean) X.first).booleanValue()) {
            return str;
        }
        String str2 = (String) X.second;
        this.pathMD5 = str2;
        if (TextUtils.isEmpty(str2)) {
            this.pathMD5 = MD5Utils.a(replaceFirst);
        }
        try {
            String str3 = e6.j.s().r() + this.pathMD5;
            String[] list = getBaseContext().getAssets().list(str3);
            if (list != null) {
                if (list.length != 0) {
                    ng.b bVar = new ng.b(8080, new n(str3, parse));
                    this.localService = bVar;
                    bVar.c();
                    int a11 = this.localService.a();
                    if (a11 == -1) {
                        i6.k.f("LocalService", "LocalService start exception!");
                        return str;
                    }
                    String str4 = "http://localhost:" + a11;
                    String replaceFirst2 = str.replaceFirst(parse.buildUpon().path("").clearQuery().toString(), str4);
                    syncCookie(str, str4);
                    return replaceFirst2;
                }
            }
            return str;
        } catch (Throwable th2) {
            i6.k.g("LocalService", "handleLocalService exception!", th2);
            return str;
        }
    }

    private void hideCustomView() {
        w6.b bVar = this.mChromeClient;
        if (bVar != null) {
            bVar.onHideCustomView();
        }
    }

    private void hideNav() {
        hideStatusBar();
        this.topBar.setBackgroundColor(0);
        this.mBackBtn.setImageResource(R$drawable.icon_back_activity_white_normal);
        this.mCloseBtn.setImageResource(R$drawable.icon_close_activity_white_normal);
        this.topBar.bringToFront();
        ((RelativeLayout.LayoutParams) this.topBar.getLayoutParams()).setMargins(0, i6.n.h(this), 0, 0);
        ((RelativeLayout.LayoutParams) this.mProcessBar.getLayoutParams()).removeRule(3);
        this.divider.setVisibility(8);
    }

    private boolean inCustomView() {
        return this.xCustomView != null;
    }

    @SuppressLint({"JavascriptInterface"})
    private void initJavascriptInterface() {
        this.mWebView.addJavascriptInterface(getJavascriptInterface(), "huobiNative");
    }

    private void initPromptLayout() {
        this.promptLayout = (LinearLayout) findViewById(R$id.id_webview_base_prompt_dialog_layout);
        this.promptCloseBtn = findViewById(R$id.id_webview_base_close_prompt_dialog);
        this.promptText = (TextView) findViewById(R$id.id_webview_base_text_prompt_dialog);
        this.promptCloseBtn.setOnClickListener(new k());
        if (TextUtils.isEmpty(this.mUrl) || !this.mUrl.contains("hb_unsafe=1")) {
            this.promptLayout.setVisibility(8);
            return;
        }
        this.promptLayout.setVisibility(0);
        try {
            SensorsDataAPI.sharedInstance().track("App_domain_risk_warning_expose");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void initRefreshLayout() {
        this.refreshLayout = (SmartRefreshLayout) findViewById(R$id.refreshLayout);
        if ("0".equals(this.pullToRefreshType)) {
            this.refreshLayout.i(false);
            this.refreshLayout.g(false);
            this.refreshLayout.W(false);
            this.refreshLayout.a(false);
            return;
        }
        this.mProcessBar.setVisibility(8);
        this.refreshLayout.i(true);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(this);
        this.mRefreshHeader = smartRefreshHeader;
        smartRefreshHeader.setBackgroundColor(this.refreshBgColor);
        this.refreshLayout.j0(this.mRefreshHeader);
        this.refreshLayout.d0(new l());
        this.refreshLayout.c0(new m());
    }

    /* access modifiers changed from: private */
    public boolean isCustomTopBarTheme() {
        return TextUtils.equals(this.topbarTheme, "1") || TextUtils.equals(this.topbarTheme, "2") || TextUtils.equals(this.topbarTheme, "4");
    }

    private boolean isOfflineTipsOn() {
        long j11;
        try {
            j11 = Long.parseLong(SP.j("debugmode", MD5Utils.a("openTime"), ""));
        } catch (Throwable unused) {
            j11 = 0;
        }
        return System.currentTimeMillis() - j11 < Period.MIN60_MILLS;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.needIntercept) {
            notifyWebUserFinish(0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (this.needIntercept) {
            notifyWebUserFinish(0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.j(R$string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.isInitLoading) {
            this.mLoadingLayout.p();
        }
        this.mLoadingLayout.postDelayed(this.timeoutLoadingCallback, com.sumsub.sns.core.presentation.base.a.f30780p);
        this.mWebView.reload();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$customTopBar$0() {
        ViewUtil.m(this.topBar, true);
        ViewUtil.m(this.topBarScroll, true);
        ViewUtil.m(this.divider, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$1(View view) {
        WebView.HitTestResult hitTestResult = ((WebView) view).getHitTestResult();
        if (hitTestResult == null) {
            return false;
        }
        if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
            return onLongClickImg(hitTestResult);
        }
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onPermissionsDenied$10(DialogInterface dialogInterface, int i11) {
        HuobiToastUtil.v(getResources().getString(R$string.n_photo_save_failure));
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$readTopBarThemeConfig$11(String str) {
        this.topbarTheme = str;
        i6.d.b("readTopBarThemeConfig = " + str);
        updateTopBarTheme();
        if (!this.hasError) {
            webRefreshHide();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showTopIcon$5(String str, View view) {
        WebView webView = getWebView();
        webView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showTopIcon$6(String str, View view) {
        WebView webView = getWebView();
        webView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showTopIcon$7(String str, View view) {
        WebView webView = getWebView();
        webView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showTopIcon$8(List list) {
        String str;
        String str2 = "";
        this.fontIconTextViewRightOne.setVisibility(0);
        String str3 = (String) ((Map) list.get(0)).get("icon");
        g6.b.c().h(this.fontIconTextViewRightOne, str3);
        g6.b.c().h(this.fontIconTextViewRightOneScroll, str3);
        String str4 = "javascript:window.execAction( { \"action\": \"" + ((String) ((Map) list.get(0)).get("action")) + "\",\"menuTop\": \"" + PixelUtils.h((float) (this.topBar.getMeasuredHeight() + BaseActivity.getStatusBarHeight(this))) + "\"})";
        try {
            str = (String) ((Map) list.get(0)).get("iconWidth");
        } catch (Exception unused) {
            str = str2;
        }
        setLayoutWidth(str, this.fontIconTextViewRightOne, this.fontIconTextViewRightOneScroll);
        this.fontIconTextViewRightOne.setOnClickListener(new v6.q(this, str4));
        this.fontIconTextViewRightOneScroll.setVisibility(0);
        this.fontIconTextViewRightOneScroll.setOnClickListener(new a(str4));
        if (list.size() > 1) {
            String str5 = (String) ((Map) list.get(1)).get("icon");
            g6.b.c().h(this.fontIconTextViewRightTwo, str5);
            g6.b.c().h(this.fontIconTextViewRightTwoScroll, str5);
            this.fontIconTextViewRightTwo.setVisibility(0);
            this.fontIconTextViewRightTwoScroll.setVisibility(0);
            String str6 = "javascript:window.execAction( { \"action\": \"" + ((String) ((Map) list.get(1)).get("action")) + "\",\"menuTop\": \"" + PixelUtils.h((float) (this.topBar.getMeasuredHeight() + BaseActivity.getStatusBarHeight(this))) + "\"})";
            try {
                str2 = (String) ((Map) list.get(1)).get("iconWidth");
            } catch (Exception unused2) {
            }
            setLayoutWidth(str2, this.fontIconTextViewRightTwo, this.fontIconTextViewRightTwoScroll);
            this.fontIconTextViewRightTwo.setOnClickListener(new v6.b(this, str6));
            this.fontIconTextViewRightTwoScroll.setOnClickListener(new v6.p(this, str6));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showTopIcon$9() {
        this.fontIconTextViewRightOne.setVisibility(8);
        this.fontIconTextViewRightOneScroll.setVisibility(8);
        this.fontIconTextViewRightTwo.setVisibility(8);
        this.fontIconTextViewRightTwoScroll.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$tryShowAskIcon$12(View view) {
        showWebView(this, this.askUrl, "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$tryShowAskIcon$13(View view) {
        showWebView(this, this.askUrl, "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$tryShowShareIcon$14(View view) {
        i6.d.b("mActionBarShare doShare");
        doShare();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$tryShowShareIcon$15(View view) {
        i6.d.b("mActionBarShareScroll doShare");
        doShare();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$visibleToolbar$16(boolean z11) {
        ViewUtil.m(this.topBar, !z11);
        ViewUtil.m(this.topBarScroll, !z11);
        ViewUtil.m(this.divider, !z11);
        ViewUtil.m(this.mProcessBar, !z11);
    }

    /* access modifiers changed from: private */
    public void notifyWebUserFinish(int i11) {
        try {
            this.fromCode = i11;
            JsMessage jsMessage = new JsMessage();
            jsMessage.setCode(200);
            jsMessage.setAction(this.interceptCallback);
            jsMessage.setData(new NotifyWebInterceptBean(i11));
            x6.b.d(jsMessage, this);
        } catch (Throwable th2) {
            Log.e("hbwebview", "onPause() Throwable", th2);
        }
        this.mWebView.postDelayed(this.runnable, (long) (this.interceptSecond * 1000));
    }

    /* access modifiers changed from: private */
    public void onFullscreenEventChanged(boolean z11) {
        if (z11) {
            getWindow().addFlags(1024);
            getWindow().addFlags(128);
            setRequestedOrientation(0);
            return;
        }
        getWindow().clearFlags(1024);
        getWindow().clearFlags(128);
        setRequestedOrientation(1);
    }

    private boolean onLongClickImg(WebView.HitTestResult hitTestResult) {
        String extra = hitTestResult.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return false;
        }
        w.e().l(this, new d(extra));
        return true;
    }

    private void pageShow() {
        if (!this.isUploadPageShow) {
            HBWebView hBWebView = this.mWebView;
            hBWebView.loadUrl(PAGE_SHOW);
            SensorsDataAutoTrackHelper.loadUrl2(hBWebView, PAGE_SHOW);
            this.isUploadPageShow = !this.isUploadPageShow;
        }
    }

    /* access modifiers changed from: private */
    public void saveImg(String str) {
        String str2 = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str2)) {
            w.e().j(str);
            return;
        }
        this.mSaveImgBase64String = str;
        EasyPermissions.requestPermissions(getActivity(), 126, str2);
    }

    private void setTopBarTransparent() {
        this.topBar.setBackgroundColor(0);
        this.topBar.bringToFront();
        if (this.isHideNav) {
            ((RelativeLayout.LayoutParams) this.topBarScroll.getLayoutParams()).setMargins(0, i6.n.h(this), 0, 0);
        }
        ((RelativeLayout.LayoutParams) this.mProcessBar.getLayoutParams()).removeRule(3);
        this.divider.setVisibility(8);
        this.topBarScroll.bringToFront();
    }

    public static boolean showWebView(Context context, String str, String str2, String str3, boolean z11) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        context.startActivity(getWebViewIntent(context, str, str2, str3, z11));
        return true;
    }

    public static boolean showWebViewFroResult(Context context, String str, String str2, boolean z11, int i11) {
        if (context == null || !(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        ((Activity) context).startActivityForResult(getWebViewIntent(context, str, "", str2, z11), i11);
        return true;
    }

    public static boolean showWebViewNoClear(Context context, String str, String str2, String str3, boolean z11) {
        if (context == null || !(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        context.startActivity(getWebViewIntentNoClear(context, str, str2, str3, z11));
        return true;
    }

    private void syncCookie(String str, String str2) {
        CookieSyncManager.createInstance(getBaseContext()).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length > 0) {
                    instance.setCookie(str2, split2[0] + ContainerUtils.KEY_VALUE_DELIMITER + split2[1]);
                }
            }
        }
    }

    private void tryShowAskIcon() {
        if (!TextUtils.isEmpty(this.askUrl)) {
            this.ivQuestion.setVisibility(0);
            this.ivQuestionScroll.setVisibility(0);
            this.ivQuestion.setOnClickListener(new v6.o(this));
            this.ivQuestionScroll.setOnClickListener(new v6.n(this));
            return;
        }
        this.ivQuestion.setVisibility(8);
        this.ivQuestionScroll.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void tryShowShareIcon() {
        if (this.canShare) {
            this.mActionBarShare.setVisibility(0);
            this.mActionBarShareScroll.setVisibility(0);
            this.mActionBarShare.setOnClickListener(new v6.i(this));
            this.mActionBarShareScroll.setOnClickListener(new v6.l(this));
            return;
        }
        this.mActionBarShare.setVisibility(8);
        this.mActionBarShareScroll.setVisibility(8);
    }

    private void updateTopBarTheme() {
        if (!TextUtils.isEmpty(this.topbarTheme) && !this.topbarTheme.equalsIgnoreCase(OptionsBridge.NULL_VALUE)) {
            i6.d.c(TAG, "topbarTheme:" + this.topbarTheme);
            String str = this.topbarTheme;
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    changeToTheme1();
                    return;
                case 1:
                    changeToTheme2();
                    return;
                case 2:
                    changeToTheme3();
                    return;
                case 3:
                    changeToTheme4();
                    return;
                default:
                    changeToThemeDefault();
                    return;
            }
        }
    }

    public void addEvent() {
        super.addEvent();
        this.mBackBtn.setOnClickListener(new v6.k(this));
        this.mBackBtnScroll.setOnClickListener(new v6.m(this));
        p pVar = new p();
        this.mCloseBtn.setOnClickListener(pVar);
        this.mCloseBtnScroll.setOnClickListener(pVar);
        this.mLoadingLayout.setOnRetryClickListener(new v6.j(this));
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        if (!"huobiNative".equals(str)) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    public Map<String, String> buildHeaders(Map<String, String> map) {
        return map;
    }

    public String buildParams(String str) {
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(com.hbg.lib.core.util.p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(NightHelper.e().g() ? 1 : 0))});
        if (str.contains("?")) {
            return str + ContainerUtils.FIELD_DELIMITER + format;
        }
        return str + "?" + format;
    }

    public void cacheStatistics() {
        if (WebCacheInterecptRequest.f20660m && WebCacheInterecptRequest.f20662o > 0) {
            long j11 = (long) ((WebCacheInterecptRequest.f20663p * 100) / WebCacheInterecptRequest.f20662o);
            if (j11 > 100) {
                j11 = 100;
            }
            StringBuilder sb2 = new StringBuilder();
            if (WebCacheInterecptRequest.f20662o > WebCacheInterecptRequest.f20663p && System.currentTimeMillis() % 10 == 0) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(WebCacheInterecptRequest.f20665r);
                for (int i11 = 0; i11 < WebCacheInterecptRequest.f20664q.size(); i11++) {
                    if (!hashSet.contains(WebCacheInterecptRequest.f20664q.get(i11))) {
                        sb2.append(WebCacheInterecptRequest.f20664q.get(i11));
                        sb2.append("|||");
                    }
                }
            }
            WoodPeckerSDK.f().g().d("app_h5_cache_hit_rate", (double) j11, WebCacheInterecptRequest.f20661n + Constants.ACCEPT_TIME_SEPARATOR_SP + WebCacheInterecptRequest.f20662o + Constants.ACCEPT_TIME_SEPARATOR_SP + WebCacheInterecptRequest.f20663p + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mUrl + Constants.ACCEPT_TIME_SEPARATOR_SP + sb2.toString());
        }
        if (GlobalAppConfig.e()) {
            WebCacheInterecptRequest.g();
        } else {
            WebCacheInterecptRequest.b();
        }
    }

    public boolean canFullScreen() {
        return this.isHideNav;
    }

    public void clearNeedLoginAction() {
        this.needLogin = false;
        this.forceLoginSuccess = false;
        this.needLoginJsMessage = null;
        Log.d(TAG, "HBWebViewPool, clearNeedLoginAction");
    }

    public void continueMusic() {
        k7.c cVar = this.mAudioPlayController;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void customTopBar(JsMessage jsMessage) {
        Map map = (Map) jsMessage.getData();
        String str = (String) map.get(TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        String str2 = (String) map.get("titleColor");
        String str3 = (String) map.get("lineColor");
        if (!(str == null || str2 == null || str3 == null)) {
            try {
                this.backgroundColor = Color.parseColor(str);
            } catch (Exception unused) {
                this.backgroundColor = getResources().getColor(R$color.baseColorContentBackground);
            }
            try {
                this.titleColor = Color.parseColor(str2);
            } catch (Exception unused2) {
                this.titleColor = getResources().getColor(R$color.webview_title_color);
            }
            try {
                this.lineColor = Color.parseColor(str3);
            } catch (Exception unused3) {
                this.lineColor = getResources().getColor(R$color.global_divider_color);
            }
            this.topBar.setBackgroundColor(this.backgroundColor);
            this.mTitleTv.setTextColor(this.titleColor);
            this.topBarScroll.setBackgroundColor(this.backgroundColor);
            this.mTitleTvScroll.setTextColor(this.titleColor);
            this.divider.setBackgroundColor(this.lineColor);
            this.mBackBtn.setColorFilter(this.titleColor);
            this.ivQuestion.setColorFilter(this.titleColor);
            this.mCloseBtn.setColorFilter(this.titleColor);
            this.mActionBarShare.setColorFilter(this.titleColor);
            this.mBackBtnScroll.setColorFilter(this.titleColor);
            this.ivQuestionScroll.setColorFilter(this.titleColor);
            this.mCloseBtnScroll.setColorFilter(this.titleColor);
            this.mActionBarShareScroll.setColorFilter(this.titleColor);
        }
        if (map.containsKey(ASK_URL_KEY)) {
            this.askUrl = (String) map.get(ASK_URL_KEY);
        } else {
            this.askUrl = null;
        }
        tryShowAskIcon();
        if (map.containsKey(SHARE_TAG)) {
            this.canShare = true;
            this.shareCallbackKey = (String) map.get(SHARE_TAG);
        } else {
            this.canShare = false;
            this.shareCallbackKey = null;
        }
        tryShowShareIcon();
        String str4 = (String) map.get("titletext");
        if (str4 != null) {
            if (this.isHideNav) {
                this.mTitleTv.setText("");
            } else {
                this.mTitleTv.setText(str4);
                this.mTitleTvScroll.setText(str4);
            }
        }
        String str5 = (String) map.get(HIDETOPBAR_TAG);
        String str6 = (String) map.get(SHOWTOPBAR_TAG);
        String str7 = (String) map.get(HIDEBACKBTN_TAG);
        String str8 = (String) map.get(SHOWBACKBTN_TAG);
        String str9 = (String) map.get(HIDECLOSE_TAG);
        String str10 = (String) map.get(SHOWCLOSE_TAG);
        if (str5 != null && ("1".equalsIgnoreCase(str5) || "true".equalsIgnoreCase(str5))) {
            this.isHideTopBar = true;
            this.isHideNav = true;
            hideStatusBar();
            visibleToolbar(true);
        }
        if (str6 != null && ("1".equalsIgnoreCase(str6) || "true".equalsIgnoreCase(str6))) {
            this.isHideNav = false;
            showStatusBar();
            runOnUiThread(new v6.e(this));
        }
        if (str7 != null && ("1".equalsIgnoreCase(str7) || "true".equalsIgnoreCase(str7))) {
            this.isHideBackBtn = true;
            ViewUtil.m(this.mBackBtn, false);
            ViewUtil.m(this.mBackBtnScroll, false);
        }
        if (str9 != null && ("1".equalsIgnoreCase(str9) || "true".equalsIgnoreCase(str9))) {
            this.isHideCloseBtn = true;
            this.mCloseBtn.setVisibility(8);
            this.mCloseBtnScroll.setVisibility(8);
        }
        if (str8 != null && ("1".equalsIgnoreCase(str8) || "true".equalsIgnoreCase(str8))) {
            ViewUtil.m(this.mCloseBtn, true);
            ViewUtil.m(this.mCloseBtnScroll, true);
        }
        if (str10 == null) {
            return;
        }
        if ("1".equalsIgnoreCase(str10) || "true".equalsIgnoreCase(str10)) {
            setCloseTvVisible(true);
        }
    }

    public void finish() {
        this.mTracer.d(StepType.WebViewClose, this.mUrl);
        AlertInfo alertInfo2 = this.alertInfo;
        if (alertInfo2 == null || !alertInfo2.isShowAlert()) {
            super.finish();
        } else {
            DialogUtils.c0(this, TextUtils.isEmpty(this.alertInfo.getContent()) ? getString(R$string.alert_exit_content) : this.alertInfo.getContent(), "", TextUtils.isEmpty(this.alertInfo.getCancel()) ? getString(R$string.stay_page) : this.alertInfo.getCancel(), TextUtils.isEmpty(this.alertInfo.getConfirm()) ? getString(R$string.exit_page) : this.alertInfo.getConfirm(), new b(), new c());
        }
    }

    public void finishRefresh() {
        if (this.refreshLayout.M()) {
            this.refreshLayout.finishRefresh();
        }
    }

    public Activity getActivity() {
        return this;
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public String getAvailableLocationY() {
        return "";
    }

    public int getContentView() {
        return R$layout.base_webview_layout;
    }

    public String getDisplayHeight() {
        return "";
    }

    public String getDisplayWidth() {
        return "";
    }

    public x6.c getJavascriptInterface() {
        return new x6.c(this);
    }

    public String getNavigatorHeight() {
        return "";
    }

    public ActivityResultLauncher<Intent> getResultLauncher(v vVar) {
        this.jumioLauncherResultListener = vVar;
        return this.resultLauncher;
    }

    public String getTopHeight() {
        return "";
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void init() {
        EventBus.d().p(this);
        this.mTracer.d(StepType.WebViewCreate, this.mUrl);
        initWebView();
        loadUrl(this.mUrl);
        if (this.isHideNav) {
            this.mTitleTv.setText("");
        } else if (!TextUtils.isEmpty(this.mTitleText)) {
            this.mTitleTv.setText(this.mTitleText);
            this.mTitleTvScroll.setText(this.mTitleText);
        }
        if (GlobalAppConfig.e()) {
            TextView textView = new TextView(this);
            textView.setTextColor(-65536);
            textView.setTextSize(8.0f);
            textView.setText(ChainInfo.CHAIN_TYPE_NEW);
            ((ViewGroup) getWebView().getParent()).addView(textView);
        }
    }

    public void initIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            this.mOriginUrl = stringExtra;
            this.mUrl = StringUtils.w(stringExtra);
            this.mTitleText = intent.getStringExtra("title");
            this.mTitleBack = intent.getStringExtra("title_back");
            this.mIsAuth = intent.getBooleanExtra("isauth", false);
            this.mIsHomeFunction = intent.getBooleanExtra("homeFunction", false);
            String str = this.mUrl;
            if (str != null) {
                if (HbgRouter.f(str)) {
                    w.e().g(this, this.mUrl);
                    finish();
                    return;
                }
                Uri parse = Uri.parse(this.mUrl);
                String queryParameter = parse.getQueryParameter(HIDETOPBAR_TAG);
                String queryParameter2 = parse.getQueryParameter(HIDEBACKBTN_TAG);
                String queryParameter3 = parse.getQueryParameter(HIDECLOSE_TAG);
                this.isHideNav = "1".equalsIgnoreCase(parse.getQueryParameter(HIDENAV_TAG));
                if ("1".equalsIgnoreCase(queryParameter) || "true".equalsIgnoreCase(queryParameter)) {
                    this.isHideTopBar = true;
                    this.isHideNav = true;
                }
                if ("1".equalsIgnoreCase(queryParameter2) || "true".equalsIgnoreCase(queryParameter2)) {
                    this.isHideBackBtn = true;
                }
                if ("1".equalsIgnoreCase(queryParameter3) || "true".equalsIgnoreCase(queryParameter3)) {
                    this.isHideCloseBtn = true;
                }
                String queryParameter4 = parse.getQueryParameter(REFRESH_TAG);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    this.pullToRefreshType = queryParameter4;
                    this.refreshBgColorString = parse.getQueryParameter("color");
                    try {
                        this.refreshBgColor = Color.parseColor("#" + this.refreshBgColorString);
                    } catch (Exception unused) {
                        this.refreshBgColor = getResources().getColor(R$color.color_white);
                    }
                } else {
                    this.pullToRefreshType = "0";
                }
            }
            if (this.mIsAuth && !w.e().c(this, this.mUrl, this.mTitleBack)) {
                finish();
            }
        }
    }

    public void initView() {
        super.initView();
        this.mWebView = new HBWebView(this);
        this.mProcessBar = (ProgressBar) findViewById(R$id.id_webview_base_progress);
        this.mBackBtn = (ImageView) this.viewFinder.b(R$id.id_webview_base_back_tv);
        this.mBackBtnScroll = (ImageView) this.viewFinder.b(R$id.webview_back_scroll);
        this.mCloseBtn = (ImageView) this.viewFinder.b(R$id.id_webview_base_close_tv);
        this.mCloseBtnScroll = (ImageView) this.viewFinder.b(R$id.webview_close_scroll);
        this.mTitleTv = (TextView) this.viewFinder.b(R$id.id_webview_base_title_tv);
        this.mTitleTvScroll = (TextView) this.viewFinder.b(R$id.webview_title_scroll);
        this.mLlRootLayout = (RelativeLayout) this.viewFinder.b(R$id.id_web_base_photo_root_layout);
        this.flVideo = (FrameLayout) this.viewFinder.b(R$id.flVideo);
        this.mActionBarShare = (ImageView) this.viewFinder.b(R$id.iv_actionbar_share);
        this.mActionBarShareScroll = (ImageView) this.viewFinder.b(R$id.webview_share_scroll);
        this.ivQuestion = (ImageView) this.viewFinder.b(R$id.iv_question);
        this.fontIconTextViewRightOne = (ImageView) this.viewFinder.b(R$id.font_icon_text_view_right_one);
        this.fontIconTextViewRightOneScroll = (ImageView) this.viewFinder.b(R$id.font_icon_text_view_right_one_scroll);
        this.fontIconTextViewRightTwo = (ImageView) this.viewFinder.b(R$id.font_icon_text_view_right_two);
        this.fontIconTextViewRightTwoScroll = (ImageView) this.viewFinder.b(R$id.font_icon_text_view_right_two_scroll);
        this.ivQuestionScroll = (ImageView) this.viewFinder.b(R$id.webview_question_scroll);
        this.topBar = this.viewFinder.b(R$id.topBar);
        this.topBarScroll = this.viewFinder.b(R$id.topBarScroll);
        this.divider = this.viewFinder.b(R$id.divider);
        LoadingLayout loadingLayout = (LoadingLayout) this.viewFinder.b(R$id.loading_layout);
        this.mLoadingLayout = loadingLayout;
        loadingLayout.p();
        this.isInitLoading = true;
        if (this.isHideNav) {
            hideNav();
        }
        if (this.isHideTopBar) {
            hideStatusBar();
            visibleToolbar(true);
        }
        if (this.isHideBackBtn) {
            ViewUtil.m(this.mBackBtn, false);
            ViewUtil.m(this.mBackBtnScroll, false);
        }
        if (this.isHideCloseBtn) {
            this.mCloseBtn.setVisibility(8);
            this.mCloseBtnScroll.setVisibility(8);
        }
        this.mWebView.setOnLongClickListener(new v6.c(this));
        this.mLoadingLayout.postDelayed(this.timeoutLoadingCallback, com.sumsub.sns.core.presentation.base.a.f30780p);
    }

    public void initWebView() {
        Log.d(TAG, "initWebView");
        initJavascriptInterface();
        setWebViewUserAgent();
        initRefreshLayout();
        initWebViewClient(this.mWebView);
        this.refreshLayout.addView(this.mWebView);
        initPromptLayout();
        this.mWebView.setScrollChangeListener(this);
    }

    public void initWebViewClient(WebView webView) {
        o oVar = new o(webView);
        JoinPoint c11 = org.aspectj.runtime.reflect.c.c(ajc$tjp_0, this, webView, oVar);
        WoodPeckerWebViewAspect.h().g(new s(new Object[]{this, webView, oVar, c11}).linkClosureAndJoinPoint(4112));
        q qVar = new q(this);
        this.mChromeClient = qVar;
        webView.setWebChromeClient(qVar);
    }

    public boolean isFinishOnBackBtnClick() {
        return false;
    }

    public boolean isPaused() {
        k7.c cVar = this.mAudioPlayController;
        return cVar != null && cVar.c() == PlayStatus.PAUSED;
    }

    public boolean isPlaying() {
        k7.c cVar = this.mAudioPlayController;
        return cVar != null && cVar.c() == PlayStatus.PLAYING;
    }

    public boolean isSupportBlankLabel() {
        return false;
    }

    public void loadUrl(String str) {
        if (BaseModuleConfig.a() != null) {
            str = BaseModuleConfig.a().y(str);
        }
        String w11 = StringUtils.w(buildParams(str));
        this.mWebView.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        String str2 = null;
        try {
            str2 = new URL(w11).getPath();
        } catch (Exception unused) {
        }
        String handleLocalService = handleLocalService(w11);
        if (BaseModuleConfig.a() != null && BaseModuleConfig.a().p0(str2, "h5")) {
            hashMap.put("canary", "always");
        }
        Log.d(TAG, "loadUrl(), mIsAuth:" + this.mIsAuth);
        if (this.mIsAuth) {
            w.e().m(this.mWebView, handleLocalService);
        }
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "loadUrl() called with: url = [" + handleLocalService + "]");
        }
        HBWebView hBWebView = this.mWebView;
        Map<String, String> buildHeaders = buildHeaders(hashMap);
        hBWebView.loadUrl(handleLocalService, buildHeaders);
        SensorsDataAutoTrackHelper.loadUrl2(hBWebView, handleLocalService, buildHeaders);
    }

    public void muteMusic() {
        k7.c cVar = this.mAudioPlayController;
        if (cVar != null) {
            this.mCurrentVolume = cVar.f();
            this.mAudioPlayController.setVolume(0);
        }
    }

    public void notifyFinish(boolean z11) {
        if (z11) {
            this.needIntercept = false;
            this.mWebView.removeCallbacks(this.runnable);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                doNotifyFinish();
            } else {
                runOnUiThread(new g());
            }
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        x6.d dVar;
        super.onActivityResult(i11, i12, intent);
        if (i12 == 1001) {
            finish();
        } else {
            this.mChromeClient.d(i11, i12, intent);
        }
        if (i11 == 605 && (dVar = this.mJumioHelpCallback) != null) {
            dVar.onActivityResult(i11, i12, intent);
        } else if (this.isBackRefresh) {
            this.isBackRefresh = false;
            getWebView().clearCache(true);
            showWebView(this, this.mUrl, this.mTitleText, this.mTitleBack, this.mIsAuth);
        }
    }

    public void onBackPressed() {
        if (this.needIntercept) {
            notifyWebUserFinish(2);
            return;
        }
        this.mWebView.removeCallbacks(this.runnable);
        if (isFinishOnBackBtnClick() || !this.mWebView.canGoBack()) {
            finish();
            return;
        }
        this.mWebView.goBack();
        readTopBarThemeConfig();
        this.mWebView.postDelayed(this.reloadMeta, 200);
        this.mWebView.postDelayed(this.reloadMeta, 1000);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.layout_web_refresh || id2 == R$id.btn_web_refresh) {
            this.mWebView.reload();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mIsReCreate = true;
        }
        this.mTracer = new WebviewTracer();
        initIntent(getIntent());
        super.onCreate(bundle);
        DokitJsActionHelper.c(this, this.mWebView);
        AppLanguageHelper.getInstance().changeAppLanguage(this, AppLanguageHelper.getInstance().getCurAppLocale());
        init();
        WebCacheInterecptRequest.f20660m = AppConfigManager.h(MgtConfigNumber.H5_CACHE_CONFIG.number, "needStatisticsCacheHitRate", false);
        WebCacheInterecptRequest.b();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
        if (this.mIsHomeFunction && !this.mIsReCreate) {
            WoodPeckerSDK.f().g().c("FunctionWebClose", this.mUrl, "");
        }
        this.mLoadingLayout.removeCallbacks(this.timeoutLoadingCallback);
        this.mWebView.removeCallbacks(this.reloadMeta);
        this.mWebView.onPause();
        this.mWebView.clearHistory();
        ng.b bVar = this.localService;
        if (bVar != null) {
            bVar.e();
        }
        stopMusic();
        this.refreshLayout.removeView(this.mWebView);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !inCustomView()) {
            return super.onKeyDown(i11, keyEvent);
        }
        hideCustomView();
        return true;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onOfflineEventCall(HBWebViewOfflineEvent hBWebViewOfflineEvent) {
        i6.r rVar = this.viewFinder;
        if (rVar != null) {
            View b11 = rVar.b(R$id.vOfflineLabel);
            TextView textView = (TextView) this.viewFinder.b(R$id.offline_tips);
            if (hBWebViewOfflineEvent.hitCache) {
                if (isOfflineTipsOn()) {
                    textView.setVisibility(0);
                    textView.setText("离线包：" + hBWebViewOfflineEvent.packageName + " md5: " + hBWebViewOfflineEvent.md5);
                }
                b11.setVisibility(0);
                return;
            }
            b11.setVisibility(8);
            textView.setVisibility(8);
        }
    }

    public void onPageLoadFinished() {
        this.refreshLayout.i(!"0".equals(this.pullToRefreshType));
        if ("2".equals(this.pullToRefreshType)) {
            finishRefresh();
        }
        pageShow();
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "HBWebViewPool, onPause");
        if (this.htmlLoadFinish) {
            this.isLift = true;
            try {
                JsMessage jsMessage = new JsMessage();
                jsMessage.setCode(200);
                jsMessage.setAction("notifyWebContainerOnPause");
                x6.b.d(jsMessage, this);
            } catch (Throwable th2) {
                Log.e("hbwebview", "onPause() Throwable", th2);
            }
        }
        pauseMusic(false);
        try {
            cacheStatistics();
        } catch (Throwable unused) {
        }
        this.mTracer.d(StepType.WebViewDisappear, this.mUrl);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        x6.f fVar;
        if (i11 == 126 && EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder(getActivity(), String.format(getString(R$string.permission_write_external_storage_apply), new Object[]{getString(R$string.app_real_name)})).setTitle(getString(R$string.permission_to_apply)).setPositiveButton(getString(R$string.currency_deposit_go_to_settings)).setNegativeButton(getString(R$string.string_cancel), new v6.a(this)).setRequestCode(126).build().show();
        } else if (i11 == 123) {
            this.mChromeClient.e(i11, list);
        } else if (i11 == 130 && (fVar = this.mPermissionHelpCallback) != null) {
            fVar.onPermissionsDenied(i11, list);
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        x6.f fVar;
        if (i11 == 126 && !TextUtils.isEmpty(this.mSaveImgBase64String)) {
            saveImg(this.mSaveImgBase64String);
        } else if (i11 == 123) {
            this.mChromeClient.h();
        } else if (i11 == 130 && (fVar = this.mPermissionHelpCallback) != null) {
            fVar.onPermissionsGranted(i11, list);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
        if (i11 == 100001) {
            PermissionRequest b11 = this.mChromeClient.b();
            if (iArr.length <= 0 || iArr[0] != 0) {
                if (b11 != null) {
                    b11.deny();
                }
            } else if (b11 != null) {
                b11.grant(b11.getResources());
            }
        }
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "HBWebViewPool, onResume");
        JsMessage jsMessage = this.needLoginJsMessage;
        if (jsMessage != null && this.needLogin) {
            JsMessage clone = jsMessage.clone();
            clone.setAction(ACTION_NATIVE_LOGIN_CHECK);
            x6.b.c(clone, this);
        }
        if (!this.isUserPaused && isPaused()) {
            continueMusic();
        }
        t tVar = this.viewLifecycleCallback;
        if (tVar != null) {
            tVar.onResume();
        }
        if (this.htmlLoadFinish && this.isLift) {
            try {
                JsMessage jsMessage2 = new JsMessage();
                jsMessage2.setCode(200);
                jsMessage2.setAction("notifyWebContainerOnResume");
                x6.b.d(jsMessage2, this);
            } catch (Throwable th2) {
                Log.e("hbwebview", "onPause() Throwable", th2);
            }
        }
        this.mTracer.d(StepType.WebViewShow, this.mUrl);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        if (isCustomTopBarTheme()) {
            float f11 = (((float) i12) * 1.0f) / ((float) TOP_BAR_SCROLL_HEIGHT);
            if (this.topBarForceShow) {
                this.lastTopBarAlpha = f11;
                return;
            }
            i6.d.c(TAG, "透明度：" + f11);
            this.topBar.setAlpha(1.0f - f11);
            this.topBarScroll.setAlpha(f11);
        } else if (!this.topbarTheme.equals("3")) {
        } else {
            if (this.divider.getVisibility() != 0 && i12 > 0) {
                ViewUtil.m(this.divider, true);
            } else if (this.divider.getVisibility() == 0 && i12 == 0) {
                ViewUtil.m(this.divider, false);
            }
        }
    }

    public void onShareClick() {
    }

    public void pauseMusic(boolean z11) {
        if (this.mAudioPlayController != null && isPlaying()) {
            this.isUserPaused = z11;
            this.mAudioPlayController.d();
        }
    }

    public void playMusic(String str) {
        stopMusic();
        if (this.mAudioPlayController == null) {
            k7.c a11 = new i7.a(this).a();
            this.mAudioPlayController = a11;
            a11.setLooping(true);
        }
        this.mAudioPlayController.e(str);
    }

    public void readTopBarThemeConfig() {
        MetaUtils.c(this.mWebView, APP_BAR_THEME, new v6.d(this));
    }

    public void report(String str, String str2, String str3) {
        this.mTracer.e(str, this.mUrl, str2, str3);
    }

    public void setAlertDialogInfo(AlertInfo alertInfo2) {
        this.alertInfo = alertInfo2;
    }

    public void setBackRefreshOneTime(boolean z11) {
        this.isBackRefresh = z11;
    }

    public void setCloseTvVisible(boolean z11) {
        if (this.isHideNav) {
            this.mCloseBtn.setVisibility(8);
            return;
        }
        ViewUtil.m(this.mCloseBtn, z11);
        ViewUtil.m(this.mCloseBtnScroll, z11);
    }

    public void setHBWebViewLifecycleCallback(t tVar) {
        this.viewLifecycleCallback = tVar;
    }

    public void setInterceptCallback(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.interceptCallback = str;
        }
    }

    public void setInterceptSecond(int i11) {
        if (i11 > 0) {
            this.interceptSecond = i11;
        }
    }

    public void setJumioHelpCallback(x6.d dVar) {
        this.mJumioHelpCallback = dVar;
    }

    public void setLayoutWidth(String str, ImageView imageView, ImageView imageView2) {
        int i11;
        if (!TextUtils.isEmpty(str)) {
            try {
                i11 = Integer.valueOf(str).intValue();
            } catch (Exception unused) {
                i11 = 0;
            }
            if (i11 != 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                float f11 = (float) i11;
                layoutParams.width = PixelUtils.a(f11);
                layoutParams2.width = PixelUtils.a(f11);
                imageView.setLayoutParams(layoutParams);
                imageView2.setLayoutParams(layoutParams2);
            }
        }
    }

    public void setNeedIntercept(boolean z11) {
        this.needIntercept = z11;
        if (!z11) {
            this.mWebView.removeCallbacks(this.runnable);
        }
    }

    public void setNeedLoginAction(boolean z11, boolean z12, JsMessage jsMessage) {
        this.needLogin = z11;
        this.forceLoginSuccess = z12;
        this.needLoginJsMessage = jsMessage;
        Log.d(TAG, "HBWebViewPool, setNeedLoginAction, needLoginJsMessage:" + jsMessage.toString());
    }

    public void setPermissionCallback(x6.f fVar) {
        this.mPermissionHelpCallback = fVar;
    }

    public void setProcess(int i11) {
        ProgressBar progressBar = this.mProcessBar;
        if (progressBar != null) {
            progressBar.setProgress(i11);
        }
    }

    public void setProcessBarVisible(boolean z11) {
        if (this.isInitLoading) {
            ViewUtil.m(this.mProcessBar, false);
            return;
        }
        if (z11) {
            this.mProcessBar.setProgress(0);
        }
        ViewUtil.m(this.mProcessBar, z11);
    }

    public void setTitleText(CharSequence charSequence) {
        if (this.isHideNav) {
            this.mTitleTv.setText("");
        } else if (TextUtils.isEmpty(this.mTitleText)) {
            this.mTitleTv.setText(charSequence);
            this.mTitleTvScroll.setText(charSequence);
        }
        readTopBarThemeConfig();
    }

    public void setTopBarColor(JsMessage jsMessage) {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "setTopBarColor() called with: jsMessage = [" + jsMessage + "]");
        }
        Map map = (Map) jsMessage.getData();
        Object obj = map.get(TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        Object obj2 = map.get("titleColor");
        Object obj3 = map.get("lineColor");
        if (obj != null && obj2 != null && obj3 != null) {
            try {
                this.backgroundColor = Color.parseColor((String) obj);
            } catch (Exception unused) {
                this.backgroundColor = getResources().getColor(R$color.baseColorContentBackground);
            }
            try {
                this.titleColor = Color.parseColor((String) obj2);
            } catch (Exception unused2) {
                this.titleColor = getResources().getColor(R$color.webview_title_color);
            }
            try {
                this.lineColor = Color.parseColor((String) obj3);
            } catch (Exception unused3) {
                this.lineColor = getResources().getColor(R$color.global_divider_color);
            }
            this.topBar.setBackgroundColor(this.backgroundColor);
            this.mTitleTv.setTextColor(this.titleColor);
            this.topBarScroll.setBackgroundColor(this.backgroundColor);
            this.mTitleTvScroll.setTextColor(this.titleColor);
            this.divider.setBackgroundColor(this.lineColor);
            this.mBackBtn.setColorFilter(this.titleColor);
            this.ivQuestion.setColorFilter(this.titleColor);
            this.mCloseBtn.setColorFilter(this.titleColor);
            this.mActionBarShare.setColorFilter(this.titleColor);
            this.mBackBtnScroll.setColorFilter(this.titleColor);
            this.ivQuestionScroll.setColorFilter(this.titleColor);
            this.mCloseBtnScroll.setColorFilter(this.titleColor);
            this.mActionBarShareScroll.setColorFilter(this.titleColor);
        }
    }

    public void setWebViewRefreshType(String str) {
        if ("1".equals(str)) {
            this.pullToRefreshType = "1";
        } else if ("2".equals(str)) {
            this.pullToRefreshType = "2";
        }
    }

    public void setWebViewUserAgent() {
        String userAgentString = this.mWebView.getSettings().getUserAgentString();
        if (this.mIsHomeFunction && !this.mIsReCreate) {
            if (userAgentString == null) {
                userAgentString = " Source/HomeFunction";
            } else {
                userAgentString = userAgentString + " Source/HomeFunction";
            }
        }
        String f11 = w.e().f(userAgentString);
        H5Retrofit.b().c(f11);
        this.mWebView.getSettings().setUserAgentString(f11);
    }

    public void showActionBarShare(boolean z11) {
        this.canShare = z11;
        runOnUiThread(new e());
    }

    public void showTopBar(JsMessage jsMessage) {
        if (GlobalAppConfig.e()) {
            Log.d("hbwebview", "showTopBar() called with: jsMessage = [" + jsMessage + "]");
        }
        Object obj = ((Map) jsMessage.getData()).get(SHOWTOPBAR_TAG);
        if (obj != null && (obj instanceof Boolean)) {
            if (((Boolean) obj).booleanValue()) {
                this.topBarForceShow = true;
                this.lastTopBarAlpha = this.topBarScroll.getAlpha();
                this.topBar.setAlpha(0.0f);
                this.topBarScroll.setAlpha(1.0f);
                return;
            }
            this.topBarForceShow = false;
            this.topBar.setAlpha(1.0f - this.lastTopBarAlpha);
            this.topBarScroll.setAlpha(this.lastTopBarAlpha);
        }
    }

    public void showTopIcon(List<Map<String, String>> list) {
        if (list == null || list.size() <= 0) {
            runOnUiThread(new v6.f(this));
        } else {
            runOnUiThread(new v6.g(this, list));
        }
    }

    public void stopMusic() {
        k7.c cVar = this.mAudioPlayController;
        if (cVar != null) {
            cVar.release();
            this.mAudioPlayController = null;
        }
    }

    public void tryShowCloseButton() {
        if (!this.isHideNav) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtnScroll.setVisibility(0);
            return;
        }
        this.mCloseBtn.setVisibility(8);
        this.mCloseBtnScroll.setVisibility(8);
    }

    public void unMuteMusic() {
        k7.c cVar = this.mAudioPlayController;
        if (cVar != null) {
            cVar.setVolume(this.mCurrentVolume);
        }
    }

    public void updateTopBarFunction(JsMessage jsMessage) {
        Map map = (Map) jsMessage.getData();
        if (map.containsKey(ASK_URL_KEY)) {
            this.askUrl = (String) map.get(ASK_URL_KEY);
        } else {
            this.askUrl = null;
        }
        tryShowAskIcon();
        if (!TextUtils.isEmpty(jsMessage.getCallback())) {
            this.canShare = true;
            this.shareCallbackKey = jsMessage.getCallback();
        } else {
            this.canShare = false;
            this.shareCallbackKey = null;
        }
        tryShowShareIcon();
    }

    public void visibleToolbar(boolean z11) {
        runOnUiThread(new v6.h(this, z11));
    }

    public void webRefreshHide() {
        this.mLoadingLayout.removeCallbacks(this.timeoutLoadingCallback);
        this.refreshLayout.setVisibility(0);
        this.mLoadingLayout.setVisibility(8);
        this.isInitLoading = false;
    }

    public void webRefreshShow() {
        this.mLoadingLayout.removeCallbacks(this.timeoutLoadingCallback);
        this.refreshLayout.setVisibility(8);
        this.mLoadingLayout.setVisibility(0);
        this.mLoadingLayout.k();
    }

    public static boolean showWebView(Context context, String str, String str2, String str3, boolean z11, boolean z12) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z12 || NetworkStatus.c(context)) {
            Intent intent = new Intent(context, HBBaseWebActivity.class);
            intent.putExtra("url", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("title", str2);
            }
            intent.putExtra("title_back", str3);
            intent.putExtra("isauth", z11);
            context.startActivity(intent);
            return true;
        }
        HuobiToastUtil.k(context, R$string.string_network_disconnect);
        return false;
    }

    public class o extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public String f68796a;

        /* renamed from: b  reason: collision with root package name */
        public long f68797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WebView f68798c;

        public o(WebView webView) {
            this.f68798c = webView;
        }

        public void onPageFinished(WebView webView, String str) {
            String str2;
            super.onPageFinished(webView, str);
            HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
            if (hBBaseWebActivity.mIsHomeFunction && !hBBaseWebActivity.hasError && !HBBaseWebActivity.this.htmlLoadFinish && !HBBaseWebActivity.this.mIsReCreate) {
                WoodPeckerSDK.f().g().c("FunctionWebLoadSuccess", str, "");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("isOffline", Integer.valueOf(HBBaseWebActivity.this.mWebView.u() ? 1 : 0));
            if (HBBaseWebActivity.this.mWebView.u()) {
                hashMap.put("packageId", HBBaseWebActivity.this.mWebView.getPackageId());
            }
            try {
                str2 = Uri.parse(str).buildUpon().clearQuery().build().toString();
            } catch (Throwable unused) {
                str2 = str;
            }
            hashMap.put("url", str2);
            hashMap.put("original_url", HBBaseWebActivity.this.mOriginUrl);
            if (this.f68797b > 0) {
                hashMap.put("web_duration", Long.valueOf(System.currentTimeMillis() - this.f68797b));
            } else {
                hashMap.put("web_duration", -1);
            }
            SensorUtil.a("App_H5_Start", hashMap);
            if (HBBaseWebActivity.this.hasError) {
                SensorUtil.a("App_H5_Error", hashMap);
            }
            boolean unused2 = HBBaseWebActivity.this.htmlLoadFinish = true;
            i6.d.b("HBWebViewPool, HBBaseWebViewActivity---->onPageFinished = " + str);
            Log.d(HBBaseWebActivity.TAG, "onPageFinished = " + str);
            HBBaseWebActivity.this.setProcessBarVisible(false);
            HBBaseWebActivity.this.onPageLoadFinished();
            if (HBBaseWebActivity.this.mUrl.equals(str)) {
                this.f68798c.clearHistory();
            }
            HBBaseWebActivity.this.readTopBarThemeConfig();
            if (webView.getProgress() == 100 && !TextUtils.equals(this.f68796a, str)) {
                this.f68796a = str;
                HBBaseWebActivity.this.mTracer.d(StepType.WebViewDidSuccess, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f68797b = System.currentTimeMillis();
            AlertInfo unused = HBBaseWebActivity.this.alertInfo = null;
            HBBaseWebActivity.this.setProcessBarVisible(true);
            boolean unused2 = HBBaseWebActivity.this.hasError = false;
            if (HBBaseWebActivity.this.mIsHomeFunction) {
                WoodPeckerSDK.f().g().c("FunctionStartRequest", str, "");
            }
            i6.d.b("HBWebViewPool, HBBaseWebViewActivity---->onPageStarted = " + str);
            Log.d(HBBaseWebActivity.TAG, "onPageStarted = " + str);
            HBBaseWebActivity.this.mTracer.d(StepType.WebViewRequest, str);
            this.f68796a = "";
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            i6.d.b("HBWebViewPool, HBBaseWebViewActivity---->onReceivedError, errorCode" + i11 + ", description" + str);
            EventBus.d().k(new WebViewLoadFailedEvent(i11, str, str2));
            if (!str2.startsWith("huobiapp://")) {
                boolean unused = HBBaseWebActivity.this.hasError = true;
                HBBaseWebActivity.this.webRefreshShow();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (HbgRouter.f(str)) {
                w.e().g(HBBaseWebActivity.this, str);
                return true;
            }
            if (HBBaseWebActivity.this.localService != null) {
                String unused = HBBaseWebActivity.this.currentPath = Uri.parse(str).getPath();
            }
            return false;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            i6.d.b("HBWebViewPool, HBBaseWebViewActivity---->onReceivedError, errorCode" + webResourceError.getErrorCode() + ", description" + webResourceError.getDescription().toString());
            HBBaseWebActivity.this.mTracer.d(StepType.WebViewDidFail, webResourceRequest.getUrl().toString());
        }
    }

    public void playMusic(int i11) {
        stopMusic();
        if (this.mAudioPlayController == null) {
            k7.c a11 = new i7.a(this).a();
            this.mAudioPlayController = a11;
            a11.setLooping(true);
        }
        this.mAudioPlayController.g(i11);
    }

    public static boolean showWebView(Context context, Intent intent) {
        if (!(context instanceof Activity) || intent == null) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}
