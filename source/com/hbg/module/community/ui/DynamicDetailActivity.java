package com.hbg.module.community.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.SaveImageUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.RichTextBean;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.pro.socket.bean.SymbolPriceV2;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListenerV2;
import com.hbg.lib.network.pro.socket.response.MarketOverviewV2Response;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.community.viewmodel.DelDynamicViewModel;
import com.hbg.module.community.viewmodel.DynamicDetailViewModel;
import com.hbg.module.community.widgets.rich.RichWebView;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$font;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.content.custom.widget.TagViewWidget;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.ui.ability.ContentAbility;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import com.hbg.module.content.utls.comment.CommentExtKt;
import com.hbg.module.content.utls.m;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.android.tpush.common.Constants;
import com.wtree.helper.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import rx.subjects.BehaviorSubject;

@Route(path = "/content/DynamicDetail")
public final class DynamicDetailActivity extends BaseActivity<lc.c> implements CommentListAdapter.a {
    public static final a H = new a((kotlin.jvm.internal.r) null);
    public SpannableStringBuilder A;
    public TextView B;
    public int C;
    public c D = new c(this);
    public final String E = "\n        function getVideoRect() {\n            let tags = document.getElementsByTagName('video');\n            if (tags.length > 0) {\n                let video = tags[0];\n                return {\n                    'width': video.videoWidth,\n                    'height': video.videoHeight\n                };\n            }\n            return {};\n        }\n        getVideoRect();\n    ";
    public View F;
    public WebChromeClient.CustomViewCallback G;

    /* renamed from: i  reason: collision with root package name */
    public String f17327i = "";

    /* renamed from: j  reason: collision with root package name */
    public boolean f17328j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f17329k = true;

    /* renamed from: l  reason: collision with root package name */
    public DynamicDetailViewModel f17330l;

    /* renamed from: m  reason: collision with root package name */
    public DelDynamicViewModel f17331m;

    /* renamed from: n  reason: collision with root package name */
    public DynamicDetailInfo f17332n;

    /* renamed from: o  reason: collision with root package name */
    public int f17333o = 1;

    /* renamed from: p  reason: collision with root package name */
    public CommentListAdapter f17334p;

    /* renamed from: q  reason: collision with root package name */
    public String f17335q = "0";

    /* renamed from: r  reason: collision with root package name */
    public HashMap<String, Object> f17336r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f17337s = true;

    /* renamed from: t  reason: collision with root package name */
    public boolean f17338t;

    /* renamed from: u  reason: collision with root package name */
    public WebChromeClient f17339u;

    /* renamed from: v  reason: collision with root package name */
    public int f17340v = 2;

    /* renamed from: w  reason: collision with root package name */
    public v6.u f17341w;

    /* renamed from: x  reason: collision with root package name */
    public rj.b f17342x;

    /* renamed from: y  reason: collision with root package name */
    public rj.b f17343y;

    /* renamed from: z  reason: collision with root package name */
    public final MarketOverviewListenerV2 f17344z = new v(this);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public static /* synthetic */ void b(a aVar, long j11, long j12, Context context, boolean z11, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            aVar.a(j11, j12, context, z11);
        }

        public static /* synthetic */ void d(a aVar, long j11, long j12, Context context, boolean z11, boolean z12, int i11, Object obj) {
            aVar.c(j11, j12, context, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12);
        }

        public final void a(long j11, long j12, Context context, boolean z11) {
            if (0 != j11) {
                Postcard withString = b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(j11));
                if (z11) {
                    withString.addFlags(268435456);
                }
                withString.navigation();
            } else if (0 != j12) {
                Intent intent = new Intent(context, HBBaseWebActivity.class);
                BaseModuleConfig.a a11 = BaseModuleConfig.a();
                intent.putExtra("url", a11.k("pretender/news-detail-long?id=" + j12));
                if (z11) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        }

        public final void c(long j11, long j12, Context context, boolean z11, boolean z12) {
            if (0 != j11) {
                Postcard withString = b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(j11));
                if (z12) {
                    withString.addFlags(268435456);
                }
                withString.navigation();
            } else if (0 != j12) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("newflashId", String.valueOf(j12));
                intent.putExtra("feedCommentClick", z11);
                if (z12) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        }
    }

    public final class b extends w6.b {
        public b(v6.u uVar) {
            super(uVar);
        }

        public void onHideCustomView() {
            if (DynamicDetailActivity.this.yi() != null) {
                View yi2 = DynamicDetailActivity.this.yi();
                if (yi2 != null) {
                    yi2.setVisibility(8);
                }
                DynamicDetailActivity.Mh(DynamicDetailActivity.this).E.removeView(DynamicDetailActivity.this.yi());
                DynamicDetailActivity.this.setXCustomView((View) null);
                DynamicDetailActivity.Mh(DynamicDetailActivity.this).E.setVisibility(8);
                WebChromeClient.CustomViewCallback Qh = DynamicDetailActivity.this.G;
                if (Qh != null) {
                    Qh.onCustomViewHidden();
                }
                DynamicDetailActivity.Mh(DynamicDetailActivity.this).P.setVisibility(0);
                super.onHideCustomView();
                DynamicDetailActivity.this.onFullscreenEventChanged(false);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            DynamicDetailActivity.Mh(DynamicDetailActivity.this).P.setVisibility(4);
            if (DynamicDetailActivity.this.yi() == null) {
                DynamicDetailActivity.Mh(DynamicDetailActivity.this).E.addView(view);
                DynamicDetailActivity.this.setXCustomView(view);
                DynamicDetailActivity.this.G = customViewCallback;
                DynamicDetailActivity.Mh(DynamicDetailActivity.this).E.setVisibility(0);
                DynamicDetailActivity.this.onFullscreenEventChanged(true);
            } else if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
            }
        }
    }

    public static final class c implements AvatarView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17346a;

        public c(DynamicDetailActivity dynamicDetailActivity) {
            this.f17346a = dynamicDetailActivity;
        }

        public void a() {
            AvatarView.a.C0156a.b(this);
            nc.c.a("app_community_tx", this.f17346a.f17336r);
        }

        public void b(int i11, int i12) {
            AvatarView.a.C0156a.a(this, i11, i12);
        }
    }

    public static final class d implements rc.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f17348b;

        public d(DynamicDetailActivity dynamicDetailActivity, long j11) {
            this.f17347a = dynamicDetailActivity;
            this.f17348b = j11;
        }

        public void a(CommentInfo commentInfo, int i11) {
            if (commentInfo != null) {
                DynamicDetailActivity dynamicDetailActivity = this.f17347a;
                long j11 = this.f17348b;
                CommentListAdapter Lh = dynamicDetailActivity.f17334p;
                if (Lh != null) {
                    Lh.H(0, commentInfo);
                }
                DynamicDetailActivity.Mh(dynamicDetailActivity).G0.setVisibility(8);
                DynamicDetailActivity.Mh(dynamicDetailActivity).H0.setVisibility(8);
                we.c.o(2, j11, (String) null, i11, 0, (CommentInfo) null, false, false, (String) null, 500, (Object) null);
            }
            this.f17347a.Df();
        }

        public void b() {
            this.f17347a.uh(false, true);
            nc.c.a("app_community_tzxqsrfb", this.f17347a.f17336r);
        }
    }

    public static final class e implements com.hbg.module.content.utls.m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17349a;

        public e(DynamicDetailActivity dynamicDetailActivity) {
            this.f17349a = dynamicDetailActivity;
        }

        public void a() {
            m.a.c(this);
            nc.c.a("app_community_jb", this.f17349a.f17336r);
            DialogUtils.S(this.f17349a);
        }

        public void b() {
            m.a.e(this);
        }

        public void c(int i11) {
            m.a.b(this, i11);
        }

        public void d() {
            m.a.d(this);
            this.f17349a.vi();
        }

        public void e() {
            m.a.a(this);
            if (this.f17349a.f17331m == null) {
                this.f17349a.Ai();
            }
            DelDynamicViewModel Fh = this.f17349a.f17331m;
            if (Fh != null) {
                Fh.h(this.f17349a.f17327i);
            }
        }
    }

    public static final class f implements v6.u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17350b;

        public f(DynamicDetailActivity dynamicDetailActivity) {
            this.f17350b = dynamicDetailActivity;
        }

        public void clearNeedLoginAction() {
        }

        public void dismissProgressDialog() {
        }

        public Activity getActivity() {
            return this.f17350b;
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
            return DynamicDetailActivity.Mh(this.f17350b).K0;
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

        public void setHBWebViewLifecycleCallback(v6.t tVar) {
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

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17352c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17353d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f17354e;

        public g(View view, long j11, DynamicDetailActivity dynamicDetailActivity, List list) {
            this.f17351b = view;
            this.f17352c = j11;
            this.f17353d = dynamicDetailActivity;
            this.f17354e = list;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17351b) > this.f17352c || (this.f17351b instanceof Checkable)) {
                sVar.e(this.f17351b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17351b;
                DynamicDetailActivity dynamicDetailActivity = this.f17353d;
                PhotoViewerUtils.a(dynamicDetailActivity, this.f17354e, dynamicDetailActivity.C);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17355b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17356c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17357d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f17358e;

        public h(View view, long j11, DynamicDetailActivity dynamicDetailActivity, List list) {
            this.f17355b = view;
            this.f17356c = j11;
            this.f17357d = dynamicDetailActivity;
            this.f17358e = list;
        }

        public final boolean onLongClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17355b) <= this.f17356c && !(this.f17355b instanceof Checkable)) {
                return true;
            }
            sVar.e(this.f17355b, currentTimeMillis);
            ImageView imageView = (ImageView) this.f17355b;
            if (this.f17357d.C >= this.f17358e.size()) {
                return true;
            }
            DynamicDetailActivity dynamicDetailActivity = this.f17357d;
            SaveImageUtils.h(dynamicDetailActivity, ((ImageData) this.f17358e.get(dynamicDetailActivity.C)).getImage());
            return true;
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17359b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17360c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17361d;

        public i(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17359b = view;
            this.f17360c = j11;
            this.f17361d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17359b) > this.f17360c || (this.f17359b instanceof Checkable)) {
                sVar.e(this.f17359b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17359b;
                DynamicDetailInfo Gh = this.f17361d.f17332n;
                if (!(Gh == null || (shareLink = Gh.getShareLink()) == null || (fg2 = this.f17361d.fg()) == null)) {
                    fg2.g(shareLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17374c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17375d;

        public j(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17373b = view;
            this.f17374c = j11;
            this.f17375d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17373b) > this.f17374c || (this.f17373b instanceof Checkable)) {
                sVar.e(this.f17373b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17373b;
                DynamicDetailInfo Gh = this.f17375d.f17332n;
                if (!(Gh == null || (shareLink = Gh.getShareLink()) == null || (fg2 = this.f17375d.fg()) == null)) {
                    fg2.g(shareLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17376b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17377c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17378d;

        public k(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17376b = view;
            this.f17377c = j11;
            this.f17378d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17376b) > this.f17377c || (this.f17376b instanceof Checkable)) {
                sVar.e(this.f17376b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17376b;
                DynamicDetailInfo Gh = this.f17378d.f17332n;
                if (!(Gh == null || (shareLink = Gh.getShareLink()) == null || (fg2 = this.f17378d.fg()) == null)) {
                    fg2.g(shareLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17380c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17381d;

        public l(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17379b = view;
            this.f17380c = j11;
            this.f17381d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareFromLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17379b) > this.f17380c || (this.f17379b instanceof Checkable)) {
                sVar.e(this.f17379b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17379b;
                DynamicDetailInfo Gh = this.f17381d.f17332n;
                if (!(Gh == null || (shareFromLink = Gh.getShareFromLink()) == null || (fg2 = this.f17381d.fg()) == null)) {
                    fg2.g(shareFromLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class m implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17383c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17384d;

        public m(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17382b = view;
            this.f17383c = j11;
            this.f17384d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareFromLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17382b) > this.f17383c || (this.f17382b instanceof Checkable)) {
                sVar.e(this.f17382b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17382b;
                DynamicDetailInfo Gh = this.f17384d.f17332n;
                if (!(Gh == null || (shareFromLink = Gh.getShareFromLink()) == null || (fg2 = this.f17384d.fg()) == null)) {
                    fg2.g(shareFromLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class n implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17386c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17387d;

        public n(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17385b = view;
            this.f17386c = j11;
            this.f17387d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String shareLink;
            HbgBaseProvider fg2;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17385b) > this.f17386c || (this.f17385b instanceof Checkable)) {
                sVar.e(this.f17385b, currentTimeMillis);
                DynamicDetailInfo Gh = this.f17387d.f17332n;
                if (!(Gh == null || (shareLink = Gh.getShareLink()) == null || (fg2 = this.f17387d.fg()) == null)) {
                    fg2.g(shareLink);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class o implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17389c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17390d;

        public o(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17388b = view;
            this.f17389c = j11;
            this.f17390d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17388b) > this.f17389c || (this.f17388b instanceof Checkable)) {
                sVar.e(this.f17388b, currentTimeMillis);
                TextView textView = (TextView) this.f17388b;
                nc.c.a("app_community_tzxqfz", this.f17390d.f17336r);
                DynamicDetailInfo Gh = this.f17390d.f17332n;
                if (Gh != null) {
                    if (Gh.isTrans()) {
                        DynamicDetailActivity.Wi(this.f17390d, Gh, false, 2, (Object) null);
                    } else if (com.hbg.module.libkt.base.ext.b.x(Gh.getOldContent())) {
                        RequestExtKt.d(v7.b.a().f0(Gh.getId().toString(), 4), new DynamicDetailActivity$initTrans$1$1$1(Gh, this.f17390d), DynamicDetailActivity$initTrans$1$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                    } else {
                        this.f17390d.Vi(Gh, true);
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class p implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17391b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17392c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17393d;

        public p(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17391b = view;
            this.f17392c = j11;
            this.f17393d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17391b) > this.f17392c || (this.f17391b instanceof Checkable)) {
                sVar.e(this.f17391b, currentTimeMillis);
                RoundLinearLayout roundLinearLayout = (RoundLinearLayout) this.f17391b;
                this.f17393d.ri();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class q implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17395c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17396d;

        public q(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17394b = view;
            this.f17395c = j11;
            this.f17396d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17394b) > this.f17395c || (this.f17394b instanceof Checkable)) {
                sVar.e(this.f17394b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17394b;
                nc.c.a("app_community_dz", this.f17396d.f17336r);
                HbgBaseProvider fg2 = this.f17396d.fg();
                boolean z11 = true;
                if (fg2 == null || !fg2.j(this.f17396d)) {
                    z11 = false;
                }
                if (z11) {
                    this.f17396d.ti();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17397b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17398c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17399d;

        public r(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17397b = view;
            this.f17398c = j11;
            this.f17399d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17397b) > this.f17398c || (this.f17397b instanceof Checkable)) {
                sVar.e(this.f17397b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17397b;
                this.f17399d.vi();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class s implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17401c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17402d;

        public s(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17400b = view;
            this.f17401c = j11;
            this.f17402d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17400b) > this.f17401c || (this.f17400b instanceof Checkable)) {
                sVar.e(this.f17400b, currentTimeMillis);
                RadioButton radioButton = (RadioButton) this.f17400b;
                if (this.f17402d.f17340v != 1) {
                    this.f17402d.f17340v = 1;
                    this.f17402d.f17333o = 1;
                    this.f17402d.f17335q = "0";
                    DynamicDetailActivity.Mh(this.f17402d).f19150e0.setNoMoreData(false);
                    this.f17402d.sh();
                    this.f17402d.wi();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class t implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17403b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17404c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17405d;

        public t(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17403b = view;
            this.f17404c = j11;
            this.f17405d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17403b) > this.f17404c || (this.f17403b instanceof Checkable)) {
                sVar.e(this.f17403b, currentTimeMillis);
                RadioButton radioButton = (RadioButton) this.f17403b;
                if (this.f17405d.f17340v == 1) {
                    this.f17405d.f17340v = 2;
                    this.f17405d.f17333o = 1;
                    this.f17405d.f17335q = "0";
                    DynamicDetailActivity.Mh(this.f17405d).f19150e0.setNoMoreData(false);
                    this.f17405d.sh();
                    this.f17405d.wi();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class u extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17406b;

        public u(DynamicDetailActivity dynamicDetailActivity) {
            this.f17406b = dynamicDetailActivity;
        }

        public void onViewClick(View view) {
            this.f17406b.wi();
        }
    }

    public static final class v extends MarketOverviewListenerV2 {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17407d;

        public v(DynamicDetailActivity dynamicDetailActivity) {
            this.f17407d = dynamicDetailActivity;
        }

        /* renamed from: j */
        public void f(MarketOverviewV2Response marketOverviewV2Response) {
            Map map = marketOverviewV2Response != null ? (Map) marketOverviewV2Response.getData() : null;
            if (map == null) {
                map = MapsKt__MapsKt.h();
            }
            if (!map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    SymbolPriceV2 symbolPriceV2 = (SymbolPriceV2) entry.getValue();
                    if (symbolPriceV2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("decimalcPrice", symbolPriceV2.getClose());
                        jSONObject2.put("decimalDelta", Double.valueOf(symbolPriceV2.getRise().doubleValue() * ((double) 100)));
                        jSONObject2.put("strAmount", symbolPriceV2.getAmount());
                        jSONObject2.put("symbol", symbolPriceV2.getSymbol());
                        jSONObject.put(str, jSONObject2);
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", PrimeRounds.ROUND_TRADE_MARKET_TYPE);
                jSONObject3.put("data", jSONObject);
                rj.b Ih = this.f17407d.f17342x;
                if (Ih != null) {
                    Ih.I("sendSocketData(" + jSONObject3 + ')');
                }
            }
        }
    }

    public static final class w extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.Topic f17408b;

        public w(CommunityFeedInfo.Topic topic) {
            this.f17408b = topic;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/content/topicDetail").withString(CommunityConstants.TOPIC_ID, String.valueOf(this.f17408b.getTopicId())).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static final class x implements z, kotlin.jvm.internal.u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f17409b;

        public x(d10.l lVar) {
            this.f17409b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof kotlin.jvm.internal.u)) {
                return false;
            }
            return kotlin.jvm.internal.x.b(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f17409b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17409b.invoke(obj);
        }
    }

    public static final class y extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RichTextBean f17410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17411c;

        public y(RichTextBean richTextBean, DynamicDetailActivity dynamicDetailActivity) {
            this.f17410b = richTextBean;
            this.f17411c = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/webView/index").withString("url", this.f17410b.data.url).navigation(this.f17411c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int color = this.f17411c.getResources().getColor(R$color.baseColorMajorTheme100);
            textPaint.setUnderlineText(false);
            textPaint.setColor(color);
        }
    }

    public static /* synthetic */ void Ei(DynamicDetailActivity dynamicDetailActivity, RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            spannableStringBuilder = null;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        dynamicDetailActivity.Di(richTextBean, spannableStringBuilder, i11);
    }

    @SensorsDataInstrumented
    public static final void Hi(DynamicDetailActivity dynamicDetailActivity, View view) {
        ((lc.c) dynamicDetailActivity.Yf()).R.p();
        DynamicDetailViewModel dynamicDetailViewModel = dynamicDetailActivity.f17330l;
        if (dynamicDetailViewModel != null) {
            dynamicDetailViewModel.i0(dynamicDetailActivity.f17327i);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Li(DynamicDetailActivity dynamicDetailActivity, String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        if (jSONObject.getInt("width") > jSONObject.getInt("height") && dynamicDetailActivity.inCustomView()) {
            dynamicDetailActivity.setRequestedOrientation(0);
        }
    }

    public static final /* synthetic */ lc.c Mh(DynamicDetailActivity dynamicDetailActivity) {
        return (lc.c) dynamicDetailActivity.Yf();
    }

    public static /* synthetic */ void Wi(DynamicDetailActivity dynamicDetailActivity, DynamicDetailInfo dynamicDetailInfo, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        dynamicDetailActivity.Vi(dynamicDetailInfo, z11);
    }

    public final void Ai() {
        MutableLiveData<VmState<Object>> h02;
        DelDynamicViewModel delDynamicViewModel = (DelDynamicViewModel) new ViewModelProvider(this).a(DelDynamicViewModel.class);
        this.f17331m = delDynamicViewModel;
        if (delDynamicViewModel != null && (h02 = delDynamicViewModel.h0()) != null) {
            h02.observe(this, new x(new DynamicDetailActivity$initDelVM$1(this)));
        }
    }

    public final void Bi() {
        this.f17341w = new f(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r0 != null && r0.getType() == 8) != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ci() {
        /*
            r4 = this;
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r4.f17332n
            if (r0 == 0) goto L_0x0009
            java.util.List r0 = r0.getImgList()
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            boolean r0 = com.hbg.module.libkt.base.ext.b.w(r0)
            if (r0 != 0) goto L_0x0085
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            com.hbg.module.community.widgets.CommunityImageLayout r0 = r0.H
            r1 = 1
            r0.setDetailPage(r1)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r4.f17332n
            r2 = 0
            if (r0 == 0) goto L_0x002a
            int r0 = r0.getShareType()
            r3 = 6
            if (r0 != r3) goto L_0x002a
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r0 = r2
        L_0x002b:
            if (r0 != 0) goto L_0x003e
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r4.f17332n
            if (r0 == 0) goto L_0x003b
            int r0 = r0.getType()
            r3 = 8
            if (r0 != r3) goto L_0x003b
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            if (r0 == 0) goto L_0x0049
        L_0x003e:
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            com.hbg.module.community.widgets.CommunityImageLayout r0 = r0.H
            r0.setLive(r1)
        L_0x0049:
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            com.hbg.module.community.widgets.CommunityImageLayout r0 = r0.H
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r4.f17332n
            java.util.List r1 = r1.getImgList()
            r0.a(r1)
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            com.hbg.module.community.widgets.CommunityImageLayout r0 = r0.H
            com.hbg.module.community.ui.DynamicDetailActivity$initPics$1 r1 = new com.hbg.module.community.ui.DynamicDetailActivity$initPics$1
            r1.<init>(r4)
            r0.setOnImageClick(r1)
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            com.hbg.module.community.widgets.CommunityImageLayout r0 = r0.H
            com.hbg.module.community.ui.DynamicDetailActivity$initPics$2 r1 = new com.hbg.module.community.ui.DynamicDetailActivity$initPics$2
            r1.<init>(r4)
            r0.setOnImageLongClick(r1)
            x1.a r0 = r4.Yf()
            lc.c r0 = (lc.c) r0
            android.widget.RelativeLayout r0 = r0.f19147b0
            r0.setVisibility(r2)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.DynamicDetailActivity.Ci():void");
    }

    public final void Di(RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder, int i11) {
        List<CommunityFeedInfo.imgListBean> imgList;
        TextView textView;
        TextView textView2;
        String str = richTextBean.type;
        if (str != null) {
            switch (str.hashCode()) {
                case -2143265644:
                    if (str.equals("mention-currency") && spannableStringBuilder != null) {
                        Ti(spannableStringBuilder, richTextBean, " $");
                        return;
                    }
                    return;
                case 100313435:
                    if (str.equals("image")) {
                        try {
                            SpannableStringBuilder spannableStringBuilder2 = this.A;
                            if (!(spannableStringBuilder2 == null || (textView = this.B) == null)) {
                                if (textView != null) {
                                    textView.setText(spannableStringBuilder2);
                                }
                                ((lc.c) Yf()).S.addView(this.B);
                                this.A = null;
                            }
                            CommunityFeedInfo.imgListBean imglistbean = this.f17332n.getImgList().get(this.C);
                            float height = (((float) imglistbean.getHeight()) / ((float) imglistbean.getWidth())) * ((float) (com.hbg.module.libkt.base.ext.c.c() - sd.a.b(Float.valueOf(32.0f))));
                            ImageView imageView = new ImageView(this);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) height);
                            ArrayList arrayList = new ArrayList();
                            DynamicDetailInfo dynamicDetailInfo = this.f17332n;
                            if (!(dynamicDetailInfo == null || (imgList = dynamicDetailInfo.getImgList()) == null)) {
                                for (CommunityFeedInfo.imgListBean imglistbean2 : imgList) {
                                    arrayList.add(new ImageData(imglistbean2.getImage(), imglistbean2.getThumbImage()));
                                }
                            }
                            rd.s sVar = rd.s.f23381a;
                            imageView.setOnClickListener(new g(imageView, 800, this, arrayList));
                            imageView.setOnLongClickListener(new h(imageView, 800, this, arrayList));
                            layoutParams.topMargin = sd.a.b(Float.valueOf(5.0f));
                            imageView.setLayoutParams(layoutParams);
                            com.hbg.module.libkt.base.ext.b.L(imageView, imglistbean.getImage(), 4.0f);
                            ((lc.c) Yf()).S.addView(imageView);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        this.C++;
                        return;
                    }
                    return;
                case 712568052:
                    if (str.equals("mention-follow") && spannableStringBuilder != null) {
                        Ti(spannableStringBuilder, richTextBean, " @");
                        return;
                    }
                    return;
                case 1949288814:
                    if (str.equals("paragraph")) {
                        if (this.A == null) {
                            this.A = new SpannableStringBuilder();
                            this.B = new TextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            if (((lc.c) Yf()).S.getChildCount() > 0) {
                                layoutParams2.topMargin = sd.a.b(Float.valueOf(10.0f));
                            }
                            TextView textView3 = this.B;
                            if (textView3 != null) {
                                textView3.setLayoutParams(layoutParams2);
                            }
                            TextView textView4 = this.B;
                            if (textView4 != null) {
                                textView4.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
                            }
                            TextView textView5 = this.B;
                            if (textView5 != null) {
                                textView5.setTextSize(2, 16.0f);
                            }
                            if (Build.VERSION.SDK_INT >= 28 && (textView2 = this.B) != null) {
                                textView2.setLineHeight(sd.a.b(Float.valueOf(24.0f)));
                            }
                            TextView textView6 = this.B;
                            if (textView6 != null) {
                                textView6.setMovementMethod(new LinkMovementMethod());
                            }
                        }
                        if (!com.hbg.module.libkt.base.ext.b.w(richTextBean.children)) {
                            Iterator<RichTextBean> it2 = richTextBean.children.iterator();
                            while (it2.hasNext()) {
                                Di(it2.next(), this.A, richTextBean.children.size());
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1963154312:
                    if (str.equals("mention-task") && spannableStringBuilder != null) {
                        richTextBean.character += n0.h.f32179b;
                        Ti(spannableStringBuilder, richTextBean, " #");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (!TextUtils.isEmpty(richTextBean.text)) {
            if (spannableStringBuilder != null) {
                spannableStringBuilder.append(richTextBean.text);
            }
        } else if (i11 == 1 && spannableStringBuilder != null) {
            spannableStringBuilder.append("\n");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:219:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0523  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0540  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Fi() {
        /*
            r16 = this;
            r0 = r16
            x1.a r1 = r16.Yf()
            lc.c r1 = (lc.c) r1
            lc.i3 r1 = r1.f19151f0
            android.view.View r1 = r1.getRoot()
            int r2 = com.hbg.module.content.R$id.ivShareAvatar
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            x1.a r2 = r16.Yf()
            lc.c r2 = (lc.c) r2
            lc.i3 r2 = r2.f19151f0
            android.view.View r2 = r2.getRoot()
            int r3 = com.hbg.module.content.R$id.atvSource
            android.view.View r2 = r2.findViewById(r3)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            x1.a r3 = r16.Yf()
            lc.c r3 = (lc.c) r3
            lc.i3 r3 = r3.f19151f0
            android.view.View r3 = r3.getRoot()
            int r4 = com.hbg.module.content.R$id.atvShareTitle
            android.view.View r3 = r3.findViewById(r4)
            androidx.appcompat.widget.AppCompatTextView r3 = (androidx.appcompat.widget.AppCompatTextView) r3
            x1.a r4 = r16.Yf()
            lc.c r4 = (lc.c) r4
            lc.i3 r4 = r4.f19151f0
            android.view.View r4 = r4.getRoot()
            int r5 = com.hbg.module.content.R$id.atvShareContent
            android.view.View r4 = r4.findViewById(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            x1.a r5 = r16.Yf()
            lc.c r5 = (lc.c) r5
            lc.i3 r5 = r5.f19151f0
            android.view.View r5 = r5.getRoot()
            int r6 = com.hbg.module.content.R$id.ivPic
            android.view.View r5 = r5.findViewById(r6)
            r6 = r5
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            x1.a r5 = r16.Yf()
            lc.c r5 = (lc.c) r5
            lc.i3 r5 = r5.f19151f0
            android.view.View r5 = r5.getRoot()
            int r7 = com.hbg.module.content.R$id.llDefaultContent
            android.view.View r5 = r5.findViewById(r7)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            lc.i3 r7 = r7.f19151f0
            android.view.View r7 = r7.getRoot()
            int r8 = com.hbg.module.content.R$id.llEngineContent
            android.view.View r7 = r7.findViewById(r8)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r8 = 0
            r5.setVisibility(r8)
            r9 = 8
            r7.setVisibility(r9)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r10 = r0.f17332n
            if (r10 == 0) goto L_0x00a5
            int r10 = r10.getShareType()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x00a6
        L_0x00a5:
            r10 = 0
        L_0x00a6:
            r12 = 6
            r14 = 800(0x320, double:3.953E-321)
            r13 = 1
            if (r10 != 0) goto L_0x00ad
            goto L_0x00e6
        L_0x00ad:
            int r11 = r10.intValue()
            if (r11 != r13) goto L_0x00e6
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x00bd
        L_0x00bc:
            r5 = 0
        L_0x00bd:
            if (r5 == 0) goto L_0x00cc
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x00c8
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            com.hbg.module.libkt.base.ext.b.J(r1, r5)
        L_0x00cc:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x00d5
            java.lang.String r1 = r1.getShareFrom()
            goto L_0x00d6
        L_0x00d5:
            r1 = 0
        L_0x00d6:
            r2.setText(r1)
            rd.s r1 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity$i r1 = new com.hbg.module.community.ui.DynamicDetailActivity$i
            r1.<init>(r2, r14, r0)
            r2.setOnClickListener(r1)
        L_0x00e3:
            r8 = 0
            goto L_0x04b0
        L_0x00e6:
            r11 = 2
            if (r10 != 0) goto L_0x00ea
            goto L_0x0125
        L_0x00ea:
            int r8 = r10.intValue()
            if (r8 != r11) goto L_0x0125
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x00f9
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x00fa
        L_0x00f9:
            r5 = 0
        L_0x00fa:
            boolean r5 = com.hbg.module.libkt.base.ext.b.x(r5)
            if (r5 != 0) goto L_0x010d
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x0109
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x010a
        L_0x0109:
            r5 = 0
        L_0x010a:
            com.hbg.module.libkt.base.ext.b.J(r1, r5)
        L_0x010d:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x0116
            java.lang.String r1 = r1.getShareFrom()
            goto L_0x0117
        L_0x0116:
            r1 = 0
        L_0x0117:
            r2.setText(r1)
            rd.s r1 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity$j r1 = new com.hbg.module.community.ui.DynamicDetailActivity$j
            r1.<init>(r2, r14, r0)
            r2.setOnClickListener(r1)
            goto L_0x00e3
        L_0x0125:
            r8 = 4
            if (r10 != 0) goto L_0x0129
            goto L_0x0131
        L_0x0129:
            int r14 = r10.intValue()
            if (r14 != r8) goto L_0x0131
        L_0x012f:
            r8 = r13
            goto L_0x013c
        L_0x0131:
            if (r10 != 0) goto L_0x0134
            goto L_0x013b
        L_0x0134:
            int r8 = r10.intValue()
            if (r8 != r12) goto L_0x013b
            goto L_0x012f
        L_0x013b:
            r8 = 0
        L_0x013c:
            if (r8 == 0) goto L_0x0333
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x014a
            int r5 = r5.getShareType()
            if (r5 != r12) goto L_0x014a
            r5 = r13
            goto L_0x014b
        L_0x014a:
            r5 = 0
        L_0x014b:
            if (r5 == 0) goto L_0x030b
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x0159
            int r5 = r5.getType()
            if (r5 != r9) goto L_0x0159
            r5 = r13
            goto L_0x015a
        L_0x0159:
            r5 = 0
        L_0x015a:
            if (r5 == 0) goto L_0x02fe
            x1.a r5 = r16.Yf()
            lc.c r5 = (lc.c) r5
            lc.i3 r5 = r5.f19151f0
            android.view.View r5 = r5.getRoot()
            r5.setVisibility(r9)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r5 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean
            r5.<init>()
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r7 = r0.f17332n
            if (r7 == 0) goto L_0x0177
            java.lang.String r7 = r7.extend
            goto L_0x0178
        L_0x0177:
            r7 = 0
        L_0x0178:
            boolean r7 = com.hbg.module.libkt.base.ext.b.x(r7)
            if (r7 != 0) goto L_0x02c9
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r7 = r0.f17332n
            java.lang.String r7 = r7.extend
            com.hbg.module.community.ui.DynamicDetailActivity$initShareView$$inlined$gsonToBean$1 r8 = new com.hbg.module.community.ui.DynamicDetailActivity$initShareView$$inlined$gsonToBean$1
            r8.<init>()
            java.lang.reflect.Type r8 = r8.getType()
            com.google.gson.Gson r10 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r7 = r10.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r8)
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r7 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r7
            if (r7 == 0) goto L_0x019a
            java.lang.String r8 = r7.coverImageUrl
            goto L_0x019b
        L_0x019a:
            r8 = 0
        L_0x019b:
            r5.setImage(r8)
            if (r7 == 0) goto L_0x01a3
            java.lang.String r8 = r7.coverImageUrl
            goto L_0x01a4
        L_0x01a3:
            r8 = 0
        L_0x01a4:
            r5.setThumbImage(r8)
            r5.setWidth(r11)
            r5.setHeight(r13)
            if (r7 == 0) goto L_0x01b5
            int r8 = r7.status
            if (r8 != r11) goto L_0x01b5
            r8 = r13
            goto L_0x01b6
        L_0x01b5:
            r8 = 0
        L_0x01b6:
            if (r8 == 0) goto L_0x0209
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.TextView r8 = r8.f19163w0
            kotlin.jvm.internal.d0 r10 = kotlin.jvm.internal.d0.f56774a
            android.content.res.Resources r10 = r16.getResources()
            int r11 = com.hbg.module.content.R$string.n_content_live_watch
            java.lang.String r10 = r10.getString(r11)
            java.lang.Object[] r11 = new java.lang.Object[r13]
            java.lang.String r7 = r7.onlineNum
            java.lang.String r7 = he.b.e(r7)
            r14 = 0
            r11[r14] = r7
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r11, r13)
            java.lang.String r7 = java.lang.String.format(r10, r7)
            r8.setText(r7)
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            android.widget.LinearLayout r7 = r7.Q
            int r8 = com.hbg.module.content.R$drawable.bg_live_broadcast_tips
            r7.setBackgroundResource(r8)
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            android.widget.ImageView r7 = r7.M
            r7.setVisibility(r9)
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            com.hbg.lib.widgets.SafeLottieView r7 = r7.f19152g0
            r8 = 0
            r7.setVisibility(r8)
            r14 = r8
            goto L_0x02bd
        L_0x0209:
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.LinearLayout r8 = r8.Q
            int r10 = com.hbg.module.content.R$drawable.bg_live_playback_tips
            r8.setBackgroundResource(r10)
            if (r7 == 0) goto L_0x021e
            int r8 = r7.status
            if (r8 != r13) goto L_0x021e
            r8 = r13
            goto L_0x021f
        L_0x021e:
            r8 = 0
        L_0x021f:
            if (r8 == 0) goto L_0x0268
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.ImageView r8 = r8.M
            int r10 = com.hbg.module.content.R$drawable.ic_live_appointment
            r8.setImageResource(r10)
            android.content.res.Resources r8 = r16.getResources()
            int r10 = com.hbg.module.content.R$string.n_content_live_play_time2
            java.lang.String r8 = r8.getString(r10)
            long r14 = r7.startTime
            java.lang.String r10 = "MM-dd HH:mm"
            java.lang.String r10 = com.hbg.lib.common.utils.DateTimeUtils.h(r14, r10)
            int r7 = r7.appointedNum
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = he.b.e(r7)
            kotlin.jvm.internal.d0 r14 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r14 = new java.lang.Object[r11]
            r15 = 0
            r14[r15] = r10
            r14[r13] = r7
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r14, r11)
            java.lang.String r7 = java.lang.String.format(r8, r7)
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.TextView r8 = r8.f19163w0
            r8.setText(r7)
            r14 = 0
            goto L_0x02a7
        L_0x0268:
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.ImageView r8 = r8.M
            int r10 = com.hbg.module.content.R$drawable.ic_live_playback
            r8.setImageResource(r10)
            x1.a r8 = r16.Yf()
            lc.c r8 = (lc.c) r8
            android.widget.TextView r8 = r8.f19163w0
            kotlin.jvm.internal.d0 r10 = kotlin.jvm.internal.d0.f56774a
            android.content.res.Resources r10 = r16.getResources()
            int r11 = com.hbg.module.content.R$string.n_content_live_watched
            java.lang.String r10 = r10.getString(r11)
            if (r10 != 0) goto L_0x028d
            java.lang.String r10 = "%s"
        L_0x028d:
            java.lang.Object[] r11 = new java.lang.Object[r13]
            if (r7 == 0) goto L_0x0294
            java.lang.String r7 = r7.onlineNum
            goto L_0x0295
        L_0x0294:
            r7 = 0
        L_0x0295:
            java.lang.String r7 = he.b.e(r7)
            r14 = 0
            r11[r14] = r7
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r11, r13)
            java.lang.String r7 = java.lang.String.format(r10, r7)
            r8.setText(r7)
        L_0x02a7:
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            android.widget.ImageView r7 = r7.M
            r7.setVisibility(r14)
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            com.hbg.lib.widgets.SafeLottieView r7 = r7.f19152g0
            r7.setVisibility(r9)
        L_0x02bd:
            x1.a r7 = r16.Yf()
            lc.c r7 = (lc.c) r7
            android.widget.LinearLayout r7 = r7.Q
            r7.setVisibility(r14)
            goto L_0x02e9
        L_0x02c9:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r7 = r0.f17332n
            if (r7 == 0) goto L_0x02d2
            java.lang.String r7 = r7.getShareImage()
            goto L_0x02d3
        L_0x02d2:
            r7 = 0
        L_0x02d3:
            r5.setImage(r7)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r7 = r0.f17332n
            if (r7 == 0) goto L_0x02df
            java.lang.String r7 = r7.getShareImage()
            goto L_0x02e0
        L_0x02df:
            r7 = 0
        L_0x02e0:
            r5.setThumbImage(r7)
            r5.setWidth(r11)
            r5.setHeight(r13)
        L_0x02e9:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r7 = r0.f17332n
            if (r7 != 0) goto L_0x02ee
            goto L_0x02fa
        L_0x02ee:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean[] r8 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean[r13]
            r10 = 0
            r8[r10] = r5
            java.util.ArrayList r5 = kotlin.collections.CollectionsKt__CollectionsKt.g(r8)
            r7.setImgList(r5)
        L_0x02fa:
            r16.Ci()
            goto L_0x0317
        L_0x02fe:
            rd.s r5 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity$k r5 = new com.hbg.module.community.ui.DynamicDetailActivity$k
            r7 = 800(0x320, double:3.953E-321)
            r5.<init>(r2, r7, r0)
            r2.setOnClickListener(r5)
            goto L_0x0317
        L_0x030b:
            r7 = 800(0x320, double:3.953E-321)
            rd.s r5 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity$l r5 = new com.hbg.module.community.ui.DynamicDetailActivity$l
            r5.<init>(r2, r7, r0)
            r2.setOnClickListener(r5)
        L_0x0317:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x0320
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x0321
        L_0x0320:
            r5 = 0
        L_0x0321:
            com.hbg.module.libkt.base.ext.b.J(r1, r5)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x032d
            java.lang.String r1 = r1.getShareFrom()
            goto L_0x032e
        L_0x032d:
            r1 = 0
        L_0x032e:
            r2.setText(r1)
            goto L_0x00e3
        L_0x0333:
            r8 = 18
            if (r10 != 0) goto L_0x0338
            goto L_0x0385
        L_0x0338:
            int r11 = r10.intValue()
            if (r11 != r8) goto L_0x0385
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x0347
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x0348
        L_0x0347:
            r5 = 0
        L_0x0348:
            if (r5 == 0) goto L_0x0357
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x0353
            java.lang.String r5 = r5.getShareFromAvatar()
            goto L_0x0354
        L_0x0353:
            r5 = 0
        L_0x0354:
            com.hbg.module.libkt.base.ext.b.J(r1, r5)
        L_0x0357:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x0360
            java.lang.String r1 = r1.getShareFrom()
            goto L_0x0361
        L_0x0360:
            r1 = 0
        L_0x0361:
            r2.setText(r1)
            android.content.res.Resources r1 = r16.getResources()
            int r5 = com.hbg.module.content.R$color.baseColorSecondaryText
            r8 = 0
            int r1 = androidx.core.content.res.ResourcesCompat.d(r1, r5, r8)
            r4.setTextColor(r1)
            r1 = 1094713344(0x41400000, float:12.0)
            r4.setTextSize(r13, r1)
            rd.s r1 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity$m r1 = new com.hbg.module.community.ui.DynamicDetailActivity$m
            r10 = 800(0x320, double:3.953E-321)
            r1.<init>(r2, r10, r0)
            r2.setOnClickListener(r1)
            goto L_0x04b0
        L_0x0385:
            r8 = 0
            r1 = 20
            r2 = 5
            java.lang.String r11 = "')"
            if (r10 != 0) goto L_0x038f
            goto L_0x041e
        L_0x038f:
            int r14 = r10.intValue()
            if (r14 != r1) goto L_0x041e
            r5.setVisibility(r9)
            r1 = 0
            r7.setVisibility(r1)
            r7.removeAllViews()
            nc.a r1 = nc.a.f19345a
            rj.b r1 = r1.a()
            r0.f17343y = r1
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x03b3
            int r1 = r1.getShowTag()
            if (r1 != r2) goto L_0x03b3
            r1 = r13
            goto L_0x03b4
        L_0x03b3:
            r1 = 0
        L_0x03b4:
            if (r1 == 0) goto L_0x03ea
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x03c1
            java.lang.String r2 = "copytrading_trader_card.xml"
            android.view.View r1 = r1.D(r2, r0)
            goto L_0x03c2
        L_0x03c1:
            r1 = r8
        L_0x03c2:
            r7.addView(r1)
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x04b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "traderCard.initTraderCardItem('"
            r2.append(r5)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x03da
            java.lang.String r5 = r5.extend
            goto L_0x03db
        L_0x03da:
            r5 = r8
        L_0x03db:
            r2.append(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.I(r2)
            goto L_0x04b0
        L_0x03ea:
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x03f5
            java.lang.String r2 = "copytrading_trader_share_card.xml"
            android.view.View r1 = r1.D(r2, r0)
            goto L_0x03f6
        L_0x03f5:
            r1 = r8
        L_0x03f6:
            r7.addView(r1)
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x04b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "traderShareCard.initTraderShareCardItem('"
            r2.append(r5)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x040e
            java.lang.String r5 = r5.extend
            goto L_0x040f
        L_0x040e:
            r5 = r8
        L_0x040f:
            r2.append(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.I(r2)
            goto L_0x04b0
        L_0x041e:
            r1 = 21
            if (r10 != 0) goto L_0x0424
            goto L_0x04b0
        L_0x0424:
            int r10 = r10.intValue()
            if (r10 != r1) goto L_0x04b0
            r5.setVisibility(r9)
            r1 = 0
            r7.setVisibility(r1)
            r7.removeAllViews()
            nc.a r1 = nc.a.f19345a
            rj.b r1 = r1.a()
            r0.f17343y = r1
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x0448
            int r1 = r1.getShowTag()
            if (r1 != r2) goto L_0x0448
            r1 = r13
            goto L_0x0449
        L_0x0448:
            r1 = 0
        L_0x0449:
            if (r1 == 0) goto L_0x047e
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x0456
            java.lang.String r2 = "copytrading_follower_card.xml"
            android.view.View r1 = r1.D(r2, r0)
            goto L_0x0457
        L_0x0456:
            r1 = r8
        L_0x0457:
            r7.addView(r1)
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x04b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "followerCard.initFollowerCardItem('"
            r2.append(r5)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x046f
            java.lang.String r5 = r5.extend
            goto L_0x0470
        L_0x046f:
            r5 = r8
        L_0x0470:
            r2.append(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.I(r2)
            goto L_0x04b0
        L_0x047e:
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x0489
            java.lang.String r2 = "copytrading_follower_share_card.xml"
            android.view.View r1 = r1.D(r2, r0)
            goto L_0x048a
        L_0x0489:
            r1 = r8
        L_0x048a:
            r7.addView(r1)
            rj.b r1 = r0.f17343y
            if (r1 == 0) goto L_0x04b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "followerShareCard.initFollowerShareCardItem('"
            r2.append(r5)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r5 = r0.f17332n
            if (r5 == 0) goto L_0x04a2
            java.lang.String r5 = r5.extend
            goto L_0x04a3
        L_0x04a2:
            r5 = r8
        L_0x04a3:
            r2.append(r5)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.I(r2)
        L_0x04b0:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x04b9
            java.lang.String r1 = r1.getShareLinkTitle()
            goto L_0x04ba
        L_0x04b9:
            r1 = r8
        L_0x04ba:
            boolean r1 = com.hbg.module.libkt.base.ext.b.x(r1)
            if (r1 != 0) goto L_0x051f
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x04cc
            int r1 = r1.getShareType()
            if (r1 != r12) goto L_0x04cc
            r1 = r13
            goto L_0x04cd
        L_0x04cc:
            r1 = 0
        L_0x04cd:
            if (r1 == 0) goto L_0x050f
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x04d6
            java.lang.String r1 = r1.extend
            goto L_0x04d7
        L_0x04d6:
            r1 = r8
        L_0x04d7:
            boolean r1 = com.hbg.module.libkt.base.ext.b.x(r1)
            if (r1 != 0) goto L_0x050f
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x04e4
            java.lang.String r1 = r1.extend
            goto L_0x04e5
        L_0x04e4:
            r1 = r8
        L_0x04e5:
            com.hbg.module.community.ui.DynamicDetailActivity$initShareView$$inlined$gsonToBean$2 r2 = new com.hbg.module.community.ui.DynamicDetailActivity$initShareView$$inlined$gsonToBean$2
            r2.<init>()
            java.lang.reflect.Type r2 = r2.getType()
            com.google.gson.Gson r5 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r1 = r5.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r2)
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r1
            if (r1 == 0) goto L_0x04fd
            java.lang.String r2 = r1.title
            goto L_0x04fe
        L_0x04fd:
            r2 = r8
        L_0x04fe:
            r3.setText(r2)
            if (r1 == 0) goto L_0x0506
            java.lang.String r1 = r1.introduction
            goto L_0x0507
        L_0x0506:
            r1 = r8
        L_0x0507:
            r4.setText(r1)
            r1 = 0
            r3.setVisibility(r1)
            goto L_0x051f
        L_0x050f:
            r3.setVisibility(r9)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x051b
            java.lang.String r1 = r1.getShareLinkTitle()
            goto L_0x051c
        L_0x051b:
            r1 = r8
        L_0x051c:
            r4.setText(r1)
        L_0x051f:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x0528
            java.lang.String r1 = r1.getShareImage()
            goto L_0x0529
        L_0x0528:
            r1 = r8
        L_0x0529:
            if (r1 == 0) goto L_0x0534
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0532
            goto L_0x0534
        L_0x0532:
            r14 = 0
            goto L_0x0535
        L_0x0534:
            r14 = r13
        L_0x0535:
            if (r14 == 0) goto L_0x0540
            if (r6 != 0) goto L_0x053b
            goto L_0x05b2
        L_0x053b:
            r6.setVisibility(r9)
            goto L_0x05b2
        L_0x0540:
            r1 = 0
            if (r6 != 0) goto L_0x0544
            goto L_0x0547
        L_0x0544:
            r6.setVisibility(r1)
        L_0x0547:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r0.f17332n
            if (r2 == 0) goto L_0x0552
            int r2 = r2.getShareType()
            if (r2 != r12) goto L_0x0552
            r1 = r13
        L_0x0552:
            if (r1 == 0) goto L_0x0566
            if (r6 == 0) goto L_0x055b
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            goto L_0x055c
        L_0x055b:
            r1 = r8
        L_0x055c:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r1
            if (r1 != 0) goto L_0x0561
            goto L_0x0577
        L_0x0561:
            java.lang.String r2 = "W,16:9"
            r1.H = r2
            goto L_0x0577
        L_0x0566:
            if (r6 == 0) goto L_0x056d
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            goto L_0x056e
        L_0x056d:
            r1 = r8
        L_0x056e:
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r1
            if (r1 != 0) goto L_0x0573
            goto L_0x0577
        L_0x0573:
            java.lang.String r2 = "W,343:220"
            r1.H = r2
        L_0x0577:
            com.hbg.lib.core.util.NightHelper r1 = com.hbg.lib.core.util.NightHelper.e()
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x059a
            if (r6 == 0) goto L_0x05b2
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x058d
            java.lang.String r1 = r1.getShareImage()
            r7 = r1
            goto L_0x058e
        L_0x058d:
            r7 = r8
        L_0x058e:
            int r8 = com.hbg.module.content.R$drawable.ic_community_feed_placeholder_night
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 28
            r13 = 0
            com.hbg.module.libkt.base.ext.b.G(r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x05b2
        L_0x059a:
            if (r6 == 0) goto L_0x05b2
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r0.f17332n
            if (r1 == 0) goto L_0x05a6
            java.lang.String r1 = r1.getShareImage()
            r7 = r1
            goto L_0x05a7
        L_0x05a6:
            r7 = r8
        L_0x05a7:
            int r8 = com.hbg.module.content.R$drawable.ic_community_feed_placeholder_light
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 28
            r13 = 0
            com.hbg.module.libkt.base.ext.b.G(r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x05b2:
            rd.s r1 = rd.s.f23381a
            x1.a r1 = r16.Yf()
            lc.c r1 = (lc.c) r1
            lc.i3 r1 = r1.f19151f0
            android.view.View r1 = r1.getRoot()
            com.hbg.module.community.ui.DynamicDetailActivity$n r2 = new com.hbg.module.community.ui.DynamicDetailActivity$n
            r3 = 800(0x320, double:3.953E-321)
            r2.<init>(r1, r3, r0)
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.DynamicDetailActivity.Fi():void");
    }

    public final void Gi() {
        rd.s sVar = rd.s.f23381a;
        TextView textView = ((lc.c) Yf()).F0;
        textView.setOnClickListener(new o(textView, 800, this));
    }

    public final void Ii() {
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        if (z11 && this.f17328j && this.f17329k) {
            si();
        }
    }

    public void J7(int i11) {
        nc.c.a("app_community_tzxqplzk", this.f17336r);
    }

    public final void Ji() {
        if (this.f17328j && this.f17329k) {
            ((lc.c) Yf()).V.setExpanded(false, true);
        }
    }

    public final void Ki(String str) {
        i6.d.c("动态详情", str);
    }

    public final void Mi() {
        TextView textView;
        DynamicDetailInfo dynamicDetailInfo = this.f17332n;
        List<RichTextBean> c11 = rd.d.f23353a.c(dynamicDetailInfo != null ? dynamicDetailInfo.getContentText() : null, RichTextBean.class);
        ((lc.c) Yf()).f19157l0.setVisibility(8);
        ((lc.c) Yf()).S.setVisibility(0);
        if (!com.hbg.module.libkt.base.ext.b.w(c11)) {
            ((lc.c) Yf()).S.removeAllViews();
            for (RichTextBean Ei : c11) {
                Ei(this, Ei, (SpannableStringBuilder) null, 0, 6, (Object) null);
            }
            SpannableStringBuilder spannableStringBuilder = this.A;
            if (!(spannableStringBuilder == null || (textView = this.B) == null)) {
                if (textView != null) {
                    textView.setText(spannableStringBuilder);
                }
                ((lc.c) Yf()).S.addView(this.B);
                this.A = null;
            }
            this.C = 0;
        }
    }

    public final void Ni() {
        we.c.a(this, new x(new DynamicDetailActivity$registerBus$1(this)));
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(this, new x(new DynamicDetailActivity$registerBus$2(this)));
    }

    public final void Oi(AvatarView... avatarViewArr) {
        PersonalCenterInfo.UcExtInfo ucExtInfo;
        PersonalCenterInfo.UcExtInfo ucExtInfo2;
        PersonalCenterInfo.UcExtInfo ucExtInfo3;
        for (AvatarView avatarView : CollectionsKt___CollectionsKt.X(ArraysKt___ArraysJvmKt.d(avatarViewArr))) {
            DynamicDetailInfo dynamicDetailInfo = this.f17332n;
            boolean z11 = false;
            int isAlive = dynamicDetailInfo != null ? dynamicDetailInfo.getIsAlive() : 0;
            DynamicDetailInfo dynamicDetailInfo2 = this.f17332n;
            String str = null;
            boolean b11 = kotlin.jvm.internal.x.b("BIG_V", (dynamicDetailInfo2 == null || (ucExtInfo3 = dynamicDetailInfo2.getUcExtInfo()) == null) ? null : ucExtInfo3.showExtBusinessTag);
            DynamicDetailInfo dynamicDetailInfo3 = this.f17332n;
            boolean b12 = kotlin.jvm.internal.x.b("NFT", (dynamicDetailInfo3 == null || (ucExtInfo2 = dynamicDetailInfo3.getUcExtInfo()) == null) ? null : ucExtInfo2.headImageType);
            DynamicDetailInfo dynamicDetailInfo4 = this.f17332n;
            String userAvatar = dynamicDetailInfo4 != null ? dynamicDetailInfo4.getUserAvatar() : null;
            String str2 = "";
            if (userAvatar == null) {
                userAvatar = str2;
            }
            DynamicDetailInfo dynamicDetailInfo5 = this.f17332n;
            String str3 = (dynamicDetailInfo5 == null || (ucExtInfo = dynamicDetailInfo5.getUcExtInfo()) == null) ? null : ucExtInfo.frameUrl;
            if (str3 == null) {
                str3 = str2;
            }
            DynamicDetailInfo dynamicDetailInfo6 = this.f17332n;
            if (dynamicDetailInfo6 != null) {
                str = dynamicDetailInfo6.getUidUnique();
            }
            if (str != null) {
                str2 = str;
            }
            if (userAvatar.length() == 0) {
                avatarView.y(R$drawable.account_user_image, isAlive);
                if (isAlive == 0 && b11) {
                    z11 = true;
                }
                avatarView.A(z11);
                avatarView.setAvatarClickListener(this.D);
            } else {
                avatarView.u(userAvatar, b12, str3);
                AvatarView.t(avatarView, isAlive, -1, str2, (String) null, (String) null, 0, 48, (Object) null);
                avatarView.setAvatarClickListener(this.D);
                if (isAlive == 0 && b11) {
                    z11 = true;
                }
                avatarView.A(z11);
            }
        }
    }

    public void P8(ky.j jVar) {
        super.P8(jVar);
        wi();
    }

    public final void Pi(DynamicDetailInfo dynamicDetailInfo, lc.c cVar) {
        List<CommunityFeedInfo.Topic> list;
        List<CommunityFeedInfo.Topic> topic = dynamicDetailInfo.getTopic();
        if (topic == null || (list = CollectionsKt___CollectionsKt.I0(topic)) == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        if (2 == dynamicDetailInfo.getTextType() || !(!list.isEmpty())) {
            cVar.E0.setVisibility(8);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (CommunityFeedInfo.Topic topic2 : list) {
            int length = spannableStringBuilder.length();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n0.h.f32179b);
            String title = topic2.getTitle();
            if (title == null) {
                title = "";
            }
            sb2.append(title);
            sb2.append("  ");
            spannableStringBuilder.append(sb2.toString());
            spannableStringBuilder.setSpan(new w(topic2), length, spannableStringBuilder.length() - 2, 33);
        }
        cVar.E0.setText(spannableStringBuilder);
        cVar.E0.setMovementMethod(LinkMovementMethod.getInstance());
        cVar.E0.setVisibility(0);
    }

    public void Q3(int i11) {
        nc.c.a("app_community_dz", this.f17336r);
    }

    public final void Qi(int i11, int i12) {
        if (i12 == 0) {
            if (i11 == 0) {
                com.hbg.module.libkt.utils.r.f24939a.d(((lc.c) Yf()).C.getDelegate(), R$color.community_label_background);
                ((lc.c) Yf()).F.setImageResource(R$drawable.icon_white_plus);
                rd.s sVar = rd.s.f23381a;
                sVar.i(((lc.c) Yf()).f19153h0, R$color.white);
                sVar.j(((lc.c) Yf()).f19153h0, R$string.n_content_communityList_attention);
            } else {
                com.hbg.module.libkt.utils.r.f24939a.d(((lc.c) Yf()).C.getDelegate(), R$color.baseColorInputBackground);
                ((lc.c) Yf()).F.setImageResource(R$drawable.icon_black_check);
                rd.s sVar2 = rd.s.f23381a;
                sVar2.i(((lc.c) Yf()).f19153h0, R$color.black);
                sVar2.j(((lc.c) Yf()).f19153h0, R$string.n_content_communityList_attentioned);
            }
            ((lc.c) Yf()).C.setVisibility(0);
            return;
        }
        ((lc.c) Yf()).C.setVisibility(8);
    }

    public final void Ri(String str) {
        ((lc.c) Yf()).Z.setHtml(str);
    }

    public final void Si(rj.b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("h5Url", BaseModuleConfig.a().j());
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.ROOT;
        jSONObject.put("currencyCharacter", y11.toUpperCase(locale));
        jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
        jSONObject.put("priceColorType", Integer.valueOf(com.hbg.lib.core.util.w.l() ^ true ? 1 : 0));
        jSONObject.put("colorMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        String j11 = AssetModuleConfig.a().j();
        Context context = null;
        jSONObject.put("iconURLHost", j11 != null ? StringsKt__StringsJVMKt.G(j11, DomainTool.DOMAIN_PREFIX, "", false, 4, (Object) null) : null);
        jSONObject.put("iconPlaceholder", "");
        jSONObject.put("OS", 1);
        jSONObject.put("bottomSafeAreaHeight", 0);
        if (bVar != null) {
            context = bVar.d();
        }
        jSONObject.put("language", com.hbg.lib.core.util.p.a(context).toLowerCase(locale));
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", Integer.valueOf(PixelUtils.h((float) com.hbg.module.libkt.utils.o.f24912a.b(this))));
        if (bVar != null) {
            bVar.I("sendCommonConfig(" + jSONObject + ')');
        }
    }

    public final void Ti(SpannableStringBuilder spannableStringBuilder, RichTextBean richTextBean, String str) {
        int length = spannableStringBuilder.length();
        int length2 = richTextBean.character.length() + length + str.length();
        spannableStringBuilder.append(str + richTextBean.character + ' ');
        spannableStringBuilder.setSpan(new y(richTextBean, this), length, length2, 33);
    }

    public final void Ui(int i11) {
        if (i11 == 0) {
            ((lc.c) Yf()).I.setImageResource(com.hbg.module.libkt.base.ext.b.q(((lc.c) Yf()).I.getContext(), R$attr.information_like));
        } else {
            ((lc.c) Yf()).I.setImageResource(com.hbg.module.libkt.base.ext.b.q(((lc.c) Yf()).I.getContext(), R$attr.information_like_focus));
        }
    }

    public final void Vi(DynamicDetailInfo dynamicDetailInfo, boolean z11) {
        String str;
        String title = dynamicDetailInfo.getTitle();
        int textType = dynamicDetailInfo.getTextType();
        if (textType == 0) {
            str = dynamicDetailInfo.getContent();
        } else if (textType != 1) {
            str = dynamicDetailInfo.getContentText();
        } else {
            str = dynamicDetailInfo.getRichText();
        }
        dynamicDetailInfo.setTitle(dynamicDetailInfo.getOldTitle());
        dynamicDetailInfo.setOldTitle(title);
        int textType2 = dynamicDetailInfo.getTextType();
        if (textType2 == 0) {
            dynamicDetailInfo.setContent(dynamicDetailInfo.getOldContent());
            dynamicDetailInfo.setOldContent(str);
        } else if (textType2 != 1) {
            dynamicDetailInfo.setContentText(dynamicDetailInfo.getOldContent());
            dynamicDetailInfo.setOldContent(str);
            Mi();
        } else {
            dynamicDetailInfo.setRichText(dynamicDetailInfo.getOldContent());
            dynamicDetailInfo.setOldContent(str);
            String richText = dynamicDetailInfo.getRichText();
            if (richText == null) {
                richText = "";
            }
            Ri(richText);
        }
        dynamicDetailInfo.setTrans(z11);
        ((lc.c) Yf()).M(dynamicDetailInfo);
    }

    public final boolean Xi(RichWebView richWebView) {
        ArrayList arrayList;
        List<CommunityFeedInfo.imgListBean> imgList;
        List<CommunityFeedInfo.imgListBean> imgList2;
        WebView.HitTestResult hitTestResult = richWebView.getHitTestResult();
        int i11 = 0;
        if ((hitTestResult.getType() != 5 && hitTestResult.getType() != 8) || TextUtils.isEmpty(hitTestResult.getExtra())) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        DynamicDetailInfo dynamicDetailInfo = this.f17332n;
        if (!(dynamicDetailInfo == null || (imgList2 = dynamicDetailInfo.getImgList()) == null)) {
            for (CommunityFeedInfo.imgListBean imglistbean : imgList2) {
                arrayList2.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
            }
        }
        DynamicDetailInfo dynamicDetailInfo2 = this.f17332n;
        if (dynamicDetailInfo2 == null || (imgList = dynamicDetailInfo2.getImgList()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(imgList, 10));
            for (CommunityFeedInfo.imgListBean image : imgList) {
                arrayList.add(image.getImage());
            }
        }
        if (arrayList != null) {
            i11 = arrayList.indexOf(hitTestResult.getExtra());
        }
        PhotoViewerUtils.a(this, arrayList2, i11);
        return true;
    }

    public final boolean Yi(RichWebView richWebView) {
        WebView.HitTestResult hitTestResult = richWebView.getHitTestResult();
        if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
            return false;
        }
        String extra = hitTestResult.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return false;
        }
        SaveImageUtils.h(this, extra);
        return true;
    }

    public void be(int i11) {
        nc.c.a("app_community_sc", this.f17336r);
    }

    public void bf(ky.j jVar) {
        super.bf(jVar);
        this.f17333o = 1;
        this.f17335q = "0";
        ((lc.c) Yf()).f19150e0.setNoMoreData(false);
        DynamicDetailViewModel dynamicDetailViewModel = this.f17330l;
        if (dynamicDetailViewModel != null) {
            dynamicDetailViewModel.i0(this.f17327i);
        }
    }

    public void finish() {
        super.finish();
        nc.c.a("app_community_tzxqfh", this.f17336r);
    }

    public final void hideCustomView() {
        WebChromeClient webChromeClient = this.f17339u;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        }
    }

    public final boolean inCustomView() {
        return this.F != null;
    }

    public void initView() {
        MutableLiveData<VmState<DynamicDetailInfo>> h02;
        super.initView();
        Qg(NightHelper.e().g());
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        this.f17338t = z11;
        ((lc.c) Yf()).N(this);
        ((lc.c) Yf()).B.q(this);
        ((lc.c) Yf()).B.r(this.f17327i);
        ((lc.c) Yf()).f19166z0.setText(StringsKt__StringsJVMKt.G(getResources().getString(R$string.n_community_browse_number), "%s", "", false, 4, (Object) null));
        ((lc.c) Yf()).f19162v0.setText(StringsKt__StringsJVMKt.G(getResources().getString(R$string.n_community_likes_number), "%s", "", false, 4, (Object) null));
        ((lc.c) Yf()).C0.setText(StringsKt__StringsJVMKt.G(getResources().getString(R$string.n_community_share_number), "%s", "", false, 4, (Object) null));
        com.hbg.module.libkt.base.ext.b.R(((lc.c) Yf()).D0);
        com.hbg.module.libkt.base.ext.b.R(((lc.c) Yf()).f19164x0);
        Ni();
        ((lc.c) Yf()).f19150e0.h0(new SmartRefreshFooter(this));
        ((lc.c) Yf()).f19150e0.e0(this);
        ((lc.c) Yf()).f19150e0.i(false);
        ((lc.c) Yf()).R.setOnRetryClickListener(new f(this));
        ((lc.c) Yf()).R.p();
        ((TextView) ((lc.c) Yf()).H0.findViewById(R$id.viewErrorRetry)).setOnClickListener(new u(this));
        if (AppLanguageHelper.getInstance().isEnglishLanguage()) {
            ((lc.c) Yf()).D0.setTypeface(Utils.c(R$font.roboto_medium));
            ((lc.c) Yf()).f19157l0.setTypeface(Utils.c(R$font.roboto_regular));
        }
        DynamicDetailViewModel dynamicDetailViewModel = (DynamicDetailViewModel) new ViewModelProvider(this).a(DynamicDetailViewModel.class);
        this.f17330l = dynamicDetailViewModel;
        if (!(dynamicDetailViewModel == null || (h02 = dynamicDetailViewModel.h0()) == null)) {
            h02.observe(this, new x(new DynamicDetailActivity$initView$3(this)));
        }
        DynamicDetailViewModel dynamicDetailViewModel2 = this.f17330l;
        if (dynamicDetailViewModel2 != null) {
            dynamicDetailViewModel2.i0(this.f17327i);
        }
        CommentListAdapter commentListAdapter = new CommentListAdapter(this, this.f17327i, "4", (String) null, false, (String) null, 56, (kotlin.jvm.internal.r) null);
        this.f17334p = commentListAdapter;
        commentListAdapter.S(this);
        ((lc.c) Yf()).f19149d0.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((lc.c) Yf()).f19149d0.setAdapter(this.f17334p);
        ((lc.c) Yf()).f19149d0.setItemAnimator((RecyclerView.ItemAnimator) null);
        rd.s sVar = rd.s.f23381a;
        RoundLinearLayout roundLinearLayout = ((lc.c) Yf()).C;
        roundLinearLayout.setOnClickListener(new p(roundLinearLayout, 800, this));
        RelativeLayout relativeLayout = ((lc.c) Yf()).f19148c0;
        relativeLayout.setOnClickListener(new q(relativeLayout, 800, this));
        AppCompatImageView appCompatImageView = ((lc.c) Yf()).J;
        appCompatImageView.setOnClickListener(new r(appCompatImageView, 800, this));
        RadioButton radioButton = ((lc.c) Yf()).Y;
        radioButton.setOnClickListener(new s(radioButton, 800, this));
        RadioButton radioButton2 = ((lc.c) Yf()).X;
        radioButton2.setOnClickListener(new t(radioButton2, 800, this));
        Gi();
    }

    public void j7(int i11) {
        nc.c.a("app_community_xqpl", this.f17336r);
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("dynamicId");
        if (stringExtra != null) {
            this.f17327i = stringExtra;
        }
        this.f17328j = getIntent().getBooleanExtra("feedCommentClick", false);
    }

    public void onDestroy() {
        super.onDestroy();
        x8.a.a().t(false, this.f17344z);
        rj.b bVar = this.f17342x;
        if (bVar != null) {
            bVar.B();
        }
        rj.b bVar2 = this.f17343y;
        if (bVar2 != null) {
            bVar2.B();
        }
        ((lc.c) Yf()).E.removeAllViews();
        ((lc.c) Yf()).Z.stopLoading();
        ((lc.c) Yf()).Z.onPause();
        ((lc.c) Yf()).Z.clearCache(true);
        ((lc.c) Yf()).Z.clearHistory();
    }

    public final void onFullscreenEventChanged(boolean z11) {
        if (z11) {
            getWindow().addFlags(1024);
            ((lc.c) Yf()).Z.evaluateJavascript(this.E, new g(this));
            return;
        }
        getWindow().clearFlags(1024);
        setRequestedOrientation(1);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return false;
        }
        if (inCustomView()) {
            hideCustomView();
            return true;
        }
        finish();
        return false;
    }

    public void onResume() {
        super.onResume();
        HbgBaseProvider fg2 = fg();
        if (!(fg2 != null && fg2.n() == this.f17338t)) {
            HbgBaseProvider fg3 = fg();
            this.f17338t = fg3 != null && fg3.n();
            uh(false, true);
            DynamicDetailViewModel dynamicDetailViewModel = this.f17330l;
            if (dynamicDetailViewModel != null) {
                dynamicDetailViewModel.i0(this.f17327i);
            }
        }
        if (getRequestedOrientation() != 0) {
            setRequestedOrientation(1);
        }
        ((lc.c) Yf()).Z.onResume();
    }

    public final void ri() {
        nc.c.a("app_community_gz", this.f17336r);
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.j(this)) {
            DynamicDetailInfo dynamicDetailInfo = this.f17332n;
            if (dynamicDetailInfo != null && dynamicDetailInfo.getFocusStatus() == 0) {
                IHbgApi a11 = v7.b.a();
                Pair[] pairArr = new Pair[2];
                pairArr[0] = kotlin.l.a("type", 1);
                DynamicDetailInfo dynamicDetailInfo2 = this.f17332n;
                pairArr[1] = kotlin.l.a("uidUnique", dynamicDetailInfo2 != null ? dynamicDetailInfo2.getUidUnique() : null);
                RequestExtKt.d(a11.requestCommunityAttention(MapsKt__MapsKt.l(pairArr)), new DynamicDetailActivity$attentionAuthor$1(this), DynamicDetailActivity$attentionAuthor$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
            }
        }
    }

    public final void setXCustomView(View view) {
        this.F = view;
    }

    public final void si() {
        long j11;
        boolean z11 = false;
        ((lc.c) Yf()).V.setExpanded(false, true);
        nc.c.a("app_community_xqpl", this.f17336r);
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.j(this)) {
            z11 = true;
        }
        if (z11) {
            try {
                j11 = Long.parseLong(this.f17327i);
            } catch (Throwable th2) {
                th2.printStackTrace();
                j11 = 0;
            }
            CommentExtKt.e(this, this.f17327i, "4", "", new d(this, j11), (String) null, (String) null, com.hbg.module.libkt.base.ext.b.j(R$string.n_community_add_comment), 48, (Object) null);
        }
    }

    public final void ti() {
        RequestExtKt.d(v7.b.a().D0(this.f17327i, 4), new DynamicDetailActivity$clickLike$1(this), DynamicDetailActivity$clickLike$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void ui() {
        boolean z11;
        com.hbg.module.content.utls.o oVar = com.hbg.module.content.utls.o.f18923a;
        AppCompatImageView appCompatImageView = ((lc.c) Yf()).N;
        e eVar = new e(this);
        boolean z12 = false;
        if (BaseModuleConfig.a().s() != 1) {
            DynamicDetailInfo dynamicDetailInfo = this.f17332n;
            if (!(dynamicDetailInfo != null && dynamicDetailInfo.getIsSelf() == 1)) {
                z11 = false;
                DynamicDetailInfo dynamicDetailInfo2 = this.f17332n;
                if (dynamicDetailInfo2 != null && dynamicDetailInfo2.getIsSelf() == 1) {
                    z12 = true;
                }
                com.hbg.module.content.utls.o.f(oVar, this, appCompatImageView, eVar, true, z11, !z12, false, 64, (Object) null);
            }
        }
        z11 = true;
        DynamicDetailInfo dynamicDetailInfo22 = this.f17332n;
        z12 = true;
        com.hbg.module.content.utls.o.f(oVar, this, appCompatImageView, eVar, true, z11, !z12, false, 64, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void vi() {
        /*
            r15 = this;
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r15.f17336r
            java.lang.String r1 = "app_community_fx"
            nc.c.a(r1, r0)
            gc.a r0 = gc.a.f19130a
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r15.f17332n
            r2 = 0
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = r1.getTitle()
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = r15.f17332n
            if (r3 == 0) goto L_0x001d
            java.lang.String r3 = r3.getContent()
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            r4 = 20
            java.lang.String r7 = r0.a(r4, r1, r3)
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r15.f17332n
            if (r0 == 0) goto L_0x002d
            java.util.List r0 = r0.getImgList()
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            boolean r0 = com.hbg.module.libkt.base.ext.b.w(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0037
        L_0x0035:
            r0 = r2
            goto L_0x0047
        L_0x0037:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r15.f17332n
            if (r0 == 0) goto L_0x0035
            java.util.List r0 = r0.getImgList()
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r0.get(r1)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean) r0
        L_0x0047:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = r15.f17332n
            r5 = 1
            if (r3 == 0) goto L_0x0054
            int r3 = r3.getShareType()
            if (r3 != r4) goto L_0x0054
            r3 = r5
            goto L_0x0055
        L_0x0054:
            r3 = r1
        L_0x0055:
            if (r3 != 0) goto L_0x0069
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = r15.f17332n
            if (r3 == 0) goto L_0x0064
            int r3 = r3.getShareType()
            r4 = 21
            if (r3 != r4) goto L_0x0064
            r1 = r5
        L_0x0064:
            if (r1 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r1 = 4
            goto L_0x0071
        L_0x0069:
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r15.f17332n
            if (r1 == 0) goto L_0x0076
            int r1 = r1.getShareType()
        L_0x0071:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0077
        L_0x0076:
            r1 = r2
        L_0x0077:
            if (r1 == 0) goto L_0x00b4
            int r13 = r1.intValue()
            com.hbg.module.libkt.provider.HbgBaseShareProvider r5 = r15.gg()
            if (r5 == 0) goto L_0x00b4
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "views/feed/details/community-details/"
            r3.append(r4)
            java.lang.String r4 = r15.f17327i
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r9 = r1.k(r3)
            if (r0 == 0) goto L_0x00a4
            java.lang.String r2 = r0.getImage()
        L_0x00a4:
            r11 = r2
            java.lang.String r12 = r15.f17327i
            com.hbg.module.community.ui.DynamicDetailActivity$doShareAction$1$1 r14 = new com.hbg.module.community.ui.DynamicDetailActivity$doShareAction$1$1
            r14.<init>(r15)
            java.lang.String r8 = ""
            java.lang.String r10 = "community"
            r6 = r15
            r5.b(r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.DynamicDetailActivity.vi():void");
    }

    public final void wi() {
        RequestExtKt.d(v7.b.a().getCommentList(this.f17327i, "4", (String) null, this.f17335q, 20, this.f17340v), new DynamicDetailActivity$getCommentList$1(this), new DynamicDetailActivity$getCommentList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: xi */
    public lc.c Og() {
        return lc.c.K(getLayoutInflater());
    }

    public final View yi() {
        return this.F;
    }

    public final void zi() {
        View D2;
        ((lc.c) Yf()).D.removeAllViews();
        rj.b bVar = new rj.b(getApplicationContext(), "content");
        this.f17342x = bVar;
        bVar.A("TagView", TagViewWidget.class);
        rj.b bVar2 = this.f17342x;
        if (bVar2 != null) {
            bVar2.t("contentBridge", ContentAbility.class);
        }
        rj.b bVar3 = this.f17342x;
        if (bVar3 != null) {
            bVar3.H();
        }
        Si(this.f17342x);
        Pair[] pairArr = new Pair[6];
        HbgBaseProvider fg2 = fg();
        pairArr[0] = kotlin.l.a("isLogin", Integer.valueOf((fg2 == null || !fg2.n()) ? 0 : 1));
        pairArr[1] = kotlin.l.a("platform", "1");
        pairArr[2] = kotlin.l.a("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        List<NewFlashInformationCoinTags> list = null;
        String uid = a11 != null ? a11.getUid() : null;
        if (uid == null) {
            uid = "";
        }
        pairArr[3] = kotlin.l.a("uid", uid);
        pairArr[4] = kotlin.l.a(Constants.FLAG_ACCOUNT, BaseModuleConfig.a().i());
        pairArr[5] = kotlin.l.a("language", AppLanguageHelper.getInstance().getCurAppLocaleName());
        HashMap j11 = MapsKt__MapsKt.j(pairArr);
        rj.b bVar4 = this.f17342x;
        if (bVar4 != null) {
            bVar4.I("nav.initNativeData('" + com.hbg.module.libkt.base.ext.f.f(j11) + "')");
        }
        rj.b bVar5 = this.f17342x;
        if (bVar5 != null) {
            bVar5.I("nativeRes.initRes()");
        }
        rj.b bVar6 = this.f17342x;
        if (bVar6 != null) {
            bVar6.I("coinTags.start()");
        }
        Pair[] pairArr2 = new Pair[1];
        DynamicDetailInfo dynamicDetailInfo = this.f17332n;
        if (dynamicDetailInfo != null) {
            list = dynamicDetailInfo.coinTags;
        }
        pairArr2[0] = kotlin.l.a("list", list);
        HashMap j12 = MapsKt__MapsKt.j(pairArr2);
        rj.b bVar7 = this.f17342x;
        if (bVar7 != null) {
            bVar7.I("coinTags.getCoinList(" + new Gson().toJson((Object) j12) + ')');
        }
        rj.b bVar8 = this.f17342x;
        if (bVar8 != null && (D2 = bVar8.D("coin_tags.xml", this)) != null) {
            ((lc.c) Yf()).D.addView(D2);
            ((lc.c) Yf()).D.setVisibility(0);
            x8.a.a().t(true, this.f17344z);
        }
    }
}
