package com.huobi.engineutils.ability;

import al.p;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.grid.bean.GridStrategyInfo;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.ability.s;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.share.AssetShareHelper;
import com.huobi.share.TradingBotShareView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import i6.m;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class AssetJumpAbility implements s {

    public class a extends q6.d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44515e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u6.g gVar, Context context) {
            super(gVar);
            this.f44515e = context;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.j(R$string.ht_exchange_please_wait);
            } else {
                AssetModuleConfig.a().B0(this.f44515e);
            }
        }

        public void onError2(Throwable th2) {
            AssetModuleConfig.a().B0(this.f44515e);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetModuleConfig.a().B0(this.f44515e);
        }
    }

    public class b implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionQuantData f44517a;

        public b(AssetPositionQuantData assetPositionQuantData) {
            this.f44517a = assetPositionQuantData;
        }

        public int a() {
            if (this.f44517a.t() == null || Double.valueOf(this.f44517a.t()).doubleValue() == 0.0d) {
                return R$string.n_grid_share_subtitle_2;
            }
            if (Double.valueOf(this.f44517a.t()).doubleValue() > 0.0d) {
                return R$string.n_grid_share_subtitle_1;
            }
            return R$string.n_grid_share_subtitle_3;
        }

        public int b() {
            if (this.f44517a.t() == null || Double.valueOf(this.f44517a.t()).doubleValue() >= 0.0d) {
                return R$drawable.share_asset_style_1;
            }
            return R$drawable.share_asset_style_2;
        }

        public int c() {
            if (this.f44517a.t() == null || Double.valueOf(this.f44517a.t()).doubleValue() == 0.0d) {
                return R$string.n_grid_share_title_2;
            }
            if (Double.valueOf(this.f44517a.t()).doubleValue() > 0.0d) {
                return R$string.n_grid_share_title_1;
            }
            return R$string.n_grid_share_title_3;
        }
    }

    public class c extends EasySubscriber<GridStrategyInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f44519b;

        public c(Activity activity) {
            this.f44519b = activity;
        }

        /* renamed from: a */
        public void onNext(GridStrategyInfo gridStrategyInfo) {
            if (!this.f44519b.isDestroyed() && !this.f44519b.isFinishing()) {
                AssetJumpAbility.B(this.f44519b, gridStrategyInfo);
            }
        }

        public void onAfter() {
            super.onAfter();
            Activity activity = this.f44519b;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).Df();
            } else if (activity instanceof com.hbg.lib.core.ui.BaseActivity) {
                ((com.hbg.lib.core.ui.BaseActivity) activity).dismissProgressDialog();
            }
        }
    }

    public class d implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44520a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f44521b;

        public d(Context context, View view) {
            this.f44520a = context;
            this.f44521b = view;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            AssetShareHelper.share(this.f44520a, this.f44521b);
        }

        public void d(String str, View view) {
        }
    }

    public class e implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionCoinData f44523a;

        public e(AssetPositionCoinData assetPositionCoinData) {
            this.f44523a = assetPositionCoinData;
        }

        public int a() {
            return 0;
        }

        public int b() {
            if (this.f44523a.v() == null || Double.valueOf(this.f44523a.v()).doubleValue() >= 0.0d) {
                return R$drawable.share_asset_style_1;
            }
            return R$drawable.share_asset_style_2;
        }

        public int c() {
            if (this.f44523a.v() == null || Double.valueOf(this.f44523a.v()).doubleValue() == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (Double.valueOf(this.f44523a.v()).doubleValue() > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    public class f implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionContractData f44525a;

        public f(AssetPositionContractData assetPositionContractData) {
            this.f44525a = assetPositionContractData;
        }

        public int a() {
            return -1;
        }

        public int b() {
            if (this.f44525a.m() == null || Double.valueOf(this.f44525a.m()).doubleValue() >= 0.0d) {
                return R$drawable.share_asset_style_5;
            }
            return R$drawable.share_asset_style_6;
        }

        public int c() {
            if (this.f44525a.m() == null || Double.valueOf(this.f44525a.m()).doubleValue() == 0.0d) {
                return R$string.contract_share_profit_hint2;
            }
            if (Double.valueOf(this.f44525a.m()).doubleValue() > 0.0d) {
                return R$string.contract_share_profit_win_mid_hint1;
            }
            return R$string.contract_share_profit_lose_mid_hint1;
        }
    }

    public class g implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double f44527a;

        public g(double d11) {
            this.f44527a = d11;
        }

        public int a() {
            return 0;
        }

        public int b() {
            double d11 = this.f44527a;
            if (d11 > 0.0d) {
                return R$drawable.share_asset_position_cow_1;
            }
            if (d11 < 0.0d) {
                return R$drawable.share_asset_position_cow_3;
            }
            return R$drawable.share_asset_position_cow_2;
        }

        public int c() {
            double d11 = this.f44527a;
            if (d11 > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            if (d11 < 0.0d) {
                return R$string.n_asset_share_total_less;
            }
            return R$string.n_asset_share_total_same;
        }
    }

    public static void B(Activity activity, GridStrategyInfo gridStrategyInfo) {
        TradingBotShareView tradingBotShareView = new TradingBotShareView(activity);
        tradingBotShareView.setData(gridStrategyInfo);
        tradingBotShareView.a(new ik.c(gridStrategyInfo));
    }

    public static void C(Activity activity, String str, String str2) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).sh();
        } else if (activity instanceof com.hbg.lib.core.ui.BaseActivity) {
            ((com.hbg.lib.core.ui.BaseActivity) activity).showProgressDialog();
        }
        v7.b.a().requestStrategyInfo(str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new c(activity));
    }

    public static /* synthetic */ void o(rj.b bVar) {
        AssetModuleConfig.a().E0(Boolean.TRUE);
        bVar.I("refreshData()");
    }

    public final void A(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", str);
        BaseModuleConfig.a().w("app_assets_tradingbot_tokens_component_click", hashMap);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03fc, code lost:
        r2 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03fd, code lost:
        if (r2 == 0) goto L_0x042b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0400, code lost:
        if (r2 == 1) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0403, code lost:
        if (r2 == 2) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0406, code lost:
        if (r2 == 3) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0408, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x040a, code lost:
        r2 = r24.d().getString(com.hbg.module.asset.R$string.n_asset_point_pledge);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0415, code lost:
        r2 = r24.d().getString(com.hbg.module.asset.R$string.n_asset_earn_large_current_account);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0420, code lost:
        r2 = r24.d().getString(com.hbg.module.asset.R$string.n_mining_asset_fixed);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x042b, code lost:
        r2 = r24.d().getString(com.hbg.module.asset.R$string.n_asset_earn_current);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0435, code lost:
        r1.L(r3);
        w(r24.d(), r1, r2);
        r14.a(true, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        r11 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r24, java.lang.Object r25, com.huobi.edgeengine.ability.AbilityFunction.a r26) {
        /*
            r23 = this;
            r13 = r23
            r1 = r25
            r14 = r26
            if (r14 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x09ba
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x09ab }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x09ab }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x09ab }
            java.lang.String r1 = "Console"
            java.lang.String r4 = r2.toString()     // Catch:{ JSONException -> 0x09ab }
            android.util.Log.e(r1, r4)     // Catch:{ JSONException -> 0x09ab }
            java.lang.String r1 = "type"
            int r1 = r2.getInt(r1)     // Catch:{ JSONException -> 0x09ab }
            r4 = 117(0x75, float:1.64E-43)
            java.lang.String r5 = "contractCode"
            java.lang.String r6 = "tradeType"
            java.lang.String r7 = "symbol"
            java.lang.String r11 = ""
            if (r1 == r4) goto L_0x0989
            r4 = 118(0x76, float:1.65E-43)
            java.lang.String r8 = "profitRate"
            java.lang.String r9 = "1"
            java.lang.String r10 = "usdt"
            if (r1 == r4) goto L_0x08d7
            r4 = 155(0x9b, float:2.17E-43)
            java.lang.String r12 = "currency"
            if (r1 == r4) goto L_0x08bd
            r4 = 166(0xa6, float:2.33E-43)
            if (r1 == r4) goto L_0x08a1
            r4 = 207(0xcf, float:2.9E-43)
            if (r1 == r4) goto L_0x088a
            java.lang.String r4 = "quoteCurrency"
            java.lang.String r3 = "details"
            java.lang.String r15 = "projectType"
            r17 = r3
            java.lang.String r3 = "coinID"
            r18 = r6
            java.lang.String r6 = "id"
            r19 = r6
            java.lang.String r6 = "2"
            r20 = r5
            java.lang.String r5 = "0"
            r21 = r7
            java.lang.String r7 = "stable"
            r22 = r3
            java.lang.String r3 = "isSuperMargin"
            switch(r1) {
                case 1: goto L_0x0854;
                case 2: goto L_0x0821;
                case 3: goto L_0x0800;
                case 4: goto L_0x07e3;
                case 5: goto L_0x07be;
                case 6: goto L_0x0762;
                case 7: goto L_0x0740;
                case 8: goto L_0x0718;
                case 9: goto L_0x06f2;
                case 10: goto L_0x06d4;
                case 11: goto L_0x06a1;
                case 12: goto L_0x067b;
                case 13: goto L_0x065b;
                case 14: goto L_0x0603;
                case 15: goto L_0x05dc;
                case 16: goto L_0x05ab;
                case 17: goto L_0x04fc;
                case 18: goto L_0x04ef;
                case 19: goto L_0x04da;
                case 20: goto L_0x04bd;
                case 21: goto L_0x04a0;
                case 22: goto L_0x046c;
                case 23: goto L_0x0466;
                case 24: goto L_0x0445;
                case 25: goto L_0x03a5;
                case 26: goto L_0x038e;
                case 27: goto L_0x0371;
                case 28: goto L_0x0339;
                case 29: goto L_0x030f;
                case 30: goto L_0x0309;
                case 31: goto L_0x0303;
                case 32: goto L_0x02af;
                case 33: goto L_0x027c;
                case 34: goto L_0x0261;
                case 35: goto L_0x024e;
                case 36: goto L_0x0241;
                case 37: goto L_0x021e;
                case 38: goto L_0x01e8;
                case 39: goto L_0x01cd;
                case 40: goto L_0x01bb;
                case 41: goto L_0x01ab;
                case 42: goto L_0x05dc;
                case 43: goto L_0x05ab;
                case 44: goto L_0x04fc;
                default: goto L_0x0068;
            }
        L_0x0068:
            switch(r1) {
                case 50: goto L_0x0199;
                case 51: goto L_0x0189;
                case 52: goto L_0x0179;
                case 53: goto L_0x0169;
                case 54: goto L_0x0139;
                default: goto L_0x006b;
            }
        L_0x006b:
            java.lang.String r3 = "null"
            java.lang.String r4 = "url"
            switch(r1) {
                case 137: goto L_0x010c;
                case 138: goto L_0x00f1;
                case 139: goto L_0x00f1;
                case 140: goto L_0x00f1;
                case 141: goto L_0x00e4;
                default: goto L_0x0072;
            }
        L_0x0072:
            switch(r1) {
                case 158: goto L_0x00c1;
                case 159: goto L_0x00ad;
                case 160: goto L_0x009d;
                case 161: goto L_0x008d;
                case 162: goto L_0x007d;
                default: goto L_0x0075;
            }
        L_0x0075:
            r1 = 0
            r3 = 0
            r14.a(r1, r3)     // Catch:{ JSONException -> 0x049b }
        L_0x007a:
            r11 = r13
            goto L_0x09c0
        L_0x007d:
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r2.c1(r3, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x008d:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            r1.Z(r3, r2)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x009d:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            r1.W0(r3, r2)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x00ad:
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r4 = 1
            r2.P0(r3, r1, r4)     // Catch:{ JSONException -> 0x049b }
            r14.a(r4, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x00c1:
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            boolean r2 = r2.getBoolean(r7)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x00d3
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            al.k.d(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x00df
        L_0x00d3:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            al.k.e(r2, r1)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r1 = "trade"
            r13.y(r1)     // Catch:{ JSONException -> 0x049b }
        L_0x00df:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x00e4:
            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ JSONException -> 0x049b }
            com.huobi.asset.event.TodayProfitHintEvent r2 = new com.huobi.asset.event.TodayProfitHintEvent     // Catch:{ JSONException -> 0x049b }
            r2.<init>()     // Catch:{ JSONException -> 0x049b }
            r1.k(r2)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x00f1:
            java.lang.String r1 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x049b }
            if (r2 != 0) goto L_0x010b
            boolean r2 = r1.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x0102
            goto L_0x010b
        L_0x0102:
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            r2.m(r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x010b:
            return
        L_0x010c:
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r5 = "app_assets_spot_autoEarnEntrance_click"
            r6 = 0
            r1.w(r5, r6)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r1 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x049b }
            if (r2 != 0) goto L_0x0138
            boolean r2 = r1.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x0127
            goto L_0x0138
        L_0x0127:
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r2.l(r3, r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0138:
            return
        L_0x0139:
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = "financialJumpUrl"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x049b }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x049b }
            if (r3 == 0) goto L_0x0155
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r2.S0(r3, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x015d
        L_0x0155:
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r3 = 0
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r1, r2, r11, r11, r3)     // Catch:{ JSONException -> 0x049b }
        L_0x015d:
            java.lang.String r1 = "earn"
            r13.y(r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0169:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0"
            r1.a1(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0179:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/copyTradingTransferRecord"
            r1.a1(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0189:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=usdt&account=13"
            r1.a1(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0199:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.M(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x01ab:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.N(r2)     // Catch:{ JSONException -> 0x049b }
            gi.a.u()     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x01bb:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.o0(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x01cd:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.V(r2)     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "app_assets_collateral_borrow_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r3)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x01e8:
            com.huobi.view.BottomAlterCostDialogFragment r1 = new com.huobi.view.BottomAlterCostDialogFragment     // Catch:{ JSONException -> 0x049b }
            r1.<init>()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ JSONException -> 0x049b }
            r4.<init>()     // Catch:{ JSONException -> 0x049b }
            r4.putString(r12, r2)     // Catch:{ JSONException -> 0x049b }
            r1.setArguments(r4)     // Catch:{ JSONException -> 0x049b }
            ik.d r2 = new ik.d     // Catch:{ JSONException -> 0x049b }
            r2.<init>(r14)     // Catch:{ JSONException -> 0x049b }
            r1.setOnDialogCloseCallback(r2)     // Catch:{ JSONException -> 0x049b }
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3     // Catch:{ JSONException -> 0x049b }
            androidx.fragment.app.FragmentManager r2 = r3.getSupportFragmentManager()     // Catch:{ JSONException -> 0x049b }
            java.lang.Class<com.huobi.view.BottomAlterCostDialogFragment> r3 = com.huobi.view.BottomAlterCostDialogFragment.class
            java.lang.String r3 = r3.getName()     // Catch:{ JSONException -> 0x049b }
            r1.show(r2, r3)     // Catch:{ JSONException -> 0x049b }
            r1 = 0
            r2 = 1
            r14.a(r2, r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x021e:
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "app_assets_income_analysis_open_button_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x049b }
            com.huobi.finance.ui.g7 r1 = new com.huobi.finance.ui.g7     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            ik.b r4 = new ik.b     // Catch:{ JSONException -> 0x049b }
            r7 = r24
            r4.<init>(r7)     // Catch:{ JSONException -> 0x049b }
            r1.<init>(r2, r3, r4)     // Catch:{ JSONException -> 0x049b }
            r1.f()     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0241:
            r7 = r24
            r15 = r11
            r11 = r13
            r5 = r18
            r4 = r20
            r3 = r21
        L_0x024b:
            r13 = 1
            goto L_0x0990
        L_0x024e:
            r7 = r24
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.m1(r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0261:
            r7 = r24
            boolean r1 = r2.getBoolean(r3)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r3.C0(r4, r1, r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x027c:
            r7 = r24
            boolean r1 = r2.getBoolean(r3)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            if (r1 == 0) goto L_0x0294
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.f0(r2, r3)     // Catch:{ JSONException -> 0x049b }
            goto L_0x02a9
        L_0x0294:
            java.lang.String r1 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = "baseCurrency"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x049b }
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r3.t(r4, r1, r2)     // Catch:{ JSONException -> 0x049b }
        L_0x02a9:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x02af:
            r7 = r24
            boolean r1 = r2.getBoolean(r3)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            if (r1 == 0) goto L_0x02ef
            boolean r1 = r10.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x049b }
            if (r1 == 0) goto L_0x02d0
            d7.a1 r1 = d7.a1.v()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "btc"
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r1 = r1.t(r2)     // Catch:{ JSONException -> 0x049b }
            goto L_0x02d8
        L_0x02d0:
            d7.a1 r1 = d7.a1.v()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r1 = r1.t(r2)     // Catch:{ JSONException -> 0x049b }
        L_0x02d8:
            if (r1 != 0) goto L_0x02e0
            int r1 = com.hbg.module.asset.R$string.n_not_support     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)     // Catch:{ JSONException -> 0x049b }
            goto L_0x02fd
        L_0x02e0:
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ JSONException -> 0x049b }
            r5 = 0
            r2.A0(r3, r1, r5, r4)     // Catch:{ JSONException -> 0x049b }
            goto L_0x02fd
        L_0x02ef:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ JSONException -> 0x049b }
            r5 = 0
            r1.e(r3, r2, r5, r4)     // Catch:{ JSONException -> 0x049b }
        L_0x02fd:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0303:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0309:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x030f:
            r7 = r24
            com.huobi.finance.bean.AssetPositionWarrantData r1 = new com.huobi.finance.bean.AssetPositionWarrantData     // Catch:{ JSONException -> 0x049b }
            r1.<init>()     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo r3 = new com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo     // Catch:{ JSONException -> 0x049b }
            r3.<init>()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r4 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            r3.setCurrency(r4)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r8)     // Catch:{ JSONException -> 0x049b }
            r3.setProfitRate(r2)     // Catch:{ JSONException -> 0x049b }
            r1.j(r3)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r13.v(r2, r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0339:
            r7 = r24
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = "availableNum"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r4 = "positionNum"
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            com.huobi.finance.bean.OtcOptionsDetailInfo r4 = new com.huobi.finance.bean.OtcOptionsDetailInfo     // Catch:{ JSONException -> 0x049b }
            r4.<init>()     // Catch:{ JSONException -> 0x049b }
            r4.setCurrency(r1)     // Catch:{ JSONException -> 0x049b }
            r4.setHoldingsNum(r2)     // Catch:{ JSONException -> 0x049b }
            r4.setAvaialAble(r3)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r1 = r13.g(r1, r3)     // Catch:{ JSONException -> 0x049b }
            r4.setEstimateAmount(r1)     // Catch:{ JSONException -> 0x049b }
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r1.x(r2, r4)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0371:
            r7 = r24
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            boolean r3 = r2 instanceof android.app.Activity     // Catch:{ JSONException -> 0x049b }
            if (r3 == 0) goto L_0x0388
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ JSONException -> 0x049b }
            r3.y0(r2, r1)     // Catch:{ JSONException -> 0x049b }
        L_0x0388:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x038e:
            r7 = r24
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r2.R0(r3, r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x03a5:
            r7 = r24
            com.huobi.finance.bean.AssetPositionCoinData r1 = new com.huobi.finance.bean.AssetPositionCoinData     // Catch:{ JSONException -> 0x049b }
            r1.<init>()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = "miningYearRate"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x049b }
            boolean r4 = i6.m.a0(r3)     // Catch:{ JSONException -> 0x049b }
            if (r4 != 0) goto L_0x03b9
            goto L_0x03ba
        L_0x03b9:
            r5 = r3
        L_0x03ba:
            r1.N(r5)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r15)     // Catch:{ JSONException -> 0x049b }
            r4 = -1
            int r5 = r2.hashCode()     // Catch:{ JSONException -> 0x049b }
            switch(r5) {
                case 49: goto L_0x03f4;
                case 50: goto L_0x03ec;
                case 51: goto L_0x03e2;
                case 52: goto L_0x03d8;
                case 53: goto L_0x03ce;
                default: goto L_0x03cd;
            }     // Catch:{ JSONException -> 0x049b }
        L_0x03cd:
            goto L_0x03fc
        L_0x03ce:
            java.lang.String r5 = "5"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x03fc
            r2 = 4
            goto L_0x03fd
        L_0x03d8:
            java.lang.String r5 = "4"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x03fc
            r2 = 3
            goto L_0x03fd
        L_0x03e2:
            java.lang.String r5 = "3"
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x03fc
            r2 = 2
            goto L_0x03fd
        L_0x03ec:
            boolean r2 = r2.equals(r6)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x03fc
            r2 = 1
            goto L_0x03fd
        L_0x03f4:
            boolean r2 = r2.equals(r9)     // Catch:{ JSONException -> 0x049b }
            if (r2 == 0) goto L_0x03fc
            r2 = 0
            goto L_0x03fd
        L_0x03fc:
            r2 = r4
        L_0x03fd:
            if (r2 == 0) goto L_0x042b
            r4 = 1
            if (r2 == r4) goto L_0x0420
            r4 = 2
            if (r2 == r4) goto L_0x0415
            r4 = 3
            if (r2 == r4) goto L_0x040a
            r2 = r11
            goto L_0x0435
        L_0x040a:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            int r4 = com.hbg.module.asset.R$string.n_asset_point_pledge     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            goto L_0x0435
        L_0x0415:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            int r4 = com.hbg.module.asset.R$string.n_asset_earn_large_current_account     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            goto L_0x0435
        L_0x0420:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            int r4 = com.hbg.module.asset.R$string.n_mining_asset_fixed     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
            goto L_0x0435
        L_0x042b:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            int r4 = com.hbg.module.asset.R$string.n_asset_earn_current     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x049b }
        L_0x0435:
            r1.L(r3)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r13.w(r3, r1, r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0445:
            r7 = r24
            java.lang.String r1 = "orderId"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = r2.getString(r15)     // Catch:{ JSONException -> 0x049b }
            boolean r3 = r5.equals(r2)     // Catch:{ JSONException -> 0x049b }
            bc.a r4 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r5 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r4.P(r5, r1, r3, r2)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x0466:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x046c:
            r7 = r24
            java.lang.String r1 = "projectInfoUrl"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r2 = "JUMP_EARN_DEPOSIT"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x049b }
            r3.<init>()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r4 = "projectInfoUrl : "
            r3.append(r4)     // Catch:{ JSONException -> 0x049b }
            r3.append(r1)     // Catch:{ JSONException -> 0x049b }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x049b }
            i6.d.c(r2, r3)     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            r2.d0(r3, r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x049b:
            r0 = move-exception
            r1 = r0
            r11 = r13
            goto L_0x09ae
        L_0x04a0:
            r7 = r24
            r1 = r22
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x049b }
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x049b }
            int r1 = i6.m.k0(r1)     // Catch:{ JSONException -> 0x049b }
            r2.J0(r3, r1)     // Catch:{ JSONException -> 0x049b }
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x04bd:
            r7 = r24
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            boolean r3 = r2 instanceof android.app.Activity     // Catch:{ JSONException -> 0x049b }
            if (r3 == 0) goto L_0x04d4
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x049b }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ JSONException -> 0x049b }
            r3.k1(r2, r1, r6)     // Catch:{ JSONException -> 0x049b }
        L_0x04d4:
            r1 = 1
            r14.a(r1, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x04da:
            r7 = r24
            r1 = r22
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x049b }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x049b }
            jp.k0.p(r2, r1)     // Catch:{ JSONException -> 0x049b }
            r12 = 1
            r14.a(r12, r11)     // Catch:{ JSONException -> 0x049b }
            goto L_0x007a
        L_0x04ef:
            r7 = r24
            r15 = r11
            r11 = r13
            r5 = r18
            r4 = r20
            r3 = r21
        L_0x04f9:
            r13 = 1
            goto L_0x08de
        L_0x04fc:
            r7 = r24
            r12 = 1
            r3 = r21
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x05d7 }
            r4 = r20
            java.lang.String r4 = r2.getString(r4)     // Catch:{ JSONException -> 0x05d7 }
            r5 = r18
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x05d7 }
            com.hbg.lib.data.symbol.TradeType r6 = r13.k(r5)     // Catch:{ JSONException -> 0x05d7 }
            boolean r8 = r5.equalsIgnoreCase(r9)     // Catch:{ JSONException -> 0x05d7 }
            if (r8 == 0) goto L_0x0526
            java.lang.String r8 = "marginMode"
            java.lang.String r8 = r2.getString(r8)     // Catch:{ JSONException -> 0x049b }
            boolean r8 = r13.h(r5, r8)     // Catch:{ JSONException -> 0x049b }
            goto L_0x0527
        L_0x0526:
            r8 = 0
        L_0x0527:
            boolean r15 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x05d7 }
            if (r15 == 0) goto L_0x053b
            com.hbg.lib.data.symbol.TradeType r15 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ JSONException -> 0x049b }
            if (r6 != r15) goto L_0x053b
            boolean r10 = r10.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x049b }
            if (r10 == 0) goto L_0x053b
            if (r8 == 0) goto L_0x053b
            java.lang.String r4 = "BTC-USDT"
        L_0x053b:
            boolean r5 = r5.equals(r9)     // Catch:{ JSONException -> 0x05d7 }
            if (r5 == 0) goto L_0x054c
            com.hbg.lib.data.future.controller.FutureContractInfoController r5 = com.hbg.lib.data.future.controller.FutureContractInfoController.n()     // Catch:{ JSONException -> 0x049b }
            com.hbg.lib.data.future.bean.FutureContractInfo r5 = r5.o(r4)     // Catch:{ JSONException -> 0x049b }
            r16 = r5
            goto L_0x054e
        L_0x054c:
            r16 = 0
        L_0x054e:
            if (r16 == 0) goto L_0x055b
            java.lang.String r5 = r16.getPair()     // Catch:{ JSONException -> 0x049b }
            java.lang.String r9 = r16.getTradePartition()     // Catch:{ JSONException -> 0x049b }
            r10 = r9
            r9 = r5
            goto L_0x055d
        L_0x055b:
            r9 = r11
            r10 = r9
        L_0x055d:
            r5 = 44
            if (r1 != r5) goto L_0x0563
            r15 = r12
            goto L_0x0564
        L_0x0563:
            r15 = 0
        L_0x0564:
            java.lang.String r1 = "available"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Exception -> 0x0583 }
            java.lang.String r5 = "equity"
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x057f }
            java.lang.String r12 = "assetType"
            int r2 = r2.getInt(r12)     // Catch:{ Exception -> 0x057c }
            r12 = r1
            r17 = r2
            r16 = r5
            goto L_0x058f
        L_0x057c:
            r0 = move-exception
            r2 = r0
            goto L_0x0587
        L_0x057f:
            r0 = move-exception
            r2 = r0
            r5 = r11
            goto L_0x0587
        L_0x0583:
            r0 = move-exception
            r2 = r0
            r1 = r11
            r5 = r1
        L_0x0587:
            r2.printStackTrace()     // Catch:{ JSONException -> 0x05d7 }
            r12 = r1
            r16 = r5
            r17 = 0
        L_0x058f:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x05d7 }
            r1 = r23
            r5 = r6
            r6 = r9
            r7 = r8
            r8 = r10
            r9 = r15
            r10 = r12
            r15 = r11
            r11 = r16
            r13 = 1
            r12 = r17
            r1.t(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ JSONException -> 0x05d7 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x05d7 }
            r11 = r23
            goto L_0x09c0
        L_0x05ab:
            r7 = r24
            r15 = r11
            r5 = r18
            r3 = r21
            r13 = 1
            java.lang.String r1 = r2.getString(r3)     // Catch:{ JSONException -> 0x05d7 }
            java.lang.String r2 = r2.getString(r5)     // Catch:{ JSONException -> 0x05d7 }
            r11 = r23
            java.lang.String r2 = r11.i(r2)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            boolean r4 = r3 instanceof android.app.Activity     // Catch:{ JSONException -> 0x0887 }
            if (r4 == 0) goto L_0x05d2
            bc.a r4 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ JSONException -> 0x0887 }
            r4.k1(r3, r1, r2)     // Catch:{ JSONException -> 0x0887 }
        L_0x05d2:
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x05d7:
            r0 = move-exception
            r11 = r23
            goto L_0x09ad
        L_0x05dc:
            r7 = r24
            r15 = r11
            r11 = r13
            r5 = r18
            r4 = r20
            r3 = r21
            r13 = 1
            java.lang.String r1 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = r2.getString(r5)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.data.symbol.TradeType r2 = r11.k(r2)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.u(r4, r1, r3, r2)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0603:
            r7 = r24
            r15 = r11
            r11 = r13
            r13 = 1
            com.huobi.finance.bean.AssetPositionQuantData r1 = new com.huobi.finance.bean.AssetPositionQuantData     // Catch:{ JSONException -> 0x0887 }
            r1.<init>()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "totalProfitRate"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.H(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "symbolTitle"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.G(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            r1.B(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "minPrice"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.y(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "maxPrice"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.x(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "tradeNum"
            int r3 = r2.getInt(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.I(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "runTime"
            long r2 = r2.getLong(r3)     // Catch:{ JSONException -> 0x0887 }
            r1.C(r2)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.z(r2, r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = "share"
            r11.A(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x065b:
            r7 = r24
            r15 = r11
            r11 = r13
            r13 = 1
            r1 = r19
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0887 }
            bc.a r2 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r2.K(r3, r1)     // Catch:{ JSONException -> 0x0887 }
            r1 = r17
            r11.A(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x067b:
            r7 = r24
            r15 = r11
            r11 = r13
            r1 = r19
            r13 = 1
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "createPath"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r3.p0(r4, r2, r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = "action"
            r11.A(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x06a1:
            r7 = r24
            r15 = r11
            r11 = r13
            r13 = 1
            com.huobi.finance.bean.AssetPositionCoinData r1 = new com.huobi.finance.bean.AssetPositionCoinData     // Catch:{ JSONException -> 0x0887 }
            r1.<init>()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "todayProfitRate"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            boolean r4 = i6.m.a0(r3)     // Catch:{ JSONException -> 0x0887 }
            if (r4 != 0) goto L_0x06b8
            goto L_0x06b9
        L_0x06b8:
            r5 = r3
        L_0x06b9:
            r1.N(r5)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            r1.L(r2)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.w(r2, r1, r15)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = "share"
            r11.y(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x06d4:
            r7 = r24
            r15 = r11
            r11 = r13
            r1 = r17
            r13 = 1
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            bc.a r3 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r3.I(r4, r2)     // Catch:{ JSONException -> 0x0887 }
            r11.y(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x06f2:
            r15 = r11
            r11 = r13
            r13 = 1
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            boolean r2 = r2.getBoolean(r7)     // Catch:{ JSONException -> 0x0887 }
            if (r2 == 0) goto L_0x0707
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            al.k.d(r2, r1)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0713
        L_0x0707:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            al.k.c(r2, r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = "trade"
            r11.y(r1)     // Catch:{ JSONException -> 0x0887 }
        L_0x0713:
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0718:
            r15 = r11
            r11 = r13
            r13 = 1
            java.lang.String r1 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            boolean r2 = r2.getBoolean(r7)     // Catch:{ JSONException -> 0x0887 }
            if (r2 == 0) goto L_0x072f
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            int r2 = com.hbg.module.asset.R$string.n_not_support     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.widgets.utils.HuobiToastUtil.k(r1, r2)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x073b
        L_0x072f:
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            al.k.a(r2, r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = "markets"
            r11.y(r1)     // Catch:{ JSONException -> 0x0887 }
        L_0x073b:
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0740:
            r15 = r11
            r11 = r13
            r13 = 1
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "3560"
            r3 = 0
            r1.L0(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_convert_small_balances__click"
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.m(r1)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0762:
            r15 = r11
            r11 = r13
            r13 = 1
            boolean r1 = r23.n()     // Catch:{ JSONException -> 0x0887 }
            if (r1 == 0) goto L_0x0779
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            int r2 = com.hbg.module.asset.R$string.n_asset_new_user_check_profit_and_loss_daily     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.widgets.utils.HuobiToastUtil.v(r1)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x07b9
        L_0x0779:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r1.N(r2)     // Catch:{ JSONException -> 0x0887 }
            gi.a.k()     // Catch:{ JSONException -> 0x0887 }
            qh.p0 r1 = qh.p0.n()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.network.hbg.core.bean.AssetDailyData r1 = r1.k()     // Catch:{ JSONException -> 0x0887 }
            boolean r1 = r1.displayGuideDot()     // Catch:{ JSONException -> 0x0887 }
            if (r1 == 0) goto L_0x07b9
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_PLDailyPaper_RedDot_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            qh.p0 r1 = qh.p0.n()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.network.hbg.core.bean.AssetDailyData r1 = r1.k()     // Catch:{ JSONException -> 0x0887 }
            r1.reset()     // Catch:{ JSONException -> 0x0887 }
            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ JSONException -> 0x0887 }
            qh.p0 r2 = qh.p0.n()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.network.hbg.core.bean.AssetDailyData r2 = r2.k()     // Catch:{ JSONException -> 0x0887 }
            r1.k(r2)     // Catch:{ JSONException -> 0x0887 }
        L_0x07b9:
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x07be:
            r15 = r11
            r11 = r13
            r13 = 1
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            u6.g r3 = (u6.g) r3     // Catch:{ JSONException -> 0x0887 }
            r1.B(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_cloud_wallet_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x07e3:
            r15 = r11
            r11 = r13
            r13 = 1
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r1.R(r2)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_history_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0800:
            r15 = r11
            r11 = r13
            r13 = 1
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = "11"
            r1.k1(r2, r10, r3)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_transfer_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0821:
            r15 = r11
            r11 = r13
            r13 = 1
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            boolean r1 = r1.c()     // Catch:{ JSONException -> 0x0887 }
            if (r1 == 0) goto L_0x0838
            int r1 = com.hbg.module.asset.R$string.n_balance_subaccount_withdraw_nosupport     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)     // Catch:{ JSONException -> 0x0887 }
            r1 = 0
            r14.a(r1, r15)     // Catch:{ JSONException -> 0x0887 }
            return
        L_0x0838:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ JSONException -> 0x0887 }
            r1.v0(r2, r6)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_withdraw_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0854:
            r15 = r11
            r11 = r13
            r13 = 1
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            boolean r1 = r1.c()     // Catch:{ JSONException -> 0x0887 }
            if (r1 == 0) goto L_0x086b
            int r1 = com.hbg.module.asset.R$string.n_balance_subaccount_deposit_nosupport     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r1)     // Catch:{ JSONException -> 0x0887 }
            r1 = 0
            r14.a(r1, r15)     // Catch:{ JSONException -> 0x0887 }
            return
        L_0x086b:
            bc.a r1 = com.hbg.module.asset.AssetModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r2 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ JSONException -> 0x0887 }
            r1.v0(r2, r9)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = "app_assets_deposit_click"
            r3 = 0
            r1.w(r2, r3)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0887:
            r0 = move-exception
            goto L_0x09ad
        L_0x088a:
            r3 = r7
            r11 = r13
            java.lang.String r1 = "strategyId"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r3 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ JSONException -> 0x0887 }
            C(r3, r1, r2)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x08a1:
            r15 = r11
            r11 = r13
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r2 = r1
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2     // Catch:{ JSONException -> 0x0887 }
            int r3 = com.hbg.module.asset.R$string.n_withdrawal_restriction_pop_str     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            int r4 = com.hbg.module.asset.R$string.n_otc_optional_process_know     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = r1.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            ik.a r4 = ik.a.f55105a     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.widgets.dialog.DialogUtils.Y(r2, r3, r15, r1, r4)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x08bd:
            r11 = r13
            java.lang.String r1 = "projectName"
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r4 = "yearRate"
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.x(r4, r3, r1, r2)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x08d7:
            r4 = r5
            r5 = r6
            r3 = r7
            r15 = r11
            r11 = r13
            goto L_0x04f9
        L_0x08de:
            java.lang.String r1 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r4 = r2.getString(r8)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r6 = "direction"
            java.lang.String r6 = r2.getString(r6)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r7 = "leverRate"
            java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r8 = "openPrice"
            java.lang.String r8 = r2.getString(r8)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r12 = "lastPrice"
            java.lang.String r2 = r2.getString(r12)     // Catch:{ JSONException -> 0x0887 }
            boolean r9 = r5.equals(r9)     // Catch:{ JSONException -> 0x0887 }
            if (r9 == 0) goto L_0x0915
            com.hbg.lib.data.future.controller.FutureContractInfoController r9 = com.hbg.lib.data.future.controller.FutureContractInfoController.n()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.data.future.bean.FutureContractInfo r9 = r9.o(r3)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0916
        L_0x0915:
            r9 = 0
        L_0x0916:
            if (r9 == 0) goto L_0x0923
            java.lang.String r12 = r9.getTradePartition()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r5 = r11.j(r5, r1, r12)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r9 = r9.contractType     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0951
        L_0x0923:
            java.lang.String r5 = r11.j(r5, r1, r15)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r9 = com.huobi.contract.helper.ContractCurrencyUtils.h(r3)     // Catch:{ JSONException -> 0x0887 }
            if (r9 == 0) goto L_0x0932
            java.lang.String r9 = r9.getContractType()     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0951
        L_0x0932:
            com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController r9 = com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController.k()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r9 = r9.q(r3)     // Catch:{ JSONException -> 0x0887 }
            if (r9 == 0) goto L_0x0941
            java.lang.String r9 = r9.getContractType()     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0951
        L_0x0941:
            com.hbg.lib.data.future.controller.FutureContractInfoController r9 = com.hbg.lib.data.future.controller.FutureContractInfoController.n()     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.data.future.bean.FutureContractInfo r9 = r9.o(r3)     // Catch:{ JSONException -> 0x0887 }
            if (r9 == 0) goto L_0x0950
            java.lang.String r9 = r9.getContractType()     // Catch:{ JSONException -> 0x0887 }
            goto L_0x0951
        L_0x0950:
            r9 = r15
        L_0x0951:
            com.huobi.finance.bean.AssetPositionContractData r12 = new com.huobi.finance.bean.AssetPositionContractData     // Catch:{ JSONException -> 0x0887 }
            r12.<init>()     // Catch:{ JSONException -> 0x0887 }
            r12.O(r4)     // Catch:{ JSONException -> 0x0887 }
            r12.b0(r5)     // Catch:{ JSONException -> 0x0887 }
            r12.P(r6)     // Catch:{ JSONException -> 0x0887 }
            r12.R(r7)     // Catch:{ JSONException -> 0x0887 }
            r12.a0(r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = al.p.j(r8, r10)     // Catch:{ JSONException -> 0x0887 }
            r12.Z(r1)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = al.p.j(r2, r10)     // Catch:{ JSONException -> 0x0887 }
            r12.Q(r1)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r1 = a7.e.q(r1, r3, r9)     // Catch:{ JSONException -> 0x0887 }
            r12.T(r1)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r1 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.f(r1, r12)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x0989:
            r4 = r5
            r5 = r6
            r3 = r7
            r15 = r11
            r11 = r13
            goto L_0x024b
        L_0x0990:
            java.lang.String r1 = r2.getString(r3)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ JSONException -> 0x0887 }
            java.lang.String r2 = r2.getString(r5)     // Catch:{ JSONException -> 0x0887 }
            com.hbg.lib.data.symbol.TradeType r2 = r11.k(r2)     // Catch:{ JSONException -> 0x0887 }
            android.content.Context r4 = r24.d()     // Catch:{ JSONException -> 0x0887 }
            r11.s(r4, r1, r3, r2)     // Catch:{ JSONException -> 0x0887 }
            r14.a(r13, r15)     // Catch:{ JSONException -> 0x0887 }
            goto L_0x09c0
        L_0x09ab:
            r0 = move-exception
            r11 = r13
        L_0x09ad:
            r1 = r0
        L_0x09ae:
            r1.printStackTrace()
            java.lang.String r1 = r1.getMessage()
            r2 = 0
            r14.a(r2, r1)
            goto L_0x09c0
        L_0x09ba:
            r11 = r13
            r1 = 0
            r2 = 0
            r14.a(r2, r1)
        L_0x09c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.engineutils.ability.AssetJumpAbility.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final void f(Context context, AssetPositionContractData assetPositionContractData) {
        int i11;
        View loadNewView = AssetShareHelper.loadNewView(context, assetPositionContractData.m(), new f(assetPositionContractData), 3);
        loadNewView.findViewById(R$id.ll_symbol).setVisibility(0);
        loadNewView.findViewById(R$id.llTrade).setVisibility(0);
        TextView textView = (TextView) loadNewView.findViewById(R$id.tv_symbol);
        textView.setText(assetPositionContractData.C().toUpperCase() + " " + assetPositionContractData.t());
        textView.setVisibility(0);
        boolean equalsIgnoreCase = "buy".equalsIgnoreCase(assetPositionContractData.n());
        TextView textView2 = (TextView) loadNewView.findViewById(R$id.tv_trade_type);
        Resources resources = context.getResources();
        if (equalsIgnoreCase) {
            i11 = w.h();
        } else {
            i11 = w.d();
        }
        textView2.setTextColor(resources.getColor(i11));
        textView2.setText(context.getResources().getString(equalsIgnoreCase ? R$string.market_info_trade_buy_type : R$string.market_info_trade_sell_type));
        TextView textView3 = (TextView) loadNewView.findViewById(R$id.tv_trade_times);
        textView3.setText(assetPositionContractData.r() + "x");
        textView3.setVisibility(0);
        ((TextView) loadNewView.findViewById(R$id.tv_today_tips)).setText(context.getResources().getString(R$string.n_contract_yield));
        TextView textView4 = (TextView) loadNewView.findViewById(R$id.tv_now_price);
        TextView textView5 = (TextView) loadNewView.findViewById(R$id.tv_tips2);
        TextView textView6 = (TextView) loadNewView.findViewById(R$id.tv_open_price);
        ((TextView) loadNewView.findViewById(R$id.tv_tips)).setText(context.getResources().getString(R$string.contarct_share_position_cur_price));
        textView4.setText(assetPositionContractData.q());
        textView5.setText(context.getResources().getString(R$string.n_contract_avg_open_price));
        textView6.setText(assetPositionContractData.A());
        textView4.setVisibility(0);
        textView5.setVisibility(0);
        textView6.setVisibility(0);
        AssetShareHelper.share(context, loadNewView);
    }

    public final String g(String str, String str2) {
        String d11 = LegalCurrencyConfigUtil.d();
        if ("btc".equals(d11)) {
            return LegalCurrencyConfigUtil.Q("btc", l(str, str2));
        }
        if ("usdt".equals(d11)) {
            return p.j(l(str, str2), "usdt");
        }
        return LegalCurrencyConfigUtil.i(str, str2);
    }

    public final boolean h(String str, String str2) {
        if (str.equalsIgnoreCase("1")) {
            if ((FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(str2) ? (char) 1 : 2) == 1) {
                return true;
            }
            return false;
        }
        str.equalsIgnoreCase("2");
        return false;
    }

    public final String i(String str) {
        if (str.equalsIgnoreCase("1")) {
            return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
        }
        return str.equalsIgnoreCase("2") ? BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP : "4";
    }

    public final String j(String str, String str2, String str3) {
        if (str.equalsIgnoreCase("1")) {
            if (!TextUtils.isEmpty(str3)) {
                return str2 + "/" + str3;
            }
            return str2 + "/USDT";
        } else if (str.equalsIgnoreCase("2")) {
            return str2 + "/USD";
        } else {
            return str2 + "/USD";
        }
    }

    public final TradeType k(String str) {
        if (str.equalsIgnoreCase("1")) {
            return TradeType.LINEAR_SWAP;
        }
        if (str.equalsIgnoreCase("2")) {
            return TradeType.SWAP;
        }
        return TradeType.CONTRACT;
    }

    public final String l(String str, String str2) {
        if (!LegalCurrencyConfigUtil.Z(str)) {
            return "0.00";
        }
        return m.a(str2).multiply(LegalCurrencyConfigUtil.H(str)).toPlainString();
    }

    public final void m(Context context) {
        u6.g gVar = (u6.g) context;
        v7.b.a().getHtExchangeSubmitStatus().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar, context));
    }

    public final boolean n() {
        long O0 = AssetModuleConfig.a().O0();
        Calendar instance = Calendar.getInstance();
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(11, 0);
        instance.set(14, 0);
        if (O0 > instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }

    public final void s(Context context, String str, String str2, TradeType tradeType) {
        if (tradeType == TradeType.CONTRACT) {
            AssetModuleConfig.a().f1(context, str, str2);
        } else if (tradeType == TradeType.SWAP) {
            AssetModuleConfig.a().O(context, str);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            AssetModuleConfig.a().h1(context, str, str2);
        }
    }

    public final void t(Context context, String str, String str2, TradeType tradeType, String str3, boolean z11, String str4, boolean z12, String str5, String str6, int i11) {
        if (tradeType == TradeType.CONTRACT) {
            ContractAccountInfo contractAccountInfo = new ContractAccountInfo();
            contractAccountInfo.setSymbol(str);
            contractAccountInfo.setNewAssetData(true);
            AssetModuleConfig.a().s(context, contractAccountInfo);
        } else if (tradeType == TradeType.SWAP) {
            SwapAccountInfo swapAccountInfo = new SwapAccountInfo();
            swapAccountInfo.setSymbol(str);
            swapAccountInfo.setContractCode(str2);
            AssetModuleConfig.a().Q(context, swapAccountInfo);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            LinearSwapAccountInfo linearSwapAccountInfo = new LinearSwapAccountInfo();
            linearSwapAccountInfo.setSymbol(str);
            linearSwapAccountInfo.setCross(z11);
            if (TextUtils.isEmpty(str3)) {
                linearSwapAccountInfo.setContractCode(str2);
            } else {
                linearSwapAccountInfo.setContractCode(str3);
            }
            linearSwapAccountInfo.setInWhiteList(z12);
            linearSwapAccountInfo.setAvailable(str5);
            linearSwapAccountInfo.setEquity(str6);
            linearSwapAccountInfo.setAssetType(i11);
            AssetModuleConfig.a().G(context, linearSwapAccountInfo);
        }
    }

    public final void u(Context context, String str, String str2, TradeType tradeType) {
        if (tradeType == TradeType.CONTRACT) {
            AssetModuleConfig.a().u0(context, str, str2);
        } else if (tradeType == TradeType.SWAP) {
            AssetModuleConfig.a().v(context, str, str2);
        } else if (tradeType != TradeType.LINEAR_SWAP) {
        } else {
            if ("usdt".equalsIgnoreCase(str)) {
                HuobiToastUtil.j(R$string.n_not_support);
            } else {
                AssetModuleConfig.a().V0(context, str, str2);
            }
        }
    }

    public final void v(Context context, AssetPositionWarrantData assetPositionWarrantData) {
        double doubleValue = Double.valueOf((assetPositionWarrantData.g() == null || TextUtils.isEmpty(assetPositionWarrantData.g().getProfitRate())) ? "0" : assetPositionWarrantData.g().getProfitRate()).doubleValue();
        View loadView = AssetShareHelper.loadView(context, String.valueOf(doubleValue), new g(doubleValue));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        ((TextView) loadView.findViewById(R$id.tv_title)).setTextColor(context.getResources().getColor(R$color.white));
        ((TextView) loadView.findViewById(R$id.tv_hield_currency)).setText(context.getString(R$string.n_asset_cumulative_yield));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        viewGroup.setVisibility(0);
        LayoutInflater.from(context).inflate(R$layout.layout_asset_position_contract, viewGroup, true);
        ((TextView) viewGroup.findViewById(R$id.tv_symbol)).setText(assetPositionWarrantData.i().toUpperCase());
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        g6.b.c().i(imageView, p.l(assetPositionWarrantData.i()), p.m());
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        ((TextView) viewGroup.findViewById(R$id.tv_price_title)).setText(context.getString(R$string.contarct_share_position_cur_price) + "(" + upperCase.toUpperCase() + ")");
        new DecimalFormat("0.00").setRoundingMode(RoundingMode.FLOOR);
        ((TextView) viewGroup.findViewById(R$id.tv_price)).setText(LegalCurrencyConfigUtil.F(assetPositionWarrantData.g().getCurrency(), upperCase, "1"));
        AssetShareHelper.share(context, loadView);
    }

    public final void w(Context context, AssetPositionCoinData assetPositionCoinData, String str) {
        View loadNewView = AssetShareHelper.loadNewView(context, assetPositionCoinData.v(), new e(assetPositionCoinData), 2);
        loadNewView.findViewById(R$id.ll_symbol).setVisibility(0);
        TextView textView = (TextView) loadNewView.findViewById(R$id.tv_symbol);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(assetPositionCoinData.z().toUpperCase() + "  " + str);
        } else {
            textView.setText(assetPositionCoinData.z().toUpperCase());
        }
        textView.setVisibility(0);
        ImageView imageView = (ImageView) loadNewView.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        g6.b.c().i(imageView, p.l(assetPositionCoinData.z()), p.m());
        ((TextView) loadNewView.findViewById(R$id.tv_tips)).setText(context.getString(R$string.contarct_share_position_cur_price));
        TextView textView2 = (TextView) loadNewView.findViewById(R$id.tv_now_price);
        String j11 = p.j(LegalCurrencyConfigUtil.H(assetPositionCoinData.z()).toPlainString(), "usdt");
        if (TextUtils.isEmpty(j11)) {
            j11 = "";
        }
        textView2.setText(j11);
        textView2.setVisibility(0);
        AssetShareHelper.share(context, loadNewView);
    }

    @SuppressLint({"SetTextI18n"})
    public final void x(Context context, String str, String str2, String str3) {
        View inflate = View.inflate(context, R$layout.layout_new_share, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R$id.img_share)).setImageResource(R$drawable.share_asset_style_1);
        ((TextView) inflate.findViewById(R$id.tv_time)).setText(DateTimeUtils.i(System.currentTimeMillis(), "MM/dd/yyyy HH:mm", (Locale) null));
        inflate.findViewById(R$id.ll_symbol).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_symbol);
        textView.setVisibility(0);
        textView.setText(str.toUpperCase() + "  " + str2);
        ((TextView) inflate.findViewById(R$id.tv_today_tips)).setText(context.getString(R$string.n_mining_year_profit));
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_yield);
        textView2.setTextColor(context.getColor(w.h()));
        textView2.setText(str3);
        inflate.findViewById(R$id.tv_tips).setVisibility(8);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        g6.b.c().k(imageView, p.l(str), p.m(), new d(context, inflate));
    }

    public final void y(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("icon", str);
        BaseModuleConfig.a().w("app_assets_spot_tokens_component_click", hashMap);
    }

    public final void z(Context context, AssetPositionQuantData assetPositionQuantData) {
        View loadNewView = AssetShareHelper.loadNewView(context, assetPositionQuantData.t(), new b(assetPositionQuantData), 1);
        loadNewView.findViewById(R$id.ll_symbol).setVisibility(0);
        TextView textView = (TextView) loadNewView.findViewById(R$id.tv_symbol);
        if (!TextUtils.isEmpty(assetPositionQuantData.s())) {
            textView.setVisibility(0);
            textView.setText(assetPositionQuantData.s().toUpperCase() + " " + context.getString(R$string.n_grid_grid_strategy));
        }
        ((TextView) loadNewView.findViewById(R$id.tv_today_tips)).setText(context.getString(R$string.n_asset_cumulative_yield));
        loadNewView.findViewById(R$id.tv_tips).setVisibility(8);
        AssetShareHelper.share(context, loadNewView);
    }
}
