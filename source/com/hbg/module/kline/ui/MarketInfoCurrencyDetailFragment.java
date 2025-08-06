package com.hbg.module.kline.ui;

import ad.b;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import bj.o0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.common.utils.ColorUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.CurrencyIntroInfo;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.SecurityGradeDetailBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.CoinDistributionItem;
import com.hbg.module.kline.bean.CurrencyIntroItem;
import com.hbg.module.kline.bean.EtfInfo;
import com.hbg.module.kline.bean.EtfIngredient;
import com.hbg.module.kline.bean.SocialMediaItem;
import com.hbg.module.kline.presenter.MarketInfoCurrencyDetailPresenter;
import com.hbg.module.kline.view.AutoSplitTextView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.custom.HexagonalRatingView;
import com.hbg.module.libkt.custom.SemicircleProgressView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.m;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;

public class MarketInfoCurrencyDetailFragment extends BaseFragment<MarketInfoCurrencyDetailPresenter, MarketInfoCurrencyDetailPresenter.f> implements MarketInfoCurrencyDetailPresenter.f {
    public ViewGroup A;
    public EasyRecyclerView B;
    public EasyRecyclerView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public EasyRecyclerView I;
    public View J;
    public View K;
    public View L;
    public LinearLayout M;
    public String N = "";
    public String O;
    public TextView P;
    public TextView Q;
    public EasyRecyclerView R;
    public LinearLayout S;
    public ImageView T;
    public ImageView U;
    public CurrencyIntroInfo V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public List<CurrencyIntroInfo.CurrencyUnlock> f23947a0 = new ArrayList();

    /* renamed from: b0  reason: collision with root package name */
    public List<CurrencyIntroInfo.CurrencyUnlock> f23948b0 = new ArrayList();

    /* renamed from: c0  reason: collision with root package name */
    public List<CurrencyIntroInfo.CurrencyUnlock> f23949c0 = new ArrayList();

    /* renamed from: d0  reason: collision with root package name */
    public List<CurrencyIntroInfo.CurrencyUnlock> f23950d0 = new ArrayList();

    /* renamed from: e0  reason: collision with root package name */
    public ImageView f23951e0;

    /* renamed from: f0  reason: collision with root package name */
    public ImageView f23952f0;

    /* renamed from: g0  reason: collision with root package name */
    public ImageView f23953g0;

    /* renamed from: h0  reason: collision with root package name */
    public ImageView f23954h0;

    /* renamed from: i0  reason: collision with root package name */
    public ImageView f23955i0;

    /* renamed from: j0  reason: collision with root package name */
    public TextView f23956j0;

    /* renamed from: k0  reason: collision with root package name */
    public TextView f23957k0;

    /* renamed from: l  reason: collision with root package name */
    public TextView f23958l;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f23959l0;

    /* renamed from: m  reason: collision with root package name */
    public TextView f23960m;

    /* renamed from: m0  reason: collision with root package name */
    public TextView f23961m0;

    /* renamed from: n  reason: collision with root package name */
    public TextView f23962n;

    /* renamed from: n0  reason: collision with root package name */
    public HexagonalRatingView f23963n0;

    /* renamed from: o  reason: collision with root package name */
    public TextView f23964o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f23965p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f23966q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f23967r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f23968s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f23969t;

    /* renamed from: t0  reason: collision with root package name */
    public SemicircleProgressView f23970t0;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f23971u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f23972v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f23973w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f23974x;

    /* renamed from: y  reason: collision with root package name */
    public AutoSplitTextView f23975y;

    /* renamed from: z  reason: collision with root package name */
    public ViewGroup f23976z;

    public class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String str) {
            super(str);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityGradeDetailBean f23977b;

        public a(SecurityGradeDetailBean securityGradeDetailBean) {
            this.f23977b = securityGradeDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/webView/index").withString("url", this.f23977b.certikProjectPage).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ai(int i11) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            ee.a.a(getActivity(), !KLineHelper.f() ? 1 : 0, (String) null, getActivity().getResources().getString(R$string.n_kline_rating_score_toast), (String) null, (String) null, getString(R$string.n_copy_trading_i_got_it), (DialogUtils.b.f) null, o0.f12469a);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gi(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getMaxPriceRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getMaxPriceRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, z0.f24309a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getMinPriceRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getMinPriceRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, d1.f24168a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getPublishTimeRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getPublishTimeRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, y0.f24304a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (!TextUtils.isEmpty(this.N)) {
            d.b("MarketInfoCurrencyDetailFragment-->mOfficialWebsiteUrl-->" + this.N);
            HBBaseWebActivity.showWebView(getActivity(), this.N, getString(R$string.market_info_ht_introduce), "", false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getRankRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getRankRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, b.f3517a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getInvestorPriceRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getInvestorPriceRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, a1.f24148a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mi(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getTotalMarketValueRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getTotalMarketValueRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, c1.f24161a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oi(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getCirculateMarketValueRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getCirculateMarketValueRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, f1.f24182a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void pi(View view) {
        if (this.Z) {
            Ci(this.f23948b0);
            this.W.setText(getString(R$string.n_kline_coin_history_extrend_more));
            this.W.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.kline_arrow_down, 0);
        } else {
            Ci(this.f23947a0);
            this.W.setText(getString(R$string.n_otc_balance_trade_order_list_button));
            this.W.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.kline_arrow_up, 0);
        }
        this.Z = !this.Z;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qi(View view) {
        if (!TextUtils.isEmpty(this.O)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(BaseModuleConfig.a().W());
            sb2.append("asset-introduction/details/h5/?currency=");
            sb2.append(this.O);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append("refresh=2&");
            sb2.append("color=" + ColorUtils.c(ContextCompat.getColor(getContext(), R$color.finance_web_refresh_color)));
            CurrencyIntroWebActivity.startWebView(getActivity(), sb2.toString(), (String) null, false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ti(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getPublishVolumeRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getPublishVolumeRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, e1.f24175a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vi(View view) {
        CurrencyIntroInfo currencyIntroInfo;
        FragmentActivity activity = getActivity();
        if (!(activity == null || (currencyIntroInfo = this.V) == null || TextUtils.isEmpty(currencyIntroInfo.getCirculateVolumeRemark()))) {
            ee.a.a(activity, KLineHelper.f() ^ true ? 1 : 0, getContext().getString(R$string.n_option_delivery_tip), this.V.getCirculateVolumeRemark(), (String) null, (String) null, getContext().getString(R$string.n_known), (DialogUtils.b.f) null, b1.f24154a);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(SecurityGradeDetailBean securityGradeDetailBean, int i11) {
        String str;
        if (i11 == 0) {
            str = securityGradeDetailBean.codeSecurityDesc;
        } else if (i11 == 1) {
            str = securityGradeDetailBean.fundamentalHealthDesc;
        } else if (i11 == 2) {
            str = securityGradeDetailBean.marketStabilityDesc;
        } else if (i11 == 3) {
            str = securityGradeDetailBean.governanceStrengthDesc;
        } else if (i11 != 4) {
            str = i11 != 5 ? "" : securityGradeDetailBean.communityTrustDesc;
        } else {
            str = securityGradeDetailBean.operationalResilienceDesc;
        }
        String str2 = str;
        if (getActivity() != null && !getActivity().isFinishing()) {
            ee.a.a(getActivity(), KLineHelper.f() ^ true ? 1 : 0, (String) null, str2, (String) null, (String) null, getString(R$string.n_copy_trading_i_got_it), (DialogUtils.b.f) null, o0.f12469a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit yi(SecurityGradeDetailBean securityGradeDetailBean) {
        boolean z11 = securityGradeDetailBean != null && !TextUtils.isEmpty(securityGradeDetailBean.certikProjectId);
        ViewUtil.m(this.J, z11);
        if (!z11) {
            return null;
        }
        TextView textView = this.f23958l;
        textView.setText(this.O.toUpperCase() + "(" + securityGradeDetailBean.currencyFullName + ")");
        SemicircleProgressView semicircleProgressView = this.f23970t0;
        double d11 = securityGradeDetailBean.score;
        String str = securityGradeDetailBean.tier;
        if (str == null) {
            str = "";
        }
        semicircleProgressView.d(100.0d, d11, d11, str);
        TextView textView2 = this.f23956j0;
        textView2.setText("#" + securityGradeDetailBean.rank);
        this.f23957k0.setText(getActivity().getResources().getString(R$string.n_currency_intro_safe_sort));
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        TextView textView3 = this.f23959l0;
        textView3.setText(decimalFormat.format(securityGradeDetailBean.rankPercentile * 100.0d) + "%");
        this.f23961m0.setText(getActivity().getResources().getString(R$string.n_kline_title_rating_percent_new));
        this.Y.setOnClickListener(new a(securityGradeDetailBean));
        this.f23963n0.setData(securityGradeDetailBean.codeSecurity, securityGradeDetailBean.fundamentalHealth, securityGradeDetailBean.marketStability, securityGradeDetailBean.governanceStrength, securityGradeDetailBean.operationalResilience, securityGradeDetailBean.communityTrust);
        this.f23963n0.setOnTextClickListener(new k1(this, securityGradeDetailBean));
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit zi(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        ViewUtil.m(this.J, false);
        if (aPIStatusErrorException == null) {
            return null;
        }
        HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        return null;
    }

    public void Ah() {
        super.Ah();
        this.M.setOnClickListener(new x0(this));
        this.f23971u.setOnClickListener(new g1(this));
        this.f23968s.setOnClickListener(new q1(this));
        this.f23951e0.setOnClickListener(new l1(this));
        this.f23952f0.setOnClickListener(new n1(this));
        this.T.setOnClickListener(new w0(this));
        this.U.setOnClickListener(new o1(this));
        this.f23953g0.setOnClickListener(new r1(this));
        this.f23954h0.setOnClickListener(new v0(this));
        this.f23955i0.setOnClickListener(new s1(this));
        this.W.setOnClickListener(new m1(this));
        this.f23974x.setOnClickListener(new p1(this));
    }

    public final void Bi() {
        if (getActivity() instanceof MarketInfoActivity) {
            HashMap hashMap = new HashMap();
            hashMap.put("TransPair_current_id", ((MarketInfoActivity) getActivity()).getPresenter().h0());
            hashMap.put("markets_kline_class", RankScreenBean.SCREEN_VALUE_SPOT);
            BaseModuleConfig.a().w("App_markets_kline_firtab_info_view", hashMap);
        }
    }

    public void Ci(List<CurrencyIntroInfo.CurrencyUnlock> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            ai(i11, list.get(i11), arrayList);
        }
        this.R.setData(arrayList);
    }

    public void Di(CurrencyIntroInfo currencyIntroInfo) {
        if (currencyIntroInfo != null && !TextUtils.isEmpty(currencyIntroInfo.getCurrency()) && !TextUtils.isEmpty(currencyIntroInfo.getFullName())) {
            TextView textView = this.f23960m;
            textView.setText(currencyIntroInfo.getCurrency().toUpperCase() + "(" + currencyIntroInfo.getFullName() + ")");
        }
    }

    public final void Ei(CurrencyIntroInfo currencyIntroInfo) {
        boolean z11;
        if (currencyIntroInfo != null) {
            String officialWebsite = currencyIntroInfo.getOfficialWebsite();
            String whitePaper = currencyIntroInfo.getWhitePaper();
            String blockQuery = currencyIntroInfo.getBlockQuery();
            String github = currencyIntroInfo.getGithub();
            String twitter = currencyIntroInfo.getTwitter();
            String medium = currencyIntroInfo.getMedium();
            String telegram = currencyIntroInfo.getTelegram();
            String auditReportUrl = currencyIntroInfo.getAuditReportUrl();
            ArrayList arrayList = new ArrayList(5);
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList;
            bi(R$drawable.icon_currency_intro_official, R$drawable.icon_currency_intro_official_night, getText(R$string.currency_intro_official_website), officialWebsite, arrayList4);
            bi(R$drawable.icon_currency_intro_white_paper, R$drawable.icon_currency_intro_white_paper_night, getText(R$string.currency_intro_whitepaper), whitePaper, arrayList4);
            bi(R$drawable.icon_currency_intro_link, R$drawable.icon_currency_intro_link_night, getText(R$string.n_kline_block_browser), blockQuery, arrayList4);
            bi(R$drawable.icon_currency_intro_github, R$drawable.icon_currency_intro_github_night, "Github", github, arrayList4);
            bi(R$drawable.icon_currency_intro_report, R$drawable.icon_currency_intro_report_night, getText(R$string.n_kline_title_rating_report), auditReportUrl, arrayList4);
            ci(R$drawable.icon_currency_intro_twitter, R$drawable.icon_currency_intro_twitter_night, twitter, arrayList3);
            ci(R$drawable.icon_currency_intro_medium, R$drawable.icon_currency_intro_medium_night, medium, arrayList3);
            ci(R$drawable.icon_currency_intro_telegram, R$drawable.icon_currency_intro_telegram_night, telegram, arrayList3);
            if (!arrayList.isEmpty()) {
                this.B.setData(arrayList);
                z11 = false;
            } else {
                z11 = false;
                ViewUtil.m(this.f23976z, false);
            }
            if (!arrayList3.isEmpty()) {
                this.C.setData(arrayList3);
            } else {
                ViewUtil.m(this.A, z11);
            }
        } else {
            ViewUtil.m(this.f23976z, false);
            ViewUtil.m(this.A, false);
        }
    }

    public void G4(CurrencyIntroInfo currencyIntroInfo) {
        this.V = currencyIntroInfo;
        Di(currencyIntroInfo);
        this.Z = false;
        if (!(currencyIntroInfo == null || currencyIntroInfo.getOfficialWebsite() == null)) {
            this.N = Html.fromHtml(currencyIntroInfo.getOfficialWebsite()).toString();
        }
        if (currencyIntroInfo != null) {
            this.O = currencyIntroInfo.getCurrency();
            ei();
        } else {
            this.O = null;
            ViewUtil.m(this.J, false);
        }
        ViewUtil.m(this.M, false);
        Resources resources = getResources();
        int i11 = R$string.global_crossbar;
        String string = resources.getString(i11);
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getRank())) {
            this.f23969t.setText(i11);
        } else {
            this.f23969t.setText(currencyIntroInfo.getRank());
        }
        if (this.V.getCurrency().equalsIgnoreCase("htx")) {
            this.f67460i.b(R$id.rlyt_coin_rank).setVisibility(8);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getPublishTime())) {
            this.f23962n.setText(string);
            this.f67460i.b(R$id.market_info_release_time_layout).setVisibility(8);
        } else {
            this.f23962n.setText(currencyIntroInfo.getPublishTime().substring(0, 10));
            this.f67460i.b(R$id.market_info_release_time_layout).setVisibility(0);
        }
        String i12 = StringUtils.i("usdt");
        if (currencyIntroInfo == null || TextUtils.isEmpty(this.O) || TextUtils.isEmpty(currencyIntroInfo.getPublishVolume()) || !NumberKlineUtil.c(currencyIntroInfo.getPublishVolume())) {
            if (currencyIntroInfo == null || !currencyIntroInfo.getCurrency().equalsIgnoreCase("ht")) {
                this.f23964o.setText(getResources().getString(R$string.currency_intro_release_volumn));
            } else {
                this.f23964o.setText(getResources().getString(R$string.n_market_ht_total_on_hand));
            }
            this.f23965p.setText(string);
            this.f23972v.setText(string);
        } else {
            String publishVolume = currencyIntroInfo.getPublishVolume();
            String p11 = m.p(publishVolume, 0, true, string);
            if (currencyIntroInfo.getCurrency().equalsIgnoreCase("ht")) {
                this.f23964o.setText(getResources().getString(R$string.n_market_ht_total_on_hand));
            } else {
                this.f23964o.setText(getResources().getString(R$string.currency_intro_release_volumn));
            }
            this.f23965p.setText(p11);
            String p12 = m.p(LegalCurrencyConfigUtil.o(this.O, publishVolume, "usdt", TradeType.PRO), 0, true, string);
            if (string.equals(p12)) {
                this.f23972v.setText(p12);
            } else {
                TextView textView = this.f23972v;
                textView.setText(p12 + " " + i12);
            }
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(this.O) || TextUtils.isEmpty(currencyIntroInfo.getCirculateVolume()) || !NumberKlineUtil.c(currencyIntroInfo.getCirculateVolume())) {
            this.f23966q.setText(string);
            this.f23973w.setText(string);
        } else {
            String circulateVolume = currencyIntroInfo.getCirculateVolume();
            this.f23966q.setText(m.p(circulateVolume, 0, true, string));
            String p13 = m.p(LegalCurrencyConfigUtil.o(this.O, circulateVolume, "usdt", TradeType.PRO), 0, true, string);
            if (string.equals(p13)) {
                this.f23973w.setText(p13);
            } else {
                TextView textView2 = this.f23973w;
                textView2.setText(p13 + " " + i12);
            }
        }
        this.f23975y.setSourceText(getString(R$string.n_currency_intro_init_price));
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getCrowdfundingPrice())) {
            this.f23967r.setText(string);
            this.f67460i.b(R$id.market_info_init_price_layout).setVisibility(8);
        } else {
            this.f23967r.setText(currencyIntroInfo.getCrowdfundingPrice());
            this.f67460i.b(R$id.market_info_init_price_layout).setVisibility(0);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getIntroduction())) {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.D.setText(currencyIntroInfo.getIntroduction());
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getPublishVolumeRemark())) {
            ViewUtil.m(this.f23951e0, false);
        } else {
            ViewUtil.m(this.f23951e0, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getCirculateVolumeRemark())) {
            ViewUtil.m(this.f23952f0, false);
        } else {
            ViewUtil.m(this.f23952f0, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getMaxPriceRemark())) {
            ViewUtil.m(this.T, false);
        } else {
            ViewUtil.m(this.T, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getMinPriceRemark())) {
            ViewUtil.m(this.U, false);
        } else {
            ViewUtil.m(this.U, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getPublishTimeRemark())) {
            ViewUtil.m(this.f23953g0, false);
        } else {
            ViewUtil.m(this.f23953g0, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getTotalMarketValueRemark())) {
            ViewUtil.m(this.f23954h0, false);
        } else {
            ViewUtil.m(this.f23954h0, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getCirculateMarketValueRemark())) {
            ViewUtil.m(this.f23955i0, false);
        } else {
            ViewUtil.m(this.f23955i0, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getRankRemark())) {
            ViewUtil.m(this.f23971u, false);
        } else {
            ViewUtil.m(this.f23971u, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getInvestorPriceRemark())) {
            ViewUtil.m(this.f23968s, false);
        } else {
            ViewUtil.m(this.f23968s, true);
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getMinPrice())) {
            this.Q.setText(string);
        } else {
            this.Q.setText(currencyIntroInfo.getMinPrice());
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getMaxPrice())) {
            this.P.setText(string);
        } else {
            this.P.setText(currencyIntroInfo.getMaxPrice());
        }
        if (currencyIntroInfo == null || currencyIntroInfo.getCurrencyUnlock() == null) {
            ViewUtil.m(this.W, false);
            ViewUtil.m(this.S, false);
            this.R.setData(this.f23950d0);
        } else {
            this.f23948b0.clear();
            this.f23949c0.clear();
            this.f23947a0.clear();
            this.f23947a0.addAll(currencyIntroInfo.getCurrencyUnlock());
            if (this.f23947a0.isEmpty()) {
                ViewUtil.m(this.W, false);
                ViewUtil.m(this.S, false);
            } else {
                ViewUtil.m(this.S, true);
                if (this.f23947a0.size() > 6) {
                    ViewUtil.m(this.W, true);
                    this.f23948b0.addAll(this.f23947a0.subList(0, 6));
                    List<CurrencyIntroInfo.CurrencyUnlock> list = this.f23949c0;
                    List<CurrencyIntroInfo.CurrencyUnlock> list2 = this.f23947a0;
                    list.addAll(list2.subList(6, list2.size()));
                    Ci(this.f23948b0);
                } else {
                    ViewUtil.m(this.W, false);
                    Ci(this.f23947a0);
                }
            }
        }
        if (currencyIntroInfo == null || TextUtils.isEmpty(currencyIntroInfo.getIntroduction()) || TextUtils.isEmpty(currencyIntroInfo.getContent())) {
            ViewUtil.m(this.f23974x, false);
        } else {
            ViewUtil.m(this.f23974x, true);
        }
        Ei(currencyIntroInfo);
    }

    public void G7() {
        TextView textView = this.F;
        int i11 = R$string.global_crossbar;
        textView.setText(i11);
        this.G.setText(i11);
    }

    public void W5(EtfInfo etfInfo) {
        this.F.setText(DateTimeUtils.m(etfInfo.getSetupDay() / 1000));
        this.G.setText(m.k(etfInfo.getRealTimeEtfAmount(), 4, false));
        ViewUtil.m(this.f23974x, false);
    }

    public void Yg(List<EtfIngredient> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.I.setData(arrayList);
    }

    public void Za(String str) {
        this.H.setText(str);
    }

    public final void ai(int i11, CurrencyIntroInfo.CurrencyUnlock currencyUnlock, List<s9.a> list) {
        CoinDistributionItem coinDistributionItem = new CoinDistributionItem();
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.kline_screening_criteria_bg_color, typedValue, true);
        if (i11 % 2 == 0) {
            coinDistributionItem.setBackground(ContextCompat.getColor(getContext(), R$color.transparent));
        } else {
            coinDistributionItem.setBackground(typedValue.data);
        }
        coinDistributionItem.setName(currencyUnlock.getName());
        coinDistributionItem.setPercent(currencyUnlock.getPercent() + "%");
        coinDistributionItem.setTime(currencyUnlock.getTime());
        list.add(coinDistributionItem);
    }

    public void b8(boolean z11) {
        ViewUtil.m(this.L, !z11);
        ViewUtil.m(this.K, z11);
        ViewUtil.m(this.f23976z, !z11);
        ViewUtil.m(this.A, !z11);
    }

    public final void bi(int i11, int i12, CharSequence charSequence, String str, List<s9.a> list) {
        if (!TextUtils.isEmpty(str)) {
            CurrencyIntroItem currencyIntroItem = new CurrencyIntroItem();
            currencyIntroItem.setUrl(str);
            if (KLineHelper.f()) {
                currencyIntroItem.setImageResId(i11);
            } else {
                currencyIntroItem.setImageResId(i12);
            }
            currencyIntroItem.setName(charSequence);
            list.add(currencyIntroItem);
        }
    }

    public final void ci(int i11, int i12, String str, List<s9.a> list) {
        if (!TextUtils.isEmpty(str)) {
            SocialMediaItem socialMediaItem = new SocialMediaItem();
            socialMediaItem.setUrl(str);
            if (KLineHelper.f()) {
                socialMediaItem.setImageResId(i11);
            } else {
                socialMediaItem.setImageResId(i12);
            }
            list.add(socialMediaItem);
        }
    }

    /* renamed from: di */
    public MarketInfoCurrencyDetailPresenter xh() {
        return new MarketInfoCurrencyDetailPresenter();
    }

    public final void ei() {
        RequestExtKt.c(v7.b.a().getSecurityGradeDetail(this.O), new h1(this), new i1(this), (MutableLiveData) null);
    }

    /* renamed from: fi */
    public MarketInfoCurrencyDetailPresenter.f zh() {
        return this;
    }

    public void initViews() {
        int i11;
        super.initViews();
        this.J = this.f67460i.b(R$id.certikParentLayout);
        this.f23958l = (TextView) this.f67460i.b(R$id.tvCurrency);
        this.f23960m = (TextView) this.f67460i.b(R$id.market_info_currerncy_name);
        this.f23962n = (TextView) this.f67460i.b(R$id.market_info_release_time);
        this.f23964o = (TextView) this.f67460i.b(R$id.currency_intro_release_volumn_tv);
        this.f23965p = (TextView) this.f67460i.b(R$id.market_info_release_volum);
        this.f23966q = (TextView) this.f67460i.b(R$id.market_info_circulation_volum);
        this.f23967r = (TextView) this.f67460i.b(R$id.market_info_init_price);
        this.D = (TextView) this.f67460i.b(R$id.market_info_currerncy_intro);
        this.E = (TextView) this.f67460i.b(R$id.market_info_currerncy_intro_title);
        this.F = (TextView) this.f67460i.b(R$id.market_info_etf_release_time);
        this.G = (TextView) this.f67460i.b(R$id.market_info_etf_total_share);
        this.H = (TextView) this.f67460i.b(R$id.market_info_etf_latest_net);
        this.P = (TextView) this.f67460i.b(R$id.tv_history_h_market_value);
        this.Q = (TextView) this.f67460i.b(R$id.tv_history_l_market_value);
        this.f23968s = (ImageView) this.f67460i.b(R$id.iv_init_price);
        this.f23951e0 = (ImageView) this.f67460i.b(R$id.iv_currency_intro_release_volumn);
        this.f23952f0 = (ImageView) this.f67460i.b(R$id.iv_market_info_circulation_volum);
        this.T = (ImageView) this.f67460i.b(R$id.iv_coin_history_max);
        this.U = (ImageView) this.f67460i.b(R$id.iv_coin_history_min);
        this.f23953g0 = (ImageView) this.f67460i.b(R$id.iv_market_info_release_time);
        this.f23954h0 = (ImageView) this.f67460i.b(R$id.iv_total_market_value);
        this.f23955i0 = (ImageView) this.f67460i.b(R$id.iv_circulation_market_value);
        this.W = (TextView) this.f67460i.b(R$id.tv_expand_or_close);
        this.f23969t = (TextView) this.f67460i.b(R$id.tv_coin_rank);
        this.f23971u = (ImageView) this.f67460i.b(R$id.iv_coin_rank);
        this.f23972v = (TextView) this.f67460i.b(R$id.tv_total_market_value);
        this.f23973w = (TextView) this.f67460i.b(R$id.tv_circulation_market_value);
        this.f23974x = (TextView) this.f67460i.b(R$id.tv_check_detail);
        this.f23976z = (ViewGroup) this.f67460i.b(R$id.llyt_currency_about_link);
        this.A = (ViewGroup) this.f67460i.b(R$id.llSocialMedia);
        this.f23975y = (AutoSplitTextView) this.f67460i.b(R$id.tv_tag_init_price);
        this.B = (EasyRecyclerView) this.f67460i.b(R$id.erv_currency_about_link);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.B.setLayoutManager(linearLayoutManager);
        this.B.setNestedScrollingEnabled(false);
        this.S = (LinearLayout) this.f67460i.b(R$id.ll_coin_distribution);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R$id.rv_market_info_coin_distribution);
        this.R = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.R.setNestedScrollingEnabled(false);
        this.C = (EasyRecyclerView) this.f67460i.b(R$id.ervSocialMedia);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(0);
        this.C.setLayoutManager(linearLayoutManager2);
        this.C.setNestedScrollingEnabled(false);
        EasyRecyclerView easyRecyclerView2 = (EasyRecyclerView) this.f67460i.b(R$id.position_recycler_view);
        this.I = easyRecyclerView2;
        easyRecyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.I.setNestedScrollingEnabled(false);
        this.I.addItemDecoration(new ea.a(getContext(), 0, PixelUtils.a(50.0f)));
        this.K = this.f67460i.b(R$id.etf_layout);
        this.L = this.f67460i.b(R$id.coin_layout);
        this.M = (LinearLayout) this.f67460i.b(R$id.indtrduce_ht);
        this.f23956j0 = (TextView) this.f67460i.b(R$id.tvRank);
        this.f23957k0 = (TextView) this.f67460i.b(R$id.tvRankTips);
        this.f23959l0 = (TextView) this.f67460i.b(R$id.tvPercentRank);
        this.f23961m0 = (TextView) this.f67460i.b(R$id.tvPercentRankTips);
        this.f23963n0 = (HexagonalRatingView) this.f67460i.b(R$id.vHexagonal);
        this.f23970t0 = (SemicircleProgressView) this.f67460i.b(R$id.sProgress);
        this.X = (TextView) this.f67460i.b(R$id.tvSafetyTips);
        this.Y = (TextView) this.f67460i.b(R$id.tvJumpSafety);
        TextView textView = this.X;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("*");
        sb2.append(getActivity().getResources().getString(R$string.n_kline_title_rating_desc_new));
        sb2.append(p.h(getActivity()) ? "。" : InstructionFileId.DOT);
        textView.setText(sb2.toString());
        TextView textView2 = this.Y;
        if (KLineHelper.f()) {
            i11 = R$drawable.ic_right_arrow;
        } else {
            i11 = R$drawable.ic_right_arrow_light;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, i11, 0);
        this.f23970t0.setOnTextClickListener(new j1(this));
    }

    public void onResume() {
        super.onResume();
        Bi();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_currency_detail, viewGroup, false);
    }
}
