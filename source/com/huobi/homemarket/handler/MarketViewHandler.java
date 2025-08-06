package com.huobi.homemarket.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ClickHelper;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.view.MarketPriceView;
import com.huobi.trade.helper.f0;
import com.huobi.view.FontIconTextView;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import i6.d;
import i6.m;
import i6.r;
import java.util.HashMap;
import ql.o;
import ql.p;
import ql.q;
import v9.c;

public class MarketViewHandler extends AbsMarketViewHandler<MarketSymbolPriceItem> {

    /* renamed from: h  reason: collision with root package name */
    public Drawable f72718h;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h0(c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11, View view) {
        B(cVar, marketSymbolPriceItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean i0(MarketSymbolPriceItem marketSymbolPriceItem, View view, View view2) {
        if (!ClickHelper.b()) {
            return false;
        }
        if (marketSymbolPriceItem.c() == null) {
            return true;
        }
        marketSymbolPriceItem.c().a(view, marketSymbolPriceItem);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j0(c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11, View view) {
        d.i("flEntry click");
        M(cVar, marketSymbolPriceItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean X(MarketSymbolPriceItem marketSymbolPriceItem) {
        return SymbolBean.PRE_ONLINE.equals(marketSymbolPriceItem.i());
    }

    /* renamed from: Y */
    public void m(c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11, boolean z11) {
        Context context = cVar.itemView.getContext();
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
            return;
        }
        if (a1.v().S(marketSymbolPriceItem.j())) {
            MarketModuleConfig.a().X(context, marketSymbolPriceItem.j(), true);
        } else {
            MarketModuleConfig.a().e(context, marketSymbolPriceItem.j(), MarketModuleConfig.a().w(), marketSymbolPriceItem.m());
        }
        if (z11) {
            g0(marketSymbolPriceItem);
        }
    }

    /* renamed from: Z */
    public String p(MarketSymbolPriceItem marketSymbolPriceItem) {
        return marketSymbolPriceItem.getBaseCurrencyDisplayName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + marketSymbolPriceItem.h();
    }

    /* renamed from: a0 */
    public boolean t(MarketSymbolPriceItem marketSymbolPriceItem) {
        return LinearSwapCurrencyInfoController.l().m(p(marketSymbolPriceItem)) != null;
    }

    /* renamed from: b0 */
    public String w(MarketSymbolPriceItem marketSymbolPriceItem) {
        return marketSymbolPriceItem.j();
    }

    /* renamed from: c0 */
    public TradeType x(MarketSymbolPriceItem marketSymbolPriceItem) {
        return marketSymbolPriceItem.m();
    }

    public void d0(MarketSymbolPriceItem marketSymbolPriceItem, r rVar) {
        ViewUtil.m((FontIconTextView) rVar.b(R$id.font_icon_text_view_market_item_collection_sign), MarketModuleConfig.a().k(marketSymbolPriceItem.j()));
    }

    /* renamed from: e0 */
    public void y(c cVar, int i11, MarketSymbolPriceItem marketSymbolPriceItem, ViewGroup viewGroup) {
        super.handleView(cVar, i11, marketSymbolPriceItem, viewGroup);
        View view = cVar.itemView;
        this.f72718h = ContextCompat.getDrawable(view.getContext(), R$drawable.market_updown_global_default_text_bg);
        view.setOnClickListener(new p(this, cVar, marketSymbolPriceItem, i11));
        view.setOnLongClickListener(new q(marketSymbolPriceItem, view));
        k0(cVar, marketSymbolPriceItem, i11);
    }

    /* renamed from: f0 */
    public boolean A(MarketSymbolPriceItem marketSymbolPriceItem) {
        return MarketModuleConfig.a().d0(marketSymbolPriceItem.j(), marketSymbolPriceItem.k() != null ? marketSymbolPriceItem.k().getSymbolPartition() : null, marketSymbolPriceItem.i());
    }

    public void g0(MarketSymbolPriceItem marketSymbolPriceItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", marketSymbolPriceItem.j());
        BaseModuleConfig.a().d("4744", hashMap, "1000047");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("TransPair_current_click_id", marketSymbolPriceItem.j());
        BaseModuleConfig.a().w("App_markets_list_coin_click", hashMap2);
        MarketModuleConfig.a().m("MARKET_QUOTATIONS_SYMBOL");
        MarketModuleConfig.a().t("spot_symbol_click", marketSymbolPriceItem.j());
    }

    public int getResId() {
        return R$layout.item_market_view;
    }

    public void k0(c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11) {
        Double d11;
        String str;
        double d12;
        String str2;
        boolean z11;
        c cVar2 = cVar;
        MarketSymbolPriceItem marketSymbolPriceItem2 = marketSymbolPriceItem;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        TextView e12 = e11.e(R$id.item_chart_basecurrency);
        TextView e13 = e11.e(R$id.item_chart_quotecurrency);
        ImageView c11 = e11.c(R$id.prime_tip);
        TextView e14 = e11.e(R$id.item_chart_amount);
        TextView e15 = e11.e(R$id.item_chart_percent);
        View b11 = e11.b(R$id.id_market_item_view_0fee_tag);
        TextView e16 = e11.e(R$id.id_market_item_view_etp_tag_tv);
        TextView e17 = e11.e(R$id.id_market_item_leverage_tv);
        MarketPriceView marketPriceView = (MarketPriceView) e11.b(R$id.marketContractPriceView);
        d0(marketSymbolPriceItem2, e11);
        SymbolBean k11 = marketSymbolPriceItem.k();
        TextView textView = e16;
        View view = b11;
        f6.c.a().f(e11.c(R$id.iv_item_basecurrency), AbsMarketViewHandler.q(marketSymbolPriceItem.getBaseCurrency()), AbsMarketViewHandler.r());
        View findViewById = cVar2.itemView.findViewById(R$id.fl_quick_trade_entry);
        if (!this.f72704b && A(marketSymbolPriceItem2)) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new o(this, cVar2, marketSymbolPriceItem2, i11));
        } else {
            findViewById.setVisibility(4);
        }
        if (a1.v().f(marketSymbolPriceItem.j())) {
            if (a1.v().R(marketSymbolPriceItem.j())) {
                c11.setImageResource(R$drawable.tips_lite);
            } else {
                c11.setImageResource(R$drawable.mark_tips);
            }
            c11.setVisibility(0);
            ViewUtil.m(e17, false);
        } else if (marketSymbolPriceItem.s()) {
            c11.setImageResource(R$drawable.market_st);
            if (marketSymbolPriceItem.r()) {
                c11.setVisibility(0);
            } else {
                c11.setVisibility(8);
            }
            ViewUtil.m(e17, false);
        } else {
            if (!gj.d.n().G() || k11 == null || TextUtils.isEmpty(k11.getLeverageRatio())) {
                ViewUtil.m(e17, false);
            } else {
                e17.setText(k11.getLeverageRatio() + "X");
                ViewUtil.m(e17, true);
            }
            c11.setVisibility(8);
        }
        Double d13 = null;
        if (marketSymbolPriceItem.getSymbolPrice() != null) {
            d13 = marketSymbolPriceItem.getSymbolPrice().getClose();
            d11 = marketSymbolPriceItem.getSymbolPrice().getOpen();
        } else {
            d11 = null;
        }
        marketPriceView.setPriceStringCny(marketSymbolPriceItem.e());
        if (e12.getText() == null || !e12.getText().equals(marketSymbolPriceItem.getBaseCurrencyDisplayName())) {
            e12.setText(marketSymbolPriceItem.getBaseCurrencyDisplayName());
        }
        String str3 = "/" + marketSymbolPriceItem.h();
        if (e13.getText() == null || !e13.getText().equals(str3)) {
            e13.setText(str3);
        }
        marketPriceView.setPriceString(m.c(marketSymbolPriceItem.d(), marketSymbolPriceItem.d()));
        if (TextUtils.isEmpty(marketSymbolPriceItem.f())) {
            str = "--";
        } else if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            str = m.g(marketSymbolPriceItem.f());
        } else {
            str = m.X(marketSymbolPriceItem.f());
        }
        e14.setText(LegalCurrencyConfigUtil.w() + str);
        double doubleValue = (d13 == null || d11 == null) ? 0.0d : d13.doubleValue() - d11.doubleValue();
        String str4 = "--";
        if (d13 == null || Double.compare(d13.doubleValue(), 0.0d) == 0) {
            d12 = doubleValue;
            str2 = str4;
        } else {
            StringBuilder sb2 = new StringBuilder();
            d12 = doubleValue;
            sb2.append(Double.compare(d12, 0.0d) > 0 ? "+" : "");
            sb2.append(m.i(100.0d * (d12 / d11.doubleValue()), PrecisionUtil.v(marketSymbolPriceItem.j())));
            sb2.append("%");
            str2 = sb2.toString();
        }
        if (SymbolBean.SUSPEND.equals(marketSymbolPriceItem.i()) || SymbolBean.TRANSFER_BOARD.equals(marketSymbolPriceItem.i()) || SymbolBean.FUSE.equals(marketSymbolPriceItem.i())) {
            int i12 = R$color.baseColorThreeLevelText;
            e12.setTextColor(ContextCompat.getColor(context, i12));
            e14.setTextColor(ContextCompat.getColor(context, i12));
            marketPriceView.setPaintColor(true);
            e15.setBackground(this.f72718h);
            if (SymbolBean.SUSPEND.equals(marketSymbolPriceItem.i())) {
                if (BaseModuleConfig.a().U(marketSymbolPriceItem.j())) {
                    e15.setText("0.00%");
                    e15.setBackground(new BgColorDrawable(context.getResources().getColor(w.k("0.00%")), AbsMarketViewHandler.f72703g));
                } else {
                    e15.setText(R$string.trade_suspend);
                }
            } else if (SymbolBean.TRANSFER_BOARD.equals(marketSymbolPriceItem.i())) {
                e15.setText(R$string.trade_transfer_board);
            } else {
                e15.setText(R$string.trade_fuse);
            }
        } else if (X(marketSymbolPriceItem2)) {
            int i13 = R$color.global_default_text_color;
            e12.setTextColor(ContextCompat.getColor(context, i13));
            e14.setTextColor(ContextCompat.getColor(context, i13));
            e15.setBackground(this.f72718h);
            e15.setText(R$string.trade_pre_online);
        } else {
            e12.setTextColor(ContextCompat.getColor(context, R$color.global_main_text_color));
            marketPriceView.setPaintColor(false);
            e14.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryTextNew));
            e15.setBackground(new BgColorDrawable(context.getResources().getColor(w.k(str2)), AbsMarketViewHandler.f72703g));
            if (e15.getText() == null || !e15.getText().equals(str2)) {
                e15.setText(str2);
                this.f72706d.put(o(marketSymbolPriceItem2), Double.valueOf(d12));
            }
        }
        float f11 = 14.0f;
        if (k11 == null || !k11.isZerofeeTag()) {
            z11 = true;
            ViewUtil.m(view, false);
            e12.setTextSize(1, 14.0f);
        } else {
            ViewUtil.m(view, true);
            if (marketSymbolPriceItem.getBaseCurrencyDisplayName() != null && marketSymbolPriceItem.getBaseCurrencyDisplayName().length() > 7) {
                f11 = 12.0f;
            }
            z11 = true;
            e12.setTextSize(1, f11);
        }
        if (k11 == null) {
            ViewUtil.m(textView, false);
        } else if (k11.isEtpTag()) {
            String d14 = f0.d(context, k11.getDirection(), k11.getEtpLeverageRatio());
            if (!TextUtils.isEmpty(d14)) {
                TextView textView2 = textView;
                ViewUtil.m(textView2, z11);
                textView2.setText(d14);
                textView2.setTextColor(f0.g(context, k11.isEtpTag(), k11.getDirection()));
                textView2.setBackgroundResource(f0.e(k11.isEtpTag(), k11.getDirection()));
                return;
            }
            ViewUtil.m(textView, false);
        } else {
            ViewUtil.m(textView, false);
        }
    }

    public ViewGroup.LayoutParams s(int i11) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, i11);
        layoutParams.f7964s = -1;
        layoutParams.f7944i = R$id.ll_main;
        return layoutParams;
    }
}
